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
<title>湖北公安监管信息综合应用平台</title>
<jsp:include page="../jscss.jsp"></jsp:include>
<link href="<%=basePath%>inc/css/form_base.css" rel="stylesheet">
</head>
<body>

 	<div class="form_header">
	<h1>监所区域管理</h1>
	</div>
	<div id="content" style=" background:#EBEBEB;">
		<div id="breadcrumb">
			<a class="tip-bottom" href="detentionArea_list.action" title=""  data-original-title="回到主页"><i class="icon-home"></i>首页</a>
			<a class="current" >添加监所区域</a>
		</div>
        <div class="widget-box">
            <div class="widget-content nopadding">
            <s:form action="detentionArea_update.action" method="post">
								<s:hidden label="id" name="detentionArea.id"></s:hidden>
								<div class="form-row">
									<div class="detail control-group">
										<span><label class="label"><div class="redColor">*&nbsp;</div>区域编码</label>
										</span>
										<s:textfield label="区域编码" require="true" name="detentionArea.areaCode"></s:textfield>
									</div>
								</div>
								<div class="form-row">
									<div class="detail control-group">
										<span><label class="label"><div class="redColor">*&nbsp;</div>区域名称</label>
										</span>
										<s:textfield label="区域名称" require="true" name="detentionArea.detentionArea"></s:textfield>
									</div>
								</div>
								<div class="form-row">
									<div class="detail control-group">
										<span><label class="label">描述</label>
										</span>
										<s:textarea label="描述" style=" width:38.3%; height:150px;" name="detentionArea.detentionDesc"></s:textarea>
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