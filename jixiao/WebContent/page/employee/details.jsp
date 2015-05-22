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
    
    <title>鄂州市实绩考核网</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
		body{
			margin:0;
			padding:0;
			background: url("<%=basePath%>images/jkn_2.jpg") repeat-x;
		}
	</style>
  </head>
  
  <body>
    <table cellpadding="0" cellspacing="0" width="95%" style="background-color: white;">
    		<tr>
    			<td>
    				<div style="width: 90%;height: 50px;margin: 0 auto;">
    					<div style="float: left"><img alt="" src="<%=basePath%>images/log.png" width="50px" height="50px"/></div>
    					<div style="font-family: 微软雅黑;font-weight: bolder;font-size: 1.0em;float: left;line-height: 50px;color: #235C9D;">考核办法</div>
    				</div>
    			</td>
    		</tr>
    		<tr>
    			<td>
    				<div style="width: 90%;height: 480px;margin: 0 auto;">
    					<div style="width: 100%;height: 50px;text-align: center;line-height: 50px;font-size: 20px;color:#235C9D;font-weight: bold;border: 1px solid #cccccc;border-bottom: none;">
    							 <%=request.getSession().getAttribute("deptName")%>实绩考核办法
    					</div>  					
    					<div style="width: 100%;height: 400px;border: 1px solid #cccccc;overflow:scroll">   					
    							<s:property value="content" escape="false"/>   											
    					</div>   				
    				</div>	
    			</td>
    		</tr>
    	</table>
  </body>
</html>
