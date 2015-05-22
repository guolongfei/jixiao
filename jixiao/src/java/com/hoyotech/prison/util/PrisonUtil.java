package com.hoyotech.prison.util;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import com.hoyotech.prison.dao.impl.BasicDao;

public class PrisonUtil {
	
	private BasicDao dao;
	
	/**
	 * 从session中获取拘留所ID
	 * @param request
	 * @return
	 */
	public static String getPrisonId(HttpServletRequest request) {
		String prisonId = (String) request.getSession().getAttribute("prisonId");
		return prisonId;
	}
	
	/**
	 * 从session中获取拘留所编码
	 * @param request
	 * @return
	 */
	public static String getPrisonCode(HttpServletRequest request) {
		String prisonCode = (String) request.getSession().getAttribute("prisonCode");
		return prisonCode;
	}

	public static String getYear(){
		Calendar cal = Calendar.getInstance();
		return String.valueOf(cal.get(Calendar.YEAR));
	}
	
	public BasicDao getDao() {
		return dao;
	}

	public void setDao(BasicDao dao) {
		this.dao = dao;
	}
	
}
