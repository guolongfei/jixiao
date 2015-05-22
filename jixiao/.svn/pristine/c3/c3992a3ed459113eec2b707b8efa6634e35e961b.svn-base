package com.hoyotech.prison.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hoyotech.prison.bean.Arraign;
import com.hoyotech.prison.bean.AskRegistration;
import com.hoyotech.prison.bean.DetentionArea;
import com.hoyotech.prison.bean.DevChnInfo;
import com.hoyotech.prison.bean.ExecutionDetain;
import com.hoyotech.prison.bean.JiangCheng;
import com.hoyotech.prison.bean.LeaveExpires;
import com.hoyotech.prison.bean.OutPrison;
import com.hoyotech.prison.bean.StopDetain;
import com.hoyotech.prison.bean.UseWeapon;
import com.hoyotech.prison.bean.User;
import com.hoyotech.prison.bean.UserPowerZD;
import com.hoyotech.prison.service.impl.DevChannelService;
import com.hoyotech.prison.service.impl.MainService;
import com.hoyotech.prison.service.impl.PrisonerHealthService;
import com.hoyotech.prison.service.impl.PrisonerService;
import com.hoyotech.prison.service.impl.UserDetentionService;
import com.hoyotech.prison.service.impl.LoginService;
import com.hoyotech.prison.util.Note;
import com.hoyotech.prison.util.PrisonUtil;
import com.opensymphony.xwork2.ActionSupport;

public class MainAction extends ActionSupport {

	private UserDetentionService userDetentionService;
	private PrisonerHealthService prisonerHealthService;
	private MainService mainService;
	private DevChannelService devChannelService;
	private PrisonerService prisonerServer;
	private LoginService loginService;	

	private List<DetentionArea> detentionAreaList;// 该用户可监控的拘室的列表
	private int prisonerCount; // 拘所在人数
	private String roomId;
	private int inPrisonCount;  //今日事务入所情况
	private int outPrisonCount; //今日事务出所情况
	private int excusedCount;   //今日事务请假情况
	private int xingjuCount;	//今日事务转刑拘情况
	private int yanguanCount;   //严管人员数量
	private int alreadyOutCount; //今日事务已出所
	private int chaoqiCount;//超期未出所
	private int weitanhuaCount; //逾期未谈话
	private int butanhuaCount; //补谈话
	private int OutPrisonerTomorrowCount;//明日出所
	
	private DevChnInfo devChnInfo;
	private List<Note> prisonerList;
	
	private int lightAndSound;
	
	private List<Arraign> arragins;
	private List<AskRegistration> asks;
	//private List<ExecuteReturn> returns;
	private List<ExecutionDetain> detains;
	private List<JiangCheng> jiangchengs;
	private List<LeaveExpires> leaves;
	private List<OutPrison> outs;
	
	//private List<SendExamine> sends;
	private List<StopDetain> stops;
	private List<UseWeapon> weapons;
	
	private int approverCount=0;
	private int takeMedicCount;
	private String password;
	private String username;
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	private User user;
	private UserPowerZD upzd; 
	
	public UserPowerZD getUpzd() {
		return upzd;
	}

	public void setUpzd(UserPowerZD upzd) {
		this.upzd = upzd;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String execute() {
		select();
		HttpServletRequest request = ServletActionContext.getRequest();
		String userId = (String) request.getSession().getAttribute("userId");
		String prisonId = PrisonUtil.getPrisonId(request);
		String prisonCode=PrisonUtil.getPrisonCode(request);

		detentionAreaList = userDetentionService.getSelected(userId);
		prisonerCount = prisonerServer.countPrisoner(prisonId);
		prisonerList = prisonerServer.getPrisonerJson(prisonId);
		
		inPrisonCount=prisonerServer.countPrisoner(null, null, null, null, null, new Date(), null,null,null,null,null,null,null, prisonCode);
		outPrisonCount=prisonerServer.countPrisoner(null, null, null, null, null, null, new Date(),null,null,null,null,null,null, prisonCode);
		excusedCount=prisonerServer.countPrisoner(null, null, null, null, "2", null, null,null,null,null,null,null,null, prisonCode);
		xingjuCount=prisonerServer.countPrisoner(null, null, null, null, "3", null, null,"113",null,new Date(),null,null,null, prisonCode);
		yanguanCount=prisonerServer.countPrisoner(null, null, null, null, null, null, null,null,"117",null,null,null,null, prisonCode);
		alreadyOutCount=prisonerServer.countPrisoner(null, null, null, null, "3", null, null,null,null,new Date(),null,null,null, prisonCode);
		chaoqiCount=prisonerServer.countPrisoner(null, null, null, null, null, null, null,null,null,null,new Date(),null,null, prisonCode);
		weitanhuaCount=prisonerServer.countPrisoner(null, null, null, null, null, null, null,null,null,null,null,"1",null, prisonCode);
		butanhuaCount=prisonerServer.countPrisoner(null, null, null, null, null, null, null,null,null,null,null,null,"1", prisonCode);
		takeMedicCount=prisonerHealthService.getTakeMedicTime(Long.toString(new Date().getTime()/1000));
		OutPrisonerTomorrowCount=prisonerServer.countOutPrisoner(null, null, null, null, null, null, null,null,null,null,null,null,null, prisonCode);
		
		if(arragins.size()>0){
			approverCount+=arragins.size();
		}
		if(asks.size()>0){
			approverCount+=asks.size();
		}
//		if(returns.size()>0){
//			approverCount+=returns.size();
//		}
		if(detains.size()>0){
			approverCount+=detains.size();
		}
		if(jiangchengs.size()>0){
			approverCount+=jiangchengs.size();
		}
		if(leaves.size()>0){
			approverCount+=leaves.size();
		}
		if(outs.size()>0){
			approverCount+=outs.size();
		}
//		if(sends.size()>0){
//			approverCount+=sends.size();
//		}
		if(stops.size()>0){
			approverCount+=stops.size();
		}
		if(weapons.size()>0){
			approverCount+=weapons.size();
		}
		
		String power=(String)request.getSession().getAttribute("key");
		if(power == null){
			power = "";
		}
		
		if(((outPrisonCount!=0||chaoqiCount!=0||weitanhuaCount!=0||butanhuaCount!=0)&&power.indexOf("P04") !=-1) ||(approverCount!=0&&power.indexOf("K23") !=-1)){
			lightAndSound=1;
		}else{
			lightAndSound=0;
		}
		
		String orgType = (String) request.getSession().getAttribute("orgType");
		if(orgType.indexOf("3") !=-1){
			upzd = loginService.getPrisonInfoListZD(userId);
		}

		return SUCCESS;
	}
	
	private void select(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String prisonCode=PrisonUtil.getPrisonCode(request);
		arragins=mainService.arrgin(prisonCode);
		asks=mainService.ask(prisonCode);
		//returns=mainService.returns(prisonCode);
		detains=mainService.detain(prisonCode);
		jiangchengs=mainService.jiangcheng(prisonCode);
		leaves=mainService.leave(prisonCode);
		outs=mainService.outs(prisonCode);
		//sends=mainService.send(prisonCode);
		stops=mainService.stop(prisonCode);
		weapons=mainService.weapon(prisonCode);
	}
	
	public String st2(){
		select();
		return "st2";
	}
	
	
	public String st(){
		return "st";
	}
	
	/**
	 * 进入监控页面
	 * @return
	 */
	public String surveil(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String userId = (String) request.getSession().getAttribute("userId");
		boolean flag = userDetentionService.checkPriv(userId, roomId);
		if(flag){
			devChnInfo = devChannelService.getDevChaInfoByRoom(roomId);
		}
		return "surveil";
	}

	
	public int getLightAndSound() {
		return lightAndSound;
	}

	public void setLightAndSound(int lightAndSound) {
		this.lightAndSound = lightAndSound;
	}

	public UserDetentionService getUserDetentionService() {
		return userDetentionService;
	}

	public void setUserDetentionService(UserDetentionService userDetentionService) {
		this.userDetentionService = userDetentionService;
	}

	public MainService getMainService() {
		return mainService;
	}

	public void setMainService(MainService mainService) {
		this.mainService = mainService;
	}

	public DevChannelService getDevChannelService() {
		return devChannelService;
	}

	public void setDevChannelService(DevChannelService devChannelService) {
		this.devChannelService = devChannelService;
	}

	public PrisonerService getPrisonerServer() {
		return prisonerServer;
	}

	public void setPrisonerServer(PrisonerService prisonerServer) {
		this.prisonerServer = prisonerServer;
	}

	public List<DetentionArea> getDetentionAreaList() {
		return detentionAreaList;
	}

	public void setDetentionAreaList(List<DetentionArea> detentionAreaList) {
		this.detentionAreaList = detentionAreaList;
	}

	public int getPrisonerCount() {
		return prisonerCount;
	}

	public void setPrisonerCount(int prisonerCount) {
		this.prisonerCount = prisonerCount;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public int getInPrisonCount() {
		return inPrisonCount;
	}

	public void setInPrisonCount(int inPrisonCount) {
		this.inPrisonCount = inPrisonCount;
	}

	public int getOutPrisonCount() {
		return outPrisonCount;
	}

	public void setOutPrisonCount(int outPrisonCount) {
		this.outPrisonCount = outPrisonCount;
	}

	public int getExcusedCount() {
		return excusedCount;
	}

	public void setExcusedCount(int excusedCount) {
		this.excusedCount = excusedCount;
	}

	public int getXingjuCount() {
		return xingjuCount;
	}

	public void setXingjuCount(int xingjuCount) {
		this.xingjuCount = xingjuCount;
	}

	public int getYanguanCount() {
		return yanguanCount;
	}

	public void setYanguanCount(int yanguanCount) {
		this.yanguanCount = yanguanCount;
	}

	public int getAlreadyOutCount() {
		return alreadyOutCount;
	}

	public void setAlreadyOutCount(int alreadyOutCount) {
		this.alreadyOutCount = alreadyOutCount;
	}

	public int getChaoqiCount() {
		return chaoqiCount;
	}

	public void setChaoqiCount(int chaoqiCount) {
		this.chaoqiCount = chaoqiCount;
	}

	public int getWeitanhuaCount() {
		return weitanhuaCount;
	}

	public void setWeitanhuaCount(int weitanhuaCount) {
		this.weitanhuaCount = weitanhuaCount;
	}

	public int getButanhuaCount() {
		return butanhuaCount;
	}

	public void setButanhuaCount(int butanhuaCount) {
		this.butanhuaCount = butanhuaCount;
	}

	public DevChnInfo getDevChnInfo() {
		return devChnInfo;
	}

	public void setDevChnInfo(DevChnInfo devChnInfo) {
		this.devChnInfo = devChnInfo;
	}

	public List<Note> getPrisonerList() {
		return prisonerList;
	}

	public void setPrisonerList(List<Note> prisonerList) {
		this.prisonerList = prisonerList;
	}

	public List<Arraign> getArragins() {
		return arragins;
	}

	public void setArragins(List<Arraign> arragins) {
		this.arragins = arragins;
	}

	public List<AskRegistration> getAsks() {
		return asks;
	}

	public void setAsks(List<AskRegistration> asks) {
		this.asks = asks;
	}

//	public List<ExecuteReturn> getReturns() {
//		return returns;
//	}
//
//	public void setReturns(List<ExecuteReturn> returns) {
//		this.returns = returns;
//	}

	public List<ExecutionDetain> getDetains() {
		return detains;
	}

	public void setDetains(List<ExecutionDetain> detains) {
		this.detains = detains;
	}

	public List<JiangCheng> getJiangchengs() {
		return jiangchengs;
	}

	public void setJiangchengs(List<JiangCheng> jiangchengs) {
		this.jiangchengs = jiangchengs;
	}

	public List<LeaveExpires> getLeaves() {
		return leaves;
	}

	public void setLeaves(List<LeaveExpires> leaves) {
		this.leaves = leaves;
	}

	public List<OutPrison> getOuts() {
		return outs;
	}

	public void setOuts(List<OutPrison> outs) {
		this.outs = outs;
	}

	public List<StopDetain> getStops() {
		return stops;
	}

	public void setStops(List<StopDetain> stops) {
		this.stops = stops;
	}

	public List<UseWeapon> getWeapons() {
		return weapons;
	}

	public void setWeapons(List<UseWeapon> weapons) {
		this.weapons = weapons;
	}

	public int getApproverCount() {
		return approverCount;
	}

	public void setApproverCount(int approverCount) {
		this.approverCount = approverCount;
	}

	public int getOutPrisonerTomorrowCount() {
		return OutPrisonerTomorrowCount;
	}

	public void setOutPrisonerTomorrowCount(int outPrisonerTomorrowCount) {
		OutPrisonerTomorrowCount = outPrisonerTomorrowCount;
	}
	
	public LoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	public PrisonerHealthService getPrisonerHealthService() {
		return prisonerHealthService;
	}

	public void setPrisonerHealthService(PrisonerHealthService prisonerHealthService) {
		this.prisonerHealthService = prisonerHealthService;
	}

	public int getTakeMedicCount() {
		return takeMedicCount;
	}

	public void setTakeMedicCount(int takeMedicCount) {
		this.takeMedicCount = takeMedicCount;
	}
}
