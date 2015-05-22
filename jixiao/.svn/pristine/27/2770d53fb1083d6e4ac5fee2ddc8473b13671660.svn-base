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
<link href="<%=basePath%>inc/css/form_base.css" rel="stylesheet">
<link href="<%=basePath%>kindeditor/themes/default/default.css" rel="stylesheet"/>
<link rel="stylesheet" href="<%=basePath%>kindeditor/plugins/code/prettify.css" />
<script src="<%=basePath%>kindeditor/kindeditor.js"></script>
<script src="<%=basePath%>kindeditor/lang/zh_CN.js"></script>
<script src="<%=basePath%>kindeditor/plugins/code/prettify.js"></script>

<SCRIPT type="text/javascript">
   $(function(){
      if('${errorMsg}'=="success"){
        alert("信息保存成功!!");
      }
      $(".mm").click(function(){
          var va = $("input[type='radio'][name='basicSetUp.ischain']:checked").val();
	      if(va == 1){
	         $("#address").removeAttr("disabled");
	      }else{
	         $("#address").attr("disabled","disabled");
	      }
      });
      $('.form-actions button').click(function(){
				if(!validateForm('form')){
					return false;
				}else{					
					$('form').submit();
				}
	  });
   });
</SCRIPT>
</head>
<body>
 	<div class="form_header">
	<h1 style="color: #c22626;">基础信息设置</h1>
	</div>
	<div id="content" style=" background:#EBEBEB;">
		<div id="breadcrumb">
			<a class="tip-bottom" href="detentionArea_list.action" title=""  data-original-title="回到主页"><i class="icon-home"></i>首页></a>			
			<a class="current" >设置基础信息</a>
		</div>
        <div class="widget-box">
            <div class="widget-content nopadding">
             <s:form action="/messageManage/message_basicSetUp.action" method="post" enctype="multipart/form-data">
								<div class="form-row">
									<div class="detail control-group">
										<span><label class="label"><div class="redColor">*&nbsp;</div>标题</label></span>
										  
										<input label="区域编码" require="true" name="basicSetUp.setup_title"/>
									</div>
								</div>
								<div class="form-row">
									<div class="detail control-group">
										<span><label class="label"><div class="redColor">*&nbsp;</div>添加链接</label></span>
										<input type="radio" name="basicSetUp.ischain" value="1" class="mm"/>是
										<input type="radio" name="basicSetUp.ischain" value="0" checked="checked" class="mm"/>否
									</div>
								</div>
								<div class="form-row">
									<div class="detail control-group">
										<span><label class="label"><div class="redColor">*&nbsp;</div>链接地址</label></span>
										<input label="区域编码" require="true" name="basicSetUp.chain_adress" disabled="disabled" id="address"/>
									</div>
								</div>	
								<div class="form-row">
									<div class="detail control-group">
										<span><label class="label"><div class="redColor">*&nbsp;</div>信息类型</label></span>
										<select  name="basicSetUp.setup_type">
										  <option value="1">基础信息</option>
										</select>
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

	</script>
	
</body>

</html>
