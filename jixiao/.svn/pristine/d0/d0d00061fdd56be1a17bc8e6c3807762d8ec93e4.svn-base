package com.hoyotech.prison.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hoyotech.prison.bean.User;
import com.hoyotech.prison.bean.UserDuty;
import com.hoyotech.prison.log.LogFactory;
import com.hoyotech.prison.service.impl.UserDutyService;
import com.hoyotech.prison.util.ConfigHelper;
import com.hoyotech.prison.util.ObjectUpdateUtil;
import com.hoyotech.prison.util.PrisonUtil;
import com.isa.pims.basic.ServletRequestUtils;

public class UserDutyAction {

	private UserDutyService userDutyService;
	private List<UserDuty> list;
	private UserDuty userDuty;
	private int pageNum;
	private int limit;
	private int totalPage;
	private int totalNum;
	private String id;
	private String userId;
	private int countNotPassWork;//未交班数量
	
	private String startTime;
	private String endTime;
	private String name;
	private String isPassWork;
	
	private LogFactory log;
	
	/**
	 * 工作交接列表
	 * @return
	 */
	public String list(){
		HttpServletRequest request = ServletActionContext.getRequest();
		pageNum = ServletRequestUtils.getInt(request, "page","1");
		limit = ServletRequestUtils.getInt(request, "limit","20");
		String prisonId = PrisonUtil.getPrisonId(request);
		list = userDutyService.getList(prisonId, startTime, endTime, name, isPassWork, pageNum, limit);
		totalNum = userDutyService.getCount(prisonId, startTime, endTime, name, isPassWork);
		totalPage=(totalNum-1)/limit+1;
		
		countNotPassWork = userDutyService.countNotPassWork(prisonId);
		
		return "list";
	}
	
	/**
	 * 进入添加页
	 * @return
	 */
	public String addUI(){
		return "addUI";
	}
	
	/**
	 * 进入修改页
	 * @return
	 */
	public String editUI(){
		userDuty = userDutyService.detail(id);
		
		return "edit";
	}
	
	/**
	 * 添加
	 * @return
	 */
	public String add(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String userId = (String) request.getSession().getAttribute("userId");
		userDuty.setUser(new User( userId) );
		id = userDutyService.add(userDuty);
		
		// 添加日志
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "添加成功。";
		log.getInsertLogMessage(userDuty, config.getInsert(), operate, config.getUserDuty(), config.getSucceed(), request);
		return "Detail";
	}
	
	/**
	 * 修改
	 * **/
	public String update() {
		UserDuty obj = userDutyService.detail(userDuty.getId());
		UserDuty old_obj = userDutyService.detail(userDuty.getId());
		ObjectUpdateUtil.compareProperty(userDuty, obj);
		userDutyService.update(obj);
		id = userDuty.getId();
		
		// 添加日志
		
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "修改成功。";
		log.getModifyLogMessage(obj, old_obj, config.getUpdate(), operate, config.getUserDuty(), config.getSucceed(), request);
		return "Detail";
	}


	/**
	 * 详细
	 * @return
	 */
	public String detail(){
		HttpServletRequest request = ServletActionContext.getRequest();
		userId = (String) request.getSession().getAttribute("userId");
		userDuty = userDutyService.detail(id);
		return "detail";
	}

	/**
	 * 交接工作
	 * @return
	 */
	public String passWork(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String userId = (String) request.getSession().getAttribute("userId");
		userDutyService.passWork(id, userId);
		return "addUI";
	}
	
	public LogFactory getLog() {
		return log;
	}

	public void setLog(LogFactory log) {
		this.log = log;
	}

	public UserDutyService getUserDutyService() {
		return userDutyService;
	}

	public void setUserDutyService(UserDutyService userDutyService) {
		this.userDutyService = userDutyService;
	}

	public List<UserDuty> getList() {
		return list;
	}

	public void setList(List<UserDuty> list) {
		this.list = list;
	}

	public UserDuty getUserDuty() {
		return userDuty;
	}

	public void setUserDuty(UserDuty userDuty) {
		this.userDuty = userDuty;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIsPassWork() {
		return isPassWork;
	}

	public void setIsPassWork(String isPassWork) {
		this.isPassWork = isPassWork;
	}

	public int getCountNotPassWork() {
		return countNotPassWork;
	}

	public void setCountNotPassWork(int countNotPassWork) {
		this.countNotPassWork = countNotPassWork;
	}
}
