  <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>  
<%
	String power=(String)session.getAttribute("key");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>湖北公安监管信息综合应用平台</title>
<jsp:include page="../jscss.jsp"></jsp:include>
</head>
<body>
	<div id="content">
		<div id="content-header">
			<h1>用户管理</h1>
			<div class="btn-group" style="width: auto;">
				<a title="" href="jx_role_bs_gotoAddRole.action" class="btn btn-primary " >添加</a>			
			</div>
		</div>
<!--		<div id="breadcrumb">-->
<!--			<a class="tip-bottom" title="" href="user_select.action"><i class="icon-home"></i>首页</a>-->
<!--			<a class="current" >用户信息列表</a>-->
<!--		</div>-->
<!--  
		<div class="searcharea">
			<s:form action="user_select.action" method="post" id="myform" theme="simple">			
			<div><label>角色名称</label><s:textfield label="" name="peopleName"/></div> 			
			<button class="btn">搜索</button>
			</s:form>
		</div>
-->
		<div class="container-fluid">
			<div class="row-fluid">  
				<div class="span12">
					<div class="widget-box">
						<div class="widget-title">
							<h5>用户信息</h5>
						</div>
						<div class="widget-content nopadding">
							<div id="DataTables_Table_0_wrapper" class="dataTables_wrapper" role="grid">
							<table id="DataTables_Table_0" class="table table-bordered table-striped table-hover data-table dataTable">
								<thead>
									<tr>
										<th>序号</th>										
										<th>角色名称</th>
										<th>添加时间</th>																	
									</tr>
								</thead>
								<tbody>
									<!-- 列表数据在这循环输出 -->
									<s:iterator value="jx_Roles" status="st">
										<tr>
											<td class="index"><s:property value="#st.index+1" /></td>											
											<td><a href="jx_role_bs_getPermissionEdit.action?roleIdPer=<s:property value="id"/>"><s:property value="name"/></a></td>
											<td><s:property value="add_date" /></td>																					
										</tr>
									</s:iterator>
								</tbody>
							</table>
							<div class="fg-toolbar ui-toolbar ui-widget-header ui-corner-bl ui-corner-br ui-helper-clearfix">
							<div class="dataTables_paginate fg-buttonset ui-buttonset fg-buttonset-multi ui-buttonset-multi paging_full_numbers">
								<div id="page-info">
									<div class="pagination nomargin">
									  <ul>
									    <li><a href="#">上一页</a></li>
									    <li class="active"><a href="#">1</a></li>
									    <li><a href="#">下一页</a></li>
									  </ul>
									</div>
								</div>
								<div class="pagecount">${totalNum}条 共${totalPage}页 </div>
							</div>
						</div>
					</div>						
				</div>
			</div>
		</div>
	</div>
			<div class="row-fluid">
				<div class="span12" id="footer">
					 
				</div>
			</div>
		</div>
	</div>
	<script>
	var pageNum = ${pageNum};
	var limit = ${limit};
	var totalPage = ${totalPage};
	
	$(function () {
		var page = new sshlma.Page({
			current:pageNum,
			total:totalPage,
			show:10,
			changetype:0,
			condition:{zhanghao:'${zhanghao}',name:'${name}',useState:'${useState}'},
			url:"jx_role_bs_getRoleList.action"
		});
		page.initPage();
	});
</script>
</body>
</html>