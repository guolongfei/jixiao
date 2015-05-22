package com.hoyotech.prison.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hoyotech.prison.bean.Inspect;
import com.hoyotech.prison.log.LogFactory;
import com.hoyotech.prison.service.impl.InspectService;
import com.hoyotech.prison.util.ConfigHelper;
import com.hoyotech.prison.util.ObjectUpdateUtil;
import com.hoyotech.prison.util.PrisonUtil;
import com.isa.pims.basic.ServletRequestUtils;

public class InspectAction {

	private InspectService inspectService;
	private List<Inspect> inspectlist;
	private Inspect inspect;
	private int pageNum;
	private int limit; 
	private int totalPage;
	private int totalNum;
	private String id;
	private String name; //姓名
	private String titles; //职称
	private String workstatus; //工作状态
	private String gender; //性别
	
	private LogFactory log;
	
	/**
	 * 视察记录登记信息-打印（台账）
	 * **/
	public String print() {
		inspect=inspectService.detail(id);

		return "ListPrint";
	}
	
	/**
	 * 查询所有视察检查记录的信息
	 * **/
	public String select() {
		HttpServletRequest request=ServletActionContext.getRequest();
		pageNum = ServletRequestUtils.getInt(request, "page","1");
		limit = ServletRequestUtils.getInt(request, "limit","20");
		String prisonCode=PrisonUtil.getPrisonCode(request);
		inspectlist = inspectService.list(name, titles, workstatus, gender, pageNum, limit,prisonCode);
		totalNum=inspectService.count(name, titles, workstatus, gender,prisonCode);
		totalPage=(totalNum-1)/limit+1;
		return "List";
	}
	
	/**
	 * 添加一条视察检查记录的信息
	 * **/
	public String add() {
		HttpServletRequest request = ServletActionContext.getRequest();
		inspect.setPrisonCode(PrisonUtil.getPrisonCode(request));
		id = inspectService.add(inspect); //添加数据得到id
		
		// 添加日志
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "添加成功。";
		log.getInsertLogMessage(inspect, config.getInsert(), operate, config.getInspect(), config.getSucceed(), request);
		return "detail";
	}

	/**
	 * 查询一条视察检查记录的信息,返回到详细页面
	 * **/
	public String detail() {
		inspect=inspectService.detail(id);
		return "Detail";
	}
	
	/**
	 * 删除一条视察检查记录的信息
	 * **/
	public String delete() {
		inspectService.delete(id);
		
		// 添加日志
		Inspect object = new Inspect();
		object.setId(id);
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "删除成功。";
		log.getModifyLogMessage(null, object, config.getDelete(), operate, config.getInspect(), config.getSucceed(), request);
		return "select";
	}
	
	/**
	 * 修改一条视察检查记录
	 * **/
	public String update() {
		Inspect obj = inspectService.detail(inspect.getId());
		Inspect old_obj = inspectService.detail(inspect.getId());
		ObjectUpdateUtil.compareProperty(inspect, obj);
		inspectService.update(obj);
		id=inspect.getId();
		
		// 添加日志
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "修改成功。";
		log.getModifyLogMessage(obj, old_obj, config.getUpdate(), operate, config.getInspect(), config.getSucceed(), request);
		return "detail";
	}
	
	/**
	 * 进入添加页面
	 * **/
	public String interAdd() {
		return "Add";
	}
	
	/**
	 * 进入修改页面
	 * **/
	public String interEdit() {
		inspect=inspectService.detail(id);
		return "Edit";
	}
	
	public LogFactory getLog() {
		return log;
	}

	public void setLog(LogFactory log) {
		this.log = log;
	}

	public InspectService getInspectService() {
		return inspectService;
	}

	public void setInspectService(InspectService inspectService) {
		this.inspectService = inspectService;
	}

	public List<Inspect> getInspectlist() {
		return inspectlist;
	}

	public void setInspectlist(List<Inspect> inspectlist) {
		this.inspectlist = inspectlist;
	}

	public Inspect getInspect() {
		return inspect;
	}

	public void setInspect(Inspect inspect) {
		this.inspect = inspect;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitles() {
		return titles;
	}

	public void setTitles(String titles) {
		this.titles = titles;
	}

	public String getWorkstatus() {
		return workstatus;
	}

	public void setWorkstatus(String workstatus) {
		this.workstatus = workstatus;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	
}
