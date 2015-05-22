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

	<div id="content" style=" background:#EBEBEB;">
		<div id="breadcrumb">
			<a class="tip-bottom" href="#" title=""  data-original-title="回到主页"><i class="icon-home"></i>首页</a>
			<a class="current" >修改用户信息</a>
		</div>
        <div class="widget-box">
            <div class="widget-content nopadding">
              <s:form action="jx_user_bs_SaveUpdateUser.action" method="post">
						<s:hidden name="userId"></s:hidden>
								<div class="form-row">
									<div class="detail control-group">
										<span><label class="label">登录账号</label></span>
											<s:textfield  name="jx_User.username"  require="true" readOnly="readOnly"></s:textfield>											
									</div>
								</div>
								<div class="form-row">
									<div class="detail control-group">
										<span><label class="label"><div class="redColor">*&nbsp;</div>用户姓名</label></span>
										<s:textfield  name="jx_People.name"  require="true"><s:property value="jx_User.jx_People.name"/></s:textfield>
									</div>									
								</div>
								<div class="form-row">
									<div class="detail control-group"> 
										<span><label class="label"><div class="redColor">*&nbsp;</div>人员职务</label></span>										  
										<s:select name="jx_People.posttable.postId" list="posts" listKey="postId" listValue="postName" headerKey="" headerValue="--请选择--"></s:select> 
									</div>
								</div>		
<!--								<div class="form-row">-->
<!--									<div class="detail control-group">-->
<!--										<span><label class="label"><div class="redColor">*&nbsp;</div>所属部门</label>-->
<!--										</span>-->
<!--										<s:select name="jx_People.jx_department.id" list="dept_list" listKey="id" listValue="name" headerKey="" headerValue="--请选择--"></s:select> 										-->
<!--									</div>-->
<!--								</div>	-->
								<div class="form-row">									
									<div class="detail control-group">
										<span><label class="label">是否可用</label></span>
										<input type="radio" name="jx_User.state" value="1" <s:if test="jx_User.state==1">checked</s:if>>可用
										<input type="radio" name="jx_User.state" value="0" <s:if test="jx_User.state==0">checked</s:if>>禁用
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
		$("select").select2();
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