package com.hoyotech.prison.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hoyotech.prison.bean.JiangCheng;
import com.hoyotech.prison.bean.Police;
import com.hoyotech.prison.bean.Prisoner;
import com.hoyotech.prison.log.LogFactory;
import com.hoyotech.prison.service.impl.DictionaryService;
import com.hoyotech.prison.service.impl.JiangChengService;
import com.hoyotech.prison.service.impl.PrisonerService;
import com.hoyotech.prison.util.ConfigHelper;
import com.hoyotech.prison.util.ObjectUpdateUtil;
import com.hoyotech.prison.util.PrisonUtil;

public class JiangchengAction {

	private PrisonerService prisonerServer;
	DictionaryService dictionaryService;
	private Prisoner prisoner;
	private JiangChengService jiangchengService;
	private List<JiangCheng> jiangchengs;
	private JiangCheng jiangcheng;
	private String id;
	private String view;
	private String type;

	private LogFactory log;
	private List<Police> policelist;
	
	public String doc(){
		jiangcheng = jiangchengService.detail(id);
		return "doc";
	}
		
	public void selectPolice(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String prisonCode=PrisonUtil.getPrisonCode(request);
		policelist=dictionaryService.selectPolice(prisonCode);
	}
	
	/**
	 * 查询所有奖惩登记的信息
	 * **/
	public String select() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String prisonCode=PrisonUtil.getPrisonCode(request);
		jiangchengs = jiangchengService.list(id, prisonCode);
		return "list";
	}

	/**
	 * 添加一条奖惩登记的信息
	 * **/
	public String add() {
		HttpServletRequest request = ServletActionContext.getRequest();
		jiangcheng.setPrisonCode(PrisonUtil.getPrisonCode(request));
		id = jiangchengService.add(jiangcheng); // 添加数据得到id
		id = jiangcheng.getPrisoner().getId();
		type = "jiangcheng";
		
		// 添加日志
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "添加成功。";
		log.getInsertLogMessage(jiangcheng, config.getInsert(), operate, config.getJiangcheng(), config.getSucceed(), request);
		return "main";
	}

	/**
	 * 查询一条奖惩登记的信息
	 * **/
	public String detail() {
		jiangcheng = jiangchengService.detail(id);
		return "detail";
	}

	/**
	 * 删除一条奖惩登记的信息
	 * **/
	public String delete() {
		jiangchengService.delete(id);
		
		JiangCheng object = new JiangCheng();
		object.setId(id);
		// 添加日志
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "删除成功。";
		log.getModifyLogMessage(null, object, config.getDelete(), operate, config.getArraign(), config.getSucceed(), request);
		return "select";
	}

	public String detailByPrisoner(){
		jiangcheng = jiangchengService.detailByPrisoner(id);
		return "detail";
	}
	
	/**
	 * 修改一条奖惩登记的信息
	 * **/
	public String update() {
		JiangCheng obj = jiangchengService.detail(jiangcheng.getId());
		JiangCheng old_obj = jiangchengService.detail(jiangcheng.getId());
		ObjectUpdateUtil.compareProperty(jiangcheng, obj);
		jiangchengService.update(obj);
		id = jiangcheng.getId();
		
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
		jiangcheng = jiangchengService.detail(id);
		return "edit";
	}
	/**
	 * 修改审批意见
	 * **/
	public String examine() {
		jiangchengService.examineChange(id, view);
		
		// 添加日志
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "修改成功。审批状态修改为:"+view;
		log.getModifyLogMessage(null, null, config.getUpdate(), operate, config.getArraign(), config.getSucceed(), request);
		return "Detail";
	}
	
	public DictionaryService getDictionaryService() {
		return dictionaryService;
	}

	public void setDictionaryService(DictionaryService dictionaryService) {
		this.dictionaryService = dictionaryService;
	}

	public List<Police> getPolicelist() {
		return policelist;
	}

	public void setPolicelist(List<Police> policelist) {
		this.policelist = policelist;
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

	public JiangChengService getJiangchengService() {
		return jiangchengService;
	}

	public void setJiangchengService(JiangChengService jiangchengService) {
		this.jiangchengService = jiangchengService;
	}

	public List<JiangCheng> getJiangchengs() {
		return jiangchengs;
	}

	public void setJiangchengs(List<JiangCheng> jiangchengs) {
		this.jiangchengs = jiangchengs;
	}

	public JiangCheng getJiangcheng() {
		return jiangcheng;
	}

	public void setJiangcheng(JiangCheng jiangcheng) {
		this.jiangcheng = jiangcheng;
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

	
}
