package com.hoyotech.prison.action;

import com.hoyotech.prison.bean.Prisoner;
import com.hoyotech.prison.service.impl.PrisonerService;

public class OutprisonProveAction {

	PrisonerService prisonerServer;
	private Prisoner prisoner;
	private String id;
	
	public String doc(){
		prisoner = prisonerServer.detail(id);
		return "doc";
	}

	public PrisonerService getPrisonerServer() {
		return prisonerServer;
	}

	public void setPrisonerServer(PrisonerService prisonerServer) {
		this.prisonerServer = prisonerServer;
	}

	public Prisoner getPrisoner() {
		return prisoner;
	}

	public void setPrisoner(Prisoner prisoner) {
		this.prisoner = prisoner;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
