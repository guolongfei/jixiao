package com.hoyotech.prison.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hoyotech.prison.bean.DetentionArea;
import com.hoyotech.prison.bean.DetentionInfo;
import com.hoyotech.prison.bean.PrisonInfo;
import com.hoyotech.prison.log.LogFactory;
import com.hoyotech.prison.service.impl.DetentionInfoService;
import com.hoyotech.prison.service.impl.PrisonInfoService;
import com.hoyotech.prison.util.ConfigHelper;
import com.hoyotech.prison.util.ObjectUpdateUtil;
import com.hoyotech.prison.util.PrisonUtil;
import com.isa.pims.basic.ServletRequestUtils;

public class DetentionInfoAction {
	private DetentionInfoService detentionInfoService;
	private PrisonInfoService prisonService;
	
	private List<DetentionInfo> list;
	private DetentionInfo detentionInfo;
	private int pageNum;
	private int limit; 
	private int totalPage;
	private int totalNum;
	private String id;
	
	private List<DetentionArea> detentionAreaList;
	private LogFactory log;
	
	// 检索条件
	private String prisonId;
	private String detentionName;
	
	public String list(){
		HttpServletRequest request = ServletActionContext.getRequest();
		pageNum = ServletRequestUtils.getInt(request, "page","1");
		limit = ServletRequestUtils.getInt(request, "limit","20");
		String prisonCode=PrisonUtil.getPrisonCode(request);
		list = detentionInfoService.getList(detentionName, pageNum, limit,prisonCode);
		totalNum = detentionInfoService.getCount(detentionName,prisonCode);
		
		totalPage=(totalNum-1)/limit+1;
		
		return "list";
	}
	
	public String addUI(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String PrisonId = PrisonUtil.getPrisonId(request);
		detentionAreaList = prisonService.getDetentionArea(PrisonId);
		return "addUI";
	}
	
	public String editUI(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String PrisonId = PrisonUtil.getPrisonId(request);
		detentionAreaList = prisonService.getDetentionArea(PrisonId);
		detentionInfo = detentionInfoService.detail(id);
		return "edit";
	}
	
	public String add(){
		//临时方法
		System.out.println(detentionInfo.getDetentionCode());
		System.out.println(detentionInfo.getDetentionName());
		System.out.println(detentionInfo.getChargePolice());
		System.out.println(detentionInfo.getStewardPolice()+"==============");
		HttpServletRequest request = ServletActionContext.getRequest();
		detentionInfo.setPrisonCode(PrisonUtil.getPrisonCode(request));
		
		detentionInfo.setPrisonInfo(new PrisonInfo(PrisonUtil.getPrisonId(request)));
		id = detentionInfoService.add(detentionInfo);
		
		// 添加日志
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "添加成功。";
		log.getInsertLogMessage(detentionInfo, config.getInsert(), operate, config.getDetentionInfo(), config.getSucceed(), request);
		return "Detail";
	}
	
	public String detail(){
		detentionInfo = detentionInfoService.detail(id);
		return "detail";
	}
	
	public String update(){
		DetentionInfo obj = detentionInfoService.detail(detentionInfo.getId());
		DetentionInfo old_obj = detentionInfoService.detail(detentionInfo.getId());
		ObjectUpdateUtil.compareProperty(detentionInfo, obj);
		
		detentionInfoService.update(obj);
		id=detentionInfo.getId();
		
		// 添加日志
		
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "修改成功。";
		log.getModifyLogMessage(obj, old_obj, config.getUpdate(), operate, config.getDetentionInfo(), config.getSucceed(), request);
		return "Detail";
	}
	
	public String delete(){
		//detentionInfo.setUpdateTime(new Date());
		detentionInfoService.delete(id);
		
		// 添加日志
		DetentionInfo object = new DetentionInfo();
		object.setId(id);
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "删除成功。";
		log.getModifyLogMessage(null, object, config.getDelete(), operate, config.getDetentionInfo(), config.getSucceed(), request);
		return "select";
	}
	
	
	public LogFactory getLog() {
		return log;
	}

	public void setLog(LogFactory log) {
		this.log = log;
	}

	public DetentionInfoService getDetentionInfoService() {
		return detentionInfoService;
	}

	public void setDetentionInfoService(DetentionInfoService detentionInfoService) {
		this.detentionInfoService = detentionInfoService;
	}

	public List<DetentionInfo> getList() {
		return list;
	}

	public void setList(List<DetentionInfo> list) {
		this.list = list;
	}

	public DetentionInfo getDetentionInfo() {
		return detentionInfo;
	}

	public void setDetentionInfo(DetentionInfo detentionInfo) {
		this.detentionInfo = detentionInfo;
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
		return detentionName;
	}

	public void setName(String name) {
		this.detentionName = name;
	}

	public PrisonInfoService getPrisonService() {
		return prisonService;
	}

	public void setPrisonService(PrisonInfoService prisonService) {
		this.prisonService = prisonService;
	}

	public List<DetentionArea> getDetentionAreaList() {
		return detentionAreaList;
	}

	public void setDetentionAreaList(List<DetentionArea> detentionAreaList) {
		this.detentionAreaList = detentionAreaList;
	}

	public String getPrisonId() {
		return prisonId;
	}

	public void setPrisonId(String prisonId) {
		this.prisonId = prisonId;
	}

	public String getDetentionName() {
		return detentionName;
	}

	public void setDetentionName(String detentionName) {
		this.detentionName = detentionName;
	}
}