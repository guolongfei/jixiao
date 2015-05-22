package com.hoyotech.prison.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hoyotech.prison.bean.Dictionary;
import com.hoyotech.prison.bean.OutDoctor;
import com.hoyotech.prison.bean.Police;
import com.hoyotech.prison.bean.Prisoner;
import com.hoyotech.prison.log.LogFactory;
import com.hoyotech.prison.service.impl.DictionaryService;
import com.hoyotech.prison.service.impl.OutDoctorService;
import com.hoyotech.prison.util.ConfigHelper;
import com.hoyotech.prison.util.ObjectUpdateUtil;
import com.hoyotech.prison.util.PrisonUtil;
import com.hoyotech.prison.util.Type;
import com.isa.pims.basic.ServletRequestUtils;

public class OutDoctorAction {

	OutDoctorService outDoctorService;
	private DictionaryService dictionaryService;
	private List<OutDoctor> outDoctorlist;
	private OutDoctor outDoctor;
	private int pageNum;
	private int limit; 
	private int totalPage;
	private int totalNum;
	private String id;
	private String name; //姓名
	private Date time; //职称
	
	private List<Dictionary> gender;
	private LogFactory log;
	private List<Prisoner> prisonerlist;
	private List<Police> policelist;
	
	public void selectPolice(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String prisonCode=PrisonUtil.getPrisonCode(request);
		policelist=dictionaryService.selectPolice(prisonCode);
	}
	
	/**
	 * 所外就医登记信息-打印（台账）
	 * **/
	public String print() {
		HttpServletRequest request=ServletActionContext.getRequest();
		pageNum = ServletRequestUtils.getInt(request, "page","1");
		limit = ServletRequestUtils.getInt(request, "limit","20");
		String prisonCode=PrisonUtil.getPrisonCode(request);
		outDoctorlist = outDoctorService.list(name, time, pageNum, limit,prisonCode);
		totalNum=outDoctorService.count(name, time,prisonCode);
		totalPage=(totalNum-1)/limit+1;
		return "ListPrint";
	}
	
	/**
	 * 查询所有出所就医登记的信息
	 * **/
	public String select() {
		HttpServletRequest request=ServletActionContext.getRequest();
		pageNum = ServletRequestUtils.getInt(request, "page","1");
		limit = ServletRequestUtils.getInt(request, "limit","20");
		String prisonCode=PrisonUtil.getPrisonCode(request);
		outDoctorlist = outDoctorService.list(name, time, pageNum, limit,prisonCode);
		totalNum=outDoctorService.count(name, time,prisonCode);
		totalPage=(totalNum-1)/limit+1;
		return "List";
	}
	
	/**
	 * 添加一条出所就医登记的信息
	 * **/
	public String add() {
		HttpServletRequest request = ServletActionContext.getRequest();
		outDoctor.setPrisonCode(PrisonUtil.getPrisonCode(request));
		id = outDoctorService.add(outDoctor); //添加数据得到id
		
		// 添加日志
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "添加成功。";
		log.getInsertLogMessage(outDoctor, config.getInsert(), operate, config.getOutDoctor(), config.getSucceed(), request);
		return "detail";
	}

	/**
	 * 查询一条出所就医登记的信息,返回到详细页面
	 * **/
	public String detail() {
		outDoctor = outDoctorService.detail(id);
		return "Detail";
	}
	
	/**
	 * 删除一条出所就医登记的信息
	 * **/
	public String delete() {
		outDoctorService.delete(id);
		
		// 添加日志
		OutDoctor object = new OutDoctor();
		object.setId(id);
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "删除成功。";
		log.getModifyLogMessage(null, object, config.getDelete(), operate, config.getOutDoctor(), config.getSucceed(), request);
		return "select";
	}
	
	/**
	 * 修改一条出所就医登记的信息
	 * **/
	public String update() {
		OutDoctor obj = outDoctorService.detail(outDoctor.getId());
		OutDoctor old_obj = outDoctorService.detail(outDoctor.getId());
		ObjectUpdateUtil.compareProperty(outDoctor, obj);
		
		outDoctorService.update(obj);
		id=outDoctor.getId();
		
		// 添加日志
		
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "修改成功。";
		log.getModifyLogMessage(obj, old_obj, config.getUpdate(), operate, config.getOutDoctor(), config.getSucceed(), request);
		return "detail";
	}
	
	/**
	 * 进入添加页面
	 * **/
	public String interAdd() {
		selectPrisoner();
		selectPolice();
		gender = dictionaryService.selectDictionary(Type.GENDERTYPE);
		return "Add";
	}
	
	/**
	 * 进入修改页面
	 * **/
	public String interEdit() {
		selectPrisoner();
		selectPolice();
		gender = dictionaryService.selectDictionary(Type.GENDERTYPE);
		outDoctor=outDoctorService.detail(id);
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

	public OutDoctorService getOutDoctorService() {
		return outDoctorService;
	}

	public void setOutDoctorService(OutDoctorService outDoctorService) {
		this.outDoctorService = outDoctorService;
	}

	public List<OutDoctor> getOutDoctorlist() {
		return outDoctorlist;
	}

	public void setOutDoctorlist(List<OutDoctor> outDoctorlist) {
		this.outDoctorlist = outDoctorlist;
	}

	public OutDoctor getOutDoctor() {
		return outDoctor;
	}

	public void setOutDoctor(OutDoctor outDoctor) {
		this.outDoctor = outDoctor;
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

	public DictionaryService getDictionaryService() {
		return dictionaryService;
	}

	public void setDictionaryService(DictionaryService dictionaryService) {
		this.dictionaryService = dictionaryService;
	}

	
	
}
