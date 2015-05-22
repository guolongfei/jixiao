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
    
    <title>个人绩效</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="/jixiao/css/perf_style.css">
	<STYLE type="text/css">
	  td{border: 1px solid #E4C08F;font-family: 微软雅黑;}
	  th{border: 1px solid #E4C08F;height:30px;}
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
		body{
			margin:0;
			padding:0;
			background: url("<%=basePath%>images/jkn_2.jpg") repeat-x;
		}
	</STYLE>
	<script type="text/javascript" src="/jixiao/js/jQuery.js" ></script>
	<SCRIPT type="text/javascript">
	$(function(){
	   $("#select_year option[value='${year}']").attr("selected","selected");
	   $("#select_month option[value='${month}']").attr("selected","selected");
	   var errorMsg = '${errorMsg}';
	    if(errorMsg=="success"){
	      alert("恭喜您！操作成功！");
	    }
	   $("#submitDuty").click(function(){
	      if($("#con").val()==''||$("#con")==null){
	         alert("请填写您的工作职责!");
	      }else{
	         $("#dutyform").submit();
	      }
	   });
	   $("#jprint").click(function(){
	     location.href="/jixiao/performance/performance_toJPrint.action";
	   });
	}); 
	</SCRIPT>
  </head>
  
  <body>
  <div style="height: 930;background-color: white;width: 98%;">
     <div style="width: 90%;height: 50px;margin: 0 auto;">
          <div style="float: left"><img alt="" src="/jixiao/images/log.png" width="50px" height="50px"/></div> 
          <div style="font-family: 微软雅黑;font-weight: bolder;font-size: 1.0em;float: left;line-height: 50px;color: #235C9D;">我的实绩 </div>
          <div style="float: right;font-family: 微软雅黑;font-weight: bolder;font-size: 0.8em;line-height: 50px;">日期：<s:property value="now" /></div>                 
     </div>
     <div style="width: 90%;height: 30px;margin: 0 auto;" align="left">
       <div style="height: 30px;float: left;" align="left">
        <form action="/jixiao/performance/performance_getPerformanceList.action" method="post">
        <select name="year" style="height:100%;width:100px;border:1px solid #adadad;" id="select_year">
          <option value="2015">2015年</option>
          <option value="2016">2016年</option>
          <option value="2017">2017年</option>
          <option value="2018">2018年</option>
          <option value="2019">2019年</option>
          <option value="2020">2020年</option>
        </select>
        <select name="month" style="height:100%;width:100px;border:1px solid #adadad;" id="select_month">
          <option value="01">一月份</option>
          <option value="02">二月份</option>
          <option value="03">三月份</option>
          <option value="04">四月份</option>
          <option value="05">五月份</option>
          <option value="06">六月份</option>
          <option value="07">七月份</option>
          <option value="08">八月份</option>
          <option value="09">九月份</option>
          <option value="10">十月份</option>
          <option value="11">十一月份</option>
          <option value="12">十二份</option>
        </select>
        <input type="submit" id="query" style="width: 80px;height: 30px;border: 1px solid #adadad;background-color:#2D92EA ;cursor: pointer;color: white;" value="查看">
        </form>
      </div>
      <div style="float: right"><input type="button" id="jprint" style="width: 80px;height: 30px;border: 1px solid #adadad;background-color: #2D92EA;cursor: pointer;color: white;" value="月绩效打印"></div>
     </div>  
      <div style="width: 90%;height: 360px;margin: 5px auto;">
      <form action="/jixiao/performance/performance_saveOfDuty.action" method="post" id="dutyform">
          <table width="100%" cellspacing="0" style="border-collapse:collapse;">
             <tr>
               <td class="left_td" align="center" style="color: white;">主要工作职责</td>
               <td>
                  <textarea rows="4" style="border: 0px solid #adadad;width: 100%;font-size: 1.0em;font-family: 微软雅黑" name="jxPeople.duty" id="con" readonly="readonly"><s:property value="jxPeople.duty"/></textarea>
               </td>
            </tr>
            <tr>
               <td class="left_td" align="center" style="color: white;">年度工作目标</td>
               <td>
                  <textarea rows="4" style="border: 0px solid #adadad;width: 100%;font-size: 1.0em;font-family: 微软雅黑" readonly="readonly"><s:property value="purposeOfyear.performance_content"/></textarea>
               </td>
            </tr>
          </table>
         </form>
     </div>
      <!-- <div style="width: 90%;height: 35px;margin: 5px auto;" align="right"><button id="submitDuty" class="cmdFiled">保存</button></div>
     <div style="height:33px; width:90%;background:#2D92EA;margin:0px auto;line-height: 33px;" align="left">
                   <span style="font-family: 微软雅黑;font-weight: bolder;font-size: 0.9em;color:white;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;每日实绩列表</span>
     </div>
     <div style="width: 90%;margin: 0px auto;">
          <table width="100%" cellspacing="0" style="border-collapse:collapse;" >
            <tr style="background-image: url('/jixiao/images/ss.png');background-repeat: repeat-x; ">
               <th align="center" style="width: 20%;color: #2D92EA;">时间</th>
               <th align="center" style="width: 80%;color: #2D92EA;">记录</th>
            </tr>
            <s:iterator var="item" value="pfList">
              <tr>
                <td width="20%" align="center" height="35px">
                  <s:date name="#item.performance_date" format="yyyy-MM-dd"/>
                </td>
                <td width="80%" align="center" height="35px">
                 <s:property value="#item.performance_content"/><a href="/jixiao/performance/performance_getPerformanceById.action?performance.performanceId=<s:property value='#item.performanceId'/>">编辑</a>
                </td>
              </tr>
            </s:iterator>
          </table>
     </div>   -->
     <div style="height: 50px;width: 90%;"></div>
     </div>
  </body>
</html>
