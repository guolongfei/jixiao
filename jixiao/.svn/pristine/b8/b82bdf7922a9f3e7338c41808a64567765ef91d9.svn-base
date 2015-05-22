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
<title>鄂州实绩考核系统</title>
<link rel="shortcut icon" href="<%=basePath%>inc/css/img/icon/fav.ico" />
<link href="<%=basePath%>inc/css/lib/bootstrap.min.css" rel="stylesheet">
<link href="<%=basePath%>inc/css/lib/bootstrap-responsive.min.css" rel="stylesheet">
<link href="<%=basePath%>inc/css/lib/hoyo.main.css" rel="stylesheet">
<link href="<%=basePath%>inc/css/lib/hoyo.blue.css" rel="stylesheet">
<link href="<%=basePath%>inc/css/header.css" rel="stylesheet">
<link href="<%=basePath%>inc/css/form.css" rel="stylesheet">
<link href="<%=basePath%>inc/js/lib/select/select2.css" rel="stylesheet">
<script src="<%=basePath%>inc/js/lib/jquery.min.js"></script>
<script src="<%=basePath%>inc/js/lib/jquery-ui.min.js"></script>
<script src="<%=basePath%>inc/js/lib/bootstrap.min.js"></script>
<script src="<%=basePath%>inc/js/lib/hoyo.js"></script>
<script src="<%=basePath%>inc/js/lib/sshlma.js"></script>
<script src="<%=basePath%>inc/js/lib/datepicker/WdatePicker.js"></script>
<script src="<%=basePath%>inc/js/lib/validator.js"></script>
<script src="<%=basePath%>inc/js/lib/sha1.js"></script>
<script src="<%=basePath%>inc/js/lib/select/select2.js"></script>
<script src="<%=basePath%>inc/js/lib/select/select2_locale_zh-CN.js"></script>
<style type="text/css">
.checkboxLabel{
	display:inline;
}

</style>
</head>
<body>
	<div id="content">
		<div id="content-header">
			<h1>用户管理</h1>
			<div class="btn-group" style="width: auto;">
			</div>
		</div>
		<div id="breadcrumb">
			<a class="tip-bottom" href="user_select.action" title=""><i class="icon-home"></i>首页</a>
			<a class="current">用户信息</a>
		</div>
		<div class="container-fluid">
			<div class="row-fluid">
				<div class="span12">
					<div class="widget-box">
						<div class="widget-title">
							<span class="icon">
								<i class="icon-align-justify"></i>									
							</span>
							<h5>用户信息</h5>
						</div>
						<div class="widget-content nopadding">
						<s:form action="jx_user_updateRole.action" method="post">
						<input type="hidden" value="<s:property value="jx_User.id"/>" name="jx_User.id"/>
								<div class="form-row">
									<div class="detail control-group">
										<span><label class="label">登录账号</label></span>
											<s:property value="jx_User.username"></s:property>
									</div>
									<div class="detail control-group">
										<span><label class="label">用户姓名</label></span>
											<s:property value="jx_User.jx_people.name"></s:property>
									</div>
								</div>
								<div class="form-row">
									<div class="detail control-group">
										<span><label class="label">角色</label></span>
											<s:iterator value="jx_Roles" status="st">
												<input type="checkbox" name="roleIds" value="<s:property value="id"/>"/><s:property value="name"/>
											</s:iterator>
									</div>
								</div>
							</s:form>
							<div class="form-actions">
								<button class="btn btn-primary">保存</button>
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
			var preJson = '${checkstring}';
			var array = preJson.split(',');
			for(var i in array){
				if(array[i] != ''){
					$('input[name="roleIds"][value="'+array[i]+'"]').attr('checked',true);
				}
			}
			$('.form-actions button').click(function(){
				if(!validateForm('form')){
					return false;
				}else{
					$('form').submit();
				}
			});
		});
	</script>
</body>
</html>