<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>鄂州实绩考核网</title>
   	<script type="text/javascript" src="<%=basePath%>js/jQuery.js"></script>
	<script src="<%=basePath%>datepicker/WdatePicker.js"></script>
	<link href="<%=basePath%>datepicker/WdatePicker.css"/>
	<SCRIPT type="text/javascript">
		$(function(){
			$("#save").click(function(){
				if($("#year").val()==""){
					alert("年份不能为空!");
				}
				else if($("#quarter").val()==""){
					alert("季度不能为空!");
				}
				else if($("#startTime").val()==""){
					alert("开始时间不能为空!");
				}
				else if($("#endTime").val()==""){
					alert("截止时间不能为空!");
				}
				else{
					document.getElementById("f").action = "<%=basePath%>quarterManage/quarter_updateTime.action";
					document.getElementById("f").submit();
				}
			});		
		});
	</SCRIPT>
  </head>
  	
  <body style="background: #F1F6FA;">
  <div style="height: 400px;">
    	<form id="f" method="post">
  	<table cellpadding="0" cellspacing="0" align="center" width="95%" border="1" bordercolor="#E4C08F" style="margin-top: 40px;text-align: center;border-collapse:collapse;">
    		<tr>
    			<td colspan="5" height="40" align="center" style="background: #F6EBE3;color: #c22626;font-weight: bold;">季度考核时间设置</td>
    		</tr>
    		<tr>
    			<td height="30">年份</td>
    			<td>季度</td>
    			<td>开始时间</td>
    			<td>结束时间</td>
    			<td>设置</td>
    		</tr>
    		<s:iterator value="list">
    		<tr>
    			<td height="30"><input type="text" id="year" name="year" value="<s:property value="year"/>"/></td>
    			<td><input type="text" id="quarter" name="quarter" value="<s:property value="quarter"/>"/></td>
    			<td><input style="width: 160px; height:21px; overflow: hidden;" id="startTime" class="TextBoxStyle"  
				 	name="startTime" value="<s:property value="startTime"/>"	
					onfocus="WdatePicker({el:'startTime',dateFmt:'yyyy-MM-dd',onpicked:function(){},isShowClear:false});" /></td>
    			<td><input style="width: 160px; height:21px; overflow: hidden;" id="endTime" class="TextBoxStyle"  
				 	name="endTime" value="<s:property value="endTime"/>"	
					onfocus="WdatePicker({el:'endTime',dateFmt:'yyyy-MM-dd',onpicked:function(){},isShowClear:false});" /></td>
    			<td><input type="button" id="save" value="保存"/></td>
			</tr>
    		</s:iterator>
    		<tr style="display: none;">
    			<td><input type="text" name="quarterId" value="<s:property value="quarterId"/>"/></td>
    		</tr>
    	</table>
    	</form>
    </div>
  </body>
</html>
