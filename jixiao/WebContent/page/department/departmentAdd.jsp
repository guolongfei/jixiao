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
<link href="<%=basePath%>inc/css/lib/bootstrap.min.css" rel="stylesheet">
<link href="<%=basePath%>inc/css/lib/bootstrap-responsive.min.css" rel="stylesheet">
<link href="<%=basePath%>inc/css/lib/hoyo.main.css" rel="stylesheet">
<link href="<%=basePath%>inc/css/lib/hoyo.blue.css" rel="stylesheet">
<link href="<%=basePath%>inc/css/header.css" rel="stylesheet">
<link href="<%=basePath%>inc/css/form.css" rel="stylesheet">
<link href="<%=basePath%>inc/js/lib/select/select2.css" rel="stylesheet">
<link href="<%=basePath%>inc/css/form_base.css" rel="stylesheet">
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
</head>
<body>
 	<div class="form_header">
	<h1 style="color: #235C9D;">添加部门信息</h1>
	</div>
	<div style=" background:#EBEBEB;height: 500px;">
		<div id="breadcrumb">
			<a class="tip-bottom" href="detentionArea_list.action" title=""  data-original-title="回到主页"><i class="icon-home"></i>首页</a>			
			<a class="current" >添加下级部门</a>
		</div>
        <div class="widget-box">
            <div class="widget-content nopadding">
             <s:form action="jx_department_bs_addDepartment.action" method="post">
								<div class="form-row">
									<div class="detail control-group">
										<span><label class="label"><div class="redColor">*&nbsp;</div>部门名称</label></span>										  
										<s:textfield label="部门名称" require="true" name="jx_department.name"></s:textfield>
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
					$('form').submit();
				}
			});
		});
		
	</script>
		
	
</body>

</html>
