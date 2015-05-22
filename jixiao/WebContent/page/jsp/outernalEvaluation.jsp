<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>外部测评</title>
<style>
a{
text-decoration: none;
color:black;
}	
</style>
</head>
<script language="javascript" src="<%=basePath%>js/jquery.min.js"></script>
<script src="<%=basePath%>datepicker/WdatePicker.js"></script>
<link href="<%=basePath%>datepicker/WdatePicker.css"/>
<link href="/jixiao/css/loginbox.css" rel="stylesheet" type="text/css"/>
 <script type="text/javascript">
  //修改选择某一行的颜色
  function changeColor(id)
  {
       var obj=document.getElementById("trcolor"+id);     
       obj.bgColor="#99ccff"; 
               
  } 
  function changeColor1(id)
  {
       var obj=document.getElementById("trcolor"+id);          
       obj.bgColor="";               
  }
 
 

 
   $(function(){
      $("#vote").click(function(){
	      	var check2 = document.getElementsByName("documentIds");
	    	var objYN = false;
	    	var param="";
	    	var count = 0;
	      for(var j=0;j<check2.length;j++){
	     		if(check2[j].checked){
	            param+=check2[j].value+',';
	            objYN= true;
	            count++;
	         	} 
	    	} 
	    	if(objYN== false){
     		alert("请至少选择一项！");
	    	}else{
		    	if(count>5){
		    		alert("请选择5个以下的部门");
		    	}else{
		    		if(confirm("确认投票吗?")){
		    		document.getElementById("depId").value=param.substring(0,param.length-1);;
		    		 $('.theme-popover-mask').fadeIn(100);
	    			 $('.theme-popover1').slideDown(200);
	    			 	
		    		}
		    	}
	 		}
      });
    });
    
    
    function tijiao(){
    var depId = document.getElementById("depId").value;
    var name = document.getElementById("name").value;
	var tel= document.getElementById("tel").value;
	 if(name==""){
	    alert("请留下您的大名！");
	    return;
	  }
	 if(tel==""){
	    alert("请留下您的电话！");
	    return;
	 }
	 else{
	 document.getElementById("f").action="/jixiao/messageManage/record_OuternalVote.action";
	 document.getElementById("f").submit();
	  }
    }
 
 	
 	function boxclose(){
	//$('.theme-popover-mask').fadeOut(100);
	$('.theme-popover1').slideUp(200);
	var selectCheckboxs = $("input[type=checkbox][name=selectpf]:checked");
	var length = selectCheckboxs.length;
	var selectvalue = "";
	for(var i=0;i<length;i++){
	   selectvalue += (i+1)+","+selectCheckboxs[i].value;
	}
    }
 
 </script>
<jsp:include page="/home/header.jsp"></jsp:include>
<body>
        <table align="center" cellpadding="0" cellspacing="0"  border="0" width="1003" >
            <tr>
                <td width="85%" valign="top">
                 <table cellpadding="0" cellspacing="0"  border="0" width="100%"  bgcolor="#F1F6FA" style="padding-left: 30px;padding-right: 30px;">
                  <tr>
                       <td height="50" colspan="3"></td>
                  </tr>
               
                   <tr>
                       <td>
                       <h3><input type="button" value="我要投票" id="vote" onclick="vote()"></h3>
                       <table cellpadding="0" cellspacing="0"  border="1" bordercolor="#E4C08F" style="border-collapse:collapse;" width="100%" height="100%">
	                       <tr>
	                       <td width="15%" height="30px" align="center" bgcolor="#F6EBE3"><div style="color:red;font-weight: bold;">操作</div></td>
	                       <td width="15%" height="30px" align="center" bgcolor="#F6EBE3"><div style="color:red;font-weight: bold;">部门名称</div></td>
	                       <td width="15%" height="30px" align="center" bgcolor="#F6EBE3"><div style="color:red;font-weight: bold;">部门级别</div></td>
	                       </tr>
	                       <s:iterator value="list" var="li" status="st">
		                       <tr id="trcolor<s:property value="#st.index+1" />" onmousemove="changeColor(<s:property value="#st.index+1" />);" onmouseout="changeColor1(<s:property value="#st.index+1" />);">
			                       <td height="40px"  align="center">
			                       		<input  type="checkbox" name="documentIds"  value="<s:property value="#li.id" />">
			                       	</td>
			                       <td height="40px" align="center"><s:property value="#li.name" />
			                       </td>
			                       <td height="40px" align="center"><s:property value="#li.level" /></td>
	                       	</tr>
	                       </s:iterator>
                       </table>
                       
                       
                       </td>
                  </tr> 
                   <tr>
                       <td height="10" colspan="3"></td>
                  </tr>     
                 
                 </table>
                 
      <div class="theme-popover1" style="">
      <form id="f" action="" method="post">
	     <div class="theme-poptit" align="left">
	          <a title="关闭" class="close" onclick="boxclose()">×</a>
	          <h3>投票人信息</h3>
	     </div>
	     <div class="theme-popbod dform">
	            <table width="100%" cellspacing="0" style="" >
	            <tr>
	              	<td>姓名</td><td><input type="text"  name="name" id="name"/><input type="hidden" value="" id="depId" name="depId"></td>
	            </tr>
	              <tr>
	              	<td>联系方式</td><td><input type="text" name="tel" id="tel"/></td>
	              </tr>
	              <tr><td colspan="2" align="center">
	              	 <input type="button" id="select_day" style="width: 140px;height: 40px;background-image: url('/jixiao/images/button.png');border: 0px;" value="提交" onclick="tijiao()"/>
	              </td></tr>
	          </table>
	     </div>
	     </form>
   </div>
                 
               <table cellpadding="0" cellspacing="0"  border="0" width="100%" height="100%" bgcolor="#F1F6FA" style="padding-left: 30px;padding-right: 30px;">
                 <tr>
                 <td align="right">
                
      <input id="max" type="hidden" value="<s:property value="totalPage"/>" />
      <input id="cur" type="hidden" value="<s:property value="pageNum"/>" />
      <span> 共<s:property value="totalPage"/>页 页次:<s:property value="pageNum"/>/<s:property value="totalPage"/> 页</span>
      <a href="/jixiao/messageManage/message_getZhengceList.action?messageType=<s:property value="messageType"/>&pageNum=1">首页</a>
      <a onclick="previous(<s:property value="pageNum"/>,'<s:property value="messageType"/>');">上一页  &nbsp;</a><span><font color=red><s:property value="pageNum"/></font></span>&nbsp;&nbsp;<a onclick="next(<s:property value="pageNum"/>,<s:property value="totalPage"/>,'<s:property value="messageType"/>');">下一页</a>
      <a href="/jixiao/messageManage/message_getZhengceList.action?messageType=<s:property value="messageType"/>&pageNum=<s:property value="totalPage"/>">尾页</a> 
                   转到 <SELECT id="selection" NAME="select" onchange="changeValue('<s:property value="messageType"/>');"><option selected=selected>1</option></SELECT>

                 </td>
                 </tr>
                  <tr>
                       <td height="10" colspan="3"></td>
                  </tr>  
                 </table>   
           
         </td>
      </tr>
    </table>
    </body>
     <jsp:include page="/home/footer.jsp"></jsp:include>
</html>