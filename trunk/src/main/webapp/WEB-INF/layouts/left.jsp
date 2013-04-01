<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="ctx" value="<%=request.getContextPath()%>" />
<div id="leftbar" class="span2">
	
	<shiro:user>
	<shiro:hasRole name="admin">
		<h2>管理员</h2>
		<div class="submenu">
			<a id="account-tab"href="${ctx}/account/user/">帐号管理</a>
		</div>
	</shiro:hasRole>
	
	<shiro:hasAnyRoles name="normal,admin">
	<h2>普通用户</h2>
	<div class="submenu">
		<a id="web-tab" href="${ctx}/story/web">权限管理</a><br/>
		<a id="webservice-tab"href="${ctx}/story/webservice">模块管理</a><br/>
		<a id="log-tab" href="${ctx}/log/console">日志管理</a><br/>
	</div>
	</shiro:hasAnyRoles>
	
	</shiro:user>
</div>