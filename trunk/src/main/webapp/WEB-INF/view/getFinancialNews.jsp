<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML>
<head>
<title>理财小贴士列表</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<link rel="shortcut icon" href="favorite.ico">
<style type="text/css">
* {
	margin: 0;
	padding: 0;
}

body {
	font-family: Arial, 微软雅黑;
	color: #3a3a3a;
}

.Tab {
	border-collapse: collapse;
	border: 1px solid black;
	width: 800px;
}

.Tab td {
	border: 1px solid black;
}
</style>

<script type="text/javascript">

	function del(){
		
		var localObj = window.location;
		var contextPath = localObj.pathname.split("/")[1];
		var basePath = localObj.protocol+"//"+localObj.host+"/"+contextPath;
		var server_context=basePath;
		
		if (confirm("真的要删除吗？")){
			return true;
		}else{
			return false;
		}
	}
	

</script>
</head>
<body>

	<h4 align="center" style="padding-top: 20px">理财小贴士列表</h4>
	<form action="<%=request.getContextPath()%>/tbj/edit/addFinancialNews.htm" method="post" >
		<table width="100%" border="1" align="center" class="Tab">

			<tr style="list-style: outside;">
				<td width="5%">
					<div align="left">
						更新时间:
					</div>
				</td>	
				<td width="5%">
					<div align="left">
						分组标识:
					</div>
				</td>
				<td width="10%">
					<div align="left">
						标题 :
					</div>
				</td>
				<td width="10%">
					<div align="left">
						副标题: 
					</div>
				</td>
				<td width="20%">
					<div align="left">
						内容 :
					</div>
				</td>
				<td width="15%">
					<div align="left">
						内容概要:
					</div>
				</td>
				<td width="5%">
					<div align="left">
						样式
					</div>
				</td>
				<td width="10%">
					<div align="left">
						推送日期:
					</div>
				</td>
				<td width="5%">
					<div align="left">
						推送状态:
					</div>
				<td width="5%">
					<div align="left">屏蔽状态:</div>
				</td>
				<td width="5%">
					<div align="left">
						缩略图地址:
					</div>
				</td>
				<td width="5%">
					操作
				</td>
			</tr>
			
			<c:forEach var="list" items="${list }" >
			 <tr>
				<div style="display: none;" id="id"> <c:out value="${list.id}"></c:out> </div>
				<td >
					<div align="left">
						<c:out value="${list.showDate}"></c:out>
					</div>
				</td>
				<td>
					<div align="left">
						<c:out value="${list.groupId}"></c:out>
					</div>
				</td>
				
				<td>
					<div align="left">
						<c:out value="${list.title}"></c:out>
					</div>
				</td>
				<td>
					<div align="left">
						<c:out value="${list.subtitle}"></c:out>
					</div>
				</td>
				<td>
					<div align="left">
						<c:out value="${list.content}"></c:out>
					</div>
				</td>
				<td>
					<div align="left">
						<c:out value="${list.lessContent}"></c:out>
					</div>
				</td>
				<td>
					<div align="left">
						<c:choose>
					       <c:when test="${list.styleType  == 1}">
								<c:out value="图片贴士"></c:out>
					       </c:when>
					       <c:when test="${list.styleType  == 2}">
								<c:out value="多条贴士"></c:out>
					       </c:when>
					       <c:when test="${list.styleType  == 3}">
								<c:out value="单条贴士"></c:out>
					       </c:when>
					       <c:otherwise>
					            <div style="color: red">
					            	<c:out value="类型错误"></c:out>
					            </div>
					       </c:otherwise>
						</c:choose>
					</div>
				</td>
				<td>
					<div align="left">
						<c:out value="${list.postDate}"></c:out>
					</div>
				</td>
				<td>
					<div align="left">
						<c:out value="${list.postStatus}"></c:out>
					</div>
				<td>
					<div align="left">
						<c:choose>
					       <c:when test="${list.available  == 'active'}">
								<c:out value="激活"></c:out>
					       </c:when>
					       <c:when test="${list.available  == 'unactive'}">
								<c:out value="屏蔽"></c:out>
					       </c:when>
					       <c:otherwise>
					            <div style="color: red">
					            	<c:out value="类型错误"></c:out>
					            </div>
					       </c:otherwise>
						</c:choose>
					</div>
				</td>
				<td>
					<div align="left">
						<c:out value="${list.thumbnail}"></c:out>
					</div>
				</td>
				<td>
					<a href="<%=request.getContextPath()%>/tbj/edit/modifyFinancialNews.htm?id=${list.id}" id="modifyFinancial">修改</a>
					
					<a onclick="del()" href="<%=request.getContextPath()%>/tbj/edit/delFinancialNews.htm?id=${list.id}" id="delFinancial">删除</a>
				</td>
			</tr>
			</c:forEach>
			<a href="<%=request.getContextPath()%>/tbj/edit/gotoAddFinancialNews.htm"> 新增小贴士 </a>
			<a href="<%=request.getContextPath()%>/tbj/edit/gotoEditImg.htm"> 图片维护 </a>
			<a href="<%=request.getContextPath()%>/tbj/edit/gotoPostNews.htm"> 推送 </a>
		</table>

		
	</form>

</body>

</html>