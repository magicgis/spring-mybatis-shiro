/**   
 * @author Strong
 * @date 2013-3-26 上午10:03:05
 * Copyright (c) 2012 T.b.j,Inc. All Rights Reserved. 
 * @version V1.2.2   
 */

package cn.tbj.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import cn.tbj.entity.main.SecurityRolePO;
import cn.tbj.entity.main.SecurityRolePermission;
import cn.tbj.entity.main.SecurityUserPO;
import cn.tbj.entity.main.SecurityUserRolePO;
import cn.tbj.utils.Encodes;

import com.google.common.base.Objects;

/**
 * @ClassName: ShiroServiceRealm
 * @Description: TODO
 * @author Strong
 * @date 2013-3-26 上午10:03:05 Copyright (c) 2012 T.b.j,Inc. All Rights Reserved.
 */
public class ShiroServiceRealm extends AuthorizingRealm {

	protected AccountService accountService;

	public AccountService getAccountService() {
		return accountService;
	}

	@Autowired
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	
	/**
	 * 认证回调函数,登录时调用
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(org
	 * .apache.shiro.authc.AuthenticationToken)
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authcToken) throws AuthenticationException {

		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;

		SecurityUserPO securityUserPO = accountService.queryByLoginName(token
				.getUsername());
		if (securityUserPO != null) {
			if (securityUserPO.getStatus().equals("disabled")) {
				throw new DisabledAccountException();
			}
			
			byte[] salt = Encodes.decodeHex(securityUserPO.getSalt());

			return new SimpleAuthenticationInfo(new ShiroUser(securityUserPO.getId(), securityUserPO.getUsername(),securityUserPO),
					securityUserPO.getPassword(),
					ByteSource.Util.bytes(salt), getName());
			
			
		}else{
			return null;
		}

	}
	
	
	
	
	/**
	 * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用.
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.shiro.realm.AuthorizingRealm#doGetAuthorizationInfo(org.apache
	 * .shiro.subject.PrincipalCollection)
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {

		ShiroUser shiroUser = (ShiroUser) principals.getPrimaryPrincipal();
		SecurityUserPO securityUserPO = this.accountService.queryByLoginName(shiroUser.loginName);
		List<SecurityUserRolePO> userRolePOs = this.accountService.queryByUserId(securityUserPO.getId());
		
		
		if (!userRolePOs.isEmpty()) {
			
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
			for (SecurityUserRolePO securityUserRolePO : userRolePOs) {
				//基于Permission的权限信息
				
				List<SecurityRolePermission> list = this.accountService.queryPermissionByRoleId(securityUserRolePO.getRoleId());
				List<String> permissions = new ArrayList<String>();
				
				for( SecurityRolePermission securityRolePermission : list){
					permissions.add(securityRolePermission.getPermission());
				}
				
				for( SecurityRolePermission securityRolePermission : list){
					permissions.add(securityRolePermission.getPermission());
				}
				info.addStringPermissions(permissions);
				
				
				//角色信息
				SecurityRolePO rolePO = this.accountService.queryByRoleId(securityUserRolePO.getRoleId());
				info.addRole(rolePO.getRoleCode());
			}
			return info;
		} else {
			return null;
		}
	}

	
	
	

	/**
	 *Description: 更新用户授权信息缓存.
	 *CreateDate:2013-3-26
	 *@author Strong
	 *@param  
	 *@return void
	 **/
	public void clearCachedAuthorizationInfo(String principal) {
		SimplePrincipalCollection principals = new SimplePrincipalCollection(principal, getName());
		clearCachedAuthorizationInfo(principals);
	}

	
	
	/**
	 *Description: 清除所有用户授权信息缓存.
	 *CreateDate:2013-3-26
	 *@author Strong
	 *@param  
	 *@return void
	 **/
	public void clearAllCachedAuthorizationInfo() {
		Cache<Object, AuthorizationInfo> cache = getAuthorizationCache();
		if (cache != null) {
			for (Object key : cache.keys()) {
				cache.remove(key);
			}
		}
	}
	
	/**
	 * 设定Password校验的Hash算法与迭代次数.
	 */
	@PostConstruct
	public void initCredentialsMatcher() {
		HashedCredentialsMatcher matcher = new HashedCredentialsMatcher(AccountService.HASH_ALGORITHM);
		matcher.setHashIterations(AccountService.HASH_INTERATIONS);

		setCredentialsMatcher(matcher);
	}
	
	
	
	
	/**
	 * 自定义Authentication对象，使得Subject除了携带用户的登录名外还可以携带更多信息.
	 */
	public static class ShiroUser implements Serializable {
		private static final long serialVersionUID = -1373760761780840081L;
		public Long id;
		public String loginName;
		public SecurityUserPO securityUserPO;

		public ShiroUser(Long id, String loginName, SecurityUserPO securityUserPO) {
			this.id = id;
			this.loginName = loginName;
			this.securityUserPO = securityUserPO;
		}

		

		public SecurityUserPO getSecurityUserPO() {
			return securityUserPO;
		}


		/**
		 * 本函数输出将作为默认的<shiro:principal/>输出.
		 */
		@Override
		public String toString() {
			return loginName;
		}

		/**
		 * 重载hashCode,只计算loginName;
		 */
		@Override
		public int hashCode() {
			return Objects.hashCode(loginName);
		}

		/**
		 * 重载equals,只计算loginName;
		 */
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			ShiroUser other = (ShiroUser) obj;
			if (loginName == null) {
				if (other.loginName != null)
					return false;
			} else if (!loginName.equals(other.loginName))
				return false;
			return true;
		}
	}

}
