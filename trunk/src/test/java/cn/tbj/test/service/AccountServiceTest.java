/**   
* @author Strong
* @date 2013-3-25 下午7:09:08
* Copyright (c) 2012 T.b.j,Inc. All Rights Reserved. 
* @version V1.2.2   
*/

package cn.tbj.test.service;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.tbj.entity.main.SecurityRolePO;
import cn.tbj.entity.main.SecurityUserPO;
import cn.tbj.service.AccountService;
import cn.tbj.test.utils.SpringTestTemplate;

/** 
 * @ClassName: AccountServiceTest 
 * @Description: TODO
 * @author Strong
 * @date 2013-3-25 下午7:09:08 
 * Copyright (c) 2012 T.b.j,Inc. All Rights Reserved. 
 */
public class AccountServiceTest extends SpringTestTemplate{

	
	private AccountService accountService;
	
	public AccountService getAccountService() {
		return accountService;
	}

	@Autowired
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	/**
	 * Test method for {@link cn.tbj.service.AccountService#queryAllSecurityUserPO()}.
	 */
	@Test
	public void testQueryAllSecurityUserPO() {
		System.out.println(accountService.queryAllSecurityUserPO());
	}

	/**
	 * Test method for {@link cn.tbj.service.AccountService#queryById(java.lang.Long)}.
	 */
	@Test
	public void testQueryById() {
		System.out.println(this.accountService.queryById(new Long(3)));
	}

	/**
	 * Test method for {@link cn.tbj.service.AccountService#queryByLoginName(java.lang.String)}.
	 */
	@Test
	public void testQueryByLoginName() {
		System.out.println(this.accountService.queryByLoginName("admin"));
	}

	/**
	 * Test method for {@link cn.tbj.service.AccountService#registerUser(cn.tbj.entity.main.SecurityUserPO, cn.tbj.entity.main.SecurityRolePO)}.
	 */
	@Test
	public void testRegisterUser() {
		
		SecurityUserPO securityUserPO = new SecurityUserPO();
		securityUserPO.setUsername("kkks");
		securityUserPO.setPlainPassword("mima");
		securityUserPO.setRealname("Strong");
		securityUserPO.setEmail("Email");
		securityUserPO.setPhone("13023686215");
		
		this.accountService.registerUser(securityUserPO, null);
		
		SecurityUserPO securityUserPO2 = new SecurityUserPO();
		securityUserPO2.setUsername("kkks2");
		securityUserPO2.setPlainPassword("mima");
		securityUserPO2.setRealname("Strong");
		securityUserPO2.setEmail("Email");
		securityUserPO2.setPhone("13023686215");
		
		SecurityRolePO securityRolePO = this.accountService.queryByRoleId(new Long(3));
		
		this.accountService.registerUser(securityUserPO2, securityRolePO);
	}

	/**
	 * Test method for {@link cn.tbj.service.AccountService#updateUser(cn.tbj.entity.main.SecurityUserPO, cn.tbj.entity.main.SecurityUserRolePO)}.
	 */
	@Test
	public void testUpdateUser() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link cn.tbj.service.AccountService#deleteUser(java.lang.Long)}.
	 */
	@Test
	public void testDeleteUser() {
		fail("Not yet implemented");
	}

}
