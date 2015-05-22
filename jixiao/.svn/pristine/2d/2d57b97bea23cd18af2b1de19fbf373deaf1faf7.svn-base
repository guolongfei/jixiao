package com.hoyotech.prison.service.impl;

import java.util.List;

import com.hoyotech.prison.bean.DevChnInfo;
import com.hoyotech.prison.dao.impl.BasicDao;

public class DevChannelService {

	private BasicDao dao;

	/**
	 * 根据拘室ID获取监控设备信息
	 * @param roomId
	 * @return
	 */
	public DevChnInfo getDevChaInfoByRoom(String roomId) {
		String hql = "from DevChnInfo where videoSoureId=?";
		List<DevChnInfo> list = (List<DevChnInfo>) dao.queryByHql(hql, new Object[] { roomId });
		return list.size() > 0 ? list.get(0) : new DevChnInfo();
	}

	public BasicDao getDao() {
		return dao;
	}

	public void setDao(BasicDao dao) {
		this.dao = dao;
	}

}
