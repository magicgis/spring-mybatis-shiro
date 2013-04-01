/**   
* @author Strong
* @date 2013-3-26 上午11:48:11
* Copyright (c) 2012 T.b.j,Inc. All Rights Reserved. 
* @version V1.2.2   
*/

package cn.tbj.web.controller;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.tbj.entity.main.SecurityRolePO;
import cn.tbj.entity.main.SecurityUserPO;
import cn.tbj.service.AccountService;

/** 
 * @ClassName: RegisterController 
 * @Description: TODO
 * @author Strong
 * @date 2013-3-26 上午11:48:11 
 * Copyright (c) 2012 T.b.j,Inc. All Rights Reserved. 
 */
@Controller
@RequestMapping(value = "/register")
public class RegisterController {

	@Autowired
	private AccountService accountService;
	
	private static final String REGISTER_PAGE = "account/register";
	private static final String LOGIN_PAGE = "redirect:/login";
	
	@RequestMapping(method = RequestMethod.GET)
	public String resisterForm(){
		return REGISTER_PAGE;
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public String register(@Valid SecurityUserPO securityUserPO, SecurityRolePO securityRolePO , RedirectAttributes redirectAttributes){
		
		this.accountService.registerUser(securityUserPO, securityRolePO);
		redirectAttributes.addFlashAttribute(securityUserPO);
		
		return LOGIN_PAGE;
	}
	
	

	/**
	 * Ajax请求校验loginName是否唯一。
	 */
	@RequestMapping(value = "checkLoginName")
	@ResponseBody
	public String checkLoginName(@RequestParam("userName") String userName) {
		
		if( this.accountService.queryByLoginName(userName) == null){
			return "true";
		} else {
			return "false";
		}
	}
	
}
