package com.hoyotech.prison.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hoyotech.prison.bean.Dictionary;
import com.hoyotech.prison.bean.Doctor;
import com.hoyotech.prison.bean.Medical;
import com.hoyotech.prison.bean.Prisoner;
import com.hoyotech.prison.log.LogFactory;
import com.hoyotech.prison.service.impl.DictionaryService;
import com.hoyotech.prison.service.impl.DoctorService;
import com.hoyotech.prison.util.ConfigHelper;
import com.hoyotech.prison.util.ObjectUpdateUtil;
import com.hoyotech.prison.util.PrisonUtil;
import com.hoyotech.prison.util.Type;
import com.isa.pims.basic.ServletRequestUtils;

public class DoctorAction {

	DoctorService doctorService;
	private DictionaryService dictionaryService;
	private List<Doctor> doctorlist;
	private Doctor doctor;
	private int pageNum;
	private int limit; 
	private int totalPage;
	private int totalNum;
	private String id;
	private String name; //姓名
	private Date time;
	
	private List<Dictionary> gender;
	private LogFactory log;
	private List<Prisoner> prisonerlist;
	private List<Medical> medicallist;
	
	/**
	 * 所内就医登记信息-打印（台账）
	 * **/
	public String print() {
		HttpServletRequest request=ServletActionContext.getRequest();
		pageNum = ServletRequestUtils.getInt(request, "page","1");
		limit = ServletRequestUtils.getInt(request, "limit","20");
		String prisonCode=PrisonUtil.getPrisonCode(request);
		doctorlist = doctorService.list(name, time, pageNum, limit,prisonCode);
		totalNum=doctorService.count(name, time,prisonCode);
		totalPage=(totalNum-1)/limit+1;
		return "ListPrint";
	}
	
	/**
	 * 查询所有所内就医的信息
	 * **/
	public String select() {
		HttpServletRequest request=ServletActionContext.getRequest();
		pageNum = ServletRequestUtils.getInt(request, "page","1");
		limit = ServletRequestUtils.getInt(request, "limit","20");
		String prisonCode=PrisonUtil.getPrisonCode(request);
		doctorlist = doctorService.list(name, time, pageNum, limit,prisonCode);
		totalNum=doctorService.count(name, time,prisonCode);
		totalPage=(totalNum-1)/limit+1;
		return "List";
	}
	
	/**
	 * 添加一条所内就医登记的信息
	 * **/
	public String add() {
		HttpServletRequest request = ServletActionContext.getRequest();
		doctor.setPrisonCode(PrisonUtil.getPrisonCode(request));
		id = doctorService.add(doctor); //添加数据得到id
		
		// 添加日志
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "添加成功。";
		log.getInsertLogMessage(doctor, config.getInsert(), operate, config.getDoctor(), config.getSucceed(), request);
		return "detail";
	}

	/**
	 * 查询一条所内就医登记的信息,返回到详细页面
	 * **/
	public String detail() {
		doctor = doctorService.detail(id);
		return "Detail";
	}
	
	/**
	 * 删除一条所内就医登记的信息
	 * **/
	public String delete() {
		doctorService.delete(id);
		
		// 添加日志
		Doctor object = new Doctor();
		object.setId(id);
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "删除成功。";
		log.getModifyLogMessage(null, object, config.getDelete(), operate, config.getDoctor(), config.getSucceed(), request);
		return "select";
	}
	
	/**
	 * 修改一条所内就医登记的信息
	 * **/
	public String update() {
		Doctor obj = doctorService.detail(doctor.getId());
		Doctor old_obj = doctorService.detail(doctor.getId());
		ObjectUpdateUtil.compareProperty(doctor, obj);
		
		doctorService.update(obj);
		id=doctor.getId();
		
		// 添加日志
		
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "修改成功。";
		log.getModifyLogMessage(obj, old_obj, config.getUpdate(), operate, config.getDoctor(), config.getSucceed(), request);
		return "detail";
	}
	
	/**
	 * 进入添加页面
	 * **/
	public String interAdd() {
		selectPrisoner();
		gender = dictionaryService.selectDictionary(Type.GENDERTYPE);
		return "Add";
	}
	
	/**
	 * 进入修改页面
	 * **/
	public String interEdit() {
		selectPrisoner();
		doctor = doctorService.detail(id);
		gender = dictionaryService.selectDictionary(Type.GENDERTYPE);
		return "Edit";
	}
	
	public void selectPrisoner(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String prisonCode=PrisonUtil.getPrisonCode(request);
		prisonerlist=dictionaryService.selectPrisoner(prisonCode);
		medicallist=dictionaryService.selectMedical(prisonCode);
	}

	
	public List<Medical> getMedicallist() {
		return medicallist;
	}

	public void setMedicallist(List<Medical> medicallist) {
		this.medicallist = medicallist;
	}

	public DoctorService getDoctorService() {
		return doctorService;
	}

	public void setDoctorService(DoctorService doctorService) {
		this.doctorService = doctorService;
	}

	public DictionaryService getDictionaryService() {
		return dictionaryService;
	}

	public void setDictionaryService(DictionaryService dictionaryService) {
		this.dictionaryService = dictionaryService;
	}

	public List<Doctor> getDoctorlist() {
		return doctorlist;
	}

	public void setDoctorlist(List<Doctor> doctorlist) {
		this.doctorlist = doctorlist;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
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

	public LogFactory getLog() {
		return log;
	}

	public void setLog(LogFactory log) {
		this.log = log;
	}

	public List<Prisoner> getPrisonerlist() {
		return prisonerlist;
	}

	public void setPrisonerlist(List<Prisoner> prisonerlist) {
		this.prisonerlist = prisonerlist;
	}
	
	
}
