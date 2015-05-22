<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>鄂州实绩考核网</title>
    <link href="<%=basePath%>kindeditor/themes/default/default.css" rel="stylesheet"/>
	<link rel="stylesheet" href="<%=basePath%>kindeditor/plugins/code/prettify.css" />
	<script src="<%=basePath%>kindeditor/kindeditor.js"></script>
	<script src="<%=basePath%>kindeditor/lang/zh_CN.js"></script>
	<script src="<%=basePath%>kindeditor/plugins/code/prettify.js"></script>
	<style type="text/css">
		body{
			background: url("<%=basePath%>images/jkn_2.jpg") repeat-x;
		}
		.cmdFiled{
			border:0px;
			background: url("<%=basePath%>images/bg_rectbtn.png") no-repeat;
			overflow: hidden;
			width: 67px;
			color:#fff;
			line-height: 27px;
			height: 27px;
			cursor: pointer;
			font-size: 14px;
			font-weight: bold;
		}
	</style>
	<SCRIPT type="text/javascript">
		function release(){
			var message = document.getElementById("message").value;
			if(message==""){
				alert("请您输入考核办法！");
				return false;
			}
			else{
				alert("考核办法发布成功！");
				document.getElementById("f").action = "<%=basePath%>/messageManage/employee_getAddRule.action";
				document.getElementById("f").submit();
			}
		}
	</SCRIPT>
  </head>

  <body>
    	<table cellpadding="0" cellspacing="0" width="95%" style="background-color: white;">
    		<tr>
    			<td>
    				<div style="width: 90%;height: 50px;margin: 0 auto;">
    					<div style="float: left"><img alt="" src="<%=basePath%>images/log.png" width="50px" height="50px"/></div>
    					<div style="font-family: 微软雅黑;font-weight: bolder;font-size: 1.0em;float: left;line-height: 50px;color: #235C9D;">发布考核办法 </div>
    				</div>
    			</td>
    		</tr>
    		<tr>
    			<td>
    				<form id="f" method="post">
    					<div style="width: 90%;height: 480px;margin: 0 auto;">
    						<div style="width: 100%;height: 50px;text-align: center;line-height: 50px;font-size: 20px;color:#235C9D;font-weight: bold;border: 1 solid #cccccc;border-bottom: none;">
    							 <%=request.getSession().getAttribute("deptName")%>考核细则办法
    						</div>
    						<div style="width: 100%;height: 400px;">   							
								<textarea id="message" name="content" cols="100" rows="8" style="width:996px;height:390px;"></textarea>							
    						</div>
    						<div style="display: none;">
    							<textarea rows="" cols="" name="departmentId"><%=request.getSession().getAttribute("deptId")%></textarea>
    						</div>
    						<div style="width: 100%;height: 30px;margin: 0 auto;text-align: center;line-height: 30px;">
    							<button id="pfsubmit" class="cmdFiled" onclick="release()">保存</button>
    						</div>
    					</div>
    				</form>
    			</td>
    		</tr>
    	</table>
  </body>
  <SCRIPT type="text/javascript">
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
  </SCRIPT>
</html>
