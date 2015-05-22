package com.hoyotech.prison.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hoyotech.prison.bean.HandleConflict;
import com.hoyotech.prison.log.LogFactory;
import com.hoyotech.prison.service.impl.HandleConflictService;
import com.hoyotech.prison.util.ConfigHelper;
import com.hoyotech.prison.util.ObjectUpdateUtil;
import com.hoyotech.prison.util.PrisonUtil;
import com.isa.pims.basic.ServletRequestUtils;

public class HandleConflictAction {

	private HandleConflictService handleConflictService;
	private List<HandleConflict> handleConflictlist;
	private HandleConflict handleConflict;
	private int pageNum;
	private int limit; 
	private int totalPage;
	private int totalNum;
	private String id;
	private String recorder; //姓名
	private Date time; //职称
	
	private LogFactory log;
	
	/**
	 * 社会矛盾化解工作记录信息-打印（台账）
	 * **/
	public String print() {
		handleConflict=handleConflictService.detail(id);

		return "ListPrint";
	}
	
	/**
	 * 查询所有社会矛盾化解工作记录的信息
	 * **/
	public String select() {
		HttpServletRequest request=ServletActionContext.getRequest();
		pageNum = ServletRequestUtils.getInt(request, "page","1");
		limit = ServletRequestUtils.getInt(request, "limit","20");
		String prisonCode=PrisonUtil.getPrisonCode(request);
		handleConflictlist = handleConflictService.list(recorder, time, pageNum, limit,prisonCode);
		totalNum=handleConflictService.count(recorder, time,prisonCode);
		totalPage=(totalNum-1)/limit+1;
		return "List";
	}
	
	/**
	 * 添加一条社会矛盾化解工作记录的信息
	 * **/
	public String add() {
		HttpServletRequest request = ServletActionContext.getRequest();
		handleConflict.setPrisonCode(PrisonUtil.getPrisonCode(request));
		id = handleConflictService.add(handleConflict); //添加数据得到id
		
		// 添加日志
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "添加成功。";
		log.getInsertLogMessage(handleConflict, config.getInsert(), operate, config.getHandleConflict(), config.getSucceed(), request);
		return "detail";
	}

	/**
	 * 查询一条社会矛盾化解工作记录的信息,返回到详细页面
	 * **/
	public String detail() {
		handleConflict=handleConflictService.detail(id);
		return "Detail";
	}
	
	/**
	 * 删除一条社会矛盾化解工作记录的信息
	 * **/
	public String delete() {
		handleConflictService.delete(id);
		
		// 添加日志
		HandleConflict object = new HandleConflict();
		object.setId(id);
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "删除成功。";
		log.getModifyLogMessage(null, object, config.getDelete(), operate, config.getHandleConflict(), config.getSucceed(), request);
		return "select";
	}
	
	/**
	 * 修改一条社会矛盾化解工作记录
	 * **/
	public String update() {
		HandleConflict obj = handleConflictService.detail(handleConflict.getId());
		HandleConflict old_obj = handleConflictService.detail(handleConflict.getId());
		ObjectUpdateUtil.compareProperty(handleConflict, obj);
		
		handleConflictService.update(obj);
		id=handleConflict.getId();
		
		// 添加日志
		
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "修改成功。";
		log.getModifyLogMessage(obj, old_obj, config.getUpdate(), operate, config.getHandleConflict(), config.getSucceed(), request);
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
		handleConflict=handleConflictService.detail(id);
		return "Edit";
	}

	public HandleConflictService getHandleConflictService() {
		return handleConflictService;
	}

	public void setHandleConflictService(HandleConflictService handleConflictService) {
		this.handleConflictService = handleConflictService;
	}

	public List<HandleConflict> getHandleConflictlist() {
		return handleConflictlist;
	}

	public void setHandleConflictlist(List<HandleConflict> handleConflictlist) {
		this.handleConflictlist = handleConflictlist;
	}

	public HandleConflict getHandleConflict() {
		return handleConflict;
	}

	public void setHandleConflict(HandleConflict handleConflict) {
		this.handleConflict = handleConflict;
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

	public String getRecorder() {
		return recorder;
	}

	public void setRecorder(String recorder) {
		this.recorder = recorder;
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
