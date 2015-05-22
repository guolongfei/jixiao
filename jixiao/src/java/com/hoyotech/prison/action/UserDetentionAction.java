package com.hoyotech.prison.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hoyotech.prison.bean.DetentionArea;
import com.hoyotech.prison.bean.DetentionInfo;
import com.hoyotech.prison.bean.User;
import com.hoyotech.prison.bean.UserDetention;
import com.hoyotech.prison.log.LogFactory;
import com.hoyotech.prison.service.impl.UserDetentionService;
import com.hoyotech.prison.util.ConfigHelper;
import com.hoyotech.prison.util.PrisonUtil;

public class UserDetentionAction {

	private UserDetentionService userDetentionService;
	private UserDetention userDetention;
	private String[] detentionInfoId;
	private String selectIds;
	private List<DetentionArea> detentionAreaList;
	private String id;

	private LogFactory log;
	
	/**
	 * 进入配置拘室权限的页面
	 * @return
	 */
	public String editUI() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String prisonId = PrisonUtil.getPrisonId(request);
		detentionAreaList = userDetentionService.getDetentionList(prisonId);
		selectIds = userDetentionService.getSelectedList(id);
		return "edit";
	}
	
	/**
	 * 添加拘室权限
	 * @return
	 */
	public String add(){
		userDetentionService.delete(id);
		UserDetention userDetention = null;
		for(String infoId : detentionInfoId){
			userDetention = new UserDetention(new User(id), new DetentionInfo(infoId));
			userDetentionService.add(userDetention);
		}
		
		// 添加日志
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "修改成功。修改了用户id为"+id+"的视频监控权限";
		log.getModifyLogMessage(null, null, config.getUpdate(), operate, config.getUserDetention(), config.getSucceed(), request);
		return "Edit";
	}
	
	public LogFactory getLog() {
		return log;
	}

	public void setLog(LogFactory log) {
		this.log = log;
	}

	public UserDetentionService getUserDetentionService() {
		return userDetentionService;
	}

	public void setUserDetentionService(
			UserDetentionService userDetentionService) {
		this.userDetentionService = userDetentionService;
	}

	public UserDetention getUserDetention() {
		return userDetention;
	}

	public void setUserDetention(UserDetention userDetention) {
		this.userDetention = userDetention;
	}

	public String[] getDetentionInfoId() {
		return detentionInfoId;
	}

	public void setDetentionInfoId(String[] detentionInfoId) {
		this.detentionInfoId = detentionInfoId;
	}

	public List<DetentionArea> getDetentionAreaList() {
		return detentionAreaList;
	}

	public void setDetentionAreaList(List<DetentionArea> detentionAreaList) {
		this.detentionAreaList = detentionAreaList;
	}

	public String getSelectIds() {
		return selectIds;
	}

	public void setSelectIds(String selectIds) {
		this.selectIds = selectIds;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
