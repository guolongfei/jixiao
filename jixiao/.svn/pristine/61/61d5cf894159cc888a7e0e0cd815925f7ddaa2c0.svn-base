package com.hoyotech.prison.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hoyotech.prison.bean.DetainReturn;
import com.hoyotech.prison.bean.Police;
import com.hoyotech.prison.bean.Prisoner;
import com.hoyotech.prison.log.LogFactory;
import com.hoyotech.prison.service.impl.DetainReturnService;
import com.hoyotech.prison.service.impl.DictionaryService;
import com.hoyotech.prison.service.impl.PrisonerService;
import com.hoyotech.prison.util.ConfigHelper;
import com.hoyotech.prison.util.ObjectUpdateUtil;
import com.hoyotech.prison.util.PrisonUtil;

public class DetainReturnAction {

	PrisonerService prisonerServer;
	DictionaryService dictionaryService;
	DetainReturnService detainReturnService;
	private List<DetainReturn> returns;
	private DetainReturn detainReturn;
	private String id;
	private String view;
	private Prisoner prisoner;
	private String type;
	
	private LogFactory log;
	private List<Police> policelist;
	
	public String doc(){
		detainReturn = detainReturnService.detail(id);
		return "doc";
	}

	/**
	 * 添加一条执行回执信息
	 * **/
	public String add() {
		detainReturn.setNoYear(PrisonUtil.getYear());//添加流水号
		detainReturn.setNoNumber(dictionaryService.getNo("AppealDataPass"));
		HttpServletRequest request = ServletActionContext.getRequest();
		detainReturn.setPrisonCode(PrisonUtil.getPrisonCode(request));
		id = detainReturnService.add(detainReturn); // 添加数据得到id
		id = detainReturn.getPrisoner().getId();
		type = "detainReturn";
		
		// 添加日志
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "添加成功。";
		log.getInsertLogMessage(detainReturn, config.getInsert(), operate, config.getDetainReturn(), config.getSucceed(), request);
		return "main";
	}

	/**
	 * 查询一条执行回执信息
	 * **/
	public String detail() {
		detainReturn = detainReturnService.detail(id);
		return "detail";
	}
	
	public String detailByPrisoner() {
		detainReturn = detainReturnService.detailByPrisoner(id);
		return "detail";
	}

	/**
	 * 删除一条执行回执信息
	 * **/
	public String delete() {
		detainReturnService.delete(id);
		
		// 添加日志
		DetainReturn object = new DetainReturn();
		object.setId(id);
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "删除成功。";
		log.getModifyLogMessage(null, object, config.getDelete(), operate, config.getDetainReturn(), config.getSucceed(), request);
		return "select";
	}

	/**
	 * 修改一条执行回执信息
	 * **/
	public String update() {
		DetainReturn obj = detainReturnService.detail(detainReturn.getId());
		DetainReturn old_obj = detainReturnService.detail(detainReturn.getId());
		ObjectUpdateUtil.compareProperty(detainReturn, obj);
		detainReturnService.update(obj);
		id = detainReturn.getId();
		
		// 添加日志
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "修改成功。";
		log.getModifyLogMessage(obj, old_obj, config.getUpdate(), operate, config.getDetainReturn(), config.getSucceed(), request);
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
		detainReturn = detainReturnService.detail(id);
		return "edit";
	}
	/**
	 * 修改审批意见
	 * **/
	public String examine() {
		detainReturnService.examineChange(id, view);
		
		// 添加日志
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "修改成功。审批状态修改为:"+view;
		log.getModifyLogMessage(null, null, config.getUpdate(), operate, config.getDetainReturn(), config.getSucceed(), request);
		return "Detail";
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

	public DetainReturnService getDetainReturnService() {
		return detainReturnService;
	}

	public void setDetainReturnService(DetainReturnService detainReturnService) {
		this.detainReturnService = detainReturnService;
	}

	public List<DetainReturn> getReturns() {
		return returns;
	}

	public void setReturns(List<DetainReturn> returns) {
		this.returns = returns;
	}

	public DetainReturn getDetainReturn() {
		return detainReturn;
	}

	public void setDetainReturn(DetainReturn detainReturn) {
		this.detainReturn = detainReturn;
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
