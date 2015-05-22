package com.hoyotech.prison.action;

import java.io.PrintWriter;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.hoyotech.prison.bean.BasicSetUp;
import com.hoyotech.prison.bean.JX_Appraise;
import com.hoyotech.prison.bean.JX_Department;
import com.hoyotech.prison.bean.JX_RolePermission;
import com.hoyotech.prison.bean.JX_User;
import com.hoyotech.prison.bean.JX_UserRole;
import com.hoyotech.prison.bean.MessageReleases;
import com.hoyotech.prison.bean.MessageType;
import com.hoyotech.prison.bean.RolePermission;
import com.hoyotech.prison.bean.UserRole;
import com.hoyotech.prison.log.LogFactory;
import com.hoyotech.prison.service.impl.HomePageService;
import com.hoyotech.prison.service.impl.MessageReleasesService;

import cryptix.jce.provider.MD5;

public class HomePageAction{
	
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
	
	//首页导航
	public void navTopList(){
		navTopList = pageService.navTopList();
		String errorMsg = "success";
		JSONObject json = new JSONObject();
		JSONArray array = new JSONArray();
		if(navTopList.size()>0){
			for (int i = 0; i < navTopList.size(); i++) {
				JSONObject j = new JSONObject();
				j.put("id", navTopList.get(i).getType_id());
				j.put("type_name",navTopList.get(i).getType_name());		
				array.put(i, j);
			}
		}
		json.put("array", array);
		json.put("errorMsg", errorMsg);
		try {
			ServletActionContext.getResponse().setContentType("text/json; charset=UTF-8");
			PrintWriter out = ServletActionContext.getResponse().getWriter();
			out.print(json);
			out.flush();
			out.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	//滚动字幕
	public void maquee(){
		basicList = messageReleasesService.getBasicList();
		String errorMsg = "success";
		JSONObject json = new JSONObject();
		JSONArray array = new JSONArray();
		if(basicList.size()>0){
			for (int i = 0; i < basicList.size(); i++) {
				JSONObject j = new JSONObject();
				j.put("Ischain", basicList.get(i).getIschain());
				j.put("title",basicList.get(i).getSetup_title());
				j.put("chain_adress",basicList.get(i).getChain_adress());
				array.put(i, j);
			}
		}
		json.put("array", array);
		json.put("errorMsg", errorMsg);
		try {
			ServletActionContext.getResponse().setContentType("text/json; charset=UTF-8");
			PrintWriter out = ServletActionContext.getResponse().getWriter();
			out.print(json);
			out.flush();
			out.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	//首页数据
	public String getList(){	
		messageList = pageService.getList();
		imagesList = pageService.getImagesList();
		DynamicList = pageService.getDynamicList();
		BlockList = pageService.getBlockList();
		PolicyList = pageService.getPolicyList();
		CounterList = pageService.getCounterList();
		SpeechList = pageService.getSpeechList();
		StoryList = pageService.getStoryList();
		ProbeList = pageService.getProbeList();
		getSynthesize = pageService.getSyntheSizeList();
		InterflowList = pageService.getInterflowList();
		getReportList = pageService.getReportList();
		getSortList = pageService.getSortList();
		tongbaoList = pageService.getTongbaoList();
		appraiseList = pageService.getAppraiseList();
		getDepartmentList =pageService.getDepartmentList();
		if(messageList.size()!=0){
			message_type = messageList.get(0).getMessageType().getType_name().toString();
		}
		else{
			message_type="通知公告";
		}
		if(imagesList.size()!=0){
			imageUrl = imagesList.get(0).getTitle_img_url().toString();			
		}
		if(getSynthesize.size()!=0){
			Synthe_type = getSynthesize.get(0).getMessageType().getType_name().toString();
		}
		else{
			Synthe_type = "综合动态";
		}
		if(DynamicList.size()!=0){
			Dynamic_type = DynamicList.get(0).getMessageType().getType_name().toString();
		}
		else{
			Dynamic_type="市直动态";
		}
		if(BlockList.size()!=0){
			Block_type = BlockList.get(0).getMessageType().getType_name().toString();
		}
		else{
			Block_type="区街动态";
		}
		if(PolicyList.size()!=0){
			Policy_type = PolicyList.get(0).getMessageType().getType_name().toString();
		}
		else{
			Policy_type = "最新政策";
		}
		if(CounterList.size()!=0){
			Counter_type = CounterList.get(0).getMessageType().getType_name().toString();
		}
		else{
			Counter_type="实绩展示";
		}
		if(SpeechList.size()!=0){
			Speech_type = SpeechList.get(0).getMessageType().getType_name().toString();
		}
		else{
			Speech_type = "表格下载";
		}
		if(StoryList.size()!=0){
			Story_type = StoryList.get(0).getMessageType().getType_name().toString();
		}
		else{
			Story_type = "他山之石";
		}
		if(ProbeList.size()!=0){
			Probe_type = ProbeList.get(0).getMessageType().getType_name().toString();
		}
		else{
			Probe_type = "领导言论";
		}
		if(InterflowList.size()!=0){
			Interflow_type = InterflowList.get(0).getMessageType().getType_name().toString();
		}
		else{
			Interflow_type = "经验交流";
		}
		if(getReportList.size()!=0){
			getReport_type = getReportList.get(0).getMessageType().getType_name().toString();
		}
		else{
			getReport_type="理论探索";
		}
	
		return "messageList";	
	}
	
	public String Login(){		
		
		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			HttpServletRequest request=ServletActionContext.getRequest();
			user = pageService.getLogin(user_Name);
			if(user==null){
				errorType = 0;
				return "loginIn";
			}
			else{
				String pass = password;
				MD5 md5 = new MD5();
				password= md5.toMD5(password);
				user = pageService.getPassword(user.getId(),password);
				if(user == null){
					errorType = 1;	
					return "loginIn";
				}
				else{
					System.out.println("登录成功！");				
					String keyName = "";
					Set<String> keyUrl=new HashSet<String>();
					for(JX_UserRole ur : user.getRoles()){
						//if(ur.getJx_role().getMark().equals("1")){
							for(JX_RolePermission rp : ur.getJx_role().getRolePer()){
								keyName = keyName + rp.getJx_permission().getKeyName()+",";
								if(rp.getJx_permission().getUrl() != null){
									String[] urls = rp.getJx_permission().getUrl().split(",");
									for(String str : urls){
										if(!"".equals(str)){
											keyUrl.add(str);
										}
									}
								}
							}
						//}
					}				
					pageService.updateState(user.getId());//登录成功后修改在线状态
					userId = user.getId();
					request.getSession().setAttribute("error", error);//密码状态 0表示未修改 1表示已修改 2表示旧密码输入错误
					/*用户类*/
					request.getSession().setAttribute("userId", user.getId());//用户ID	  
					request.getSession().setAttribute("userName", user_Name);//用户名				
					request.getSession().setAttribute("userState", user.getState());//启用状态					
					request.getSession().setAttribute(userId, user_Name);
					request.getSession().setAttribute("onlineUserBindingListener", new OnlineUserBindingListener(userId,user_Name));
					/*部门类*/
					request.getSession().setAttribute("deptId", user.getJx_people().getJx_department().getId());//部门ID
					request.getSession().setAttribute("userid", user.getJx_people().getId());//用户ID
					request.getSession().setAttribute("deptName", user.getJx_people().getJx_department().getName());//部门名称
					request.getSession().setAttribute("deptPid", user.getJx_people().getJx_department().getPid());//上级部门ID
					request.getSession().setAttribute("deptLevel", user.getJx_people().getJx_department().getLevel());//部门等级
					/*人员类*/
					request.getSession().setAttribute("peoPost", user.getJx_people().getPosttable().getPostId());//人员职位
					request.getSession().setAttribute("name", user.getJx_people().getName());//用户真实姓名	
					request.getSession().setAttribute("peoDuty", user.getJx_people().getDuty());//人员职责	
					/*权限类*/
					request.getSession().setAttribute("key", keyName);//权限编号
					request.getSession().setAttribute("url", keyUrl);//跳转路径
										
					// 添加日志
					//ConfigHelper config = ConfigHelper.getConfig();
					//String operate = "登录成功。";
					//log.getQueryLogMessage(request, config.getLogin(), operate, config.getUser(), config.getSucceed());
					if(is_save==null){
						is_save = 0;
					}
					else{
						request.getSession().setAttribute("password", pass);
						request.getSession().setAttribute("is_save", is_save);
					}
					return "performance";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();	
			return null;
		}	
	}
	//用户退出登录
	public String loginOut(){
		HttpServletRequest request=ServletActionContext.getRequest();
		userId = request.getSession().getAttribute("userId").toString();
		pageService.loginOut(userId);
		return "loginOut";
	}
	//用户修改密码界面
	public String frowdPsd(){
		return "frowdPsd";
	}
	//用户修改密码
	public String updatePsd(){
		MD5 md5 = new MD5();
		System.out.println(password+"!!!!!!!!!!");
		password= md5.toMD5(password);
		System.out.println(password+"!!!!!!!!!!");
		JX_User user = new JX_User();
		user = pageService.getPsd(userId, password);
		if(user!=null){
			error = 1;
			NewPassword= md5.toMD5(NewPassword);
			pageService.updatePad(userId, NewPassword);
			System.out.println("密码修改成功！");
			return "updatePsd";
		}
		else{
			error = 2;
		}
		return "updatePsd";
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
