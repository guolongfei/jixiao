package com.hoyotech.prison.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hoyotech.prison.bean.ExecutionDetain;
import com.hoyotech.prison.bean.Police;
import com.hoyotech.prison.bean.Prisoner;
import com.hoyotech.prison.log.LogFactory;
import com.hoyotech.prison.service.impl.DictionaryService;
import com.hoyotech.prison.service.impl.ExecutionDetainService;
import com.hoyotech.prison.service.impl.PrisonerService;
import com.hoyotech.prison.util.ConfigHelper;
import com.hoyotech.prison.util.ObjectUpdateUtil;
import com.hoyotech.prison.util.PrisonUtil;

public class ExecutionDetainAction {

	PrisonerService prisonerServer;
	DictionaryService dictionaryService;
	ExecutionDetainService exeDetainService;
	private List<ExecutionDetain> exedetainlist;
	private ExecutionDetain exeDetain;
	private Prisoner prisoner;
	private String id;
	private String view;
	private String type;

	private LogFactory log;
	private List<Police> policelist;
	
	public void selectPolice(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String prisonCode=PrisonUtil.getPrisonCode(request);
		policelist=dictionaryService.selectPolice(prisonCode);
	}
	
	public String doc() {
		exeDetain = exeDetainService.detail(id);
		return "doc";
	}
	
	/**
	 * 添加一条代为执行拘留的信息
	 * **/
	public String add() {
		exeDetain.setNoYear(PrisonUtil.getYear());
		exeDetain.setNoNumber(dictionaryService.getNo("ExecutionDetain"));
		HttpServletRequest request = ServletActionContext.getRequest();
		exeDetain.setPrisonCode(PrisonUtil.getPrisonCode(request));
		id = exeDetainService.add(exeDetain); // 添加数据得到id
		id = exeDetain.getPrisoner().getId();
		type = "exeDetain";
		
		// 添加日志
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "添加成功。";
		log.getInsertLogMessage(exeDetain, config.getInsert(), operate, config.getExecutionDetain(), config.getSucceed(), request);
		return "main";
	}

	/**
	 * 查询一条代为执行拘留的信息
	 * **/
	public String detail() {
		exeDetain = exeDetainService.detail(id);
		return "detail";
	}

	/**
	 * 删除一条代为执行拘留的信息
	 * **/
	public String delete() {
		exeDetainService.delete(id);
		
		// 添加日志
		ExecutionDetain object = new ExecutionDetain();
		object.setId(id);
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "删除成功。";
		log.getModifyLogMessage(null, object, config.getDelete(), operate, config.getExecutionDetain(), config.getSucceed(), request);
		return "select";
	}

	public String detailByPrisoner() {
		exeDetain = exeDetainService.detailByPrisoner(id);
		return "detail";
	}

	/**
	 * 修改一条代为执行拘留的信息
	 * **/
	public String update() {
		ExecutionDetain obj = exeDetainService.detail(exeDetain.getId());
		ExecutionDetain old_obj = exeDetainService.detail(exeDetain.getId());
		ObjectUpdateUtil.compareProperty(exeDetain, obj);
		exeDetainService.update(obj);
		id = exeDetain.getId();
		
		// 添加日志
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "修改成功。";
		log.getModifyLogMessage(obj, old_obj, config.getUpdate(), operate, config.getExecutionDetain(), config.getSucceed(), request);
		return "Detail";
	}

	/**
	 * 进入添加页面
	 * **/
	public String interAdd() {
		selectPolice();
		prisoner = prisonerServer.detail(id);
		return "addUI";
	}

	/**
	 * 进入修改页面
	 * **/
	public String interEdit() {
		selectPolice();
		exeDetain = exeDetainService.detail(id);
		return "edit";
	}

	/**
	 * 修改审批意见
	 * **/
	public String examine() {
		exeDetainService.examineChange(id, view);
		
		// 添加日志
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "修改成功。审批状态修改为:"+view;
		log.getModifyLogMessage(null, null, config.getUpdate(), operate, config.getExecutionDetain(), config.getSucceed(), request);
		return "Detail";
	}
	
	
	public List<Police> getPolicelist() {
		return policelist;
	}

	public void setPolicelist(List<Police> policelist) {
		this.policelist = policelist;
	}

	public LogFactory getLog() {
		return log;
	}

	public void setLog(LogFactory log) {
		this.log = log;
	}

	public String getView() {
		return view;
	}

	public void setView(String view) {
		this.view = view;
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

	public ExecutionDetainService getExeDetainService() {
		return exeDetainService;
	}

	public void setExeDetainService(ExecutionDetainService exeDetainService) {
		this.exeDetainService = exeDetainService;
	}

	public List<ExecutionDetain> getExedetainlist() {
		return exedetainlist;
	}

	public void setExedetainlist(List<ExecutionDetain> exedetainlist) {
		this.exedetainlist = exedetainlist;
	}

	public ExecutionDetain getExeDetain() {
		return exeDetain;
	}

	public void setExeDetain(ExecutionDetain exeDetain) {
		this.exeDetain = exeDetain;
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
