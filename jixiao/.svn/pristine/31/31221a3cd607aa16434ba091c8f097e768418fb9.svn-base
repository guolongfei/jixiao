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
<title>工作组列表</title>
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
    <form id="form"  method="post">
	<table cellpadding="" cellspacing="" width="95%" align="center" height="30" style="margin-top: 35px;">
		<tr>
			<td width="93%" style="color: #235C9D;font-weight: bold;">工作组列表</td>
			<td align="center"><a class="btn btn-primary" href="<%=basePath%>roomManager/roomManager_addRoom.action">添加</a></td>
		</tr>
		<tr height="30">
		</tr>
			<tr ><td>工作组名：
			         <input type="text" name="roomName" value="<s:property value="roomName" />">
			         <input type="submit" value="查询">
                     <input id="yema" type="hidden" name="pageNum">
                     <input id="room_id" type="hidden" name="room_id">
                        </td></tr>		
	</table>
	</form>	
	<table cellpadding="0" cellspacing="0" width="95%" align="center" border="1" bordercolor="#E4C08F"  style="text-align: center;border-collapse:collapse;margin-top: 30px;">	

									<tr height="30">
										<th>序号</th>
										<th>工作组名</th>								
										<th>创建时间</th>
										<th>工作组成员数</th>										
										<th>操作</th>
									</tr>
									<!-- 列表数据在这循环输出 -->								
									<s:iterator value="list" status="st" var="li">									
										<tr>
											<td><s:property value="#st.index+1" /></td>
											<td><s:property value="#li.room_name" /></td>											
											<td><s:date name="#li.room_create_date" format="yyyy-MM-dd hh:mm:ss"/></td>
											<td><s:property value="#li.room_member_num" /></td>											
											<td> <a class="btn btn-primary" onclick="updateRoom('<s:property value="#li.room_server_id" />');">修改</a>
											     <a class="btn btn-primary" onclick="deleteRoom('<s:property value="#li.room_server_id" />');">删除</a></td>
										</tr>
									</s:iterator>
							</table>
						<table cellpadding="0" cellspacing="0" align="center" width="95%" style="margin-top: 8px;">
							<tr>
								<td align="right">
								<input id="max" type="hidden" value="<s:property value="totalPage"/>" />
                                <input id="cur" type="hidden" value="<s:property value="pageNum"/>" />
										<span> 共<s:property value="totalPage"/>页 页次:<s:property value="pageNum"/>/<s:property value="totalPage"/> 页</span>
      <a class="lj" onclick="firstPage();">首页</a>
      <a class="lj" onclick="previous(<s:property value="pageNum"/>);">上一页  &nbsp;</a><span><font color=red><s:property value="pageNum"/></font></span>&nbsp;&nbsp;<a class="lj" onclick="next(<s:property value="pageNum"/>,<s:property value="totalPage"/>);">下一页</a>
      <a class="lj" onclick="endPage(<s:property value="totalPage"/>);">尾页</a> 
                   转到 <SELECT id="selection" style="width: 50px;" NAME="select" onchange="changeValue('<s:property value="messageType"/>');"><option selected=selected>1</option></SELECT>
								</td>
							</tr>
						</table>	
	</div>															
	<script>
	var serverUrl="http://59.173.13.218:3001/";
//删除房间
function deleteRoomByID(room_id) {
  var deleteRoom = function(room_id, callback) {

    var req = new XMLHttpRequest();
    var url = serverUrl + 'deleteRoom/';
    var body = {roomid: room_id};

    req.onreadystatechange = function () {
      if (req.readyState === 4) {
        callback(req.responseText);
      }
    };

    req.open('POST', url, true);
    req.setRequestHeader('Content-Type', 'application/json');
    req.send(JSON.stringify(body));

  };

  deleteRoom(room_id, function (response) {

     var result = room_id;
     window.location.href="<%=basePath%>roomManager/roomManager_deleteRoom.action?room_id="+result+"";
 
  });
}

function deleteRoom(roomId)
{
     
     deleteRoomByID(roomId);
}

function updateRoom(roomId)
{
    window.location.href="<%=basePath%>roomManager/roomManager_updateRoom.action?room_id="+roomId+"";
}
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
         //window.location.href="<%=basePath%>roomManager/roomManager_getRoomList.action?pageNum="+page;
         document.getElementById("yema").value=page;
         document.getElementById("form").action="<%=basePath%>roomManager/roomManager_getRoomList.action";
         document.getElementById("form").submit();	
         
     }
     var obj=document.getElementById("title").value;
     var rtp=document.getElementById("rtp").value;
     var title=encodeURI(encodeURI(obj));
     
     //首页
     function firstPage()
     {
         document.getElementById("yema").value=1;
         document.getElementById("form").action="<%=basePath%>roomManager/roomManager_getRoomList.action";
         document.getElementById("form").submit();	
     }
     
     //尾页
     function endPage(pageNum)
     {
         document.getElementById("yema").value=pageNum;
         document.getElementById("form").action="<%=basePath%>roomManager/roomManager_getRoomList.action";
         document.getElementById("form").submit();	
     }
     //上一页
     function previous(currentPage)
     {  
         if(currentPage==1)
         {
             document.getElementById("yema").value=currentPage;
             document.getElementById("form").action="<%=basePath%>roomManager/roomManager_getRoomList.action";
             document.getElementById("form").submit();	           
         }
         if(currentPage>1)
         {
             currentPage=currentPage-1;
             document.getElementById("yema").value=currentPage;
             document.getElementById("form").action="<%=basePath%>roomManager/roomManager_getRoomList.action";
             document.getElementById("form").submit();	        
         }
     }
     //下一页
     function next(currentPage,totalPage)
     {
         if(currentPage<totalPage)
         {
             currentPage=currentPage+1;
             document.getElementById("yema").value=currentPage;
             document.getElementById("form").action="<%=basePath%>roomManager/roomManager_getRoomList.action";
             document.getElementById("form").submit();	
         }
         if(currentPage>=totalPage)
         {          
             document.getElementById("yema").value=currentPage;
             document.getElementById("form").action="<%=basePath%>roomManager/roomManager_getRoomList.action";
             document.getElementById("form").submit();	
         }
     }
    
</script>
</body>
</html>