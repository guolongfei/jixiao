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
<title>年考核</title>
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
 document.getElementById("f").action="/jixiao/messageManage/record_gradeList.action";
 document.getElementById("f").submit();
 }
 </script>
<body>
<form action="" name="f" id="f" method="post">
        <table cellpadding="0" cellspacing="0"  border="0" width="100%">
            <tr>
                <td width="85%" valign="top">
                 <table cellpadding="0" cellspacing="0"  border="0" width="100%" height="100%" bgcolor="#F1F6FA" style="padding-left: 30px;padding-right: 30px;">
                  <tr>
                       <td height="50" colspan="3"></td>
                  </tr>
                  <tr>
                  		<td>年份
                  		<select id="year" name="year">
     					<option value="">请选择</option>
     					<option value="2015" <s:if test='year == 2015'> selected="selected"</s:if>>2015年</option>
     					<option value="2014" <s:if test='year == 2014'> selected="selected"</s:if>>2014年</option>
     					<option value="2013" <s:if test='year == 2013'> selected="selected"</s:if>>2013年</option>
     					</select>
                      	 职务
                      	 <select id="recordState" name="recordState">
     					<option value="">请选择</option>
     					<option value="1" <s:if test='recordState== 1'> selected="selected"</s:if>>主要领导</option>
     					<option value="2" <s:if test='recordState== 2'> selected="selected"</s:if>>领导班子副职</option>
     					<option value="3" <s:if test='recordState== 3'> selected="selected"</s:if>>正科</option>
     					<option value="4" <s:if test='recordState== 4'> selected="selected"</s:if>>副科</option>
     					<option value="5" <s:if test='recordState== 5'> selected="selected"</s:if>>其他干部</option>
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
	                       <td width="15%" height="30px" align="center" bgcolor="#F6EBE3"><div style="color:red;font-weight: bold;">年份</div></td>
	                       <td width="15%" height="30px" align="center" bgcolor="#F6EBE3"><div style="color:red;font-weight: bold;">评分类型</div></td>
	                       <td width="15%" height="30px" align="center" bgcolor="#F6EBE3"><div style="color:red;font-weight: bold;">姓名</div></td>
	                       <td width="15%" height="30px" align="center" bgcolor="#F6EBE3"><div style="color:red;font-weight: bold;">分数</div></td>
	                       <td width="15%" height="30px" align="center" bgcolor="#F6EBE3"><div style="color:red;font-weight: bold;">部门</div></td>
	                       <td width="15%" height="30px" align="center" bgcolor="#F6EBE3"><div style="color:red;font-weight: bold;">职务</div></td>
	                       </tr>
	                       <s:iterator value="list" var="li" status="st">
	                       <tr id="trcolor<s:property value="#st.index+1" />"   onmousemove="changeColor(<s:property value="#st.index+1" />);" onmouseout="changeColor1(<s:property value="#st.index+1" />);">
	                       <td height="40px" align="center"><s:date name="#li.gradeDate" format="yyyy年"></s:date></td>
	                       <td height="40px" align="center"><s:property value="#li.gradeTypeId.gradeTypeName"/></td>
	                       <td height="40px" align="center"><s:property value="#li.peopleId.name"/></td>
	                       <td height="40px" align="center"><s:property value="#li.gradeScore"/></td>
	                       <td height="40px" align="center"><s:property value="#li.departmentId.name"/></td>
	                       <td height="40px" align="center"><s:property value="#li.postId.postName"/></td>
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
</html>