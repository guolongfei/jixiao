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
	
	<script type="text/javascript">
		$(function(){
			$("#add").click(function(){
					if($("#year option:selected").text()=="--请选择年份--"){
						alert("请选择年份!");
					}
					else if($("#quarter option:selected").text()=="--请选择季度--"){
						alert("请选择季度!");
					}
					else if($("#startTime").val()==""){
						alert("请选择开始时间!");
					}
					else if($("#endTime").val()==""){
						alert("请选择截止时间!");
					}
					else{
						document.getElementById("f").action = "<%=basePath%>/quarterManage/quarter_getQuarterTime.action";
						document.getElementById("f").submit();
					}		
			});
		
		});
	</script>
	<STYLE type="text/css">
		a{
			color: #c22626;
			text-decoration: none;
		}
	</STYLE>
  </head>
  
  <body style="background: #F1F6FA;">
  	<div style="height: 500px;">
  		<table cellpadding="0" cellspacing="0" align="center" width="95%" style="margin-top: 50px;">
  			<tr>
  				<td style="font-weight: bold;color:#c22626;">季度考核时间设置</td>
  			</tr>
  		</table> 	
  		<form id="f" method="post">
    	<table cellpadding="0" cellspacing="0" align="center" width="95%" style="margin-top:20px;">
    		<tr>
    			<td>
    				年份<select id="year" name="year">
    					<option selected="selected">--请选择年份--</option>
    					<option value="2015年">2015年</option>
    					<option value="2016年">2016年</option>
    					<option value="2017年">2017年</option>
    					<option value="2018年">2018年</option>
    				</select>
    			</td>
    			<td>
    				季度<select id="quarter" name="quarter">
    					<option selected="selected">--请选择季度--</option>
    					<option value="第一季度">第一季度</option>
    					<option value="第二季度">第二季度</option>
    					<option value="第三季度">第三季度</option>
    					<option value="第四季度">第四季度</option>
    				</select>
    			</td>
    			<td>
    				开始时间:<input style="width: 160px; height:21px; overflow: hidden;" id="startTime" class="TextBoxStyle"  
				 	name="startTime" value=""	
					onfocus="WdatePicker({el:'startTime',dateFmt:'yyyy-MM-dd',onpicked:function(){},isShowClear:false});" />
				</td>
				<td>
				 	截止时间:<input style="width: 160px; height:21px; overflow: hidden;" id="endTime" class="TextBoxStyle"  
				 	name="endTime" value=""	
					onfocus="WdatePicker({el:'endTime',dateFmt:'yyyy-MM-dd',onpicked:function(){},isShowClear:false});" />
    			</td>
    			<td>
					 <input type="button" id="add" value="添加" width="140" style="border: none;background: #c22626;color: white;font-size: 14px;"/>	
    			</td>
    		</tr>
    	</table>
    	</form>
    	<table cellpadding="0" cellspacing="0" align="center" width="95%" border="1" bordercolor="#E4C08F" style="margin-top: 20px;text-align: center;border-collapse:collapse;">
    		<tr>
    			<td colspan="5" align="center" height="40" style="background: #F6EBE3;color: #c22626;font-weight: bold;">季度考核时间设置</td>
    		</tr>
    		<tr>
    			<td height="30">年份</td>
    			<td>季度</td>
    			<td>开始时间</td>
    			<td>结束时间</td>
    			<td>操作</td>
    		</tr>
    		<s:iterator value="list">
    		<tr>
    			<td height="30"><s:property value="year"/></td>
    			<td><s:property value="quarter"/></td>
    			<td><s:property value="startTime"/></td>
    			<td><s:property value="endTime"/></td>
    			<td><a href="<%=basePath%>/quarterManage/quarter_queryTime.action?quarterId=<s:property value='quarterId'/>">编辑</a></td>
			</tr>
    		</s:iterator>
    	</table>
    </div>
  </body>
</html>
