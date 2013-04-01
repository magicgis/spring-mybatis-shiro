<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/view/include.inc.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML>
<head>

<title>用户管理</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />

<script>
	$(document).ready(function() {
		//聚焦第一个输入框
		$("#name").focus();
		//为inputForm注册validate函数
		$("#inputForm").validate();
	});
</script>
</head>
<body>
	<h2 class="contentTitle">添加角色</h2>
	<form id="inputForm" action="<%=basePath%>/management/security/role/create" method="post" class="form-horizontal">
	
		<input type="hidden" name="id" value="${user.id}" />
		<fieldset>
			<legend>
				<small>用户管理</small>
			</legend>
			<div class="control-group">
				<label class="control-label">登录名:</label>
				<div class="controls">
					<input type="text" value="${user.loginName}" class="input-large"
						disabled="" />
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">用户名:</label>
				<div class="controls">
					<input type="text" id="name" name="name" value="${user.name}"
						class="input-large required" />
				</div>
			</div>
			<div class="control-group">
				<label for="plainPassword" class="control-label">密码:</label>
				<div class="controls">
					<input type="password" id="plainPassword" name="plainPassword"
						class="input-large" placeholder="...Leave it blank if no change" />
				</div>
			</div>
			<div class="control-group">
				<label for="confirmPassword" class="control-label">确认密码:</label>
				<div class="controls">
					<input type="password" id="confirmPassword" name="confirmPassword"
						class="input-large" equalTo="#plainPassword" />
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">注册日期:</label>
				<div class="controls">
					<span class="help-inline" style="padding: 5px 0px"><fmt:formatDate
							value="${user.registerDate}" pattern="yyyy年MM月dd日  HH时mm分ss秒" /></span>
				</div>
			</div>
			<div class="form-actions">
				<input id="submit_btn" class="btn btn-primary" type="submit"
					value="提交" />&nbsp; <input id="cancel_btn" class="btn"
					type="button" value="返回" onclick="history.back()" />
			</div>
		</fieldset>
	</form>


</body>
</html>