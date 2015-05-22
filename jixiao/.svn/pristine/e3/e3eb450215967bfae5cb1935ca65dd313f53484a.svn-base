<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<meta http-equiv="content-type" content="text/html; charset=utf-8">
		<script type="text/javascript" src="<%=basePath%>/js/jQuery.js"></script>
		<title>鄂州市干部实绩考核系统</title>
		<style>
body {
	margin: 0;
	padding: 0;
}

.left {
	width: 212px;
	height: 490px;
	float: left;
	background: url("<%=basePath%>/images/jkn_7.jpg") no-repeat;
}
.left_a{
	letter-spacing: 1px;
	background: url("<%=basePath%>/images/jkn_5.png") no-repeat;
	height: 33px;
	line-height: 30px;
	overflow: hidden;
	color: #fff;
	font-size:14px;
	font-weight:bold;
	padding-left: 28px;
}
body, div, dl, dt, dd, ul, ol, li, h1, h2, h3, h4, h5, h6, pre, code, form, fieldset, legend, input, textarea, p, blockquote, th, td { margin: 0; padding: 0; font-family:"宋体"}
table { border-collapse: collapse; border-spacing: 0; }
fieldset, img { border: 0; }
address, caption, cite, code, dfn, em, strong, th, var { font-style: normal; font-weight: normal; }
ol, ul { list-style: none; }
caption, th { text-align: left; }
.hidden { display: none; }
a{ text-decoration:none;}
</style>
		<style>
.subNavBox {
	width: 177px;
	text-align:center;
	font-size:15px;
	height:29px;
	color: #fff; 
}

.subNav {
	cursor: pointer;
	font-weight: bold;
	font-size: 15px;
	color: #fff;
	line-height: 28px;
	background:url("<%=basePath%>/images/jkn_8.png");
}

.subNav:hover {
	color: #ffff99;
	background:url("<%=basePath%>/images/jkn_10.png");
}

.currentDd {
	color: #ffff99;
}

.navContent {
	width:177px;	
	display: none;
	list-style: none;
	
}
.navContent li{
	border-bottom:1px dashed #e0e0e0;
}
.navContent li a {
	display: block;
	width: 177px;
	heighr: 29px;
	text-align: center;
	font-size: 13px;
	line-height: 29px;
	color: #cc3333;
	font-weight: bold;
}
.navContent li a:hover {
	color: #fff;
	background:#ff2d2d;
	width: 177px;
	heighr: 29px;
	text-align: center;
	font-size: 13px;
	line-height: 29px;
	text-align: center;
}
</style>
		<script type="text/javascript">
	$(function() {
		$(".subNav").click(
				function() {
					$(this).toggleClass("currentDd").siblings(".subNav")
							.removeClass("currentDd")
					$(this).toggleClass("currentDt").siblings(".subNav")
							.removeClass("currentDt")

					// 修改数字控制速度， slideUp(500)控制卷起速度
					$(this).next(".navContent").slideToggle(500).siblings(
							".navContent").slideUp(500);
				})
	})
</script>
	</head>

	<body style="background:url('<%=basePath%>/images/jkn_2.jpg') repeat-x;">
		<div class="left_a">
			菜单栏目
		</div>
		<div class="left">
			<table width="200" align="center" cellpadding="0" cellspacing="0"
				style="margin-top: 20px;">
				<tr>
					<td align="center">
							<div class="subNavBox">
			<div class="subNav">
				填写实绩
			</div>
			<div class="subNav">
				实绩管理
			</div>
			<ul class="navContent">
				<li id="navc">
					<a>日记管理</a>
				</li>
				<li>
					<a href="#">月小结管理</a>
				</li>
				<li>
					<a href="#">月度评价查询</a>
				</li>
				<li>
					<a href="#">年考核管理</a>
				</li>
				<li>
					<a href="#">突出成果管理</a>
				</li>
				<li>
					<a href="#">季度总结查询</a>
				</li>
			</ul>
			<div class="subNav">
				考核查询
			</div>
			<ul class="navContent">
				<li>
					<a href="#">社会考评查询</a>
				</li>
				<li>
					<a href="#">季度考核查询</a>
				</li>
				<li>
					<a href="#">领导考评查询</a>
				</li>
				<li>
					<a href="#">年度考评查询</a>
				</li>
			</ul>
			<div class="subNav">
				考廉查询
			</div>
			<div class="subNav">
				考学查询
			</div>		
			<div class="subNav">
				考勤管理
			</div>
			<div class="subNav">
				政策查询
			</div>
			<div class="subNav">
				审核管理
			</div>
			<div class="subNav">
				个人设置
			</div>
		</div>
					</td>
				</tr>
				<tr>
				</tr>
			</table>
		</div>
	
	</body>
</html>
