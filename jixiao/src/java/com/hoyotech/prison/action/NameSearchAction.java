package com.hoyotech.prison.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.hoyotech.prison.bean.Prisoner;
import com.hoyotech.prison.service.impl.NameSearchService;
import com.hoyotech.prison.service.impl.PrisonerService;
import com.hoyotech.prison.util.Note;
import com.hoyotech.prison.util.PrisonUtil;
import com.opensymphony.xwork2.Action;

public class NameSearchAction implements Action{
	private List<Prisoner> prisonlist;
	NameSearchService nameSearchService;
	private String prisonjson;
	private List<Note> prisonerList;
	private PrisonerService prisonerServer;
	
	public PrisonerService getPrisonerServer() {
		return prisonerServer;
	}

	public void setPrisonerServer(PrisonerService prisonerServer) {
		this.prisonerServer = prisonerServer;
	}

	public List<Note> getPrisonerList() {
		return prisonerList;
	}

	public void setPrisonerList(List<Note> prisonerList) {
		this.prisonerList = prisonerList;
	}

	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String prisonCode=PrisonUtil.getPrisonCode(request);
		String prisonId = PrisonUtil.getPrisonId(request);
		prisonerList = prisonerServer.getPrisonerJson(prisonId);
		prisonlist = nameSearchService.getPrisonerList(prisonCode);
		prisonjson = JSON.toJSONString(prisonlist);
		return SUCCESS;
	}

	public List<Prisoner> getPrisonlist() {
		return prisonlist;
	}

	public void setPrisonlist(List<Prisoner> prisonlist) {
		this.prisonlist = prisonlist;
	}

	public NameSearchService getNameSearchService() {
		return nameSearchService;
	}

	public void setNameSearchService(NameSearchService nameSearchService) {
		this.nameSearchService = nameSearchService;
	}

	public String getPrisonjson() {
		return prisonjson;
	}

	public void setPrisonjson(String prisonjson) {
		this.prisonjson = prisonjson;
	}
	
	
}
