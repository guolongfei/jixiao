package com.hoyotech.prison.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hoyotech.prison.bean.Police;
import com.hoyotech.prison.bean.Prisoner;
import com.hoyotech.prison.bean.RefuseDetain;
import com.hoyotech.prison.log.LogFactory;
import com.hoyotech.prison.service.impl.DictionaryService;
import com.hoyotech.prison.service.impl.PrisonerService;
import com.hoyotech.prison.service.impl.RefuseDetainService;
import com.hoyotech.prison.util.ConfigHelper;
import com.hoyotech.prison.util.ObjectUpdateUtil;
import com.hoyotech.prison.util.PrisonUtil;

public class RefuseDetainAction {

	PrisonerService prisonerServer;
	DictionaryService dictionaryService;
	RefuseDetainService refuseDetainService;
	private List<RefuseDetain> refuses;
	private RefuseDetain refuseDetain;
	private String id ;
	private String view;
	private Prisoner prisoner;
	private String type;
	
	private LogFactory log;
	private List<Police> policelist;
	
	public void selectPolice(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String prisonCode=PrisonUtil.getPrisonCode(request);
		policelist=dictionaryService.selectPolice(prisonCode);
	}
	
	public String doc(){
		refuseDetain = refuseDetainService.detail(id);
		return "doc";
	}

	/**
	 * 添加一条不予拘留通知信息
	 * **/
	public String add() {
		refuseDetain.setNoYear(PrisonUtil.getYear());//添加流水号
		refuseDetain.setNoNumber(dictionaryService.getNo("AppealDataPass"));
		HttpServletRequest request = ServletActionContext.getRequest();
		refuseDetain.setPrisonCode(PrisonUtil.getPrisonCode(request));
		id = refuseDetainService.add(refuseDetain); // 添加数据得到id
		id = refuseDetain.getPrisoner().getId();
		type = "refuseDetain";
		
		// 添加日志
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "添加成功。";
		log.getInsertLogMessage(refuseDetain, config.getInsert(), operate, config.getRefuseDetain(), config.getSucceed(), request);
		return "main";
	}

	/**
	 * 查询一条不予拘留通知信息
	 * **/
	public String detail() {
		refuseDetain = refuseDetainService.detail(id);
		return "detail";
	}

	public String detailByPrisoner(){
		refuseDetain = refuseDetainService.detailByPrisoner(id);
		return "detail";
	}
	
	/**
	 * 删除一条不予拘留通知信息
	 * **/
	public String delete() {
		refuseDetainService.delete(id);
		
		// 添加日志
		RefuseDetain object = new RefuseDetain();
		object.setId(id);
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "删除成功。";
		log.getModifyLogMessage(null, object, config.getDelete(), operate, config.getRefuseDetain(), config.getSucceed(), request);
		return "select";
	}

	/**
	 * 修改一条不予拘留通知信息
	 * **/
	public String update() {
		RefuseDetain obj = refuseDetainService.detail(refuseDetain.getId());
		RefuseDetain old_obj = refuseDetainService.detail(refuseDetain.getId());
		ObjectUpdateUtil.compareProperty(refuseDetain, obj);
		refuseDetainService.update(obj);
		id = refuseDetain.getId();
		
		// 添加日志
		
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "修改成功。";
		log.getModifyLogMessage(obj, old_obj, config.getUpdate(), operate, config.getRefuseDetain(), config.getSucceed(), request);
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
		refuseDetain = refuseDetainService.detail(id);
		return "edit";
	}
	/**
	 * 修改审批意见
	 * **/
	public String examine() {
		refuseDetainService.examineChange(id, view);
		
		// 添加日志
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "修改成功。审批状态修改为:"+view;
		log.getModifyLogMessage(null, null, config.getUpdate(), operate, config.getRefuseDetain(), config.getSucceed(), request);
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

	public RefuseDetainService getRefuseDetainService() {
		return refuseDetainService;
	}

	public void setRefuseDetainService(RefuseDetainService refuseDetainService) {
		this.refuseDetainService = refuseDetainService;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<RefuseDetain> getRefuses() {
		return refuses;
	}

	public void setRefuses(List<RefuseDetain> refuses) {
		this.refuses = refuses;
	}
	
	public RefuseDetain getRefuseDetain() {
		return refuseDetain;
	}

	public void setRefuseDetain(RefuseDetain refuseDetain) {
		this.refuseDetain = refuseDetain;
	}

	public String getId() {
		return id;
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

	public String getView() {
		return view;
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
}
