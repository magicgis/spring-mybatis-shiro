/**   
* @author Strong
* @date 2013-3-22 下午2:56:31
* Copyright (c) 2012 T.b.j,Inc. All Rights Reserved. 
* @version V1.2.2   
*/

package cn.tbj.entity.main;

import java.util.Date;
import java.util.List;

/** 
 * @ClassName: SecurityRolePO 
 * @Description: 用户角色PO
 * @author Strong
 * @date 2013-3-22 下午2:56:31 
 * Copyright (c) 2012 T.b.j,Inc. All Rights Reserved. 
 */
public class SecurityRolePO {

	private Long id;
	
	// 角色名称
	private String roleName;
	
	// 角色代码
	private String roleCode;
	
	// 创建时间
	private Date createTime;

	
	private List<String> permissions;
	
	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	public List<String> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<String> permissions) {
		this.permissions = permissions;
	}

	@Override
	public String toString() {
		return "SecurityRolePO [id=" + id + ", roleName=" + roleName
				+ ", roleCode=" + roleCode + ", createTime=" + createTime
				+ ", permissions=" + permissions + "]";
	}
	
	
}
