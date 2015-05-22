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
    
    <title>月绩效管理</title>
    
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
	<script type="text/javascript" src="/jixiao/js/jquery.min.js"></script>
	<link href="/jixiao/css/loginbox.css" rel="stylesheet" type="text/css"/>
    <SCRIPT type="text/javascript">
    $(function(){
      var errorMsg = '${errorMsg}';
      if(errorMsg=="success"){
        alert("恭喜您！操作成功！");
      }
      $("#makedraft").click(function(){
        $('.theme-popover-mask').fadeIn(100);
	    $('.theme-popover').slideDown(200);	
      });
      $("#pfsubmit").click(function(){
        if($("#con").val()==""||$("#con").val()==null){
          alert("请输入您的月计划!");
        }else{
          $("#submitPlan").submit();
        }
      });
       $("#pfsumOfsubmit").click(function(){
        if($("#summaryOfmonth").val()==""||$("#summaryOfmonth").val()==null){
          alert("请输入您的月小结!");
        }else{
          $("#summaryOfmonthform").submit();
        }
      });
    });
  	function boxclose(){
	//$('.theme-popover-mask').fadeOut(100);
	$('.theme-popover').slideUp(200);
	var selectCheckboxs = $("input[type=checkbox][name=selectpf]:checked");
	var length = selectCheckboxs.length;
	var selectvalue = "";
	for(var i=0;i<length;i++){
	   selectvalue += (i+1)+","+selectCheckboxs[i].value;
	}
	if(selectvalue!=""){
	   $("#summaryOfmonth").val(selectvalue);
	}
    }
    
    </SCRIPT>
  </head>
  
  <body>
     <div style="width: 90%;height: 50px;margin: 0 auto;">
          <div style="float: left"><img alt="" src="/jixiao/images/log.png" width="50px" height="50px"/></div> 
          <div style="font-family: 微软雅黑;font-weight: bolder;font-size: 1.2em;float: left;line-height: 50px;color: #cc2626;">月绩效 </div>
          <div style="float: right;font-family: 微软雅黑;font-weight: bolder;font-size: 1.0em;line-height: 50px;">日期：<s:property value="now" /></div>                 
     </div>
     <div style="width: 90%;height: 130px;margin: 5px auto;">
         <form action="/jixiao/performance/performance_submitPlanOfmonth.action" method="post" id="submitPlan">
          <input type="hidden" name="pfOfmonth.performanceId" value="<s:property value='pfOfmonth.performanceId'/>">
          <table width="100%" cellspacing="0" style="border-collapse:collapse;">
            <tr>
               <td class="left_td" align="center" style="color: white;">个人月计划</td>
               <td>
                  <textarea rows="4" style="border: 0px solid #adadad;width: 100%;font-size: 1.0em;" name="pfOfmonth.performance_content" id="con"><s:property value="pfOfmonth.performance_content"/></textarea>
               </td>
            </tr>        
          </table>
          <div style="width: 100%;height: 35px;margin: 2px auto;" align="right"><img id="pfsubmit" src="/jixiao/images/bt.png" height="35px" width="100px" style="cursor: pointer"/></div>
         </form>
     </div>
     
     <div class="theme-popover" style="">
	     <div class="theme-poptit" align="left">
	          <a title="关闭" class="close" onclick="boxclose()">×</a>
	          <h3>每日实绩列表</h3>
	     </div>
	     <div class="theme-popbod dform">
	            <table width="100%" cellspacing="0" style="border-collapse:collapse;" >
	            <tr style="background-image: url('/jixiao/images/ss.png');background-repeat: repeat-x; ">
	               <th align="center" style="width: 10%;color: #D84B4B;">操作</th>
	               <th align="center" style="width: 20%;color: #D84B4B;">时间</th>
	               <th align="center" style="width: 70%;color: #D84B4B;">记录</th>
	            </tr>
	            <s:iterator var="item" value="pfList">
	              <tr>
	                <td width="10%" align="center" height="30px"><input type="checkbox" name="selectpf" value="<s:property value='#item.performance_content'/>" style="border: 0px;"/></td>
	                <td width="20%" align="center" height="30px" style="font-size: 0.8em;">
	                  <s:date name="#item.performance_date" format="yyyy-MM-dd"/>
	                </td>
	                <td width="70%" align="center" height="30px" style="font-size: 0.8em;">
	                 <s:property value="#item.performance_content"/>
	                </td>
	              </tr>
	            </s:iterator>
	          </table>
	     </div>
   </div>
   
   
     <div style="width: 90%;margin: 0px auto;height: 188px">
     	<form action="/jixiao/performance/performance_subSumOfmonth.action" method="post" id="summaryOfmonthform">
     	  <input type="hidden" name="summaryOfmonth.performanceId" value="<s:property value='summaryOfmonth.performanceId'/>">
          <table width="100%" cellspacing="0" cellpadding="0">
            <tr style="background-image: url('/jixiao/images/jkn_11.png');background-repeat:repeat-x;margin:5px auto;">
               <td height="33px" align="left" style="font-family: 微软雅黑;color: white;font-size: 1.0em;border: 0px;">&nbsp;&nbsp;&nbsp;&nbsp;月小结</td>
               <td height="33px" align="right" style="font-family: 微软雅黑;border: 0px;"><font id="makedraft" style="font-size: 1.0em;cursor: pointer;color: white;">生成初稿&nbsp;&nbsp;</font></td>
            </tr>
            <tr>
              <td align="center" height="80%" colspan="2">
               <textarea style="border: 0px solid #adadad;width: 100%;font-size: 1.0em;" rows="5" id="summaryOfmonth" name="summaryOfmonth.performance_content"><s:property value="summaryOfmonth.performance_content"/></textarea>
              </td>
            </tr>
            <tr>
              <td colspan="2" align="right" style="border: 0px ;" height="40px"><img id="pfsumOfsubmit" src="/jixiao/images/bt.png" height="35px" width="100px" style="cursor: pointer"/></td>
            </tr>
          </table>
        </form>
     </div>
     
     <div style="height:33px; width:90%;background-image: url('/jixiao/images/jkn_11.png');background-repeat:repeat-x;margin:0px auto;line-height: 33px;" align="left">
                   <span style="font-family: 微软雅黑;font-size: 1.3em;color:white;">&nbsp;&nbsp;&nbsp;&nbsp;月小结列表</span>
     </div>
     <div style="width: 90%;margin: 0 auto;">
          <table width="100%" cellspacing="0" style="border-collapse:collapse;" >
            <tr style="background-image: url('/jixiao/images/ss.png');background-repeat: repeat-x; ">
               <th align="center" style="width: 20%;color: #D84B4B">时间</th>
               <th align="center" style="width: 80%;color: #D84B4B">记录</th>
            </tr>
            <s:iterator var="item" value="pfmonthList">
              <tr>
                <td width="20%" align="center" height="35px">
                  <s:date name="#item.performance_date" format="yyyy-MM"/>
                </td>
                <td width="80%" align="center" height="35px">
                 <s:property value="#item.performance_content"/>
                </td>
              </tr>
            </s:iterator>
          </table>
     </div>
     <div style="height: 50px;width: 90%;"></div>
     
     
     
  </body>
</html>
