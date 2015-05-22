package com.hoyotech.prison.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hoyotech.prison.bean.ContrabandGoods;
import com.hoyotech.prison.bean.Police;
import com.hoyotech.prison.bean.PrisonerContrabandGoods;
import com.hoyotech.prison.log.LogFactory;
import com.hoyotech.prison.service.impl.DictionaryService;
import com.hoyotech.prison.service.impl.PrisonerContrabandGoodsService;
import com.hoyotech.prison.util.ConfigHelper;
import com.hoyotech.prison.util.ObjectUpdateUtil;
import com.hoyotech.prison.util.PrisonUtil;

public class ContrabandGoodsAction {

	private PrisonerContrabandGoodsService prisonerContrabandGoodsService;
	private DictionaryService dictionaryService;
	private List<PrisonerContrabandGoods> list;
	
	private PrisonerContrabandGoods prisonerContrabandGoods;
	private ContrabandGoods contrabandGoods;

	private String id;
	private String prisonerId;
	private String type;
	private List<Police> policelist;

	private LogFactory log;
	
	public String detail(){
		prisonerContrabandGoods = prisonerContrabandGoodsService.detailByPrisoner(id);
		return "detail";
	}
	
	public String detailByPrisoner(){
		prisonerContrabandGoods = prisonerContrabandGoodsService.detailByPrisoner(id);
		return "detail";
	}
	
	public String addUI(){
		selectPolice();
		prisonerId = id;
		type = "contrabandGoods";
		return "addUI";
	}
	
	public void selectPolice(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String prisonCode=PrisonUtil.getPrisonCode(request);
		policelist=dictionaryService.selectPolice(prisonCode);
	}
	
	public String addGoodsUI(){
		selectPolice();
		prisonerContrabandGoods = prisonerContrabandGoodsService.detail(id);
		prisonerId = prisonerContrabandGoods.getPrisoner().getId();
		return "addGoodsUI";
	}
	
	/**
	 * 添加涉案装备
	 * @return
	 */
	public String addContrabandGoods(){
		HttpServletRequest request=ServletActionContext.getRequest();
		String prisonCode=PrisonUtil.getPrisonCode(request);
		contrabandGoods.setPrisonCode(prisonCode);
		prisonerContrabandGoodsService.addContrabandGoods(contrabandGoods);
		
		// 添加日志
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "添加成功。";
		log.getInsertLogMessage(contrabandGoods, config.getInsert(), operate, config.getContrabandGood(), config.getSucceed(), request);
		return "seccess";
	}
	
	/**
	 * 添加
	 * @return
	 */
	public String add(){
		addContrabandGoods();
		prisonerContrabandGoods.setNoYear(PrisonUtil.getYear());//添加流水号
		prisonerContrabandGoods.setNoNumber(dictionaryService.getNo("PrisonerContrabandGoods"));
		HttpServletRequest request=ServletActionContext.getRequest();
		String prisonCode=PrisonUtil.getPrisonCode(request);
		prisonerContrabandGoods.setPrisonCode(prisonCode);
		prisonerContrabandGoodsService.add(prisonerContrabandGoods);
		id = prisonerContrabandGoods.getPrisoner().getId();
		type = "contrabandGoods";
		
		// 添加日志
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "添加成功。";
		log.getInsertLogMessage(prisonerContrabandGoods, config.getInsert(), operate, config.getContrabandGood(), config.getSucceed(), request);
		return "main";
	}
	/**
	 * 添加涉案物品
	 * @return
	 */
	public String add1(){
		addContrabandGoods();
		
		id = prisonerContrabandGoods.getId();
		PrisonerContrabandGoods object = prisonerContrabandGoodsService.detail(id);
		ObjectUpdateUtil.compareProperty(prisonerContrabandGoods, object);
		prisonerContrabandGoodsService.update(object);
		
		id = prisonerContrabandGoods.getPrisoner().getId();
		
		// 添加日志
		PrisonerContrabandGoods old_obj = prisonerContrabandGoodsService.detail(id);
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "修改成功。";
		log.getModifyLogMessage(object, old_obj, config.getUpdate(), operate, config.getContrabandGood(), config.getSucceed(), request);
		return "Detail";
	}

	public String doc(){
		prisonerContrabandGoods = prisonerContrabandGoodsService.detailByPrisoner(prisonerId);
		return "doc";
	}

	public PrisonerContrabandGoodsService getPrisonerContrabandGoodsService() {
		return prisonerContrabandGoodsService;
	}

	public void setPrisonerContrabandGoodsService(
			PrisonerContrabandGoodsService prisonerContrabandGoodsService) {
		this.prisonerContrabandGoodsService = prisonerContrabandGoodsService;
	}

	public DictionaryService getDictionaryService() {
		return dictionaryService;
	}

	public void setDictionaryService(DictionaryService dictionaryService) {
		this.dictionaryService = dictionaryService;
	}

	public List<Police> getPolicelist() {
		return policelist;
	}

	public void setPolicelist(List<Police> policelist) {
		this.policelist = policelist;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<PrisonerContrabandGoods> getList() {
		return list;
	}

	public void setList(List<PrisonerContrabandGoods> list) {
		this.list = list;
	}

	public PrisonerContrabandGoods getPrisonerContrabandGoods() {
		return prisonerContrabandGoods;
	}

	public void setPrisonerContrabandGoods(
			PrisonerContrabandGoods prisonerContrabandGoods) {
		this.prisonerContrabandGoods = prisonerContrabandGoods;
	}

	public ContrabandGoods getContrabandGoods() {
		return contrabandGoods;
	}

	public void setContrabandGoods(ContrabandGoods contrabandGoods) {
		this.contrabandGoods = contrabandGoods;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPrisonerId() {
		return prisonerId;
	}

	public void setPrisonerId(String prisonerId) {
		this.prisonerId = prisonerId;
	}

	public LogFactory getLog() {
		return log;
	}

	public void setLog(LogFactory log) {
		this.log = log;
	}
	
}
