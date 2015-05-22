package com.hoyotech.prison.log;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.hoyotech.prison.dao.impl.BasicDao;
import com.hoyotech.prison.log.ip.IPLocation;
import com.hoyotech.prison.log.ip.IPSeeker;
import com.isa.pims.basic.StringUtils;

public class LogFactory {
	private IPSeeker posit;
	private DifferHelper differ;
	private BasicDao dao;

	/**
	 * 添加 操作
	 * 
	 */
	public void getInsertLogMessage(Object obj, int type, String operate, String moduleId, int state, HttpServletRequest request) {
		Message message = new Message();
		getSesssionMessage(message, request);
		message.setOperateId(type);
		message.setModuleName(moduleId);
		message.setState(state);
		getComparedMessage(message, obj, null);
		message.setOperate("【" + message.getUserName() + "】" + operate + message.getOperate());

		dao.save(message);
	}

	/**
	 * 修改、删除操作
	 * 
	 * @param newObj
	 * @param oldObj
	 * @param type
	 * @param operate
	 * @param moduleId
	 * @param status
	 * @param request
	 * 
	 * @since shendu_report　Ver1.0
	 */
	public void getModifyLogMessage(Object newObj, Object oldObj, int type, String operate, String moduleId, int state, HttpServletRequest request) {
		Message message = new Message();
		getSesssionMessage(message, request);
		message.setOperateId(type);
		message.setModuleName(moduleId);
		message.setState(state);
		getComparedMessage(message, newObj, oldObj);
		message.setOperate("【" + message.getUserName() + "】" + operate + message.getOperate());

		dao.save(message);
	}

	/**
	 * 查询操作
	 * 
	 * @param request
	 * @param type
	 *            操作类型
	 * @param operate
	 *            操作内容
	 * @param moduleId
	 *            模块ID
	 * @param status
	 *            操作状态
	 * 
	 * @since shendu_report　Ver1.0
	 */
	public void getQueryLogMessage(HttpServletRequest request, int type, String operate, String moduleId, int state) {
		Message message = new Message();
		getSesssionMessage(message, request);
		message.setOperateId(type);
		message.setOperate("【" + message.getUserName() + "】" + operate);
		message.setModuleName(moduleId);
		message.setState(state);

		dao.save(message);
	}

	/**
	 * 操作错误
	 * 
	 * @param request
	 * @param type
	 * @param operate
	 * @param moduleId
	 * @param status
	 */
	public void getErrorLogMessage(HttpServletRequest request, int type, String operate, String moduleId, int state) {
		Message message = new Message();
		getSesssionMessage(message, request);
		message.setOperateId(type);
		message.setOperate("【" + message.getUserName() + "】" + operate);
		message.setModuleName(moduleId);
		message.setState(state);

		dao.save(message);
	}

	/**
	 * 比较两个对象的内容，写入Message对象 同时记录当前时间
	 * 
	 * @param message
	 * @param newObj
	 *            新值
	 * @param oldObj
	 *            旧值
	 */
	protected void getComparedMessage(Message message, Object newObj, Object oldObj) {
		// operateRec操作记录字段————————拼成中文字符串
		String operateRec = differ.diffValues(newObj, oldObj);

		message.setOperate(operateRec);
		message.setTime(new Date());

	}

	/**
	 * 从 HttpServletRequest中，提起userid,username,request_ip信息
	 * 
	 * @param message
	 * @param request
	 */
	private void getSesssionMessage(Message message, HttpServletRequest request) {
		String userName = StringUtils.$C((String) request.getSession().getAttribute("userName"), "admin");
		String prisonCode = StringUtils.$C((String) request.getSession().getAttribute("prisonCode"), "");
		String ip = request.getHeader("X-Real-IP");
		String address = this.getIPAddress(ip);
		
		message.setUserName(userName);
		message.setIp(ip);
		message.setAddress(address);
		message.setTime(new Date());
		message.setPrisonCode(prisonCode);
	}

	/**
	 * 获得IP 对应的地址
	 * 
	 * @param ip
	 * @return
	 */
	protected String getIPAddress(String ip) {
		String postion = "";
		if (ip != null) {
			// 初始化,QQWry.Dat包

			IPLocation pos = posit.getIPLocation(ip);
			if (pos != null) {
				postion = pos.getCountry() + "  " + pos.getArea();
			}
		}
		return postion;
	}

	public IPSeeker getPosit() {
		return posit;
	}

	public void setPosit(IPSeeker posit) {
		this.posit = posit;
	}

	public BasicDao getDao() {
		return dao;
	}

	public void setDao(BasicDao dao) {
		this.dao = dao;
	}

	public DifferHelper getDiffer() {
		return differ;
	}

	public void setDiffer(DifferHelper differ) {
		this.differ = differ;
	}

}
