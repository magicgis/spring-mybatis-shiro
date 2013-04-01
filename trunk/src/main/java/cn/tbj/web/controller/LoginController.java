/**   
* @author Strong
* @date 2013-3-26 上午11:12:12
* Copyright (c) 2012 T.b.j,Inc. All Rights Reserved. 
* @version V1.2.2   
*/

package cn.tbj.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.tbj.entity.main.SecurityUserPO;
import cn.tbj.service.AccountService;
import cn.tbj.service.ModuleService;

/** 
 * @ClassName: LoginController 
 * @Description: 登录控制器(真正登录的POST请求由Filter完成)
 * @author Strong
 * @date 2013-3-26 上午11:12:12 
 * Copyright (c) 2012 T.b.j,Inc. All Rights Reserved. 
 */

@Controller
@RequestMapping(value = "/login.do")
public class LoginController {

	private static final String LOGIN_PAGE = "user/login";
	
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private ModuleService moduleService;
	
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String login(Model model){
		model.addAttribute("SecurityUserPO", new SecurityUserPO());
		return LOGIN_PAGE;
	}
	
	
	
	@RequestMapping(method = RequestMethod.POST)
	public String loginFail(@RequestParam(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM) String userName , Model model ,HttpServletRequest request){
		String msg = parseException(request); 
		
		model.addAttribute(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM, userName);
		model.addAttribute(msg);
		return LOGIN_PAGE;
	}
	
	
	/**
	 *Description: 通用异常信息
	 *CreateDate:2013-3-26
	 *@author Strong
	 *@param  
	 *@return String
	 **/
	private String parseException(HttpServletRequest request) {
		String error = (String) request
				.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
		String msg = "其他错误！";
		if (error != null) {
			if ("org.apache.shiro.authc.UnknownAccountException".equals(error))
				msg = "未知帐号错误！";
			else if ("org.apache.shiro.authc.IncorrectCredentialsException"
					.equals(error))
				msg = "密码错误！";
			else if ("com.ketayao.security.shiro.IncorrectCaptchaException"
					.equals(error))
				msg = "验证码错误！";
			else if ("org.apache.shiro.authc.AuthenticationException"
					.equals(error))
				msg = "认证失败！";
			else if ("org.apache.shiro.authc.DisabledAccountException"
					.equals(error))
				msg = "账号被冻结！";
		}
		return "登录失败，" + msg;
	}
}
