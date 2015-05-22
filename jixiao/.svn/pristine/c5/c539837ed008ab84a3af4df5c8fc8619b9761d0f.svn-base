package com.hoyotech.prison.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hoyotech.prison.bean.DaiShou;
import com.hoyotech.prison.bean.Police;
import com.hoyotech.prison.bean.Prisoner;
import com.hoyotech.prison.log.LogFactory;
import com.hoyotech.prison.service.impl.DaiShouService;
import com.hoyotech.prison.service.impl.DictionaryService;
import com.hoyotech.prison.util.ConfigHelper;
import com.hoyotech.prison.util.ObjectUpdateUtil;
import com.hoyotech.prison.util.PrisonUtil;
import com.isa.pims.basic.ServletRequestUtils;

public class DaiShouAction {
	
	private DaiShouService daiShouService;
	private DictionaryService dictionaryService;
	private List<DaiShou> daishoulist;
	private DaiShou daiShou;
	private int pageNum;
	private int limit; 
	private int totalPage;
	private int totalNum;
	private String id;
	private String name; 
	private Date time; 

	private LogFactory log;
	private List<Prisoner> prisonerlist;
	private List<Police> policelist;
	
	public void selectPolice(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String prisonCode=PrisonUtil.getPrisonCode(request);
		policelist=dictionaryService.selectPolice(prisonCode);
	}
	
	/**
	 * 代收财务登记信息-打印（台账）
	 * **/
	public String print() {
		HttpServletRequest request=ServletActionContext.getRequest();
		pageNum = ServletRequestUtils.getInt(request, "page","1");
		limit = ServletRequestUtils.getInt(request, "limit","20");
		String prisonCode=PrisonUtil.getPrisonCode(request);
		daishoulist = daiShouService.list(name, time, pageNum, limit,prisonCode);
		totalNum=daiShouService.count(name, time,prisonCode);
		totalPage=(totalNum-1)/limit+1;
		return "ListPrint";
	}
	/**
	 * 查询所有代收财物登记的信息
	 * **/
	public String select() {
		HttpServletRequest request=ServletActionContext.getRequest();
		pageNum = ServletRequestUtils.getInt(request, "page","1");
		limit = ServletRequestUtils.getInt(request, "limit","20");
		String prisonCode=PrisonUtil.getPrisonCode(request);
		daishoulist = daiShouService.list(name, time, pageNum, limit,prisonCode);
		totalNum=daiShouService.count(name, time,prisonCode);
		totalPage=(totalNum-1)/limit+1;
		return "List";
	}
	
	/**
	 * 添加一条代收财物登记的信息
	 * **/
	public String add() {
		HttpServletRequest request = ServletActionContext.getRequest();
		daiShou.setPrisonCode(PrisonUtil.getPrisonCode(request));
		id = daiShouService.add(daiShou); //添加数据得到id
		
		// 添加日志
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "添加成功。";
		log.getInsertLogMessage(daiShou, config.getInsert(), operate, config.getDaishou(), config.getSucceed(), request);
		return "detail";
	}

	/**
	 * 查询一条代收财物登记的信息,返回到详细页面
	 * **/
	public String detail() {
		daiShou = daiShouService.detail(id);
		return "Detail";
	}
	
	/**
	 * 删除一条代收财物登记的信息
	 * **/
	public String delete() {
		daiShouService.delete(id);
		
		// 添加日志
		DaiShou object = new DaiShou();
		object.setId(id);
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "删除成功。";
		log.getModifyLogMessage(null, object, config.getDelete(), operate, config.getDaishou(), config.getSucceed(), request);
		return "select";
	}
	
	/**
	 * 修改一条代收财物登记的信息
	 * **/
	public String update() {
		DaiShou obj = daiShouService.detail(daiShou.getId());
		DaiShou old_obj = daiShouService.detail(daiShou.getId());
		ObjectUpdateUtil.compareProperty(daiShou, obj);
		
		daiShouService.update(obj);
		id=daiShou.getId();
		
		// 添加日志
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "修改成功。";
		log.getModifyLogMessage(obj, old_obj, config.getUpdate(), operate, config.getDaishou(), config.getSucceed(), request);
		return "detail";
	}
	
	/**
	 * 进入添加页面
	 * **/
	public String interAdd() {
		selectPolice();
		selectPrisoner();
		return "Add";
	}
	
	/**
	 * 进入修改页面
	 * **/
	public String interEdit() {
		selectPolice();
		selectPrisoner();
		daiShou=daiShouService.detail(id);
		return "Edit";
	}
	
	public void selectPrisoner(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String prisonCode=PrisonUtil.getPrisonCode(request);
		prisonerlist=dictionaryService.selectPrisoner(prisonCode);
	}
	
	public List<Police> getPolicelist() {
		return policelist;
	}

	public void setPolicelist(List<Police> policelist) {
		this.policelist = policelist;
	}

	public DictionaryService getDictionaryService() {
		return dictionaryService;
	}
	public void setDictionaryService(DictionaryService dictionaryService) {
		this.dictionaryService = dictionaryService;
	}
	public List<Prisoner> getPrisonerlist() {
		return prisonerlist;
	}
	public void setPrisonerlist(List<Prisoner> prisonerlist) {
		this.prisonerlist = prisonerlist;
	}
	public LogFactory getLog() {
		return log;
	}

	public void setLog(LogFactory log) {
		this.log = log;
	}

	public DaiShouService getDaiShouService() {
		return daiShouService;
	}

	public void setDaiShouService(DaiShouService daiShouService) {
		this.daiShouService = daiShouService;
	}

	public List<DaiShou> getDaishoulist() {
		return daishoulist;
	}

	public void setDaishoulist(List<DaiShou> daishoulist) {
		this.daishoulist = daishoulist;
	}

	public DaiShou getDaiShou() {
		return daiShou;
	}

	public void setDaiShou(DaiShou daiShou) {
		this.daiShou = daiShou;
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
