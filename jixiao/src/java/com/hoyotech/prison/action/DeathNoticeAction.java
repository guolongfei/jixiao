package com.hoyotech.prison.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hoyotech.prison.bean.DeathNotice;
import com.hoyotech.prison.bean.Police;
import com.hoyotech.prison.bean.Prisoner;
import com.hoyotech.prison.log.LogFactory;
import com.hoyotech.prison.service.impl.DeathNoticeService;
import com.hoyotech.prison.service.impl.DictionaryService;
import com.hoyotech.prison.service.impl.PrisonerService;
import com.hoyotech.prison.util.ConfigHelper;
import com.hoyotech.prison.util.ObjectUpdateUtil;
import com.hoyotech.prison.util.PrisonUtil;

public class DeathNoticeAction {

	PrisonerService prisonerServer;
	private Prisoner prisoner;
	DictionaryService dictionaryService;
	DeathNoticeService deathNoticeService;
	private DeathNotice deathNotice;
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
		deathNotice = deathNoticeService.detail(id);
		return "doc";
	}

	/**
	 * 添加一条被拘留人死亡通知信息
	 * **/
	public String add() {
		deathNotice.setNoYear(PrisonUtil.getYear());//添加流水号
		deathNotice.setNoNumber(dictionaryService.getNo("AppealDataPass"));
		HttpServletRequest request = ServletActionContext.getRequest();
		deathNotice.setPrisonCode(PrisonUtil.getPrisonCode(request));
		id = deathNoticeService.add(deathNotice); // 添加数据得到id
		id = deathNotice.getPrisoner().getId();
		type = "deathNotice";
		
		// 添加日志
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "添加成功。";
		log.getInsertLogMessage(deathNotice, config.getInsert(), operate, config.getDeathNotice(), config.getSucceed(), request);
		return "main";
	}

	/**
	 * 查询一条被拘留人死亡通知信息
	 * **/
	public String detail() {
		deathNotice = deathNoticeService.detail(id);
		return "detail";
	}

	/**
	 * 删除一条被拘留人死亡通知信息
	 * **/
	public String delete() {
		deathNoticeService.delete(id);
		
		// 添加日志
		DeathNotice object = new DeathNotice();
		object.setId(id);
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "删除成功。";
		log.getModifyLogMessage(null, object, config.getDelete(), operate, config.getDeathNotice(), config.getSucceed(), request);
		return "select";
	}

	public String detailByPrisoner(){
		deathNotice = deathNoticeService.detailByPrisoner(id);
		return "detail";
	}
	/**
	 * 修改一条被拘留人死亡通知信息
	 * **/
	public String update() {
		DeathNotice obj = deathNoticeService.detail(deathNotice.getId());
		DeathNotice old_obj = deathNoticeService.detail(deathNotice.getId());
		ObjectUpdateUtil.compareProperty(deathNotice, obj);
		deathNoticeService.update(obj);
		id = deathNotice.getId();
		
		// 添加日志
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "修改成功。";
		log.getModifyLogMessage(obj, old_obj, config.getUpdate(), operate, config.getDeathNotice(), config.getSucceed(), request);
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
		deathNotice = deathNoticeService.detail(id);
		return "edit";
	}
	/**
	 * 修改审批意见
	 * **/
	public String examine() {
		deathNoticeService.examineChange(id, view);
		
		// 添加日志
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "修改成功。审批状态修改为:"+view;
		log.getModifyLogMessage(null, null, config.getUpdate(), operate, config.getDeathNotice(), config.getSucceed(), request);
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

	public DeathNoticeService getDeathNoticeService() {
		return deathNoticeService;
	}

	public void setDeathNoticeService(DeathNoticeService deathNoticeService) {
		this.deathNoticeService = deathNoticeService;
	}

	public DeathNotice getDeathNotice() {
		return deathNotice;
	}

	public void setDeathNotice(DeathNotice deathNotice) {
		this.deathNotice = deathNotice;
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
