package com.hoyotech.prison.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hoyotech.prison.bean.Emergency;
import com.hoyotech.prison.log.LogFactory;
import com.hoyotech.prison.service.impl.EmergencyService;
import com.hoyotech.prison.util.ConfigHelper;
import com.hoyotech.prison.util.ObjectUpdateUtil;
import com.hoyotech.prison.util.PrisonUtil;
import com.isa.pims.basic.ServletRequestUtils;

public class EmergencyAction {

	private EmergencyService emergencyService;
	private List<Emergency> emergencylist;
	private Emergency emergency;
	private int pageNum;
	private int limit; 
	private int totalPage;
	private int totalNum;
	private String id;
	private String name; //姓名
	private Date time;
	
	private LogFactory log;
	
	/**
	 * 应急预案演练记录登记信息-打印（台账）
	 * **/
	public String print() {
		emergency = emergencyService.detail(id);
		return "ListPrint";
	}
	/**
	 * 查询所有应急预案演练记录
	 * **/
	public String select() {
		HttpServletRequest request=ServletActionContext.getRequest();
		pageNum = ServletRequestUtils.getInt(request, "page","1");
		limit = ServletRequestUtils.getInt(request, "limit","20");
		String prisonCode=PrisonUtil.getPrisonCode(request);
		emergencylist = emergencyService.list(name, time, pageNum, limit,prisonCode);
		totalNum=emergencyService.count(name, time,prisonCode);
		totalPage=(totalNum-1)/limit+1;
		return "List";
	}
	
	/**
	 * 添加一条应急预案演练记录
	 * **/
	public String add() {
		HttpServletRequest request = ServletActionContext.getRequest();
		emergency.setPrisonCode(PrisonUtil.getPrisonCode(request));
		id = emergencyService.add(emergency); //添加数据得到id
		
		// 添加日志
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "添加成功。";
		log.getInsertLogMessage(emergency, config.getInsert(), operate, config.getEmergency(), config.getSucceed(), request);
		return "detail";
	}

	/**
	 * 查询一条应急预案演练记录,返回到详细页面
	 * **/
	public String detail() {
		emergency = emergencyService.detail(id);
		return "Detail";
	}
	
	/**
	 * 删除一条应急预案演练记录
	 * **/
	public String delete() {
		emergencyService.delete(id);
		
		// 添加日志
		Emergency object = new Emergency();
		object.setId(id);
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "删除成功。";
		log.getModifyLogMessage(null, object, config.getDelete(), operate, config.getEmergency(), config.getSucceed(), request);
		return "select";
	}
	
	/**
	 * 修改一条应急预案演练记录
	 * **/
	public String update() {
		Emergency obj = emergencyService.detail(emergency.getId());
		Emergency old_obj = emergencyService.detail(emergency.getId());
		ObjectUpdateUtil.compareProperty(emergency, obj);
		
		emergencyService.update(obj);
		id=emergency.getId();
		
		// 添加日志
		
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "修改成功。";
		log.getModifyLogMessage(obj, old_obj, config.getUpdate(), operate, config.getEmergency(), config.getSucceed(), request);
		return "detail";
	}
	
	/**
	 * 进入添加页面
	 * **/
	public String interAdd() {
		return "Add";
	}
	
	/**
	 * 进入修改页面
	 * **/
	public String interEdit() {
		emergency=emergencyService.detail(id);
		return "Edit";
	}
	
	public LogFactory getLog() {
		return log;
	}

	public void setLog(LogFactory log) {
		this.log = log;
	}

	public EmergencyService getEmergencyService() {
		return emergencyService;
	}

	public void setEmergencyService(EmergencyService emergencyService) {
		this.emergencyService = emergencyService;
	}

	public List<Emergency> getEmergencylist() {
		return emergencylist;
	}

	public void setEmergencylist(List<Emergency> emergencylist) {
		this.emergencylist = emergencylist;
	}

	public Emergency getEmergency() {
		return emergency;
	}

	public void setEmergency(Emergency emergency) {
		this.emergency = emergency;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
	
	
}
