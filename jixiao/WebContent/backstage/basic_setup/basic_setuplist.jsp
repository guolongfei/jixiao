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
<script src="<%=basePath%>inc/js/lib/jquery.min.js"></script>
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
<SCRIPT type="text/javascript">
  $(function(){
     if('${errorMsg}'=="success"){
        alert("信息保存成功!!");
      }
  });
</SCRIPT>
</head>
<body>
<div style="height: 600px;">
	<table cellpadding="" cellspacing="" width="95%" align="center" height="30" style="margin-top: 35px;">
		<tr>
			<td width="93%" style="color: #c22626;font-weight: bold;">信息发布列表</td>
			<td align="center"><a class="btn btn-primary" href="<%=basePath%>messageManage/message_toBasicSetup.action">添加</a></td>
		</tr>
	</table>	
	<table cellpadding="0" cellspacing="0" width="95%" align="center" border="1" bordercolor="#E4C08F"  style="text-align: center;border-collapse:collapse;margin-top: 30px;">			
									<tr height="30">
										<th>序号</th>
										<th>标题</th>
										<th>类型</th>
										<th>添加时间</th>										
										<th>操作</th>
									</tr>
								
								<tbody>
									<!-- 列表数据在这循环输出 -->								
									<s:iterator value="basicList" status="st" var="item">									
										<tr>
											<td><s:property value="#st.index+1" /></td>
											<td><s:property value="#item.setup_title" /></td>											
											<td>
											   <s:if test="#item.setup_type==1">
											           基础设置
											   </s:if>
											<td><s:date name="#item.addtime" format="yyyy-MM-dd" /></td>											
											<td><a class="btn btn-primary" href="<%=basePath%>messageManage/message_deleteBS.action?bsId=<s:property value="#item.id" />">删除</a></td>
										</tr>
									</s:iterator>
								</tbody>
							</table>
	</div>															
</body>
</html>