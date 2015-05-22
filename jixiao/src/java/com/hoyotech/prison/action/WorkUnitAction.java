package com.hoyotech.prison.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hoyotech.prison.bean.WorkUnit;
import com.hoyotech.prison.log.LogFactory;
import com.hoyotech.prison.service.impl.WorkUnitService;
import com.hoyotech.prison.util.ConfigHelper;
import com.hoyotech.prison.util.ObjectUpdateUtil;
import com.hoyotech.prison.util.PrisonUtil;
import com.isa.pims.basic.ServletRequestUtils;

public class WorkUnitAction {

	private WorkUnitService workUnitService;
	private List<WorkUnit> workUnitlist;
	private WorkUnit workUnit;
	private int pageNum;
	private int limit; 
	private int totalPage;
	private int totalNum;
	private String id;
	
	private String unit;
	private LogFactory log;
	
	
	
	/**
	 * 查询所有办案单位的信息
	 * **/
	public String select() {
		HttpServletRequest request=ServletActionContext.getRequest();
		pageNum = ServletRequestUtils.getInt(request, "page","1");
		limit = ServletRequestUtils.getInt(request, "limit","20");
		String prisonCode=PrisonUtil.getPrisonCode(request);
		workUnitlist = workUnitService.list(unit, pageNum, limit,prisonCode);
		totalNum=workUnitService.count(unit,prisonCode);
		totalPage=(totalNum-1)/limit+1;
		return "List";
	}
	
	/**
	 * 添加一条办案单位的信息
	 * **/
	public String add() {
		HttpServletRequest request = ServletActionContext.getRequest();
		workUnit.setPrisonCode(PrisonUtil.getPrisonCode(request));
		id = workUnitService.add(workUnit); //添加数据得到id
		
		// 添加日志
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "添加成功。";
		log.getInsertLogMessage(workUnit, config.getInsert(), operate, config.getWorkUnit(), config.getSucceed(), request);
		return "detail";
	}

	/**
	 * 查询一条办案单位的信息,返回到详细页面
	 * **/
	public String detail() {
		workUnit=workUnitService.detail(id);
		return "Detail";
	}
	
	/**
	 * 删除一条办案单位的信息
	 * **/
	public String delete() {
		workUnitService.delete(id);
		
		// 添加日志
		WorkUnit object = new WorkUnit();
		object.setId(id);
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "删除成功。";
		log.getModifyLogMessage(null, object, config.getDelete(), operate, config.getWorkUnit(), config.getSucceed(), request);
		return "select";
	}
	
	/**
	 * 修改一条办案单位
	 * **/
	public String update() {
		WorkUnit obj = workUnitService.detail(workUnit.getId());
		WorkUnit old_obj = workUnitService.detail(workUnit.getId());
		ObjectUpdateUtil.compareProperty(workUnit, obj);
		
		workUnitService.update(obj);
		id=workUnit.getId();
		
		// 添加日志
		
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "修改成功。";
		log.getModifyLogMessage(obj, old_obj, config.getUpdate(), operate, config.getWorkUnit(), config.getSucceed(), request);
		return "detail";
	}
	
	/**
	 * 进入添加页面
	 * **/
	public String interAdd() {
		selectParentUnit();
		return "Add";
	}
	
	/**
	 * 进入修改页面
	 * **/
	public String interEdit() {
		selectParentUnit();
		workUnit=workUnitService.detail(id);
		return "Edit";
	}
	
	public void selectParentUnit(){
		HttpServletRequest request=ServletActionContext.getRequest();
		String prisonCode=PrisonUtil.getPrisonCode(request);
		workUnitlist = workUnitService.highWorkunit(prisonCode);
	}
	
	
	public LogFactory getLog() {
		return log;
	}

	public void setLog(LogFactory log) {
		this.log = log;
	}

	public WorkUnitService getWorkUnitService() {
		return workUnitService;
	}

	public void setWorkUnitService(WorkUnitService workUnitService) {
		this.workUnitService = workUnitService;
	}

	public List<WorkUnit> getWorkUnitlist() {
		return workUnitlist;
	}

	public void setWorkUnitlist(List<WorkUnit> workUnitlist) {
		this.workUnitlist = workUnitlist;
	}

	public WorkUnit getWorkUnit() {
		return workUnit;
	}

	public void setWorkUnit(WorkUnit workUnit) {
		this.workUnit = workUnit;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
	
}
