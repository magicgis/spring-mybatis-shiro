/**   
* @author Strong
* @date 2013-3-26 下午4:50:21
* Copyright (c) 2012 T.b.j,Inc. All Rights Reserved. 
* @version V1.2.2   
*/

package cn.tbj.entity.main;

import java.util.Date;
import java.util.List;

/** 
 * @ClassName: SecurityModule 
 * @Description: 模块
 * @author Strong
 * @date 2013-3-26 下午4:50:21 
 * Copyright (c) 2012 T.b.j,Inc. All Rights Reserved. 
 */
public class SecurityModule {

	
	private Long id;
	
	// 描述
	private String description;
	
	// 节点名称
	private String name;
	
	// 
	private String priority;
	
	// 地址
	private String url;
	
	// 父节点id
	private Long parentId;
	
	// 序列号
	private String sn;

	// 模块级别
	private String level;
	
	// 父模块
	private SecurityModule parent;
	
	// 子模块
	private List<SecurityModule> children;
	
	
	
	private Date createTime;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public void setPrority(String prority) {
		this.priority = prority;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	
	public SecurityModule getParent() {
		return parent;
	}

	public void setParent(SecurityModule parent) {
		this.parent = parent;
	}

	public List<SecurityModule> getChildren() {
		return children;
	}

	public void setChildren(List<SecurityModule> children) {
		this.children = children;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "SecurityModule [id=" + id + ", description=" + description
				+ ", name=" + name + ", priority=" + priority + ", url=" + url
				+ ", parentId=" + parentId + ", sn=" + sn + ", level=" + level
				+ ", parent=" + parent + ", children=" + children
				+ ", createTime=" + createTime + "]";
	}
	
	
}
