<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>湖北公安监管信息综合应用平台</title>
<jsp:include page="../jscss.jsp"></jsp:include>
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
						<s:form action="user_updateRole.action" method="post">
						<input type="hidden" value="<s:property value="user.id"/>" name="id"/>
								<div class="form-row">
									<div class="detail control-group">
										<span><label class="label">登录账号</label></span>
											<s:property value="user.username"></s:property>
									</div>
									<div class="detail control-group">
										<span><label class="label">用户姓名</label></span>
											<s:property value="user.name.name"></s:property>
									</div>
								</div>
								<div class="form-row">
									<div class="detail control-group">
										<span><label class="label">角色</label></span>
											<s:iterator value="roles" status="st">
												<input type="checkbox" name="roleIds" value="<s:property value="id"/>"/><s:property value="role"/>
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