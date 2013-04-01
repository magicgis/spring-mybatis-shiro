/**   
* @author Strong
* @date 2013-3-29 下午12:39:37
* Copyright (c) 2012 T.b.j,Inc. All Rights Reserved. 
* @version V1.2.2   
*/

package cn.tbj.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tbj.entity.main.SecurityModule;
import cn.tbj.security.utils.SecurityConstants;
import cn.tbj.service.ModuleService;
import cn.tbj.service.ShiroServiceRealm.ShiroUser;

/** 
 * @ClassName: ModuleController 
 * @Description: TODO
 * @author Strong
 * @date 2013-3-29 下午12:39:37 
 * Copyright (c) 2012 T.b.j,Inc. All Rights Reserved. 
 */
@Controller
@RequestMapping(value = "/management/security/module")
public class ModuleController {

	
	private static final String TREE = "management/security/module/tree";
	
	
	@Autowired
	private ModuleService moduleService;
	
	
	
	@RequiresPermissions("Module:view")
	@RequestMapping(value = "/makeTree" ,method = RequestMethod.GET)
	public @ResponseBody List<SecurityModule> loginSuccess(Model model){
		
		List<SecurityModule> securityModule = moduleService.makeRootTree();
		return securityModule;
		
	}
	
	
	@RequestMapping(value = "/success" ,method = {RequestMethod.GET,RequestMethod.POST})
	public String loginSuccess(HttpServletRequest request){
		
		Subject subject = SecurityUtils.getSubject();
		ShiroUser shiroUser = (ShiroUser)subject.getPrincipal();
		request.getSession().setAttribute(SecurityConstants.LOGIN_USER, subject);
		return TREE;
	}
}
