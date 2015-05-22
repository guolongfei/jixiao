package com.hoyotech.prison.action;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hoyotech.prison.bean.HandOver;
import com.hoyotech.prison.bean.Police;
import com.hoyotech.prison.log.LogFactory;
import com.hoyotech.prison.service.impl.DictionaryService;
import com.hoyotech.prison.service.impl.HandOverService;
import com.hoyotech.prison.util.ConfigHelper;
import com.hoyotech.prison.util.ObjectUpdateUtil;
import com.hoyotech.prison.util.PrisonUtil;
import com.isa.pims.basic.ServletRequestUtils;

public class HandOverAction {

	private HandOverService handOverService;
	private DictionaryService dictionaryService;
	private List<HandOver> handOverlist;
	private HandOver handOver;
	private int pageNum;
	private int limit; 
	private int totalPage;
	private int totalNum;
	private String id;
	private String name; //姓名
	private Date time;
	
	private String typeId;
	private int inNum;
	private int out;
	private int zaiju;
	
	
	private LogFactory log;
	private List<Police> policelist;
	
	public void prisonerCount(Date addTime){
		HttpServletRequest request = ServletActionContext.getRequest();
		String prisonCode=PrisonUtil.getPrisonCode(request);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal=Calendar.getInstance();//当前日期
		String date=simpleDateFormat.format(cal.getTime());
		String date2=simpleDateFormat.format(addTime);
		
		inNum=handOverService.inToday(date2,date, prisonCode);
		out=handOverService.outToday(date2,date, prisonCode);
		zaiju=handOverService.zaiju(prisonCode);
		
	}
	
	public void selectPolice(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String prisonCode=PrisonUtil.getPrisonCode(request);
		policelist=dictionaryService.selectPolice(prisonCode);
	}
	
	/**
	 * 值班记录信息-打印（台账）
	 * **/
	public String print() {
		handOver=handOverService.detail(id);

		return "ListPrint";
	}
	
	/**
	 * 查询所有值班记录的信息
	 * **/
	public String select() {
		HttpServletRequest request=ServletActionContext.getRequest();
		pageNum = ServletRequestUtils.getInt(request, "page","1");
		limit = ServletRequestUtils.getInt(request, "limit","20");
		String prisonCode=PrisonUtil.getPrisonCode(request);
		handOverlist = handOverService.list(name, time, pageNum, limit,prisonCode);
		totalNum=handOverService.count(name, time,prisonCode);
		totalPage=(totalNum-1)/limit+1;
		
		List<HandOver> hand=handOverService.listCount(prisonCode); 
		String userId=(String)request.getSession().getAttribute("realyName");
		if(hand.size()>0){
			if(hand.get(0).getDutyName().getId().equals(userId)){//判断当前账号是否为当前值班人员，只有值班人员才能添加值班记录
				typeId="1";
			}
		}else{ //如果当前还不存在值班人员 的话任意账号都可以添加值班记录。
			typeId="1";
		}
		
		return "List";
	}
	
	/**
	 * 添加一条值班记录的信息
	 * **/
	public String add() {
		HttpServletRequest request = ServletActionContext.getRequest();
		handOver.setPrisonCode(PrisonUtil.getPrisonCode(request));
		id = handOverService.add(handOver); //添加数据得到id
		
		// 添加日志
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "添加成功。";
		log.getInsertLogMessage(handOver, config.getInsert(), operate, config.getHandOver(), config.getSucceed(), request);
		return "detail";
	}

	/**
	 * 查询一条值班记录的信息,返回到详细页面
	 * **/
	public String detail() {
		handOver=handOverService.detail(id);
		HttpServletRequest request=ServletActionContext.getRequest();
		String userId=(String)request.getSession().getAttribute("realyName");
		System.out.println("========="+handOver.getState());
		System.out.println("========"+userId.equals(handOver.getDutyName().getId()));
		if(handOver.getState()==1&&userId.equals(handOver.getDutyName().getId())==false){
			typeId="1";
		}
		return "Detail";
	}
	
	/**
	 * 删除一条值班记录的信息
	 * **/
	public String delete() {
		handOverService.delete(id);
		
		// 添加日志
		HandOver object = new HandOver();
		object.setId(id);
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "删除成功。";
		log.getModifyLogMessage(null, object, config.getDelete(), operate, config.getHandOver(), config.getSucceed(), request);
		return "select";
	}
	
	/**
	 * 修改一条值班记录
	 * **/
	public String update() {
		HandOver obj = handOverService.detail(handOver.getId());
		HandOver old_obj = handOverService.detail(handOver.getId());
		ObjectUpdateUtil.compareProperty(handOver, obj);
		
		handOverService.update(obj);
		id=handOver.getId();
		
		// 添加日志
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "修改成功。";
		log.getModifyLogMessage(obj, old_obj, config.getUpdate(), operate, config.getHandOver(), config.getSucceed(), request);
		return "detail";
	}
	
	/**
	 * 进入添加页面
	 * **/
	public String interAdd() {
		selectPolice();
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String prisonCode=PrisonUtil.getPrisonCode(request);
		List<HandOver> hand=handOverService.listCount(prisonCode);
		if(hand.size()==0){
			zaiju=handOverService.zaiju(prisonCode);
			return "Add";
		}else{
			handOver=hand.get(0);
			System.out.println(handOver.getOutNum()+"----");
			System.out.println(handOver.getDutyDoctor()+"-----");
			prisonerCount(hand.get(0).getAddTime());
			return "Edit";
		}
	}
	
	/**
	 * 进入修改页面
	 * **/
	public String interEdit() {
		selectPolice();
		handOver=handOverService.detail(id);
		System.out.println(handOver.getOutNum());
		System.out.println(handOver.getDutyDoctor());
		return "Edit";
	}
	
	/**
	 * 确认接班
	 * **/
	public String examine() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String userId=(String)request.getSession().getAttribute("realyName");
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar cal=Calendar.getInstance();//当前日期
		String date=simpleDateFormat.format(cal.getTime());//输出2005-04-30
		
		//int num=handOverService.examineChange(id,userId,date);
		HandOver num=handOverService.examineChange(id,userId,date);
		
		// 添加日志
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "已接班";
		log.getModifyLogMessage(null, null, config.getUpdate(), operate, config.getHandOver(), config.getSucceed(), request);
		
		
		//添加一条新的值班记录
		HandOver newHand=new HandOver();
		newHand.setPrisonCode(PrisonUtil.getPrisonCode(request));
		Police police=new Police();
		police.setId(userId);
		newHand.setDutyName(police);
		//newHand.setJiebanNum(num);
		newHand.setJiebanNum(num.getJiebanNum());
		newHand.setJiaobanNum(num.getJiaobanNum());
		newHand.setDutyLeader(num.getDutyLeader());
		id = handOverService.add(newHand); //添加数据得到id
		
		// 添加日志
		String operate2 = "添加成功。";
		log.getInsertLogMessage(handOver, config.getInsert(), operate2, config.getHandOver(), config.getSucceed(), request);
		
		return "select";
	}

	
	public int getZaiju() {
		return zaiju;
	}

	public void setZaiju(int zaiju) {
		this.zaiju = zaiju;
	}

	public int getInNum() {
		return inNum;
	}

	public void setInNum(int inNum) {
		this.inNum = inNum;
	}

	public int getOut() {
		return out;
	}

	public void setOut(int out) {
		this.out = out;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public DictionaryService getDictionaryService() {
		return dictionaryService;
	}

	public void setDictionaryService(DictionaryService dictionaryService) {
		this.dictionaryService = dictionaryService;
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

	public HandOverService getHandOverService() {
		return handOverService;
	}

	public void setHandOverService(HandOverService handOverService) {
		this.handOverService = handOverService;
	}

	public List<HandOver> getHandOverlist() {
		return handOverlist;
	}

	public void setHandOverlist(List<HandOver> handOverlist) {
		this.handOverlist = handOverlist;
	}

	public HandOver getHandOver() {
		return handOver;
	}

	public void setHandOver(HandOver handOver) {
		this.handOver = handOver;
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
