package com.hoyotech.prison.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hoyotech.prison.bean.Dictionary;
import com.hoyotech.prison.bean.ExecuteReturn;
import com.hoyotech.prison.bean.Prisoner;
import com.hoyotech.prison.log.LogFactory;
import com.hoyotech.prison.service.impl.DictionaryService;
import com.hoyotech.prison.service.impl.ExecuteReturnService;
import com.hoyotech.prison.service.impl.PrisonerService;
import com.hoyotech.prison.util.ConfigHelper;
import com.hoyotech.prison.util.ObjectUpdateUtil;
import com.hoyotech.prison.util.PrisonUtil;

/**
 * @author Hzibo
 *
 */
public class ExecuteReturnAction {

	PrisonerService prisonerServer;
	private Prisoner prisoner;
	DictionaryService dictionaryService;
	ExecuteReturnService exeReturnService;
	private List<ExecuteReturn> executelist;
	private ExecuteReturn exeReturn;
	private List<Prisoner> list;
	
	private String id;
	private String type;
	private String view;
	
	private LogFactory log;
	
	private List<Dictionary> dangerLevelList;
	
	public String doc(){
		exeReturn = exeReturnService.detail(id);
		return "doc";
	}
	
	/**
	 * 进入添加页面
	 * @return
	 */
	public String addUI(){
		prisoner = prisonerServer.detail(id);
		return "addUI";
	}

	/**
	 * 添加信息
	 * **/
	public String add() {
		HttpServletRequest request = ServletActionContext.getRequest();
		exeReturn.setPrisonCode(PrisonUtil.getPrisonCode(request));
		id = exeReturnService.add(exeReturn); // 添加数据得到id
		id = exeReturn.getPrisoner().getId();
		type = "executeReturn";
		
		// 添加日志
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "添加成功。";
		log.getInsertLogMessage(exeReturn, config.getInsert(), operate, config.getExecuteReturn(), config.getSucceed(), request);
		return "main";
	}

	/**
	 * 查询信息
	 * **/
	public String detail() {
		exeReturn = exeReturnService.detail(id);
		return "detail";
	}
	
	/**
	 * 根据被拘留人Id查详细信息
	 * @return
	 */
	public String detailByPrisoner(){
		exeReturn = exeReturnService.detailByPrisoner(id);
		return "detail";
	}

	/**
	 * 删除
	 * **/
	public String delete() {
		exeReturnService.delete(id);
		
		// 添加日志
		ExecuteReturn object = new ExecuteReturn();
		object.setId(id);
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "删除成功。";
		log.getModifyLogMessage(null, object, config.getDelete(), operate, config.getExecuteReturn(), config.getSucceed(), request);
		return "addUI";
	}

	/**
	 * 修改一条请假出所到期的信息
	 * **/
	public String update() {
		ExecuteReturn obj = exeReturnService.detail(exeReturn.getId());
		ExecuteReturn old_obj = exeReturnService.detail(exeReturn.getId());
		ObjectUpdateUtil.compareProperty(exeReturn, obj);
		
		exeReturnService.update(obj);
		id = exeReturn.getId();
		
		// 添加日志
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "修改成功。";
		log.getModifyLogMessage(obj, old_obj, config.getUpdate(), operate, config.getExecuteReturn(), config.getSucceed(), request);
		return "Detail";
	}
	
	/**
	 * 进入修改页面
	 * **/
	public String interEdit() {
		exeReturn = exeReturnService.detail(id);
		return "edit";
	}

	/**
	 * 修改审批意见
	 * **/
	public String examine() {
		exeReturnService.examineChange(id, view);
		
		// 添加日志
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "修改成功。审批状态修改为:"+view;
		log.getModifyLogMessage(null, null, config.getUpdate(), operate, config.getExecuteReturn(), config.getSucceed(), request);
		return "Detail";
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

	public DictionaryService getDictionaryService() {
		return dictionaryService;
	}

	public void setDictionaryService(DictionaryService dictionaryService) {
		this.dictionaryService = dictionaryService;
	}

	public ExecuteReturnService getExeReturnService() {
		return exeReturnService;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	public void setExeReturnService(ExecuteReturnService exeReturnService) {
		this.exeReturnService = exeReturnService;
	}

	public List<ExecuteReturn> getExecutelist() {
		return executelist;
	}

	public void setExecutelist(List<ExecuteReturn> executelist) {
		this.executelist = executelist;
	}

	public ExecuteReturn getExeReturn() {
		return exeReturn;
	}

	public void setExeReturn(ExecuteReturn exeReturn) {
		this.exeReturn = exeReturn;
	}

	public List<Prisoner> getList() {
		return list;
	}

	public void setList(List<Prisoner> list) {
		this.list = list;
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

	public List<Dictionary> getDangerLevelList() {
		return dangerLevelList;
	}

	public void setDangerLevelList(List<Dictionary> dangerLevelList) {
		this.dangerLevelList = dangerLevelList;
	}
}
