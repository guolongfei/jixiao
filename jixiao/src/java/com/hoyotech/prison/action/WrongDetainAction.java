  package com.hoyotech.prison.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hoyotech.prison.bean.Police;
import com.hoyotech.prison.bean.Prisoner;
import com.hoyotech.prison.bean.WrongDetain;
import com.hoyotech.prison.log.LogFactory;
import com.hoyotech.prison.service.impl.DictionaryService;
import com.hoyotech.prison.service.impl.PrisonerService;
import com.hoyotech.prison.service.impl.WrongDetainService;
import com.hoyotech.prison.util.ConfigHelper;
import com.hoyotech.prison.util.ObjectUpdateUtil;
import com.hoyotech.prison.util.PrisonUtil;

public class WrongDetainAction {

	PrisonerService prisonerServer;
	private Prisoner prisoner;
	DictionaryService dictionaryService;
	WrongDetainService wrongDetainService;
	private WrongDetain wrongDetain;
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
	
	public String doc(){
		wrongDetain = wrongDetainService.detail(id);
		return "doc";
	}

	/**
	 * 添加一条可能错误拘留信息
	 * **/
	public String add() {
		wrongDetain.setNoYear(PrisonUtil.getYear());//添加流水号
		wrongDetain.setNoNumber(dictionaryService.getNo("AppealDataPass"));
		HttpServletRequest request = ServletActionContext.getRequest();
		wrongDetain.setPrisonCode(PrisonUtil.getPrisonCode(request));
		wrongDetainService.add(wrongDetain);
		id = wrongDetain.getPrisoner().getId();
		type = "wrongDetain";
		
		// 添加日志
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "添加成功。";
		log.getInsertLogMessage(wrongDetain, config.getInsert(), operate, config.getWrongDetain(), config.getSucceed(), request);
		return "main";
	}

	/**
	 * 查询一条可能错误拘留信息
	 * **/
	public String detail() {
		wrongDetain = wrongDetainService.detail(id);
		return "detail";
	}
	public String detailByPrisoner() {
		wrongDetain = wrongDetainService.detailByPrisoner(id);
		return "detail";
	}
	/**
	 * 删除一条可能错误拘留信息
	 * **/
	public String delete() {
		wrongDetainService.delete(id);
		
		// 添加日志
		WrongDetain object = new WrongDetain();
		object.setId(id);
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "删除成功。";
		log.getModifyLogMessage(null, object, config.getDelete(), operate, config.getWrongDetain(), config.getSucceed(), request);
		return "select";
	}

	/**
	 * 修改一条可能错误拘留信息
	 * **/
	public String update() {
		WrongDetain obj = wrongDetainService.detail(wrongDetain.getId());
		WrongDetain old_obj = wrongDetainService.detail(wrongDetain.getId());
		ObjectUpdateUtil.compareProperty(wrongDetain, obj);
		wrongDetainService.update(obj);
		id = wrongDetain.getId();
		
		// 添加日志
		
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "修改成功。";
		log.getModifyLogMessage(obj, old_obj, config.getUpdate(), operate, config.getWrongDetain(), config.getSucceed(), request);
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
		wrongDetain = wrongDetainService.detail(id);
		return "edit";
	}
	/**
	 * 修改审批意见
	 * **/
	public String examine() {
		wrongDetainService.examineChange(id, view);
		
		// 添加日志
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "修改成功。审批状态修改为:"+view;
		log.getModifyLogMessage(null, null, config.getUpdate(), operate, config.getWrongDetain(), config.getSucceed(), request);
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

	public WrongDetainService getWrongDetainService() {
		return wrongDetainService;
	}

	public void setWrongDetainService(WrongDetainService wrongDetainService) {
		this.wrongDetainService = wrongDetainService;
	}

	public WrongDetain getWrongDetain() {
		return wrongDetain;
	}

	public void setWrongDetain(WrongDetain wrongDetain) {
		this.wrongDetain = wrongDetain;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
