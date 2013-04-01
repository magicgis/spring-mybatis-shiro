<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true"%>
<%@ include file="/WEB-INF/view/include.inc.jsp"%>
<c:set var="ctx" value="<%=request.getContextPath()%>" />

<!DOCTYPE html>
<HTML>
<HEAD>
<TITLE>管理模块</TITLE>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">

</HEAD>

<BODY>

	<h2> 欢迎 您</h2>
	<form method="post" action="">
		
		<div class="tree" style="display: none;">
			<c:forEach items="${securityModule }" var="list">
				<div id="name">
					<c:out value="${ list.name}"></c:out>
				</div>

				<div id="level">
					<c:out value="${ list.level}"></c:out>
				</div>

				<div id="priority">
					<c:out value="${ list.priority}"></c:out>
				</div>

				<div id="parent_id">
					<c:out value="${ list.parent_id}"></c:out>
				</div>

				<div id="url">
					<c:out value="${ list.url}"></c:out>
				</div>
			</c:forEach>
		</div>
		
		
	</form>

</BODY>
</HTML>