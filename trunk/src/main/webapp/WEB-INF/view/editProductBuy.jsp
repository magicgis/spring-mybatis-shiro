<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML>
<head>
<title>编辑如何购买</title>
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

	<h4 align="center" style="padding-top: 20px">编辑如何购买</h4>
	<form
		action="<%=request.getContextPath()%>/tbj/edit/editProductBuy.htm"
		method="post">
		<table width="800" border="1" align="center" class="Tab">
			<div style="display: none;">
				<form:input path="productBuyPO.id" />
			</div>
			<tr style="list-style: outside;">
				<td width="5%">
					<div align="left">
						管理机构:
						<form:input path="productBuyPO.manageCompany" />
					</div>
				</td>
			</tr>
			
			<tr>
				<td width="10%">
					<div align="left">
						管理机构代码:
						<form:input path="productBuyPO.manageCompanyCode" />
					</div>
				</td>
			</tr>
			
			<tr>
				<td width="10%">
					<div align="left">
						官网网站地址:
						<form:input path="productBuyPO.internetAddress" />
					</div>
				</td>
			</tr>
			
			<tr>
				<td width="20%">
					<div align="left">
						服务电话 :
						<form:input path="productBuyPO.telNumber" />
					</div>
				</td>
			</tr>
			
			<tr>
				<td width="15%">
					<div align="left">
						ios客户端地址:
						<form:input path="productBuyPO.appLinkIphone" />
					</div>
				</td>
			</tr>
			
			<tr>
				<td width="5%">
					<div align="left">
						android客户端地址:
						<form:input path="productBuyPO.appLinkAndroid" />
					</div>
				</td>
			</tr>
			
			<tr>
				<td width="10%">
					<div align="left">
						银行机构:
						<form:radiobutton path="productBuyPO.manageType" value="0" />
						基金公司:
						<form:radiobutton path="productBuyPO.manageType" value="1" />
					</div>
				</td>
			</tr>
			
			<tr>
				<td width="5%">
					<div align="left">
						银行定期利率:
						<form:input path="productBuyPO.bankRate" />
					</div>
				</td>
			</tr>
			
			<tr>
				<td>
					<div align="center">
						<input type="submit" name="提交" value="提交">
						<a href="<%=request.getContextPath()%>/tbj/edit/getProductBuy.htm">
							返回 </a>
					</div>
				</td>
			</tr>
		</table>


	</form>

</body>

</html>