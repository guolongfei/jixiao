<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<title>鄂州实绩考核网- Powered by Trilink</title>
		<meta name="Keywords" content="鄂州市实绩考核网">
		<meta name="Description" content="鄂州实绩效考核网">
		<meta name="generator" content="Trilink" />
		<meta name="author" content="Trilink Team lead by Raincl" />
		<meta http-equiv="X-UA-Compatible" content="IE=7" />
		<link type="text/css" href="/Templates/tz/css/dean.css"
			rel="stylesheet" />
		<link type="text/css" href="/Templates/tz/css/whole.css"
			rel="stylesheet" />
		<link type="text/css" href="/Templates/tz/css/public.css"
			rel="stylesheet" />
		<link type="text/css" href="/Templates/tz/css/front.css"
			rel="stylesheet" />
		<script type="text/javascript" src="/Templates/tz/js/changdiv.js"></script>
		<script type="text/javascript" src="/jixiao/js/jQuery.js"></script>
		<style>
.la02 {
	font-size: 12px;
	color: #e00606;
}

.xl_kuan {
	border: 1px solid #999999;
}

.la03 {
	font-family: "宋体";
	font-size: 20px;
	color: #000000;
}

.la04 {
	font-family: "宋体";
	font-size: 12px;
	color: #000000;
}

.STYLE1 {
	color: #CC0000;
	font-weight: bold;
	font-size: 13px;
}
</style>


	</head>
	<body>
		<jsp:include page="header.jsp" />
		<table width="1003" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td height="8" bgcolor="#FFFFFF">
					<table width="100%" border="0" align="center" cellpadding="0"
						cellspacing="0" background="../images/ldxx_04.gif">
						<tr>
							<td width="4%">
								<img src="../images/ldxx_03.gif" width="41" height="34" />
							</td>
							<td>
								<span class="la02">当前位置：<a href="/jixiao/messageManage/homePage_getList.action"
									target="_blank" class="CurrChnlCls">首页</a>&nbsp;>&nbsp;<a
									href="/jixiao/messageManage/message_getMessageList.action?messageType=<s:property value='messageRelease.messageType.type_id'/>"
									
									target="_blank" class="CurrChnlCls"><s:property
											value="messageRelease.messageType.type_name" />
								</a>&nbsp;>&nbsp;<a href="#" onClick=
	window.location.reload();
class="CurrChnlCls">详情</a> </span>
							</td>
						</tr>

					</table>
				</td>
			</tr>
		</table>
		<table width="1003" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td height="5" bgcolor="#FFFFFF"></td>
			</tr>
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
										<td height="1" bgcolor="#d1d0d0"></td>
									</tr>
									<tr>
										<td height="24" align="center" bgcolor="#f7f7f7" class="la04">
											<table cellpadding="0" cellspacing="0" border="0" width="100%">
												<tr>
													<td width="300">编稿时间：<s:date name="messageRelease.add_time" format="yyyy-MM-dd HH:mm:ss"/></td>
													<td width="300" align="center">来源：<s:property value="messageRelease.messageFrom" /></td>
													<td align="center">作者：<s:property value="messageRelease.author" /></td>
												</tr>	
											</table>											
										</td>
									</tr>
									<tr>
										<td>
											&nbsp;
										</td>
									</tr>
									<tr>
										<td height="30">
											<div class=TRS_Editor>
												<s:property value="messageRelease.content" escape="false" />
											</div>
										</td>
									</tr>
									<tr>
										<td height="20"></td>
									</tr>
									<tr>
										<td height="20" align="left">
											<table width="100%" border="0" cellpadding="0"
												cellspacing="0">
												<s:iterator value="listaf" var="li">
												<tr>
												<td width="20px;">
														
														<img src="../images/xl_ioc_2.jpg" height="15px"></img>
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
										<td align="right">
											<table width="21%" border="0" align="right" cellpadding="0"
												cellspacing="0">
												<tr>
													<td align="left">
														<img src="../images/sgp_xl02.jpg" width="20" height="19" />
													</td>
													<td align="left">
														<a href="#" onClick=
	window.print();;
>打印本页</a>
													</td>
													<td align="left">
														<img src="../images/sgp_xl03.jpg" width="15" height="12" />
													</td>
													<td align="left">
														<a href="#" onClick=
	window.close();;
>关闭窗口</a>
													</td>
												</tr>
											</table>
										</td>
									</tr>
									<tr>
										<td align="right" height="30"></td>
									</tr>
									<s:if test="messageType==4">
									<s:form id="f" method="post">
									<tr>
										<td>
										<table width="900" border="0" align="center" cellpadding="0" cellspacing="0" style="border: 1px solid #cccccc;">
			<tr height="40" style="background: url('../images/jk_r1_c21_4 .jpg') repeat-x;">
				<td align="center" colspan="2">
					<span style="font-size:16px;color:#fff;font-weight: bold;">我要评价</span>	
				</td>
			</tr>
			<tr>
				<td height="10"></td>
			</tr>
			<tr>
				<td align="center">
					名字：<input type="text" name="name"/>
				</td>
				<td align="center">
					电话：<input type="text" name="phoneNumber"/>
				</td>
			</tr>
			<tr>
				<td height="6"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<textarea id="content" rows="" cols="" style="width:700px;height: 150px;resize:none;font-size: 14px;" name="content"></textarea>
				</td>
			</tr>
			<tr>
				<td height="6"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<img alt="" src="/jixiao/images/tijiao.jpg" onclick="addAppraise('<s:property value="id"/>')">	
				</td>
			</tr>
			<tr>
				<td height="20"></td>
			</tr>
		</table>
										</td>
									</tr>
									</s:form>
									</s:if>
									<s:elseif test="messageType==0">
										<tr>
											<td>
												<div style="width: 950px;margin: 0 auto;border: 1px solid #cccccc;text-align: center;height: 400px;overflow-y:auto;overflow-x:hidden;">
													<p style="width: 950px;height: 40px;line-height: 40px;background-color: #84c1ff;font-size: 18px;color: white;font-weight: bold;">评价专区</p>
												<table width="900" cellpadding="0" cellspacing="0" align="center" style="margin-top: 5px;">
													<s:iterator value="appraiseList">
													<tr>
														<td>
															<div style="color: #900;"><s:if test="name!=null"><s:property value="name"/></s:if><s:else>匿名</s:else>　<s:date name="appraise_time" format="yyyy/MM/dd"/>　评论：</div>
															<div style="width:700px;height: 40px;border:1px solid #cccccc;font-size: 14px;line-height: 40px;">
																&nbsp;&nbsp;<s:property value="content"/>
															</div>
														</td>
													</tr>
													</s:iterator>																	
													<tr>
														<td height="20"></td>
													</tr>
												</table>
												</div>
											</td>
										</tr>
									</s:elseif>
									<tr>
										<td height="20"></td>
									</tr>						
								</table>
							</td>
						</tr>						
					</table>
				</td>
			</tr>			
		</table>
		<SCRIPT type="text/javascript">
			function addAppraise(id){
				var content = $("#content").val();		
				if(content==""){
					alert("评价不能为空！");
					return;						
				}
				else if(content.length<15){
						alert("评价不能少于15个字！");
						return;	
					}
				else{
					document.getElementById("f").action = "/jixiao/messageManage/message_AddAppraise.action?id="+id+"&messageType=4";
					document.getElementById("f").submit();
					alert("提交评价成功！");
				}
			}
		</SCRIPT>
		<table width="1003" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td height="5" bgcolor="#FFFFFF"></td>
			</tr>
		</table>
		<jsp:include page="footer.jsp" />
	</body>
</html>