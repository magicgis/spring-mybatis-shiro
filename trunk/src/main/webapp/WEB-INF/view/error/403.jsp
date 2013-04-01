<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="<%=request.getContextPath()%>"/>
<%response.setStatus(200);%>

<!DOCTYPE html>
<html>
<head>
	<title>403 - 没有访问权限</title>
</head>

<body>
	<h2>403 - 访问受限.</h2>
	<p>请联系管理员</p>
</body>
</html>