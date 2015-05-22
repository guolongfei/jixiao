<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String power=(String)session.getAttribute("key");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<meta http-equiv="content-type" content="text/html; charset=utf-8">
		<title>鄂州市干部实绩考核系统</title>
		<script src="<%=basePath%>js/clock.js" type="text/javascript"></script>
		<script src="<%=basePath%>js/jQuery.js" type="text/javascript"></script>
	</head>
	<style>
body {
	margin: 0;
	padding: 0;
}

.top {
	background: url(<%=basePath%>/images/jkn_1.jpg) repeat-x;
	height: 111px;
	margin: 0 auto;
	width: 100%;
}

.top_a {
	height: 81px;
}
.top_a span {
	margin-right: 40px;
	float: right;
}
.top_b {
	height: 30px;
	line-height: 30px;
	color: #235C9D;
	font: 16px/ 30px 'Microsoft YaHei', 'SimHei';
	padding: 0px 30px;
	letter-spacing: 1px;
}

.top_b span {
	float: right;
}

.top_b span a {
	color: #235C9D;
	font: 16px/ 30px 'Microsoft YaHei', 'SimHei';
}
</style>
	<body>
		<div class="top">
			<div class="top_a">
				<span class="top_a_a"> 
				<iframe allowtransparency="true"
						frameborder="0" width="255" height="75" scrolling="no"
						src="http://tianqi.2345.com/plugin/widget/index.htm?s=1&z=1&t=1&v=0&d=1&k=&f=2&q=1&e=1&a=1&c=57476&w=255&h=81"></iframe>
					<a class="exit" onclick="LoginOut()">			
					  		<img src="images/jkn_3.png" style=""/>					  		
				 	</a>			
				</span>
				 
					  
				 <!--  <img src="<%=basePath%>images/ez_logo.png" style="margin-top: 15px;margin-left: 30px;"/>-->
			</div>
			<div class="top_b">
			<!-- 
				<span style="float: right;">
				 	<img src="images/jkn_6.jpg" width="31" height="30" /><a href="/help_b.htm" target="_blank">帮助</a>
				</span>
			--><span id="clock" style="float: right;"></span><span style="float: right;">当前在线&nbsp;<font color="red"
					id="OnLine"></font>&nbsp;人&nbsp;</span>··· 欢迎 市直单位  <%=request.getSession().getAttribute("deptName")%>[
				<strong><%=request.getSession().getAttribute("name")%></strong>] 光临 ···
			</div>	
		</div>
		 <script type="text/javascript">
        var clock = new Clock();
        clock.display(document.getElementById("clock"));
        function LoginOut(){
            $.post("<%=basePath%>page/manageHome/test.jsp", null, function(txt){
                if(txt==1){
                    top.location.href = "<%=basePath%>messageManage/homePage_loginOut.action";
                }else{
                    alert("退出失败");
                }
            });
        }       
        GetOnLine();
        function GetOnLine(){
           $.post("<%=basePath%>messageManage/online_getNumber.action",null,function(txt){
           		var result = txt.substring(txt.indexOf("<body>")+6,txt.indexOf("</body>"));     
 				$("#OnLine").html(result.replace(" ",""));
           });
           window.setTimeout("GetOnLine()", 10000);
        }
    </script>
		
	</body>
</html>
