<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>鄂州市绩效考核网</title>
<jsp:include page="../jscss.jsp"></jsp:include>
<link href="/jixiao/inc/css/form_base.css" rel="stylesheet">
</head>
<body>
 	
	<div id="content" style=" background:#EBEBEB;">
		<div id="breadcrumb">
			<a class="tip-bottom" href="#" title=""  data-original-title="回到主页"><i class="icon-home"></i>首页</a>			
			<a class="current" >添加角色</a>
		</div>
        <div class="widget-box">
            <div class="widget-content nopadding">
               <s:form action="jx_role_bs_SaveAddRole.action" method="post">
					<div class="form-row">
						<div class="detail control-group">
							<span><label class="label"><div class="redColor">*&nbsp;</div>角色名称</label></span>										  
							<s:textfield label="部门名称" require="true" name="jx_Role.name"></s:textfield>
						</div>
					</div>								
<!--					<div class="form-row">-->
<!--						<div class="detail control-group">-->
<!--							<span><label class="label"><div class="redColor">*&nbsp;</div>启用状态</label></span>										  -->
<!--							<s:select list="#{0:'禁用'}" name="jx_Role.state" listKey="key" listValue="value"  headerKey="1" headerValue="启用"></s:select>-->
<!--						</div>-->
<!--					</div>									-->
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
