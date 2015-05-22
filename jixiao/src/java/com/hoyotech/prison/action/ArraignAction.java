package com.hoyotech.prison.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hoyotech.prison.bean.Arraign;
import com.hoyotech.prison.bean.Police;
import com.hoyotech.prison.bean.Prisoner;
import com.hoyotech.prison.log.LogFactory;
import com.hoyotech.prison.service.impl.ArraignService;
import com.hoyotech.prison.service.impl.DictionaryService;
import com.hoyotech.prison.service.impl.PrisonerService;
import com.hoyotech.prison.util.ConfigHelper;
import com.hoyotech.prison.util.ObjectUpdateUtil;
import com.hoyotech.prison.util.PrisonUtil;

public class ArraignAction {

	PrisonerService prisonerServer;
	DictionaryService dictionaryService;
	ArraignService arraignService;
	private Prisoner prisoner;
	private List<Arraign> arraigns;
	private Arraign arraign;
	private String id;
	private String view;
	private String type;

	private LogFactory log;
	private List<Police> policelist;
	
	public String doc(){
		arraign = arraignService.detail(id);
		return "doc";
	}
	
	/**
	 * 查询所有提解被拘留人登记的信息
	 * **/
	public String select() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String prisonCode=PrisonUtil.getPrisonCode(request);
		arraigns = arraignService.list(id, prisonCode);
		return "list";
	}

	/**
	 * 添加一条提解被拘留人登记的信息
	 * **/
	public String add() {
		arraign.setNoYear(PrisonUtil.getYear());//添加流水号
		arraign.setNoNumber(dictionaryService.getNo("Arraign"));
		HttpServletRequest request = ServletActionContext.getRequest();
		arraign.setPrisonCode(PrisonUtil.getPrisonCode(request));
		id = arraignService.add(arraign); // 添加数据得到id
		id = arraign.getPrisoner().getId();
		type = "arraign";
		
		// 添加日志
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "添加成功。";
		log.getInsertLogMessage(arraign, config.getInsert(), operate, config.getArraign(), config.getSucceed(), request);
		return "main";
	}

	/**
	 * 查询一条提解被拘留人登记的信息
	 * **/
	public String detail() {
		arraign = arraignService.detail(id);
		return "detail";
	}

	/**
	 * 删除一条提解被拘留人登记的信息
	 * **/
	public String delete() {
		arraignService.delete(id);
		
		Arraign object = new Arraign();
		object.setId(id);
		// 添加日志
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "删除成功。";
		log.getModifyLogMessage(null, object, config.getDelete(), operate, config.getArraign(), config.getSucceed(), request);
		return "select";
	}

	public String detailByPrisoner(){
		arraign = arraignService.detailByPrisoner(id);
		return "detail";
	}
	
	/**
	 * 修改一条提解被拘留人登记的信息
	 * **/
	public String update() {
		Arraign obj = arraignService.detail(arraign.getId());
		Arraign old_obj = arraignService.detail(arraign.getId());
		ObjectUpdateUtil.compareProperty(arraign, obj);
		arraignService.update(obj);
		id = arraign.getId();
		
		// 添加日志
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "修改成功。";
		log.getModifyLogMessage(obj, old_obj, config.getUpdate(), operate, config.getArraign(), config.getSucceed(), request);
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
		arraign = arraignService.detail(id);
		return "edit";
	}
	/**
	 * 修改审批意见
	 * **/
	public String examine() {
		arraignService.examineChange(id, view);
		
		// 添加日志
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "修改成功。审批状态修改为:"+view;
		log.getModifyLogMessage(null, null, config.getUpdate(), operate, config.getArraign(), config.getSucceed(), request);
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

	public ArraignService getArraignService() {
		return arraignService;
	}

	public void setArraignService(ArraignService arraignService) {
		this.arraignService = arraignService;
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

	public List<Arraign> getArraigns() {
		return arraigns;
	}

	public void setArraigns(List<Arraign> arraigns) {
		this.arraigns = arraigns;
	}

	public Arraign getArraign() {
		return arraign;
	}

	public void setArraign(Arraign arraign) {
		this.arraign = arraign;
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
}
