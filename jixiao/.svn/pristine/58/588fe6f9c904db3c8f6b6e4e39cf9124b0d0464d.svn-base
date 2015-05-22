<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta name="viewport" content="user-scalable=yes">
		<meta charset="utf-8">
		<meta name="apple-mobile-web-app-capable" content="yes">
		<title>IP数字对讲系统管理平台——登录</title>
		<link type="text/css" href="../inc/css/jquery.msgbox.css"
			rel="stylesheet">
		<script src="../inc/js/lib/jquery.min.js"></script>
		<script src="../inc/js/lib/sha1.js"></script>
		<script src="../inc/js/lib/jquery.msgbox.min.js"></script>
		<script src="../inc/js/lib/bootstrap.min.js"></script>
		<script src="../inc/js/lib/jquery.placeholder.1.3.min.js"></script>


		<STYLE type="text/css">
#content {
	clear: both;
	height: 75%;
	width: 780px;
	margin: auto;
}


#footer {
	clear: both;
	margin: auto;
	margin-top:15%;
	height: 24px;
	text-align: center;
	color: #627990;
	font-family: arial;
	font-size: 12px;
}

body {
	background: url("../inc/css/img/login/bg.png") repeat;
}

#content .texts {
	text-align: center;
	margin-top: 12px;
	color: #E9F5FD;
	font-size: 50px;
	font-weight: bold;
	font-family: 黑体;
}

#content .box {
	margin: 0 auto;
	margin-top: 30px;
	height: 66px;
	width: 202px;
	background: url("../inc/css/img/login/login(1).png") no-repeat;
	background-size: 202px 66px;
}

#content .box input[type=text],#content .box input[type=password] {
	height: 22px;
	border: none;
	background: #EFF5F9;
	margin: 4px 0 1px 38px;
	width: 150px;
	text-indent: 2px;
	line-height: 22px;
}

#content .btn_box {
	text-align: center;
	margin-top: 18px;
}

#content .btn_box .certificate_login {
	width: 98px;
	height: 38px;
	border: none;
	background: url("../inc/css/img/button3(1).png") no-repeat;
	background-size: 98px 38px;
}

#content .btn_box .certificate_login:hover {
	background: url("../css/img/button2(1).png") no-repeat;
	background-size: 98px 38px;
}

#content .btn_box .fingerprint_login {
	width: 98px;
	height: 38px;
	border: none;
	background: url("../inc/css/img/button1(1).png") no-repeat;
	background-size: 98px 38px;
}

#content .btn_box .fingerprint_login:hover {
	background: url("../inc/css/img/button4(1).png") no-repeat;
	background-size: 98px 38px;
}

#content .login_button {
	text-align: center;
	margin-top: 30px;
}

#content .login_button .login_btn {
	width: 106px;
	height: 106px;
	border: none;
	background: url("../inc/css/img/login_btn2(1).png") no-repeat;
	background-size: 106px 106px;
	cursor: pointer;
}

#content .login_button .login_btn:hover {
	background: url("../inc/css/img/login_btn1(1).png") no-repeat;
	background-size: 106px 106px;
}


</STYLE>


		<SCRIPT>
   
function login(){ 
	var user_Name = $("#user_Name").val();
	var password = $("#password").val();
	if(user_Name==""||user_Name==null){
		$.msgbox("用户名不能为空。",{buttons : [{type: "cancel", value: "确定"}]});
		return;
	}
	else if(password==""||password==null){
		$.msgbox("密码不能为空。",{buttons : [{type: "cancel", value: "确定"}]});
		return;
	}
	
		var is_save = 2;    
		document.getElementById("f").action="../messageManage/homePage_Login.action";
		document.getElementById("f").submit();
}

    </script>



	</head>
	<body>
		<div style="height: 200px"></div>
		<div id="content">
			<div class="texts" style="font-family: 华文新魏;">
				IP数字对讲系统管理平台
			</div>
			<br/><br/><br/><br/><br/><br/>
			<div class="texts" style="font-family: 华文新魏;">
				
			</div>
			<form id="f" method="post">
				<div class="box">
					<input id="user_Name" name="user_Name" type="text" value="<% if(request.getSession().getAttribute("userName")!=null){%><%= request.getSession().getAttribute("userName") %><%}%>" placeholder="用户名" />
					<input id="password" name="password" type="password" value="<% if(request.getSession().getAttribute("password")!=null){%><%= request.getSession().getAttribute("password") %><%}%>"
						placeholder="密码" />
				</div>
				<div class="btn_box">
					<!--        	<input id="certificate_login" class="certificate_login" name="" type="button" value="" style="padding:0;">-->
					<!--            <input id="fingerprint_login" class="fingerprint_login" name="" type="button" value="" style="padding:0;">-->
				</div>
				<div class="login_button">
					<input id="button" class="login_btn" name="" type="button" value=""
						onclick="login()">
				</div>
			</form>
		</div>
		<div id="footer">
			©2015 武汉三际物联网络科技有限公司版权所有
		</div>

	</body>
</html>