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
				<a title="" href="jx_user_bs_gotoAddUser.action" class="btn btn-primary " >添加</a>			
			</div>
		</div>
<!--		<div id="breadcrumb">-->
<!--			<a class="tip-bottom" title="" href="user_select.action"><i class="icon-home"></i>首页</a>-->
<!--			<a class="current" >用户信息列表</a>-->
<!--		</div>-->
<!-- 
		<div class="searcharea">
			<s:form action="user_select.action" method="post" id="myform" theme="simple">
			<div><label>登录账号</label><s:textfield label="" name="userName"/></div>
			<div><label>用户姓名</label><s:textfield label="" name="peopleName"/></div> 
			<div><label>部门</label><s:select name="deptId" list="dept_list" listKey="id" listValue="name" headerKey="0" headerValue="本级部门"/></div>
			<div><label>是否启用</label><s:select name="userState" list="#{1:'启用',2:'禁用'}"   headerKey="0" headerValue="--请选择--"/></div>
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
										<th>登录账号</th>
										<th>用户姓名</th>
										<th>职位</th>
										<th>部门</th>
										<th>创建时间</th>
										<th>是否启用</th>										
									</tr>
								</thead>
								<tbody>
									<!-- 列表数据在这循环输出 -->
									<s:iterator value="jx_Users" status="st">
										<tr>
											<td class="index"><s:property value="#st.index+1" /></td>											
											<td><a href="jx_user_bs_gotoUserDetail.action?userId=<s:property value="id"/>" style="text-decoration: underline;cursor: pointer;color: blue;"><s:property value="username" /></a></td>
											<td><s:property value="jx_people.name" /></td>
											<td><s:property value="jx_people.posttable.postName"/></td>
											<td><s:property value="jx_people.jx_department.name"/></td>
											<td><s:date name="add_date" format="yyyy-MM-dd"/></td>
											<td><s:if test="state==1">启用</s:if>
												<s:else>停用</s:else>											
											</td>											
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
			url:"jx_user_bs_gotoUserListPage.action"
		});
		page.initPage();
	});
</script>
</body>
</html>