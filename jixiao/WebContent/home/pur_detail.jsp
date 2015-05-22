<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>工作实绩详情</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <style type="text/css">
    .eva_td{
	     height: 40px;
	     border: 1px solid #CCCCFF;
	     font-family: 微软雅黑;
	     font-size: 0.9em;
	   }
    </style>
  </head>
  <body style="margin: 0;">
    
     <div style="width: 870px;height: 1200px;margin: 0 auto;">
       <div style="width:870px;order: 1px solid #ccc;float: left;background-color: white;">
          <div style="width: 90%;height: 50px;line-height: 50px;font-size: 1.2em;font-family: 微软雅黑;margin: 0 auto;font-weight: bold;" align="center">
                                               华容区2014年工作目标
          </div>
          <div style="width: 90%;margin: 0 auto;height: 150px;border-top: 1px solid #CCCCFF;font-size: 1.0em;padding-top: 20px;">
                            &nbsp;&nbsp;&nbsp;&nbsp;建立健全市青年企业家联合会工作机制，实施青年企业家能力素质提升工程；依托青企联会员开展以商招商工作；积极服务省运会场馆等重大项目建设。
          </div>

          <table style="border-collapse:collapse;margin: 15 auto;" width="90%">
            <tr>
              <td style="background-color: #9999FF;font-size: 1.0em;font-weight: bolder;color: white;height: 30px;">当前评价</td>
            </tr>
             <tr>
              <td class="eva_td"><span>&nbsp;&nbsp;雷某某&nbsp;&nbsp;评价: </span>&nbsp;&nbsp;&nbsp;&nbsp;<span style="color:blue;">很重要，希望认真落实！</span>&nbsp;&nbsp;&nbsp;&nbsp;<span style="">2014-6-16</span></td>
            </tr>
             <tr>
              <td class="eva_td"><span>&nbsp;&nbsp;雷某某&nbsp;&nbsp;评价：</span>&nbsp;&nbsp;&nbsp;&nbsp;<span style="color:blue;">很重要，希望认真落实！</span>&nbsp;&nbsp;&nbsp;&nbsp;<span style="">2014-6-16</span></td>
            </tr>
            <tr>
              <td class="eva_td"><span>&nbsp;&nbsp;雷某某&nbsp;&nbsp;评价：</span>&nbsp;&nbsp;&nbsp;&nbsp;<span style="color:blue;">很重要，希望认真落实！</span>&nbsp;&nbsp;&nbsp;&nbsp;<span style="">2014-6-16</span></td>
            </tr>
          </table>
          <table style="border-collapse:collapse;margin: 0 auto;" width="90%">
            <tr>
              <td style="background-color: #9999FF;font-size: 1.0em;font-weight: bolder;color: white;height: 30px;" colspan="2">我要评价</td>
            </tr>
           </table>
           <table width="90%" style="margin: 0 auto;border: 1px solid #cccccc;border-top: none;">       
            <tr>
              <td align="center">姓名：<input type="text" /> </td><td align="center">联系电话：<input type="text" /> </td>
            </tr>
             <tr style="" align="center">
               <td style="height: 100px;"  colspan="2">
                 <textarea rows="" cols="" style="width: 700px;height: 100px;resize:none;font-size: 14px;"></textarea>
               </td>
             </tr>
             <tr>           	
             	<td height="5"></td>
             </tr>
             <tr>
               <td colspan="2" align="center">
               	<img alt="" src="/jixiao/images/tijiao.jpg">
               </td>
             </tr>
             <tr>
             	<td height="10"></td>
             </tr>
          </table>
          <div style="height: 10px;">
          	
          </div>
       </div>
      </div>
  </body>
</html>
