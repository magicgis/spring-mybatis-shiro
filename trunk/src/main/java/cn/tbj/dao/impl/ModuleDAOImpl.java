/**   
* @author Strong
* @date 2013-3-26 下午5:17:13
* Copyright (c) 2012 T.b.j,Inc. All Rights Reserved. 
* @version V1.2.2   
*/

package cn.tbj.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import cn.tbj.dao.ModuleDAO;
import cn.tbj.entity.main.SecurityModule;

/** 
 * @ClassName: ModuleDAOImpl 
 * @Description: TODO
 * @author Strong
 * @date 2013-3-26 下午5:17:13 
 * Copyright (c) 2012 T.b.j,Inc. All Rights Reserved. 
 */
public class ModuleDAOImpl extends SqlSessionDaoSupport implements ModuleDAO {

	/* (non-Javadoc)
	 * @see cn.tbj.dao.ModuleDAO#insertSecurityModule(cn.tbj.entity.main.SecurityModule)
	 */
	@Override
	public void insertSecurityModule(SecurityModule securityModule) {
		
		if( securityModule != null){
			this.getSqlSession().insert("SecurityModule.INSERT_SECURITYMODULE", securityModule);
		}else{
			throw new IllegalArgumentException("securityModule 不能为空");
		}

	}
	
	
	/* (non-Javadoc)
	 * @see cn.tbj.dao.ModuleDAO#upadteSecurityModule(cn.tbj.entity.main.SecurityModule)
	 */
	@Override
	public void upadteSecurityModule(SecurityModule securityModule) {
		
		if( securityModule != null){
			this.getSqlSession().update("SecurityModule.UPDATE_BY_ID", securityModule);
		}else{
			throw new IllegalArgumentException("securityModule 不能为空");
		}

	}
	

	/* (non-Javadoc)
	 * @see cn.tbj.dao.ModuleDAO#deleteSecurityModule(java.lang.Long)
	 */
	@Override
	public void deleteSecurityModule(Long id) {
		
		if( id != null){
			this.getSqlSession().delete("SecurityModule.DELETE_BY_ID", id);
		}else{
			throw new IllegalArgumentException("id 不能为空");
		}

	}
	
	
	/* (non-Javadoc)
	 * @see cn.tbj.dao.ModuleDAO#getSecurityModuleById(java.lang.Long)
	 */
	@Override
	public SecurityModule getSecurityModuleById(Long id){
		
		if( id != null){
			return (SecurityModule) this.getSqlSession().selectOne("SecurityModule.SELECT_BY_ID", id);
		}else{
			throw new IllegalArgumentException("id 不能为空");
		}
	}

	/* (non-Javadoc)
	 * @see cn.tbj.dao.ModuleDAO#getSecurityModuleByParentId(java.lang.Long)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<SecurityModule> getSecurityModuleByParentId(Long parentId) {
		
		if( parentId != null){
			return this.getSqlSession().selectList("SecurityModule.SELECTS_ALL_MODULE", parentId);
		}else{
			throw new IllegalArgumentException("parentId 不能为空");
		}
	}

	/* (non-Javadoc)
	 * @see cn.tbj.dao.ModuleDAO#getSecurityModuleByIdAndName(java.lang.Long, java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<SecurityModule> getSecurityModuleByIdAndName(Long parentId,
			String name) {
		
		Map<String, Object> map;
		if( parentId != null && StringUtils.isNotBlank(name)){
			map = new HashMap<String, Object>();
			map.put("parentId", parentId);
			map.put("name", name);
			return this.getSqlSession().selectList("SecurityModule.SELECTS_MODULE_BY_PARENTID_NAME", map);
		}else{
			throw new IllegalArgumentException("parentId,name 不能为空");
		}
	}

	/* (non-Javadoc)
	 * @see cn.tbj.dao.ModuleDAO#getAllSecurityModule()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<SecurityModule> getLevelSecurityModule(String level , Long parentId) {
		
		Map<String, Object> map;
		map = new HashMap<String, Object>();
		map.put("parentId", parentId);
		map.put("level", level);
			
		return this.getSqlSession().selectList("SecurityModule.SELECTS_LEVEL_MODULE", map);
	}
	
	

}
