package com.hoyotech.prison.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hoyotech.prison.bean.DeepCrime;
import com.hoyotech.prison.bean.Prisoner;
import com.hoyotech.prison.log.LogFactory;
import com.hoyotech.prison.service.impl.DeepCrimeService;
import com.hoyotech.prison.service.impl.DictionaryService;
import com.hoyotech.prison.util.ConfigHelper;
import com.hoyotech.prison.util.ObjectUpdateUtil;
import com.hoyotech.prison.util.PrisonUtil;
import com.isa.pims.basic.ServletRequestUtils;

public class DeepCrimeAction {

	DeepCrimeService deepCrimeService;
	private List<DeepCrime> deepCrimelist;
	private DictionaryService dictionaryService;
	private DeepCrime deepCrime;
	private int pageNum;
	private int limit; 
	private int totalPage;
	private int totalNum;
	private String id;
	private String name; //姓名
	private	Date time;
	private String neixing;
	
	private LogFactory log;
	private List<Prisoner> prisonerlist;
	
	/**
	 * 深挖犯罪线索登记-打印（台账）
	 * **/
	public String print() {
		HttpServletRequest request=ServletActionContext.getRequest();
		pageNum = ServletRequestUtils.getInt(request, "page","1");
		limit = ServletRequestUtils.getInt(request, "limit","20");
		String prisonCode=PrisonUtil.getPrisonCode(request);
		deepCrimelist = deepCrimeService.list(name, time,neixing, pageNum, limit,prisonCode);
		totalNum=deepCrimeService.count(name, time,neixing,prisonCode);
		totalPage=(totalNum-1)/limit+1;
		return "ListPrint";
	}
	
	/**
	 * 查询所有深挖犯罪线索登记信息
	 * **/
	public String select() {
		HttpServletRequest request=ServletActionContext.getRequest();
		pageNum = ServletRequestUtils.getInt(request, "page","1");
		limit = ServletRequestUtils.getInt(request, "limit","20");
		String prisonCode=PrisonUtil.getPrisonCode(request);
		deepCrimelist = deepCrimeService.list(name, time,neixing, pageNum, limit,prisonCode);
		totalNum=deepCrimeService.count(name, time,neixing,prisonCode);
		totalPage=(totalNum-1)/limit+1;
		return "List";
	}
	
	/**
	 * 添加一条深挖犯罪线索登记信息
	 * **/
	public String add() {
		HttpServletRequest request = ServletActionContext.getRequest();
		deepCrime.setPrisonCode(PrisonUtil.getPrisonCode(request));
		id = deepCrimeService.add(deepCrime); //添加数据得到id
		
		// 添加日志
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "添加成功。";
		log.getInsertLogMessage(deepCrime, config.getInsert(), operate, config.getDeepCrime(), config.getSucceed(), request);
		return "detail";
	}

	/**
	 * 查询一条深挖犯罪线索登记信息,返回到详细页面
	 * **/
	public String detail() {
		deepCrime = deepCrimeService.detail(id);
		return "Detail";
	}
	
	/**
	 * 删除一条深挖犯罪线索登记信息
	 * **/
	public String delete() {
		deepCrimeService.delete(id);
		
		// 添加日志
		DeepCrime object = new DeepCrime();
		object.setId(id);
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "删除成功。";
		log.getModifyLogMessage(null, object, config.getDelete(), operate, config.getDeepCrime(), config.getSucceed(), request);
		return "select";
	}
	
	/**
	 * 修改一条深挖犯罪线索登记信息
	 * **/
	public String update() {
		DeepCrime obj = deepCrimeService.detail(deepCrime.getId());
		DeepCrime old_obj = deepCrimeService.detail(deepCrime.getId());
		ObjectUpdateUtil.compareProperty(deepCrime, obj);
		
		deepCrimeService.update(obj);
		id=deepCrime.getId();
		
		// 添加日志
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "修改成功。";
		log.getModifyLogMessage(obj, old_obj, config.getUpdate(), operate, config.getDeepCrime(), config.getSucceed(), request);
		return "detail";
	}
	
	/**
	 * 进入添加页面
	 * **/
	public String interAdd() {
		selectPrisoner();
		return "Add";
	}
	
	/**
	 * 进入修改页面
	 * **/
	public String interEdit() {
		selectPrisoner();
		deepCrime=deepCrimeService.detail(id);
		return "Edit";
	}

	public void selectPrisoner(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String prisonCode=PrisonUtil.getPrisonCode(request);
		prisonerlist=dictionaryService.selectPrisoner(prisonCode);
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

	public DeepCrimeService getDeepCrimeService() {
		return deepCrimeService;
	}

	public void setDeepCrimeService(DeepCrimeService deepCrimeService) {
		this.deepCrimeService = deepCrimeService;
	}

	public List<DeepCrime> getDeepCrimelist() {
		return deepCrimelist;
	}

	public void setDeepCrimelist(List<DeepCrime> deepCrimelist) {
		this.deepCrimelist = deepCrimelist;
	}

	public DeepCrime getDeepCrime() {
		return deepCrime;
	}

	public void setDeepCrime(DeepCrime deepCrime) {
		this.deepCrime = deepCrime;
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

	public String getNeixing() {
		return neixing;
	}

	public void setNeixing(String neixing) {
		this.neixing = neixing;
	}

	
	
	
}
