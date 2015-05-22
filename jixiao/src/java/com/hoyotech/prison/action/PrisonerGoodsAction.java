package com.hoyotech.prison.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hoyotech.prison.bean.Goods;
import com.hoyotech.prison.bean.Police;
import com.hoyotech.prison.bean.PrisonerGoods;
import com.hoyotech.prison.log.LogFactory;
import com.hoyotech.prison.service.impl.DictionaryService;
import com.hoyotech.prison.service.impl.PrisonerGoodsService;
import com.hoyotech.prison.util.ConfigHelper;
import com.hoyotech.prison.util.ObjectUpdateUtil;
import com.hoyotech.prison.util.PrisonUtil;

public class PrisonerGoodsAction {

	private PrisonerGoodsService prisonerGoodsService;
	private DictionaryService dictionaryService;
	private Goods goods;
	private PrisonerGoods prisonerGoods;
	private List<Police> policelist;

	private String id;
	private String prisonerId;
	private String type;
	
	private LogFactory log;
	
	// 向导添加的参数
	private String mode;
	private String step;
	private String complete;
	
	public String addUI(){
		selectPolice();
		prisonerId = id;
		return "addUI";
	}
	
	public void selectPolice(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String prisonCode=PrisonUtil.getPrisonCode(request);
		policelist=dictionaryService.selectPolice(prisonCode);
	}
	
	public String addGoodsUI(){
		selectPolice();
		prisonerGoods = prisonerGoodsService.detail(id);
		prisonerId = prisonerGoods.getPrisoner().getId();
		return "addGoods";
	}
	
	public String detail(){
		prisonerGoods = prisonerGoodsService.detailByPrisoner(id);
		return "detail";
	}
	
	public String detailByPrisoner(){
		prisonerGoods = prisonerGoodsService.detailByPrisoner(id);
		return "detail";
	}
	
	/**
	 * 添加物品
	 * @return
	 */
	public String addGoods(){
		HttpServletRequest request=ServletActionContext.getRequest();
		String prisonCode=PrisonUtil.getPrisonCode(request);
		goods.setPrisonCode(prisonCode);
		prisonerGoodsService.addGoods(goods);
		
		// 添加日志
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "添加成功。";
		log.getInsertLogMessage(goods, config.getInsert(), operate, config.getPrisonerGoods(), config.getSucceed(), request);
		
		id = goods.getPrisoner().getId();
		
		if("wizard".equals(mode)){
			step = "3";
			complete = "3";
		}
		return "Detail";
	}
	
	/**
	 * 添加物品及物品清单
	 * @return
	 */
	public String add(){
		addGoods();
		
		prisonerGoods.setNoYear(PrisonUtil.getYear());//添加流水号
		prisonerGoods.setNoNumber(dictionaryService.getNo("PrisonerGoods"));
		HttpServletRequest request=ServletActionContext.getRequest();
		String prisonCode=PrisonUtil.getPrisonCode(request);
		prisonerGoods.setPrisonCode(prisonCode);
		prisonerGoodsService.add(prisonerGoods);
		id = prisonerGoods.getPrisoner().getId();
		type = "prisonerGoods";
		
		// 添加日志
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "添加成功。";
		log.getInsertLogMessage(prisonerGoods, config.getInsert(), operate, config.getPrisonerGoods(), config.getSucceed(), request);
		
		if("wizard".equals(mode)){
			step = "3";
			complete = "3";
			return "Detail";
		}else{
			return "main";
		}
	}
	
	/**
	 * 进入物品清单修改页
	 * @return
	 */
	public String editUI(){
		selectPolice();
		prisonerGoods = prisonerGoodsService.detail(id);
		return "edit";
	}
	
	/**
	 * 进入物品修改页
	 * @return
	 */
	public String editGoodsUI(){
		selectPolice();
		goods = prisonerGoodsService.detailGoods(id);
		return "editGoods";
	}
	
	/**
	 * 修改物品清单
	 * @return
	 */
	public String edit(){
		PrisonerGoods object = prisonerGoodsService.detail(prisonerGoods.getId());
		PrisonerGoods old_object = prisonerGoodsService.detail(prisonerGoods.getId());
		ObjectUpdateUtil.compareProperty(prisonerGoods, object);
		prisonerGoodsService.update(object);

		// 添加日志
		HttpServletRequest request=ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "修改成功。";
		log.getModifyLogMessage(object, old_object, config.getUpdate(), operate, config.getPrisonerGoods(), config.getSucceed(), request);
		
		id = object.getPrisoner().getId();
		return "Detail";
	}
	
	/**
	 * 修改物品
	 * @return
	 */
	public String editGoods(){
		Goods old_object = prisonerGoodsService.detailGoods(goods.getId());
		Goods object = prisonerGoodsService.detailGoods(goods.getId());
		ObjectUpdateUtil.compareProperty(goods, object);
		prisonerGoodsService.updateGoods(object);

		// 添加日志
		HttpServletRequest request=ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "修改成功。";
		log.getModifyLogMessage(object, old_object, config.getUpdate(), operate, config.getPrisonerGoods(), config.getSucceed(), request);
		
		
		id = object.getPrisoner().getId();
		return "Detail";
	}
	
	
	public String doc(){
		prisonerGoods = prisonerGoodsService.detailByPrisoner(prisonerId);
		return "doc";
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

	public DictionaryService getDictionaryService() {
		return dictionaryService;
	}

	public void setDictionaryService(DictionaryService dictionaryService) {
		this.dictionaryService = dictionaryService;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public PrisonerGoods getPrisonerGoods() {
		return prisonerGoods;
	}

	public void setPrisonerGoods(PrisonerGoods prisonerGoods) {
		this.prisonerGoods = prisonerGoods;
	}

	public String getPrisonerId() {
		return prisonerId;
	}

	public void setPrisonerId(String prisonerId) {
		this.prisonerId = prisonerId;
	}

	public String getId() {
		return id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	public void setId(String id) {
		this.id = id;
	}

	public PrisonerGoodsService getPrisonerGoodsService() {
		return prisonerGoodsService;
	}

	public void setPrisonerGoodsService(PrisonerGoodsService prisonerGoodsService) {
		this.prisonerGoodsService = prisonerGoodsService;
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
}
