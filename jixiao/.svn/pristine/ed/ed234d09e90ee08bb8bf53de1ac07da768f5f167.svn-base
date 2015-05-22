package com.hoyotech.prison.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.hoyotech.prison.bean.JX_Department;
import com.hoyotech.prison.bean.JX_People;
import com.hoyotech.prison.bean.Room;
import com.hoyotech.prison.bean.RoomDetail;
import com.hoyotech.prison.dao.impl.BasicDao;

public class RoomService {

	private BasicDao dao;
	public BasicDao getDao() {
		return dao;
	}
	public void setDao(BasicDao dao) {
		this.dao = dao;
	}
	
	public String saveRoom(Room r) {
		// TODO Auto-generated method stub
		return dao.save(r);
	}
	public List<Room> getRoomList(int pageNum, String roomName) {
		// TODO Auto-generated method stub
		List<Room> list=new ArrayList<Room>();
		String hql="";
		if(roomName==null)
		{
			 hql="from Room m where 1=1 order by m.room_create_date desc";
		}
		else
		{
			hql="from Room m where m.room_name like '%"+roomName+"%' order by m.room_create_date desc";
		}
		list=(List<Room>) dao.queryByHql(hql, new Object[] {}, pageNum, 10);
		return list;
	}
	public int getTotalMessageSize(String roomName) {
		// TODO Auto-generated method stub
		List<Room> list=new ArrayList<Room>();
		String hql="";
		if(roomName==null)
		{
			 hql="from Room m where 1=1 order by m.room_create_date desc";
		}
		else
		{
			 hql="from Room m where m.room_name like '%"+roomName+"%' order by m.room_create_date desc";
		}
		list=(List<Room>) dao.queryByHql(hql, new Object[] {});
		if(list.size()>0)
		{
			return list.size();
		}
		else
		{
			return 0;
		}		
	}
	public void deleteRoom(String roomId) {
		// TODO Auto-generated method stub
		String hql="delete from Room m where m.room_server_id ='"+roomId+"'";
		dao.executeHql(hql, new Object[] {});
	}
public void deleteRoomDetail(String roomId) {
		// TODO Auto-generated method stub		
		String hql1="delete from RoomDetail rd where rd.room_server_id ='"+roomId+"'";
		dao.executeHql(hql1, new Object[] {});
	}
	//判断房间名是否存在
	public int IsExistName(String roomName) {
		// TODO Auto-generated method stub
		List<Room> list=new ArrayList<Room>();
		String hql="from Room m where m.room_name ='"+roomName+"'";
		list=(List<Room>) dao.queryByHql(hql, new Object[] {});
		return list.size();
			
	}
	
	//查询所有用户消息
	public List<Object[]> getMemList() {
		// TODO Auto-generated method stub
		List<Object[]> list=new ArrayList<Object[]>();
		String hql="select jp.id,jp.name,jd.name from JX_People jp,JX_Department jd where jp.jx_department.id=jd.id";
		list=(List<Object[]>) dao.queryByHql(hql, new Object[] {});
		return list;
		
	}
	public List<Object[]> getMemByid(String id) {
		// TODO Auto-generated method stub
		List<Object[]> list=new ArrayList<Object[]>();
		String hql="select jp.id,jp.name,jd.name from JX_People jp,JX_Department jd where jp.jx_department.id=jd.id and jp.id='"+id+"'";
		list=(List<Object[]>) dao.queryByHql(hql, new Object[] {});
		return list;
		
	}
	public List<JX_People> getMemDetail(String id) {
		// TODO Auto-generated method stub
		List<JX_People> list=new ArrayList<JX_People>();
		String hql="from JX_People jp where jp.id='"+id+"'";
		list=(List<JX_People>) dao.queryByHql(hql, new Object[] {});
		return list;
	}
	
	//保存详情
	public void saveRoomDetail(RoomDetail rd) {
		// TODO Auto-generated method stub
		dao.save(rd);
	}
	
	//查询详细数据
	public List<JX_People> getPeople() {
		// TODO Auto-generated method stub
		List<JX_People> list=new ArrayList<JX_People>();
		String hql="from JX_People";
		list=(List<JX_People>) dao.queryByHql(hql, new Object[] {});
		return list;
	}
	
	//获取房间成员
	public List<RoomDetail> getRoomMem(String roomId) {
		// TODO Auto-generated method stub
		List<RoomDetail> list=new ArrayList<RoomDetail>();
		String hql="from RoomDetail rd where rd.room_server_id ='"+roomId+"'";
		list=(List<RoomDetail>) dao.queryByHql(hql, new Object[] {});
		return list;
	}
	public Room getRoomById(String roomId) {
		// TODO Auto-generated method stub
		List<Room> list=new ArrayList<Room>();
		String hql="from Room m where m.room_server_id ='"+roomId+"'";
		list=(List<Room>) dao.queryByHql(hql, new Object[] {});
		return list.get(0);
	}
	public void updateRoom(Room m) {
		// TODO Auto-generated method stub
		dao.update(m);
	}
public List<RoomDetail> getRooms(String user_id){
		List<RoomDetail> list=new ArrayList<RoomDetail>();
		String hql="";
		if(user_id==null)
		{
			 hql="from RoomDetail ";
		}
		else
		{
			hql="from RoomDetail m where m.member_id = '"+user_id+"' order by m.room_join_date desc";
		}
		list=(List<RoomDetail>) dao.queryByHql(hql, new Object[] {});
		return list;
	}
	@SuppressWarnings("unchecked")
	public List<RoomDetail> getUsers(String room_server_id){
		List<RoomDetail> list=new ArrayList<RoomDetail>();
		String hql="";
		if(room_server_id==null)
		{
			 hql="from RoomDetail ";
		}
		else
		{
			hql="from RoomDetail m where m.room_server_id = '"+room_server_id+"' order by m.room_join_date desc";
		}
		list=(List<RoomDetail>) dao.queryByHql(hql, new Object[] {});
		return list;
	}
	public List<JX_Department> getTreeList() {
		// TODO Auto-generated method stub
		List<JX_Department> list=new ArrayList<JX_Department>();
		String hql="from JX_Department";
		list=(List<JX_Department>) dao.queryByHql(hql, new Object[] {});
		return list;
	}
}
