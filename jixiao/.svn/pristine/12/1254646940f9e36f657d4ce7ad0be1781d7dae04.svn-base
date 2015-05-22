<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>  
<%
	String power=(String)session.getAttribute("key");
%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>鄂州市实绩考核系统</title>

<STYLE type="text/css">
	.cmdFiled{
			border:0px;
			background: url("<%=basePath%>images/bg_rectbtn.png") no-repeat;
			overflow: hidden;
			width: 67px;
			color:#fff;
			line-height: 27px;
			height: 27px;
			cursor: pointer;
			font-size: 14px;
			font-weight: bold;
		}
</STYLE>
<jsp:include page="../jscss.jsp"></jsp:include>
</head>
<body>
	<div id="content" style="height: 520px;">
		<div id="content-header">
			<h1>部门管理</h1>
			<div class="btn-group" style="width: auto;">
				
				<a id="delbtn" title="" href="#" class="btn btn-danger">删除</a>
				
				<a id="updatebtn" title="修改部门名称" class="btn btn-primary">修改</a> 							
				
			</div>
		</div>
		<div id="breadcrumb">
			<a class="current" href="#" style="text-decoration: none;">部门信息</a>
		</div>
		<div class="container-fluid">
			<div class="row-fluid">
				<div class="span12">
					<div class="widget-box">
                         <div class="widget-title">
                             <span class="icon"><i class="icon-align-justify"></i></span>
                             <h5>部门详细信息</h5>
                         </div>
                         <div class="widget-content  nopadding">
							<div class="detail_row">
								<div class="detail_item" style="width: 60%;">
									<label>部门名称:</label>
									<div id="sh_name">
										<s:property value="jx_department.name"></s:property>
									</div>
									<div id="up_name" style="display: none;">
									<form id="f" method="post">
											<input name="name" type="text" value="<s:property value='jx_department.name'/>"/>　　<button id="pfsubmit" class="cmdFiled">保存</button>
									</form>										
									</div>													
								</div>
							</div>							
							<div class="form-actions nomargin">
								<a href="<%=basePath%>jx_department/jx_department_bs_gotoDepartmentList.action"  class="btn btn-primary">返回</a>
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
$(function(){
//删除事件
	$("#delbtn").click(function(){
		if(confirm("你确定要删除该信息吗？")){
			window.location.href ="<%=basePath%>jx_department/jx_department_bs_deleteDepartment.action?dept_id=<s:property value='jx_department.id'/>";
		}
	});
//修改事件	
	$("#updatebtn").click(function(){
		$("#sh_name").css("display","none");
		$("#up_name").css("display","block");		
	});	
	$("#pfsubmit").click(function(){
		$("#f").attr("action","<%=basePath%>jx_department/jx_department_bs_updateDepartment.action?dept_id=<s:property value='jx_department.id'/>");
		$("#f").submit();
	});
});
</script>
</body>
</html>