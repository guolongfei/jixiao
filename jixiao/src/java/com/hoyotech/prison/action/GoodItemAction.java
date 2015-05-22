package com.hoyotech.prison.action;

import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.hoyotech.prison.bean.GoodItem;
import com.hoyotech.prison.bean.GoodSell;
import com.hoyotech.prison.bean.Prisoner;
import com.hoyotech.prison.bean.SthIn;
import com.hoyotech.prison.service.impl.GoodItemService;
import com.hoyotech.prison.util.PrisonUtil;
import com.isa.pims.basic.ServletRequestUtils;

public class GoodItemAction {
	GoodItemService goodItemService;
	private GoodItem goodItem;
	private GoodSell goodSell;
	private SthIn sthIn;
	private int pageNum;
	private int limit; 
	private int totalPage;
	private int totalNum;
	
	private List<Prisoner> prisonerList;
	private List<GoodSell> sellList;
	private List<GoodItem> goodItemList;
	private List<SthIn> sthInList;
	private BigDecimal canUse; //可用金额
	/**
	 * 添加修改U商品
	 * @return
	 * @createDate 2014年12月18日
	 * @author mw
	 */
	public String add(){
		HttpServletRequest request = ServletActionContext.getRequest();
		goodItem.setPrisonCode(PrisonUtil.getPrisonCode(request));
		if(StringUtils.isNotBlank(goodItem.getId())){
			GoodItem g = goodItemService.get(goodItem.getId());
			goodItem.setAddTime(g.getAddTime());
			goodItemService.modify(goodItem);
		}else{
			goodItemService.addGoodItem(goodItem);
		}
		return "add";
	}
	
	/**
	 * 添加修改页面
	 * @return
	 * @createDate 2014年12月19日
	 * @author mw
	 */
	public String addUI(){
		if(goodItem!=null){
			goodItem = goodItemService.get(goodItem.getId());
		}
		return "addUI";
	}
	
	/**
	 * 查询商品
	 * @return
	 * @createDate 2014年12月18日
	 * @author mw
	 */
	public String select(){
		HttpServletRequest request = ServletActionContext.getRequest();
		pageNum = ServletRequestUtils.getInt(request, "page","1");
		limit = ServletRequestUtils.getInt(request, "limit","20");
		String prisonCode=PrisonUtil.getPrisonCode(request);
		if(goodItem==null)
			goodItem = new GoodItem();
		goodItemList = goodItemService.queryGoodList(goodItem.getItemName(), pageNum, limit, prisonCode);
		totalNum = goodItemService.getCount(goodItem.getItemName(), prisonCode);
		totalPage=(totalNum-1)/limit+1;
		return "list";
	}
	/**
	 * 进入消费登记页面
	 * @return
	 * @createDate 2014年12月19日
	 * @author mw
	 */
	public String sellReg(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String prisonCode = PrisonUtil.getPrisonCode(request);
		String prisonId = PrisonUtil.getPrisonId(request);
		prisonerList = goodItemService.queryPrsionerList(prisonId);
		goodItemList = goodItemService.queryGoodItemList(prisonCode);
		return "sell_show";
	}
	/**
	 * 获取消费列表
	 * 
	 * @createDate 2014年12月22日
	 * @author mw
	 */
	public void getPrisonerSellList(){
		HttpServletRequest request = ServletActionContext.getRequest();
		JSONObject json = new JSONObject();
		sellList = goodItemService.queryGoodSellList(request.getParameter("prisonerId"));
		//canUse = goodItemService.queryCanUseMoney(prisonId);
		json.put("selllist", sellList);
		//json.put("canUse", canUse);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		try {
			Gson gson = new Gson();
			PrintWriter out = response.getWriter();
			out.println(gson.toJson(json));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addSell(){
		HttpServletRequest request = ServletActionContext.getRequest();
		goodSell.setPrisonCode(PrisonUtil.getPrisonCode(request));
		goodItemService.insertSellList(goodSell);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		JSONObject json = new JSONObject();
		json.put("result", 0);
		try {
			PrintWriter out = response.getWriter();
			out.println(JSON.toJSONString(json));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String sthInUi(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String prisonId = PrisonUtil.getPrisonId(request);
		prisonerList = goodItemService.queryPrsionerList(prisonId);
		return "sthInUI";
	}
	
	public void getSthInListAndSellList(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		JSONObject json = new JSONObject();
		sellList = goodItemService.queryGoodSellList(request.getParameter("prisonerId"));
		sthInList = goodItemService.querySthIn(request.getParameter("prisonerId"));
		json.put("selllist", sellList);
		json.put("sthInList", sthInList);
		try {
			PrintWriter out = response.getWriter();
			out.println(JSON.toJSONString(json));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addSthIn(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		sthIn.setPrisonCode(PrisonUtil.getPrisonCode(request));
		goodItemService.addSthIn(sthIn);
		JSONObject json = new JSONObject();
		json.put("result", 0);
		try {
			PrintWriter out = response.getWriter();
			out.println(JSON.toJSONString(json));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void insertSellList(){
		goodItemService.insertSellList(goodSell);
	} 

	public GoodItemService getGoodItemService() {
		return goodItemService;
	}

	public void setGoodItemService(GoodItemService goodItemService) {
		this.goodItemService = goodItemService;
	}

	public GoodItem getGoodItem() {
		return goodItem;
	}

	public void setGoodItem(GoodItem goodItem) {
		this.goodItem = goodItem;
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

	public List<GoodItem> getGoodItemList() {
		return goodItemList;
	}

	public void setGoodItemList(List<GoodItem> goodItemList) {
		this.goodItemList = goodItemList;
	}

	public List<Prisoner> getPrisonerList() {
		return prisonerList;
	}

	public void setPrisonerList(List<Prisoner> prisonerList) {
		this.prisonerList = prisonerList;
	}

	public List<GoodSell> getSellList() {
		return sellList;
	}

	public void setSellList(List<GoodSell> sellList) {
		this.sellList = sellList;
	}

	public BigDecimal getCanUse() {
		return canUse;
	}

	public void setCanUse(BigDecimal canUse) {
		this.canUse = canUse;
	}

	public GoodSell getGoodSell() {
		return goodSell;
	}

	public void setGoodSell(GoodSell goodSell) {
		this.goodSell = goodSell;
	}

	public List<SthIn> getSthInList() {
		return sthInList;
	}

	public void setSthInList(List<SthIn> sthInList) {
		this.sthInList = sthInList;
	}

	public SthIn getSthIn() {
		return sthIn;
	}

	public void setSthIn(SthIn sthIn) {
		this.sthIn = sthIn;
	}
}
