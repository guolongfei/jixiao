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
    
    <title>专办评分</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="<%=basePath%>js/jQuery.js"></script>
	<link href="/jixiao/kindeditor/themes/default/default.css" rel="stylesheet"/>
    <link rel="stylesheet" href="/jixiao/kindeditor/plugins/code/prettify.css" />
    <script src="/jixiao/kindeditor/kindeditor.js"></script>
    <script src="/jixiao/kindeditor/lang/zh_CN.js"></script>
    <script src="/jixiao/kindeditor/plugins/code/prettify.js"></script>
  <STYLE>
  body{
  	margin:0;
	padding:0;
	background: url("<%=basePath%>images/jkn_2.jpg") repeat-x;
  }
  .label
  {
     color:#235c9d;
  }
   .cmdFiled{
			border:0px;
			background: url("<%=basePath%>images/bg_rectbtn.png") no-repeat;
			overflow: hidden;
			width: 67px;
			color:#fff;
			line-height: 27px;
			height: 27px;
			cursor: pointer;
			font-size: 14px;
			font-weight: bold;
		}
  </STYLE>
  	<script>
		//var editor1;
		KindEditor.ready(function(K) {
			var editor1 = K.create('textarea[name="content"]', {
				cssPath : '/jixiao/kindeditor/plugins/code/prettify.css',
				uploadJson : '/jixiao/kindeditor/jsp/upload_json.jsp',
				fileManagerJson : '/jixiao/kindeditor/jsp/file_manager_json.jsp',
				allowFileManager : true,
				afterCreate : function() {
					var self = this;
					K.ctrl(document, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
					K.ctrl(self.edit.doc, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
				},
				afterBlur: function(){
					this.sync();
					$("#mrc").val($("textarea[name='content']").val());
				}
			});
			prettyPrint();
		});
		
		$(function()
   {
     var myDate = new Date();  
     var year=myDate.getFullYear();
     var str;
     for(var i=0;i<=5;i++)
     {        
         str+="<option value='"+(year-i)+"'>"+(year-i)+"年"+"</option>";
	 }     
     $("#year").html(str);
     
      $("#submitDuty").click(function(){
          var flag;
	      if($("#mrc").val()==''||$("#mrc")==null){
	         alert("请填写专办内容!");
	         return;
	      }
	      var year=$("#year").val();
	      var season=$("#season").val();
	        $.ajax(
          {
              type:"post",
              url:"/jixiao/SpecialScore/SpecialScore_IsExistScore.action",
              data:"year="+year+"&season="+season+"",
              dataType:"json",
              success: function(data){      
                        flag=data.flag;
                         if(flag==0)
                         {
	                        $("#form").submit();
	                     }
	                     else
	                     {
	                        $("#error").css("display","inline");
	                     }
                      }
         });
        
	    
	   });
     })
     
     function Yincang()
     {
        $("#error").css("display","none"); 
     }
	</script>
	</head>
  <body>
    <form id="form" action="/jixiao/SpecialScore/SpecialScore_addScore.action" method="post" enctype="multipart/form-data">
     <table cellpadding="0" cellspacing="0"  border="0" width="95%" style="background-color: white;">      
            <tr>            
                <td width="100%" valign="top">
             
            <table cellpadding="0" cellspacing="0"  border="0" width="90%" height="100%" style="margin: 0 auto;">
                  <tr>
                       <td height="20" colspan="3"></td>
                  </tr>
                  <tr>
                        <td>
                        <div style="width: 120px;">
                        <div style="float: left;">
                        		 <img alt="" src="/jixiao/images/log.png" width="50px" height="50px"/>
                        </div>                    
                        	 <div style="font-family:微软雅黑;color: #235c9d;;font-weight: bold;float: right;line-height: 50px;">专班评分</div>
                        </div>                                      
                        </td>
                  </tr>
                   <tr>
                       <td height="20" colspan="3"></td>
                  </tr>
                  <tr>
                        <td><SELECT id="year" name="spec.score_year" style="height:30px;width:100px;border:1px solid #adadad;" class="select" onchange="Yincang();"></SELECT>
                        <SELECT id="season" name="spec.score_season" style="height:30px;width:100px;border:1px solid #adadad;" class="select" onchange="Yincang();">
                             <option value="1">一季度</option>
                             <option value="2">二季度</option>
                             <option value="3">三季度</option>
                             <option value="4">四季度</option>
                             </SELECT>
                             <label id="error" style="color:red;display:none;">本季度已经上传过相关内容</label>
                        </td>
                  </tr>
                   <tr>
                       <td height="30" colspan="3"></td>
                  </tr>
                  <tr>
                       
                       <td><label class="label">专办内容：</label></td>
                  </tr>
                    <tr>
                       <td height="10" colspan="3"></td>
                  </tr>
                   <tr>
                       
                       <td><textarea label="描述" id="mrc"  style=" width:38.3%; height:150px;display:none;"  name="spec.score_content" value=""></textarea></td>									
                  </tr>
                   <tr>                    
                       <td><textarea name="content" cols="100" rows="8" style="width:1040px;height:400px;"></textarea></td>
                  </tr>
                    <tr>
                       <td height="20" colspan="3"></td>
                  </tr>
                  <tr>
                        <td><label class="label">附件上传:<input type="file" name="file"></label></td>
                  </tr>
                    <tr>
                       <td height="20" colspan="3"></td>
                  </tr>
                  <tr>
                       <td><div style="width: 90%;height: 35px;" ><button type="button" id="submitDuty" class="cmdFiled">保存</button></div></td>
                  </tr>                   
             </table>
        	</td>
      </tr>
    </table>
    </form>
  </body>
</html>
