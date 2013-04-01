/**   
* @author Strong
* @date 2013-3-26 上午11:12:12
* Copyright (c) 2012 T.b.j,Inc. All Rights Reserved. 
* @version V1.2.2   
*/

package cn.tbj.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.tbj.entity.main.SecurityModule;
import cn.tbj.security.utils.SecurityConstants;
import cn.tbj.service.AccountService;
import cn.tbj.service.ModuleService;
import cn.tbj.service.ShiroServiceRealm.ShiroUser;

/** 
 * @ClassName: LoginController 
 * @Description: 登录控制器(真正登录的POST请求由Filter完成)
 * @author Strong
 * @date 2013-3-26 上午11:12:12 
 * Copyright (c) 2012 T.b.j,Inc. All Rights Reserved. 
 */

@Controller
@RequestMapping(value = "/loginSuccess")
public class LoginSuccessController {

	private static final String LOGIN_SUCCESS = "user/success";
	
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private ModuleService moduleService;
	
	
	@RequestMapping(value = "/index.do" ,method = RequestMethod.GET)
	public ModelAndView loginSuccess(HttpServletRequest request){
		
		Subject subject = SecurityUtils.getSubject();
		ShiroUser shiroUser = (ShiroUser)subject.getPrincipal();
		request.getSession().setAttribute(SecurityConstants.LOGIN_USER, shiroUser);
		return new ModelAndView(LOGIN_SUCCESS);
	}
	
	
	
	
	@RequestMapping(value = "/admin/makeTree.do" ,method = RequestMethod.GET)
	@RequiresPermissions("Module:test")
	@RequiresRoles("normal")
	public @ResponseBody List<SecurityModule> loginSuccess(Model model){
		
		List<SecurityModule> securityModule = moduleService.makeRootTree();
		return securityModule;
		
	}
	
}
