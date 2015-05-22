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
    
    <title>季绩效管理</title>
    
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
     var summary = "";
    $(function(){  
      var errorMsg = '${errorMsg}';
      if(errorMsg=="success"){
        alert("恭喜您！操作成功！");
      }  
      $("#makedraft").click(function(){
	    $('.theme-popover').slideDown(200);	
      });
      $("#pfsubmitplan").click(function(){
        if($("#con").val()==""||$("#con").val()==null){
          alert("请输入您的季计划!");
        }else{
          $("#submitPlanOfseason").submit();
        }
      });
       $("#seasonsumOfsubmit").click(function(){
        if($("#summaryOfseason").val()==""||$("#summaryOfseason").val()==null){
          alert("请输入您的季汇总!");
        }else{
          $("#summaryOfseasonform").submit();
        }
      });
      $("#season").change(function(){
         var selectvalue = $("#season").find("option:selected").val();
         if(selectvalue == "1"){
              $("#month").empty();
	          $("#month").removeAttr("disabled");
	          $("#choose").removeAttr("disabled");
	          var type = $("#seasontype").val();
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
	          $(ht).appendTo($("#month"));
         }else{
          $("#month").attr("disabled","disabled");
          $("#choose").attr("disabled","disabled");
          $("#daydiv").css("display","none");
          $("#monthdiv").css("display","block");
         }
         
      });
      $("#choose").click(function(){
         $("#daydiv").css("display","block");
         $("#monthdiv").css("display","none");
         var month = $("#month").find("option:selected").val();
         $.ajax({
            type:"post",
            url:"/jixiao/performance/performance_getpfbyday.action?month="+month+"",
            dataType:"json",
            success:function(msg){
              if(msg.errorMsg=="success"){
                var pflist = msg.array;
                 $("#tab1 tr:gt(0)").remove();
                if(pflist.length>0){
                   for(var i=0;i<pflist.length;i++){
                      var trday = "<tr><td width='10%' align='center' height='30px' style='font-size: 0.8em;'>"+
	                "<input type='checkbox' name='selectpf' value='"+pflist[i].content+"' style='border: 0px;'/></td>"+
	                "<td width='20%' align='center' height='30px' style='font-size: 0.8em;'>"+pflist[i].time+"</td>"+
	                "<td width='70%' align='center' height='30px' style='font-size: 0.8em;'>"+pflist[i].content+"</td></tr>";
	                $(trday).appendTo($("#tab1"));
                   }
                }
                
              }
            }
         });
      });
      
      $("#select_day").click(function(){
         var dayCheckboxs = $("input[type=checkbox][name=selectpf]:checked");
		 var length = dayCheckboxs.length;
		 var dayvalue = "";
		 for(var i=0;i<length;i++){
		    dayvalue += dayCheckboxs[i].value+"。";
		 }
		 summary += dayvalue;
		  alert("获取成功!");
      });
      
      $("#select_month").click(function(){
         var monthCheckboxs = $("input[type=checkbox][name=selectpfmonth]:checked");
		 var length = monthCheckboxs.length;
		 var monthvalue = "";
		 for(var i=0;i<length;i++){
		    monthvalue += monthCheckboxs[i].value+"。";
		 }
		 summary += monthvalue;
		 alert("获取成功!");
      });
    });
  	function boxclose(){
	$('.theme-popover').slideUp(200);
	if(summary!=""){
	  $("#summaryOfseason").val(summary);
	}
	summary = "";
    }
    
    </SCRIPT>
  </head>
  
  <body>
     <input type="hidden" id="seasontype" value="<s:property value='type'/>">
     <div style="width: 90%;height: 50px;margin: 0 auto;">
          <div style="float: left"><img alt="" src="/jixiao/images/log.png" width="50px" height="50px"/></div> 
          <div style="font-family: 微软雅黑;font-weight: bolder;font-size: 1.2em;float: left;line-height: 50px;color: #cc2626;">季绩效 </div>
          <div style="float: right;font-family: 微软雅黑;font-weight: bolder;font-size: 1.0em;line-height: 50px;">日期：<s:property value="now" /></div>                 
     </div>
     <div style="width: 90%;height: 130px;margin: 5px auto;">
         <form action="/jixiao/performance/performance_submitOfseason.action" method="post" id="submitPlanOfseason">
          <input type="hidden" name="pfOfseason.performanceId" value="<s:property value='pfOfseason.performanceId'/>">
          <table width="100%" cellspacing="0" style="border-collapse:collapse;">
            <tr>
               <td class="left_td" align="center" style="color: white;">个人季计划</td>
               <td>
                  <textarea rows="4" style="border: 0px solid #adadad;width: 100%;font-size: 1.0em;" name="pfOfseason.performance_content" id="con"><s:property value="pfOfseason.performance_content"/></textarea>
               </td> 
            </tr>        
          </table>
          <div style="width: 100%;height: 35px;margin: 2px auto;" align="right"><img id="pfsubmitplan" src="/jixiao/images/bt.png" height="35px" width="100px" style="cursor: pointer"/></div>
         </form>
     </div>
     <div class="theme-popover">
	     <div class="theme-poptit" align="left">
	           <a title="关闭" class="close" onclick="boxclose()">×</a>
	          <h3>每月小结</h3>
	     </div>
	     <div class="theme-popbod dform" style="overflow-y: scroll">
	        <div id="daydiv" style="display: none;">
	            <table width="100%" cellspacing="0" style="border-collapse:collapse;" id="tab1">
	            <tr style="background-image: url('/jixiao/images/ss.png');background-repeat: repeat-x; ">
	               <th align="center" style="width: 10%;color: #D84B4B">操作</th>
	               <th align="center" style="width: 20%;color: #D84B4B">时间</th>
	               <th align="center" style="width: 70%;color: #D84B4B">记录</th>
	            </tr>
	          </table>
	          <input type="button" id="select_day" style="width: 140px;height: 40px;background-image: url('/jixiao/images/button.png');border: 0px;" value="选择"/>
	       </div>
	       <div id="monthdiv">
	           <table width="100%" cellspacing="0" style="border-collapse:collapse;" >
	            <tr style="background-image: url('/jixiao/images/ss.png');background-repeat: repeat-x; ">
	               <th align="center" style="width: 10%;color: #D84B4B">操作</th>
	               <th align="center" style="width: 20%;color: #D84B4B">时间</th>
	               <th align="center" style="width: 70%;color: #D84B4B">记录</th>
	            </tr>
	            <s:iterator var="item1" value="pfmonthList">
	              <tr>
	                <td width="10%" align="center" height="30px"><input type="checkbox" name="selectpfmonth" value="<s:property value='#item1.performance_content'/>" style="border: 0px;"/></td>
	                <td width="20%" align="center" height="30px" style="font-size: 0.8em;">
	                  <s:date name="#item1.performance_date" format="yyyy-MM-dd"/>
	                </td>
	                <td width="70%" align="center" height="30px" style="font-size: 0.8em;">
	                 <s:property value="#item1.performance_content"/>
	                </td>
	              </tr>
	            </s:iterator>
	          </table>
	          <input type="button" id="select_month" style="width: 140px;height: 40px;background-image: url('/jixiao/images/button.png');border: 0px;" value="选择"/>
	       </div>   
	     </div>
	     <div style="color: #444;border-top: 1px solid #ddd;height: 26px;line-height: 26px;" align="right">
	       <select id="season" style="height:25px;width:80px;border:1px solid #adadad;">
	         <option value="0">月小结</option>
	         <option value="1">日记载</option>
	       </select>
	       <select id="month" disabled="disabled" style="height:25px;width:80px;border:1px solid #adadad;">
	         <option>请选择该季度月份</option>
	       </select>
	       <input type="button" value="确定" id="choose" disabled="disabled" style="width: 50px;height: 25px;border: 1px solid #adadad;cursor: pointer;">
	     </div>
   </div>
   
     <div style="width: 90%;margin: 0px auto;height: 308px">
     	<form action="/jixiao/performance/performance_submitOfseasonSum.action" method="post" id="summaryOfseasonform">
     	  <input type="hidden" name="summaryOfseason.performanceId" value="<s:property value='summaryOfseason.performanceId'/>">
          <table width="100%" cellspacing="0" style="border-collapse:collapse;" >
            <tr style="background-image: url('/jixiao/images/jkn_11.png');background-repeat:repeat-x;margin:5px auto;">
               <td height="33px" align="left" style="font-family: 微软雅黑;color: white;font-size: 1.0em;border: 0;">&nbsp;&nbsp;&nbsp;&nbsp;季汇总</td>
               <td height="33px" align="right" style="font-family: 微软雅黑;border: 0;"><font id="makedraft" style="font-size: 1.0em;cursor: pointer;color: white;">生成初稿&nbsp;&nbsp;</font></td>
            </tr>
            <tr>
              <td align="center" height="80%" colspan="2">
               <textarea style="border: 0px solid #adadad;width: 100%;font-size: 1.0em;" rows="10" id="summaryOfseason" name="summaryOfseason.performance_content"><s:property value="summaryOfseason.performance_content"/></textarea>
              </td>
            </tr>
            <tr>
              <td colspan="2" align="right" style="border: 0px ;height: 40px;"><img id="seasonsumOfsubmit" src="/jixiao/images/bt.png" height="35px" width="100px" style="cursor: pointer"/></td>
            </tr>
          </table>
        </form>
     </div>
      <div style="height:33px; width:90%;background-image: url('/jixiao/images/jkn_11.png');background-repeat:repeat-x;margin:0px auto;line-height: 33px;" align="left">
                   <span style="font-family: 微软雅黑;font-size: 1.3em;color:white;">&nbsp;&nbsp;&nbsp;&nbsp;季汇总列表</span>
     </div>
     <div style="width: 90%;margin: 0 auto;">
          <table width="100%" cellspacing="0" style="border-collapse:collapse;" >
            <tr style="background-image: url('/jixiao/images/ss.png');background-repeat: repeat-x; ">
               <th align="center" style="width: 20%;color: #D84B4B">时间</th>
               <th align="center" style="width: 80%;color: #D84B4B">记录</th>
            </tr>
            <s:iterator var="item" value="pfseasonList">
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
