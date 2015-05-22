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
    
    <title> 评分详情</title>
    <script type="text/javascript" src="<%=basePath%>js/jQuery.js"></script>
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
	color:#2D92EA;;
	font-weight: bold;
	font-weight: bold;
}
  body{
  	margin:0;
	padding:0;
	background: url("<%=basePath%>images/jkn_2.jpg") repeat-x;
  }
</style>
  </head>
  <script>
  $(function()
   {
     var myDate = new Date();   
     var year=myDate.getFullYear();
     var str="<option value='0'>--请选择--</option>";
     for(var i=0;i<=5;i++)
     {                
         str+="<option value='"+(year-i)+"'>"+(year-i)+"年"+"</option>";
	 }     
     $("#year").html(str);
     var y= $("#y").val(); 
     var s= $("#s").val(); 
     $("#season").find("option[value='"+s+"']").attr("selected",true);
     $("#year").find("option[value='"+y+"']").attr("selected",true);    
     $("#query").click(function(){
          
	      if($("#year").val()==0){
	         alert("请选择年份!");
	      }
	      else if($("#season").val()==0){
	         alert("请选择季度!");
	      }	  	      
	      else
	      {
	      $("#form").submit();	
	      }                         	    
	   });  
     })
        
  </script>
  <body>
    <table cellpadding="0" cellspacing="0"  border="0" width="95%" style="background-color: white;" height="520">       
            <tr>              
                <td width="100%" valign="top">
                 <table width="1042" border="0" cellpadding="0" cellspacing="0" style="margin: 0 auto;">
			<tr>
				<td height="8" bgcolor="#FFFFFF">
					<table width="95%" border="0" align="center" cellpadding="0"
						cellspacing="0">
						<tr>
							<td height="20"></td>
						</tr>
						
						<tr>
							<td>
								<table width="100%" border="0" align="center" cellpadding="0"
									cellspacing="0">
									<tr> 
									<td>
									<div style="width: 90%;height: 50px;">
                                <div style="float: left"><img alt="" src="/jixiao/images/log.png" width="50px" height="50px"/></div> 
                                <div style="font-family: 微软雅黑;font-weight: bolder;font-size: 1.0em;float: left;line-height: 50px;color: #235C9D;">评价得分</div>
                            </div>
                            </td>
                        </tr>                        
						<tr>
						<td>
						<form id="form" action="/jixiao/SpecialScore/SpecialScore_selectScore.action" method="post">
                        <SELECT id="year" name="spec.score_year" style="height:30px;width:100px;border:1px solid #adadad;" class="select" onchange="Yincang();"></SELECT>
                        <SELECT id="season" name="spec.score_season" style="height:30px;width:100px;border:1px solid #adadad;" class="select" onchange="Yincang();">
                             <option value="0">--请选择--</option>
                             <option value="1">一季度</option>
                             <option value="2">二季度</option>
                             <option value="3">三季度</option>
                             <option value="4">四季度</option>
                             </SELECT>
                             <input type="button" id="query" style="width: 80px;height: 30px;border: 1px solid #adadad;background-color:#2D92EA ;cursor: pointer;color: white;" value="查看">
                             
                        </form>
                         </td>
                       </tr>                   
									<tr>
										<td height="30" align="center" class="la03">
                                              <span style="font-size:25px;">评分详情</span>
										</td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td height="20"></td>
						</tr>
						<tr>
								<s:if test="size==0">
						<input id="y" type="hidden" value="<s:property value="year" />" />
						<input id="s" type="hidden" value="<s:property value="season" />" />
						<div class=TRS_Editor>暂无相关数据</div></s:if></td>
						</tr>
						<tr>
							<td valign="top">
							<s:iterator value="list" var="li" status="st">
								<table width="100%" border="0" align="center" cellpadding="0"
									cellspacing="0">
									<tr>
										<td height="1" bgcolor="#E4C08F"></td>
										<td><input id="y" type="hidden" value="<s:property value="year" />" /></td>
										<td><input id="s" type="hidden" value="<s:property value="season" />" /></td>
									</tr>								
									<tr>
										<td height="20">								
										</td>
									</tr>
									<tr>
										<td height="30">
											<div class=TRS_Editor>			
												<s:property value="#li.score_content" escape="false"/>
											</div>
										</td>
									</tr>
									<tr>
										<td height="20"></td>
									</tr>
									<tr>
										<td height="20" align="left" valign="top">
											<table width="100%" border="0" cellpadding="0"
												cellspacing="0">
												
												<tr>
												<s:if test="#li.score_file!=null"> 
													<td width="20px;">
														
														<img src="<%=basePath%>images/xl_ioc_2.jpg" height="15px"></img>
													</td>
													<td align="left">
													
													<div class="la04">
														&nbsp;附件：
														 <a href="/jixiao/upload/<s:property value="#li.score_file"/>"
															target="_blank"><s:property value="#li.score_file" /></a>
															</div>
															
													</td>
													</s:if>
												</tr>
												
											</table>
										</td>
									</tr>
									<tr>
										<td height="20"></td>
									</tr>
									
									<tr>
										<td height="1" bgcolor="#E4C08F"></td>
									</tr>
								</table>
								</s:iterator>
							</td>	
							<td height="30"></td>								
						</tr>
					</table>
				</td>
			</tr>
		</table>
           
         </td>
      </tr>
    </table>
  </body>
</html>
