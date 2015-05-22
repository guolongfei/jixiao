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
    
    <title>鄂州绩效网</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
	   th{
	      font-family: 微软雅黑;
	      font-size: 1.1em;
	      height: 50px;
	   }
	  td{
	      border: 1px solid #CCC;
	      font-family: 微软雅黑;
	      font-size: 1.1em;
	      height: 50px;
	   }
	   a{
	     text-decoration: none;
	   }
	   .left{
		  width: 130px;
		  height: 50px;
		  background-color: #2894FF;
		  margin: 0 auto;
		  text-align: center;
		  line-height: 50px;
		  font-size: 1.2em;
		  color: white;
          margin-top: 2px;
	   }
	   
	</style>
	<script type="text/javascript" src="/jixiao/js/jQuery.js"></script>
	<script type="text/javascript">
	  
	   $(function(){
	     $("#purpose").click(function(){
	        $("#purpose").css("background-color","#333399");
	        $("#purpose1").css("background-color","#2894FF");
	        $("#rightframe").attr("src","/jixiao/home/purpose2.jsp");
	     });
	     $("#purpose1").click(function(){
	        $("#purpose1").css("background-color","#333399");
	        $("#purpose").css("background-color","#2894FF");
	        $("#rightframe").attr("src","/jixiao/home/purpose3.jsp");
	     });	     
	   });
	</script>

  </head>
  <body style="background: url('/jixiao/images/bg.jpg') no-repeat 50% 0px #def1ff;margin: 0;">
     <div style="width: 1003px;margin: 0 auto;height: 180px">
       <img alt="" src="/jixiao/images/pur_top.png" width="1003" height="180">
     </div>
     <div style="width: 1003px;height: 1100px;margin: 0 auto;">
       <div style="width:130px;border: 1px solid #ccc;height: 1200px;float: left;">
         <div id="purpose" class="left" style="background-color: #333399;">
                                                              工作目标
         </div>
         <div id="purpose1" class="left">
                                                             工作实绩                                       
         </div>
       </div>
       
       <!-- 右边 -->
       
          <iframe frameborder="0" width="870px" height="1200px" style="margin:0;padding:0;overflow-y:hidden;background-color: white;" id="rightframe" src="/jixiao/home/purpose.jsp" scrolling="yes" ></iframe>
       
     </div>
    
  </body>
</html>
