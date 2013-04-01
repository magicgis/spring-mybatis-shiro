<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML>
<head>
<title>更新理财小贴士图片</title>
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
	function subForm() {
		var img = document.getElementById('img').value;
		if( img == null){
			alert("请上传图片");
			return false;
		}else{
			return true;
		}
	}
</script>
</head>
<body>

	<h4 align="center" style="padding-top: 20px">图片管理</h4>
	<form action="<%=request.getContextPath()%>/tbj/edit/uploadEditImg.htm"
		method="post" enctype="multipart/form-data" onsubmit="return subForm();">
		<table width="800" border="1" align="center" class="Tab">
			<tr>
				<td>
					<div align="left" id="img">
						上传内容图片:<input name="imgFile" id="imgFile" type="file" />
					</div>
				</td>
			</tr>

			<tr>
				<td>
					<div align="center">
						<input type="submit" name="提交" value="提交"> 
						<a href="<%=request.getContextPath()%>/tbj/edit/getFinancialNews.htm">返回 </a>
					</div>
				</td>
			</tr>

		</table>
	</form>


	<c:out value="${message }"></c:out>
	<table width="100%" border="1" align="center" class="Tab">
		<tr >
		
		</tr>
		<tr style="list-style: outside;">
			<td width="5%">
				<div align="left">图片名称:</div>
			</td>
			
			<td width="5%">
				<div align="left">图片地址:</div>
			</td>
		</tr>

		<c:forEach var="list" items="${img }">
			<tr>
				<td>
					<div align="left">
						<c:out value="${list.imgName}"></c:out>
					</div>
				</td>
				
				<td>
					<div align="left">
						<c:out value="${list.path}"></c:out>
					</div>
					
					<a href="<%=request.getContextPath()%>/tbj/edit/delImg.htm?path=${list.path}"> 删除</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	
	
</body>

</html>