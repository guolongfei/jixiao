package com.hoyotech.prison.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.hoyotech.prison.bean.BasicSetUp;
import com.hoyotech.prison.bean.JX_Appraise;
import com.hoyotech.prison.bean.JX_Department;
import com.hoyotech.prison.bean.JX_User;
import com.hoyotech.prison.bean.MessageReleases;
import com.hoyotech.prison.bean.MessageType;
import com.hoyotech.prison.log.LogFactory;
import com.hoyotech.prison.service.impl.HomePageService;
import com.hoyotech.prison.service.impl.MessageReleasesService;


public class MobileAction{
	
	private HomePageService pageService;
	private MessageReleasesService messageReleasesService;
	private List<BasicSetUp> basicList; //滚动链接
	private List<MessageReleases> messageList;//通知公告
	private List<MessageReleases> imagesList;//图片新闻
	private List<MessageReleases> DynamicList;//市直动态
	private List<MessageReleases> BlockList;//区街动态
	private List<MessageReleases> PolicyList;//政策法规
	private List<MessageReleases> CounterList;//实绩展示
	private List<MessageReleases> SpeechList;//表格下载
	private List<MessageReleases> StoryList;//他山之石
	private List<MessageReleases> ProbeList;//领导言论
	private List<MessageReleases> InterflowList;//经验交流
	private List<MessageReleases> getReportList;//理论探索
	private List<MessageReleases> getSynthesize;//综合动态
	private List<MessageReleases> checkList;//单项考核
	private List<MessageReleases> checkNoticeList;//考核通报
	private List<MessageReleases> tongbaoList;//实绩通报
	private List<JX_Appraise> appraiseList;//实绩评价
	private List<JX_Department> getSortList;//部门类别
	private List<Object[]> getDepartmentList;//部门信息
	private String message_type;
	private String Dynamic_type;
	private String Policy_type;
	private String Block_type;
	private String Counter_type;
	private String Speech_type;
	private String Story_type;
	private String Probe_type;
	private String Interflow_type;
	private String getReport_type;
	private String Synthe_type;
	private String imageUrl;//图片地址
	private String user_Name;//用户名
	private String password;//密码
	private Integer is_save;//记住密码
	private JX_User user;
	private String userId;//用户ID
	private int errorType=2;
	private LogFactory log;
	private Integer onLine_num;//当前在线人数
	private int error=0;
	private String NewPassword;//新密码
	private List<MessageType> navTopList;//导航栏
	
	
	//登录
	public void user_login(){		
		
		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			HttpServletRequest request=ServletActionContext.getRequest();
			String callback = request.getParameter("callback");

			 response.setContentType("text/json"); 
			 response.setCharacterEncoding("UTF-8"); 
			 
			PrintWriter out=response.getWriter();
			JSONObject json = new JSONObject();
			System.out.println(user_Name);
			user = pageService.getLogin(user_Name);
			if(user==null){
//				out.println("{\"errorMsg\":\"user is null or not exist!\"}"); // 用户名不存在
				json.put("errorMsg","用户名为空或不存在");
			}
			else{
				user = pageService.getPassword(user.getId(),password);
				if(user == null){
//					out.println("{\"errorMsg\":\"wrong username or password!\"}"); 
					json.put("errorMsg","用户名或密码错误");
				}
				else{
//					System.out.println("登录成功！");
					pageService.updateState(user.getId());//登录成功后修改在线状态，用于统计在线人数
					
					json.put("deptName", user.getJx_people().getJx_department().getName());//部门名称
					json.put("userId",user.getJx_people().getId());
					json.put("realName",user.getJx_people().getName());//用户真实姓名	
					json.put("errorMsg","success");
//					out.println(json);
				}
			}
			out.print(callback + "(" + json + ")");
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();	
		}	
	}
	//用户退出登录
	public void loginOut(){
		HttpServletRequest request=ServletActionContext.getRequest();
		userId = request.getSession().getAttribute("userId").toString();
		pageService.loginOut(userId);
	}

	public List<MessageReleases> getDynamicList() {
		return DynamicList;
	}

	public void setDynamicList(List<MessageReleases> dynamicList) {
		DynamicList = dynamicList;
	}

	public List<MessageReleases> getPolicyList() {
		return PolicyList;
	}

	public void setPolicyList(List<MessageReleases> policyList) {
		PolicyList = policyList;
	}

	public List<MessageReleases> getCounterList() {
		return CounterList;
	}

	public void setCounterList(List<MessageReleases> counterList) {
		CounterList = counterList;
	}

	public List<MessageReleases> getSpeechList() {
		return SpeechList;
	}

	public void setSpeechList(List<MessageReleases> speechList) {
		SpeechList = speechList;
	}

	public List<MessageReleases> getStoryList() {
		return StoryList;
	}

	public void setStoryList(List<MessageReleases> storyList) {
		StoryList = storyList;
	}

	public List<MessageReleases> getProbeList() {
		return ProbeList;
	}

	public void setProbeList(List<MessageReleases> probeList) {
		ProbeList = probeList;
	}

	public List<MessageReleases> getInterflowList() {
		return InterflowList;
	}

	public void setInterflowList(List<MessageReleases> interflowList) {
		InterflowList = interflowList;
	}

	public List<MessageReleases> getGetReportList() {
		return getReportList;
	}

	public void setGetReportList(List<MessageReleases> getReportList) {
		this.getReportList = getReportList;
	}

	public String getMessage_type() {
		return message_type;
	}

	public void setMessage_type(String messageType) {
		message_type = messageType;
	}
	
	public String getDynamic_type() {
		return Dynamic_type;
	}

	public void setDynamic_type(String dynamicType) {
		Dynamic_type = dynamicType;
	}

	public String getPolicy_type() {
		return Policy_type;
	}

	public void setPolicy_type(String policyType) {
		Policy_type = policyType;
	}

	public String getCounter_type() {
		return Counter_type;
	}

	public void setCounter_type(String counterType) {
		Counter_type = counterType;
	}

	public String getSpeech_type() {
		return Speech_type;
	}

	public void setSpeech_type(String speechType) {
		Speech_type = speechType;
	}

	public String getStory_type() {
		return Story_type;
	}

	public void setStory_type(String storyType) {
		Story_type = storyType;
	}

	public String getProbe_type() {
		return Probe_type;
	}

	public void setProbe_type(String probeType) {
		Probe_type = probeType;
	}

	public String getInterflow_type() {
		return Interflow_type;
	}

	public void setInterflow_type(String interflowType) {
		Interflow_type = interflowType;
	}

	public String getGetReport_type() {
		return getReport_type;
	}

	public void setGetReport_type(String getReportType) {
		getReport_type = getReportType;
	}

	public HomePageService getPageService() {
		return pageService;
	}

	public void setPageService(HomePageService pageService) {
		this.pageService = pageService;
	}

	public List<MessageReleases> getMessageList() {
		return messageList;
	}

	public void setMessageList(List<MessageReleases> messageList) {
		this.messageList = messageList;
	}


	public void setImagesList(List<MessageReleases> imagesList) {
		this.imagesList = imagesList;
	}


	public List<MessageReleases> getImagesList() {
		return imagesList;
	}


	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}


	public String getImageUrl() {
		return imageUrl;
	}

	public void setUser_Name(String user_Name) {
		this.user_Name = user_Name;
	}

	public String getUser_Name() {
		return user_Name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public Integer getIs_save() {
		return is_save;
	}

	public void setIs_save(Integer isSave) {
		is_save = isSave;
	}

	

	public JX_User getUser() {
		return user;
	}

	public void setUser(JX_User user) {
		this.user = user;
	}

	public void setErrorType(int errorType) {
		this.errorType = errorType;
	}

	public int getErrorType() {
		return errorType;
	}
	public List<MessageReleases> getBlockList() {
		return BlockList;
	}

	public void setBlockList(List<MessageReleases> blockList) {
		BlockList = blockList;
	}

	public String getBlock_type() {
		return Block_type;
	}

	public void setBlock_type(String blockType) {
		Block_type = blockType;
	}

	public void setOnLine_num(Integer onLine_num) {
		this.onLine_num = onLine_num;
	}

	public Integer getOnLine_num() {
		return onLine_num;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserId() {
		return userId;
	}

	public void setError(int error) {
		this.error = error;
	}

	public int getError() {
		return error;
	}

	public void setNewPassword(String newPassword) {
		NewPassword = newPassword;
	}

	public String getNewPassword() {
		return NewPassword;
	}

	public LogFactory getLog() {
		return log;
	}

	public void setLog(LogFactory log) {
		this.log = log;
	}

	public void setNavTopList(List<MessageType> navTopList) {
		this.navTopList = navTopList;
	}

	public List<MessageType> getNavTopList() {
		return navTopList;
	}
	public void setBasicList(List<BasicSetUp> basicList) {
		this.basicList = basicList;
	}
	public List<BasicSetUp> getBasicList() {
		return basicList;
	}
	public void setMessageReleasesService(MessageReleasesService messageReleasesService) {
		this.messageReleasesService = messageReleasesService;
	}
	public MessageReleasesService getMessageReleasesService() {
		return messageReleasesService;
	}
	public List<MessageReleases> getGetSynthesize() {
		return getSynthesize;
	}
	public void setGetSynthesize(List<MessageReleases> getSynthesize) {
		this.getSynthesize = getSynthesize;
	}
	public String getSynthe_type() {
		return Synthe_type;
	}
	public void setSynthe_type(String syntheType) {
		Synthe_type = syntheType;
	}
	public void setGetSortList(List<JX_Department> getSortList) {
		this.getSortList = getSortList;
	}
	public List<JX_Department> getGetSortList() {
		return getSortList;
	}
	public void setGetDepartmentList(List<Object[]> getDepartmentList) {
		this.getDepartmentList = getDepartmentList;
	}
	public List<Object[]> getGetDepartmentList() {
		return getDepartmentList;
	}
	public List<MessageReleases> getCheckList() {
		return checkList;
	}
	public void setCheckList(List<MessageReleases> checkList) {
		this.checkList = checkList;
	}
	public List<MessageReleases> getCheckNoticeList() {
		return checkNoticeList;
	}
	public void setCheckNoticeList(List<MessageReleases> checkNoticeList) {
		this.checkNoticeList = checkNoticeList;
	}
	public void setTongbaoList(List<MessageReleases> tongbaoList) {
		this.tongbaoList = tongbaoList;
	}
	public List<MessageReleases> getTongbaoList() {
		return tongbaoList;
	}
	public void setAppraiseList(List<JX_Appraise> appraiseList) {
		this.appraiseList = appraiseList;
	}
	public List<JX_Appraise> getAppraiseList() {
		return appraiseList;
	}

}
