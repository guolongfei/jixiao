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
    
    <title>部门绩效</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="/jixiao/css/perf_style.css">
	<script type="text/javascript" src="/jixiao/js/jQuery.js" ></script>
	<STYLE type="text/css">
	  td{border: 1px solid #E4C08F;font-family: 微软雅黑;}
	  th{border: 1px solid #E4C08F;height:30px;}
	  body{
			margin:0;
			padding:0;
			background: url("<%=basePath%>images/jkn_2.jpg") repeat-x;
		}
	  a{text-decoration: none;}
	</STYLE>
    <script type="text/javascript">
	    function que(msg,msg1,msg2,obj){
	        var ms1 = encodeURI(msg);
	        var ms2 = encodeURI(ms1);
	        var h = "/jixiao/performance/performance_getOthersPerformance.action?empId="+msg1+"&empName="+ms2+"&postId="+msg2;
	        obj.href = h;
	     }
	     
	     
       function fenye(type1){
         var currentpage = ${pageNum};
         var totalPage = ${totalPage};
         var url = "/jixiao/performance/performance_getPeopleList.action";
         if(type1==1){
           url += "?pageNum=1";
         }else if(type1==2){
           var m = currentpage-1;
           url += "?pageNum="+m;
         }else if(type1==3){
           var m = currentpage+1;
           url += "?pageNum="+m;
         }else{
           url += "?pageNum="+totalPage;
         }
         $("#dep").attr("action",url);
         $("#dep").submit();
      }
    </script>
  </head>
  
  <body>

  <form action="" method="post" id="dep">
  <table cellpadding="0" cellspacing="0" width="95%" height="520" style="background-color: white;">
  	<tr>
  		<td valign="top">
  			<div style="height:33px; width:90%;background-color:#2D92EA;margin:0px auto;line-height: 33px;margin-top: 30px;" align="left">
                   <span style="font-family: 微软雅黑;font-weight: bolder;font-size: 0.9em;color:white;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;部门人员实绩</span>
     		</div>
     <div style="width: 90%;margin: 0 auto;">
          <table width="100%" cellspacing="0" style="border-collapse:collapse;" >
            <tr style="background-image: url('/jixiao/images/ss.png');background-repeat: repeat-x; ">
               <th align="center" style="width: 10%;color: #2D92EA">姓名</th>
               <th align="center" style="width: 10%;color: #2D92EA">职位</th>
               <th align="center" style="width: 70%;color: #2D92EA">工作职责</th>
               <th align="center" style="width: 10%;color: #2D92EA">查看绩效</th>            
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
                <a onclick="que('<s:property value="#item.name"/>','<s:property value="#item.id"/>','<s:property value="#item.posttable.postId"/>',this)" href="javascript:void(0)">查看</a>
                </td>
              </tr>
            </s:iterator>
          </table>
     </div>
  		</td>
  	</tr>
  </table>
  <div style="height: 50px;width: 90%;margin: 0 auto;line-height: 50px;">
          <input type="hidden" value="<s:property value='totalPage'/>" name="totalPage">
        
          <span> 共&nbsp;<font color=red><s:property value="totalPage"/></font>&nbsp;页 </span>
          <a href="javascript:void(0)" onclick="fenye('1')">首页</a>
          <a onclick="fenye('2');" href="javascript:void(0)">上一页  &nbsp;</a><span><font color=red><s:property value="pageNum"/></font></span>&nbsp;&nbsp;<a onclick="fenye('3');" href="javascript:void(0)">下一页</a>
          <a onclick="fenye('4');" href="javascript:void(0)">尾页</a> 
     </div>
 </form> 
  </body>
</html>
