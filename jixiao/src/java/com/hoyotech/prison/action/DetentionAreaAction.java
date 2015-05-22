package com.hoyotech.prison.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hoyotech.prison.bean.DetentionArea;
import com.hoyotech.prison.bean.PrisonInfo;
import com.hoyotech.prison.log.LogFactory;
import com.hoyotech.prison.service.impl.DetentionAreaService;
import com.hoyotech.prison.service.impl.PrisonInfoService;
import com.hoyotech.prison.util.ConfigHelper;
import com.hoyotech.prison.util.ObjectUpdateUtil;
import com.hoyotech.prison.util.PrisonUtil;
import com.isa.pims.basic.ServletRequestUtils;

public class DetentionAreaAction {
	private DetentionAreaService detentionAreaService;
	private PrisonInfoService prisonService;
	private List<DetentionArea> list;
	private DetentionArea detentionArea;
	private int pageNum;
	private int limit; 
	private int totalPage;
	private int totalNum;
	private String id;
	
	// 检索条件
	private String prisonId;
	private String areaName;
	
	private LogFactory log;
	
	public String list(){
		HttpServletRequest request = ServletActionContext.getRequest();
		pageNum = ServletRequestUtils.getInt(request, "page","1");
		limit = ServletRequestUtils.getInt(request, "limit","20");
		String prisonCode=PrisonUtil.getPrisonCode(request);
		list = detentionAreaService.getList(prisonId, areaName, pageNum, limit,prisonCode);
		totalNum = detentionAreaService.getCount(prisonId, areaName,prisonCode);
		totalPage=(totalNum-1)/limit+1;
		return "list";
	}
	
	public String addUI(){
		return "addUI";
	}
	
	public String editUI(){
		detentionArea = detentionAreaService.detail(id);
		return "edit";
	}
	
	public String add(){
		//临时方法
		HttpServletRequest request = ServletActionContext.getRequest();
		detentionArea.setPrisonCode(PrisonUtil.getPrisonCode(request));
		detentionArea.setPrisonInfo(new PrisonInfo(PrisonUtil.getPrisonId(request)));
		id = detentionAreaService.add(detentionArea);
		
		// 添加日志
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "添加成功。";
		log.getInsertLogMessage(detentionArea, config.getInsert(), operate, config.getDetentionArea(), config.getSucceed(), request);
		return "Detail";
	}
	
	public String detail(){
		detentionArea = detentionAreaService.detail(id);
		return "detail";
	}
	public String update(){
		DetentionArea obj = detentionAreaService.detail(detentionArea.getId());
		DetentionArea old_obj = detentionAreaService.detail(detentionArea.getId());
		ObjectUpdateUtil.compareProperty(detentionArea, obj);
		detentionAreaService.update(obj);
		id=detentionArea.getId();
		
		// 添加日志
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "修改成功。";
		log.getModifyLogMessage(obj, old_obj, config.getUpdate(), operate, config.getDetentionArea(), config.getSucceed(), request);
		return "Detail";
	}
	
	public String delete(){
		//detentionArea.setUpdateTime(new Date());
		detentionAreaService.delete(id);
		
		// 添加日志
		DetentionArea object = new DetentionArea();
		object.setId(id);
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "删除成功。";
		log.getModifyLogMessage(null, object, config.getDelete(), operate, config.getDetentionArea(), config.getSucceed(), request);
		return "select";
	}
	
	public LogFactory getLog() {
		return log;
	}

	public void setLog(LogFactory log) {
		this.log = log;
	}

	public DetentionAreaService getDetentionAreaService() {
		return detentionAreaService;
	}

	public void setDetentionAreaService(DetentionAreaService detentionAreaService) {
		this.detentionAreaService = detentionAreaService;
	}

	public List<DetentionArea> getList() {
		return list;
	}

	public void setList(List<DetentionArea> list) {
		this.list = list;
	}

	public DetentionArea getDetentionArea() {
		return detentionArea;
	}

	public void setDetentionArea(DetentionArea detentionArea) {
		this.detentionArea = detentionArea;
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

	public String getPoliceNumber() {
		return prisonId;
	}

	public void setPoliceNumber(String policeNumber) {
		this.prisonId = policeNumber;
	}

	public String getName() {
		return areaName;
	}

	public void setName(String name) {
		this.areaName = name;
	}

	public PrisonInfoService getPrisonService() {
		return prisonService;
	}

	public void setPrisonService(PrisonInfoService prisonService) {
		this.prisonService = prisonService;
	}

	public String getPrisonId() {
		return prisonId;
	}

	public void setPrisonId(String prisonId) {
		this.prisonId = prisonId;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	
}