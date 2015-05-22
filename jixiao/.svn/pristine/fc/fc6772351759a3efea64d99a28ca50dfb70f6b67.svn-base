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
    
    <title>工作目标</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="/jixiao/css/perf_style.css">
	<STYLE type="text/css">
	  td{border: 1px solid #E4C08F;font-family: 微软雅黑;}
	  th{border: 1px solid #E4C08F;height:30px;}
	  .cmdFild{
	  	border: 0;
	  	background: url("/jixiao/images/bg_rectbtn.png") no-repeat;
	  	overflow: hidden;
	  	width: 67px;
	  	color: #fff;
	  	line-height: 27px;
	  	height: 27px;
	  	cursor: pointer;
	  	font-size: 15px;
	  	font-weight: bold;
	  	text-align: center;
	  }
	  body{
			margin:0;
			padding:0;
			background: url("<%=basePath%>images/jkn_2.jpg") repeat-x;
		}
	</STYLE>
	<script type="text/javascript" src="/jixiao/js/jQuery.js" ></script>
	<script type="text/javascript" src="/jixiao/js/jquery.min.js"></script>
	<link href="/jixiao/css/loginbox.css" rel="stylesheet" type="text/css"/>
    <SCRIPT type="text/javascript">
       $(function(){
          var errorMsg = '${errorMsg}';
	      if(errorMsg=="success"){
	        alert("恭喜您！操作成功！");
	      }
          $("#pfsubmitplan").click(function(){
             if($("#con1").val()==""||$("#con1").val()==null){
                alert("请输入年度工作目标!!");
                return;
             }
             if($("#con2").val()==""||$("#con2").val()==null){
                alert("请输入季度工作目标!!");
                return;
             }
             if($("#con3").val()==""||$("#con3").val()==null){
                alert("请输入当月工作目标!!");
                return;
             }
             $("#submitPurpose").submit();
          });
       });
    </SCRIPT>
  </head>
  
  <body>
  	<div style="background-color: #fff;width: 95%;height: 500px;">
     <div style="width: 90%;height: 50px;margin: 0 auto;">
          <div style="float: left"><img alt="" src="/jixiao/images/log.png" width="50px" height="50px"/></div> 
          <div style="font-family: 微软雅黑;font-weight: bolder;font-size: 1.4em;float: left;line-height: 50px;color: #235c9d;">工作目标 </div>
          <div style="float: right;font-family: 微软雅黑;font-weight: bolder;font-size: 13px;;line-height: 50px;">日期：<s:property value="now" /></div>                 
     </div>
     <div style="width: 90%;height: 390px;margin: 20px auto;">
         <form action="/jixiao/performance/performance_savePurpose.action" method="post" id="submitPurpose">
          <input type="hidden" name="purposeOfyear.performanceId" value="<s:property value='purposeOfyear.performanceId'/>">
          <input type="hidden" name="pfOfseason.performanceId" value="<s:property value='pfOfseason.performanceId'/>">
          <input type="hidden" name="pfOfmonth.performanceId" value="<s:property value='pfOfmonth.performanceId'/>">
          <table width="100%" cellspacing="0" style="border-collapse:collapse;">
            <tr>
               <td class="left_td" align="center" style="color: white;">岗位职责</td>
               <td>
                  <textarea rows="4" cols="65" style="border: 0px solid #adadad;width: 100%;font-size: 1.0em;" name="purposeOfyear.performance_content" id="con1"><s:property value="purposeOfyear.performance_content"/></textarea>
               </td>
            </tr>
            <tr>
               <td class="left_td" align="center" style="color: white;">年度工作目标</td>
               <td>
                  <textarea rows="4" cols="65" style="border: 0px solid #adadad;width: 100%;font-size: 1.0em;" name="pfOfseason.performance_content" id="con2"><s:property value="pfOfseason.performance_content"/></textarea>
               </td>
            </tr>                 
          </table>
          <div style="width: 100%;height: 35px;margin: 2px auto;" align="right">
          	<button id="pfsubmitplan" class="cmdFild">保存</button>
          </div>
         </form>
     </div>
    </div>  
  </body>
</html>
