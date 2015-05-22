package com.hoyotech.prison.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hoyotech.prison.bean.LeaveExpires;
import com.hoyotech.prison.bean.OutPrison;
import com.hoyotech.prison.bean.Prisoner;
import com.hoyotech.prison.log.LogFactory;
import com.hoyotech.prison.service.impl.DictionaryService;
import com.hoyotech.prison.service.impl.LeaveExpiresService;
import com.hoyotech.prison.service.impl.OutPrisonService;
import com.hoyotech.prison.service.impl.PrisonerService;
import com.hoyotech.prison.util.ConfigHelper;
import com.hoyotech.prison.util.ObjectUpdateUtil;
import com.hoyotech.prison.util.PrisonUtil;

public class LeaveExpiresAction {

	PrisonerService prisonerServer;
	DictionaryService dictionaryService;
	LeaveExpiresService leaveExService;
	OutPrisonService outprisonService;
	private Prisoner prisoner;
	private OutPrison outprison;
	private List<LeaveExpires> leavelist;
	private LeaveExpires leaveEx;

	private String id;
	private String view;
	private String type;
	
	public String doc(){
		leaveEx = leaveExService.detail(id);
		return "doc";
	}
	
	private LogFactory log;
	
	/**
	 * 查询所有请假出所到期的信息
	 * **/
	public String select() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String prisonCode=PrisonUtil.getPrisonCode(request);
		leavelist = leaveExService.list(id, prisonCode);
		return "list";
	}

	/**
	 * 添加一条请假出所到期的信息
	 * **/
	public String add() {
		leaveEx.setNoYear(PrisonUtil.getYear());//添加流水号
		leaveEx.setNoNumber(dictionaryService.getNo("LeaveExpires"));
		HttpServletRequest request = ServletActionContext.getRequest();
		leaveEx.setPrisonCode(PrisonUtil.getPrisonCode(request));
		leaveExService.add(leaveEx); // 添加数据得到id
//		id = leaveEx.getOutprison().getPrisoner().getId();
		type = "leaveEx";
		
		// 添加日志
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "添加成功。";
		log.getInsertLogMessage(leaveEx, config.getInsert(), operate, config.getLeaveExpires(), config.getSucceed(), request);
		return "main";
	}

	/**
	 * 查询一条请假出所到期的信息
	 * **/
	public String detail() {
		leaveEx = leaveExService.detail(id);
		return "detail";
	}

	/**
	 * 删除一条请假出所到期的信息
	 * **/
	public String delete() {
		leaveExService.delete(id);
		
		// 添加日志
		LeaveExpires object = new LeaveExpires();
		object.setId(id);
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "删除成功。";
		log.getModifyLogMessage(null, object, config.getDelete(), operate, config.getLeaveExpires(), config.getSucceed(), request);
		return "select";
	}
	
	/**
	 * 修改一条请假出所到期的信息
	 * **/
	public String update() {
		LeaveExpires obj = leaveExService.detail(leaveEx.getId());
		LeaveExpires old_obj = leaveExService.detail(leaveEx.getId());
		ObjectUpdateUtil.compareProperty(leaveEx, obj);
		leaveExService.update(obj);
		id = leaveEx.getId();
		
		// 添加日志
		
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "修改成功。";
		log.getModifyLogMessage(obj, old_obj, config.getUpdate(), operate, config.getLeaveExpires(), config.getSucceed(), request);
		return "Detail";
	}

	/**
	 * 进入添加页面
	 * **/
	public String interAdd() {
		outprison = outprisonService.getLastOutprison(id);
		return "addUI";
	}

	/**
	 * 进入修改页面
	 * **/
	public String interEdit() {
		leaveEx = leaveExService.detail(id);
		return "edit";
	}
	/**
	 * 修改审批意见
	 * **/
	public String examine() {
		leaveExService.examineChange(id, view);
		
		// 添加日志
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "修改成功。审批状态修改为:"+view;
		log.getModifyLogMessage(null, null, config.getUpdate(), operate, config.getLeaveExpires(), config.getSucceed(), request);
		return "Detail";
	}
	
	public String getView() {
		return view;
	}
	
	public LogFactory getLog() {
		return log;
	}

	public void setLog(LogFactory log) {
		this.log = log;
	}

	public void setView(String view) {
		this.view = view;
	}

	public OutPrison getOutprison() {
		return outprison;
	}

	public void setOutprison(OutPrison outprison) {
		this.outprison = outprison;
	}

	public OutPrisonService getOutprisonService() {
		return outprisonService;
	}

	public void setOutprisonService(OutPrisonService outprisonService) {
		this.outprisonService = outprisonService;
	}

	public LeaveExpiresService getLeaveExService() {
		return leaveExService;
	}

	public void setLeaveExService(LeaveExpiresService leaveExService) {
		this.leaveExService = leaveExService;
	}

	public List<LeaveExpires> getLeavelist() {
		return leavelist;
	}

	public void setLeavelist(List<LeaveExpires> leavelist) {
		this.leavelist = leavelist;
	}

	public LeaveExpires getLeaveEx() {
		return leaveEx;
	}

	public void setLeaveEx(LeaveExpires leaveEx) {
		this.leaveEx = leaveEx;
	}

	public PrisonerService getPrisonerServer() {
		return prisonerServer;
	}

	public void setPrisonerServer(PrisonerService prisonerServer) {
		this.prisonerServer = prisonerServer;
	}

	public DictionaryService getDictionaryService() {
		return dictionaryService;
	}

	public void setDictionaryService(DictionaryService dictionaryService) {
		this.dictionaryService = dictionaryService;
	}

	public Prisoner getPrisoner() {
		return prisoner;
	}

	public void setPrisoner(Prisoner prisoner) {
		this.prisoner = prisoner;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
