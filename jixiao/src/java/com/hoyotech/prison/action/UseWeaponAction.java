package com.hoyotech.prison.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hoyotech.prison.bean.Prisoner;
import com.hoyotech.prison.bean.UseWeapon;
import com.hoyotech.prison.log.LogFactory;
import com.hoyotech.prison.service.impl.DictionaryService;
import com.hoyotech.prison.service.impl.PrisonerService;
import com.hoyotech.prison.service.impl.UseWeaponService;
import com.hoyotech.prison.util.ConfigHelper;
import com.hoyotech.prison.util.ObjectUpdateUtil;
import com.hoyotech.prison.util.PrisonUtil;

public class UseWeaponAction {

	PrisonerService prisonerServer;
	DictionaryService dictionaryService;
	UseWeaponService useWeaponService;
	private List<UseWeapon> list;
	private Prisoner prisoner;
	private UseWeapon useWeapon;
	private String id;
	private String view;
	private String type;
	
	private LogFactory log;
	
	public String select(){
		list = useWeaponService.list(id);
		return "list";
	}
	
	public String doc(){
		useWeapon = useWeaponService.detail(id);
		return "doc";
	}

	/**
	 * 添加一条使用警械审批的信息
	 * **/
	public String add() {
		
		HttpServletRequest request = ServletActionContext.getRequest();
		useWeapon.setPrisonCode(PrisonUtil.getPrisonCode(request));
		id = useWeaponService.add(useWeapon); // 添加数据得到id
		id = useWeapon.getPrisoner().getId();
		type = "useWeapon";
		
		// 添加日志
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "添加成功。";
		log.getInsertLogMessage(useWeapon, config.getInsert(), operate, config.getUseWeapon(), config.getSucceed(), request);
		return "main";
	}

	/**
	 * 查询一条使用警械审批的信息
	 * **/
	public String detail() {
		useWeapon = useWeaponService.detail(id);
		return "detail";
	}

	public String detailByPrisoner(){
		useWeapon = useWeaponService.detailByPrisoner(id);
		return "detail";
	}
	
	/**
	 * 删除一条使用警械审批的信息
	 * **/
	public String delete() {
		useWeaponService.delete(id);
		
		// 添加日志
		UseWeapon object = new UseWeapon();
		object.setId(id);
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "删除成功。";
		log.getModifyLogMessage(null, object, config.getDelete(), operate, config.getUseWeapon(), config.getSucceed(), request);
		return "select";
	}

	/**
	 * 修改一条使用警械审批的信息
	 * **/
	public String update() {
		UseWeapon obj = useWeaponService.detail(useWeapon.getId());
		UseWeapon old_obj = useWeaponService.detail(useWeapon.getId());
		ObjectUpdateUtil.compareProperty(useWeapon, obj);
		useWeaponService.update(obj);
		id = useWeapon.getId();
		
		// 添加日志
		
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "修改成功。";
		log.getModifyLogMessage(obj, old_obj, config.getUpdate(), operate, config.getUseWeapon(), config.getSucceed(), request);
		return "Detail";
	}

	/**
	 * 进入添加页面
	 * **/
	public String interAdd() {
		prisoner = prisonerServer.detail(id);
		return "addUI";
	}

	
	/**
	 * 进入修改页面
	 * **/
	public String interEdit() {
		useWeapon = useWeaponService.detail(id);
		return "edit";
	}
	/**
	 * 修改审批意见
	 * **/
	public String examine() {
		useWeaponService.examineChange(id, view);
		
		// 添加日志
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "修改成功。审批状态修改为:"+view;
		log.getModifyLogMessage(null, null, config.getUpdate(), operate, config.getUseWeapon(), config.getSucceed(), request);
		return "Detail";
	}

	public UseWeapon getUseWeapon() {
		return useWeapon;
	}

	public void setUseWeapon(UseWeapon useWeapon) {
		this.useWeapon = useWeapon;
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

	public UseWeaponService getUseWeaponService() {
		return useWeaponService;
	}

	public void setUseWeaponService(UseWeaponService useWeaponService) {
		this.useWeaponService = useWeaponService;
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

	public List<UseWeapon> getList() {
		return list;
	}

	public void setList(List<UseWeapon> list) {
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
