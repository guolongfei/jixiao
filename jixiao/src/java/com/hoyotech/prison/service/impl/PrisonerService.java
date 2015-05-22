package com.hoyotech.prison.service.impl;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import java.util.GregorianCalendar;

import com.hoyotech.prison.bean.Dictionary;
import com.hoyotech.prison.bean.FingerPrint;
import com.hoyotech.prison.bean.IdentityAddress;
import com.hoyotech.prison.bean.Prisoner;
import com.hoyotech.prison.bean.PrisonerImage;
import com.hoyotech.prison.dao.impl.BasicDao;
import com.hoyotech.prison.dao.impl.DictionaryDao;
import com.hoyotech.prison.util.ChineseCharToEn;
import com.hoyotech.prison.util.Note;
import com.hoyotech.prison.util.ObjectUpdateUtil;


public class PrisonerService {

	private BasicDao dao;
	private DictionaryDao dictionaryDao;

	// 查询指纹个数
	public int countPrint(String id) {
		String hql = "select count(*) from FingerPrint where prisoner.id=?";
		return dao.getCount(hql, new Object[] { id });
	}

	/**
	 * 添加指纹
	 * **/
	public String addFingerPrint(FingerPrint obj) {
		// 解决外键为空的异常
		obj.setAddTime(new Date());
		return dao.save(obj);

	}

	/**
	 * 查询指纹
	 * **/
	public List<FingerPrint> selectFingerPrint(String id) {
		String hql = "from FingerPrint where prisoner.id=?";
		return (List<FingerPrint>) dao.queryByHql(hql, new Object[] { id });
	}

	/**
	 * 根据身份证前6位查找归属地
	 * 
	 */
	public IdentityAddress getAddress(String idNum) {
		String hql = "from IdentityAddress where number=?";
		return (IdentityAddress) dao.queryByHqlReturnUnique(hql,
				new Object[] { idNum });
	}

	/**
	 * 根据身份证前2位查找归属地所在
	 * 
	 */
	public Dictionary getshengfen(String idNum) {
		String SFnum = idNum.substring(0, 2) + "0000";
		String hql = "from Dictionary where code=?";
		return (Dictionary) dao.queryByHqlReturnUnique(hql,
				new Object[] { SFnum });
	}

	/**
	 * 检查是否填写了对应的法律文书
	 * 
	 * @param prisonerId
	 * @return
	 */
	public String hasDoc(String prisonerId) {
		String str = "";
		Object[] param = new Object[] { prisonerId };

		long count = (Long) dao.queryByHqlReturnUnique(
				"select count(*) from PrisonerHealth where prisoner.id=?",
				param);
		if (count > 0) {
			str += "prisonerHealth,";
		}
		count = (Long) dao.queryByHqlReturnUnique(
				"select count(*) from ContrabandGoods where prisoner.id=?",
				param);
		if (count > 0) {
			str += "contrabandGoods,";
		}
		count = (Long) dao
				.queryByHqlReturnUnique(
						"select count(*) from PrisonerGoods where prisoner.id=?",
						param);
		if (count > 0) {
			str += "prisonerGoods,";
		}
		count = (Long) dao
				.queryByHqlReturnUnique(
						"select count(*) from ExecuteReturn where prisoner.id=?",
						param);
		if (count > 0) {
			str += "executeReturn,";
		}
		count = (Long) dao.queryByHqlReturnUnique(
				"select count(*) from SendExamine where prisoner.id=?", param);
		if (count > 0) {
			str += "sendExamine,";
		}
		count = (Long) dao.queryByHqlReturnUnique(
				"select count(*) from RefuseDetain where prisoner.id=?", param);
		if (count > 0) {
			str += "refuseDetain,";
		}
		count = (Long) dao.queryByHqlReturnUnique(
				"select count(*) from DetainReturn where prisoner.id=?", param);
		if (count > 0) {
			str += "detainReturn,";
		}
		count = (Long) dao.queryByHqlReturnUnique(
				"select count(*) from WrongDetain where prisoner.id=?", param);
		if (count > 0) {
			str += "wrongDetain,";
		}
		count = (Long) dao.queryByHqlReturnUnique(
				"select count(*) from HandleSeparate where prisoner.id=?",
				param);
		if (count > 0) {
			str += "handleSeparate,";
		}
		count = (Long) dao.queryByHqlReturnUnique(
				"select count(*) from StopDetain where prisoner.id=?", param);
		if (count > 0) {
			str += "stopDetain,";
		}
		count = (Long) dao.queryByHqlReturnUnique(
				"select count(*) from OutPrison where prisoner.id=?", param);
		if (count > 0) {
			str += "outPrison,";
		}
		count = (Long) dao
				.queryByHqlReturnUnique(
						"select count(*) from LeaveExpires where outprison.prisoner.id=?",
						param);
		if (count > 0) {
			str += "leaveExpires,";
		}
		count = (Long) dao.queryByHqlReturnUnique(
				"select count(*) from ExecutionDetain where prisoner.id=?",
				param);
		if (count > 0) {
			str += "executionDetain,";
		}
		count = (Long) dao.queryByHqlReturnUnique(
				"select count(*) from UseWeapon where prisoner.id=?", param);
		if (count > 0) {
			str += "useWeapon,";
		}
		count = (Long) dao.queryByHqlReturnUnique(
				"select count(*) from AskRegistration where prisoner.id=?",
				param);
		if (count > 0) {
			str += "askRegistration,";
		}
		count = (Long) dao.queryByHqlReturnUnique(
				"select count(*) from Arraign where prisoner.id=?", param);
		if (count > 0) {
			str += "arraign,";
		}
		count = (Long) dao.queryByHqlReturnUnique(
				"select count(*) from CrimeKeyPass where prisoner.id=?", param);
		if (count > 0) {
			str += "crimeKeyPass,";
		}
		count = (Long) dao.queryByHqlReturnUnique(
				"select count(*) from AppealDataPass where prisoner.id=?",
				param);
		if (count > 0) {
			str += "appealDataPass,";
		}
		count = (Long) dao.queryByHqlReturnUnique(
				"select count(*) from DeathNotice where prisoner.id=?", param);
		if (count > 0) {
			str += "deathNotice,";
		}
		count = (Long) dao.queryByHqlReturnUnique(
				"select count(*) from RemoveDetain where prisoner.id=?", param);
		if (count > 0) {
			str += "removeDetain,";
		}
		count = (Long) dao.queryByHqlReturnUnique(
				"select count(*) from JiangCheng where prisoner.id=?", param);
		if (count > 0) {
			str += "jiangcheng,";
		}
		count = (Long) dao.queryByHqlReturnUnique(
				"select count(*) from RiskAssess where prisoner.id=?", param);
		if (count > 0) {
			str += "riskAssess,";
		}
		count = (Long) dao.queryByHqlReturnUnique(
				"select count(*) from FingerPrint where prisoner.id=?", param);
		if (count > 0) {
			str += "fingerPrint,";
		}
		return str;
	}

	/**
	 * 检索被拘留人信息
	 * **/
	public String getCondition(String priNum, String priName, String roomNum,
			String level, String detainState, Date inTime, Date outTime,
			String xingju, String yanguan, Date realityTime, Date chaoqi,
			String yuqi, String butan) {
		StringBuilder sb = new StringBuilder();
		if (priNum != null && priNum.length() > 0) {
			sb.append(" and prisonerCode=?");
		}
		if (priName != null && priName.length() > 0) {
			sb.append(" and name like '%" + priName + "%'");
		}
		if (roomNum != null && roomNum.length() > 0) {
			sb.append(" and detentionInfo.detentionCode=?");
		}
		if (level != null && level.length() > 0) {
			sb.append(" and dangerLevel=?");
		}
		if (yanguan != null && yanguan.length() > 0) {
			sb.append(" and managerClasses.id=?");
		}
		if (inTime != null) {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String date1 = formatter.format(new Date());
			sb.append(" and dateInprison= to_date('"+date1+"','yyyy-mm-dd')");
		}
		if (outTime != null) {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String date2 = formatter.format(new Date());
			sb.append(" and dateOutprison= to_date('"+date2+"','yyyy-mm-dd')");
		}
		if (chaoqi != null) {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String date2 = formatter.format(new Date());
			sb.append(" and dateOutprison < to_date('"+date2+"','yyyy-mm-dd')");
		}
		if (realityTime != null) {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String date2 = formatter.format(new Date());
			sb.append(" and realityOutTime= to_date('"+date2+"','yyyy-mm-dd')");
		}

		if (yuqi != null) {
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, -1);
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String date2 = formatter.format(cal.getTime());
			sb.append(" and id not in (select prisoner.id from Memcon) and dateInprison < to_date('"+date2+"','yyyy-mm-dd')");
		}

		if (butan != null) {
			Calendar cal = Calendar.getInstance();
			Calendar cal2 = Calendar.getInstance();
			cal.add(Calendar.DATE, -1);
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String date2 = formatter.format(cal.getTime());
			String today = formatter.format(cal2.getTime());
			sb.append(" and id in (select prisoner.id from Memcon where talkTime= to_date('"+today+"','yyyy-mm-dd')) and dateInprison < to_date('"+date2+"','yyyy-mm-dd')");
		}

		if (xingju != null && xingju.length() > 0) {
			sb.append(" and outprisonReson.id=" + xingju);
		}
		sb.append(" and state=?");

		return sb.toString();
	}

	/**
	 * 检索信息所需要的条件
	 * **/
	public List<String> getParaCondition(String priNum, String priName,
			String roomNum, String level, String detainState, String yanguan,
			Date realityTime, Date chaoqi, String yuqi, String butan) {
		List<String> list = new ArrayList<String>();
		if (priNum != null && priNum.length() > 0) {
			list.add(priNum);
		}
		// if(priName != null && priName.length() > 0){
		// list.add(priName);
		// }
		if (roomNum != null && roomNum.length() > 0) {
			list.add(roomNum);
		}
		if (level != null && level.length() > 0) {
			list.add(level);
		}
		if (yanguan != null && yanguan.length() > 0) {
			list.add(yanguan);
		}
		if (detainState != null && detainState.length() > 0) {
			list.add(detainState);
		} else {
			list.add("1");
		}
		return list;
	}

	/**
	 * 查询被拘留人信息
	 * **/
	public List<Prisoner> allPrisoners(String orderlist,String priNum, String priName,
			String roomNum, String level, String detainSate, Date inTime,
			Date outTime, String xingju, String yanguan, Date realityTime,
			Date chaoqi, String yuqi, String butan, int pageNumber,
			int pageSize, String prisonCode) {
		List<String> param = getParaCondition(priNum, priName, roomNum, level,
				detainSate, yanguan, realityTime, chaoqi, yuqi, butan);
		String condition = getCondition(priNum, priName, roomNum, level,
				detainSate, inTime, outTime, xingju, yanguan, realityTime,
				chaoqi, yuqi, butan);
		String strorder=strOrderBy(orderlist);
		String hql = "from Prisoner where prisonCode='" + prisonCode + "'"
				+ condition + " order by " + strorder;
		return (List<Prisoner>) dao.queryByHql(hql, param.toArray(),
				pageNumber, pageSize);
	} 
	
	public String strOrderBy(String orderlist)
	{
		String strorder="fileNumber desc, addTime desc";//addTime,dateOutprison,fileNumber asc
		if(orderlist!=null){
		if(orderlist.equals("1")){strorder="addTime desc";}
		else if(orderlist.equals("2")){strorder="addTime asc";}
		else if(orderlist.equals("3")){strorder="dateOutprison desc";}
		else if(orderlist.equals("4")){strorder="dateOutprison asc";}
		else if(orderlist.equals("5")){strorder="fileNumber desc";}
		else if(orderlist.equals("6")){strorder="fileNumber asc";}
		}
		return strorder;
	}

	/**
	 * 查询明日出所人信息                           刘泉
	 * **/
	public List<Prisoner> outPrisonerTomorrow(String priNum, String priName,
			String roomNum, String level, String detainSate, Date inTime,
			Date outTime, String xingju, String yanguan, Date realityTime,
			Date chaoqi, String yuqi, String butan, int pageNumber,
			int pageSize, String prisonCode) {
		
		Date date=new Date();//取时间
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(calendar.DATE,1);//把日期往后增加一天.整数往后推,负数往前移动
		date=calendar.getTime(); //这个时间就是日期往后推一天的结果 
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(date);
		
		List<String> param = getParaCondition(priNum, priName, roomNum, level,
				detainSate, yanguan, realityTime, chaoqi, yuqi, butan);
		String condition = getCondition(priNum, priName, roomNum, level,
				detainSate, inTime, outTime, xingju, yanguan, realityTime,
				chaoqi, yuqi, butan);
		String hql = "from Prisoner where prisonCode='" + prisonCode + "'"
				+ " and state='1'" + " and dateOutprison=to_date('"+dateString+"','yyyy-MM-dd') " +
						" order by addTime desc";
		
		List<Prisoner> LP = new ArrayList<Prisoner>();
		try
		{
			LP=(List<Prisoner>) dao.queryByHql(hql, param.toArray(),pageNumber, pageSize);
		}
		catch (Exception e) {
			// TODO: handle exception
		} 
		return LP;
	}
	
	/*
	 * 按拘留所代码查询拘室
	 * */
	public List allDetentionInfo(String prisonCode)
	{
		String hql = "select id,detentionCode,detentionName,capacity from DetentionInfo where state=1 and prisonCode=?";
		return (List) dao.queryByHql(hql, new Object[] {prisonCode});
	}
	
	/**
	 * 查询被拘留人今日事务请假的总数
	 * **/
	public int countPrisoner(String priNum, String priName, String roomNum,
			String level, String detainSate, Date inTime, Date outTime,
			String xingju, String yanguan, Date realityTime, Date chaoqi,
			String yuqi, String butan, String prisonCode) {
		List<String> param = getParaCondition(priNum, priName, roomNum, level,
				detainSate, yanguan, realityTime, chaoqi, yuqi, butan);
		String condition = getCondition(priNum, priName, roomNum, level,
				detainSate, inTime, outTime, xingju, yanguan, realityTime,
				chaoqi, yuqi, butan);
		String hql = "select count(*) from Prisoner where prisonCode="
				+ prisonCode + condition;
		return dao.getCount(hql, param.toArray());
	}
	
	/**
	 * 查询明日出所总人数
	 * **/
	public int countOutPrisoner(String priNum, String priName, String roomNum,
			String level, String detainSate, Date inTime, Date outTime,
			String xingju, String yanguan, Date realityTime, Date chaoqi,
			String yuqi, String butan, String prisonCode) {
		List<String> param = getParaCondition(priNum, priName, roomNum, level,
				detainSate, yanguan, realityTime, chaoqi, yuqi, butan);
		String condition = getCondition(priNum, priName, roomNum, level,
				detainSate, inTime, outTime, xingju, yanguan, realityTime,
				chaoqi, yuqi, butan);
		Date date=new Date();//取时间
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(calendar.DATE,1);//把日期往后增加一天.整数往后推,负数往前移动
		date=calendar.getTime(); //这个时间就是日期往后推一天的结果 
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(date);
		
		String hql = "select count(*) from Prisoner where prisonCode='" + prisonCode + "'"
				+ condition + " and dateOutprison=to_date('"+dateString+"','yyyy-MM-dd') " +
						" order by addTime desc";
		System.out.println(hql);
		return dao.getCount(hql, param.toArray());
	}

	/**
	 * 查询被拘留人的总数
	 * **/
	public int countPrisoner(String prisonId) {
		String hql = "select count(*) from Prisoner where state=1 and prison.id=?";
		return dao.getCount(hql, new Object[] { prisonId });
	}
	
	/*
	 * 查询某拘室的被拘留人
	 * */
	public List getDetentionPrisoner(String prisonCode,String detenCode)
	{
		String hql="select id,name from Prisoner where prisonCode=? and detentionInfo.detentionCode=? and state=1";
		return (List) dao.queryByHql(hql, new Object[] {prisonCode,detenCode});
	}
	
	/*
	 * 修改被拘留人拘室
	 * */
	public void toChangeDetention(String pid,String did){
		String hql = "update Prisoner set detentionInfo.id='"+did+"' where id='"+pid+"'";
		dao.executeHql(hql, new Object[] {});
	}	
	
	/**
	 * 查询被拘留人json
	 * **/
	public List<Note> getPrisonerJson(String prisonId) {
		try {
			String hql = "select id, name from Prisoner where state=1 and prison.id=?";
			List<Object[]> list = (List<Object[]>) dao.queryByHql(hql,
					new Object[] { prisonId });
			List<Note> noteList = new ArrayList<Note>();
			Note note = null;
			for (Object[] array : list) {
				note = new Note(array[0] + "", array[1] + "");
				noteList.add(note);
			}
			// String json = JsonUtil.list2json(noteList);
			return noteList;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 根据被留人编码查询拘留人
	 * 
	 * @param prisonerId
	 * @return
	 */
	public Prisoner getPrisonerByCode(String prisonerId, String prisonId) {
		List<Prisoner> list = (List<Prisoner>) dao.queryByHql(
				"from Prisoner where id=? and prison.id=?", new Object[] {
						prisonerId, prisonId });
		return list.size() > 0 ? list.get(0) : null;
	}

	/**
	 * 添加被拘留人信息
	 * **/
	public String add(Prisoner obj) {
		// 解决外键为空的异常
		ObjectUpdateUtil.checkProperty(obj);
		obj.setAddTime(new Date());
		obj.setUpdateTime(new Date());
		this.createPrisonerCode(obj);
		ChineseCharToEn cte = new ChineseCharToEn();
		String en = cte.getFirstLetter(obj.getName()).toUpperCase();
		obj.setxLetters(en);
		return dao.save(obj);
	}

	/**
	 * 生成拘留人编码
	 * 
	 * @param obj
	 */
	public void createPrisonerCode(Prisoner obj) {
		String prisonCode = obj.getPrisonCode();
		Date dateInPrisner = obj.getDateInprison();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		String dateIn = dateFormat.format(dateInPrisner);//入所时间

		dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		String hql = "select count(*) from Prisoner where dateInprison= to_date('"+ dateFormat.format(dateInPrisner)+"','yyyy/MM/dd')" ;
		/*long count = (Long) dao.queryByHqlReturnUnique(hql,
				new Object[] { dateFormat.format(dateInPrisner) });*/
		long count = (Long) dao.queryByHqlReturnUnique(hql,
				new Object[] {});
		count++;
		// System.out.println("count:"+count);
		DecimalFormat format = new DecimalFormat("0000");
		String prisonerCode = prisonCode + dateIn + format.format(count);//拘留所编码+入所时间+入所时间段内人员数量
		// System.out.println(prisonerCode);
		obj.setPrisonerCode(prisonerCode);
	}

	/**
	 * 查询一条被拘留人信息
	 * **/
	public Prisoner detail(String id) {
		return (Prisoner) dao.detail(Prisoner.class, id);
	}

	/**
	 * 获取用户图片
	 * 
	 * @param id
	 * @return
	 */
	public byte[] getprisonerImage(String id,String directionImg) {
		List<PrisonerImage> list = (List<PrisonerImage>) dao.queryByHql(
				"from PrisonerImage where prisoner.id=? order by addTime desc",
				new Object[] { id });
		if(directionImg!=null){
			if(directionImg.equals("left")){
				return list.size() > 0 ? list.get(0).getFileLeftDate(): null;
			}else if(directionImg.equals("right")){
				return list.size() > 0 ? list.get(0).getFileRightDate(): null;
			}else{
				return list.size() > 0 ? list.get(0).getFileDate(): null;
			}
		}else{
			return list.size() > 0 ? list.get(0).getFileDate(): null;
		}
	}

	/**
	 * 判断被拘留人是否有图片
	 * 
	 * @param id
	 * @return
	 */
	public boolean hasImage(String id) {
		String hql = "select count(*) from PrisonerImage where prisoner.id=?";
		int count = dao.getCount(hql, new Object[] { id });
		return count > 0 ;
	}

	/**
	 * 删除一条被拘留人信息
	 * **/
	public void delete(String id) {
		String hql = "update Prisoner set state=0 where id=?";
		dao.executeHql(hql, new Object[] { id });
	}

	/**
	 * 修改一条被拘留人信息
	 * **/
	public void update(Prisoner obj) {
		// 解决外键为空的异常
		ObjectUpdateUtil.checkProperty(obj);
		obj.setUpdateTime(new Date());
		ChineseCharToEn cte = new ChineseCharToEn();
		String en = cte.getFirstLetter(obj.getName()).toUpperCase();
		obj.setxLetters(en);
		dao.update(obj);
	}

	/**
	 * 添加被拘留人图片
	 * **/
	public String addImage(PrisonerImage obj) {
		// 解决外键为空的异常
		// ObjectUpdateUtil.checkProperty(obj);
		obj.setAddTime(new Date());
		return dao.save(obj);
	}

	public void updateImage(PrisonerImage img){
		dao.update(img);
	}
	
	public PrisonerImage getPrisonerImage(String id) {
		// TODO Auto-generated method stub
		String hql="from PrisonerImage where prisoner = ?";
		PrisonerImage p = (PrisonerImage)dao.queryByHqlReturnUnique(hql,new Object[]{id});
		if(p!=null)
		{
			return (PrisonerImage)dao.detail(PrisonerImage.class, p.getId());
		}
		
		else
		{
			return null;
		}
	}
	
	public DictionaryDao getDictionaryDao() {
		return dictionaryDao;
	}

	public void setDictionaryDao(DictionaryDao dictionaryDao) {
		this.dictionaryDao = dictionaryDao;
	}

	public BasicDao getDao() {
		return dao;
	}

	public void setDao(BasicDao dao) {
		this.dao = dao;
	}

	public Prisoner detail(int prisonerId) {
		return (Prisoner) dao.queryByHqlReturnUnique("from Prisoner where id = ?",
				new Object[] { prisonerId });
	}
}
