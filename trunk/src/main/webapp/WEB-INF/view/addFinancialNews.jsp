<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML>
<head>
<title>新增理财小贴士</title>
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
	function test() {
		var startDate = document.getElementById('startDate').value;
		var endDate = document.getElementById('endDate').value;

		alert(Date.parse(startDate.replace("-", "/")) <= Date.parse(endDate
				.replace("-", "/")));
	}
</script>
</head>
<body>

	<h4 align="center" style="padding-top: 20px">新增理财小贴士</h4>
	<form
		action="<%=request.getContextPath()%>/tbj/edit/editFinancialNews.htm"
		method="post" enctype="multipart/form-data">
		<table width="800" border="1" align="center" class="Tab">

			<tr>
				<td>
					<div align="left">
						标题 :
						<form:textarea path="financialNewsPO.title" rows="5" cols="80" />
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div align="left">
						副标题: <form:textarea path="financialNewsPO.subtitle" rows="5" cols="80" />
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div align="left">
						内容 :<form:textarea path="financialNewsPO.content" rows="18" cols="80"/>
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div align="left">
						内容概要:<form:textarea path="financialNewsPO.lessContent" rows="10" cols="80"/>
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div align="left">
						样式
						<form:radiobutton path="financialNewsPO.styleType" value="1" />
						图片贴士
						<form:radiobutton path="financialNewsPO.styleType" value="2" />
						多条贴士
						<form:radiobutton path="financialNewsPO.styleType" value="3" />
						单条贴士
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div align="left">
						分组标识:<form:input path="financialNewsPO.groupId" />
					</div>
				</td>
			</tr>
			
			<!--  
			<tr>
				<td>
					<div align="left">
						推送日期:<form:input path="financialNewsPO.postDate" readonly="readonly" />
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div align="left">
						推送状态:<form:input path="financialNewsPO.postStatus" readonly="readonly" />
					</div>
			</tr>
			-->
			<tr>
				<td>
					<div align="left">屏蔽状态:
						激活
						<form:radiobutton path="financialNewsPO.available" value="active" />
						屏蔽
						<form:radiobutton path="financialNewsPO.available" value="unactive" />
					</div>
				</td>
			</tr>
			
			
			<tr>
				<td>
					<div align="left">
						上传缩略图:<input name="imgFile" id="imgFile" type="file" />
					</div>
				</td>
			</tr>

			<tr>
				<td>
					<div align="center">
						<input type="submit" name="提交" value="提交">
						<input type="reset" name="重置" value="重置">
						<a href="<%=request.getContextPath()%>/tbj/edit/getFinancialNews.htm"> 返回 </a>
					</div>
				</td>
			</tr>
			
		</table>

		
	</form>

</body>

</html>