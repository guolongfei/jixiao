package com.hoyotech.prison.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hoyotech.prison.bean.Area;
import com.hoyotech.prison.bean.Organization;
import com.hoyotech.prison.log.LogFactory;
import com.hoyotech.prison.service.impl.DictionaryService;
import com.hoyotech.prison.service.impl.OrganizationService;
import com.hoyotech.prison.util.ConfigHelper;
import com.hoyotech.prison.util.ObjectUpdateUtil;
import com.isa.pims.basic.ServletRequestUtils;

public class OrganizationAction {
	private OrganizationService organizationService;
	private DictionaryService dictionaryService;
	private List<Organization> list;
	private Organization organization;
	private int pageNum;
	private int limit;
	private int totalPage;
	private int totalNum;
	private String id;

	private List<Organization> parentOrgList;
	private List<Area> areaList;

	// 检索条件
	private String orgCode;
	private String orgName;
	private String orgState;
	private String orgLevel;

	private LogFactory log;
	
	public String list() {
		HttpServletRequest request = ServletActionContext.getRequest();
		pageNum = ServletRequestUtils.getInt(request, "page", "1");
		limit = ServletRequestUtils.getInt(request, "limit", "20");

		list = organizationService.getList(orgCode, orgName, orgState, orgLevel, pageNum, limit);
		totalNum = organizationService.getCount(orgCode, orgName, orgState, orgLevel);
		totalPage = (totalNum - 1) / limit + 1;
		
		String type=(String)request.getSession().getAttribute("orgType");
		if("2".equals(type)){
			return "stlist";
		}else{
			return "list";
		}
		
	}

	public String addUI() {
		parentOrgList = organizationService.getParentOrgList();
		areaList = dictionaryService.getAreaListLevel1();
		return "addUI";
	}

	public String editUI() {
		organization = organizationService.detail(id);
		parentOrgList = organizationService.getParentOrgList();
		return "edit";
	}

	public String add() {
		id = organizationService.add(organization);
		
		// 添加日志
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "添加成功。";
		log.getInsertLogMessage(organization, config.getInsert(), operate, config.getOrganization(), config.getSucceed(), request);
		return "Detail";
	}

	public String detail() {
		organization = organizationService.detail(id);
		HttpServletRequest request = ServletActionContext.getRequest();
		String type=(String)request.getSession().getAttribute("orgType");
		if("2".equals(type)){
			return "stdetail";
		}else{
			return "detail";
		}
		
	}

	public String update() {
		Organization obj = organizationService.detail(organization.getId());
		Organization old_obj = organizationService.detail(organization.getId());
		ObjectUpdateUtil.compareProperty(organization, obj);

		organizationService.update(obj);
		id = organization.getId();
		
		
		// 添加日志
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "修改成功。";
		log.getModifyLogMessage(obj, old_obj, config.getUpdate(), operate, config.getOrganization(), config.getSucceed(), request);
		return "Detail";
	}

	public String delete() {
		organizationService.delete(id);
		
		// 添加日志
		Organization object = new Organization();
		object.setId(id);
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "删除成功。";
		log.getModifyLogMessage(null, object, config.getDelete(), operate, config.getOrganization(), config.getSucceed(), request);
		return "select";
	}
	
	public LogFactory getLog() {
		return log;
	}

	public void setLog(LogFactory log) {
		this.log = log;
	}

	public List<Organization> getList() {
		return list;
	}

	public void setList(List<Organization> list) {
		this.list = list;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
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

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getOrgState() {
		return orgState;
	}

	public void setOrgState(String orgState) {
		this.orgState = orgState;
	}

	public String getOrgLevel() {
		return orgLevel;
	}

	public void setOrgLevel(String orgLevel) {
		this.orgLevel = orgLevel;
	}

	public List<Organization> getParentOrgList() {
		return parentOrgList;
	}

	public void setParentOrgList(List<Organization> parentOrgList) {
		this.parentOrgList = parentOrgList;
	}

	public OrganizationService getOrganizationService() {
		return organizationService;
	}

	public void setOrganizationService(OrganizationService organizationService) {
		this.organizationService = organizationService;
	}

	public List<Area> getAreaList() {
		return areaList;
	}

	public void setAreaList(List<Area> areaList) {
		this.areaList = areaList;
	}

	public DictionaryService getDictionaryService() {
		return dictionaryService;
	}

	public void setDictionaryService(DictionaryService dictionaryService) {
		this.dictionaryService = dictionaryService;
	}
}