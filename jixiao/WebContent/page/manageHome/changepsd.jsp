<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>鄂州实绩考核系统</title>
		<script type="text/javascript" src="<%=basePath%>js/jQuery.js"></script>
		<STYLE type="text/css">

</STYLE>
		<script type="text/javascript">
		$(document).ready(function(){
				if($("#error").val()==1){
					alert("密码修改成功!");
				}
				else if($("#error").val()==2){
					$("#hint").css("display","block");
					$("#hint").html("输入的旧密码不正确！");
					$("#tis").css("display","none");
					$("#two").css("display","none");
				}
		});
	
		$(function(){
			$("#sub").click(function(){
				if($("#OldPassword").val()==""){
					$("#hint").css("display","block");
					$("#hint").html("请输入旧密码！");
					$("#tis").css("display","none");
					$("#two").css("display","none");
					return;
				}
				else if($("#NewPassword").val()==""){
					$("#tishi1").css("display","block");
					$("#tishi1").html("请输入您要修改的密码！");
					$("#hint").css("display","none");
					$("#tishi2").css("display","none")
					return;
				}
				else if($("#NewPassword").val()!=$("#confirm").val()){
					$("#tishi2").css("display","block");
					$("#tishi2").html("两次输入的密码不一致！");
					$("#hint").css("display","none");
					$("#tishi1").css("display","none");
					return;
				}
				else{
					document.getElementById("f").action = "<%=basePath%>messageManage/homePage_updatePsd.action?userId=<%=request.getSession().getAttribute("userId")%>";
					document.getElementById("f").submit();
				}			
			});			
		});
		
	</script>
		<style type="text/css">
body {
	margin:0;
	padding:0;
	background: url("<%=basePath%>images/jkn_2.jpg") repeat-x;
}
input {
	width: 160px;
}
</style>
	</head>

	<body>


		<table cellpadding="0" cellspacing="0" width="95%" height="515"
			style="background-color: #F1F6FA;">
			<tr>
				<td>
					<form id="f" method="post">
						<table cellpadding="0" cellspacing="0" border="0" height="200"
							style="margin: 0 auto; vertical-align: middle;" width="350"
							bgcolor="#acd6ff">
							<tr>
								<td colspan="2" align="center"
									style="background-color:#46A3FF;color:white; font-weight: bold;">
									密码修改
								</td>
							</tr>
							<tr>
								<td align="center" width="100">
									旧密码:
								</td>
								<td width="250">
									<input id="OldPassword" name="password" type="password" />
								</td>
							</tr>
							<tr id="old" style="color: red; font-size: 14px;">
								<td colspan="2" id="hint"
									style="padding-left: 100px; display: none;"></td>
							</tr>
							<tr>
								<td align="center">
									新密码:
								</td>
								<td>
									<input id="NewPassword" name="NewPassword" type="password" />
								</td>
							</tr>
							<tr id="tis" style="color: red; font-size: 14px;">
								<td colspan="2" id="tishi1"
									style="padding-left: 100px; display: none;"></td>
							</tr>
							<tr>
								<td align="center">
									确认密码:
								</td>
								<td>
									<input id="confirm" type="password" />
								</td>
							</tr>
							<tr id="two" style="color: red; font-size: 14px;">
								<td colspan="2" id="tishi2"
									style="padding-left: 100px; display: none;"></td>
							</tr>
							<tr>
								<td></td>
								<td>
									<input id="sub" type="button" value="提交"
										style="text-align: center;font-size: 14px; border: none; color: white; font-weight: bold;background-color: #46A3FF;" />
								</td>
							</tr>
						</table>
						<div style="display: none;">
							<input id="error" type="text" value="<s:property value='error'/>" />
						</div>
					</form>
				</td>
			</tr>
		</table>

	</body>
</html>
