package com.hoyotech.prison.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hoyotech.prison.bean.Dictionary;
import com.hoyotech.prison.bean.Police;
import com.hoyotech.prison.bean.TalkEducation;
import com.hoyotech.prison.log.LogFactory;
import com.hoyotech.prison.service.impl.DictionaryService;
import com.hoyotech.prison.service.impl.TalkEducationService;
import com.hoyotech.prison.util.ConfigHelper;
import com.hoyotech.prison.util.ObjectUpdateUtil;
import com.hoyotech.prison.util.PrisonUtil;
import com.hoyotech.prison.util.Type;
import com.isa.pims.basic.ServletRequestUtils;

public class TalkEducationAction {
	private TalkEducationService talkEducationService;
	private DictionaryService dictionaryService;
	private List<TalkEducation> talkEducationlist;
	private TalkEducation talkEducation;
	private int pageNum;
	private int limit; 
	private int totalPage;
	private int totalNum;
	private String id;
	private String talker; //姓名
	private Date time; //职称
	
	private List<Dictionary> gender;
	private LogFactory log;
	private List<Police> policelist;
	
	public void selectPolice(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String prisonCode=PrisonUtil.getPrisonCode(request);
		policelist=dictionaryService.selectPolice(prisonCode);
	}
	
	/**
	 * 谈话教育记录信息-打印（台账）
	 * **/
	public String print() {
		talkEducation=talkEducationService.detail(id);

		return "ListPrint";
	}
	
	/**
	 * 查询所有谈话教育记录的信息
	 * **/
	public String select() {
		HttpServletRequest request=ServletActionContext.getRequest();
		pageNum = ServletRequestUtils.getInt(request, "page","1");
		limit = ServletRequestUtils.getInt(request, "limit","20");
		String prisonCode=PrisonUtil.getPrisonCode(request);
		talkEducationlist = talkEducationService.list(talker, time, pageNum, limit,prisonCode);
		totalNum=talkEducationService.count(talker, time,prisonCode);
		totalPage=(totalNum-1)/limit+1;
		return "List";
	}
	
	/**
	 * 添加一条谈话教育记录的信息
	 * **/
	public String add() {
		HttpServletRequest request = ServletActionContext.getRequest();
		talkEducation.setPrisonCode(PrisonUtil.getPrisonCode(request));
		id = talkEducationService.add(talkEducation); //添加数据得到id
		
		// 添加日志
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "添加成功。";
		log.getInsertLogMessage(talkEducation, config.getInsert(), operate, config.getTalkEducation(), config.getSucceed(), request);
		return "detail";
	}

	/**
	 * 查询一条谈话教育记录的信息,返回到详细页面
	 * **/
	public String detail() {
		talkEducation=talkEducationService.detail(id);
		return "Detail";
	}
	
	/**
	 * 删除一条谈话教育记录的信息
	 * **/
	public String delete() {
		talkEducationService.delete(id);
		
		// 添加日志
		TalkEducation object = new TalkEducation();
		object.setId(id);
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "删除成功。";
		log.getModifyLogMessage(null, object, config.getDelete(), operate, config.getTalkEducation(), config.getSucceed(), request);
		return "select";
	}
	
	/**
	 * 修改一条谈话教育记录
	 * **/
	public String update() {
		TalkEducation obj = talkEducationService.detail(talkEducation.getId());
		TalkEducation old_obj = talkEducationService.detail(talkEducation.getId());
		ObjectUpdateUtil.compareProperty(talkEducation, obj);
		
		talkEducationService.update(obj);
		id=talkEducation.getId();
		
		// 添加日志
		
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "修改成功。";
		log.getModifyLogMessage(obj, old_obj, config.getUpdate(), operate, config.getTalkEducation(), config.getSucceed(), request);
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
		talkEducation=talkEducationService.detail(id);
		return "Edit";
	}
	
	public List<Police> getPolicelist() {
		return policelist;
	}

	public void setPolicelist(List<Police> policelist) {
		this.policelist = policelist;
	}

	public TalkEducationService getTalkEducationService() {
		return talkEducationService;
	}

	public void setTalkEducationService(TalkEducationService talkEducationService) {
		this.talkEducationService = talkEducationService;
	}

	public List<TalkEducation> getTalkEducationlist() {
		return talkEducationlist;
	}

	public void setTalkEducationlist(List<TalkEducation> talkEducationlist) {
		this.talkEducationlist = talkEducationlist;
	}

	public TalkEducation getTalkEducation() {
		return talkEducation;
	}

	public void setTalkEducation(TalkEducation talkEducation) {
		this.talkEducation = talkEducation;
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

	public String getTalker() {
		return talker;
	}

	public void setTalker(String talker) {
		this.talker = talker;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
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

	public List<Dictionary> getGender() {
		return gender;
	}

	public void setGender(List<Dictionary> gender) {
		this.gender = gender;
	}
	
}
