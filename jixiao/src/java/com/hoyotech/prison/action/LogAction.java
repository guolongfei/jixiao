package com.hoyotech.prison.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hoyotech.prison.log.Message;
import com.hoyotech.prison.service.impl.LogService;
import com.hoyotech.prison.util.PrisonUtil;
import com.isa.pims.basic.ServletRequestUtils;

public class LogAction {

	private LogService logService;
	private List<Message> messagelist;
	private int pageNum;
	private int limit; 
	private int totalPage;
	private int totalNum;
	private String id;
	private String name; //用户名
	private Date time; //时间
	private String typeId;
	private String typeName;
	
	/**
	 * 查询所有集体教育记录的信息
	 * **/
	public String select() {
		HttpServletRequest request=ServletActionContext.getRequest();
		pageNum = ServletRequestUtils.getInt(request, "page","1");
		limit = ServletRequestUtils.getInt(request, "limit","20");
		String prisonCode=PrisonUtil.getPrisonCode(request);
		messagelist = logService.list(name, time,typeId,typeName, pageNum, limit,prisonCode);
		totalNum=logService.count(name, time,typeId,typeName,prisonCode);
		totalPage=(totalNum-1)/limit+1;
		return "List";
	}

	
	public String getTypeName() {
		return typeName;
	}


	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}


	public String getTypeId() {
		return typeId;
	}


	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}


	public LogService getLogService() {
		return logService;
	}




	public void setLogService(LogService logService) {
		this.logService = logService;
	}




	public List<Message> getMessagelist() {
		return messagelist;
	}




	public void setMessagelist(List<Message> messagelist) {
		this.messagelist = messagelist;
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


	
	
	
	
	
	
}
