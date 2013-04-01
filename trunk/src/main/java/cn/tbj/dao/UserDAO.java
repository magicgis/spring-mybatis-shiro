/**    
* @Title: UserDAO.java  
* @Description: TODO 
* @author Strong 
* @date 2013-3-11 下午4:39:46  
* @version V1.0    
*/
package cn.tbj.dao;

import java.util.List;

import cn.tbj.entity.main.SecurityRolePO;
import cn.tbj.entity.main.SecurityRolePermission;
import cn.tbj.entity.main.SecurityUserPO;
import cn.tbj.entity.main.SecurityUserRolePO;

/** 
* @ClassName: UserDAO 
* @Description: TODO
* @author Strong
* @date 2013-3-22 上午11:32:08 
* Copyright (c) 2012 T.b.j,Inc. All Rights Reserved. 
*/ 
public interface UserDAO {

	// ---------- 用户接口 ------------ //

	/**
	 *Description: 查询所有用户列表
	 *CreateDate:2013-3-22
	 *@author Strong
	 *@param  
	 *@return PageList<SecurityUserPO>
	 **/
	List<SecurityUserPO> getAllUser();
	
	
	/**
	 *Description: 通过id查询用户
	 *CreateDate:2013-3-22
	 *@author Strong
	 *@param  
	 *@return SecurityUserPO
	 **/
	SecurityUserPO getUserById(Long id);
	
	
	/**
	 *Description: 通过登录名 查询用户
	 *CreateDate:2013-3-22
	 *@author Strong
	 *@param  
	 *@return SecurityUserPO
	 **/
	SecurityUserPO getUserByLoginName(String loginName);
	
	
	
	/**
	 *Description: 新增用户
	 *CreateDate:2013-3-22
	 *@author Strong
	 *@param  
	 *@return void
	 **/
	void insertSecurityUser(SecurityUserPO securityUser);
	
	/**
	 *Description: 更新用户
	 *CreateDate:2013-3-22
	 *@author Strong
	 *@param  
	 *@return void
	 **/
	void upadteSecurityUser(SecurityUserPO securityUser);
	
	/**
	 *Description: 删除用户
	 *CreateDate:2013-3-22
	 *@author Strong
	 *@param  
	 *@return void
	 **/
	void deleteSecurityUser(Long id);
	
	
	// ---------- 角色接口 ------------ //
	
	/**
	 *Description: 查询角色
	 *CreateDate:2013-3-25
	 *@author Strong
	 *@param  
	 *@return SecurityRolePO
	 **/
	SecurityRolePO getSecurityRolePOById(Long id);
	
	
	/**
	 *Description: 新增角色
	 *CreateDate:2013-3-22
	 *@author Strong
	 *@param  
	 *@return void
	 **/
	void insertSecurityRole(SecurityRolePO rolePO);
	
	/**
	 *Description: 更新角色
	 *CreateDate:2013-3-22
	 *@author Strong
	 *@param  
	 *@return void
	 **/
	void updateSecurityRole(SecurityRolePO rolePO);
	
	/**
	 *Description: 删除角色
	 *CreateDate:2013-3-22
	 *@author Strong
	 *@param  
	 *@return void
	 **/
	void deleteSecurityRole(Long id);
	
	// ---------- 用户角色接口 ------------ //
	
	
	/**
	 *Description: 获得用户角色
	 *CreateDate:2013-3-25
	 *@author Strong
	 *@param  
	 *@return List<SecurityUserRolePO>
	 **/
	List<SecurityUserRolePO> getSecurityUserRolePO(Long userId);
	
	/**
	 *Description: 新增用户角色
	 *CreateDate:2013-3-22
	 *@author Strong
	 *@param  
	 *@return void
	 **/
	void insertSecurityUserRole(SecurityUserRolePO securityUserRolePO);
	
	/**
	 *Description: 更新用户角色
	 *CreateDate:2013-3-22
	 *@author Strong
	 *@param  
	 *@return void
	 **/
	void updateSecurityUserRole(SecurityUserRolePO securityUserRolePO);
	
	/**
	 *Description: 删除用户角色
	 *CreateDate:2013-3-22
	 *@author Strong
	 *@param  
	 *@return void
	 **/
	void deleteSecurityUserRole(Long userId);
	
	
	
	// ---------- 用户角色接口 ------------ //
	/**
	 *Description: 查询角色权限
	 *CreateDate:2013-3-26
	 *@author Strong
	 *@param  
	 *@return SecurityRolePermission
	 **/
	List<SecurityRolePermission> getSecurityRolePermissionByRoleId(Long roleId);
	
}
