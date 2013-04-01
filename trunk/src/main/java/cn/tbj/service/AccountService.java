/**
 * 
 */
package cn.tbj.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.tbj.dao.UserDAO;
import cn.tbj.entity.main.SecurityRolePO;
import cn.tbj.entity.main.SecurityRolePermission;
import cn.tbj.entity.main.SecurityUserPO;
import cn.tbj.entity.main.SecurityUserRolePO;
import cn.tbj.security.utils.Digests;
import cn.tbj.security.utils.RoleUtils;
import cn.tbj.utils.Encodes;
import cn.tbj.utils.ServiceException;

/** 
* @ClassName: AccountService 
* @Description: 角色服务类
* @author Strong
* @date 2013-3-21 下午5:37:34 
* Copyright (c) 2012 T.b.j,Inc. All Rights Reserved. 
*/ 
@Component
@Transactional( readOnly = true)
public class AccountService {
	
	public static final String HASH_ALGORITHM = "SHA-1";
	public static final int HASH_INTERATIONS = 1024;
	private static final int SALT_SIZE = 8;

	private static Logger logger = LoggerFactory.getLogger(AccountService.class);
	
	
	@Resource(name = "userDAO")
	private UserDAO userDAO;
	
	
	
	public List<SecurityUserPO> queryAllSecurityUserPO(){
		return this.userDAO.getAllUser();
	}

	public SecurityUserPO queryById(Long id){
		return this.userDAO.getUserById(id);
	}
	
	public SecurityUserPO queryByLoginName(String username){
		return this.userDAO.getUserByLoginName(username);
	}
	
	public SecurityRolePO queryByRoleId(Long roleId){
		return this.userDAO.getSecurityRolePOById(roleId);
	}
	
	public List<SecurityUserRolePO> queryByUserId(Long userId){
		return this.userDAO.getSecurityUserRolePO(userId);
	}
	
	public List<SecurityRolePermission> queryPermissionByRoleId(Long roleId){
		return this.userDAO.getSecurityRolePermissionByRoleId(roleId);
	}
	
	public void addSecurityRolePO(SecurityRolePO securityRolePO){
		this.userDAO.insertSecurityRole(securityRolePO);
	}
	
	/**
	 *Description: 注册用户 以及 用户角色
	 *CreateDate:2013-3-25
	 *@author Strong
	 *@param  
	 *@return void
	 **/
	@Transactional(readOnly = false,propagation=Propagation.REQUIRED)
	public void registerUser(SecurityUserPO securityUserPO, SecurityRolePO securityRolePO){
		
		if( securityUserPO != null){
			entryptPassword(securityUserPO);
			securityUserPO.setCreateTime(new Date());
			securityUserPO.setStatus(RoleUtils.getRoleUserStatusEnabled());
			// 注册用户
			this.userDAO.insertSecurityUser(securityUserPO);
			
			securityUserPO = this.queryByLoginName(securityUserPO.getUsername());
			// 注册用户权限,默认级别为 普通用户
			SecurityUserRolePO securityUserRolePO = new SecurityUserRolePO();
			securityUserRolePO.setUserId(securityUserPO.getId());
			securityUserRolePO.setCreateTime(new Date());
			if( securityRolePO != null){
				securityUserRolePO.setRoleId(securityRolePO.getId());
			}else{
				securityUserRolePO.setRoleId(RoleUtils.getRoleUserNormalId());
			}
			this.userDAO.insertSecurityUserRole(securityUserRolePO);
		}
		
		if (logger.isInfoEnabled()) {
			logger.debug("InsertUser:{},InsertUserRole", new Object[] { securityUserPO, securityRolePO});
		}
		
	}
	
	
	/**
	 *Description: 更新用户信息 (用户角色)
	 *CreateDate:2013-3-25
	 *@author Strong
	 *@param  
	 *@return void
	 **/
	@Transactional(readOnly = false)
	public void updateUser(SecurityUserPO securityUserPO , SecurityUserRolePO securityUserRolePO) {
		
		if(securityUserPO != null){
			if (securityUserRolePO != null ) {//更新用户角色 
				this.userDAO.updateSecurityUserRole(securityUserRolePO);
			}
			
			
			//只更新用户信息
			if (StringUtils.isNotBlank(securityUserPO.getPlainPassword())) {
				entryptPassword(securityUserPO);
				this.userDAO.upadteSecurityUser(securityUserPO);
			}
		}else{
			throw new IllegalArgumentException("用户信息不能为空");
		}
		
	}
	
	
	/**
	 *Description: 删除用户信息
	 *CreateDate:2013-3-25
	 *@author Strong
	 *@param  
	 *@return void
	 **/
	@Transactional(readOnly = false)
	public void deleteUser(Long id) {
		if (isSupervisor(id)) {
			logger.warn("操作员{}尝试删除超级管理员用户", getCurrentUserName());
			throw new ServiceException("不能删除超级管理员用户");
		}
		// 删除用户信息
		this.userDAO.deleteSecurityUser(id);
		
		// 删除用户角色
		this.userDAO.deleteSecurityUserRole(id);
		

	}
	

	/**
	 *Description: 判断是否超级管理员.
	 *CreateDate:2013-3-25
	 *@author Strong
	 *@param  
	 *@return boolean
	 **/
	private boolean isSupervisor(Long id) {
		return id == 1;
	}
	

	/**
	 *Description: 取出Shiro中的当前用户LoginName.
	 *CreateDate:2013-3-25
	 *@author Strong
	 *@param  
	 *@return String
	 **/
	private String getCurrentUserName() {
		SecurityUserPO securityUserPO = (SecurityUserPO) SecurityUtils.getSubject().getPrincipal();
		return securityUserPO.getUsername();
	}
	
	
	/**
	 * 设定安全的密码，生成随机的salt并经过1024次 sha-1 hash
	 */
	private void entryptPassword(SecurityUserPO user) {
		byte[] salt = Digests.generateSalt(SALT_SIZE);
		user.setSalt(Encodes.encodeHex(salt));

		byte[] hashPassword = Digests.sha1(user.getPlainPassword().getBytes(), salt, HASH_INTERATIONS);
		user.setPassword(Encodes.encodeHex(hashPassword));
	}
}
