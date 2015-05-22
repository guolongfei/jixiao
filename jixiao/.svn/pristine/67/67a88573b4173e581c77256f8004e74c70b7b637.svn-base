<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	String power=(String)session.getAttribute("key");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">   
    <title>IP数字对讲系统管理平台——登录</title>
    <script type="text/javascript" src="<%=basePath%>js/jQuery.js"></script>
  		<style>
body {
	margin: 0;
	padding: 0;
}

.left {
	width: 212px;
	height: 490px;
	background: url("<%=basePath%>/images/jkn_7.png") repeat-y;
}
.left_a{
	letter-spacing: 1px;
	background: url("<%=basePath%>/images/jkn_5.png") no-repeat;
	height: 30px;
	line-height: 30px;
	overflow: hidden;
	color: #fff;
	font-size:14px;
	font-weight:bold;
	padding-left: 28px;
}
body, div, dl, dt, dd, ul, ol, li, h1, h2, h3, h4, h5, h6, pre, code, form, fieldset, legend, input, textarea, p, blockquote, th, td { margin: 0; padding: 0; font-family:"宋体"}
table { border-collapse: collapse; border-spacing: 0; }
fieldset, img { border: 0; }
address, caption, cite, code, dfn, em, strong, th, var { font-style: normal; font-weight: normal; }
ol, ul { list-style: none; }
caption, th { text-align: left; }
.hidden { display: none; }
a{ text-decoration:none;}
</style>
		<style>
.subNavBox {
	margin-top:20px;
	width: 177px;
	text-align:center;
	font-size:15px;
	height:29px;
	color: #fff; 
}

.subNav {
	cursor: pointer;
	font-weight: bold;
	font-size: 15px;
	color: #fff;
	line-height: 29px;
	background:url("<%=basePath%>/images/jkn_8.png");
}

.subNav:hover {
	color: #ffff99;
	background:url("<%=basePath%>/images/jkn_10.png");
}

.currentDd{
	color: #ffff99;
	background:url("<%=basePath%>/images/jkn_10.png");
}

.navContent {
	width:177px;	
	display: none;
	list-style: none;
	
}
.navContent li{
	border-bottom:1px dashed #e0e0e0;
}
.navli{
	display: block;
	width: 177px;
	heighr: 29px;
	text-align: center;
	font-size: 13px;
	line-height: 29px;
	color: #235C9D;
	font-weight: bold;
}
.navli:hover {
	color: #fff;
	background:#004A9F;
	cursor: pointer;
}
.currentDt{
	background:#004A9F
	;
	cursor: pointer;
	color: #fff;
}
</style>
    <script type="text/javascript">
    	$(function() {
		$(".subNav").click(
				function() {
					$(this).toggleClass("currentDd").siblings(".subNav")
							.removeClass("currentDd")
											
					// 修改数字控制速度， slideUp(500)控制卷起速度
					$(this).next(".navContent").slideToggle(1000).siblings(
							".navContent").slideUp(1000);
				});
		$(".subNav").hover(function(){
			$(this).addClass("currentDd");
		
		}
		,function(){
			$(this).removeClass("currentDd");
		}
		);		
		
		$(".navli").hover(function(){
			$(this).addClass("currentDt");
		}
		,function(){
			$(this).removeClass("currentDt");	
		}
		);
	});
   
	function forword(id){
		switch (id){
		case 1:
			document.getElementById("rightframe").src="<%=basePath%>performance/performance_toPFEditByday.action";
			break;	
		case 2:
			document.getElementById("rightframe").src="<%=basePath%>performance/performance_getPerformanceList.action";		
			break;
		case 3:
			document.getElementById("rightframe").src="<%=basePath%>performance/performance_toPurpose.action";			
			break;
		case 4:
			document.getElementById("rightframe").src="<%=basePath%>performance/performance_getPeopleList.action";
			break;
		case 5:
			document.getElementById("rightframe").src="<%=basePath%>performance/performance_toPFOfyear.action";
			break;
		case 6:
		    document.getElementById("rightframe").src="<%=basePath%>achieveManage/achieveManage_showMyAchieve.action";	
			break;
		case 7:
			document.getElementById("rightframe").src="<%=basePath%>performance/performance_toPFOfseason.action";	
			break;
		case 8:
			document.getElementById("rightframe").src="<%=basePath%>messageManage/record_queryDep.action";
			break;
		case 9:
		    document.getElementById("rightframe").src="<%=basePath%>performance/performance_getPeopleList1.action";	
			break;
		case 10:
			document.getElementById("rightframe").src="<%=basePath%>messageManage/employee_getEmpRule.action";
			break;
		case 11:
			document.getElementById("rightframe").src="<%=basePath%>messageManage/record_gradeList.action";
			break;
		case 12:
		    document.getElementById("rightframe").src="<%=basePath%>TextManage/TextManage_showMyInexepensiveText.action";
			break;
		case 13:
		    document.getElementById("rightframe").src="<%=basePath%>TextManage/TextManage_showMyLearningText.action";
			break;
		case 14:
			document.getElementById("rightframe").src="<%=basePath%>messageManage/record_recordList.action";
			break;
		case 15:
			document.getElementById("rightframe").src="<%=basePath%>messageManage/message_getZhengceList.action";
			break;
		case 16:
			document.getElementById("rightframe").src="<%=basePath%>messageManage/record_queryDep2.action";
			break;
		case 17:
			document.getElementById("rightframe").src="<%=basePath%>messageManage/homePage_frowdPsd.action";
			break;
		case 18:
			document.getElementById("rightframe").src="<%=basePath%>messageManage/message_bs_getMessageList.action";
			break;
		case 19:			
			document.getElementById("rightframe").src="<%=basePath%>jx_department/jx_department_bs_gotoDepartmentList.action";
			break;
		case 20:			
			document.getElementById("rightframe").src="<%=basePath%>jx_user/jx_user_bs_gotoUserList.action?userId=<%=request.getSession().getAttribute("userId")%>";
			break;
		case 21:			
			document.getElementById("rightframe").src="<%=basePath%>jx_role/jx_role_bs_getRoleList.action";
		 	break;
		case 22:
			document.getElementById("rightframe").src="<%=basePath%>messageManage/record_queryDep.action";
			break;
		case 23:
			document.getElementById("rightframe").src="<%=basePath%>messageManage/record_voteGather.action";
			break;
		case 24:
			document.getElementById("rightframe").src="<%=basePath%>quarterManage/quarter_getQuarterTime.action";
			break;
		case 25:
			document.getElementById("rightframe").src="<%=basePath%>backstage/quarter/querySub.jsp";
			break;
		case 26:
			document.getElementById("rightframe").src="<%=basePath%>backstage/quarter/annualSub.jsp";
			break;
		case 27:
			document.getElementById("rightframe").src="<%=basePath%>roomManager/roomManager_getRoomList.action";
			break;
		case 28:
			document.getElementById("rightframe").src="<%=basePath%>page/specialscore/addscore.jsp";
			break;
		case 29:
			document.getElementById("rightframe").src="<%=basePath%>SpecialScore/SpecialScore_showScore.action";
			break;
		default:
			break;
		}
	}
    </script>
  </head>
  
  <body>
     <table cellpadding="0" cellspacing="0" width="100%" height="100%">
            <tr>
                <td colspan="2"><iframe frameborder="no" height="111" width="100%" style="margin:0;padding:0;" id="topframe" name="topframe" src="<%=basePath%>/page/manageHome/topNews.jsp" scrolling="no" noResize></iframe></td>
            </tr>
            <tr>
            	<td colspan="2" height="10" style="background:#2D92EA;"></td>
            </tr>
            <tr>
            	<td width="17%" valign="top" style="background:url('<%=basePath%>/images/jkn_2.jpg') repeat-x;">
            		<div class="left_a">
			菜单栏目
		</div>
		<div class="left">
			<table width="200" align="center" cellpadding="0" cellspacing="0"
				style="">
				<tr>
					<td align="center">
							<div class="subNavBox">
							<!--  <%if(power.indexOf("KHXZ") != -1){ %>
							<div class="subNav" onclick="forword(10)">
								考核办法
							</div>
							<%} %>
							<%if(power.indexOf("GZMB") != -1){ %>
							<div class="subNav" onclick="forword(3)">
								工作目标
							</div>
							<%} %>
							<%if(power.indexOf("SJJZ") != -1){ %>
							<div class="subNav" onclick="forword(1)">
								实绩记载
							</div>
							<%} %>
							<%if(power.indexOf("SJZS") != -1){ %>
							<div class="subNav" onclick="forword(2)">
								实绩展示
							</div>
							<%} %>
							<%if(power.indexOf("SJKP") != -1){ %>
							<div class="subNav">
								实绩考评
							</div>
							<%} %>							
							<ul class="navContent">								
								<%if(power.indexOf("SJKP01") != -1){ %>
								<li>
									<span class="navli" onclick="forword(28)" >专班评分</span>
								</li>
								<%} %>
								<%if(power.indexOf("SJKP02") != -1){ %>
								<li>
									<span class="navli" onclick="forword(4)">实绩点评</span>
								</li>
								<%} %>
								<%if(power.indexOf("SJKP03") != -1){ %>
								<li>
									<span class="navli" onclick="forword(29)">评价得分</span>
								</li>
								<%} %>								
							</ul>-->
							<%if(power.indexOf("SJTB") != -1){ %>
							<div class="subNav" onclick="forword(27)">
								工作组管理
							</div>
							<%} %>
							<%if(power.indexOf("XTSZ") != -1){ %>
							<div class="subNav">
								系统设置
							</div>
							<%} %>
							<ul class="navContent">
								<%if(power.indexOf("XTSZ01") != -1){ %>
								<li onclick="forword(18)">
									<span class="navli">信息发布</span>
								</li>
								<%} %>
								<%if(power.indexOf("XTSZ02") != -1){ %>
								<li onclick="forword(19)">
									<span class="navli">部门信息</span>
								</li>
								<%} %>
								<%if(power.indexOf("XTSZ03") != -1){ %>
								<li onclick="forword(20)">
									<span class="navli">用户信息</span>
								</li>
								<%} %>
								<%if(power.indexOf("XTSZ04") != -1){ %>
								<li onclick="forword(21)">
									<span class="navli">角色信息</span>
								</li>
								<%} %>
								<!--  <%if(power.indexOf("XTSZ05") != -1){ %>
								<li onclick="forword(27)">
									<span class="navli">工作组管理</span>
								</li>
								<%} %>-->
							</ul>
							<%if(power.indexOf("GRSZ") != -1){ %>
							<div class="subNav" onclick="forword(17)">
								个人设置
							</div>
							<%} %>
							<!--  
							<ul class="navContent">
					<li onclick="forword(24)">
						<span class="navli">季度考核时间设置</span>
					</li>
					<li onclick="forword()">
						<span class="navli">考学数据管理</span>
					</li>
					<li onclick="forword()">
						<span class="navli">考勤数据管理</span>
					</li>
					<li onclick="forword()">
						<span class="navli">社会考评设置</span>
					</li>
				</ul>
				-->
			<!-- 
			<%if(power.indexOf("TXSJ01") !=-1){%>
			<div class="subNav" onclick="forword(1)">
				填写实绩
			</div>
			<%} %>
			<%if(power.indexOf("SJGL") !=-1){%>
			<div class="subNav">
				实绩管理
			</div>
			
			<%} %>
			<ul class="navContent">
				<%if(power.indexOf("SJGL01") !=-1){%>
				<li onclick="forword(2)">
					<span class="navli">日记管理</span>				
				</li>
				<%} %>
				<%if(power.indexOf("SJGL02") !=-1){%>
				<li onclick="forword(3)">
					<span class="navli">月小结管理</span>
				</li>
				<%} %>
				<%if(power.indexOf("SJGL03") !=-1){%>
				<li onclick="forword(4)">
					<span class="navli">部门实绩</span>
				</li>
				<%} %>
				<%if(power.indexOf("SJGL04") !=-1){%>

				<li onclick="forword(7)">
					<span class="navli">季度总结查询</span>
				</li>
				<%} %>
				<%if(power.indexOf("SJGL05") !=-1){%>
				<li onclick="forword(5)">
					<span class="navli">年考核管理</span>		
				</li>
				<%} %>
				<%if(power.indexOf("SJGL06") !=-1){%>
				<li onclick="forword(6)">
					<span class="navli">突出成果管理</span>
				</li>
				<%} %>			
			</ul>
			<%if(power.indexOf("KHCX") !=-1){%>
			<div class="subNav">
				考核查询
			</div>
			<%} %>	
			<ul class="navContent">
				<%if(power.indexOf("KHCX01") !=-1){%>
				<li onclick="forword(8)">
					<span class="navli">社会考评查询</span>
				</li>
				<%} %>	
				<%if(power.indexOf("KHCX02") !=-1){%>
				<li onclick="forword(9)">
					<span class="navli">季度考核查询</span>
				</li>
				<%} %>
				<%if(power.indexOf("KHCX03") !=-1){%>	
				<li onclick="forword(10)">
					<span class="navli">领导考评查询</span>
				</li>
				<%} %>
				<%if(power.indexOf("KHCX04") !=-1){%>
				<li onclick="forword(11)">
					<span class="navli">年度考评查询</span>
				</li>
				<%} %>
			</ul>
			<div class="subNav">
				其他查询
			</div>
				<ul class="navContent">
				<%if(power.indexOf("KLCX01") !=-1){%>
				<li onclick="forword(12)">
					<span class="navli">考廉查询</span>
				</li>
				<%} %>	
				<%if(power.indexOf("KXCX01") !=-1){%>
				<li onclick="forword(13)">
					<span class="navli">考学查询</span>
				</li>
				<%} %>
				<%if(power.indexOf("KQGL01") !=-1){%>	
				<li onclick="forword(14)">
					<span class="navli">考勤查询</span>
				</li>
				<%} %>
				<%if(power.indexOf("ZCCX01") !=-1){%>
				<li onclick="forword(15)">
					<span class="navli">政策查询</span>
				</li>
				<%} %>
			</ul>
			<%if(power.indexOf("SHGL01") !=-1){%>
			<div class="subNav" onclick="forword(16)">
				审核管理
			</div>
			<%} %>
			<div class="subNav">
				单位实绩
			</div>
			<ul class="navContent">
				<li onclick="forword(22)">
					<span class="navli">内部测评</span>
				</li>
				<li onclick="forword(23)">
					<span class="navli">测评汇总</span>
				</li>
			</ul>	
			<%if(power.indexOf("GRSZ01") !=-1){%>
			<div class="subNav" onclick="forword(17)">
				个人设置
			</div>
			<%} %>
			<%if(power.indexOf("HTGL") !=-1){%>	
			<div class="subNav">
				系统管理
			</div>
			<%} %>
			<ul class="navContent">
				<%if(power.indexOf("HTGL01") !=-1){%>	
				<li onclick="forword(18)">
					<span class="navli">信息发布</span>
				</li>
				<%} %>
				<%if(power.indexOf("HTGL02") !=-1){%>
				<li onclick="forword(19)">
					<span class="navli">部门信息</span>
				</li>
				<%} %>
				<%if(power.indexOf("HTGL03") !=-1){%>
				<li onclick="forword(20)">
					<span class="navli">用户信息</span>
				</li>
				<%} %>
				<%if(power.indexOf("HTGL04") !=-1){%>
				<li onclick="forword(21)">
					<span class="navli">角色信息</span>
				</li>
				<%} %>
			</ul>
				<div class="subNav">
					系统设置
				</div>
				<ul class="navContent">
					<li onclick="forword(25)">
						<span class="navli">季度考核未提交查询</span>
					</li>
					<li onclick="forword(26)">
						<span class="navli">年度考核未提交查询</span>
					</li>
					<li onclick="forword()">
						<span class="navli">年考核成绩汇总发布</span>
					</li>
					<li onclick="forword()">
						<span class="navli">单位考核成绩汇总发布</span>
					</li>
					<li onclick="forword()">
						<span class="navli">年终考核汇总发布</span>
					</li>
					<li onclick="forword()">
						<span class="navli">领导考核成绩发布</span>
					</li>
				</ul>
				<div class="subNav">
					其他设置
				</div>
				<ul class="navContent">
					<li onclick="forword(24)">
						<span class="navli">季度考核时间设置</span>
					</li>
					<li onclick="forword()">
						<span class="navli">考学数据管理</span>
					</li>
					<li onclick="forword()">
						<span class="navli">考勤数据管理</span>
					</li>
					<li onclick="forword()">
						<span class="navli">社会考评设置</span>
					</li>
				</ul>
			 -->
		</div>
					</td>
				</tr>
				<tr>
				</tr>
			</table>
		</div>
            	
            	</td>
            	<td width="83%" valign="top" ><iframe frameborder="0" width="100%" height="700" style="margin:0;padding:0;overflow-y:hidden;min-height: 400px;" id="rightframe" name="rightframe" src="<%=basePath%>roomManager/roomManager_getRoomList.action" scrolling="yes" noresize></iframe></td>
            </tr>
      </table>
  </body>
</html>
