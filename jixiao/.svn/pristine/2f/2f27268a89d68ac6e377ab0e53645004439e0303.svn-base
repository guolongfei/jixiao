package com.hoyotech.prison.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hoyotech.prison.bean.MeetingRecord;
import com.hoyotech.prison.log.LogFactory;
import com.hoyotech.prison.service.impl.MeetingRecordService;
import com.hoyotech.prison.util.ConfigHelper;
import com.hoyotech.prison.util.ObjectUpdateUtil;
import com.hoyotech.prison.util.PrisonUtil;
import com.isa.pims.basic.ServletRequestUtils;

public class MeetingRecordAction {

	private MeetingRecordService meetingRecordService;
	private List<MeetingRecord> meetingRecordlist;
	private MeetingRecord meetingRecord;
	private int pageNum;
	private int limit; 
	private int totalPage;
	private int totalNum;
	private String id ;
	
	private String address; //地点
	private Date time; 
	
	private LogFactory log;
	
	
	/**
	 * 所务会议及动态分析会议记录-打印（台账）
	 * **/
	public String print() {
		meetingRecord=meetingRecordService.detail(id);

		return "ListPrint";
	}
	
	/**
	 * 查询所有所务会议及动态分析会议记录
	 * **/
	public String select() {
		HttpServletRequest request=ServletActionContext.getRequest();
		pageNum = ServletRequestUtils.getInt(request, "page","1");
		limit = ServletRequestUtils.getInt(request, "limit","20");
		String prisonCode=PrisonUtil.getPrisonCode(request);
		meetingRecordlist = meetingRecordService.list(address, time, pageNum, limit,prisonCode);
		totalNum=meetingRecordService.count(address, time,prisonCode);
		totalPage=(totalNum-1)/limit+1;
		return "List";
	}
	
	/**
	 * 添加一条所务会议及动态分析会议记录
	 * **/
	public String add() {
		HttpServletRequest request = ServletActionContext.getRequest();
		meetingRecord.setPrisonCode(PrisonUtil.getPrisonCode(request));
		id = meetingRecordService.add(meetingRecord); //添加数据得到id
		
		// 添加日志
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "添加成功。";
		log.getInsertLogMessage(meetingRecord, config.getInsert(), operate, config.getMeetingRecord(), config.getSucceed(), request);
		return "detail";
	}

	/**
	 * 查询一条所务会议及动态分析会议记录,返回到详细页面
	 * **/
	public String detail() {
		meetingRecord=meetingRecordService.detail(id);
		return "Detail";
	}
	
	/**
	 * 删除一条所务会议及动态分析会议记录
	 * **/
	public String delete() {
		meetingRecordService.delete(id);
		
		// 添加日志
		MeetingRecord object = new MeetingRecord();
		object.setId(id);
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "删除成功。";
		log.getModifyLogMessage(null, object, config.getDelete(), operate, config.getMeetingRecord(), config.getSucceed(), request);
		return "select";
	}
	
	/**
	 * 修改一条所务会议及动态分析会议记录
	 * **/
	public String update() {
		MeetingRecord obj = meetingRecordService.detail(meetingRecord.getId());
		MeetingRecord old_obj = meetingRecordService.detail(meetingRecord.getId());
		ObjectUpdateUtil.compareProperty(meetingRecord, obj);
		meetingRecordService.update(obj);
		id=meetingRecord.getId();
		
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
		return "Add";
	}
	
	/**
	 * 进入修改页面
	 * **/
	public String interEdit() {
		
		meetingRecord=meetingRecordService.detail(id);
		return "Edit";
	}

	public MeetingRecordService getMeetingRecordService() {
		return meetingRecordService;
	}

	public void setMeetingRecordService(MeetingRecordService meetingRecordService) {
		this.meetingRecordService = meetingRecordService;
	}

	public List<MeetingRecord> getMeetingRecordlist() {
		return meetingRecordlist;
	}

	public void setMeetingRecordlist(List<MeetingRecord> meetingRecordlist) {
		this.meetingRecordlist = meetingRecordlist;
	}

	public MeetingRecord getMeetingRecord() {
		return meetingRecord;
	}

	public void setMeetingRecord(MeetingRecord meetingRecord) {
		this.meetingRecord = meetingRecord;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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
	
	
}
