<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>鄂州市绩效考核网</title>
<jsp:include page="../jscss.jsp"></jsp:include>
<link href="<%=basePath%>inc/css/form_base.css" rel="stylesheet">
</head>
<body>
 	<div class="form_header">
	<h1 style="color: #cccccc;">添加用户</h1>
	</div>
	<div id="content" style=" background:#EBEBEB;">
		<div id="breadcrumb">
			<a class="tip-bottom" href="#" title=""  data-original-title="回到主页"><i class="icon-home"></i>首页</a>			
			<a class="current" >添加用户</a>
		</div>
        <div class="widget-box">
            <div class="widget-content nopadding">
             <s:form id="f" method="post">
								<div class="form-row">
									<div class="detail control-group">
										<span><label class="label"><div class="redColor">*&nbsp;</div>人员名称</label></span>		 								  
										<s:textfield label="部门名称" require="true" name="jx_People.name"></s:textfield>
									</div>
								</div>
								<div class="form-row">
									<div class="detail control-group"> 
										<span><label class="label"><div class="redColor">*&nbsp;</div>人员职务</label></span>										  
										<s:select name="jx_People.posttable.postId" list="posts" listKey="postId" listValue="postName" headerKey="" headerValue="--请选择--"></s:select> 
									</div>
								</div>		
								<div class="form-row">
									<div class="detail control-group">
										<span><label class="label"><div class="redColor">*&nbsp;</div>所属部门</label>
										</span>
										<s:select name="jx_People.jx_department.id" list="dept_list" listKey="id" listValue="name" headerKey="" headerValue="--请选择--"></s:select> 										
									</div>
								</div>	
								<div class="form-row">
									<div class="detail control-group">
										<span><label class="label"><div class="redColor">*&nbsp;</div>帐号名称</label></span>										  
										<s:textfield label="帐号名称" require="true" name="jx_User.username"></s:textfield>
										<s:if test="errorType==0"><label style="color: red;">用户名已存在！</label></s:if>
									</div>
								</div>
								<div class="form-row">
									<div class="detail control-group">
										<span><label class="label"><div class="redColor">*&nbsp;</div>默认密码</label></span>										  
										<span><label>123456</label></span>
									</div>
								</div>
								<div class="form-row">
									<div class="detail control-group">
										<span><label class="label"><div class="redColor">*&nbsp;</div>启用状态</label></span>										  
										<s:select list="#{0:'禁用'}" name="jx_User.state" listKey="key" listValue="value"  headerKey="1" headerValue="启用"></s:select>
									</div>
								</div>									
							</s:form>
                <div class="form-actions">
                    <button class="form_save_btn"></button>
                </div>
            </div>
        </div>
	</div>	
	<script>
		$(function(){
			$('.form-actions button').click(function(){
				if(!validateForm('form')){
					return false;
				}else{
					$('#f').attr("action","../jx_user/jx_user_bs_SaveAddUser.action");					
					$('form').submit();
				}
			});
		});
		
	</script>
		
	
</body>

</html>
