package com.hoyotech.prison.action;

import com.hoyotech.prison.service.impl.HomePageService;

public class OnLine_Test{
	private Integer onLine_Number;
	private HomePageService pageService;
	

	public String getNumber(){
		onLine_Number = pageService.getUserNumber().size();
		if(onLine_Number==null){
			onLine_Number=0;
		}
		//System.out.println(onLine_Number);
		return "number";
	}
	

	public void setOnLine_Number(Integer onLine_Number) {
		this.onLine_Number = onLine_Number;
	}

	public HomePageService getPageService() {
		return pageService;
	}


	public void setPageService(HomePageService pageService) {
		this.pageService = pageService;
	}


	public Integer getOnLine_Number() {
		return onLine_Number;
	}
	
}
