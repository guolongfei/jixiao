<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>鄂州实绩考核系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="/jixiao/css/perf_style.css">
	<STYLE type="text/css">
	    td{border: 1px solid #E4C08F;font-family: 微软雅黑;text-align: center;color: #FF6666;}
	    th{border: 1px solid #E4C08F;height:30px;color: #D84B4B;font-family: 微软雅黑;}
	</STYLE>
	<script type="text/javascript" src="/jixiao/js/jQuery.js" ></script>
	<SCRIPT type="text/javascript">
	  
	</SCRIPT>

  </head>
  <body style="background-color: #FFCCCC;text-align: center;">
    <form action="/jixiao/performance/performance_mark.action" method="post" id="markform">
      <div style="width: 60%;height: 300px;background-color: white;margin: 0 auto;"> 
        <table cellspacing="0" style="border-collapse: collapse;margin: 0 auto;" width="90%">
          <tr>
            <th>优</th><th>良</th><th>一般</th><th>差</th>
          </tr>
          <tr>
            <td><input type="radio" value="01" name="evaluation"/>A</td><td><input type="radio" value="11" name="evaluation"/>A</td><td><input type="radio" value="21" name="evaluation"/>A</td><td><input type="radio" value="31" name="evaluation"/>A</td>
          </tr>
          <tr>
            <td><input type="radio" value="02" name="evaluation"/>B</td><td><input type="radio" value="12" name="evaluation"/>B</td><td><input type="radio" value="22" name="evaluation"/>B</td><td><input type="radio" value="32" name="evaluation"/>B</td>
          </tr>
          <tr>
            <td><input type="radio" value="03" name="evaluation"/>C</td><td><input type="radio" value="13" name="evaluation"/>C</td><td><input type="radio" value="23" name="evaluation"/>C</td><td><input type="radio" value="33" name="evaluation"/>C</td>
          </tr>
        </table>
        <div style="margin: 5px auto;width: 90%;">
          <div style="color: #cc2626;width: 100%;height: 25px;line-height: 25px;text-align: left;font-weight: bolder;">文字点评</div>
          <div style="width: 100%">
            <textarea rows="5" style="width: 100%;"></textarea>
            <input type="submit" value="提交">
          </div>
           
        </div>
        
      </div>
     </form>
  </body>
</html>
