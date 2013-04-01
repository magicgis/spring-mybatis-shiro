/**   
* @author Strong
* @date 2013-3-22 下午3:12:31
* Copyright (c) 2012 T.b.j,Inc. All Rights Reserved. 
* @version V1.2.2   
*/

package cn.tbj.security.utils;

/** 
 * @ClassName: RoleUtils 
 * @Description: 角色常量代码
 * @author Strong
 * @date 2013-3-22 下午3:12:31 
 * Copyright (c) 2012 T.b.j,Inc. All Rights Reserved. 
 */
public class RoleUtils {

	private static final String role_admin = "ROLE_ADMIN";
	
	private static final String role_user_normal = "ROLE_USER_NORMAL";
	private static final Long role_user_normal_id = new Long(2);
	
	
	private static final String role_user_role1 = "ROLE_USER_ROLE1";
	private static final Long role_user_role1_id = new Long(3);
	
	
	public static String getRoleAdmin() {
		return role_admin;
	}

	public static String getRoleUserNormal() {
		return role_user_normal;
	}

	public static String getRoleUserRole1() {
		return role_user_role1;
	}

	public static Long getRoleUserNormalId() {
		return role_user_normal_id;
	}

	public static Long getRoleUserRole1Id() {
		return role_user_role1_id;
	}
	
	
	private static final String role_user_status_enabled = "enabled";
	private static final String role_user_status_disabled = "disabled";


	public static String getRoleUserStatusEnabled() {
		return role_user_status_enabled;
	}

	public static String getRoleUserStatusDisabled() {
		return role_user_status_disabled;
	}
	
	
	
}
