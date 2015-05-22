package com.hoyotech.prison.bean;

import java.util.Date;

public class RoomDetail {
	
	//房间详情id
	private String room_detail_id;
	//房间id
	private String room_id;
	//房间服务器id
	private String room_server_id;
	//房间名称
	private String room_name;
	//成员id
	private String member_id;
	//成员名称
	private String member_name;
	//成员部门
	private String member_department;
	//成员等级
	private String member_level;
	//加入时间
	private Date room_join_date;
	
	public String getRoom_detail_id() {
		return room_detail_id;
	}
	public void setRoom_detail_id(String roomDetailId) {
		room_detail_id = roomDetailId;
	}
	public String getRoom_id() {
		return room_id;
	}
	public void setRoom_id(String roomId) {
		room_id = roomId;
	}
	public String getRoom_server_id() {
		return room_server_id;
	}
	public void setRoom_server_id(String roomServerId) {
		room_server_id = roomServerId;
	}
	public String getRoom_name() {
		return room_name;
	}
	public void setRoom_name(String roomName) {
		room_name = roomName;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String memberId) {
		member_id = memberId;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String memberName) {
		member_name = memberName;
	}
	public String getMember_department() {
		return member_department;
	}
	public void setMember_department(String memberDepartment) {
		member_department = memberDepartment;
	}
	public String getMember_level() {
		return member_level;
	}
	public void setMember_level(String memberLevel) {
		member_level = memberLevel;
	}
	public Date getRoom_join_date() {
		return room_join_date;
	}
	public void setRoom_join_date(Date roomJoinDate) {
		room_join_date = roomJoinDate;
	}

}
