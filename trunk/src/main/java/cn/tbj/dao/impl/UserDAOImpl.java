/**    
* @Title: UserDAOImpl.java  
* @Description: TODO 
* @author Strong 
* @date 2013-3-11 下午5:03:47  
* @version V1.0    
*/
package cn.tbj.dao.impl;

import java.util.Collections;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import cn.linkea.common.util.PageList;
import cn.tbj.dao.UserDAO;
import cn.tbj.entity.main.SecurityRolePO;
import cn.tbj.entity.main.SecurityRolePermission;
import cn.tbj.entity.main.SecurityUserPO;
import cn.tbj.entity.main.SecurityUserRolePO;



/** 
* @ClassName: UserDAOImpl 
* @Description: 用户DAO 实现
* @author Strong
* @date 2013-3-22 下午1:29:01 
* Copyright (c) 2012 T.b.j,Inc. All Rights Reserved. 
*/ 
public class UserDAOImpl extends SqlSessionDaoSupport implements UserDAO {

	/* (non-Javadoc)
	 * @see cn.tbj.dao.UserDAO#getAllUser()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<SecurityUserPO> getAllUser() {
		
		PageList<SecurityUserPO> list = new PageList<SecurityUserPO>();
		list.addAll(this.getSqlSession().selectList("SecurityUserPO.SELECT_ALL_USER"));
		return  (List<SecurityUserPO>) (list.size() > 0 ? list : Collections.emptyList());
	}

	/* (non-Javadoc)
	 * @see cn.tbj.dao.UserDAO#getUserById(java.lang.Long)
	 */
	@Override
	public SecurityUserPO getUserById(Long id) {
		if( id != null){
			return (SecurityUserPO) this.getSqlSession().selectOne("SecurityUserPO.SELECT_BY_ID", id);
		}else{
			throw new IllegalArgumentException("id 不能为空");
		}
	}

	/* (non-Javadoc)
	 * @see cn.tbj.dao.UserDAO#getUserByLoginName(java.lang.String)
	 */
	@Override
	public SecurityUserPO getUserByLoginName(String loginName) {
		
		if( loginName != null){
			return (SecurityUserPO) this.getSqlSession().selectOne("SecurityUserPO.SELECT_BY_LOGINNAME", loginName);
		}else{
			throw new IllegalArgumentException("loginName 不能为空");
		}
	}

	/* (non-Javadoc)
	 * @see cn.tbj.dao.UserDAO#insertSecurityUser(cn.tbj.entity.main.SecurityUserPO)
	 */
	@Override
	public void insertSecurityUser(SecurityUserPO securityUser) {
		
		if( securityUser != null ){
			this.getSqlSession().insert("SecurityUserPO.INSERT_SECURITYUSERPO", securityUser);
		}else{
			throw new IllegalArgumentException("securityUser 不能为空");
		}
	}

	/* (non-Javadoc)
	 * @see cn.tbj.dao.UserDAO#upadteSecurityUser(cn.tbj.entity.main.SecurityUserPO)
	 */
	@Override
	public void upadteSecurityUser(SecurityUserPO securityUser) {
		
		if( securityUser != null ){
			this.getSqlSession().update("SecurityUserPO.UPDATE_BY_ID", securityUser);
		}else{
			throw new IllegalArgumentException("securityUser 不能为空");
		}
	}

	/* (non-Javadoc)
	 * @see cn.tbj.dao.UserDAO#deleteSecurityUser(java.lang.Long)
	 */
	@Override
	public void deleteSecurityUser(Long id) {

		if( id != null){
			this.getSqlSession().selectOne("SecurityUserPO.DELETE_BY_ID", id);
		}else{
			throw new IllegalArgumentException("id 不能为空");
		}
		
	}

	
	
	
	
	
	
	@Override
	public SecurityRolePO getSecurityRolePOById(Long roleId){
		if( roleId != null ){
			return (SecurityRolePO) this.getSqlSession().selectOne("SecurityUserPO.SELECT_ROLE_BY_ID", roleId);
		}else{
			throw new IllegalArgumentException("roleId 不能为空");
		}
	}
	
	
	@Override
	public void insertSecurityRole(SecurityRolePO rolePO) {
		if( rolePO != null ){
			this.getSqlSession().insert("SecurityUserPO.INSERT_ROLE", rolePO);
		}else{
			throw new IllegalArgumentException("rolePO 不能为空");
		}
	}

	@Override
	public void updateSecurityRole(SecurityRolePO rolePO) {
		if( rolePO != null ){
			this.getSqlSession().update("SecurityUserPO.UPDATE_ROLE", rolePO);
		}else{
			throw new IllegalArgumentException("rolePO 不能为空");
		}
	}

	@Override
	public void deleteSecurityRole(Long id) {
		if( id != null ){
			this.getSqlSession().delete("SecurityUserPO.DELETE_ROLE", id);
		}else{
			throw new IllegalArgumentException("rolePO 不能为空");
		}
	}
	
	
	
	
	
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<SecurityUserRolePO> getSecurityUserRolePO(Long userId){
		if( userId != null ){
			return this.getSqlSession().selectList("SecurityUserPO.SELECTS_USERROLE_BY_USERID", userId);
		}else{
			throw new IllegalArgumentException("userId 不能为空");
		}
	}
	

	@Override
	public void insertSecurityUserRole(SecurityUserRolePO securityUserRolePO) {
		if( securityUserRolePO != null ){
			this.getSqlSession().insert("SecurityUserPO.INSERT_USERROLE", securityUserRolePO);
		}else{
			throw new IllegalArgumentException("securityUserRolePO 不能为空");
		}
	}

	@Override
	public void updateSecurityUserRole(SecurityUserRolePO securityUserRolePO) {
		if( securityUserRolePO != null ){
			this.getSqlSession().update("SecurityUserPO.UPDATE_USERROLE", securityUserRolePO);
		}else{
			throw new IllegalArgumentException("securityUserRolePO 不能为空");
		}
	}

	@Override
	public void deleteSecurityUserRole(Long userId) {
		if( userId != null ){
			this.getSqlSession().delete("SecurityUserPO.DELETE_USERROLE", userId);
		}else{
			throw new IllegalArgumentException("userId 不能为空");
		}
	}

	
	
	
	/* (non-Javadoc)
	 * @see cn.tbj.dao.UserDAO#getSecurityRolePermissionByRoleId(java.lang.Long)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<SecurityRolePermission> getSecurityRolePermissionByRoleId(
			Long roleId) {


		if( roleId != null ){
			return this.getSqlSession().selectList("SecurityUserPO.SELECTS_PERMISSION_BY_ROLEID", roleId);
		}else{
			throw new IllegalArgumentException("roleId 不能为空");
		}
	}


	
	
	
	
}
