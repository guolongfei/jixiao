package com.hoyotech.prison.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hoyotech.prison.bean.Dictionary;
import com.hoyotech.prison.bean.Police;
import com.hoyotech.prison.bean.Prisoner;
import com.hoyotech.prison.bean.RemoveDetain;
import com.hoyotech.prison.log.LogFactory;
import com.hoyotech.prison.service.impl.DictionaryService;
import com.hoyotech.prison.service.impl.PrisonerService;
import com.hoyotech.prison.service.impl.RemoveDetainService;
import com.hoyotech.prison.util.ConfigHelper;
import com.hoyotech.prison.util.ObjectUpdateUtil;
import com.hoyotech.prison.util.PrisonUtil;
import com.hoyotech.prison.util.Type;

public class RemoveDetainAction {

	PrisonerService prisonerServer;
	private Prisoner prisoner;
	DictionaryService dictionaryService;
	RemoveDetainService removeDetainService;
	private RemoveDetain removeDetain;
	private String id;
	private String view;
	private String type;
	private List<Dictionary> outPrison;
	
	private LogFactory log;
	private List<Police> policelist;
	
	public void selectPolice(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String prisonCode=PrisonUtil.getPrisonCode(request);
		policelist=dictionaryService.selectPolice(prisonCode);
	}
	
	public String doc(){
		removeDetain = removeDetainService.detail(id);
		return "doc";
	}

	/**
	 * 添加一条解除拘留信息
	 * **/
	public String add() {
		removeDetain.setNoYear(PrisonUtil.getYear());//添加流水号
		removeDetain.setNoNumber(dictionaryService.getNo("AppealDataPass"));
		HttpServletRequest request = ServletActionContext.getRequest();
		removeDetain.setPrisonCode(PrisonUtil.getPrisonCode(request));
		id = removeDetainService.add(removeDetain); // 添加数据得到id
		id = removeDetain.getPrisoner().getId();
		type = "removeDetain";
		
		// 添加日志
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "添加成功。";
		log.getInsertLogMessage(removeDetain, config.getInsert(), operate, config.getRemoveDetain(), config.getSucceed(), request);
		return "main";
	}

	public String detailByPrisoner(){
		removeDetain = removeDetainService.detailByPrisoner(id);
		return "detail";
	}
	
	/**
	 * 查询一条解除拘留信息
	 * **/
	public String detail() {
		removeDetain = removeDetainService.detail(id);
		return "detail";
	}

	/**
	 * 删除一条解除拘留信息
	 * **/
	public String delete() {
		removeDetainService.delete(id);
		
		// 添加日志
		RemoveDetain object = new RemoveDetain();
		object.setId(id);
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "删除成功。";
		log.getModifyLogMessage(null, object, config.getDelete(), operate, config.getRemoveDetain(), config.getSucceed(), request);
		return "select";
	}

	/**
	 * 修改一条解除拘留信息
	 * **/
	public String update() {
		RemoveDetain obj = removeDetainService.detail(removeDetain.getId());
		RemoveDetain old_obj = removeDetainService.detail(removeDetain.getId());
		ObjectUpdateUtil.compareProperty(removeDetain, obj);
		removeDetainService.update(obj);
		id = removeDetain.getId();
		
		// 添加日志
		
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "修改成功。";
		log.getModifyLogMessage(obj, old_obj, config.getUpdate(), operate, config.getRemoveDetain(), config.getSucceed(), request);
		return "Detail";
	}

	/**
	 * 进入添加页面
	 * **/
	public String interAdd() {
		selectPolice();
		outPrison = dictionaryService.selectDictionary(Type.OUTPRISONTYPE);
		prisoner = prisonerServer.detail(id);
		return "addUI";
	}
	
	/**
	 * 进入修改页面
	 * **/
	public String interEdit() {
		selectPolice();
		outPrison = dictionaryService.selectDictionary(Type.OUTPRISONTYPE);
		removeDetain = removeDetainService.detail(id);
		return "edit";
	}
	/**
	 * 修改审批意见
	 * **/
	public String examine() {
		removeDetainService.examineChange(id, view);
		
		// 添加日志
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "修改成功。审批状态修改为:"+view;
		log.getModifyLogMessage(null, null, config.getUpdate(), operate, config.getRemoveDetain(), config.getSucceed(), request);
		return "Detail";
	}
	public LogFactory getLog() {
		return log;
	}
	public List<Police> getPolicelist() {
		return policelist;
	}

	public void setPolicelist(List<Police> policelist) {
		this.policelist = policelist;
	}

	public void setLog(LogFactory log) {
		this.log = log;
	}

	public List<Dictionary> getOutPrison() {
		return outPrison;
	}

	public void setOutPrison(List<Dictionary> outPrison) {
		this.outPrison = outPrison;
	}

	public DictionaryService getDictionaryService() {
		return dictionaryService;
	}

	public void setDictionaryService(DictionaryService dictionaryService) {
		this.dictionaryService = dictionaryService;
	}

	public RemoveDetainService getRemoveDetainService() {
		return removeDetainService;
	}

	public void setRemoveDetainService(RemoveDetainService removeDetainService) {
		this.removeDetainService = removeDetainService;
	}

	public RemoveDetain getRemoveDetain() {
		return removeDetain;
	}

	public void setRemoveDetain(RemoveDetain removeDetain) {
		this.removeDetain = removeDetain;
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
