<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>政策详情</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<style>
a{
text-decoration: none;
color:black;
}
a:hover {color:#ba2636;text-decoration:none;}
.la04 {
	font-family: "宋体";
	font-size: 14px;
	color: #000000;
}
.la03 {
	font-family: "宋体";
	font-size: 18px;
	color: #000000;
	font-weight: bold;
}
</style>
  </head>
  
  <body>
    <table cellpadding="0" cellspacing="0"  border="0" width="100%">
         
            <tr>
               
                <td width="85%" valign="top">
                 <table width="100%" border="0" align="center" cellpadding="0"  cellspacing="0">
			<tr>
				<td height="8" bgcolor="#FFFFFF">
					<table width="100%" border="0" align="center" cellpadding="0"
						cellspacing="0" class="xl_kuan">
						<tr>
							<td height="20"></td>
						</tr>
						<tr>
							<td>
								<table width="900" border="0" align="center" cellpadding="0"
									cellspacing="0">
									<tr>
										<td height="30" align="center" class="la03">
                                      <s:property value="messageRelease.title" />
										</td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td height="20"></td>
						</tr>
						<tr>
							<td valign="top">
								<table width="900" border="0" align="center" cellpadding="0"
									cellspacing="0">
									<tr>
										<td height="1" bgcolor="#E4C08F" colspan="3"></td>
									</tr>
									<tr>
										<td height="24" width="300" align="center" bgcolor="#f7f7f7" >
											编稿时间：<s:date name="messageRelease.add_time"  format="yyyy-MM-dd HH:mm:ss"/>
										</td>
										<td height="24" width="300" align="center" bgcolor="#f7f7f7" > 
										来源：<s:property value="messageRelease.messageFrom" />
											</td>
											<td height="24" width="300" align="center" bgcolor="#f7f7f7" >
											作者：<s:property value="messageRelease.author" />
										</td>
									</tr>
									<tr>
										<td>
											&nbsp;
										</td>
									</tr>
									<tr>
										<td height="30" colspan="3">
											<div class=TRS_Editor>
												<s:property value="messageRelease.content" escape="false" />
											</div>
										</td>
									</tr>
									<tr>
										<td height="20"></td>
									</tr>
									<tr>
										<td height="20" align="left" valign="top" colspan="3">
											<table width="100%" border="0" cellpadding="0"
												cellspacing="0">
												<s:iterator value="listaf" var="li">
												<tr>
													<td width="20px;">
														
														<img src="<%=basePath%>images/xl_ioc_2.jpg" height="15px"></img>
													</td>
													<td align="left">
													<div class="la04">
														&nbsp;附件：
														  <a href="/jixiao/upload/<s:property value="#li.file_name"/>"
															target="_blank"><s:property value="#li.file_name" /></a>
															</div>
													</td>
												</tr>
												</s:iterator>
											</table>
										</td>
									</tr>
									<tr>
										<td height="20"></td>
									</tr>
									<tr>
										<td align="right" colspan="3">
											<table width="21%" border="0" align="right" cellpadding="0"
												cellspacing="0">
												<tr>
													<td align="left">
														<img src="<%=basePath%>images/sgp_xl02.jpg" width="20" height="19" />
													</td>
													<td align="left">
														<a style="cursor: pointer;" onClick=window.print();>打印本页</a>
													</td>
													<td align="left">
														<img src="<%=basePath%>images/sgp_xl03.jpg" width="15" height="12" />
													</td>
													<td align="left">
														<a style="cursor: pointer;" onClick="backTo();";>返回</a>
													</td>
												</tr>
											</table>
										</td>
									</tr>
									<tr>
										<td align="right" height="30"></td>
									</tr>
									<tr>
										<td height="1" bgcolor="#E4C08F" colspan="3"></td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
           
         </td>
      </tr>
    </table>
  </body>
  <script>
  function backTo()
  {
      history.go(-1);
  }
  </script>
</html>
