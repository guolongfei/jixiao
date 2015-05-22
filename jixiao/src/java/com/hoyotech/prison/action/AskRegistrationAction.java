package com.hoyotech.prison.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hoyotech.prison.bean.Arraign;
import com.hoyotech.prison.bean.AskAndArraign;
import com.hoyotech.prison.bean.AskRegistration;
import com.hoyotech.prison.bean.Police;
import com.hoyotech.prison.bean.Prisoner;
import com.hoyotech.prison.log.LogFactory;
import com.hoyotech.prison.service.impl.ArraignService;
import com.hoyotech.prison.service.impl.AskRegistrationService;
import com.hoyotech.prison.service.impl.DictionaryService;
import com.hoyotech.prison.service.impl.PrisonerService;
import com.hoyotech.prison.util.ConfigHelper;
import com.hoyotech.prison.util.ObjectUpdateUtil;
import com.hoyotech.prison.util.PrisonUtil;
import com.isa.pims.basic.ServletRequestUtils;

public class AskRegistrationAction {

	PrisonerService prisonerServer;
	DictionaryService dictionaryService;
	AskRegistrationService askRegiService;
	ArraignService arraignService;
	private Prisoner prisoner;
	private List<AskRegistration> askRegis;
	private AskRegistration askRegistration;
	private Arraign arraign;
	private int pageNum;
	private int limit; 
	private int totalPage;
	private int totalNum;
	private String id;
	private String view;
	private String type;

	private String name;
	private Date time;
	
	private LogFactory log;
	private List<Police> policelist;
	private List<AskAndArraign> askAndArraigns= new ArrayList<AskAndArraign>();
	
	public void selectPolice(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String prisonCode=PrisonUtil.getPrisonCode(request);
		policelist=dictionaryService.selectPolice(prisonCode);
	}
	
	public String doc(){
		askRegistration = askRegiService.detail(id);
		return "doc";
	}
	
	/**
	 * 询问登记信息-打印（台账）
	 * **/
	public String print() {
		selectList();
		return "ListPrint";
	}
	
	/**
	 * 查询所有询问被拘留人登记的信息
	 * **/
	public String select() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String prisonCode=PrisonUtil.getPrisonCode(request);
		askRegis = askRegiService.list(id, prisonCode);
		return "list";
	}

	/**
	 * 添加一条询问被拘留人登记的信息
	 * **/
	public String add() {
		askRegistration.setNoYear(PrisonUtil.getYear());//添加流水号
		askRegistration.setNoNumber(dictionaryService.getNo("AskRegistration"));
		HttpServletRequest request = ServletActionContext.getRequest();
		askRegistration.setPrisonCode(PrisonUtil.getPrisonCode(request));
		id = askRegiService.add(askRegistration); // 添加数据得到id
		id = askRegistration.getPrisoner().getId();
		type = "askRegistration";
		
		// 添加日志
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "添加成功。";
		log.getInsertLogMessage(askRegistration, config.getInsert(), operate, config.getAskRegistration(), config.getSucceed(), request);
		return "main";
	}

	/**
	 * 查询一条询问被拘留人登记的信息
	 * **/
	public String detail() {
		askRegistration = askRegiService.detail(id);
		return "detail";
	}
	
	/**
	 * 删除一条询问被拘留人登记的信息
	 * **/
	public String delete() {
		askRegiService.delete(id);
		
		// 添加日志
		AskRegistration object = new AskRegistration();
		object.setId(id);
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "删除成功。";
		log.getModifyLogMessage(null, object, config.getDelete(), operate, config.getAskRegistration(), config.getSucceed(), request);
		return "select";
	}

	/**
	 * 修改一条询问被拘留人登记的信息
	 * **/
	public String update() {
		AskRegistration old_obj = askRegiService.detail(askRegistration.getId());
		AskRegistration obj = askRegiService.detail(askRegistration.getId());
		ObjectUpdateUtil.compareProperty(askRegistration, obj);
		askRegiService.update(obj);
		id = askRegistration.getId();
		
		// 添加日志
		
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "修改成功。";
		log.getModifyLogMessage(obj, old_obj, config.getUpdate(), operate, config.getAskRegistration(), config.getSucceed(), request);
		
		return "Detail";
	}

	/**
	 * 进入添加页面
	 * **/
	public String interAdd() {
		selectPolice();
		prisoner = prisonerServer.detail(id);
		return "addUI";
	}
	
	/**
	 * 进入修改页面
	 * **/
	public String interEdit() {
		selectPolice();
		askRegistration = askRegiService.detail(id);
		return "edit";
	}
	/**
	 * 修改审批意见
	 * **/
	public String examine() {
		askRegiService.examineChange(id, view);
		
		// 添加日志
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "修改成功。审批状态修改为:"+view;
		log.getModifyLogMessage(null, null, config.getUpdate(), operate, config.getAskRegistration(), config.getSucceed(), request);
		return "Detail";
	}

	//以下为台账的方法
	/**
	 * 查询询问被拘留人登记信息（台账）
	 * **/
	public String tzSelect() {
		selectList();
		return "tz_List";
	}
	
	public void selectList(){
		HttpServletRequest request=ServletActionContext.getRequest();
		pageNum = ServletRequestUtils.getInt(request, "page","1");
		limit = ServletRequestUtils.getInt(request, "limit","20");
		String prisonCode=PrisonUtil.getPrisonCode(request);
		askRegis=askRegiService.list_tz(name,time,prisonCode,pageNum, limit);
		List<Arraign> arraigns=askRegiService.arraign_tz(name,time,prisonCode,pageNum, limit);
		for(AskRegistration i:askRegis){
			AskAndArraign a=new AskAndArraign();
			a.setType("1");
			a.setId(i.getId());
			a.setTime(i.getUpdateTime());
			a.setName(i.getPrisoner().getName());
			a.setSex(i.getPrisoner().getGender().getDescription());
			a.setUnitName(i.getPrisoner().getHandleCases()==null?"":i.getPrisoner().getHandleCases().getUnitName());
			a.setAsk1(i.getAsker1());
			a.setNum1(i.getWorkNum1());
			a.setAsk2(i.getAsker2());
			a.setNum2(i.getWorkNum2());
			a.setStartTime(i.getStartTime());
			a.setEndTime(i.getEndTime());
			a.setApprover(i.getApprover()==null?"":i.getApprover().getName());
			a.setBefore(i.getAfterAsk());
			askAndArraigns.add(a);
		}
		
		for(Arraign k:arraigns){
			AskAndArraign b=new AskAndArraign();
			b.setType("2");
			b.setTime(k.getUpdateTime());
			b.setName(k.getPrisoner().getName());
			b.setSex(k.getPrisoner().getGender().getDescription());
			b.setUnitName(k.getPrisoner().getHandleCases()==null?"":k.getPrisoner().getHandleCases().getUnitName());
			b.setAsk1(k.getName1());
			b.setId(k.getId());
			b.setNum1(k.getWorkNum1());
			b.setAsk2(k.getName2());
			b.setNum2(k.getWorkNum2());
			b.setStartTime(k.getStartTime());
			b.setEndTime(k.getEndTime());
			b.setApprover(k.getApprover()==null?"":k.getApprover().getName());
			b.setBefore(k.getAfterAsk());
			askAndArraigns.add(b);
		}
		Collections.sort(askAndArraigns, new Comparator<AskAndArraign>(){
			public int compare(AskAndArraign arg0, AskAndArraign arg1){
				return arg0.getTime().compareTo(arg1.getTime());  
			}
		});
		
		totalNum=askRegiService.count_tz(name,time,prisonCode)+askRegiService.count_arr(name,time,prisonCode);
		totalPage=(totalNum-1)/limit+1;
	}
	
	/**
	 * 查询一条询问被拘留人登记信息（台账）,返回到详细页面
	 * **/
	public String tzDetail() {
		askRegistration=askRegiService.detail(id);
		return "tz_Detail";
	}
	
	public String arraignDetail() {
		arraign=arraignService.detail(id);
		return "arraign_Detail";
	}
	
	public ArraignService getArraignService() {
		return arraignService;
	}

	public void setArraignService(ArraignService arraignService) {
		this.arraignService = arraignService;
	}

	public Arraign getArraign() {
		return arraign;
	}

	public void setArraign(Arraign arraign) {
		this.arraign = arraign;
	}

	public List<AskAndArraign> getAskAndArraigns() {
		return askAndArraigns;
	}

	public void setAskAndArraigns(List<AskAndArraign> askAndArraigns) {
		this.askAndArraigns = askAndArraigns;
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

	public AskRegistrationService getAskRegiService() {
		return askRegiService;
	}

	public void setAskRegiService(AskRegistrationService askRegiService) {
		this.askRegiService = askRegiService;
	}

	public Prisoner getPrisoner() {
		return prisoner;
	}

	public void setPrisoner(Prisoner prisoner) {
		this.prisoner = prisoner;
	}

	public List<AskRegistration> getAskRegis() {
		return askRegis;
	}

	public void setAskRegis(List<AskRegistration> askRegis) {
		this.askRegis = askRegis;
	}

	public AskRegistration getAskRegistration() {
		return askRegistration;
	}

	public void setAskRegistration(AskRegistration askRegistration) {
		this.askRegistration = askRegistration;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getView() {
		return view;
	}

	public void setView(String view) {
		this.view = view;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
