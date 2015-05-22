package com.hoyotech.prison.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.hoyotech.prison.bean.DrugManage;
import com.hoyotech.prison.bean.DrugType;
import com.hoyotech.prison.service.impl.MedicalTreatmentService;
import com.hoyotech.prison.util.PrisonUtil;
import com.isa.pims.basic.ServletRequestUtils;

public class MedicalTreatmentAction {
	MedicalTreatmentService medicalTreatmentService;
	
	private DrugType drugtype;
	private List<DrugType> typeList;
	
	private DrugManage drugManage;
	private List<DrugManage> durgList;
	private int pageNum;
	private int limit; 
	private int totalPage;
	private int totalNum;
	/**
	 * 药品类别查询
	 * @return
	 * @createDate 2014年12月24日
	 * @author mw
	 */
	public String selectType(){
		HttpServletRequest request=ServletActionContext.getRequest();
		if(drugtype==null){
			drugtype = new DrugType();
		}
		pageNum = ServletRequestUtils.getInt(request, "page","1");
		limit = ServletRequestUtils.getInt(request, "limit","20");
		drugtype.setPrisonCode(PrisonUtil.getPrisonCode(request));
		typeList = medicalTreatmentService.queryDrugTypeByLimit(drugtype, pageNum, limit);
		totalNum = medicalTreatmentService.queryDurgTypeCount(drugtype);
		totalPage=(totalNum-1)/limit+1;
		return "selectType";
	}
	/**
	 * 药品类别添加
	 * @return
	 * @createDate 2014年12月24日
	 * @author mw
	 */
	public String addType(){
		HttpServletRequest request=ServletActionContext.getRequest();
		if(StringUtils.isNotBlank(drugtype.getId())){
			modifyType();
		}else{
			drugtype.setPrisonCode(PrisonUtil.getPrisonCode(request));
			medicalTreatmentService.addDrugType(drugtype);
		}
		return "addtype";
	}
	
	public String editeType(){
		if(drugtype!=null){
			drugtype = this.medicalTreatmentService.getDrugType(drugtype.getId());
		}
		return "editeTypeUI";
		
	}
	
	public String editeDrug(){
		HttpServletRequest request=ServletActionContext.getRequest();
		if(drugManage!=null){
			drugManage = this.medicalTreatmentService.getDrug(drugManage.getId());
		}
		typeList = medicalTreatmentService.getDrugTypeList(PrisonUtil.getPrisonCode(request));
		return "editeDrugUI";
		
	}
	
	/**
	 * 修改类别
	 * @return
	 * @createDate 2014年12月24日
	 * @author mw
	 */
	public String modifyType(){
		medicalTreatmentService.modifyType(drugtype);
		return "modifyType";
	}
	
	public String selectDrug(){
		HttpServletRequest request=ServletActionContext.getRequest();
		if(drugManage==null){
			drugManage = new DrugManage();
		}
		pageNum = ServletRequestUtils.getInt(request, "page","1");
		limit = ServletRequestUtils.getInt(request, "limit","20");
		drugManage.setPrisonCode(PrisonUtil.getPrisonCode(request));
		durgList = medicalTreatmentService.queryDrugListByLimit(drugManage, pageNum, limit);
		totalNum = medicalTreatmentService.quertDrugListCount(drugManage);
		totalPage=(totalNum-1)/limit+1;
		return "selectDrug";
	}
	
	public String addDrug(){
		HttpServletRequest request=ServletActionContext.getRequest();
		drugManage.setPrisonCode(PrisonUtil.getPrisonCode(request));
		if(StringUtils.isNotBlank(drugManage.getId())){
			modifyDrug();
		}else{
			medicalTreatmentService.addDrug(drugManage);
		}
		return "addDrug";
	}
	
	public String modifyDrug(){
		medicalTreatmentService.modifyDrug(drugManage);
		return "modifyDrug";
	}
	public MedicalTreatmentService getMedicalTreatmentService() {
		return medicalTreatmentService;
	}
	public void setMedicalTreatmentService(
			MedicalTreatmentService medicalTreatmentService) {
		this.medicalTreatmentService = medicalTreatmentService;
	}
	public DrugType getDrugtype() {
		return drugtype;
	}
	public void setDrugtype(DrugType drugtype) {
		this.drugtype = drugtype;
	}
	public List<DrugType> getTypeList() {
		return typeList;
	}
	public void setTypeList(List<DrugType> typeList) {
		this.typeList = typeList;
	}
	public DrugManage getDrugManage() {
		return drugManage;
	}
	public void setDrugManage(DrugManage drugManage) {
		this.drugManage = drugManage;
	}
	public List<DrugManage> getDurgList() {
		return durgList;
	}
	public void setDurgList(List<DrugManage> durgList) {
		this.durgList = durgList;
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
}
