/**   
* @author Strong
* @date 2013-3-22 下午2:48:47
* Copyright (c) 2012 T.b.j,Inc. All Rights Reserved. 
* @version V1.2.2   
*/

package cn.tbj.entity.main;

import java.util.Date;

/** 
 * @ClassName: SecurityUserRole 
 * @Description: 用户与角色PO
 * @author Strong
 * @date 2013-3-22 下午2:48:47 
 * Copyright (c) 2012 T.b.j,Inc. All Rights Reserved. 
 */
public class SecurityUserRolePO {

	
	private Long id;
	
	// 优先权，值越小，优先级越高
	private Integer priority = 99;
	
	// 用户角色id
	private Long roleId;
	
	// 用户id
	private Long UserId;

	private Date createTime;
	
	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getUserId() {
		return UserId;
	}

	public void setUserId(Long userId) {
		UserId = userId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "SecurityUserRolePO [id=" + id + ", priority=" + priority
				+ ", roleId=" + roleId + ", UserId=" + UserId + ", createTime="
				+ createTime + "]";
	}
	
	
	
	
}
