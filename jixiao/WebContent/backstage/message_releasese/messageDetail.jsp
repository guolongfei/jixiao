<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>  
<%
	String power=(String)session.getAttribute("key");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>湖北公安监管信息综合应用平台</title>
<jsp:include page="../jscss.jsp"></jsp:include>
</head>
<body>
<%-- 	<jsp:include page="../header.jsp"></jsp:include>
 --%>	<div id="content">
		<div id="content-header">
			<h1>监所区域管理</h1>
			<div class="btn-group" style="width: auto;">
				<%
				if(power.indexOf("G02") !=-1){
				%>
				<a id="delbtn" title="" class="btn btn-danger">删除</a>
				<%
				}
				if(power.indexOf("G03") !=-1){
				%>
				<a title="" href="detentionArea_editUI.action?id=<s:property value="detentionArea.id"/>" class="btn btn-primary">修改</a>
				<%} %>
			</div>
		</div>
		<div id="breadcrumb">
			<a class="tip-bottom" href="detentionArea_list.action" title="" data-original-title="回到主页"><i class="icon-home"></i> 主页</a>
			<a class="current" href="#">监所区域信息</a>
		</div>
		<div class="container-fluid">
			<div class="row-fluid">
				<div class="span12">
					<div class="widget-box">
                         <div class="widget-title">
                             <span class="icon"><i class="icon-align-justify"></i></span>
                             <h5>监所区域信息表</h5>
                         </div>
                         <div class="widget-content  nopadding">
                         <div  class="detail_row">
							<div class="detail_item">
								<label>监所:</label>
								<div>
									<s:property value="detentionArea.prisonInfo.prisonName" />
								</div>
							</div>
							</div>
							<div  class="detail_row">
							<div class="detail_item">
								<label>区域编码	:</label>
								<div>
									<s:property value="detentionArea.areaCode" />
								</div>
							</div>
							</div>
							<div  class="detail_row">
							<div class="detail_item">
								<label>区域名称:</label>
								<div>
									<s:property value="detentionArea.detentionArea" />
								</div>
							</div>
							</div>
							<div  class="detail_row">
							<div class="detail_item">
								<label>描述:</label>
								<div>
									<s:property value="detentionArea.detentionDesc" />
								</div>
							</div>
							</div>
							<div class="form-actions nomargin">
								<a class="btn btn-primary" href="detentionArea_list.action">返回</a>
							</div>
						</div>
					</div>						
				</div>
			</div>
		</div>
	</div>
<script>
$(function(){
	$("#delbtn").click(function(){
		if(confirm("你确定要删除该信息吗")){
			window.top.location="detentionArea_delete.action?id=<s:property value="detentionArea.id"/>";
		}
	});
	
});
</script>
</body>
</html>