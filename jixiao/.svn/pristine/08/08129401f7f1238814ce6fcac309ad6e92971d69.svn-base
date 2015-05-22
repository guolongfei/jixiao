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
<title>选择成员</title>
<meta http-equiv="Access-Control-Allow-Origin" content="*">
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
function checkAll()
{
     var allcheck=document.getElementById("check_all");
     var as=document.getElementsByName('check');
     if(allcheck.checked==true)
     {
         for(var i=0;i<as.length;i++)
         {
            as[i].checked=true;
         }
                 
     }
     else
     {
        for(var i=0;i<as.length;i++)
         {
            as[i].checked=false;
         }
     }
}

function addMember()
{
    var as=document.getElementsByName('check');
    var flag=0;
    var id="";
    for(var i=0;i<as.length;i++)
    {
         if(as[i].checked==true)
         {
              flag++;
              if(flag==1)
              {
                  id=id+as[i].value;
              }
              else
              {
                  id=id+","+as[i].value;
              }
         }
    }
    
    if(flag==0)
    {
        alert("请选择要添加的成员");
        return;
    }
    else
    {
        window.location.href="<%=basePath%>roomManager/roomManager_addMember1.action?ids="+id+"";
    }
}
</script>
</head>
<body style="background: #F8F8F8;">
<div style="height: 600px;">
    <form id="form"  method="post">
	<table cellpadding="" cellspacing="" width="95%" align="center" height="30" style="margin-top: 35px;">
		<tr height="30">
		</tr>
			<tr ><td>成员名：			         
			         <input id="rm" type="text" name="roomName" style="width:120px;"/>
			                            部门：<SELECT id="season" name="spec.score_season" style="height:24px;width:100px;border:1px solid #adadad;" class="select" >
			                 <option value="0">--请选择--</option>           
                             <option value="1">一季度</option>
                             <option value="2">二季度</option>
                             <option value="3">三季度</option>
                             <option value="4">四季度</option>
                             </SELECT>
                    <input id="rm" type="button" name="chaxun"  value="查询"/>
                        </td></tr>		
	</table>
	</form>	
	<table cellpadding="0"  cellspacing="0" width="95%" align="center" border="1" bordercolor="#E4C08F"  style="text-align: center;border-collapse:collapse;margin-top: 30px;overflow:scroll;">	
    <tr height=40px><TD  colspan="3" style="font-size:16px;font-weight:bolder;">成员列表</TD></tr>
									<tr height="30">
										<th><input id="check_all" type="checkbox" name="all" onclick="checkAll();"/>全选</th>
										<th>成员名</th>
										<th>所在部门</th>																			
									</tr>
									<!-- 列表数据在这循环输出 -->								
									<s:iterator value="memlist" status="st" var="li">							
										<tr height="30">
										    <td><input id="check_all<s:property value="#st.index+1" />" type="checkbox" name="check"  value="<s:property value="#li[0]" />"/></td>
											<td><s:property value="#li[1]" /></td>
											<td><s:property value="#li[2]" /></td>																					
										</tr>
										</s:iterator>								
							</table>
							<div class="form-actions">
                                            <button class="form_save_btn" onclick="addMember();"></button>
                                             </div>
					
	</div>															
</body>
</html>