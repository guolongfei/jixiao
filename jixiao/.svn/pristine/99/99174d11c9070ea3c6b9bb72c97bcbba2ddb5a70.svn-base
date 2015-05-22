package com.hoyotech.prison.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hoyotech.prison.bean.SendExamine;
import com.hoyotech.prison.log.LogFactory;
import com.hoyotech.prison.service.impl.DictionaryService;
import com.hoyotech.prison.service.impl.SendExamineService;
import com.hoyotech.prison.util.ConfigHelper;
import com.hoyotech.prison.util.ObjectUpdateUtil;
import com.hoyotech.prison.util.PrisonUtil;

public class SendExamineAction {

	private SendExamineService sendExamineService;
	private DictionaryService dictionaryService;
	private SendExamine sendExamine;
	private String id;
	private String view;
	private String type;
	
	private LogFactory log;
	
	public String addUI(){
		return "addUI";
	}
	
	public String detail(){
		sendExamine = sendExamineService.detail(id);
		return "detail";
	}	
	
	public String detailByPrisoner(){
		sendExamine = sendExamineService.detailByPrisoner(id);
		return "detail";
	}
	
	/**
	 * 添加
	 * @return
	 */
	public String add(){
		HttpServletRequest request = ServletActionContext.getRequest();
		sendExamine.setPrisonCode(PrisonUtil.getPrisonCode(request));
		id = sendExamineService.add(sendExamine);
		id = sendExamine.getPrisoner().getId();
		type = "sendExamine";
		
		// 添加日志
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "添加成功。";
		log.getInsertLogMessage(sendExamine, config.getInsert(), operate, config.getSendExamine(), config.getSucceed(), request);
		return "main";
	}
	
	/**
	 * 进入修改页面
	 * **/
	public String interEdit() {
		sendExamine = sendExamineService.detail(id);
		return "edit";
	}
	
	/**
	 * 修改审批意见
	 * **/
	public String examine() {
		sendExamineService.examineChange(id, view);
		
		// 添加日志
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "修改成功。审批状态修改为:"+view;
		log.getModifyLogMessage(null, null, config.getUpdate(), operate, config.getSendExamine(), config.getSucceed(), request);
		return "Detail";
	}
	
	/**
	 * 修改信息
	 * **/
	public String update() {
		SendExamine obj = sendExamineService.detail(sendExamine.getId());
		SendExamine old_obj = sendExamineService.detail(sendExamine.getId());
		ObjectUpdateUtil.compareProperty(sendExamine, obj);
		sendExamineService.update(obj);
		id = sendExamine.getId();
		
		// 添加日志
		
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "修改成功。";
		log.getModifyLogMessage(obj, old_obj, config.getUpdate(), operate, config.getSendExamine(), config.getSucceed(), request);
		return "Detail";
	}
	
	public String doc(){
		sendExamine = sendExamineService.detail(id);
		return "doc";
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

	public DictionaryService getDictionaryService() {
		return dictionaryService;
	}

	public void setDictionaryService(DictionaryService dictionaryService) {
		this.dictionaryService = dictionaryService;
	}

	public SendExamineService getSendExamineService() {
		return sendExamineService;
	}

	public void setSendExamineService(SendExamineService sendExamineService) {
		this.sendExamineService = sendExamineService;
	}

	public SendExamine getSendExamine() {
		return sendExamine;
	}

	public void setSendExamine(SendExamine sendExamine) {
		this.sendExamine = sendExamine;
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
