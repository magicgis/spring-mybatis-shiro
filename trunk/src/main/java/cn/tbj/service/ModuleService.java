/**   
* @author Strong
* @date 2013-3-26 下午5:43:24
* Copyright (c) 2012 T.b.j,Inc. All Rights Reserved. 
* @version V1.2.2   
*/

package cn.tbj.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.tbj.dao.ModuleDAO;
import cn.tbj.entity.main.SecurityModule;
import cn.tbj.utils.ServiceException;

/** 
 * @ClassName: ModuleService 
 * @Description: 模块管理服务
 * @author Strong
 * @date 2013-3-26 下午5:43:24 
 * Copyright (c) 2012 T.b.j,Inc. All Rights Reserved. 
 */

@Component
@Transactional( readOnly = true)
public class ModuleService {

	
	@Resource(name = "moduleDAO")
	private ModuleDAO moduleDAO;
	
	
	
	
	/**
	 *Description: 查询子模块
	 *CreateDate:2013-3-26
	 *@author Strong
	 *@param  
	 *@return List<SecurityModule>
	 **/
	public List<SecurityModule> querySecurityModule(Long parentId){
		return this.moduleDAO.getSecurityModuleByParentId(parentId);
	}
	
	/**
	 *Description: 查询子模块(名称)
	 *CreateDate:2013-3-26
	 *@author Strong
	 *@param  
	 *@return List<SecurityModule>
	 **/
	public List<SecurityModule> querySecurityModuleByName(Long parentId, String name){
		return this.moduleDAO.getSecurityModuleByIdAndName(parentId, name);
	}
	
	/**
	 *Description: 查询所有模块
	 *CreateDate:2013-3-26
	 *@author Strong
	 *@param  
	 *@return List<SecurityModule>
	 **/
	public List<SecurityModule> queryAllSecurityModule(){
		return this.moduleDAO.getLevelSecurityModule(null, null);
	}
	
	
	/**
	 *Description: 查询子模块所有模块
	 *CreateDate:2013-3-26
	 *@author Strong
	 *@param  
	 *@return List<SecurityModule>
	 **/
	public List<SecurityModule> queryLevelSecurityModule(String level, Long parentId){
		return this.moduleDAO.getLevelSecurityModule(level, parentId);
	}
	
	
	
	/**
	 *Description: 通过主键查询模块
	 *CreateDate:2013-3-26
	 *@author Strong
	 *@param  
	 *@return SecurityModule
	 **/
	public SecurityModule queryById(Long id){
		return this.moduleDAO.getSecurityModuleById(id);
	}
	
	/**
	 *Description: 新增模块
	 *CreateDate:2013-3-26
	 *@author Strong
	 *@param  
	 *@return void
	 **/
	@Transactional
	public void addSecurityModule(SecurityModule securityModule){
		
		this.moduleDAO.insertSecurityModule(securityModule);
	}
	
	/**
	 *Description: 更新模块
	 *CreateDate:2013-3-26
	 *@author Strong
	 *@param  
	 *@return void
	 **/
	@Transactional
	public void updateSecurityModule(SecurityModule securityModule){
		this.moduleDAO.upadteSecurityModule(securityModule);
	}
	
	
	
	/**
	 *Description: 删除模块
	 *CreateDate:2013-3-26
	 *@author Strong
	 *@param  
	 *@return void
	 **/
	public void deleteSecurityModule(Long id) throws ServiceException {
		
		if(isRoot(id)){
			throw new ServiceException("不允许删除根模块。");
		}
		
		SecurityModule securityModule = this.moduleDAO.getSecurityModuleById(id);
		
		List<SecurityModule> list = this.moduleDAO.getSecurityModuleByParentId(securityModule.getId());
		
		//先判断是否存在子模块，如果存在子模块，则不允许删除
		if( list.size() > 0 ){
			throw new ServiceException( securityModule.getName() + "模块下存在子模块，不允许删除。");
		}
		
		this.moduleDAO.deleteSecurityModule(id);
		
	}
	
	/**
	 * 判断是否是根模块.
	 */
	private boolean isRoot(Long id) {
		return id == 1;
	}
	
	
	
	/**
	 * 获得根节点一级节点
	 */
	@SuppressWarnings("unused")
	private String getRootLevel(){
		return  "1";
	}
	
	/**
	 * 获得一级目录节点
	 */
	private String getModuleLevel(){
		return  "2";
	}
	
	
	/**
	 *Description: 默认一级目录
	 *CreateDate:2013-3-26
	 *@author Strong
	 *@param  
	 *@return SecurityModule
	 **/
	public List<SecurityModule> makeRootTree(){
		
		return this.queryLevelSecurityModule(getModuleLevel(),null);
	}
	
	
	
	
	
}
