/**
 * 
 */
package cn.tbj.entity;

import java.io.Serializable;

/**
 * @Description:统一定义id的entity基类.
 * 基类统一定义id的属性名称、数据类型、列名映射及生成策略.
 * 子类可重载getId()函数重定义id的列名映射和生成策略.
 * @author Strong
 * @date 2013-3-11 下午4:06:38
 */
public abstract class IdEntity implements Serializable {

	
	/**  
	  * @Fields serialVersionUID : TODO 
	  */
	private static final long serialVersionUID = 1L;
	protected Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
