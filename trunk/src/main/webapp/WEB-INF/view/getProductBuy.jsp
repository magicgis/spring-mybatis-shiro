<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML>
<head>
<title>如何购买列表</title>
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

	<h4 align="center" style="padding-top: 20px">如何购买列表</h4>
	<form action="<%=request.getContextPath()%>/tbj/edit/addFinancialNews.htm" method="post" >
		<table width="100%" border="1" align="center" class="Tab">

			<tr style="list-style: outside;">
				<td width="5%">
					<div align="left">
						更新时间:
					</div>
				</td>	
				<td width="10%">
					<div align="left">
						管理机构:
					</div>
				</td>
				<td width="5%">
					<div align="left">
						管理机构代码:
					</div>
				</td>
				<td width="10%">
					<div align="left">
						官网网站地址: 
					</div>
				</td>
				<td width="10%">
					<div align="left">
						服务电话 :
					</div>
				</td>
				<td width="15%">
					<div align="left">
						ios客户端地址:
					</div>
				</td>
				<td width="15%">
					<div align="left">
						android客户端地址
					</div>
				</td>
				<td width="10%">
					<div align="left">
						机构类型:
					</div>
				</td>
				<td width="5%">
					<div align="left">
						银行定期利率:
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
						<c:out value="${list.manageCompany}"></c:out>
					</div>
				</td>
				
				<td>
					<div align="left">
						<c:out value="${list.manageCompanyCode}"></c:out>
					</div>
				</td>
				<td>
					<div align="left">
						<c:out value="${list.internetAddress}"></c:out>
					</div>
				</td>
				<td>
					<div align="left">
						<c:out value="${list.telNumber}"></c:out>
					</div>
				</td>
				<td>
					<div align="left">
						<c:out value="${list.appLinkIphone}"></c:out>
					</div>
				</td>
				<td>
					<div align="left">
						<c:out value="${list.appLinkAndroid}"></c:out>
					</div>
				</td>
				<td>
					<div align="left">
						<c:choose>
					       <c:when test="${list.manageType  == 0}">
								<c:out value="银行机构"></c:out>
					       </c:when>
					       <c:when test="${list.manageType  == 1}">
								<c:out value="基金公司"></c:out>
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
						<c:out value="${list.bankRate}"></c:out>
					</div>
				</td>
				<td>
					<a href="<%=request.getContextPath()%>/tbj/edit/modifyProductBuy.htm?id=${list.id}" id="modifyProductBuy">修改</a>
					
					<a onclick="del()" href="<%=request.getContextPath()%>/tbj/edit/delProductBuy.htm?id=${list.id}" id="delProductBuy">删除</a>
				</td>
			</tr>
			</c:forEach>
			<a href="<%=request.getContextPath()%>/tbj/edit/gotoAddProductBuy.htm"> 新增如何购买 </a>
		</table>

		
	</form>

</body>

</html>