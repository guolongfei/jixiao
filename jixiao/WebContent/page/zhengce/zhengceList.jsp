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
<title>鄂州实绩考核系统</title>
<script type="text/javascript" src="<%=basePath%>js/jQuery.js"></script>
<style>
body{
	margin: 0;
	padding: 0;
}
a{
text-decoration: none;
color:black;
}
table
{
border-color:#E4C08F;
}
a:hover {color:#ba2636;text-decoration:none;cursor: pointer;}
.chakan{
  text-decoration:underline;
  color:red;
}
</style>
</head>
<body>
        <table cellpadding="0" cellspacing="0"  border="0" width="99%" style="padding: 5px;">
            <tr>         
                <td width="100%" valign="top">
                 <table cellpadding="0" cellspacing="0"  border="0" width="100%"  bgcolor="#F1F6FA" style="padding-left: 30px;padding-right: 30px;">
                  <tr>
                       <td height="30" colspan="3"></td>
                  </tr>
                  <tr>
                        <td><div style="color: #cc2626;font-weight: bold;">政策查询</div></td>
                  </tr>
                  <tr>
                       <td height="30" colspan="3"></td>
                  </tr>
                  <tr>
                        <td valign="bottom">文档标题:<input id="title" type="text" name="biaoti" value="<s:property value="title"/>" style="width:100px;"/> 
                                                                                             文档类型：<select id="ruletype" name="ruleType" style="height:23px;">
                                        <option>请选择</option>
                                        <s:iterator value="listrt" var="rt">
                                        <s:if test="ruleType==#rt.rule_id"><option value="<s:property value="#rt.rule_id"/>" selected="selected"><s:property value="#rt.rule_name" /></option></s:if>
                                        <<s:else><option value="<s:property value="#rt.rule_id" />"><s:property value="#rt.rule_name" /></option></s:else>
                                        </s:iterator>                                                      
                                  </select>
                            <input type="button" name="biaoti" value="查询" onclick="search();" />
                        </td>
                  </tr>
                  <tr>
                       <td height="50" colspan="3"></td>
                  </tr>
                   <tr>
                       <td>
                       <table id="table1" cellpadding="0" cellspacing="0"  border="1" bordercolor="#E4C08F" style="border-collapse:collapse;" width="100%"  >
                       <tr>
                       <td width="15%" height="30px" align="center" bgcolor="#F6EBE3"><div style="color:red;font-weight: bold;">序号</div></td>
                       <td width="50%" height="30px" align="center" bgcolor="#F6EBE3"><div style="color:red;font-weight: bold;">标题</div></td>
                       <td width="20%" height="30px" align="center" bgcolor="#F6EBE3"><div style="color:red;font-weight: bold;">时间</div></td>
                       <td width="15%" height="30px" align="center" bgcolor="#F6EBE3"><div style="color:red;font-weight: bold;">详情</div></td>
                       </tr>
                       <s:iterator value="list" status="st" var="li">
                       <tr id="trcolor<s:property value="#st.index+1" />" ondblclick="detail('<s:property value="#li.id" />');" onmousemove="changeColor(<s:property value="#st.index+1" />);" onmouseout="changeColor1(<s:property value="#st.index+1" />);">
                       <td height="40px" align="center"><s:property value="#st.index+1" /></td>
                       <td height="40px" align="center"><s:property value="#li.title" /></td>
                       <td height="40px" align="center"><s:date name="#li.add_time"  format="yyyy-MM-dd"/></td>
                       <td height="40px" align="center"><a class="chakan" href="/jixiao/messageManage/message_zhengceDetail.action?id=<s:property value="#li.id" />">查看</a></td>
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
      <input id="rtp" type="hidden" value="<s:property value="ruleType"/>" />
      <span> 共<s:property value="totalPage"/>页 页次:<s:property value="pageNum"/>/<s:property value="totalPage"/> 页</span>
      <a onclick="firstPage('<s:property value="messageType"/>');">首页</a>
      <a onclick="previous(<s:property value="pageNum"/>,'<s:property value="messageType"/>');">上一页  &nbsp;</a><span><font color=red><s:property value="pageNum"/></font></span>&nbsp;&nbsp;<a onclick="next(<s:property value="pageNum"/>,<s:property value="totalPage"/>,'<s:property value="messageType"/>');">下一页</a>
      <a onclick="endPage('<s:property value="messageType"/>',<s:property value="totalPage"/>);">尾页</a> 
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
    </body>
<script>
     //分页功能
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
         window.location.href="/jixiao/messageManage/message_getZhengceList.action?messageType="+messageType+"&pageNum="+page+"&title="+title+"&ruleType="+rtp+"";
         
     }
     var obj=document.getElementById("title").value;
     var rtp=document.getElementById("rtp").value;
     var title=encodeURI(encodeURI(obj));
     
     //首页
     function firstPage(messageType)
     {
         window.location.href="/jixiao/messageManage/message_getZhengceList.action?messageType="+messageType+"&pageNum=1&title="+title+"&ruleType="+rtp+"" ;
     }
     
     //尾页
     function endPage(messageType,pageNum)
     {
         window.location.href="/jixiao/messageManage/message_getZhengceList.action?messageType="+messageType+"&pageNum="+pageNum+"&title="+title+"&ruleType="+rtp+"" ;
     }
     //上一页
     function previous(currentPage,messageType)
     {  
         if(currentPage==1)
         {
           
                 window.location.href="/jixiao/messageManage/message_getZhengceList.action?messageType="+messageType+"&pageNum="+currentPage+"&title="+title+"&ruleType="+rtp+"" ;
             
         }
         if(currentPage>1)
         {
             currentPage=currentPage-1;
        
                 window.location.href="/jixiao/messageManage/message_getZhengceList.action?messageType="+messageType+"&pageNum="+currentPage+"&title="+title+"&ruleType="+rtp+"" ;
          
         }
     }
     //下一页
     function next(currentPage,totalPage,messageType)
     {
         if(currentPage<totalPage)
         {
             currentPage=currentPage+1;
             window.location.href="/jixiao/messageManage/message_getZhengceList.action?messageType="+messageType+"&pageNum="+currentPage+"&title="+title+"&ruleType="+rtp+"" ;           
         }
         if(currentPage>=totalPage)
         {          
              window.location.href="/jixiao/messageManage/message_getZhengceList.action?messageType="+messageType+"&pageNum="+currentPage+"&title="+title+"&ruleType="+rtp+"" ;            
         }
     }   
        
        //进入详情界面   
        function detail(id)
        {
            window.location.href="/jixiao/messageManage/message_zhengceDetail.action?id="+id+"";
        }
        
        //修改选择某一行的颜色
        function changeColor(id)
        {
            var obj=document.getElementById("trcolor"+id);          
            obj.bgColor="#99ccff";
            obj.style.cursor ="pointer";            
        } 
         function changeColor1(id)
        {
            var obj=document.getElementById("trcolor"+id);          
            obj.bgColor="";            
        }
        
        //查询功能
        function search()
        {
             var ruletype=document.getElementById("ruletype").value;
             var obj=document.getElementById("title").value;
             var title=encodeURI(encodeURI(obj));
             if(ruletype=="请选择")
             {
               window.location.href="/jixiao/messageManage/message_getZhengceList.action?title="+title+"";
             }
             else
             {
               window.location.href="/jixiao/messageManage/message_getZhengceList.action?title="+title+"&ruleType="+ruletype+"";
             }
        }   
</script>
</html>