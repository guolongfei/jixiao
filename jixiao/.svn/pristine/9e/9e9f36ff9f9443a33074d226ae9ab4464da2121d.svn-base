<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>鄂州实绩考核网</title>
<script type="text/javascript" src="../js/jQuery.js"></script>
 <link href="../css/style.css" rel="stylesheet" type="text/css"/>
</head>
<style>
.container
{
   margin:0 auto; 
   padding: 0; 
   width: 1003px;
}
</style>

<jsp:include page="header.jsp"/>
<body>
<table width="1003" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="8" bgcolor="#FFFFFF"></td>
  </tr>
</table>
<table width="1003" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
  <tr>
    <td width="240" valign="top"><table width="230" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td height="500" valign="top">
            <table width="100%" border="0" cellpadding="0" cellspacing="0" class="line1">
              <tr>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" background="../images/index_22.jpg">
                    <tr>
                      <td width="12%" height="33"><img src="../images/index_20.jpg" width="28" height="33" /></td>
                      <td width="88%" class="titel02">通知公告</td>
                    </tr>
                </table></td>
              </tr>
              <tr>
                <td height="5"></td>
              </tr>
              <tr>
                <td><table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
                <s:iterator value="list1" status="status" var="li">
                    <tr>
                      <td width="4%" height="30" align="center" class="line7"><img src="../images/ej_06.gif" width="6" height="6" /></td>                 
                      <td width="96%" class="line6" align="left"><a href="/jixiao/messageManage/message_detail.action?id=<s:property value="#li.id"/>" title="<s:property value='#li.title'/>"><div style="width:170px;overflow:hidden;text-overflow:ellipsis;white-space:nowrap;">&nbsp;<s:property value="#li.title"/></div></a></td>
                    </tr>
                </s:iterator>                          
                </table></td>
              </tr>
              <tr>
                <td height="10"></td>
              </tr>
            </table>
         </td>
      </tr>
    </table></td>
    <td width="763" valign="top"><table width="99%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" background="../images/ldxx_04.gif">
            <tr>
              <td width="6%"><img src="../images/ldxx_03.gif" width="41" height="34" /></td>
              <td width="94%">当前位置：
                  <a href="/jixiao/messageManage/homePage_getList.action" target="_blank">首页</a>&nbsp;>&nbsp;
                  <a href="#" target="_blank" class="CurrChnlCls">实绩评价</a></td>
            </tr>
        </table></td>
      </tr>
      <tr>
        <td height="10"></td>
      </tr>
      <tr>
        <td><table width="96%" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr >
              <td height="37" background="../images/bs.gif"><table width="96%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="5%" align="center"><img src="../images/bs_43.gif" width="11" height="11" /></td>
                    <td width="95%" class="titel02">实绩评价</td>
                  </tr>
              </table></td>
            </tr>
            <tr>
              <td><table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" class="box">
                  
                  <s:iterator value="appraiseList" status="status" var="li">
                    <tr>
                      <td width="4%" height="30" align="center" class="line7"><img src="../images/ej_06.gif" width="6" height="6" /></td>
                      <td width="81%" class="line7"><a href="../messageManage/message_detail.action?id=<s:property value='#li.messageReleasesId'/>&messageType=0" title="<s:property value='#li.content'/>"><s:property value="#li.content" /></a></td>
                      <td width="15%" align="right" class="line7">(
                        <s:date name="#li.appraise_time"  format="yyyy-MM-dd"/>
                        )</td>
                    </tr>
                    </s:iterator>              
              </table></td>
            </tr>
        </table></td>
      </tr>
      <tr>
        <td height="20"></td>
      </tr>
      <tr>
        <td><table width="96%" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr>
              <td height="30" align="right"><P class=page_num>
<div class="pagelink">
      <input id="max" type="hidden" value="<s:property value="totalPage"/>" />
      <input id="cur" type="hidden" value="<s:property value="pageNum"/>" />
      <span> 共<s:property value="totalPage"/>页 页次:<s:property value="pageNum"/>/<s:property value="totalPage"/> 页</span>
      <a href="<%=basePath%>messageManage/message_AppraiseList.action?pageNum=1">首页</a>
      <a onclick="previous(<s:property value="pageNum"/>);" style="cursor: pointer;" title="上一页">上一页  &nbsp;</a><span><font color=red><s:property value="pageNum"/></font></span>&nbsp;<a onclick="next(<s:property value="pageNum"/>,<s:property value="totalPage"/>);" style="cursor: pointer;" title="下一页">下一页</a>
      <a href="<%=basePath%>messageManage/message_AppraiseList.action?pageNum=<s:property value="totalPage"/>">尾页</a> 
                   转到 <SELECT id="selection" NAME="select" onchange="changeValue();"><option selected=selected>1</option></SELECT>
</div>
</P></td>
            </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
</table>
</body>
<jsp:include page="footer.jsp"/>
<script>
     $(function()
     {
     var num=$("#max").val();
     var page=$("#cur").val();
     var str;
     for(var i=1;i<=num;i++)
     {
        if(page==i)
        {
           str+="<option value='"+i+"' selected='selected'>"+i+"</option>";
        }
        else
        {
	       str+="<option value='"+i+"' >"+i+"</option>";
	    }
	 }     
     $("#selection").html(str);     
     })
     function changeValue(messageType)
     {
         var page=$("#selection").val();
         window.location.href="<%=basePath%>"+"messageManage/message_AppraiseList.action?pageNum="+page;
         
     }
     function previous(currentPage)
     {  
         if(currentPage==1)
         {
             window.location.href="<%=basePath%>"+"messageManage/message_AppraiseList.action?pageNum="+currentPage;
         }
         if(currentPage>1)
         {
             currentPage=currentPage-1;
             window.location.href="<%=basePath%>"+"messageManage/message_AppraiseList.action?pageNum="+currentPage;
         }
     }
     
     function next(currentPage,totalPage)
     {
         if(currentPage<totalPage)
         {
             currentPage=currentPage+1;
             window.location.href="<%=basePath%>"+"messageManage/message_AppraiseList.action?pageNum="+currentPage;
         }
         if(currentPage>=totalPage)
         {
             window.location.href="<%=basePath%>"+"messageManage/message_AppraiseList.action?pageNum="+currentPage;
         }
     }
</script>
</html>
