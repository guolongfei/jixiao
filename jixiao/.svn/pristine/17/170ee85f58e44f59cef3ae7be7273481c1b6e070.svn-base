package com.hoyotech.prison.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hoyotech.prison.bean.CrimeKeyPass;
import com.hoyotech.prison.bean.Police;
import com.hoyotech.prison.bean.Prisoner;
import com.hoyotech.prison.log.LogFactory;
import com.hoyotech.prison.service.impl.CrimeKeyPassService;
import com.hoyotech.prison.service.impl.DictionaryService;
import com.hoyotech.prison.service.impl.PrisonerService;
import com.hoyotech.prison.util.ConfigHelper;
import com.hoyotech.prison.util.ObjectUpdateUtil;
import com.hoyotech.prison.util.PrisonUtil;

public class CrimeKeyPassAction {

	PrisonerService prisonerServer;
	DictionaryService dictionaryService;
	CrimeKeyPassService crimeKeyPassService;
	private Prisoner prisoner;
	private CrimeKeyPass crimeKeyPass;

	private String id;
	private String view;
	private String type;
	private List<Police> policelist;
	
	private LogFactory log;
	
	public String doc() {
		crimeKeyPass = crimeKeyPassService.detail(id);
		return "doc";
	}

	/**
	 * 添加一条被拘留人申诉控告等材料转递函信息
	 * **/
	public String add() {
		crimeKeyPass.setNoYear(PrisonUtil.getYear());// 添加流水号
		crimeKeyPass.setNoNumber(dictionaryService.getNo("CrimeKeyPass"));
		HttpServletRequest request = ServletActionContext.getRequest();
		crimeKeyPass.setPrisonCode(PrisonUtil.getPrisonCode(request));
		id = crimeKeyPassService.add(crimeKeyPass); // 添加数据得到id
		id = crimeKeyPass.getPrisoner().getId();
		type = "crimeKeyPass";
		
		// 添加日志
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "添加成功。";
		log.getInsertLogMessage(crimeKeyPass, config.getInsert(), operate, config.getCrimeKeyPass(), config.getSucceed(), request);
		return "main";
	}

	/**
	 * 查询一条被拘留人申诉控告等材料转递函信息
	 * **/
	public String detail() {
		crimeKeyPass = crimeKeyPassService.detail(id);
		return "detail";
	}

	public String detailByPrisoner() {
		crimeKeyPass = crimeKeyPassService.detailByPrisoner(id);
		return "detail";
	}

	/**
	 * 删除一条被拘留人申诉控告等材料转递函信息
	 * **/
	public String delete() {
		crimeKeyPassService.delete(id);
		
		// 添加日志
		CrimeKeyPass object = new CrimeKeyPass ();
		object.setId(id);
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "删除成功。";
		log.getModifyLogMessage(null, object, config.getDelete(), operate, config.getCrimeKeyPass(), config.getSucceed(), request);
		return "select";
	}

	/**
	 * 修改一条被拘留人申诉控告等材料转递函信息
	 * **/
	public String update() {
		CrimeKeyPass obj = crimeKeyPassService.detail(crimeKeyPass.getId());
		CrimeKeyPass old_obj = crimeKeyPassService.detail(crimeKeyPass.getId());
		ObjectUpdateUtil.compareProperty(crimeKeyPass, obj);
		crimeKeyPassService.update(obj);
		id = crimeKeyPass.getId();
		
		// 添加日志
		
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "修改成功。";
		log.getModifyLogMessage(obj, old_obj, config.getUpdate(), operate, config.getCrimeKeyPass(), config.getSucceed(), request);
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
		crimeKeyPass = crimeKeyPassService.detail(id);
		return "edit";
	}

	/**
	 * 修改审批意见
	 * **/
	public String examine() {
		crimeKeyPassService.examineChange(id, view);
		
		// 添加日志
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "修改成功。审批状态修改为:"+view;
		log.getModifyLogMessage(null, null, config.getUpdate(), operate, config.getCrimeKeyPass(), config.getSucceed(), request);
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

	public CrimeKeyPassService getCrimeKeyPassService() {
		return crimeKeyPassService;
	}

	public void setCrimeKeyPassService(CrimeKeyPassService crimeKeyPassService) {
		this.crimeKeyPassService = crimeKeyPassService;
	}

	public CrimeKeyPass getCrimeKeyPass() {
		return crimeKeyPass;
	}

	public void setCrimeKeyPass(CrimeKeyPass crimeKeyPass) {
		this.crimeKeyPass = crimeKeyPass;
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
