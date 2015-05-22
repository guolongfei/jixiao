<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>鄂州实绩考核系统</title>
<link rel="shortcut icon" href="/jixiao/inc/css/img/icon/fav.ico" />
<link href="/jixiao/inc/css/lib/bootstrap.min.css" rel="stylesheet">
<link href="/jixiao/inc/css/lib/bootstrap-responsive.min.css" rel="stylesheet">
<link href="/jixiao/inc/css/lib/hoyo.main.css" rel="stylesheet">
<link href="/jixiao/inc/css/lib/hoyo.blue.css" rel="stylesheet">
<link href="/jixiao/inc/css/header.css" rel="stylesheet">
<link href="/jixiao/inc/css/form.css" rel="stylesheet">
<link href="/jixiao/inc/js/lib/select/select2.css" rel="stylesheet">
<link href="/jixiao/inc/css/role.css" rel="stylesheet">
<script src="/jixiao/inc/js/lib/jquery.min.js"></script>
<script src="/jixiao/inc/js/lib/jquery-ui.min.js"></script>
<script src="/jixiao/inc/js/lib/bootstrap.min.js"></script>
<script src="/jixiao/inc/js/lib/hoyo.js"></script>
<script src="/jixiao/inc/js/lib/sshlma.js"></script>
<script src="/jixiao/inc/js/lib/datepicker/WdatePicker.js"></script>
<script src="/jixiao/inc/js/lib/validator.js"></script>
<script src="/jixiao/inc/js/lib/sha1.js"></script>
<script src="/jixiao/inc/js/lib/select/select2.js"></script>
<script src="/jixiao/inc/js/lib/select/select2_locale_zh-CN.js"></script>
<style type="text/css">
	.checkboxLabel{
		display:inline;
	}
	.title{
		clear: left;
		overflow: hidden;
	}
	.title-name{
		margin-right: 40px;
		float: left;
	}
	.select-title{
		float: left;
	}
	.select-title .checkbox{
		margin-top: 5px;
	}
	.checkbox input{
		margin-top: 5px;
	}
</style>
</head>
<body>
	<div id="content">
		
		<div id="breadcrumb">
			<div id="content-header">			
				<div class="btn-group" style="width: auto;">				
					<a id="delbtn" title="" href="#" class="btn btn-danger">删除</a>							
				</div>
			</div>
		</div>
		<div class="container-fluid">
			<div class="row-fluid">
				<div class="span12">
					<div class="widget-box">
						<div class="widget-title">
							<span class="icon">
								<i class="icon-align-justify"></i>									
							</span>
							<h5>角色信息</h5>							
						</div>
						<div class="widget-content nopadding">
						<s:form action="jx_role_updatePer.action" method="post">
						<input type="hidden" value="<s:property value="jx_Role.id"/>" name="jx_Role.id"/>
								<div class="form-row">
									<div class="detail control-group">
										<span><label class="label">角色名:</label></span>
										<s:property value="jx_Role.name"></s:property>
									</div>
								</div>
								
								<div class="form-row">
									<div class="detail control-group">
										<span class="select-title"><label class="label">权限:</label></span>
										<div class="select-title">
											<label class="checkbox"><input class="select-all" type="checkbox" />全选</label>
										</div>
		
										<s:iterator value="map" status="st">
											<div class="role-box">
												<div class="title">
													<div class="title-name">
														<s:if test="#st.index==0">
															<s:property value="key"/>
														</s:if>
														<s:else>
															<s:property value="key"/>
														</s:else>
													</div>
													<label class="checkbox"><input class="select-all-item" type="checkbox" />全选</label>
												</div>
												<div class="role">
													<s:iterator value="value" status="st">
														<label class="checkbox"><input type="checkbox" name="perId" value="<s:property value="id"/>"/><s:property value="permission"/></label>
													</s:iterator>
												</div>
											</div>
										</s:iterator>
									</div>
								</div>
							</s:form>
							<div class="form-actions">
								<button class="btn btn-primary">保存</button>
								<a class="btn btn-primary" href="jx_role_bs_getRoleList.action">返回</a>
							</div>
						</div>
					</div>						
				</div>
			</div>
			

			<div class="row-fluid">
				<div class="span12" id="footer">
					 
				</div>
			</div>
		</div>
	</div>
	<script>
		$(function(){
			$("#delbtn").click(function(){
				if(confirm("你确定要删除该信息吗？")){
					window.location="jx_user_bs_detele.action?userId=<s:property value="jx_User.id"/>&peopleId=<s:property value="jx_User.jx_people.id"/>";
				}
			});
			
		});
	</script>
	
	<script>
		$(function(){
			var preJson = '${checkstring}';
			var array = preJson.split(',');
			for(var i in array){
				if(array[i] != ''){
					$('input[name="perId"][value="'+array[i]+'"]').attr('checked',true);
				}
			}
			$('.form-actions button').click(function(){
				if(!validateForm('form')){
					return false;
				}else{
					$('form').submit();
				}
			});
			
			$('.role-box').each(function(){
				if($(this).find('input[name="perId"]').length == $(this).find('input[name="perId"][checked="checked"]').length){
					$(this).find('.select-all-item').attr('checked',true);
				}
			});
			if($('.select-all-item[checked="checked"]').length == $('.select-all-item').length){
				$('.select-all').attr('checked',true);
			}
			
			$('.select-all').click(function(){
				if(!!$(this).attr('checked')){
					// 全选
					$('.role-box').find('input[type="checkbox"]').attr('checked',true);
				}else{
					// 取消全选
					$('.role-box').find('input[type="checkbox"]').attr('checked',false);
				}
			});
			$('.select-all-item').click(function(){
				if(!!$(this).attr('checked')){
					// 全选
					$(this).parents('.role-box').find('input[type="checkbox"]').attr('checked',true);
				}else{
					// 取消全选
					$(this).parents('.role-box').find('input[type="checkbox"]').attr('checked',false);
				}
			});
			$('input[name="perId"]').click(function(){
				if(!$(this).attr('checked')){
					$(this).parents('.role-box').find('.select-all-item').attr('checked',false);
					$('.select-all').attr('checked',false);
				}
			});
			
		});
	</script>
	
</body>
</html>