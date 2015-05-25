package com.hoyotech.prison.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import org.apache.struts2.ServletActionContext;
import com.hoyotech.prison.bean.JX_User;
import com.hoyotech.prison.log.LogFactory;
import com.hoyotech.prison.service.impl.FriendService;
import com.hoyotech.prison.service.impl.HomePageService;
import com.hoyotech.prison.dao.impl.BasicDao;
import com.hoyotech.prison.dao.impl.DictionaryDao;



public class MobileFriendAction {
	private String user_Name_Me;//主用户名
	private String user_Name_Des;//目标用户名
	private JX_User user;
	private String user_Id_Me;//主用户ID
	private String user_Id_Des;//目标用户ID
	private List<JX_User> friend_List;//好友列表
	private HomePageService pageService;//引用HomePageService

	

		
	
	public void FriendshipOptError(){

	}
}