package com.hoyotech.prison.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.hoyotech.prison.bean.Room;
import com.hoyotech.prison.bean.JX_Department;
import com.hoyotech.prison.bean.RoomDetail;
import com.hoyotech.prison.service.impl.RoomService;
import com.hoyotech.prison.service.impl.JX_DepartmentService;

public class MobileRoomManageAction {
	
	private RoomService roomService;
		
	public RoomService getRoomService() {
		return roomService;
	}
    private List<Room> list;
    private int pageNum;
    private int totalNum;
	private JX_DepartmentService jxDepartmentService;

	public JX_DepartmentService getJxDepartmentService() {
		return jxDepartmentService;
	}

	public void setJxDepartmentService(JX_DepartmentService jxDepartmentService) {
		this.jxDepartmentService = jxDepartmentService;
	}
	
	
	private int totalPage;
    private String roomName;
    private String room_id;
    private String user_id;
	private String room_server_id;
    
	private List<JX_Department> listDept;

    
	public String getUser_id() {
		return user_id;
	}

	public String getRoom_server_id() {
		return room_server_id;
	}

	public void setRoom_server_id(String roomServerId) {
		room_server_id = roomServerId;
	}

	public void setUser_id(String userId) {
		user_id = userId;
	}

	public String getRoom_id() {
		return room_id;
	}

	public void setRoom_id(String roomId) {
		room_id = roomId;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public List<Room> getList() {
		return list;
	}

	public void setList(List<Room> list) {
		this.list = list;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}


	public void setRoomService(RoomService roomService) {
		this.roomService = roomService;
	}

    //获取工作组列表
	public String getRoomList()
	{
		if(pageNum==0)
		{
			pageNum=1;
		}
		list=roomService.getRoomList(pageNum,roomName);
		totalNum=roomService.getTotalMessageSize(roomName);
		totalPage = (totalNum - 1) / 10 + 1;
		return "roomList";
	}
	
	//删除工作组
	public String deleteRoom()
	{
		roomService.deleteRoom(room_id);
		return getRoomList();
	}
	
	public void get_rooms(){
	
		try {
			HttpServletResponse response=ServletActionContext.getResponse();
			HttpServletRequest request=ServletActionContext.getRequest();
			String callback = request.getParameter("callback");
			 response.setContentType("text/json"); 
			 response.setCharacterEncoding("UTF-8"); 
				JSONObject json = new JSONObject();
				JSONArray arr = new JSONArray();
			PrintWriter out=response.getWriter();
			List<RoomDetail> list=roomService.getRooms(user_id);
			if(list==null || list.size()==0){
				json.put("errorMsg", "用户没有加入任何工作组");
			}else{
//				System.out.println("---------------"+list.size());
				json.put("errorMsg", "success");
				for(int i=0;i<list.size();i++){
					JSONObject j = new JSONObject();
					j.put("room_id", list.get(i).getRoom_id());
					//System.out.println(list.get(i).getRoom_id());
					j.put("room_server_id", list.get(i).getRoom_server_id());
					System.out.println( list.get(i).getRoom_server_id());
					j.put("room_name", list.get(i).getRoom_name());
					//System.out.println(j.toString()+"----------------");
					arr.put(i,j);
				}
			}
			json.put("result", arr);
			out.print(callback + "(" + json + ")");
//			out.println(json);
			out.flush();
			out.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	
	public void get_users(){
		
		try {
			HttpServletResponse response=ServletActionContext.getResponse();
			HttpServletRequest request=ServletActionContext.getRequest();
			String callback = request.getParameter("callback");
			 response.setContentType("text/json"); 
			 response.setCharacterEncoding("UTF-8"); 
				JSONObject json = new JSONObject();
				JSONArray arr = new JSONArray();
			PrintWriter out=response.getWriter();
			List<RoomDetail> list=roomService.getUsers(room_server_id);
			if(list==null||list.size()==0){
				json.put("errorMsg", "工作组没有用户存在");
			}else{
//				System.out.println("---------------"+list.size());
				json.put("errorMsg", "success");
				for(int i=0;i<list.size();i++){
					JSONObject j = new JSONObject();
					j.put("user_id", list.get(i).getMember_id());
					//System.out.println(list.get(i).getRoom_id());
					j.put("user_name", list.get(i).getMember_name());
//					System.out.println( list.get(i).getRoom_server_id());
					j.put("user_department", list.get(i).getMember_department());
					//System.out.println(j.toString()+"----------------");
					arr.put(i,j);
				}
			}
			json.put("result", arr);
//			out.println(json);
			out.print(callback + "(" + json + ")");
			out.flush();
			out.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	
	
	
	
	
	

}
