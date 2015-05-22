package com.hoyotech.prison.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hoyotech.prison.bean.AppealDataPass;
import com.hoyotech.prison.bean.Police;
import com.hoyotech.prison.bean.Prisoner;
import com.hoyotech.prison.log.LogFactory;
import com.hoyotech.prison.service.impl.AppealDataPassService;
import com.hoyotech.prison.service.impl.DictionaryService;
import com.hoyotech.prison.service.impl.PrisonerService;
import com.hoyotech.prison.util.ConfigHelper;
import com.hoyotech.prison.util.ObjectUpdateUtil;
import com.hoyotech.prison.util.PrisonUtil;

public class AppealDataPassAction {

	PrisonerService prisonerServer;
	DictionaryService dictionaryService;
	AppealDataPassService appealDataPassService;	
	private Prisoner prisoner;
	private AppealDataPass appealDataPass;
	private String id;
	private String type;
	
	private LogFactory log;
	private List<Police> policelist;
	
	public String doc(){
		appealDataPass = appealDataPassService.detail(id);
		return "doc";
	}

	/**
	 * 添加一条被拘留人申诉控告等材料转递函信息
	 * **/
	public String add() {
		appealDataPass.setNoYear(PrisonUtil.getYear());//添加流水号
		appealDataPass.setNoNumber(dictionaryService.getNo("AppealDataPass"));
		HttpServletRequest request = ServletActionContext.getRequest();
		appealDataPass.setPrisonCode(PrisonUtil.getPrisonCode(request));
		id = appealDataPassService.add(appealDataPass); // 添加数据得到id
		id = appealDataPass.getPrisoner().getId();
		type = "appealDataPass";
		
		// 添加日志
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "添加成功。";
		log.getInsertLogMessage(appealDataPass, config.getInsert(), operate, config.getAppealDataPass(), config.getSucceed(), request);
		return "main";
	}

	public String detailByPrisoner(){
		appealDataPass = appealDataPassService.detailByPrisoner(id);
		return "detail";
	}
	
	/**
	 * 查询一条被拘留人申诉控告等材料转递函信息
	 * **/
	public String detail() {
		appealDataPass = appealDataPassService.detail(id);
		return "detail";
	}

	/**
	 * 删除一条被拘留人申诉控告等材料转递函信息
	 * **/
	public String delete() {
		appealDataPassService.delete(id);
		
		AppealDataPass object = new AppealDataPass();
		object.setId(id);
		// 添加日志
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "删除成功。";
		log.getModifyLogMessage(null, object, config.getDelete(), operate, config.getAppealDataPass(), config.getSucceed(), request);
		return "select";
	}

	/**
	 * 修改一条被拘留人申诉控告等材料转递函信息
	 * **/
	public String update() {
		AppealDataPass obj = appealDataPassService.detail(appealDataPass.getId());
		AppealDataPass old_obj = appealDataPassService.detail(appealDataPass.getId());
		ObjectUpdateUtil.compareProperty(appealDataPass, obj);
		appealDataPassService.update(obj);
		id = appealDataPass.getId();
		
		// 添加日志
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "修改成功。";
		log.getModifyLogMessage(obj, old_obj, config.getUpdate(), operate, config.getAppealDataPass(), config.getSucceed(), request);
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
		appealDataPass = appealDataPassService.detail(id);
		return "edit";
	}
	
	public void selectPolice(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String prisonCode=PrisonUtil.getPrisonCode(request);
		policelist=dictionaryService.selectPolice(prisonCode);
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

	public AppealDataPassService getAppealDataPassService() {
		return appealDataPassService;
	}

	public void setAppealDataPassService(AppealDataPassService appealDataPassService) {
		this.appealDataPassService = appealDataPassService;
	}

	public AppealDataPass getAppealDataPass() {
		return appealDataPass;
	}

	public void setAppealDataPass(AppealDataPass appealDataPass) {
		this.appealDataPass = appealDataPass;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
