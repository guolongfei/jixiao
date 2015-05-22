<%@ page language="java" import="java.util.*,java.net.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>季评鉴</title>
    
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
      function que(msg,msg1,obj){
        alert(msg);
        var ms1 = encodeURI(msg);
        var ms2 = encodeURI(ms1);
        var h = "/jixiao/performance/performance_getOthersPerformance1.action?empId="+msg1+"&empName="+ms2;
        obj.href = h;
      }
    </SCRIPT>
  </head>
  
  <body>
    <div style="height:33px; width:90%;background-image: url('/jixiao/images/jkn_11.png');background-repeat:repeat;margin:0px auto;line-height: 33px;" align="left">
                   <span style="font-family: 微软雅黑;font-weight: bolder;font-size: 0.9em;color:white;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;部门人员实绩</span>
     </div>
     <div style="width: 90%;margin: 0 auto;">
          <table width="100%" cellspacing="0" style="border-collapse:collapse;" >
            <tr style="background-image: url('/jixiao/images/ss.png');background-repeat: repeat-x; ">
               <th align="center" style="width: 10%;color: #D84B4B">姓名</th>
               <th align="center" style="width: 10%;color: #D84B4B">职位</th>
               <th align="center" style="width: 70%;color: #D84B4B">工作职责</th>
               <th align="center" style="width: 10%;color: #D84B4B">季评鉴</th>            
            </tr>
            <s:iterator var="item" value="jpList">
              <tr>
                <td width="10%" align="center" height="35px">
                  <s:property value="#item.name"/>
                </td>
                <td width="10%" align="center" height="35px">
                  <s:property value="#item.posttable.postName"/>
                </td>
                <td width="70%" align="center" height="35px">
                  <s:property value="#item.duty"/>
                </td>
                <td width="10%" align="center" height="35px">
                <a onclick="que('<s:property value="#item.name"/>','<s:property value="#item.id"/>',this)" href="javascript:void(0)">季评鉴</a>
                </td>
              </tr>
            </s:iterator>
          </table>
     </div>
     <div style="height: 50px;width: 90%;"></div>
  </body>
</html>
