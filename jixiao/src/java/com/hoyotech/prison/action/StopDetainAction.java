package com.hoyotech.prison.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hoyotech.prison.bean.Police;
import com.hoyotech.prison.bean.Prisoner;
import com.hoyotech.prison.bean.StopDetain;
import com.hoyotech.prison.log.LogFactory;
import com.hoyotech.prison.service.impl.DictionaryService;
import com.hoyotech.prison.service.impl.PrisonerService;
import com.hoyotech.prison.service.impl.StopDetainService;
import com.hoyotech.prison.util.ConfigHelper;
import com.hoyotech.prison.util.ObjectUpdateUtil;
import com.hoyotech.prison.util.PrisonUtil;

public class StopDetainAction {

	PrisonerService prisonerServer;
	private Prisoner prisoner;
	StopDetainService stopdetainService;
	DictionaryService dictionaryService;
	private StopDetain stopdetain;
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
		stopdetain = stopdetainService.detail(id);
		return "doc";
	}
	
	/**
	 * 添加一条停止执行拘留的信息
	 * **/
	public String add() {
		stopdetain.setNoYear(PrisonUtil.getYear());//添加流水号
		stopdetain.setNoNumber(dictionaryService.getNo("StopDetain"));
		HttpServletRequest request = ServletActionContext.getRequest();
		stopdetain.setPrisonCode(PrisonUtil.getPrisonCode(request));
		id = stopdetainService.add(stopdetain); // 添加数据得到id
		id = stopdetain.getPrisoner().getId();
		type = "stopDetain";
		
		// 添加日志
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "添加成功。";
		log.getInsertLogMessage(stopdetain, config.getInsert(), operate, config.getStopDetain(), config.getSucceed(), request);
		return "main";
	}

	/**
	 * 查询一条被拘留人的信息
	 * **/
	public String detail() {
		stopdetain = stopdetainService.detail(id);
		return "detail";
	}
	
	/**
	 * 根据被拘留人Id查详细信息
	 * @return
	 */
	public String detailByPrisoner(){
		stopdetain = stopdetainService.detailByPrisoner(id);
		return "detail";
	}

	/**
	 * 删除一条被拘留人的信息
	 * **/
	public String delete() {
		stopdetainService.delete(id);
		
		// 添加日志
		StopDetain object = new StopDetain();
		object.setId(id);
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "删除成功。";
		log.getModifyLogMessage(null, object, config.getDelete(), operate, config.getStopDetain(), config.getSucceed(), request);
		return "select";
	}

	/**
	 * 修改一条被拘留人的信息
	 * **/
	public String update() {
		StopDetain obj = stopdetainService.detail(stopdetain.getId());
		StopDetain old_obj = stopdetainService.detail(stopdetain.getId());
		ObjectUpdateUtil.compareProperty(stopdetain, obj);
		stopdetainService.update(obj);
		id = stopdetain.getId();
		
		// 添加日志
		
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "修改成功。";
		log.getModifyLogMessage(obj, old_obj, config.getUpdate(), operate, config.getStopDetain(), config.getSucceed(), request);
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
		stopdetain = stopdetainService.detail(id);
		return "edit";
	}
	
	/**
	 * 修改审批意见
	 * **/
	public String examine() {
		stopdetainService.examineChange(id, view);
		
		// 添加日志
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "修改成功。审批状态修改为:"+view;
		log.getModifyLogMessage(null, null, config.getUpdate(), operate, config.getStopDetain(), config.getSucceed(), request);
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

	public StopDetainService getStopdetainService() {
		return stopdetainService;
	}

	public void setStopdetainService(StopDetainService stopdetainService) {
		this.stopdetainService = stopdetainService;
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

	public StopDetain getStopdetain() {
		return stopdetain;
	}

	public void setStopdetain(StopDetain stopdetain) {
		this.stopdetain = stopdetain;
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
