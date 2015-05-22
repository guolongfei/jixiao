package com.hoyotech.prison.action;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.loader.MultipleBagFetchException;

import net.sf.json.JSONObject;

import net.sf.json.JSONArray;
import com.hoyotech.prison.bean.JX_Department;
import com.hoyotech.prison.bean.JX_People;
import com.hoyotech.prison.bean.Room;
import com.hoyotech.prison.bean.RoomDetail;
import com.hoyotech.prison.service.impl.RoomService;
import com.hoyotech.prison.util.MultipleTree;
import com.opensymphony.xwork2.ActionContext;

public class RoomManagerAction {
	
	private RoomService roomService;
    private List<Room> list;
    private int pageNum;
    private int totalNum;
    private int totalPage;
    private String roomName;
    private String room_id;
    private String rmName;
    private String jsonString;
    private List<Object[]> memlist;
    private String ids;
    private List<Object[]> memlist1=new ArrayList<Object[]>();
    private List<RoomDetail> list1;
    
       
	public List<RoomDetail> getList1() {
		return list1;
	}

	public void setList1(List<RoomDetail> list1) {
		this.list1 = list1;
	}

	public List<Object[]> getMemlist1() {
		return memlist1;
	}

	public void setMemlist1(List<Object[]> memlist1) {
		this.memlist1 = memlist1;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public List<Object[]> getMemlist() {
		return memlist;
	}

	public void setMemlist(List<Object[]> memlist) {
		this.memlist = memlist;
	}

	public String getJsonString() {
		return jsonString;
	}

	public void setJsonString(String jsonString) {
		this.jsonString = jsonString;
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

	public RoomService getRoomService() {
		return roomService;
	}
	
	public void setRoomService(RoomService roomService) {
		this.roomService = roomService;
	}
	//添加工作组
	public String addRoom()
	{
		memlist1=null;
		return "addRoom";
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
		roomService.deleteRoomDetail(room_id);
		return getRoomList();
	}
	
	//保存工作组
	public String saveRoom() throws UnsupportedEncodingException
	{	
		String userName=(String) ServletActionContext.getRequest().getSession().getAttribute("userName");
		JSONObject json=JSONObject.fromObject(jsonString);
		String roomName1=URLDecoder.decode(rmName,"UTF-8");
		System.out.println(roomName1);
		String room_id1=json.getString("_id");
		String id[]=ids.split(",");
		Room r=new Room();
		r.setRoom_create_date(new Date());
		r.setRoom_createby(userName);
		r.setRoom_name(roomName1);
		r.setRoom_level(1);
		r.setRoom_state("1");
		r.setRoom_update_date(new Date());
		r.setRoom_server_id(room_id1);
		r.setRoom_member_num(id.length);
		String id1=roomService.saveRoom(r);
		
		List<JX_People> list=new ArrayList<JX_People>();
		for(int i=0;i<id.length;i++)
		{
			RoomDetail rd=new RoomDetail();
			rd.setRoom_id(id1);
			rd.setRoom_join_date(new Date());
			rd.setRoom_name(roomName1);
			rd.setRoom_server_id(room_id1);
			rd.setMember_id(id[i]);
			list=roomService.getMemDetail(id[i]);
			if(list.size()>0)
			{
				rd.setMember_department(list.get(0).getJx_department().getName());
				rd.setMember_level(list.get(0).getJx_department().getLevel().toString());
				rd.setMember_name(list.get(0).getName());
			}
			roomService.saveRoomDetail(rd);
		}
		return getRoomList();
	}
	
	//判断房间名是否唯一
	public void checkName() throws IOException
	{		
		int flag=roomService.IsExistName(roomName);
		JSONObject json=new JSONObject();
		json.put("flag", flag);
		ServletActionContext.getResponse().setContentType("text/json; charset=UTF-8");
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		out.print(json);
		out.flush();
		out.close();
	}
	
	//添加成员
	public String addMember()
	{
		memlist=roomService.getMemList();
		return "addMem";
	}
	
	//要添加的成员
	public String addMember1()
	{
		String id[]=ids.split(",");
		for(int i=0;i<id.length;i++)
		{
			List<Object[]> list=new ArrayList<Object[]>();
			list=roomService.getMemByid(id[i]);	
			memlist1.addAll(list);
		}
		return "addRoom";
	}
	
	
	//获取所有部门及其成员
	public void getAll() throws IOException
	{
		List<JX_Department> list=new ArrayList<JX_Department>();
		List<JX_People> list1=new ArrayList<JX_People>();
		list=roomService.getTreeList();
		list1=roomService.getPeople();
		List dataList = new ArrayList();
		for(int i=0;i<list.size();i++)
		{
			HashMap dataRecord1 = new HashMap();  
			dataRecord1.put("id", list.get(i).getId());  
			dataRecord1.put("text", list.get(i).getName());
			if(list.get(i).getLevel() == 0)
				dataRecord1.put("parentId", "");
			else
				dataRecord1.put("parentId", list.get(i).getPid());
			dataList.add(dataRecord1);
		}
		for(int i=0;i<list1.size();i++)
		{
			HashMap dataRecord1 = new HashMap();  
			dataRecord1.put("id", list1.get(i).getId());  
			dataRecord1.put("text", list1.get(i).getName());
			dataRecord1.put("name", list1.get(i).getJx_department().getName());
			dataRecord1.put("parentId",list1.get(i).getJx_department().getId());
			dataList.add(dataRecord1);
		}
		MultipleTree mt=new MultipleTree();
		String s=mt.getTree(dataList);
		JSONObject json=JSONObject.fromObject(s);
		JSONArray jsonArray=new JSONArray();
		jsonArray.put(json);
		ServletActionContext.getResponse().setContentType("text/json; charset=UTF-8");
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		out.print(jsonArray);
		out.flush();
		out.close();		
	}
	
	//修改工作组
	public String updateRoom()
	{
		list1=roomService.getRoomMem(room_id);
		if(list1.size()>0)
		{
		     roomName=list1.get(0).getRoom_name();
		     room_id=list1.get(0).getRoom_server_id();
		}
		return "update";		
	}
	
	public String updateRoom1()
	{
		String id[]=ids.split(",");
		Room m=roomService.getRoomById(room_id);
		String id1=m.getRoom_id();
		String roomName1=m.getRoom_name();
		m.setRoom_member_num(id.length);
		m.setRoom_update_date(new Date());
		roomService.updateRoom(m);	
		roomService.deleteRoomDetail(room_id);
		List<JX_People> list=new ArrayList<JX_People>();
		for(int i=0;i<id.length;i++)
		{
			RoomDetail rd=new RoomDetail();
			rd.setRoom_id(id1);
			rd.setRoom_join_date(new Date());
			rd.setRoom_name(roomName1);
			rd.setRoom_server_id(room_id);
			rd.setMember_id(id[i]);
			list=roomService.getMemDetail(id[i]);
			if(list.size()>0)
			{
				rd.setMember_department(list.get(0).getJx_department().getName());
				rd.setMember_level(list.get(0).getJx_department().getLevel().toString());
				rd.setMember_name(list.get(0).getName());
			}
			roomService.saveRoomDetail(rd);
		}
		return getRoomList();
	}

	public void setRmName(String rmName) {
		this.rmName = rmName;
	}

	public String getRmName() {
		return rmName;
	}

}
