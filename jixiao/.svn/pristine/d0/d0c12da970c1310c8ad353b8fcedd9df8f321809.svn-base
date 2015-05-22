package com.hoyotech.prison.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hoyotech.prison.bean.Dictionary;
import com.hoyotech.prison.bean.DrugManage;
import com.hoyotech.prison.bean.Medical;
import com.hoyotech.prison.bean.Police;
import com.hoyotech.prison.bean.Prisoner;
import com.hoyotech.prison.bean.PrisonerHealth;
import com.hoyotech.prison.bean.TakeMedicine;
import com.hoyotech.prison.log.LogFactory;
import com.hoyotech.prison.service.impl.DictionaryService;
import com.hoyotech.prison.service.impl.MedicalTreatmentService;
import com.hoyotech.prison.service.impl.PrisonerHealthService;
import com.hoyotech.prison.service.impl.PrisonerService;
import com.hoyotech.prison.util.ConfigHelper;
import com.hoyotech.prison.util.ObjectUpdateUtil;
import com.hoyotech.prison.util.PrisonUtil;
import com.hoyotech.prison.util.Type;

public class PrisonerHealthAction {

	private PrisonerHealthService prisonerHealthService;
	private PrisonerService prisonerServer;
	private MedicalTreatmentService medicalTreatmentService;
	private DictionaryService dictionaryService;
	private Prisoner prisoner;
	private PrisonerHealth prisonerHealth;
	private String id ;
	
	private List<Dictionary> dragHistoryList;
	private List<Dictionary> isFectionList;
	
	private LogFactory log;
	private List<Police> policelist;
	private List<Medical> medicallist;
	
	private String type;
	
	// 向导添加的参数
	private String mode;
	private String step;
	private String complete;
	
	private List<TakeMedicine> takeMedicList;
	private TakeMedicine takeMedic;
	private List<DrugManage> drugList;
	public void selectPolice(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String prisonCode=PrisonUtil.getPrisonCode(request);
		policelist=dictionaryService.selectPolice(prisonCode);
		medicallist=dictionaryService.selectMedical(prisonCode);
	}
	
	/**
	 * 进入添加页面
	 * @return
	 */
	public String addUI(){
		selectPolice();
		dragHistoryList = dictionaryService.selectDictionary(Type.DRUG_HISTORY_TYPE);
		isFectionList = dictionaryService.selectDictionary(Type.IS_INFECTION_TYPE);
		return "addUI";
	}
	
	/**
	 * 添加
	 * @return
	 */
	public String add(){
		HttpServletRequest request = ServletActionContext.getRequest();
		prisonerHealth.setPrisonCode(PrisonUtil.getPrisonCode(request));
		prisonerHealth.setNoYear(PrisonUtil.getYear());//添加流水号
		prisonerHealth.setNoNumber(dictionaryService.getNo("PrisonerHealth"));

		id = prisonerHealthService.add(prisonerHealth);
		id = prisonerHealth.getPrisoner().getId();
		
		type = "prisonerHealth";
		
		// 添加日志
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "添加成功。";
		log.getInsertLogMessage(prisonerHealth, config.getInsert(), operate, config.getPrisonHealth(), config.getSucceed(), request);
		
		if("wizard".equals(mode)){
			// 快速添加
			step = "3";
			complete = "2";
			return "next";
			
		}else{
			return "main";//全局跳转
		}
		
	}
	
	/**
	 * 修改
	 * @return
	 */
	public String edit(){
		id = prisonerHealth.getId();
		PrisonerHealth obj = prisonerHealthService.detail(id);
		PrisonerHealth old_obj = prisonerHealthService.detail(id);
		ObjectUpdateUtil.compareProperty(prisonerHealth, obj);
		
		prisonerHealthService.update(obj);
		
		// 添加日志
		
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "修改成功。";
		log.getModifyLogMessage(obj, old_obj, config.getUpdate(), operate, config.getPrisonHealth(), config.getSucceed(), request);
		return "Detail";
	}
	
	/**
	 * 进入修改页
	 * @return
	 */
	public String editUI(){
		selectPolice();
		dragHistoryList = dictionaryService.selectDictionary(Type.DRUG_HISTORY_TYPE);
		isFectionList = dictionaryService.selectDictionary(Type.IS_INFECTION_TYPE);
		prisonerHealth = prisonerHealthService.detail(id);
		return "editUI";
	}
	
	/**
	 * 详细
	 * @return
	 */
	public String detail(){
		prisonerHealth = prisonerHealthService.detail(id);
		return "detail";
	}
	
	public String detailByPrisoner(){
		prisonerHealth = prisonerHealthService.detailByPrisoner(id);
		return "detail";
	}
	
	public String queryTakeMedicList(){
		HttpServletRequest request = ServletActionContext.getRequest();
		takeMedicList = prisonerHealthService.queryTakeMedicList(id);
		drugList = this.medicalTreatmentService.getDrugList(PrisonUtil.getPrisonCode(request));
		return "selectMedicList";
	}
	
	public String insertTakeMedic(){
		HttpServletRequest request = ServletActionContext.getRequest();
		takeMedic.setPrisonCode(PrisonUtil.getPrisonCode(request));
		takeMedic.setState(0);
		takeMedic.setStartTime(Long.toString(convertStringToLongDate(takeMedic.getStartTime())));
		takeMedic.setPrisoner(id);
		prisonerHealthService.insertTakeMedic(takeMedic);
		return "insertTakeMedicState";
	}
	
	public String updateTakeMedicState(){
		prisonerHealthService.updateTakeMedicState(id);
		return "insertTakeMedicState";
	}
	
	/**
	 * 打印法律文书
	 * @return
	 */
	public String doc(){
		prisonerHealth = prisonerHealthService.detail(id);
		return "doc";
	}
	
	public List<Medical> getMedicallist() {
		return medicallist;
	}

	public void setMedicallist(List<Medical> medicallist) {
		this.medicallist = medicallist;
	}

	public List<Police> getPolicelist() {
		return policelist;
	}

	public void setPolicelist(List<Police> policelist) {
		this.policelist = policelist;
	}

	public LogFactory getLog() {
		return log;
	}

	public void setLog(LogFactory log) {
		this.log = log;
	}

	public PrisonerHealthService getPrisonerHealthService() {
		return prisonerHealthService;
	}

	public void setPrisonerHealthService(PrisonerHealthService prisonHealthService) {
		this.prisonerHealthService = prisonHealthService;
	}

	public PrisonerService getPrisonerServer() {
		return prisonerServer;
	}

	public void setPrisonerServer(PrisonerService prisonerServer) {
		this.prisonerServer = prisonerServer;
	}

	public DictionaryService getDictionaryService() {
		return dictionaryService;
	}

	public void setDictionaryService(DictionaryService dictionaryService) {
		this.dictionaryService = dictionaryService;
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

	public List<Dictionary> getDragHistoryList() {
		return dragHistoryList;
	}

	public void setDragHistoryList(List<Dictionary> dragHistoryList) {
		this.dragHistoryList = dragHistoryList;
	}

	public List<Dictionary> getIsFectionList() {
		return isFectionList;
	}

	public void setIsFectionList(List<Dictionary> isFectionList) {
		this.isFectionList = isFectionList;
	}

	public PrisonerHealth getPrisonerHealth() {
		return prisonerHealth;
	}

	public void setPrisonerHealth(PrisonerHealth prisonerHealth) {
		this.prisonerHealth = prisonerHealth;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getStep() {
		return step;
	}

	public void setStep(String step) {
		this.step = step;
	}

	public String getComplete() {
		return complete;
	}

	public void setComplete(String complete) {
		this.complete = complete;
	}
	
	
	public MedicalTreatmentService getMedicalTreatmentService() {
		return medicalTreatmentService;
	}

	public void setMedicalTreatmentService(
			MedicalTreatmentService medicalTreatmentService) {
		this.medicalTreatmentService = medicalTreatmentService;
	}

	public List<TakeMedicine> getTakeMedicList() {
		return takeMedicList;
	}

	public void setTakeMedicList(List<TakeMedicine> takeMedicList) {
		this.takeMedicList = takeMedicList;
	}

	public TakeMedicine getTakeMedic() {
		return takeMedic;
	}

	public void setTakeMedic(TakeMedicine takeMedic) {
		this.takeMedic = takeMedic;
	}

	public List<DrugManage> getDrugList() {
		return drugList;
	}

	public void setDrugList(List<DrugManage> drugList) {
		this.drugList = drugList;
	}

	public long convertStringToLongDate(String str){
		SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			Date d = formatDate.parse(str);
			return (d.getTime()/1000);
		} catch (ParseException e) {
			e.printStackTrace();
			return 0;
		}
	}
	public static void main(String[] args) {
		SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String a = "1368288734";
		Date d = new Date();
		d.setTime(Long.parseLong(a)*1000);
		System.out.println(formatDate.format(d));
	}
}
