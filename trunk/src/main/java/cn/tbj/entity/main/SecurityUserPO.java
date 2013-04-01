/**    
* @Title: SecurityUser.java  
* @Description: TODO 
* @author Strong 
* @date 2013-3-11 下午4:13:35  
* @version V1.0    
*/
package cn.tbj.entity.main;

import java.beans.Transient;
import java.util.Date;

import cn.tbj.entity.IdEntity;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**  
 * @Description: TODO 
 * @author Strong
 * @date 2013-3-11 下午4:13:35    
 */
public class SecurityUserPO extends IdEntity {

	
	/**  
	  * @Fields serialVersionUID : TODO 
	  */
	private static final long serialVersionUID = 1L;

	private Long id;
	
	// 创建时间
	private Date createTime;
	
	//密码
	private String password;
	
	private String plainPassword;
	
	// 不持久化到数据库，也不显示在Restful接口的属性.
	@Transient
	@JsonIgnore
	public String getPlainPassword() {
		return plainPassword;
	}

	public void setPlainPassword(String plainPassword) {
		this.plainPassword = plainPassword;
	}

	// salt 盐
	private String salt;
	
	// 状态
	private String status;
	
	// 用户名
	private String username;
	
	// 邮箱地址
	private String email;
	
	// 真实姓名
	private String realname;
	
	// 手机号
	private String phone;
	
	// 
	private Long org_id;

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Long getOrg_id() {
		return org_id;
	}

	public void setOrg_id(Long org_id) {
		this.org_id = org_id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "SecurityUserPO [id=" + id + ", createTime=" + createTime
				+ ", password=" + password + ", plainPassword=" + plainPassword
				+ ", salt=" + salt + ", status=" + status + ", username="
				+ username + ", email=" + email + ", realname=" + realname
				+ ", phone=" + phone + ", org_id=" + org_id + "]";
	}

	public SecurityUserPO(){
		
	}
	
	
	public SecurityUserPO(String username, String password, String salt, 
			String realname) {
		this.password = password;
		this.salt = salt;
		this.username = username;
		this.realname = realname;
	}
	
	
}
