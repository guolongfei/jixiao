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
	  .fenye{border: 0px;font-size: 15px;}
	  a:hover {color:#ba2636;text-decoration:none;cursor: pointer;}
	</STYLE>
	<script type="text/javascript" src="/jixiao/js/jQuery.js" ></script>
	<SCRIPT type="text/javascript">
	$(function(){
	   var p = '${postId}';
	   if(p==1){
	      $("#eva").css("display","block");
	   }
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
	}); 
	
	
	function firstPage()
     { 
         document.getElementById("page").value=1;
         $("#pinglun").action="/jixiao/performance/performance_getOthersPerformance.action";
         $("#pinglun").submit();  
     }
     
     function endPage(page)
     { 
         document.getElementById("page").value=page;
         $("#pinglun").action="/jixiao/performance/performance_getOthersPerformance.action";
         $("#pinglun").submit();  
     }
     
     function next(currentPage,totalPage)
     {
         if(currentPage<totalPage)
         {
             document.getElementById("page").value=currentPage+1;
             $("#pinglun").action="/jixiao/performance/performance_getOthersPerformance.action";
             $("#pinglun").submit(); 
         }        
     }
     
     function previous(currentPage)
     {  
         if(currentPage>1)
         {
             document.getElementById("page").value=currentPage-1;
             $("#pinglun").action="/jixiao/performance/performance_getOthersPerformance.action";
             $("#pinglun").submit();                 
         }
     }
     
     function tiJiao()
     {
         var c=document.getElementById("content").value;
         if(c=="")
         {
             alert("提交内容不能为空");
             return;
         }
         $("#tj").action="/jixiao/performance/performance_saveComment.action";
         $("#tj").submit();   
     }   
	</SCRIPT>
  </head>
  
  <body>
     <div style="width: 90%;height: 50px;margin: 0 auto;">
          <div style="float: left"><img alt="" src="/jixiao/images/log.png" width="50px" height="50px"/></div> 
          <div style="font-family: 微软雅黑;font-weight: bolder;font-size: 1.0em;float: left;line-height: 50px;color: #2D92EA;"><s:property value="empName"/>&nbsp;&nbsp;&nbsp;&nbsp;的实绩 </div>
          <div style="float: right;font-family: 微软雅黑;font-weight: bolder;font-size: 0.8em;line-height: 50px;">日期：<s:property value="now" /></div>                 
     </div>
     <div style="width: 90%;height: 30px;margin: 0 auto;" align="left">
        <form action="/jixiao/performance/performance_getOthersPerformance.action" method="post">
        <input type="hidden" name="empId" value="<s:property value='empId'/>"/>
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
          <option value="12">十二月份</option>
        </select>
        <input type="submit" id="query" style="width: 80px;height: 30px;border: 1px solid #adadad;background-color: #2D92EA;cursor: pointer;color: white;font-weight: bolder;" value="查看">
        </form>
     </div>  
      <div style="width: 90%;height: 360px;margin: 5px auto;">
      <form action="/jixiao/performance/performance_saveOfDuty.action" method="post" id="dutyform">
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
               <td class="left_td" align="center" style="color: white;">个人月计划</td>
               <td width="85%">
                  <textarea rows="4" style="border: 0px solid #adadad;width: 100%;font-size: 1.0em;font-family: 微软雅黑" readonly="readonly"><s:property value="pfOfmonth.performance_content"/></textarea>
               </td>
            </tr>
            <tr>
               <td class="left_td" align="center" style="color: white;">主要工作职责</td>
               <td width="85%">
                  <textarea rows="4" style="border: 0px solid #adadad;width: 100%;font-size: 1.0em;font-family: 微软雅黑" readonly="readonly"><s:property value="jxPeople.duty"/></textarea>
               </td>
            </tr>
          </table>
         </form>
     </div>
     <div style="height: 30px;width: 90%;"></div>
     <div style="height:33px; width:90%;background-color:#2D92EA;margin:0px auto;line-height: 33px;" align="left">
                   <span style="font-family: 微软雅黑;font-weight: bolder;font-size: 0.9em;color:white;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;每日实绩列表</span>
     </div>
     <div style="width: 90%;margin: 0 auto;">
          <table width="100%" cellspacing="0" style="border-collapse:collapse;" >
            <tr style="background-image: url('/jixiao/images/ss.png');background-repeat: repeat-x; ">
               <th align="center" style="width: 20%;color: #2D92EA">时间</th>
               <th align="center" style="width: 80%;color: #2D92EA">记录</th>
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
     
     <div style="height: 40px;width: 90%;"></div>
     <div style="display: none;" id="eva">
     <div style="height:33px; width:90%;background-color:#2D92EA;margin:0px auto;line-height: 33px;" align="left">
                   <span style="font-family: 微软雅黑;font-weight: bolder;font-size: 0.9em;color:white;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;评论专区</span>
     </div>
     <div style="width: 90%;margin: 0 auto;">
     <form id="pinglun" method="post">
     <input id="page" type="hidden" name="pageNum" value="<s:property value="pageNum"/>"/>
         <table width="100%" cellspacing="0" border="0">
         <s:if test="commentNum==0">
          <tr>
               <td align="center">暂无评论</td>
          </tr>
          </s:if>
         <s:iterator var="li" value="fyList">
            <tr>
               <td><s:property value="name"/>&nbsp;&nbsp;<s:date name="#li.comment_time" format="yyyy-MM-dd HH:mm:ss"/>&nbsp;&nbsp;评论：</td>
            </tr>
             <tr>
               <td>
                  <textarea rows="4" style="border: 0px solid #adadad;width: 100%;font-size: 1.0em;font-family: 微软雅黑" readonly="readonly" ><s:property value="#li.comment_content"/></textarea>
               </td>
            </tr>
            <tr height="10px;"></tr>
            </s:iterator>
             <tr>
                 <td align="right" class="fenye">
                
      <span> 共&nbsp;<font color=red><s:property value="totalPage"/></font>&nbsp;页 </span>
      <a onclick="firstPage();">首页</a>
      <a onclick="previous(<s:property value="pageNum"/>);">上一页  &nbsp;</a><span><font color=red><s:property value="pageNum"/></font></span>&nbsp;&nbsp;<a onclick="next(<s:property value="pageNum"/>,<s:property value="totalPage"/>);">下一页</a>
      <a onclick="endPage(<s:property value="totalPage"/>);">尾页</a> 
                  
                 </td>
                 </tr>
         </table>
         </form>
     </div>
     
     <div style="height: 30px;width: 90%;"></div>
     <div style="height:33px; width:90%;background-color:#2D92EA;margin:0px auto;line-height: 33px;" align="left">
                   <span style="font-family: 微软雅黑;font-weight: bolder;font-size: 0.9em;color:white;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;我要评论</span>
     </div>
     <form id="tj" action="/jixiao/performance/performance_saveComment.action" method="post">
     <input type="hidden" name="empId" value="<s:property value='empId'/>"/>
     <input type="hidden" name="empName1" value="1"/>
     <input type="hidden" name="empName" value="<s:property value='empName'/>"/>
     <div style="width: 90%;margin: 0 auto;">
         <table width="100%" cellspacing="0" style="border-collapse:collapse;" >
             <tr>
               <td>
                  <textarea id="content" rows="4" style="border: 0px solid #adadad;width: 100%;font-size: 1.0em;font-family: 微软雅黑"  name="commentContent"></textarea>
               </td>
            </tr>
            <tr>
                <td><input type="button" onclick="tiJiao();" value="评论" /></td>
            </tr>
         </table>
     </div>
     </form>
     </div>
     <div style="height: 50px;width: 90%;"></div>
  </body>
</html>
