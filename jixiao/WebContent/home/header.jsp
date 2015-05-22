<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
 	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>鄂州实绩考核网</title>
    <script type="text/javascript" src="../js/jQuery.js"></script>
     <link href="../css/style.css" rel="stylesheet" type="text/css"/>
    <style type="text/css">
    	body{
    		margin: 0px;
    		padding: 0px;
    	}
   		.navigation{
   			width: 1003px;
   			height: 38px;
   			line-height: 38px;
   			text-align: center;
   		}
   		.navigation ul{
   			width:1003px;
   			float: left;
   			display:inline;
   			margin:0px;
   			padding:0px;
   		}
    	.navigation ul li{
    		width:110.3px;
    	 	list-style:none;
    	 	float: left;
    	 	font-size:16px;
    	 	border-spacing: 2px;
    	 	color:white;
    	 	font-weight: bold;
    	 }
    	.navigation ul li:HOVER{
    		cursor:pointer;
    		text-decoration: underline;
    		background: url("../images/daohang1.gif");
    		color: #fff4c1;	
    	}
    	.choose{
    		cursor:pointer;
    		text-decoration: underline;
    		color: #fff4c1;
    		background: url("../images/daohang1.gif");
    	}
    </style>
    <SCRIPT type="text/javascript">
    
    	$(function(){
    	/*
    		$.ajax({
    			type:"post",
          		url:"/jixiao/messageManage/homePage_navTopList.action",
          		dataType:"json",
          		success:function(msg){
          			 if(msg.errorMsg=="success"){
          			 	var list = msg.array;
          			 	var nav = "";
          			 	for(var i=0;i<list.length;i++){
          			 		if(list[i].id!=1&&list[i].id!=2&&list[i].id!=11&&list[i].id!=12&&list[i].id!=3)
          			 		{         			 		
          			 			nav = "<li onclick='linkhref("+list[i].id+")'>"+list[i].type_name+"</li>";         			 			
          			 			$(nav).appendTo($("#NavFrist"));
          			 		}      			 		
          			 	}         		 	
          			 }
          		}
    		}); 
    	*/	
    		$.ajax({
    			type:"post",
          		url:"/jixiao/messageManage/homePage_maquee.action",
          		dataType:"json",
          		success:function(msg){
          			 if(msg.errorMsg=="success"){
          			 	var list = msg.array;
          			 	var nav = "";
          			 	for(var i=0;i<list.length;i++){
          			 		if(list[i].Ischain==1){
          			 			nav="<a style='font-size:13px;' href='"+list[i].chain_adress+"'>"+list[i].title+"</a>"+"　　";
          			 		}
          			 		else{
          			 			nav = "<a style='font-size:13px;' href='#'>"+list[i].title+"</a>"+"　　";
          			 		}
          			 	$("#moveleft").append(nav);      			 		
          			 	}         		 	
          			 }
          		}
    		
    		});	
    				  	
    	});
    	
    		function linkhref(type){
    			if(type==12){
    				window.location.href = "<%=basePath%>messageManage/message_getMessageList.action?MessageType=12";
    			}
    			else{
    				window.location.href = "<%=basePath%>messageManage/message_getMessageList.action?MessageType="+type;
    			}
    		} 
    </SCRIPT>
  </head>
  
  <body>
		<table width="1003" height="170" border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
				<td>
					<embed height="169" type="application/x-shockwave-flash" pluginspage="http://www.macromedia.com/go/getflashplayer" width="1003" src="../images/topflash.swf" quality="high" wmode="transparent">
				</td>
			</tr>		
		</table>
		<table width="1003" height="38" cellpadding="0" cellspacing="0" align="center" border="0" style="background: url('../images/daohang.gif');">
			<tr>
				<td>
				<div class="navigation">
					<ul id="NavFrist">				
						<li onclick="window.open('<%=basePath%>messageManage/homePage_getList.action','_self')">首　页</li>
						<li onclick="linkhref(12)">工作动态</li>	
						<li onclick="linkhref(4)">实绩展示</li>	
						<li onclick="linkhref(13)">实绩通报</li>	
						<li onclick="linkhref(5)">政策法规</li>	
						<li onclick="linkhref(8)">领导言论</li>	
						<li onclick="linkhref(10)">理论探索</li>	
						<li onclick="linkhref(9)">经验交流</li>	
						<li onclick="linkhref(6)">表格下载</li>			
					</ul>
				</div>
				<script type="text/javascript">
					$(document).ready(function(){
						$(".navigation ul li").hover(function(){
							$(this).addClass("choose");													
						}
						,function(){
							$(this).removeClass("choose");						
						});							
					});
				</script>			
				</td>
			</tr>		
		</table>
			<table align="center" width="1003" height="35" cellpadding="0" cellspacing="0" style="line-height: 35px;font-size: 13px;" background="../images/index_06.jpg">
				<tr>
					<td width="20%" style="padding-left: 20px;">欢迎光临鄂州实绩考核网</td>
					<td width="58%">
						<marquee id="moveleft">
							
						</marquee>
					</td>	
					<td width="22%" align="center">
						<script language=JavaScript>
						var d, s = "";
						var x = new Array("星期日", "星期一", "星期二","星期三","星期四", "星期五","星期六");
						d = new Date();
						s+=d.getFullYear()+"年"+(d.getMonth() + 1)+"月"+d.getDate()+"日　";
						s+=x[d.getDay()];
						document.writeln(s);
						</script>
					</td>
				</tr>
			</table>
						
  </body>
</html>
