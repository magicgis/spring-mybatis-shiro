/**   
* @author Strong
* @date 2013-3-26 下午2:08:24
* Copyright (c) 2012 T.b.j,Inc. All Rights Reserved. 
* @version V1.2.2   
*/

package cn.tbj.entity.main;

import java.util.Date;

/** 
 * @ClassName: SecurityRolePermission 
 * @Description: 用户角色权限
 * @author Strong
 * @date 2013-3-26 下午2:08:24 
 * Copyright (c) 2012 T.b.j,Inc. All Rights Reserved. 
 */
public class SecurityRolePermission {

	
	private long roleId;
	
	private String permission;
	
	private String desc;
	
	private Date createTime;

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "SecurityRolePermission [roleId=" + roleId + ", permission="
				+ permission + ", desc=" + desc + ", createTime=" + createTime
				+ "]";
	}
	
	
}
