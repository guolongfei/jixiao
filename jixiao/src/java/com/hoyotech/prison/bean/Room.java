package com.hoyotech.prison.bean;

import java.util.Date;

public class Room {
	
	//房间id
	private String room_id;
	//房间服务器id
	private String room_server_id;
	//房间名称
	private String room_name;
	//房间创建人
	private String room_createby;
	//房间创建时间
	private Date room_create_date;
	//房间修改时间
	private Date room_update_date;
	//房间状态
	private String room_state;
	//房间等级
	private int room_level;
	//房间成员数
	private int room_member_num;
	//开始说话时间
	private Date room_starttalk_date;
	//结束说话时间
	private Date room_endtalk_date;
		
	public Date getRoom_starttalk_date() {
		return room_starttalk_date;
	}
	public void setRoom_starttalk_date(Date roomStarttalkDate) {
		room_starttalk_date = roomStarttalkDate;
	}
	public Date getRoom_endtalk_date() {
		return room_endtalk_date;
	}
	public void setRoom_endtalk_date(Date roomEndtalkDate) {
		room_endtalk_date = roomEndtalkDate;
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
	public String getRoom_createby() {
		return room_createby;
	}
	public void setRoom_createby(String roomCreateby) {
		room_createby = roomCreateby;
	}
	public Date getRoom_create_date() {
		return room_create_date;
	}
	public void setRoom_create_date(Date roomCreateDate) {
		room_create_date = roomCreateDate;
	}
	public Date getRoom_update_date() {
		return room_update_date;
	}
	public void setRoom_update_date(Date roomUpdateDate) {
		room_update_date = roomUpdateDate;
	}
	public String getRoom_state() {
		return room_state;
	}
	public void setRoom_state(String roomState) {
		room_state = roomState;
	}
	public int getRoom_level() {
		return room_level;
	}
	public void setRoom_level(int roomLevel) {
		room_level = roomLevel;
	}
	public int getRoom_member_num() {
		return room_member_num;
	}
	public void setRoom_member_num(int roomMemberNum) {
		room_member_num = roomMemberNum;
	}

}
