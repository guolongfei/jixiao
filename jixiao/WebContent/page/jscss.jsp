<%@ page contentType="text/html; charset=utf-8" language="java" errorPage="" %>
<%@ taglib prefix="s" uri="/struts-tags"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">

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
<script>
	function changeHeight(){
		var windowHeight = document.documentElement.clientHeight;
		$('#content').css('minHeight', parseInt(windowHeight)-15);
	}
	$(function(){
		changeHeight();
	});
	window.onresize = function(){
		changeHeight();	
	}
	$(function(){
		if(top.location!=self.location){
			var thisWidth = parseInt($('.widget-content').find('.form-row').find('.detail').width())-237;
			$('.widget-content').find('input[type="text"]').width(thisWidth);
			$('.widget-content').find('select').width(thisWidth);
			$('.widget-content').find('textarea').width(thisWidth+442);
		}
	});
</script>
<!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->
