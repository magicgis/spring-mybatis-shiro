<%@page import="java.util.Date"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/WEB-INF/view/include.inc.jsp"%>
<c:set var="ctx" value="<%=request.getContextPath()%>" />

<!DOCTYPE html>
<HTML>
<HEAD>
	<TITLE>管理模块</TITLE>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="${ctx}/static/ztree/css/demo.css" type="text/css">
	<link rel="stylesheet" href="${ctx}/static/ztree/css/zTreeStyle/zTreeStyle.css" type="text/css">
	<script type="text/javascript" src="${ctx}/static/ztree/js/jquery-1.4.4.min.js"></script>
	<script type="text/javascript" src="${ctx}/static/ztree/js/jquery.ztree.core-3.5.js"></script>
	<script type="text/javascript" src="${ctx}/static/ztree/js/jquery.ztree.excheck-3.5.js"></script>
	<script type="text/javascript" src="${ctx}/static/ztree/js/jquery.ztree.exedit-3.5.js"></script>
	<SCRIPT type="text/javascript">
		<!--
		var setting = {
			data: {
				key: {
					title:"t"
				},
				simpleData: {
					enable: true
				}
			},
			callback: {
				beforeClick: beforeClick,
				onClick: onClick
			}
		};

		
		var 
		var zNodes =[
			{ id:1, pId:0, name:"one", open:true, iconOpen:"../tree/css/zTreeStyle/img/diy/1_open.png", iconClose:"../tree/css/zTreeStyle/img/diy/1_close.png"},
			{ id:11, pId:1, name:"one", icon:"../tree/css/zTreeStyle/img/diy/2.png"},
			{ id:12, pId:1, name:"one", icon:"../tree/css/zTreeStyle/img/diy/3.png"},
			{ id:13, pId:1, name:"one", icon:"../tree/css/zTreeStyle/img/diy/5.png"},
			{ id:2, pId:0, name:"two", open:true, icon:"../tree/css/zTreeStyle/img/diy/4.png"},
			{ id:21, pId:2, name:"one", icon:"../tree/css/zTreeStyle/img/diy/6.png"},
			{ id:22, pId:2, name:"two", icon:"../tree/css/zTreeStyle/img/diy/7.png"},
			{ id:23, pId:2, name:"three", icon:"../tree/css/zTreeStyle/img/diy/8.png"},
			{ id:3, pId:0, name:"three", open:true },
			{ id:31, pId:3, name:"KKKs", t:"ss" , icon:"../tree/css/zTreeStyle/img/diy/8.png"},
			{ id:32, pId:3, name:"KKKs", t:"ss"},
			{ id:33, pId:3, name:"KKKs", t:"ss"}

		];


		var id = $("demo").val();
		
		function beforeClick(treeId, treeNode, clickFlag) {
			alert(treeId + treeNode.name + clickFlag);
			var id = $('demo').val();
			alert(id);
			return false;
		}
		function onClick(event, treeId, treeNode, clickFlag) {
			alert(event + treeId + treeNode + clickFlag);
		}	
		
		
		$(document).ready(function(){
			$.fn.zTree.init($("#treeDemo"), setting, zNodes);
		});
		
		
		 $(document).ready(function(){  
             
	          
		        $.get("http://localhost:8090/Test/servlet/tree",function(data){  
		          
		            $('#result').text(data);//直接展示JSON数据  
		            fuzhi(data);  
		              
		            });  
		  
		        }); 
		 
		 
		//-->
	</SCRIPT>
</HEAD>

<BODY>
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