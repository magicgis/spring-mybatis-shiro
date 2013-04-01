/**   
* @author Strong
* @date 2013-3-22 下午4:26:52
* Copyright (c) 2012 T.b.j,Inc. All Rights Reserved. 
* @version V1.2.2   
*/

package cn.tbj.test.dao;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;

import cn.tbj.dao.UserDAO;
import cn.tbj.test.utils.SpringTestTemplate;

/** 
 * @ClassName: UserDAOImplTest 
 * @Description: TODO
 * @author Strong
 * @date 2013-3-22 下午4:26:52 
 * Copyright (c) 2012 T.b.j,Inc. All Rights Reserved. 
 */
public class UserDAOImplTest extends SpringTestTemplate{

	@Resource(name = "userDAO")
	private UserDAO userDAO;
	
	/**
	 * Test method for {@link cn.tbj.dao.impl.UserDAOImpl#getAllUser()}.
	 */
	@Test
	public void testGetAllUser() {
		
		System.out.println(this.userDAO.getAllUser());
	}

	/**
	 * Test method for {@link cn.tbj.dao.impl.UserDAOImpl#getUserById(java.lang.Long)}.
	 */
	@Test
	public void testGetUserById() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link cn.tbj.dao.impl.UserDAOImpl#getUserByLoginName(java.lang.String)}.
	 */
	@Test
	public void testGetUserByLoginName() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link cn.tbj.dao.impl.UserDAOImpl#insertSecurityUser(cn.tbj.entity.main.SecurityUserPO)}.
	 */
	@Test
	public void testInsertSecurityUser() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link cn.tbj.dao.impl.UserDAOImpl#upadteSecurityUser(cn.tbj.entity.main.SecurityUserPO)}.
	 */
	@Test
	public void testUpadteSecurityUser() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link cn.tbj.dao.impl.UserDAOImpl#deleteSecurityUser(java.lang.Long)}.
	 */
	@Test
	public void testDeleteSecurityUser() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link cn.tbj.dao.impl.UserDAOImpl#insertSecurityRole(cn.tbj.entity.main.SecurityRolePO)}.
	 */
	@Test
	public void testInsertSecurityRole() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link cn.tbj.dao.impl.UserDAOImpl#updateSecurityRole(cn.tbj.entity.main.SecurityRolePO)}.
	 */
	@Test
	public void testUpdateSecurityRole() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link cn.tbj.dao.impl.UserDAOImpl#deleteSecurityRole(cn.tbj.entity.main.SecurityRolePO)}.
	 */
	@Test
	public void testDeleteSecurityRole() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link cn.tbj.dao.impl.UserDAOImpl#insertSecurityUserRole(cn.tbj.entity.main.SecurityUserRolePO)}.
	 */
	@Test
	public void testInsertSecurityUserRole() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link cn.tbj.dao.impl.UserDAOImpl#updateSecurityUserRole(cn.tbj.entity.main.SecurityUserRolePO)}.
	 */
	@Test
	public void testUpdateSecurityUserRole() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link cn.tbj.dao.impl.UserDAOImpl#deleteSecurityUserRole(cn.tbj.entity.main.SecurityUserRolePO)}.
	 */
	@Test
	public void testDeleteSecurityUserRole() {
		fail("Not yet implemented");
	}

}
