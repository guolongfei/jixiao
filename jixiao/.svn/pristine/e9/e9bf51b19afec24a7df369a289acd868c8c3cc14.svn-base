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
<title>投票统计列表</title>
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
 document.getElementById("f").action="/jixiao/messageManage/record_voteGather.action";
 document.getElementById("f").submit();
 }
 
 
 </script>
<body>
<form action="" name="f" id="f" method="post">
        <table cellpadding="0" cellspacing="0"  border="0" width="100%">
            <tr>
                <td width="85%" valign="top">
                 <table cellpadding="0" cellspacing="0"  border="0" width="100%"  bgcolor="#F1F6FA" style="padding-left: 30px;padding-right: 30px;">
                  <tr>
                       <td height="50" colspan="3"></td>
                  </tr>
               		<tr>
                  		<td>
                      	 测评类型
                      	<select id="recordState" name="recordState">
								<option value=""/> --请选择--</option>
	                    		<option value="1" <s:if test='recordState == 1'> selected="selected"</s:if>/>--内部测评--</option>
	                    		<option value="0" <s:if test='recordState == 0'> selected="selected"</s:if>/>--外部测评--</option>
						</select>
     				 <input type="button" onclick="query()" value="查询"/>
				</td>
                      	 
                  </tr>
                  
                   <tr>
                       <td height="50" colspan="3"></td>
                  </tr>
                  
                   <tr>
                       <td>
                       <table cellpadding="0" cellspacing="0"  border="1" bordercolor="#E4C08F" style="border-collapse:collapse;" width="100%" height="100%">
	                       <tr>
	                       <td width="15%" height="30px" align="center" bgcolor="#F6EBE3"><div style="color:red;font-weight: bold;">编号</div></td>
	                       <td width="15%" height="30px" align="center" bgcolor="#F6EBE3"><div style="color:red;font-weight: bold;">部门名称</div></td>
	                       <td width="15%" height="30px" align="center" bgcolor="#F6EBE3"><div style="color:red;font-weight: bold;">级别</div></td>
	                       <td width="15%" height="30px" align="center" bgcolor="#F6EBE3"><div style="color:red;font-weight: bold;">票数</div></td>
	                       </tr>
	                       <s:iterator value="list" var="li" status="st">
	                       <tr id="trcolor<s:property value="#st.index+1" />"   onmousemove="changeColor(<s:property value="#st.index+1" />);" onmouseout="changeColor1(<s:property value="#st.index+1" />);">
	                      <td height="40px" align="center"><s:property value="#st.index+1" /></td>
	                       <td height="40px" align="center"><s:property value="#li[0]" /></td>
	                       <td height="40px" align="center"><s:property value="#li[1]" /></td>
	                       <td height="40px" align="center"><s:property value="#li[2]" /></td>
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
      <a href="/jixiao/messageManage/record_voteGather.action"/>首页</a>
      <a onclick="previous(<s:property value="pageNum"/>);">上一页  &nbsp;</a><span><font color=red><s:property value="pageNum"/></font></span>&nbsp;&nbsp;<a onclick="next(<s:property value="pageNum"/>,<s:property value="totalPage"/>);">下一页</a>
      <a href="/jixiao/messageManage/record_voteGather.action"/>尾页</a> 
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