/**   
* @author Strong
* @date 2013-3-26 下午5:03:25
* Copyright (c) 2012 T.b.j,Inc. All Rights Reserved. 
* @version V1.2.2   
*/

package cn.tbj.dao;

import java.util.List;

import cn.tbj.entity.main.SecurityModule;


/** 
 * @ClassName: ModuleDAO 
 * @Description: 模块DAO接口
 * @author Strong
 * @date 2013-3-26 下午5:03:25 
 * Copyright (c) 2012 T.b.j,Inc. All Rights Reserved. 
 */
public interface ModuleDAO {

	
	/**
	 *Description: 新增模块
	 *CreateDate:2013-3-26
	 *@author Strong
	 *@param  
	 *@return void
	 **/
	void insertSecurityModule(SecurityModule securityModule);
	
	
	/**
	 *Description: 更新模块
	 *CreateDate:2013-3-26
	 *@author Strong
	 *@param  
	 *@return void
	 **/
	void upadteSecurityModule(SecurityModule securityModule);
	
	
	/**
	 *Description: 删除模块
	 *CreateDate:2013-3-26
	 *@author Strong
	 *@param  
	 *@return void
	 **/
	void deleteSecurityModule(Long id);
	
	
	/**
	 *Description: 根据主键查询模块
	 *CreateDate:2013-3-26
	 *@author Strong
	 *@param  
	 *@return SecurityModule
	 **/
	SecurityModule getSecurityModuleById(Long id);
	
	
	/**
	 *Description: 查询子模块
	 *CreateDate:2013-3-26
	 *@author Strong
	 *@param  
	 *@return List<SecurityModule>
	 **/
	List<SecurityModule> getSecurityModuleByParentId(Long parentId);
	
	/**
	 *Description: 查询子模块（名称）
	 *CreateDate:2013-3-26
	 *@author Strong
	 *@param  
	 *@return List<SecurityModule>
	 **/
	List<SecurityModule> getSecurityModuleByIdAndName(Long parentId , String name);
	
	/**
	 *Description: 查询模块列表
	 *CreateDate:2013-3-26
	 *@author Strong
	 *@param  
	 *@return List<SecurityModule>
	 **/
	List<SecurityModule> getLevelSecurityModule(String level, Long parentId);
	
	
	
}
