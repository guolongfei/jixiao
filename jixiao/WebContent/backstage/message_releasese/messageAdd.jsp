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
<script src="<%=basePath%>datepicker/WdatePicker.js"></script>
<link href="<%=basePath%>datepicker/WdatePicker.css"/>
</head>
<body>
 	<div class="form_header">
	<h1 style="color: #235C9D;">信息发布管理</h1>
	</div>
	<div id="content" style=" background:#EBEBEB;">
		<div id="breadcrumb">
			<a class="tip-bottom" href="detentionArea_list.action" title=""  data-original-title="回到主页"><i class="icon-home"></i>首页></a>			
			<a class="current" >添加发布信息</a>
		</div>
        <div class="widget-box">
            <div class="widget-content nopadding">
             <s:form action="message_bs_SaveAdd.action" method="post" enctype="multipart/form-data">
								<div class="form-row">
									<div class="detail control-group">
										<span><label class="label"><div class="redColor">*&nbsp;</div>标题</label></span>
										  
										<s:textfield label="区域编码" require="true" name="messageRelease.title"></s:textfield>
									</div>
								</div>
								<div class="form-row">
									<div class="detail control-group">
										<span><label class="label">作者</label></span>
										<s:textfield label="区域编码" name="messageRelease.author"></s:textfield>

									</div>
								</div>
								<div class="form-row">
									<div class="detail control-group">
										<span><label class="label">消息来源</label></span>
										<s:textfield label="区域编码" name="messageRelease.messageFrom"></s:textfield>
									</div>
								</div>
								<div class="form-row">
									<div class="detail control-group">
										<span><label class="label"><div class="redColor">*&nbsp;</div>信息摘要</label>
										</span>
										<s:textfield label="区域名称" name="messageRelease.summary" value=""></s:textfield>
									</div>
								</div>
								<div class="form-row">
									<div class="detail control-group">
										<span><label class="label"><div class="redColor">*&nbsp;</div>信息类型</label>
										</span>
										<s:select onchange="showRule();" id="state" name="messageRelease.messageType.type_id" list="listmt" listKey="type_id" listValue="type_name" ></s:select> 
										
									</div>
								</div>
								<div id="tupian" class="form-row"  style="display: none">
									<div class="detail control-group">
										<span><label class="label"><div class="redColor">*&nbsp;</div>上传图片</label>
										</span>
										<input type="file" name="file1" >
										<!--<s:select  id="state1" name="messageRelease.rule_type" list="listrt" listKey="rule_id" listValue="rule_name" ></s:select> -->
										
									</div>
								</div>
								<div class="form-row">
									<div class="detail control-group">
										<span><label class="label">发布时间</label>
										</span>
										<input style="width: 200px; height:21px; overflow: hidden;" id="startTime" class="TextBoxStyle"  
				 			name="messageRelease.add_time" value=""	
					onfocus="WdatePicker({el:'startTime',dateFmt:'yyyy-MM-dd HH:mm:ss',onpicked:function(){},isShowClear:false});" />
									</div>
								</div>
								<div class="form-row">
									<div class="detail control-group">
										<span><label class="label">内容</label>
										</span>
										<s:textarea label="描述" id="mrc"  style=" width:38.3%; height:150px;display:none;"  name="messageRelease.content" value=""></s:textarea>										
									</div>
									<textarea name="content" cols="100" rows="8" style="width:700px;height:400px;"></textarea>
								</div>
								<div class="form-row">
									<div class="detail control-group">
										<span><label class="label">附件：<input type="file" name="file"></label>
										</span>
										
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
	
	function showRule()
	{
	    var type=$("#state").val();
	    if(type==2)
	    {
	        $("#tupian").show();
	    }
	    else
	    {
	        $("#tupian").hide();
	    }
	}
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
		<script>
		//var editor1;
		KindEditor.ready(function(K) {
			var editor1 = K.create('textarea[name="content"]', {
				cssPath : '<%=basePath%>kindeditor/plugins/code/prettify.css',
				uploadJson : '<%=basePath%>kindeditor/jsp/upload_json.jsp',
				fileManagerJson : '<%=basePath%>kindeditor/jsp/file_manager_json.jsp',
				allowFileManager : true,
				afterCreate : function() {
					var self = this;
					K.ctrl(document, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
					K.ctrl(self.edit.doc, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
				},
				afterBlur: function(){
					this.sync();
					$("#mrc").val($("textarea[name='content']").val());
				}
			});
			prettyPrint();
		});
	</script>
	
</body>

</html>
