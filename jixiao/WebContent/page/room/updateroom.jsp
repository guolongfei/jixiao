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
<title>创建工作组</title>
<meta http-equiv="Access-Control-Allow-Origin" content="*">
<link href="<%=basePath%>inc/css/lib/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="<%=basePath%>js/jQuery.js"></script>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/icon.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/demo.css">
<script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery.easyui.min.js"></script>
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
	.form-actions {
	background: #F8F8F8;
	text-align: center
}
.form_save_btn {
	background: url("<%=basePath%>inc/css/img/form_save_btn1.png") no-repeat;
	width: 129px;
	height: 35px;
	border: none
}

.form_save_btn:hover {
	background: url("<%=basePath%>inc/css/img/form_save_btn2.png") no-repeat
}
</STYLE>
<script>
function addRoom()
{
    var roomid=$("#rm1").val(); 
    var id="";
    var as=document.getElementsByName('check');
    for(var i=0;i<as.length;i++)
    {            
         if(i==0)
         {
              id=id+as[i].value;
         }
         else
         {
              id=id+","+as[i].value;
         }
         
     }
    window.location.href="<%=basePath%>roomManager/roomManager_updateRoom1.action?room_id="+roomid+"&ids="+id+"";
}


function deleteMem(mem_id)
{
    $("#"+mem_id+"").remove();
}

function getChecked(){
			var nodes = $('#tt').tree('getChecked');
			var s = '';			
			var as=document.getElementsByName('check');
			var flag=as.length+1;
			var index=false;
			if(as.length<1)
			{
			     for(var j=0;j<nodes.length;j++)
			        {		
			                if(nodes[j].id.indexOf("second")<0&&nodes[j].id.indexOf("third")<0)
			                {	   
			                   s+="<tr id='"+nodes[j].id+"' height='30px;'><td><input type='hidden' name='check' value='"+nodes[j].id+"' />"+nodes[j].text+"</td><td>"+nodes[j].name+"</td><td><a class='btn btn-primary' onclick=\"deleteMem('"+nodes[j].id+"');\">删除</a></td></tr>";
				               flag++;
				            }
			        }  
			}
			else
			{
			    for(var j=0;j<nodes.length;j++)
			    {
			         for(var i=0;i<as.length;i++)
			         {
			             if(nodes[j].id==as[i].value)
			             {
			                 index=true;
			             }
			         }
			        if(index==false)
			        {
			           if(nodes[j].id.indexOf("second")<0&&nodes[j].id.indexOf("third")<0)
			           {	 
			              s+="<tr id='"+nodes[j].id+"' height='30px;'><td><input type='hidden' name='check' value='"+nodes[j].id+"' />"+nodes[j].text+"</td><td>"+nodes[j].name+"</td><td><a class='btn btn-primary' onclick=\"deleteMem('"+nodes[j].id+"');\">删除</a></td></tr>";
				          flag++;
				       } 
			        }
			    }
			}
			$('#table').append(s);
		}
</script>
</head>
<body style="background: #F8F8F8;">
<div style="height: 600px;">
    <form id="form"  method="post">
	<table cellpadding="" cellspacing="" width="95%" align="center" height="30" style="margin-top: 35px;">
		<tr height="30">
		</tr>
			<tr ><td>工作组名：			         
			         <input id="rm" type="text" name="roomName" disabled="disabled" style="width:120px;" value="<s:property value="roomName" />">
			         <input id="rm1" type="hidden" name="room_id" value="<s:property value="room_id" />">
                        </td></tr>	
            <tr ><td>选择成员：			         
			         <input type="button" value="点击添加" onclick="getChecked();">
               
                        </td></tr>	
            <tr height="5px"></tr>           
                        <tr><td width="600px;" valign="top">
	<div class="easyui-panel" style="padding:5px;width:95%;">
		<ul id="tt" class="easyui-tree" data-options="url:'<%=basePath%>roomManager/roomManager_getAll.action',method:'get',animate:true,checkbox:true"></ul>
	</div>
                        </td>
                        <td valign="top">
                            <table id="table" cellpadding="0" cellspacing="0" width="100%" align="center" border="1" bordercolor="#E4C08F"  style="text-align: center;border-collapse:collapse;">	
                                <tr height=40px><TD  colspan="3" style="font-size:16px;font-weight:bolder;">成员列表</TD></tr>
									<tr height="30">
										<th>成员名</th>
										<th>部门</th>
										<th>操作</th>																
									</tr>
									<!-- 列表数据在这循环输出 -->								
									<s:iterator value="list1" status="st" var="li">						
										<tr id="<s:property value="#li.member_id" />" height="30">
										<td><input type="hidden" name="check" value="<s:property value="#li.member_id" />" /><s:property value="#li.member_name" /></td>
											<td><s:property value="#li.member_department" /></td>
											<td><a class='btn btn-primary' onclick="deleteMem('<s:property value="#li.member_id" />');">删除</a></td>										
										</tr>
										</s:iterator>								
							</table>                       
                          
                        </td>
                        </tr>	
	</table>
	
	</form>	

							<div class="form-actions">
                                            <button class="form_save_btn" onclick="addRoom();"></button>
                                             </div>
					
	</div>															
</body>
</html>