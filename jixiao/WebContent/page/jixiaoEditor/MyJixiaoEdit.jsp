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
	td{border: 1px solid #E4C08F;height: 35px;}
	th{border: 1px solid #E4C08F;height:30px;}
	</STYLE>
	<script type="text/javascript" src="/jixiao/js/jQuery.js" ></script>
	<SCRIPT type="text/javascript">
	  $(function(){
	    var errorMsg = '${errorMsg}';
	    if(errorMsg=="success"){
	      alert("恭喜您！操作成功！");
	    }
	    $("#pfsubmit").click(function(){
	      if($("#content").val()==''||$("#content")==null){
	        alert("请填写记载!");
	        return;
	      }else{
	        $("#todaypf").submit();
	      }
	    });
	  });
	</SCRIPT>
	<STYLE type="text/css">
		body{
			margin:0;
			padding:0;
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
	</STYLE>
  </head>
  <body>
    
	<table cellpadding="0" cellspacing="0" width="95%" style="background-color: white;">
		<tr>
			<td style="border: 0;">
				<div style="width: 90%;height: 50px;margin: 0 auto;">
          <div style="float: left"><img alt="" src="/jixiao/images/log.png" width="50px" height="50px"/></div> 
          <div style="font-family: 微软雅黑;font-weight: bolder;font-size: 1.0em;float: left;line-height: 50px;color: #235C9D;">实绩记载 </div>
          <div style="float: right;font-family: 微软雅黑;font-weight: bolder;font-size: 0.8em;line-height: 50px;">日期：
          <s:if test="performance.performance_date!=null||performance.performance_date!=''">
            <s:date name="performance.performance_date" format="yyyy-MM-dd"/>
          </s:if>
          <s:else><s:property value="now" /></s:else>
          </div>                 
     </div>

    <form action="/jixiao/performance/performance_savePFByday.action" method="post" id="todaypf">
     <input type="hidden" name="performance.performanceId" value="<s:property value='performance.performanceId'/>">
     <div style="width: 90%;margin: 10px auto;height: 150px;">
          <table width="100%" height="100%" cellspacing="0" style="border-collapse:collapse;">
            <tr>
               <td class="left_td" align="center" width="80px" style="color: white;">记载内容</td>
               <td class="right_td">
                  <textarea  style="height:100%;border: 0px solid #fff;width: 100%;font-size: 1.0em;font-family: 微软雅黑" id="content" name="performance.performance_content"><s:property value="performance.performance_content"/></textarea>
               </td>
            </tr>
          </table>
     </div>

     <div style="width: 90%;margin: 5px auto;text-align: right;">
     <button id="pfsubmit" class="cmdFiled">保存</button>
        <!-- <img id="pfsubmit" src="/jixiao/images/bt.png" height="35px" width="100px" style="cursor: pointer"/>  --> 
     </div>  
     </form>
			</td>
		</tr>
		<tr>
		  <td style="border: 0;"> 
		     <div style="height:33px; width:90%;background:#2D92EA;margin:0px auto;line-height: 33px;" align="left">
                   <span style="font-family: 微软雅黑;font-weight: bolder;font-size: 0.9em;color:white;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;每日实绩列表</span>
     </div>
     <div style="width: 90%;margin: 0px auto;">
          <table width="100%" cellspacing="0" style="border-collapse:collapse;" >
            <tr style="background-image: url('/jixiao/images/ss.png');background-repeat: repeat-x; ">
               <th align="center" style="width: 20%;color: #2D92EA;">时间</th>
               <th align="center" style="width: 80%;color: #2D92EA;">记录</th>
            </tr>
          <!--    <s:iterator var="item" value="pfList">
              <tr>
                <td width="20%" align="center" height="35px">
                  <s:date name="#item.performance_date" format="yyyy-MM-dd"/>
                </td>
                <td width="80%" align="center" height="35px">
                 <s:property value="#item.performance_content"/><a href="/jixiao/performance/performance_getPerformanceById.action?performance.performanceId=<s:property value='#item.performanceId'/>">编辑</a>
                </td>
              </tr>
            </s:iterator>  -->
          </table>
     </div>
     <div style="height: 180px;width: 90%;"></div>
		  </td>
		</tr>
	</table>
    
   
     

  </body>
</html>
