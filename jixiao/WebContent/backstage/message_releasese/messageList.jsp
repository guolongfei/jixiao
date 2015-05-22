<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>鄂州市绩效考核网</title>
<link href="<%=basePath%>inc/css/lib/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="<%=basePath%>js/jQuery.js"></script>
<STYLE type="text/css">
	a{
		text-decoration: none;
		cursor: pointer;
	}
	.lj{
		color:#333333;
	}
	.lj:HOVER {
		color: #c22626;
		cursor: pointer;
	}
</STYLE>
</head>
<body>
<div style="height: 600px;">
	<table cellpadding="" cellspacing="" width="95%" align="center" height="30" style="margin-top: 35px;">
		<tr>
			<td width="93%" style="color: #235C9D;font-weight: bold;">信息发布列表</td>
			<td align="center"><a class="btn btn-primary" href="message_bs_gotoMessageAddPage.action">添加</a></td>
		</tr>
	</table>	
	<table cellpadding="0" cellspacing="0" width="95%" align="center" border="1" bordercolor="#E4C08F"  style="text-align: center;border-collapse:collapse;margin-top: 30px;">			
									<tr height="30">
										<th>序号</th>
										<th>标题</th>
										<th>类型</th>
										<th>创建人</th>
										<th>创建单位</th>
										<th>创建时间</th>										
										<th>操作</th>
									</tr>
									<!-- 列表数据在这循环输出 -->								
									<s:iterator value="list2" status="st" var="li">									
										<tr>
											<td><s:property value="#st.index+1" /></td>
											<td><a class="lj" href="<%=basePath%>messageManage/message_zhengceDetail.action?id=<s:property value="#li[0]" />"><s:property value="#li[1]" /></a></td>											
											<td><s:property value="#li[2]" /></td>
											<td><s:property value="#li[4]" /></td>
											<td><s:property value="#li[5]" /></td>
											<td><s:date name="#li[3]" format="yyyy-MM-dd hh:mm:ss"/></td>											
											<td><a class="btn btn-primary" href="<%=basePath%>messageManage/message_deleteMes.action?id=<s:property value="#li[0]" />">删除</a></td>
										</tr>
									</s:iterator>
							</table>
						<table cellpadding="0" cellspacing="0" align="center" width="95%" style="margin-top: 8px;">
							<tr>
								<td align="right">
								<input id="max" type="hidden" value="<s:property value="totalPage"/>" />
                                <input id="cur" type="hidden" value="<s:property value="pageNum"/>" />
										<span> 共<s:property value="totalPage"/>页 页次:<s:property value="pageNum"/>/<s:property value="totalPage"/> 页</span>
      <a class="lj" onclick="firstPage('<s:property value="messageType"/>');">首页</a>
      <a class="lj" onclick="previous(<s:property value="pageNum"/>,'<s:property value="messageType"/>');">上一页  &nbsp;</a><span><font color=red><s:property value="pageNum"/></font></span>&nbsp;&nbsp;<a class="lj" onclick="next(<s:property value="pageNum"/>,<s:property value="totalPage"/>,'<s:property value="messageType"/>');">下一页</a>
      <a class="lj" onclick="endPage('<s:property value="messageType"/>',<s:property value="totalPage"/>);">尾页</a> 
                   转到 <SELECT id="selection" style="width: 50px;" NAME="select" onchange="changeValue('<s:property value="messageType"/>');"><option selected=selected>1</option></SELECT>
								</td>
							</tr>
						</table>	
	</div>															
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
         window.location.href="<%=basePath%>messageManage/message_bs_getMessageList.action?pageNum="+page;
         
     }
     var obj=document.getElementById("title").value;
     var rtp=document.getElementById("rtp").value;
     var title=encodeURI(encodeURI(obj));
     
     //首页
     function firstPage(messageType)
     {
         window.location.href="<%=basePath%>messageManage/message_bs_getMessageList.action?pageNum=1" ;
     }
     
     //尾页
     function endPage(messageType,pageNum)
     {
         window.location.href="<%=basePath%>messageManage/message_bs_getMessageList.action?pageNum="+pageNum;
     }
     //上一页
     function previous(currentPage,messageType)
     {  
         if(currentPage==1)
         {
           
                 window.location.href="<%=basePath%>messageManage/message_bs_getMessageList.action?pageNum="+currentPage;
             
         }
         if(currentPage>1)
         {
             currentPage=currentPage-1;
        
                 window.location.href="<%=basePath%>messageManage/message_bs_getMessageList.action?pageNum="+currentPage;
          
         }
     }
     //下一页
     function next(currentPage,totalPage,messageType)
     {
         if(currentPage<totalPage)
         {
             currentPage=currentPage+1;
             window.location.href="<%=basePath%>messageManage/message_bs_getMessageList.action?pageNum="+currentPage ;           
         }
         if(currentPage>=totalPage)
         {          
              window.location.href="<%=basePath%>messageManage/message_bs_getMessageList.action?pageNum="+currentPage;            
         }
     }
    
</script>
</body>
</html>