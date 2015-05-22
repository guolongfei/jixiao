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
var serverUrl="http://59.173.13.218:3001/";
//创建房间
function creatRoomByName(roomname) {
  var creatRoom = function(roomname, callback) {

    var req = new XMLHttpRequest();
    var url = serverUrl + 'createRoom/';
    var body = {roomname: roomname};

    req.onreadystatechange = function () {
      if (req.readyState === 4) {
        callback(req.responseText);
      }
    };

    req.open('POST', url, true);
    req.setRequestHeader('Content-Type', 'application/json');
    req.send(JSON.stringify(body));

  };

  creatRoom(roomname, function(response) {
     var roomid = eval("("+response+")");
     var rmName = ncodeURIComponent(encodeURIComponent(roomid.name));	
     if(roomid=="")
     { 
         alert("服务器连接失败");
         return;
     }
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
          window.location.href="<%=basePath%>roomManager/roomManager_saveRoom.action?jsonString="+response+"&ids="+id+"&rmName="+rmName;
     
  });
}

function addRoom()
{
      
     var roomName=$("#rm").val();
     var x=document.getElementById("error").style.display;
     if(x=="inline")
     {
         alert("小组名已经存在");
         return;
     }
     if(roomName==""||roomName==null)
     {
         alert("请填写工作组名称");
         return;
     }
    
     creatRoomByName(roomName);
}



function checkName()
{
     var roomName=$("#rm").val();
      $.ajax({
              type:"post",
              url:"<%=basePath%>roomManager/roomManager_checkName.action",
              data:"roomName="+roomName+"",
              dataType:"json",
              success: function(data){      
                     if(data.flag!=0)
                     {
                        $("#error").css("display","inline");
                     }
                      }
         });
}

function hideErr()
{
    $("#error").css("display","none");
}

function addMembers()
{
     window.location.href="<%=basePath%>roomManager/roomManager_addMember.action";
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
			                if(nodes[j].name!=null)
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
			           if(nodes[j].name!=null)
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
			         <input id="rm" type="text" name="roomName" style="width:120px;" onblur="checkName();" onfocus="hideErr();">
                     <label id="error" style="color:red;display:none;">*小组名已存在</label>
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
									<s:iterator value="memlist1" status="st" var="li">						
										<tr height="30">
										<td><input type="hidden" name="check" value="<s:property value="#li[0]" />" /><s:property value="#st.index+1" /></td>
											<td><s:property value="#li[1]" /></td>										
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