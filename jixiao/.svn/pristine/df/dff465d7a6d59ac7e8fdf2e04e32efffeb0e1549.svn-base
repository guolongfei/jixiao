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
    
    <title>我的考学</title>
    <script type="text/javascript" src="<%=basePath%>js/jQuery.js"></script>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style>
.la03 {
	font-family: "宋体";
	font-size: 18px;
	color: #000000;
	font-weight: bold;
}
.textarea
{
   width: 100%;
   height: 130px;
   borderColor:#E4C08F;
}
.select
{
   width:70px;
   height:35px;
   borderColor:#E4C08F;
}
</style>
  </head>
  
  <body>
  <form id="form" method="post">
     <table cellpadding="0" cellspacing="0"  border="0" width="100%">
            <tr>
                <td width="100%" valign="top">
             
            <table cellpadding="0" cellspacing="0"  border="0" width="100%" height="100%"  bgcolor="#F1F6FA" style="padding-left: 30px;padding-right: 30px;">
                  <tr>
                       <td height="30" colspan="3"></td>
                  </tr>
                  <tr>
                        <td><div style="color: #cc2626;font-weight: bold;">考学查询</div></td>
                  </tr>
                  <tr>
                       <td height="30" colspan="3"></td>
                  </tr>
                  <tr>
                        <td><input id="inputYear" type="hidden" value="<s:property value="year"/>"/><SELECT id="year" name="year" class="select" onchange="changeYear();"></SELECT></td>
                  </tr>
                  <tr>
                       <td height="30" colspan="3"></td>
                  </tr>
                   <tr>
                       <td>
                       <table id="table1" cellpadding="0" cellspacing="0"  border="1" bordercolor="#E4C08F" style="border-collapse:collapse;" width="100%" height="100%" >
                       <tr>
                       <td width="10%" height="30px" align="center" bgcolor="#F6EBE3"><div style="color:red;font-weight: bold;">序号</div></td>
                       <td width="10%" height="30px" align="center" bgcolor="#F6EBE3"><div style="color:red;font-weight: bold;">姓名</div></td>
                       <td width="10%" height="30px" align="center" bgcolor="#F6EBE3"><div style="color:red;font-weight: bold;">考评</div></td>
                       <td width="60%" height="30px" align="center" bgcolor="#F6EBE3"><div style="color:red;font-weight: bold;">内容</div></td>
                       <td width="10%" height="30px" align="center" bgcolor="#F6EBE3"><div style="color:red;font-weight: bold;">时间</div></td>
                       </tr>
                       <s:iterator value="list" status="st" var="li">
                       <tr id="trcolor<s:property value="#st.index+1" />"   onmousemove="changeColor(<s:property value="#st.index+1" />);" onmouseout="changeColor1(<s:property value="#st.index+1" />);">
                       <td width="10%" height="40px" align="center" ><s:property value="#st.index+1"/></td>
                       <td width="10%" id="ct<s:property value="#st.index+1" />" width="50%" height="40px" align="center" ><s:property value="name" /></td>
                       <td width="10%" height="40px" align="center" ><s:property value="#li.text_grade"/></td>
                       <td width="60%" height="40px" align="center" >在线学习政策法规得到**分，表现良好得到**分，**原因扣除**分</td>
                       <td width="10%" height="40px" align="center" ><s:date name="#li.text_time"  format="yyyy-MM-dd"/></td>
                       </tr>
                       </s:iterator>
                       </table>                      
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
  <script>
  $(function()
   {
     var myDate = new Date();  
     var year=myDate.getFullYear();
     var year1=$("#inputYear").val();
     var str;
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
     
     function changeYear()
     {     
         var year=$("#year").val();
         window.location.href="/jixiao/TextManage/TextManage_getMyInexepensiveText.action?year="+year;
     }
  var flag=0;
  function changeColor2()
  {
       var obj=document.getElementById("chengji");          
       obj.style.borderColor="#E4C08F"; 
  }
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
  </script>
</html>
