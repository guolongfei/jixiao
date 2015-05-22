package com.hoyotech.prison.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hoyotech.prison.bean.Dictionary;
import com.hoyotech.prison.bean.Police;
import com.hoyotech.prison.bean.Reception;
import com.hoyotech.prison.log.LogFactory;
import com.hoyotech.prison.service.impl.DictionaryService;
import com.hoyotech.prison.service.impl.ReceptionService;
import com.hoyotech.prison.util.ConfigHelper;
import com.hoyotech.prison.util.ObjectUpdateUtil;
import com.hoyotech.prison.util.PrisonUtil;
import com.hoyotech.prison.util.Type;
import com.isa.pims.basic.ServletRequestUtils;

public class ReceptionAction {

	private DictionaryService dictionaryService;
	private ReceptionService receptionService;
	private List<Reception> receptionlist;
	private Reception reception;
	private int pageNum;
	private int limit; 
	private int totalPage;
	private int totalNum;
	private String id ;
	private String name; //姓名
	private Date time; 
	
	private LogFactory log;
	private List<Dictionary> gender;
	private List<Police> policelist;
	
	/**
	 * 所长接待记录信息-打印（台账）
	 * **/
	public String print() {
		reception=receptionService.detail(id);

		return "ListPrint";
	}
	
	public void selectPolice(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String prisonCode=PrisonUtil.getPrisonCode(request);
		policelist=dictionaryService.selectPolice(prisonCode);
	}
	
	/**
	 * 查询所有所长接待记录的信息
	 * **/
	public String select() {
		HttpServletRequest request=ServletActionContext.getRequest();
		pageNum = ServletRequestUtils.getInt(request, "page","1");
		limit = ServletRequestUtils.getInt(request, "limit","20");
		String prisonCode=PrisonUtil.getPrisonCode(request);
		receptionlist = receptionService.list(name, time, pageNum, limit,prisonCode);
		totalNum=receptionService.count(name, time,prisonCode);
		totalPage=(totalNum-1)/limit+1;
		return "List";
	}
	
	/**
	 * 添加一条所长接待记录的信息
	 * **/
	public String add() {
		HttpServletRequest request = ServletActionContext.getRequest();
		reception.setPrisonCode(PrisonUtil.getPrisonCode(request));
		id = receptionService.add(reception); //添加数据得到id
		
		// 添加日志
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "添加成功。";
		log.getInsertLogMessage(reception, config.getInsert(), operate, config.getReception(), config.getSucceed(), request);
		return "detail";
	}

	/**
	 * 查询一条所长接待记录的信息,返回到详细页面
	 * **/
	public String detail() {
		reception=receptionService.detail(id);
		return "Detail";
	}
	
	/**
	 * 删除一条所长接待记录的信息
	 * **/
	public String delete() {
		receptionService.delete(id);
		
		// 添加日志
		Reception object = new Reception();
		object.setId(id);
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "删除成功。";
		log.getModifyLogMessage(null, object, config.getDelete(), operate, config.getReception(), config.getSucceed(), request);
		return "select";
	}
	
	/**
	 * 修改一条所长接待记录
	 * **/
	public String update() {
		Reception obj = receptionService.detail(reception.getId());
		Reception old_obj = receptionService.detail(reception.getId());
		ObjectUpdateUtil.compareProperty(reception, obj);
		
		receptionService.update(obj);
		id=reception.getId();
		
		// 添加日志
		
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "修改成功。";
		log.getModifyLogMessage(obj, old_obj, config.getUpdate(), operate, config.getReception(), config.getSucceed(), request);
		return "detail";
	}
	
	/**
	 * 进入添加页面
	 * **/
	public String interAdd() {
		selectPolice();
		gender = dictionaryService.selectDictionary(Type.GENDERTYPE);
		return "Add";
	}
	
	/**
	 * 进入修改页面
	 * **/
	public String interEdit() {
		selectPolice();
		gender = dictionaryService.selectDictionary(Type.GENDERTYPE);
		reception=receptionService.detail(id);
		return "Edit";
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

	public ReceptionService getReceptionService() {
		return receptionService;
	}

	public void setReceptionService(ReceptionService receptionService) {
		this.receptionService = receptionService;
	}

	public List<Reception> getReceptionlist() {
		return receptionlist;
	}

	public void setReceptionlist(List<Reception> receptionlist) {
		this.receptionlist = receptionlist;
	}

	public Reception getReception() {
		return reception;
	}

	public void setReception(Reception reception) {
		this.reception = reception;
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

	public List<Dictionary> getGender() {
		return gender;
	}

	public void setGender(List<Dictionary> gender) {
		this.gender = gender;
	}

	
	
}
