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
    
    <title>菜单名称管理</title>
    <script type="text/javascript" src="<%=basePath%>js/jQuery.js"></script>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script type="text/javascript" src="<%=basePath%>js/jQuery.js" ></script>
	<script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>
	<link href="<%=basePath%>css/loginbox.css" rel="stylesheet" type="text/css"/>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style>
a:hover {color:red;text-decoration:none;cursor: pointer;}
.chakan{
  text-decoration:underline;
  color:red;
}
</style>
<SCRIPT type="text/javascript">

      function xiuGai(id,name)
      {
      $('.theme-popover').slideDown(200);
      document.getElementById("msgName").value=name;
      document.getElementById("msgId").value=id;
      }
     function boxclose(){
	$('.theme-popover').slideUp(200);
    }
    
    function sureChange()
    {
        var ct=document.getElementById("msgName").value;
        if(ct=="")
        {
          alert("内容不能为空");
          return;
        }
        $("#form1").submit();
    }

</SCRIPT>
  </head>
  
  <body>
  <form id="form1" method="post" action="<%=basePath%>messageManage/message_updateType.action">
   <div class="theme-popover" style="height:140px;">
	     <div class="theme-poptit" align="left">
	           <a title="关闭" class="close" onclick="boxclose()">×</a>
	          <h3>名称修改</h3>
	     </div>
	     <div class="theme-poptit" >
	          <div style="float:left;"><h3>名称:</h3>
	          </div> 
	          <input id="msgName" type="text" name="titleName"/>
	          <input id="msgId" type="hidden" name="messageType"/>
	     </div>
	     <div class="theme-poptit" >
	          <input type="button" value="确认修改" onclick="sureChange();" />
	     </div>
   </div>
   </form>
  
  <form id="form" method="post">
     <table cellpadding="0" cellspacing="0"  border="0" width="100%">
            <tr>
                <td width="100%" valign="top">
             
            <table cellpadding="0" cellspacing="0"  border="0" width="100%" height="100%"  bgcolor="#F1F6FA" style="padding-left: 30px;padding-right: 30px;">
                  <tr>
                       <td height="30" colspan="3"></td>
                  </tr>
                  <tr>
                        <td><div style="color: #cc2626;font-weight: bold;">菜单名称管理</div></td>
                  </tr>
                   <tr>
                       <td height="30" colspan="3"></td>
                  </tr>
                   <tr>
                       <td>
                       <table id="table1" cellpadding="0" cellspacing="0"  border="1" bordercolor="#E4C08F" style="border-collapse:collapse;" width="100%" height="100%" >
                       <tr>
                       <td width="60%" height="30px" align="center" bgcolor="#F6EBE3"><div style="color:red;font-weight: bold;">名称</div></td>
                       <td width="20%" height="30px" align="center" bgcolor="#F6EBE3"><div style="color:red;font-weight: bold;">操作</div></td>
                       </tr>
                       <s:iterator value="listmt" status="st" var="li">
                       <tr id="trcolor<s:property value="#st.index+1" />"   onmousemove="changeColor(<s:property value="#st.index+1" />);" onmouseout="changeColor1(<s:property value="#st.index+1" />);">
                       <td width="60%" id="ct<s:property value="#st.index+1" />" width="50%" height="40px" align="center" ><s:property value="#li.type_name" /></td>
                       <td width="20%" height="40px" align="center" ><a onclick="xiuGai(<s:property value="#li.type_id" />,'<s:property value="#li.type_name" />');" class="chakan" class="chakan">修改</a></td>
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
