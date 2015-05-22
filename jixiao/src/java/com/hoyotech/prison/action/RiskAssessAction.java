package com.hoyotech.prison.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hoyotech.prison.bean.Dictionary;
import com.hoyotech.prison.bean.Medical;
import com.hoyotech.prison.bean.Police;
import com.hoyotech.prison.bean.Prisoner;
import com.hoyotech.prison.bean.RiskAssess;
import com.hoyotech.prison.log.LogFactory;
import com.hoyotech.prison.service.impl.DictionaryService;
import com.hoyotech.prison.service.impl.PrisonerService;
import com.hoyotech.prison.service.impl.RiskAssessService;
import com.hoyotech.prison.util.ConfigHelper;
import com.hoyotech.prison.util.ObjectUpdateUtil;
import com.hoyotech.prison.util.PrisonUtil;
import com.hoyotech.prison.util.Type;

public class RiskAssessAction {

	private PrisonerService prisonerServer;
	private DictionaryService dictionaryService;
	private Prisoner prisoner;
	private RiskAssessService riskAssessService;
	private List<RiskAssess> risks;
	private RiskAssess riskAssess;
	private String id;
	private String view;
	private String type;

	private LogFactory log;
	private List<Police> policelist;
	private List<Medical> medicallist;
	private List<Dictionary> levels;
	
	// 向导添加的参数
	private String mode;
	private String step;
	private String complete;
	
	public String doc(){
		riskAssess = riskAssessService.detail(id);
		return "doc";
	}
		
	public void selectPolice(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String prisonCode=PrisonUtil.getPrisonCode(request);
		policelist=dictionaryService.selectPolice(prisonCode);
		medicallist=dictionaryService.selectMedical(prisonCode);
		levels= dictionaryService.selectDictionary(Type.DANGERTYPENUM);
	}
	
	/**
	 * 查询所有风险评估的信息
	 * **/
	public String select() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String prisonCode=PrisonUtil.getPrisonCode(request);
		risks = riskAssessService.list(id, prisonCode);
		return "list";
	}

	/**
	 * 添加一条风险评估的信息
	 * **/
	public String add() {
		HttpServletRequest request = ServletActionContext.getRequest();
		riskAssess.setPrisonCode(PrisonUtil.getPrisonCode(request));
		id = riskAssessService.add(riskAssess); // 添加数据得到id
		id = riskAssess.getPrisoner().getId();
		type = "riskAssess";
		
		// 添加日志
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "添加成功。";
		log.getInsertLogMessage(riskAssess, config.getInsert(), operate, config.getRiskAssess(), config.getSucceed(), request);
		
		if("wizard".equals(mode)){
			// 快速添加
			step = "4";
			complete = "4";
			return "next";
		}else{
			return "main";
		}
		
	}

	/**
	 * 查询一条风险评估的信息
	 * **/
	public String detail() {
		riskAssess = riskAssessService.detail(id);
		return "detail";
	}

	/**
	 * 删除一条风险评估的信息
	 * **/
	public String delete() {
		riskAssessService.delete(id);
		
		RiskAssess object = new RiskAssess();
		object.setId(id);
		// 添加日志
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "删除成功。";
		log.getModifyLogMessage(null, object, config.getDelete(), operate, config.getRiskAssess(), config.getSucceed(), request);
		return "select";
	}

	public String detailByPrisoner(){
		riskAssess = riskAssessService.detailByPrisoner(id);
		return "detail";
	}
	
	/**
	 * 修改一条风险评估的信息
	 * **/
	public String update() {
		RiskAssess obj = riskAssessService.detail(riskAssess.getId());
		RiskAssess old_obj = riskAssessService.detail(riskAssess.getId());
		ObjectUpdateUtil.compareProperty(riskAssess, obj);
		riskAssessService.update(obj);
		id = riskAssess.getId();
		
		// 添加日志
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "修改成功。";
		log.getModifyLogMessage(obj, old_obj, config.getUpdate(), operate, config.getRiskAssess(), config.getSucceed(), request);
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
		riskAssess = riskAssessService.detail(id);
		return "edit";
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

	public RiskAssessService getRiskAssessService() {
		return riskAssessService;
	}

	public void setRiskAssessService(RiskAssessService riskAssessService) {
		this.riskAssessService = riskAssessService;
	}

	public List<RiskAssess> getRisks() {
		return risks;
	}

	public void setRisks(List<RiskAssess> risks) {
		this.risks = risks;
	}

	public RiskAssess getRiskAssess() {
		return riskAssess;
	}

	public void setRiskAssess(RiskAssess riskAssess) {
		this.riskAssess = riskAssess;
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

	public LogFactory getLog() {
		return log;
	}

	public void setLog(LogFactory log) {
		this.log = log;
	}

	public List<Police> getPolicelist() {
		return policelist;
	}

	public void setPolicelist(List<Police> policelist) {
		this.policelist = policelist;
	}

	public List<Medical> getMedicallist() {
		return medicallist;
	}

	public void setMedicallist(List<Medical> medicallist) {
		this.medicallist = medicallist;
	}

	public List<Dictionary> getLevels() {
		return levels;
	}

	public void setLevels(List<Dictionary> levels) {
		this.levels = levels;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getStep() {
		return step;
	}

	public void setStep(String step) {
		this.step = step;
	}

	public String getComplete() {
		return complete;
	}

	public void setComplete(String complete) {
		this.complete = complete;
	}
	
}
