package com.hoyotech.prison.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hoyotech.prison.bean.HandleSeparate;
import com.hoyotech.prison.bean.Police;
import com.hoyotech.prison.bean.Prisoner;
import com.hoyotech.prison.log.LogFactory;
import com.hoyotech.prison.service.impl.DictionaryService;
import com.hoyotech.prison.service.impl.HandleSeparateService;
import com.hoyotech.prison.service.impl.PrisonerService;
import com.hoyotech.prison.util.ConfigHelper;
import com.hoyotech.prison.util.ObjectUpdateUtil;
import com.hoyotech.prison.util.PrisonUtil;

public class HandleSeparateAction {

	PrisonerService prisonerServer;
	private Prisoner prisoner;
	DictionaryService dictionaryService;
	HandleSeparateService handleSeparateService;
	private HandleSeparate handleSeparate;
	private String id;
	private String view;
	private String type;
	
	private LogFactory log;
	private List<Police> policelist;
	
	public String doc(){
		handleSeparate = handleSeparateService.detail(id);
		return "doc";
	}
	
	public void selectPolice(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String prisonCode=PrisonUtil.getPrisonCode(request);
		policelist=dictionaryService.selectPolice(prisonCode);
	}
	
	/**
	 * 添加一条建议另行处理信息
	 * **/
	public String add() {
		handleSeparate.setNoYear(PrisonUtil.getYear());//添加流水号
		handleSeparate.setNoNumber(dictionaryService.getNo("AppealDataPass"));
		HttpServletRequest request = ServletActionContext.getRequest();
		handleSeparate.setPrisonCode(PrisonUtil.getPrisonCode(request));
		id = handleSeparateService.add(handleSeparate); // 添加数据得到id
		id = handleSeparate.getPrisoner().getId();
		type = "handleSeparate";
		
		// 添加日志
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "添加成功。";
		log.getInsertLogMessage(handleSeparate, config.getInsert(), operate, config.getHandleSeparate(), config.getSucceed(), request);
		return "main";
	}

	/**
	 * 查询一条建议另行处理信息
	 * **/
	public String detail() {
		handleSeparate = handleSeparateService.detail(id);
		return "detail";
	}
	public String detailByPrisoner() {
		handleSeparate = handleSeparateService.detailByPrisoner(id);
		return "detail";
	}
	/**
	 * 删除一条建议另行处理信息
	 * **/
	public String delete() {
		handleSeparateService.delete(id);
		
		// 添加日志
		HandleSeparate object = new HandleSeparate();
		object.setId(id);
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "删除成功。";
		log.getModifyLogMessage(null, object, config.getDelete(), operate, config.getHandleSeparate(), config.getSucceed(), request);
		return "select";
	}

	/**
	 * 修改一条建议另行处理信息
	 * **/
	public String update() {
		HandleSeparate obj = handleSeparateService.detail(handleSeparate.getId());
		HandleSeparate old_obj = handleSeparateService.detail(handleSeparate.getId());
		ObjectUpdateUtil.compareProperty(handleSeparate, obj);
		handleSeparateService.update(obj);
		id = handleSeparate.getId();
		
		// 添加日志
		
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "修改成功。";
		log.getModifyLogMessage(obj, old_obj, config.getUpdate(), operate, config.getHandleSeparate(), config.getSucceed(), request);
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
		handleSeparate = handleSeparateService.detail(id);
		return "edit";
	}
	/**
	 * 修改审批意见
	 * **/
	public String examine() {
		handleSeparateService.examineChange(id, view);
		
		// 添加日志
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "修改成功。审批状态修改为:"+view;
		log.getModifyLogMessage(null, null, config.getUpdate(), operate, config.getHandleSeparate(), config.getSucceed(), request);
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

	public DictionaryService getDictionaryService() {
		return dictionaryService;
	}

	public void setDictionaryService(DictionaryService dictionaryService) {
		this.dictionaryService = dictionaryService;
	}

	public HandleSeparateService getHandleSeparateService() {
		return handleSeparateService;
	}

	public void setHandleSeparateService(HandleSeparateService handleSeparateService) {
		this.handleSeparateService = handleSeparateService;
	}

	public HandleSeparate getHandleSeparate() {
		return handleSeparate;
	}

	public void setHandleSeparate(HandleSeparate handleSeparate) {
		this.handleSeparate = handleSeparate;
	}

	public PrisonerService getPrisonerServer() {
		return prisonerServer;
	}

	public void setPrisonerServer(PrisonerService prisonerServer) {
		this.prisonerServer = prisonerServer;
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

	public String getView() {
		return view;
	}

	public void setView(String view) {
		this.view = view;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
