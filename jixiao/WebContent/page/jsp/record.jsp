<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>考勤查询</title>
  <script type="text/javascript" src="<%=basePath%>js/jQuery.js"></script>
<style>
a{
text-decoration: none;
color:black;
}
</style>
</head>
<script language="javascript" src="${path}/js/jquery.js"></script>
<script src="<%=basePath%>datepicker/WdatePicker.js"></script>
<link href="<%=basePath%>datepicker/WdatePicker.css"/>
 <script type="text/javascript">
  $(function()
   {
     var myDate = new Date();  
     var year=myDate.getFullYear();
     var year1=$("#year").val();
     var str="<option value=''>请选择</option>";
     for(var i=0;i<=5;i++)
     {
     
          if((year-i)==year1)
          {       
               str+="<option value='"+(year-i)+"' selected='selected'>"+(year-i)+"年"+"</option>";
          }
          else
          {
               str+="<option value='"+(year-i)+"'>"+(year-i)+"年"+"</option>";
          }
	 }     
     $("#year").html(str);     
     })
 
 //修改选择某一行的颜色
  function changeColor(id)
  {
       var obj=document.getElementById("trcolor"+id);     
       obj.bgColor="#99ccff"; 
               
  } 
  function changeColor1(id)
  {
       var obj=document.getElementById("trcolor"+id);          
       obj.bgColor="";               
  }
 
 
 function query(){
 var month= document.getElementById("month").value;
 var year= document.getElementById("year").value;
 if(month!=""&&year==""){
 	alert("请选择查询年份");
 	return;
 }
 document.getElementById("f").action="/jixiao/messageManage/record_recordList2.action";
 document.getElementById("f").submit();
 }
 </script>
<body>
<form action="" name="f" id="f" method="post">
        <table cellpadding="0" cellspacing="0"  border="0" width="99%" style="padding: 5px;">
            <tr>
                <td width="100%" valign="top">
                 <table cellpadding="0" cellspacing="0"  border="0" width="100%"  bgcolor="#F1F6FA" style="padding-left: 30px;padding-right: 30px;">
                  <tr>
                       <td height="50" colspan="3"></td>
                  </tr>
                  <tr>
                  		<td>
                  		<select id="year" name="year">
     				</select>
                    <select id="month" name="month">
                    	<option value=""  selected="selected">请选择</option>
                        <option value="01" <s:if test='month == 1'> selected="selected"</s:if>>一月</option>
                        <option value="02" <s:if test='month == 2'> selected="selected"</s:if>>二月</option>
                        <option value="03" <s:if test='month == 3'> selected="selected"</s:if>>三月</option>
                        <option value="04" <s:if test='month == 4'> selected="selected"</s:if>>四月</option>
                        <option value="05" <s:if test='month == 5'> selected="selected"</s:if>>五月</option>
                        <option value="06" <s:if test='month == 6'> selected="selected"</s:if>>六月</option>
                        <option value="07" <s:if test='month == 7'> selected="selected"</s:if>>七月</option>
                        <option value="08" <s:if test='month == 8'> selected="selected"</s:if>>八月</option>
                        <option value="09" <s:if test='month == 9'> selected="selected"</s:if>>九月</option>
                        <option value="10" <s:if test='month == 10'> selected="selected"</s:if>>十月</option>
                        <option value="11" <s:if test='month == 11'> selected="selected"</s:if>>十一月</option>
                        <option value="12" <s:if test='month == 12'> selected="selected"</s:if>>十二月</option>
                    </select>
                      	 考勤状态
                      	 <select id="recordState" name="recordState">
     					<option value="">请选择</option>
     					<option value="出勤" <s:if test='recordState == 出勤'> selected="selected"</s:if>>出勤</option>
     					<option value="事假" <s:if test='recordState == 事假'> selected="selected"</s:if>>事假</option>
     					<option value="病假" <s:if test='recordState == 病假'> selected="selected"</s:if>>病假</option>
     					<option value="旷工" <s:if test='recordState == 旷工'> selected="selected"</s:if>>旷工</option>
     					<option value="休假" <s:if test='recordState == 休假'> selected="selected"</s:if>>休假</option>
     					<option value="迟到" <s:if test='recordState == 迟到'> selected="selected"</s:if>>迟到</option>
     					<option value="早退" <s:if test='recordState == 早退'> selected="selected"</s:if>>早退</option>
     				</select>
     				
     				查询时间
				 <input style="width: 160px; height:21px; overflow: hidden;" id="startTime" class="TextBoxStyle"  
				 	name="startTime" value="<s:property value='startTime' />"	
					onfocus="WdatePicker({el:'startTime',dateFmt:'yyyy-MM-dd HH:mm:ss',onpicked:function(){},isShowClear:false});" />&nbsp;至
				 <input style="width: 160px; height:21px; overflow: hidden;" id="endTime" class="TextBoxStyle"  
				 	name="endTime" value="<s:property value='endTime' />"	
					onfocus="WdatePicker({el:'endTime',dateFmt:'yyyy-MM-dd HH:mm:ss',onpicked:function(){},isShowClear:false});" />
                      	 <input type="button" onclick="query()" value="查询"/>
				</td>
                      	 
                  </tr>
                  <tr>
                       <td height="50" colspan="3"></td>
                  </tr>
                   <tr>
                       <h4 style="color: red;margin-left: 30px;margin-top: 20px;"><s:property value="year"/>年<s:property value="month"/>月份考勤表</h4>
                       <td>
                       <table cellpadding="0" cellspacing="0"  border="1" bordercolor="#E4C08F" style="border-collapse:collapse;" width="100%" height="100%">
	                       <tr>
	                       <td width="15%" height="30px" align="center" bgcolor="#F6EBE3"><div style="color:red;font-weight: bold;">序号</div></td>
	                       <td width="15%" height="30px" align="center" bgcolor="#F6EBE3"><div style="color:red;font-weight: bold;">日期</div></td>
	                       <td width="15%" height="30px" align="center" bgcolor="#F6EBE3"><div style="color:red;font-weight: bold;">姓名</div></td>
	                       <td width="15%" height="30px" align="center" bgcolor="#F6EBE3"><div style="color:red;font-weight: bold;">考勤状态</div></td>
	                       <td width="20%" height="30px" align="center" bgcolor="#F6EBE3"><div style="color:red;font-weight: bold;">上班打卡</div></td>
	                       <td width="15%" height="30px" align="center" bgcolor="#F6EBE3"><div style="color:red;font-weight: bold;">下班打卡</div></td>
	                       </tr>
	                       <s:iterator value="list" var="li" status="st">
	                       <tr id="trcolor<s:property value="#st.index+1" />"   onmousemove="changeColor(<s:property value="#st.index+1" />);" onmouseout="changeColor1(<s:property value="#st.index+1" />);">
	                       <td height="40px" align="center"><s:property value="#st.index+1" /></td>
	                       <td height="40px" align="center"><s:date name="#li.recordDate" format="yyyy年MM月dd日"/></td>
	                        <td height="40px" align="center"><s:property value="#li.peopleId.name" /></td>
	                       <td height="40px" align="center"><s:property value="#li.recordState" /></td>
	                       <td height="40px" align="center"><s:date name="#li.startTime" format="hh-mm-ss"/></td>
	                       <td height="40px" align="center"><s:date name="#li.endTime" format="hh-mm-ss"/></td>
	                       </tr>
	                       </s:iterator>
                       </table>
                       
                       </td>
                  </tr> 
                   <tr>
                       <td height="10" colspan="3"></td>
                  </tr>     
                 
                 </table>
               <table cellpadding="0" cellspacing="0"  border="0" width="100%" height="100%" bgcolor="#F1F6FA" style="padding-left: 30px;padding-right: 30px;">
                 <tr>
                 <td align="right">
                
      <input id="max" type="hidden" value="<s:property value="totalPage"/>" />
      <input id="cur" type="hidden" value="<s:property value="pageNum"/>" />
      <span> 共<s:property value="totalPage"/>页 页次:<s:property value="pageNum"/>/<s:property value="totalPage"/> 页</span>
      <a href="/jixiao/messageManage/message_getZhengceList.action?messageType=<s:property value="messageType"/>&pageNum=1">首页</a>
      <a onclick="previous(<s:property value="pageNum"/>,'<s:property value="messageType"/>');">上一页  &nbsp;</a><span><font color=red><s:property value="pageNum"/></font></span>&nbsp;&nbsp;<a onclick="next(<s:property value="pageNum"/>,<s:property value="totalPage"/>,'<s:property value="messageType"/>');">下一页</a>
      <a href="/jixiao/messageManage/message_getZhengceList.action?messageType=<s:property value="messageType"/>&pageNum=<s:property value="totalPage"/>">尾页</a> 
                   转到 <SELECT id="selection" NAME="select" onchange="changeValue('<s:property value="messageType"/>');"><option selected=selected>1</option></SELECT>

                 </td>
                 </tr>
                  <tr>
                       <td height="10" colspan="3"></td>
                  </tr>  
                 </table>   
           
         </td>
      </tr>
    </table>
    </form>
    </body>
</html>