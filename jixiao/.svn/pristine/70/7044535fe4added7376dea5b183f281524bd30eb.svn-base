package com.hoyotech.prison.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hoyotech.prison.bean.Prisoner;
import com.hoyotech.prison.service.impl.PrisonerService;
import com.hoyotech.prison.util.PrisonUtil;

public class PrisonerMainAction {
	private PrisonerService prisonerServer;
	
	private Prisoner prisoner;
	private String id;//被拘留人ID
	private String prisonerId;
	private String message;
	private String tag;
	private String type;
	
	private boolean is_has_image;
	
	private String hasDoc;//存在的法律文书标识
//	private List<Note> prisonerList;
	
	public String query() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String prisonId = PrisonUtil.getPrisonId(request);
		
//		prisonerList = prisonerServer.getPrisonerJson(prisonId);
		if(prisonerId != null){
			prisoner = prisonerServer.getPrisonerByCode(prisonerId, prisonId);
		}
		if (prisoner == null) {
			message = "您输入的被拘留人不存在，请确认后重新输入。";
			return "input";
		} else {
			tag = "manage/prisoner_detail.action?id="+prisoner.getId();
			hasDoc = prisonerServer.hasDoc(prisoner.getId());
			is_has_image = prisonerServer.hasImage(prisoner.getId());
			return "success";
		}
	}

	public String addUI() {
		//tag = "manage/prisoner_interAdd.action";
		return "addUI";
	}
	
	public String detail() {
//		System.out.println("type:"+type);
		hasDoc = prisonerServer.hasDoc(id);
		prisoner = prisonerServer.detail(id);
		
		is_has_image = prisonerServer.hasImage(id);
		
		tag = "manage/prisoner_detail.action";
		if("prisoner".equals(type)){
			
		}else if("prisonerHealth".equals(type)){
			tag = "manage/prisonerHealth_detailByPrisoner.action";
			
		}else if("prisonerGoods".equals(type)){
			tag = "manage/prisonerGoods_detailByPrisoner.action";
			
		}else if("contrabandGoods".equals(type)){
			tag = "manage/contrabandGoods_detailByPrisoner.action";
			
		}else if("executeReturn".equals(type)){
			tag = "manage/executeReturn_detailByPrisoner.action";
			
		}else if("sendExamine".equals(type)){
			tag = "manage/sendExamine_detailByPrisoner.action";
			
		}else if("refuseDetain".equals(type)){
			tag = "manage/refuseDetain_detailByPrisoner.action";
			
		}else if("detainReturn".equals(type)){
			tag = "manage/detainReturn_detailByPrisoner.action";
			
		}else if("wrongDetain".equals(type)){
			tag = "manage/wrongDetain_detailByPrisoner.action";
			
		}else if("handleSeparate".equals(type)){
			tag = "manage/handleSeparate_detailByPrisoner.action";
			
		}else if("stopDetain".equals(type)){
			tag = "manage/stopDetain_detailByPrisoner.action";
			
		}else if("outPrison".equals(type)){
			tag = "manage/outprison_select.action";
			
		}else if("leaveEx".equals(type)){
			tag = "manage/leaveEx_select.action";
			
		}else if("exeDetain".equals(type)){
			tag = "manage/exeDetain_detailByPrisoner.action";
			
		}else if("useWeapon".equals(type)){
			tag = "manage/useWeapon_select.action";
			
		}else if("askRegistration".equals(type)){
			tag = "manage/askRegi_select.action";
			
		}else if("arraign".equals(type)){
			tag = "manage/arraign_detailByPrisoner.action";
			
		}else if("crimeKeyPass".equals(type)){
			tag = "manage/crimeKeyPass_detailByPrisoner.action";
			
		}else if("appealDataPass".equals(type)){
			tag = "manage/appealDataPass_detailByPrisoner.action";
			
		}else if("deathNotice".equals(type)){
			tag = "manage/deathNotice_detailByPrisoner.action";
			
		}else if("removeDetain".equals(type)){
			tag = "manage/removeDetain_detailByPrisoner.action";
			
		}else if("jiangcheng".equals(type)){
			tag = "manage/jiangcheng_detailByPrisoner.action";
		}else if("riskAssess".equals(type)){
			tag = "manage/riskAssess_detailByPrisoner.action";
		}		
		
		tag += "?id="+id;
		return "success";
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
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

	public String getPrisonerId() {
		return prisonerId;
	}

	public void setPrisonerId(String prisonerId) {
		this.prisonerId = prisonerId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getHasDoc() {
		return hasDoc;
	}

	public void setHasDoc(String hasDoc) {
		this.hasDoc = hasDoc;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isIs_has_image() {
		return is_has_image;
	}

	public void setIs_has_image(boolean is_has_image) {
		this.is_has_image = is_has_image;
	}
	

//	public List<Note> getPrisonerList() {
//		return prisonerList;
//	}
//
//	public void setPrisonerList(List<Note> prisonerList) {
//		this.prisonerList = prisonerList;
//	}

}
