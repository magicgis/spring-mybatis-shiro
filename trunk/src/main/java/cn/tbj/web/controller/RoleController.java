/**   
* @author Strong
* @date 2013-3-26 下午4:36:04
* Copyright (c) 2012 T.b.j,Inc. All Rights Reserved. 
* @version V1.2.2   
*/

package cn.tbj.web.controller;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.tbj.entity.main.SecurityRolePO;
import cn.tbj.entity.main.SecurityRolePermission;
import cn.tbj.service.AccountService;
import cn.tbj.service.ModuleService;

import com.google.common.collect.Lists;

/** 
 * @ClassName: RoleController 
 * @Description: 角色控制器
 * @author Strong
 * @date 2013-3-26 下午4:36:04 
 * Copyright (c) 2012 T.b.j,Inc. All Rights Reserved. 
 */
@Controller
@RequestMapping("/management/security/role")
public class RoleController {

	@Autowired
	private AccountService accountService;
	
	@Autowired
	private ModuleService moduleService;
	
	private static final String CREATE = "management/security/role/create";
	private static final String UPDATE = "management/security/role/update";
	private static final String LIST = "management/security/role/list";
	private static final String SUCCESS = "management/security/role/success";
	private String message;
	
	
	
	@RequiresPermissions("Role:save")
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String preCreate(Model model){
		model.addAttribute("module", moduleService.makeRootTree());
		model.addAttribute("SecurityRolePO", new SecurityRolePO());
		return CREATE;
	}
	
	
	
	// 重新组装PermissionList（切分test:save,test:edit的形式）
	private void refactor(SecurityRolePO securityRolePO){
		
		List<String> allList = Lists.newArrayList();
		List<String> list = Lists.newArrayList();
		
		List<SecurityRolePermission> temp = this.accountService.queryPermissionByRoleId(securityRolePO.getId());
		for(SecurityRolePermission securityRolePermission : temp){
			list.add(securityRolePermission.getPermission());
		}
		
		for (String string : list) {
			if (StringUtils.isBlank(string)) {
				continue;
			}
			
			if (string.contains(",")) {
				String[] arr = string.split(",");
				allList.addAll(Arrays.asList(arr));
			} else {
				allList.add(string);
			}
		}
		securityRolePO.setPermissions(allList);
		
	}
	
	
	
	
	@RequiresPermissions("Role:save")
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String createRole(SecurityRolePO securityRolePO, Model model){
		
		refactor(securityRolePO);
		this.accountService.addSecurityRolePO(securityRolePO);
		
		message = "添加角色成功！";
		model.addAttribute("message", message);
		return SUCCESS;
	}
	
	
	
	
	
	
	
}
