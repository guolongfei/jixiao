package com.hoyotech.prison.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hoyotech.prison.bean.Prisoner;
import com.hoyotech.prison.bean.WorkUnit;
import com.hoyotech.prison.service.impl.DictionaryService;
import com.hoyotech.prison.service.impl.OutRegisterService;
import com.hoyotech.prison.util.PrisonUtil;
import com.isa.pims.basic.ServletRequestUtils;

public class OutRegister {

	OutRegisterService outRegiService;
	private DictionaryService dictionaryService;
	private List<Prisoner> outlist;
	private Prisoner outprison;
	private int pageNum;
	private int limit; 
	private int totalPage;
	private int totalNum;
	private String id;
	
	private String name;
	private Date time;
	private Date inTime;
	private Date birthday;
	private String workUnit;
	
	private List<WorkUnit> workUnits;
	
	/**
	 * 查询出所登记信息（台账）
	 * **/
	public String select() {
		
		HttpServletRequest request=ServletActionContext.getRequest();
		pageNum = ServletRequestUtils.getInt(request, "page","1");
		limit = ServletRequestUtils.getInt(request, "limit","20");
		String prisonCode = PrisonUtil.getPrisonCode(request);
		
		outlist=outRegiService.list(name,time,birthday,workUnit,inTime,pageNum, limit,prisonCode);
		totalNum=outRegiService.count(name,time,birthday,workUnit,inTime,prisonCode);
		totalPage=(totalNum-1)/limit+1;
		//查询办案单位
		workUnits= dictionaryService.selectWorkUnit(prisonCode);
		return "List";
	}
	
	/**
	 * 出入所登记信息-打印（台账）
	 * **/
	public String print() {
		HttpServletRequest request=ServletActionContext.getRequest();
		pageNum = ServletRequestUtils.getInt(request, "page","1");
		limit = ServletRequestUtils.getInt(request, "limit","20");
		String prisonCode = PrisonUtil.getPrisonCode(request);
		outlist=outRegiService.list(name,time,birthday,workUnit,inTime,pageNum, limit,prisonCode);
		totalNum=outRegiService.count(name,time,birthday,workUnit,inTime,prisonCode);
		totalPage=(totalNum-1)/limit+1;
		//查询办案单位
		workUnits= dictionaryService.selectWorkUnit(prisonCode);
		return "ListPrint";
	}

	/**
	 * 查询一条出所登记信息（台账）,返回到详细页面
	 * **/
	public String detail() {
		outprison=outRegiService.detail(id);
		return "Detail";
	}

	
	public Date getInTime() {
		return inTime;
	}

	public void setInTime(Date inTime) {
		this.inTime = inTime;
	}

	public DictionaryService getDictionaryService() {
		return dictionaryService;
	}

	public void setDictionaryService(DictionaryService dictionaryService) {
		this.dictionaryService = dictionaryService;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getWorkUnit() {
		return workUnit;
	}

	public void setWorkUnit(String workUnit) {
		this.workUnit = workUnit;
	}

	public List<WorkUnit> getWorkUnits() {
		return workUnits;
	}

	public void setWorkUnits(List<WorkUnit> workUnits) {
		this.workUnits = workUnits;
	}

	public OutRegisterService getOutRegiService() {
		return outRegiService;
	}

	public void setOutRegiService(OutRegisterService outRegiService) {
		this.outRegiService = outRegiService;
	}

	public List<Prisoner> getOutlist() {
		return outlist;
	}

	public void setOutlist(List<Prisoner> outlist) {
		this.outlist = outlist;
	}

	public Prisoner getOutprison() {
		return outprison;
	}

	public void setOutprison(Prisoner outprison) {
		this.outprison = outprison;
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

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	
	
}
