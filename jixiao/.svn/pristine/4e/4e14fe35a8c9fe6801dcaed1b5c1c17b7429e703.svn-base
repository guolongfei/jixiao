<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html >
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=7" />
    <title>鄂州实绩考核网</title>
    <script type="text/javascript" src="/jixiao/js/jQuery.js"></script>
    <link href="../css/style.css" rel="stylesheet" type="text/css"/>
    <link href="../css/ulstyle.css" rel="stylesheet" type="text/css"/>
    <style type="text/css">
    	.column-box{
    		width: 318px;
    		height:215px;
    		float: left;
    		border: #d4d8d4 1px solid; 
    	}
    	.column-box ul{	    	
    		margin: 10px 0px 0px 5px;
    	}
    	.column-box ul li{
    		line-height: 26px;
    		font-size: 13px;
    		text-align: left;
    		width: 313px;
    		text-overflow:ellipsis;
        	white-space:nowrap;
        	overflow:hidden;
    	}
    	.column-box ul li a{
    		padding-left:8px;
    		text-decoration: none;
    		color: #585858;
    		font-size: 14px;
    	}
    	.column-box ul li a:HOVER{
    		text-decoration: underline;
    	}
    	.column-top{
    		border-bottom: #235C9D 4px solid;
    		width: 319px;
    		height: 33px;
    	}
    	.column-top span{
    		line-height: 33px;
    		padding-left:10px;
    		float: left;
    		font-size: 16px;
    	}
    	.column-top a{
    		line-height: 33px;
    		text-decoration: none; 		
    	}
    	.code  
        {  
            background-image:url(../images/ldxx_04.gif);  
            font-family:Arial;  
            font-style:italic;  
            color:Red;  
            border:0;  
            padding:2px 3px;  
            letter-spacing:3px;  
            font-weight:bolder;  
        }  
        table tr td a{
        	font-size: 14px;       	
        }
       	.bm_fl{
       		width: 130px;
       		float: left;
       		height: 45px;
       		line-height: 45px;
       		text-align: center;
       		font-size: 13px;
       	}
       	.blk_29{
       		width: 1001px;
       		height: 130px;
       		overflow: hidden;
       		display: block;
       	}
       	.blk_29 .leftBotton{
       		background: url("../images/P_roll.gif") no-repeat 0px 0px;
       		margin-left: 5px;
       		width: 11px;
       		cursor: pointer;
       		margin-top: 8px;
       		height: 114px;
     		float: left;    		
       	}
       	a.abtn{display:block;height:130px;width:17px;overflow:hidden;background:url(../images/arrow3.png) no-repeat 0px 50%;}
		a.aleft{float:left;}
		a.agrayleft{cursor:default;background-position:-34px 50%;}
		a.aright{float:right;background-position:-17px 50%;}
		a.agrayright{cursor:default;background-position:-51px 50%;} 
		.scrolllist{height: 140px;width: 970px;position: relative;overflow: hidden;margin: 0 auto;}
		.scrolllist .imglist_w{width:935px;height:140px;overflow:hidden;float:left;position:relative;/*必要元素*/}
		.scrolllist .imglist_w ul{width:20000px;position:absolute;left:0px;top:0px;}
		.scrolllist .imglist_w li{width:163px;float:left;padding-top: 5px;padding-right: 20px;}
		.scrolllist .imglist_w li img{}		
    </style>
    <script type="text/javascript">
      
      
      $(function(){
         $(".aa").each(function(){
            if($(this).text().length>10){
		     $(this).text($(this).text().substring(0,10));
		     $(this).html($(this).html()+"..."); 
		    }
         });
         /*if($("#con").text().length>15){
            $("#con").text($("#con").text().substring(0,15));
            $("#con").html($("#con").html()+"..");
         }*/
         $(".po").each(function(){
            if($(this).text().length>25){
		     $(this).text($(this).text().substring(0,25));
		     $(this).html($(this).html()+"..."); 
		    }
         });
          $(".do").each(function(){
            if($(this).text().length>18){
		     $(this).text($(this).text().substring(0,18));
		     $(this).html($(this).html()+"..."); 
		    }
         });
         $(".ck").each(function(){
            if($(this).text().length>20){
		     $(this).text($(this).text().substring(0,20));
		     $(this).html($(this).html()+"..."); 
		    }
         });
         $(".ping_jia").each(function(){
            if($(this).text().length>25){
		     $(this).text($(this).text().substring(0,25));
		     $(this).html($(this).html()+"..."); 
		    }
         });
      })
    </script>
    <script language="javascript" type="text/javascript"> 
      
     var code ; //在全局 定义验证码  
     function createCode(e) 
     {
       code = "";  
       var codeLength = 4;//验证码的长度  
       var checkCode = document.getElementById("checkCode");  
       var selectChar = new Array(0,1,2,3,4,5,6,7,8,9,'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z');//所有候选组成验证码的字符，当然也可以用中文的     
       for(var i=0;i<codeLength;i++)  
       {  
        var charIndex = Math.floor(Math.random()*36);  
        code +=selectChar[charIndex];  
       }   
       if(checkCode)  
       {  
         checkCode.className="code";  
         checkCode.value = code;
         checkCode.blur();  
       } 
     
     }
     function userLogin(){    	   				
        			var user_Name = $("#user_Name").val();
        			var password = $("#password").val();
        			var is_save = document.getElementById("is_save").checked;
        			var verify = $("#verify").val();
        			var checkCode = $("#checkCode").val(); 
        			var is_save = document.getElementById("is_save");      			
        			if(user_Name==""||user_Name==null){
        				alert("用户名不能为空!");
        				return;
        			}
        			else if(password==""||password==null){
        				alert("密码不能为空!");
        				return;
        			}
        			else if(verify==""||verify.length<=0){
        				alert("请输入验证码!");
        				return;
        			}
        			 else if(verify.toUpperCase()!= code )  
       				{  
          				alert("验证码输入错误！");  
          				createCode();//刷新验证码  
       				} 
        			else{
        				if(is_save.checked){
       						is_save.value = 1;
       					}
       					else{      		    						
       						is_save.value = 2;     
       					} 
        				document.getElementById("f").action="../messageManage/homePage_Login.action";
        				document.getElementById("f").submit();
        			}	
        		}
        		function synthesize(){
        			$("#title_synthesize").css("background","url('../images/index_43.jpg')");
        			$("#title_synthesize").css("color","white");
        			$("#title_street").css("background","");
        			$("#title_street").css("color","black");
        			$("#title_city").css("background","");
        			$("#title_city").css("color","black");
        			$("#syn").css("display","block");
        			$("#st").css("display","none");
        			$("#ct").css("display","none");
        			for(var i=0;i<8;i++){
        				$("#synthe"+i).css("display","block");
        				$("#dynamic"+i).css("display","none");
        				$("#street"+i).css("display","none"); 
        			}
        		}
        		function cityChange(){
        			$("#title_synthesize").css("background","");
        			$("#title_synthesize").css("color","black");
        			$("#title_street").css("background","");
        			$("#title_street").css("color","black");
        			$("#title_city").css("background","url('../images/index_43.jpg')");
        			$("#title_city").css("color","white");
        			$("#st").css("display","none");
        			$("#ct").css("display","block");
        			$("#syn").css("display","none");
        			for(var i=0;i<8;i++){
        				$("#dynamic"+i).css("display","block");
        				$("#street"+i).css("display","none"); 
        				$("#synthe"+i).css("display","none");
        			}
        			
        		}
        		function streetChange(){
        			$("#title_synthesize").css("background","");
        			$("#title_synthesize").css("color","black");
        			$("#title_city").css("background","");
        			$("#title_city").css("color","black");
        			$("#title_street").css("background","url('../images/index_43.jpg')");
        			$("#title_street").css("color","white");
        			$("#st").css("display","block");
        			$("#ct").css("display","none");
        			$("#syn").css("display","none");
        			for(var i=0;i<8;i++){
        				$("#dynamic"+i).css("display","none");
        				$("#street"+i).css("display","block");
        				$("#synthe"+i).css("display","none"); 
        			}
        		}
        		function dt(type){
        			window.location.href = "../messageManage/message_getMessageList.action?messageType="+type;
        		}
        		
        		function chance_purpose1(){
        			$("#purpose1").css("background","url('../images/index_43.jpg')");
        			$("#purpose1").css("color","white");
        			$("#purpose2").css("background","");
        			$("#purpose2").css("color","black");
        			$("#purpose3").css("background","");
        			$("#purpose3").css("color","black");
        			$("#syn1").css("display","block");
        			$("#st1").css("display","none");
        			$("#ct1").css("display","none");
        			for(var i=0;i<8;i++){
        				$("#synthe1"+i).css("display","block");
        				$("#dynamic1"+i).css("display","none");
        				$("#street1"+i).css("display","none"); 
        			}
        		}
        		function chance_purpose2(){
        			$("#purpose1").css("background","");
        			$("#purpose1").css("color","black");
        			$("#purpose3").css("background","");
        			$("#purpose3").css("color","black");
        			$("#purpose2").css("background","url('../images/index_43.jpg')");
        			$("#purpose2").css("color","white");
        			$("#st1").css("display","none");
        			$("#ct1").css("display","block");
        			$("#syn1").css("display","none");
        			for(var i=0;i<8;i++){
        				$("#dynamic1"+i).css("display","block");
        				$("#street1"+i).css("display","none"); 
        				$("#synthe1"+i).css("display","none");
        			}
        			
        		}
        		function chance_purpose3(){
        			$("#purpose1").css("background","");
        			$("#purpose1").css("color","black");
        			$("#purpose2").css("background","");
        			$("#purpose2").css("color","black");
        			$("#purpose3").css("background","url('../images/index_43.jpg')");
        			$("#purpose3").css("color","white");
        			$("#st1").css("display","block");
        			$("#ct1").css("display","none");
        			$("#syn1").css("display","none");
        			for(var i=0;i<8;i++){
        				$("#dynamic1"+i).css("display","none");
        				$("#street1"+i).css("display","block");
        				$("#synthe1"+i).css("display","none"); 
        			}
        		}
        		//实绩展示
        		function zxChange(id){
        		for ( var i = 1; i < 9; i++) {
        		if(i==id){
        			$("#zx_tb"+i).css("color","red");
        			$("#zx_tb"+i).css("fontSize","14px");
        			$("#zx_tb"+i).css("fontWeight","bold");
        			$("#zx_tb"+i).css("textDecoration","underline");
					if(id==1){
        				$("#zxsj").css("display","");
        				$("#bmlb").css("display","none")
        			}
        			else{        	
        				$("#zxsj").css("display","none");
        				$("#bmlb").css("display","")
        				for(var j=1;j<=94;j++){
        					if(id==2&&1<=j&&j<=13){
        						$("#tb_qj").css("display","");
        					}
        					else if(id==3&&14<=j&&j<=28){
        						$("#tb_qt").css("display","");
        						$("#bm"+j).css("display","");
        						$("#tb_qj").css("display","none");
        					}
        					else if(id==4&&29<=j&&j<=38){
        						$("#tb_qt").css("display","");
        						$("#bm"+j).css("display","");
        						$("#tb_qj").css("display","none");
        					}
        					else if(id==5&&39<=j&&j<=55){
        						$("#tb_qt").css("display","");
        						$("#bm"+j).css("display","");
        						$("#tb_qj").css("display","none");
        					}
        					else if(id==6&&56<=j&&j<=69){
        						$("#tb_qt").css("display","");
        						$("#bm"+j).css("display","");
        						$("#tb_qj").css("display","none");
        					}
        					else if(id==7&&70<=j&&j<=83){
        						$("#tb_qt").css("display","");
        						$("#bm"+j).css("display","");
        						$("#tb_qj").css("display","none");
        					}
        					else if(id==8&&84<=j&&j<=94){
        						$("#tb_qt").css("display","");
        						$("#bm"+j).css("display","");
        						$("#tb_qj").css("display","none");
        					}
        					else{
        						$("#bm"+j).css("display","none");
        					}
        				}   			
        			} 
        		}
        		else{
        			$("#zx_tb"+i).css("color","#2b2b2b");
        			$("#zx_tb"+i).css("fontSize","12px");
        			$("#zx_tb"+i).css("fontWeight","normal");
        			$("#zx_tb"+i).css("textDecoration","");
        			if(id==1){
        					$("#zxsj").css("display","");
        					$("#bmlb").css("display","none")
        			}
        			else{
        					$("#zxsj").css("display","none");
        					$("#bmlb").css("display","")
        				}       					
        			}
					}
        		}	
        	
  </script>
  </head>
  
  <jsp:include page="header.jsp"></jsp:include>
  <body onload="createCode()">
  <table width="1003" bgcolor="#FFFFFF" height="10"><tr><td></td></tr></table>
  <table width="1003" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
  <tr>
    <td width="300" valign="top">
	<table width="90%" height="260" border="0" align="center" cellpadding="0" cellspacing="0" class="line1">
      <tr>
        <td width="65%" align="center">
        <div style="display: none;">
      
        <s:iterator value="imagesList">    	
        	<input name="imageUrl" value="../message_upload/<s:property value='title_img_url'/>"/>
        	<input name="title" value="<s:property value='title'/>"/>
        	<input name="summary" value="<s:property value='summary'/>"/>
        	<input name="link" value="../messageManage/message_detail.action?id=<s:property value='id'/>"/>
        </s:iterator>
        
        </div>
		<!-- 播放器 begin -->
<script type="text/javascript" src="../images/imgplayer.js"></script>
<script type="text/javascript" language="javascript">
			//内容部分
			ss = new slideshow("ss");
			ss.prefetch = 1;
			ss.sizelmt = true;
			ss.repeat = true;
          	var imageUrl = document.getElementsByName("imageUrl");
          	var title = document.getElementsByName("title");
          	var summary = document.getElementsByName("summary");
          	var link = document.getElementsByName("link");
          	for(var i=0;i<imageUrl.length;i++){
          		s = new slide();
          		s.src = imageUrl[i].value.toString();
				s.title = "图片新闻";
				s.link = link[i].value;
				//summary[i] = summary[i].substring(0,15);
				s.con = title[i].value;
				ss.add_slide(s);
          	}							
			for (var i=0; i < ss.slides.length; i++) {		
				s = ss.slides[i];	
			}
			//--><!]]>
			</script>
			
			<!-- 图片播放器主体 begin -->
				<!-- 大图 begin -->
				<div id="ImgBlk">
					<div id="ss_img_div">
					    <a href="javascript:ss.hotlink();">
					        <img id="ss_img" style="filter:blendTrans(Duration=1);" width="308" height="248" src="../message_upload/<s:property value='imageUrl'/>" />
                        </a>
                        <div id="ImgNum">
						<!-- 数字 begin -->
						<ul>
							<s:iterator value="imagesList" status="st">
							<li class="itemOff" id="imbtn<s:property value='#st.index'/>" onMouseOver="ss.goto_slide(<s:property value='#st.index'/>)" onClick="ss.goto_slide(<s:property value='#st.index'/>)"><a href="javascript:ss.hotlink();"><s:property value="#st.index+1"/></a></li>
							</s:iterator>	
						</ul>
						<!-- 数字 end -->

					</div>
                    </div>
					
				</div>
				<!-- 大图 end -->
				<!-- 标题正文 begin -->
				<div id="TxtBlk">
					<!-- 内容 begin -->
					<div id="Txt">
						<span id="con" style="font-weight:bolder;"></span>
						<span id="more"></span>
					</div>
					<!-- 内容 end -->
				</div>
				<!-- 标题正文 end -->
			
			<!-- 图片播放器主体 end -->
			<script type="text/javascript">
			<!--//--><![CDATA[//><!--
			ss.pre_update_hook = function() {
				sid = ss.current;
				title = ss.slides[sid].title;
				linkurl = ss.slides[sid].link;
				totals = ss.slides.length;
				scon = ss.slides[sid].con;
				tempid = parseInt(sid) + 1;
				document.getElementById("con").innerHTML =scon;
				//document.getElementById("more").innerHTML = "<a href='"+linkurl+"'>详细>></a>";
				for (var i = 0;i < ss.slides.length;i++){
					document.getElementById("imbtn"+i).className = "itemOff";
				}
				document.getElementById("imbtn"+sid).className = "itemOn";
			  return;
			}
			if (document.images) {
				ss.image = document.images.ss_img;
				ss.update();
				ss.play();
			}
			//--><!]]>
			</script>
		<!-- 播放器  end -->

		</td>
      </tr>
    </table>
	</td>
	<td width="450px" valign="top">
	  <table width="425" border="0" align="center" cellpadding="0" cellspacing="0" class="line1" height="260">
      <tr>
        <td width="65%" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td height="33" valign="bottom" background="../images/index_22.jpg">
             <div  style="width: 300px;padding-left:10px;">
             <table width="300" border="0" cellpadding="0" cellspacing="0" class="titel03">
              <tr>
              	<td id="title_synthesize" width="80" height="24" align="center" style="color: white;font-weight: bold;cursor: pointer;background:url('../images/index_43.jpg');" onmousemove="synthesize()" onclick="dt(12)"><s:property value="Synthe_type"/></td>
                <td id="title_city" width="80" height="24" align="center" style="color:balck;font-weight: bold;cursor: pointer;" onmousemove="cityChange()" onclick="dt(3)"><s:property value="Dynamic_type"/></td>
                <td id="title_street" width="80" height="24"  align="center" style="color: black;font-weight: bold;cursor: pointer;" onmousemove="streetChange()" onclick="dt(11)"><s:property value="Block_type"/></td>         
              </tr>
            </table>
            </div></td>
          </tr>
          <tr>
            <td><table width="96%" border="0" align="center" cellpadding="0" cellspacing="0" class="box" height="190px">
			  <s:iterator value="getSynthesize" status="st">
              <tr id="synthe<s:property value='#st.index'/>" style="display: block;">
                <td width="300"><span style="color:#585858;">·</span>　<a href="../messageManage/message_detail.action?id=<s:property value='id'/>" class="do"><s:property value="title"/></a><br></td>
                <td width="100" align="right">(<s:date name="add_time" format="yyyy-MM-dd"/>)</td>
              </tr>         
			 </s:iterator>
			  <s:iterator value="DynamicList" status="st">
              <tr id="dynamic<s:property value='#st.index'/>" style="display: none;">
                <td width="300"><span style="color:#585858;">·</span>　<a href="../messageManage/message_detail.action?id=<s:property value='id'/>" class="do"><s:property value="title"/></a><br></td>
                <td width="100" align="right">(<s:date name="add_time" format="yyyy-MM-dd"/>)</td>
              </tr>         
			 </s:iterator>
			 <s:iterator value="BlockList" status="st">
			 <tr id="street<s:property value='#st.index'/>" style="display: none;">
                <td width="300"><span style="color:#585858;">·</span>　<a href="../messageManage/message_detail.action?id=<s:property value='id'/>" class="do"><s:property value="title"/></a><br></td>
                <td width="100" align="right">(<s:date name="add_time" format="yyyy-MM-dd"/>)</td>
			 </tr>
			 </s:iterator>
            </table>
            <table width="96%" border="0" align="center" cellpadding="0" cellspacing="0" class="box">
               <tr id="syn" style="display: block;"> 
			 	<td width="300"></td>           
                <td width="100" align="right"><a href="../messageManage/message_getMessageList.action?messageType=12">更多&gt;&gt;</a></td>
              </tr>				
			 <tr id="ct" style="display: none;"> 
			 	<td width="300"></td>           
                <td width="100" align="right"><a href="../messageManage/message_getMessageList.action?messageType=3">更多&gt;&gt;</a></td>
              </tr>
              <tr id="st" style="display: none;"> 
              	<td width="300"></td>            	
                <td width="100" align="right"><a href="../messageManage/message_getMessageList.action?messageType=11">更多&gt;&gt;</a></td>	
              </tr>
            </table>
            </td>
          </tr>
        </table></td>
        </tr>
    </table>
	</td>
	<td width="250" valign="top" height="260" align="center"><table width="240" border="0" cellpadding="0" cellspacing="0" class="line1" bgcolor="#f0f0f0">
      <tr>
        <td width="240"><table width="100%" height="33" border="0" cellpadding="0" cellspacing="0" background="../images/index_22.jpg">
            <tr>
              <td width="12%" height="33"><img src="../images/index_20.jpg" width="28" height="33" /></td>
              <td width="88%" class="titel02" align="left">鄂州市干部实绩考核系统</td>
            </tr>
        </table></td>
     </tr>
      <tr>
        <td height="225px" valign="top">
        <form id="f" method="post">
        <table width="100%" height="160" cellpadding="0" cellspacing="0">
        	<tr>
        		<td width="40%" align="center" style="font-size: 1.1em;font-weight: bolder;">用户名:</td>
        		<td><input id="user_Name" type="text" name="user_Name" value="<% if(request.getSession().getAttribute("userName")!=null){%><%= request.getSession().getAttribute("userName") %><%}%>" style="width: 120px;"/></td>
        	</tr>
        	<tr>
        		<td width="40%"></td>
        		<td>
        			<s:if test="errorType==0"><font style="color: red;">用户名不存在!</font></s:if>
        		</td>
        	</tr>
        	<tr>
        		<td width="40%" align="center" style="font-size: 1.1em;font-weight: bolder;">密　码:</td>
        		<td><input id="password" type="password" name="password" value="<% if(request.getSession().getAttribute("password")!=null){%><%= request.getSession().getAttribute("password") %><%}%>" style="width: 120px;"/></td>
        	</tr>
        	<tr>
        		<td width="40%"></td>
        		<td>
        			<s:if test="errorType==1"><font style="color: red;">密码不正确!</font></s:if>
        		</td>
        	</tr>
        	<tr>
        		<td width="40%" align="center" style="font-size: 1.1em;font-weight: bolder;">验证码:</td>
        		<td><input id="verify" type="text" name="verify" style="width: 60px;height: 21px;"/><input type="text" onclick="createCode()" readonly="readonly" id="checkCode" class="code" style="width: 60px;cursor:pointer;height: 21px;" /></td>
        	</tr>
        	<tr>    		
        		<td colspan="2" align="right" style="padding-right: 12px;vertical-align:middle;">
        			<div>
        				<div style="float: left;margin-left: 38px;margin-top: 5px;">  			
        					<input id="is_save" type="checkbox" name="is_save" style="vertical-align:text-top;margin-top: 0;height: 13px;" <% if(request.getSession().getAttribute("is_save")!=null){%> checked="checked" <%}%>/><span style="font-size: 1.1em;font-weight: bolder;">记住密码</span>	
        				</div>
        				<div style="float: right;margin-right: 20px;"> 	      				
        					<input id="imgLogin" type="image" src="../images/jk_r1_c13.jpg" width="55px"  onclick="userLogin()" height="28px"/>	
        				</div>  	
        			</div>
        		</td>
        	</tr>
        </table>
   			<div style="width: 100%;margin-top: 25px;height: 30px;">
        			<div style="width: 85px;height: 28px;line-height: 28px;border: 1px solid #adadad;float: left;margin-left: 5px;margin-top: 5px;">
        				<img alt="" src="../images/jk_r3.gif">&nbsp;<a href="../messageManage/record_queryDep2.action" style="font-size: 12px;">外部测评</a>
        			</div>
        			<div style="width: 85px;height: 28px;line-height: 28px;border: 1px solid #adadad;float: right;margin-right: 5px;margin-top: 5px;">
        				<img alt="" src="../images/jk_r4.gif">&nbsp;<a href="#" style="font-size: 12px;">联系电话</a>
        			</div>
        	</div>
        </form>
        </td>
      </tr>
    </table></td>  
   
    
	
  </tr>
</table>
<!-- 宣传图片 -->
<table width="1003" bgcolor="#FFFFFF" height="5"><tr><td></td></tr></table>
<table width="1003" align="center" cellpadding="0" cellspacing="0">
	<tr>
		<td>
			<embed height="80" type="application/x-shockwave-flash" pluginspage="http://www.macromedia.com/go/getflashplayer" width="1003" src="../images/topa.swf" quality="high" wmode="transparent">
		</td>
	</tr>
</table>  
<table width="1003" bgcolor="#FFFFFF" height="5"><tr><td></td></tr></table>
 <!-- 中间内容 --> 
  <table width="1003" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
  <tr>
    <td width="300" valign="top">
	       <table width="300" border="0" cellpadding="0" cellspacing="0" class="line1" height="182">
	         <tr>
	           <td width="298"><table width="100%" border="0" cellpadding="0" cellspacing="0" background="../images/index_22.jpg">
	            <tr>
	              <td width="8%" height="33"><img src="../images/index_20.jpg" width="28" height="33" /></td>
	              <td width="92%" class="titel02"><s:property value="message_type"/></td>
	            </tr>
	        </table>
	     </td>
	      </tr>
      <tr>
        <td height="245" valign="top"><div class="box">			
            <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0" valign="top" class="box">
	  		<s:iterator value="messageList">
              <tr valign="top">
                <td width="184" class="ts" align="left" valign="top" height="24" style="line-height:24px;"><span style="color:#585858;">·</span>
                <a href="../messageManage/message_detail.action?id=<s:property value='id'/>" title="<s:property value='title' />" class="aa"><s:property value="title" /></a></td>
                <td width="90" align="right">(<s:date name="add_time" format="yyyy-MM-dd"/>)</td>
              </tr>
			</s:iterator>
            </table>	
        </div></td>
      </tr>
	  <tr><td align="right" height="24"><a href="../messageManage/message_getMessageList.action?messageType=1">更多&gt;&gt;</a>&nbsp;</td></tr>
    </table></td>
    <td width="704" valign="top"><table width="689" border="0" cellpadding="0" cellspacing="0" class="line1">
      <tr>
        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" background="../images/index_22.jpg">
            <tr>
              <td width="5%" height="33"><img src="../images/index_20.jpg" width="28" height="33" /></td>
              <td width="95%" class="titel02"><s:property value="Policy_type"/></td>
            </tr>
        </table></td>
      </tr>
      <tr>
        <td>		
            <table width="95%" height="260" border="0" align="center" cellpadding="0" cellspacing="0" style="margin-top: 10px;">   
            <tr>
            	<td>
            		<table width="100%" border="0" cellpadding="0" cellspacing="0" background="../images/index_22.jpg" class="line1">
            			<tr>
             	 			<td id="zx_tb1" align="center" class="titel02" onmousemove="zxChange(1)" style="color: red;cursor: pointer;text-decoration: underline;">最新实绩</td>
             	 			<s:iterator value="getSortList" status="st">
             	 				<td id="zx_tb<s:property value='#st.index+2'/>" onmousemove="zxChange('<s:property value='#st.index+2'/>')" style="cursor: pointer;"><s:property value="name"/></td>
             	 			</s:iterator>
            			</tr>
        			</table>
            	</td>
            </tr>
            <!-- 展示最新实绩 -->
			 <tr id="zxsj">
			 	<td>
			 <div id="sj_d" style="width: 652px;height: 210px;overflow: hidden;border-bottom: 1px solid #CCCCCC;"> 						 					
			 	<table width="100%" height="400" border="0" cellpadding="0" cellspacing="0" class="line1">
			 			<tr>
			 				<td>
			 					<div id="sj_e">
			 						<table width="100%" cellpadding="0" cellspacing="0" border="0">
			 								<s:iterator value="PolicyList">
              									<tr>
                									<td width="" height="24" style="border-bottom: 1px solid #e0e0e0;"><span style="color:#585858;">·</span>　<a href="../messageManage/message_detail.action?id=<s:property value='id'/>&messageType=4" class="po"><s:property value="title"/></a></td>
                									<td width="100" align="right" style="border-bottom: 1px solid #e0e0e0;">(<s:date name="add_time" format="yyyy-MM-dd"/>)</td>
              									</tr>		    
											</s:iterator>
			 						</table>
			 					</div>
			 				</td>			 				
			 			</tr>
			 			<tr>
			 				<td id="sj_f"></td>
			 			</tr>
				</table>
			</div>
			<SCRIPT type="text/javascript">
				var speed5=30                                       
		   sj_f.innerHTML=sj_e.innerHTML                                       
		   function Marquee5(){                                       
		   if(sj_f.offsetHeight-sj_d.scrollTop<=0)                                       
		   		sj_d.scrollTop-=sj_e.offsetHeight                                       
		   else{                                       
		   	sj_d.scrollTop++                                       
		   }                                       
		   }                                       
		   var MyMar5=setInterval(Marquee5,speed5);                                       
		   sj_d.onmouseover=function() {clearInterval(MyMar5)};
		   sj_d.onmouseout=function() {MyMar5=setInterval(Marquee5,speed5)};  
			</SCRIPT>
			 	</td>			 
			 </tr>
			<!-- 展示部门信息 -->
			<tr id="bmlb" style="display: none;">
				<td>
					<div style="width:650px;float: left;height: 212px;border: 1px solid #cccccc;border-top: none;">
						<div id="tb_qj" style="display: none;"> 
						  <table width="100%" height="180" cellpadding="0" cellspacing="0" style="text-align:left;">
						  		<tr>
						  			<td style="padding-left: 20px;"><a style="font-size: 12px;" href="/jixiao/home/purpose.jsp">鄂城区</a></td>
						  			<td><a style="font-size: 12px;" href="/jixiao/home/purpose1.jsp" target="_blank">华容区</a></td>
						  			<td>梁子湖区</td>
						  		</tr>						  		
						  		<tr>
						  			<td colspan="2" style="padding-left: 20px;">葛店经济技术开发区</td>
						  			<td>鄂州经济开发区</td>
						  		</tr>
						  		<tr>
						  			<td width="126" style="padding-left: 20px;">鄂城新区</td>
						  			<td width="126">花湖新区</td>
						  			<td width="126">红莲湖新区</td>
						  			<td width="126">三江港新区</td>
						  			<td width="126">梧桐湖新区</td>					  			
						  		</tr>
						  		<tr>
						  			<td style="padding-left: 20px;">古楼街道</td>
						  			<td>凤凰街道</td>
						  			<td>西山街道</td>						  						  			
						  		</tr>
						  </table>
						  	
						</div>
						<div id="tb_qt" style="display: none;">
						
							<ul style="width: 650px;height: 180px;">
								<s:iterator value="getDepartmentList" var="li" status="st">														
									<li id="bm<s:property value='#st.index+1'/>" class="bm_fl" style="display: none;"><s:property value="name"/></li>										
								</s:iterator>
							</ul>
						</div>
					</div>		
				</td>
			</tr> 
			 <tr>
			 	<td height="20">
			 	
			 	</td>
			 </tr>
            </table>	
        </td>
      </tr>	 
    </table></td>
  </tr>
</table>
<table width="1003" bgcolor="#FFFFFF" height="5"><tr><td></td></tr></table>
<table width="1003" align="center" cellpadding="0" cellspacing="0" bgcolor="#ffffff">
	<tr>
		<td width="50%" valign="top">
	       <table width="490" border="0" cellpadding="0" cellspacing="0" class="line1" height="270">
	         <tr>
	           <td width="490" height="33"><table width="100%"  border="0" cellpadding="0" cellspacing="0" background="../images/index_22.jpg" style="height: 33px;">
	            <tr>
	              <td width="30" height="33"><img src="../images/index_20.jpg" width="28" height="33" /></td>
	              <td width="460" class="titel02">实绩通报</td>
	            </tr>
	        </table>
	     </td>
	      </tr>
      <tr>
        <td height="235" valign="top"><div class="box">			
            <table width="95%" height="200" border="0" align="center" cellpadding="0" cellspacing="0" class="box">
	  		<s:iterator value="messageList">
              <tr valign="top">
                <td width="344" class="ts" align="left" valign="top" height="24" style="line-height:24px;"><span style="color:#585858;">·</span> <a href="../messageManage/message_detail.action?id=<s:property value='id'/>" title="<s:property value='title' />" class="ck"><s:property value="title" /></a></td>
                <td width="119" align="right">(<s:date name="add_time" format="yyyy-MM-dd"/>)</td>
              </tr>
			</s:iterator>			
            </table>
            <table width="95%" height="30" border="0" align="center" cellpadding="0" cellspacing="0">  
            		<tr><td colspan="2" align="right" height="" style=""><a href="../messageManage/message_getMessageList.action?messageType=1">更多&gt;&gt;</a></td></tr>          	
            </table>	
        </div></td>
      </tr>  
    </table></td>
    <td width="50%" valign="top">
	       <table width="490" border="0" cellpadding="0" cellspacing="0" class="line1" height="270">
	         <tr height="33">
	           <td width="490" height="33"><table width="100%" height="33" border="0" cellpadding="0" cellspacing="0" background="../images/index_22.jpg">
	            <tr>
	              <td width="30" height="33"><img src="../images/index_20.jpg" width="28" height="33" /></td>
	              <td width="460" class="titel02">实绩评价</td>
	            </tr>
	        </table>
	     </td>
	      </tr>
	      
      <tr>
        <td height="235" valign="top"><div class="box">			
            <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0" class="box">	  		
              <tr valign="top">
                <td width="334" class="ts" align="left" valign="top" height="200" style="line-height:24px;">
                	<div>
                		<ul>
                			<s:iterator value="appraiseList">
                				<li style="border-bottom: 1 dashed #cccccc;height: 40px;font-size: 14px;width:463px;line-height: 40px;">
                					<table width="100%" height="40" cellpadding="0" cellspacing="0" border="0">
                						<tr>
                							<td width="385">
                								<a class="ping_jia" href="../messageManage/message_detail.action?id=<s:property value='messageReleasesId'/>&messageType=0" title="<s:property value='content'/>" style="color: #0f8bcf;"><s:property value="content"/></a>
                							</td>
                							<td>
                								<s:date format="yyyy/MM/dd" name="appraise_time"/>
                							</td>
                						</tr>
                					</table>            					
                				</li>
                			</s:iterator>
                		</ul>
                	</div>
                </td>              
              </tr>
              <tr>
              	<td align="right">
              		<div style="font-size: 13px">
              			<a href="../messageManage/message_AppraiseList.action">更多>></a>	
              		</div>
              	</td>
              </tr>
            </table>	
        </div></td>
      </tr>
	 
    </table></td>
	</tr>
</table>  

<!-- 宣传图片 -->
<table width="1003" bgcolor="#FFFFFF" height="5"><tr><td></td></tr></table>
<table width="1003" align="center" cellpadding="0" bgcolor="#ffffff" cellspacing="0" class="line1">
	<tr>
		<td>
		<table width="100%" border="0" cellpadding="0" cellspacing="0" background="../images/index_22.jpg">
            <tr>
              <td width="3%" height="33"><img src="../images/index_20.jpg" width="28" height="33" /></td>
              <td width="95%" class="titel02">图片展示</td>
              <td width="2%" style="color: #235C9D;font-weight: bold;">>></td>
            </tr>
        </table>
		</td>
	</tr>
	<tr>
		<td>
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="">
				<tr>
					<td>				
						<div id="s1" class="scrolllist">	
							<a class="abtn aleft" href="#left" title="左移"></a>					
							<div class="imglist_w">
								<ul class="imglist">
									<li style="padding-left: 20px;">
										<img src="../images/publicity/zstp1.jpg" width="163" height="130"/>
									</li>
									<li>
										<img src="../images/publicity/zstp2.jpg" width="163" height="130"/>
									</li>
									<li>
										<img src="../images/publicity/zstp5.jpg" width="163" height="130"/>
									</li>
									<li>
										<img src="../images/publicity/zstp4.jpg" width="163" height="130"/>
									</li>
									<li>
										<img src="../images/publicity/zstp7.jpg" width="163" height="130"/>
									</li>
									<li style="padding-left: 20px;">
										<img src="../images/publicity/zstp2.jpg" width="163" height="130"/>
									</li>
									<li>
										<img src="../images/publicity/zstp1.jpg" width="163" height="130"/>
									</li>
									<li>
										<img src="../images/publicity/zstp2.jpg" width="163" height="130"/>
									</li>
									<li>
										<img src="../images/publicity/zstp6.jpg" width="163" height="130"/>
									</li>
									<li>
										<img src="../images/publicity/zstp3.jpg" width="163" height="130"/>
									</li>									
								</ul>
							</div>
							<a class="abtn aright" href="#right" title="右移"></a>									
						</div>																																																																																													
					</td>				
				</tr>
			</table>		
		</td>
	</tr>
</table>
<SCRIPT type="text/javascript" src="../js/slider.js"></SCRIPT>
<SCRIPT type="text/javascript">
	$(function(){
		$("#s1").xslider({
			unitdisplayed:5,
			movelength:5,
			unitlen:187,
			autoscroll:6000
		});	
	});						
</SCRIPT>		
<!-- 底部内容 -->
<table width="1003" bgcolor="#FFFFFF" height="5"><tr><td></td></tr></table>
   <table align="center" width="1003" cellpadding="0" cellspacing="0" bgcolor="#ffffff">
   		<tr>
   		<td width="10">
   		</td>
   			<td>  				
   		<div class="column-box">
   			<div class="column-top">
   					<span>
   						<a href="#" style="color: #235C9D;font-weight: bold;"><s:property value="Counter_type"/></a>					
   					</span>
   					<a href="../messageManage/message_getMessageList.action?messageType=5" style="float: right;color: #235C9D;font-size: 12px;padding-right: 4px;">>></a>   				
   			</div>
   			<ul>
   			<s:iterator value="CounterList">
   				<li><span style="color:#585858;">·</span><a href="../messageManage/message_detail.action?id=<s:property value='id'/>"><s:property value="title"/></a></li>
   			</s:iterator>
   			</ul>
   		</div>
   			</td>
   			<td width="10">
   			</td>
   			<td>
   		<div class="column-box">
   			<div class="column-top">
   					<span>
   						<a href="#" style="color: #235C9D;font-weight: bold;"><s:property value="Probe_type"/></a>					
   					</span>
   					<a href="../messageManage/message_getMessageList.action?messageType=6" style="float: right;color: #235C9D;font-size: 12px;padding-right: 4px;">>></a>   				
   			</div>
   			<ul>
   				<s:iterator value="ProbeList">
   					<li><span style="color:#585858;">·</span><a href="../messageManage/message_detail.action?id=<s:property value='id'/>"><s:property value="title"/></a></li>
   				</s:iterator>
   			</ul>
   		</div>
   			</td>
   			<td width="10">
   			</td>		
   			<td>
   		<div class="column-box">
   			<div class="column-top">
   					<span>
   						<a href="#" style="color: #235C9D;font-weight: bold;"><s:property value="getReport_type"/></a>					
   					</span>
   					<a href="../messageManage/message_getMessageList.action?messageType=7" style="float: right;color: #235C9D;font-size: 12px;padding-right: 4px;">>></a>   				
   			</div>
   			<ul>
				<s:iterator value="InterflowList">
   					<li><span style="color:#585858;">·</span><a href="../messageManage/message_detail.action?id=<s:property value='id'/>"><s:property value="title"/></a></li>
   				</s:iterator>
   			</ul>
   		</div>
   			</td>
   		</tr>
   </table>	  
   <table width="1003" bgcolor="#FFFFFF" height="10"><tr><td></td></tr></table>
    <table align="center" width="1003" cellpadding="0" cellspacing="0" bgcolor="#ffffff">
   		<tr>
   		<td width="10">	
   		</td>
   			<td>	
   		<div class="column-box">
   			<div class="column-top">
   					<span>
   						<a href="#" style="color: #235C9D;font-weight: bold;"><s:property value="Interflow_type"/></a>					
   					</span>
   					<a href="../messageManage/message_getMessageList.action?messageType=8" style="float: right;color: #235C9D;font-size: 12px;padding-right:4px;">>></a>   				
   			</div>
   			<ul>
   				<s:iterator value="getReportList">
   					<li><span style="color:#585858;">·</span><a href="../messageManage/message_detail.action?id=<s:property value='id'/>"><s:property value="title"/></a></li>
   				</s:iterator>
   			</ul>
   		</div>
   			</td>
   			<td width="10">
   			</td>
   			<td>
   		<div class="column-box">
   			<div class="column-top">
   					<span>
   						<a href="#" style="color: #235C9D;font-weight: bold;"><s:property value="Story_type"/></a>					
   					</span>
   					<a href="../messageManage/message_getMessageList.action?messageType=9" style="float: right;color: #235C9D;font-size: 12px;padding-right:4px;">>></a>   				
   			</div>
   			<ul>
   				<s:iterator value="StoryList">
   					<li><span style="color:#585858;">·</span><a href="../messageManage/message_detail.action?id=<s:property value='id'/>"><s:property value="title"/></a></li>
   				</s:iterator>
   			</ul>
   		</div>
   			</td>
   			<td width="10"><br><br></td>		
   			<td>
   		<div class="column-box">
   			<div class="column-top">
   					<span>
   						<a href="#" style="color: #235C9D;font-weight: bold;"><s:property value="Speech_type"/></a>					
   					</span>
   					<a href="../messageManage/message_getMessageList.action?messageType=10" style="float: right;color: #235C9D;font-size: 12px;padding-right: 4px;">>></a>   				
   			</div>
   			<ul>
   				<s:iterator value="SpeechList">
   					<li><span style="color:#585858;">·</span><a href="../messageManage/message_detail.action?id=<s:property value='id'/>"><s:property value="title"/></a></li>
   				</s:iterator>
   			</ul>
   		</div>
   			</td>
   		</tr>
   </table>	
   <!-- 底部链接 -->
   <table width="1003" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF" style="margin-top: 5px;">
  <tr>
    <td>
	<table width="993" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td><div id="div6" style="OVERFLOW: hidden; WIDTH:992px; HEIGHT:50px; display:block">
          <table width="100%" border="0" cellpadding="0" cellspacing="0" bgcolor="#F0F0F0" class="line1">
            <tr>
              <td id="div7"><table>
                  <tr>
                    <td height="45" align="center"><a href="#">
                      <img src="../images/publicity/lian_j1.jpg" width='188' height='45'/>
                    </a>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                    <td height="45" align="center"><a href="#">
                      <img src="../images/publicity/lian_j2.jpg" width='188' height='45'/>
                    </a>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                    <td height="45" align="center"><a href="#">
                      <img src="../images/publicity/lian_j3.jpg" width='188' height='45'/>
                    </a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                    <td height="45" align="center"><a href="#">
                      <img src="../images/publicity/lian_j4.jpg" width='188' height='45'/>
                    </a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                    <td height="45" align="center"><a href="#">
                      <img src="../images/publicity/lian_j5.jpg" width='188' height='45'/>
                    </a>&nbsp;</td>                
                  </tr>
              </table></td>
            </tr>
          </table>
        </div>
  		</td>
      </tr>
    </table></td>
  </tr>
</table>
  </body>
  <jsp:include page="footer.jsp"></jsp:include>
</html>
