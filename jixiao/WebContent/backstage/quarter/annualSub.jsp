<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>鄂州实绩考核网</title>
    <script type="text/javascript" src="<%=basePath%>js/jQuery.js"></script>
	<script src="<%=basePath%>datepicker/WdatePicker.js"></script>
	<link href="<%=basePath%>datepicker/WdatePicker.css"/>
	<style type="text/css">
		input{
			width: 100px;
		}
		
	</style>

  </head>
  
  <body style="background: #F1F6FA;"> 
  	<div style="height: 500px;">
  		<table cellpadding="0" cellspacing="0" align="center" width="95%" style="margin-top: 40px;">
  			<tr>
    			<td colspan="5" style="color:#c22626;font-weight: bold;">年度考核未提交查询</td>
    		</tr>
  		</table>
    	<form id="f" method="post">
    	<table cellpadding="0" cellspacing="0" align="center" width="95%" style="margin-top: 20px;">
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
    				职员编号:<input type="text" name="" value=""/>
    			</td>
    			<td>
    				部门:<input type="text" name="" value=""/>
    			</td>
    			<td>
    				日期:<input style="width: 100px; height:21px; overflow: hidden;" id="startTime" class="TextBoxStyle"  
				 	name="startTime" value=""	
					onfocus="WdatePicker({el:'startTime',dateFmt:'yyyy-MM-dd',onpicked:function(){},isShowClear:false});" />
				</td>
				<td>
					<input type="button" value="查询" style="border: none;font-size: 14px;vertical-align: middle;background: #c22626;color: white;font-weight: bold;width: 80px;"/>
				</td>	
    		</tr>
    	</table>
    	</form>
    	<table cellpadding="0" cellspacing="0" align="center" width="95%" border="1" bordercolor="#E4C08F" style="margin-top: 20px;text-align: center;border-collapse:collapse;">
    		<tr>
    			<td colspan="5" align="center" height="40" style="color: #c22626;font-weight: bold;font-size: 16px;background: #F6EBE3;">年度考核未提交人员</td>
    		</tr>
    		<tr>
    			<td height="30">年份</td>
    			<td>季度</td>
    			<td>部门</td>
    			<td>姓名</td>
    		</tr> 
    		<tr>
    			<td height="30">2014</td>
    			<td>第二季度</td>
    			<td>宣传部</td>
    			<td>xxx</td>
    		</tr>
    		<tr>
    			<td height="30">2014</td>
    			<td>第二季度</td>
    			<td>宣传部</td>
    			<td>xxx</td>
    		</tr>
    		<tr>
    			<td height="30">2014</td>
    			<td>第二季度</td>
    			<td>宣传部</td>
    			<td>xxx</td>
    		</tr>
    	</table>
    </div>
  </body>
</html>
