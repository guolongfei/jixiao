package com.hoyotech.prison.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hoyotech.prison.bean.OutPrison;
import com.hoyotech.prison.bean.Police;
import com.hoyotech.prison.bean.Prisoner;
import com.hoyotech.prison.log.LogFactory;
import com.hoyotech.prison.service.impl.DictionaryService;
import com.hoyotech.prison.service.impl.OutPrisonService;
import com.hoyotech.prison.service.impl.PrisonerService;
import com.hoyotech.prison.util.ConfigHelper;
import com.hoyotech.prison.util.ObjectUpdateUtil;
import com.hoyotech.prison.util.PrisonUtil;

public class OutprisonAction {

	PrisonerService prisonerServer;
	DictionaryService dictionaryService;
	OutPrisonService outprisonService;
	private Prisoner prisoner;
	private OutPrison outprison;
	private List<OutPrison> outlist;
	private String id;
	
	private String view;
	private String type;
	
	private LogFactory log;
	private List<Police> policelist;
	
	public String doc(){
		outprison = outprisonService.detail(id);
		return "doc";
	}

	public void selectPolice(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String prisonCode=PrisonUtil.getPrisonCode(request);
		policelist=dictionaryService.selectPolice(prisonCode);
	}
	
	/**
	 * 查询所有请假出所审批的信息
	 * **/
	public String select() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String prisonCode=PrisonUtil.getPrisonCode(request);
		outlist = outprisonService.list(id, prisonCode);
		return "list";
	}

	/**
	 * 添加一条请假出所审批的信息
	 * **/
	public String add() {
		outprison.setNoYear(PrisonUtil.getYear());//添加流水号
		outprison.setNoNumber(dictionaryService.getNo("OutPrison"));
		HttpServletRequest request = ServletActionContext.getRequest();
		outprison.setPrisonCode(PrisonUtil.getPrisonCode(request));
		outprisonService.add(outprison); // 添加数据得到id
		id = outprison.getPrisoner().getId();
		type = "outPrison";
		
		// 添加日志
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "添加成功。";
		log.getInsertLogMessage(outprison, config.getInsert(), operate, config.getOutPrison(), config.getSucceed(), request);
		return "main";
	}

	/**
	 * 查询一条请假出所审批的信息
	 * **/
	public String detail() {
		outprison = outprisonService.detail(id);
		return "detail";
	}

	/**
	 * 删除一条请假出所审批的信息
	 * **/
	public String delete() {
		outprisonService.delete(id);
		
		// 添加日志
		OutPrison object = new OutPrison();
		object.setId(id);
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "删除成功。";
		log.getModifyLogMessage(null, object, config.getDelete(), operate, config.getOutPrison(), config.getSucceed(), request);
		return "select";
	}

	/**
	 * 修改一条请假出所审批的信息
	 * **/
	public String update() {
		OutPrison obj = outprisonService.detail(outprison.getId());
		OutPrison old_obj = outprisonService.detail(outprison.getId());
		ObjectUpdateUtil.compareProperty(outprison, obj);
		outprisonService.update(obj);
		id = outprison.getId();
		
		// 添加日志
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "修改成功。";
		log.getModifyLogMessage(obj, old_obj, config.getUpdate(), operate, config.getOutPrison(), config.getSucceed(), request);
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
		outprison = outprisonService.detail(id);
		return "edit";
	}
	/**
	 * 修改审批意见
	 * **/
	public String examine() {
		outprisonService.examineChange(id, view);
		
		// 添加日志
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "修改成功。审批状态修改为:"+view;
		log.getModifyLogMessage(null, null, config.getUpdate(), operate, config.getOutPrison(), config.getSucceed(), request);
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

	public OutPrison getOutprison() {
		return outprison;
	}

	public void setOutprison(OutPrison outprison) {
		this.outprison = outprison;
	}

	public List<OutPrison> getOutlist() {
		return outlist;
	}

	public void setOutlist(List<OutPrison> outlist) {
		this.outlist = outlist;
	}

	public OutPrisonService getOutprisonService() {
		return outprisonService;
	}

	public void setOutprisonService(OutPrisonService outprisonService) {
		this.outprisonService = outprisonService;
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
