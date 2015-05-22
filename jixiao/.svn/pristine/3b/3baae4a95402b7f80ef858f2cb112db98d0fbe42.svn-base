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
	</STYLE>
	<script type="text/javascript" src="/jixiao/js/jQuery.js" ></script>
	<SCRIPT type="text/javascript">
	$(function(){ 
	   var type = '${type}';
       var ht ="";
       if(type==1){
         ht = "<option value='01'>一月份</option><option value='02'>二月份</option><option value='03'>三月份</option>";
       }else if(type==2){
         ht = "<option value='04'>四月份</option><option value='05'>五月份</option><option value='06'>六月份</option>";
       }else if(type==3){
         ht = "<option value='07'>七月份</option><option value='08'>八月份</option> <option value='09'>九月份</option>";
       }else{
         ht = "<option value='10'>十月份</option><option value='11'>十一月份</option><option value='12'>十二月份</option>";
       }
       $(ht).appendTo($("#select_month"));
       
       $("#select_year option[value='${year}']").attr("selected","selected");
	   $("#select_month option[value='${month}']").attr("selected","selected");
	   
       $("#query").click(function(){
         var year = $("#select_year").val();
         var month = $("#select_month").val();
         var empId = $("#empId").val();
         $.ajax({
           type:"post",
           url:"/jixiao/performance/performance_getpfbyday.action?month="+month+"&year="+year+"&empId="+empId+"",
           dataType:"json",
           success:function(msg){
             if(msg.errorMsg=="success"){
               var pfmonth = msg.pfOfmonth;
               var summaryOfmonth = msg.summaryOfmonth;
               if(pfmonth!=null&&pfmonth!=""){
                  $("#textplan").val(pfmonth);
               }else{
                  $("#textplan").val("");
               }
               if(summaryOfmonth!=null&&summaryOfmonth!=""){
                  $("#textsum").val(summaryOfmonth);
               }else{
                  $("#textsum").val("");
               }
               var pflist = msg.array;
                 $("#tab1 tr:gt(0)").remove();
                if(pflist.length>0){
                   for(var i=0;i<pflist.length;i++){                    
		               var trday =  "<tr><td width='20%' align='center' height='35px'>"+pflist[i].time+"</td>"+
		                "<td width='80%' align='center' height='35px'>"+pflist[i].content+"</td></tr>";
		                $(trday).appendTo($("#tab1"));
                   }
                }
             }
           }
         });
       });
       
       $("#evaluate").click(function(){
          var empId = $("#empId").val();
          location.href="/jixiao/performance/performance_toMark.action?empId="+empId+"";
       });
	}); 
	</SCRIPT>
  </head>
  
  <body>
     <div style="width: 95%;background-color: #FFCCCC;margin: 0 auto;">
     <div style="width: 90%;height: 50px;margin: 0 auto;">
          <div style="float: left"><img alt="" src="/jixiao/images/log.png" width="50px" height="50px"/></div> 
          <div style="font-family: 微软雅黑;font-weight: bolder;font-size: 1.0em;float: left;line-height: 50px;color: #cc2626;"><s:property value="empName"/>&nbsp;&nbsp;&nbsp;&nbsp;的季评鉴 </div>
          <div style="float: right;font-family: 微软雅黑;font-weight: bolder;font-size: 0.8em;line-height: 50px;">日期：<s:property value="now" /></div>                 
     </div>
    
      <div style="width: 90%;height: 360px;margin: 5px auto;">
          <table width="100%" cellspacing="0" style="border-collapse:collapse;">
            <tr>
               <td class="left_td" align="center" style="color: white;">年度工作目标</td>
               <td width="85%">
                  <textarea rows="4" style="border: 0px solid #adadad;width: 100%;font-size: 1.0em;font-family: 微软雅黑" readonly="readonly"><s:property value="purposeOfyear.performance_content"/></textarea>
               </td>
            </tr>
            <tr>
               <td class="left_td" align="center" style="color: white;">个人季计划</td>
               <td width="85%">
                  <textarea rows="4" style="border: 0px solid #adadad;width: 100%;font-size: 1.0em;font-family: 微软雅黑" readonly="readonly"><s:property value="pfOfseason.performance_content"/></textarea>
               </td>
            </tr>
            <tr>
               <td class="left_td" align="center" style="color: white;">个人季汇总</td>
               <td width="85%">
                  <textarea rows="4" style="border: 0px solid #adadad;width: 100%;font-size: 1.0em;font-family: 微软雅黑" readonly="readonly"><s:property value="summaryOfseason.performance_content"/></textarea>
               </td>
            </tr>
            <tr>
               <td class="left_td" align="center" style="color: white;">主要工作职责</td>
               <td width="85%">
                  <textarea rows="4" style="border: 0px solid #adadad;width: 100%;font-size: 1.0em;font-family: 微软雅黑" readonly="readonly"><s:property value="jxPeople.duty"/></textarea>
               </td>
            </tr>
          </table>       
     </div>
     
     
      <div style="width: 90%;height: 30px;margin: 0 auto;" align="left">
        <input type="hidden" name="empId" value="<s:property value='empId'/>" id="empId"/>
        <input type="hidden" name="empName1" value="1"/>
        <input type="hidden" name="empName" value="<s:property value='empName'/>"/>
        <select name="year" style="height:100%;width:100px;border:1px solid #adadad;" id="select_year">
          <option value="2015">2015年</option>
          <option value="2016">2016年</option>
          <option value="2017">2017年</option>
          <option value="2018">2018年</option>
          <option value="2019">2019年</option>
          <option value="2020">2020年</option>
        </select>
        <select name="month" style="height:100%;width:100px;border:1px solid #adadad;" id="select_month">
        </select>
        <input type="button" id="query" style="width: 80px;height: 30px;border: 1px solid #adadad;background-color: #D84B4B;cursor: pointer;" value="查看">
     </div> 
     
     <div style="width: 90%;height: 180px;margin: 5px auto;">
          <table width="100%" cellspacing="0" style="border-collapse:collapse;">
            <tr>
               <td class="left_td" align="center" style="color: white;">个人月计划</td>
               <td width="85%">
                  <textarea rows="4" style="border: 0px solid #adadad;width: 100%;font-size: 1.0em;font-family: 微软雅黑" readonly="readonly" id="textplan"><s:property value="pfOfmonth.performance_content"/></textarea>
               </td>
            </tr>
            <tr>
               <td class="left_td" align="center" style="color: white;">个人月小结</td>
               <td width="85%">
                  <textarea rows="4" style="border: 0px solid #adadad;width: 100%;font-size: 1.0em;font-family: 微软雅黑" readonly="readonly" id="textsum"><s:property value="summaryOfmonth.performance_content"/></textarea>
               </td>
            </tr>
          </table>       
     </div>
     
     <div style="height:33px; width:90%;background-image: url('/jixiao/images/jkn_11.png');background-repeat:repeat;margin:0px auto;line-height: 33px;" align="left">
                   <span style="font-family: 微软雅黑;font-weight: bolder;font-size: 0.9em;color:white;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;每日实绩列表</span>
     </div>
     
     <div style="width: 90%;margin: 5px auto;">
          <table width="100%" cellspacing="0" style="border-collapse:collapse;" id="tab1">
            <tr style="background-image: url('/jixiao/images/ss.png');background-repeat: repeat-x; ">
               <th align="center" style="width: 20%;color: #D84B4B">时间</th>
               <th align="center" style="width: 80%;color: #D84B4B">记录</th>
            </tr>
            <s:iterator var="item" value="pfList">
              <tr>
                <td width="20%" align="center" height="35px">
                  <s:date name="#item.performance_date" format="yyyy-MM-dd"/>
                </td>
                <td width="80%" align="center" height="35px">
                 <s:property value="#item.performance_content"/>
                </td>
              </tr>
            </s:iterator>
          </table>
     </div>
     <div style="height: 30px;width: 90%;"></div>
     </div>
     <div style="height: 50px;width: 90%;margin: 0 auto;text-align: center;line-height: 50px;">
        <input type="button" value="评鉴" id="evaluate"/>
     </div>
  </body>
</html>
