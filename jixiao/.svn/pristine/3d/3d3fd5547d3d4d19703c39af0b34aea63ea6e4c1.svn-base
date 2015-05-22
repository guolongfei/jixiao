package com.hoyotech.prison.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.hoyotech.prison.bean.Career;
import com.hoyotech.prison.bean.DetentionInfo;
import com.hoyotech.prison.bean.Dictionary;
import com.hoyotech.prison.bean.Document;
import com.hoyotech.prison.bean.FingerPrint;
import com.hoyotech.prison.bean.IdentityAddress;
import com.hoyotech.prison.bean.Nationality;
import com.hoyotech.prison.bean.Peoples;
import com.hoyotech.prison.bean.PrisonInfo;
import com.hoyotech.prison.bean.Prisoner;
import com.hoyotech.prison.bean.PrisonerGoods;
import com.hoyotech.prison.bean.PrisonerHealth;
import com.hoyotech.prison.bean.PrisonerImage;
import com.hoyotech.prison.bean.RiskAssess;
import com.hoyotech.prison.bean.WorkUnit;
import com.hoyotech.prison.log.LogFactory;
import com.hoyotech.prison.service.impl.DictionaryService;
import com.hoyotech.prison.service.impl.PrisonerGoodsService;
import com.hoyotech.prison.service.impl.PrisonerHealthService;
import com.hoyotech.prison.service.impl.PrisonerService;
import com.hoyotech.prison.service.impl.RiskAssessService;
import com.hoyotech.prison.util.ConfigHelper;
import com.hoyotech.prison.util.ObjectUpdateUtil;
import com.hoyotech.prison.util.PrisonUtil;
import com.hoyotech.prison.util.Type;
import com.isa.pims.basic.ServletRequestUtils;
import com.btdx.qqfw.client.QQFWClient;


public class PrisonerAction {
	private PrisonerService prisonerServer;
	private DictionaryService dictionaryService;
	private PrisonerHealthService prisonerHealthService;
	private RiskAssessService riskAssessService;
	private List<Prisoner> lists;
	private Prisoner prisoner;
	private int pageNum;
	private int limit;
	private int totalPage;
	private int totalNum;
	private String id;
	private String type;
	private String idNum;
	
	
	private List<Dictionary> gender;
	private List<Dictionary> marryStatus;
	private List<Dictionary> eduLevel;
	private List<Dictionary> status;
	private List<Dictionary> inprison;
	private List<Dictionary> handType;
	private List<Dictionary> crime;
	private List<Dictionary> voucher;
	private List<Dictionary> dangerLev;
	private List<Dictionary> outPrison;
	private List<Dictionary> managers;
	private List<Dictionary> dateCheck;
	private List<Peoples> peoples;
	private List<Dictionary> specials;
	private List<Dictionary> address;
	private List<Career> careers;
	private List<Document> documents;
	private List<Nationality> nations;
	private List<DetentionInfo> detentionList;
	private List<WorkUnit> workUnits;

	private String prisonerNum;
	private String prisonerName;
	private String roomNum;
	private String dangerlevel;
	private String detainState;
	private Date inTime;
	private Date outTime;
	private String xingju;//今日事务转刑拘
	private String yanguan;
	private Date realityTime;
	private Date chaoqi;
	private String yuqi;//逾期未谈话
	private String butanhua;//补谈话
	
	private String bussiness;
	private String filePath;
	
	private LogFactory log;
	//记录被拘留人员列表页面名称	2014年11月6日  刘泉
	private String prisonerListWebname;
	
	// 向导添加的参数
	private String mode;
	private String step;
	private String complete;
	private String kuaisu;
	
	private PrisonerGoodsService prisonerGoodsService;
	private Prisoner oneprison;
	private PrisonerHealth prisonerHealth;
	private RiskAssess riskAssess;
	private PrisonerGoods prisonerGoods;
	
	private boolean is_has_image;
	
	private String printRecord;
	private FingerPrint fingerPrint;
	private String documeNum;//刘泉    传回的身份证号\
	private String orderlist;
	private String detentionNum;
	
	private String pid;
	private String did;
		
	//根据图片的方位参数然后上传到相对应的字段中去
	//2014-2-11 9:07:36 张志超
	private String directionImg;
	
	public String getDirectionImg() {
			return directionImg;
		}
	public void setDirectionImg(String directionImg) {
		this.directionImg = directionImg;
	}

	//-----------------------------------------------
	public String interFinger(){
		return "finger";
	}
	
		/*
		 * 作者：张欢
		 * 时间：2012.06.26
		 * 调用请求服务查询: 
		 * 参数：
			 *  ip - 服务器IP地址
		   	*	port - 服务器端口号
			*	senderId - 请求方ID
			*	serviceId - 服务方ID
			*	dataObjectCode - 服务对象类别代码
			*	returnFileds - 需要返回的字段
			*	whereCondition - 查询条件 
		*	返回：
		*		String[][] 
		*	抛出： 
		*		java.lang.RuntimeException
		 */
		public String mainGet() {			
			String ip ="10.72.1.156";
			String port ="9080";
			String senderId ="HBQBPT";
			//String serviceId ="JGDJ-00000001";
			String serviceId ="JGEZ-00000001";
			String dataObjectCode ="H001";
			//String dataObjectCode ="V_JGJK_DRSRY";
			String returnFileds ="AJBH,AJLB,RYBH,GMSFHM,XM,XMPY,XB,CSRQ,HJQH,HJZRQ,SG,SF,BMCH,BMCHPY,RYLB,RYSX,ZWBH,DNABH,WHCD,HJXZ,ZHRQ,ZHDW,ZHFS,XYRSX,ZAYY,XSZK,KY,XYRBH,AJMC,FAB,AJJLBH,ZBDW,FASJSX";
			//String returnFileds ="XM,RYBH";
			String[] rf = returnFileds.split(",");
			String whereCondition ="GMSFHM='"+documeNum+"'";//420704197109180361'";
			//String whereCondition =" XM='易胜'";
			String[][] rs=QQFWClient.queryServices(ip, port, senderId, serviceId, dataObjectCode, returnFileds, whereCondition);
			String[] _temp = null;
			for (int i = 0; i < rs.length; i++) {
				System.out.print(rs.length+",");
				_temp=rs[i];
				System.out.println("--------------第【"+i+"】条记录---------------");
				for (int j = 0; j < _temp.length; j++) {
					//System.out.print(_temp.length+",");
					System.out.print(_temp[j]+",");
//					System.out.println(rs[i][k]);
				}
				System.out.println("");
			}
			//System.out.println(len);
			System.out.println("请求结果："+rs[2][0]+","+rs[2][1]);
			//System.out.println("请求字段："+rs[1][0]+","+rs[1][1]+","+rs[1][2]);
			//System.out.println("请求字段："+rs[2][0]+","+rs[2][1]+","+rs[2][2]);
			//System.out.println("请求字段："+rs[1][0]+","+rs[1][1]+","+rs[1][2]+","+rs[1][3]+","+rs[1][4]+","+rs[1][5]);
			//System.out.println("请求字段："+rs[2][0]+","+rs[2][1]+","+rs[2][2]+","+rs[2][3]+","+rs[2][4]+","+rs[2][5]);
			//System.out.println("请求字段："+rs[3][0]+","+rs[3][1]+","+rs[3][2]+","+rs[3][3]+","+rs[3][4]+","+rs[3][5]);
			
			//AJBHAJLB,RYBH,GMSFHM,XM,XMPY,XB,CSRQ,HJQH,HJZRQ,SG,SF,BMCH,BMCHPY,RYLB,RYSX,ZWBH,DNABH,WHCD,HJXZ,ZHRQ,ZHDW,ZHFS,XYRSX,ZAYY,XSZK,KY,XYRBH,AJMC,FAB,AJJLBH,ZBDW,FASJSX

			Prisoner prisone=new Prisoner();
			prisone.setFileNumber("42070000000061301795");
			prisone.setName("孔丽");
			prisoner=prisone;
			System.out.println(prisoner.getName());
			mode="wizard";
			initDict();
			return "Add";
		}

	
	/**
	 * 添加指纹模板
	 */
	public void addFingerPrint(){
		try{
			HttpServletResponse response=ServletActionContext.getResponse();
			HttpServletRequest request=ServletActionContext.getRequest();
			PrintWriter out=response.getWriter();
			// 设置拘留所编码
			fingerPrint=new FingerPrint();
			fingerPrint.setPrisonCode(PrisonUtil.getPrisonCode(request));
			Prisoner prisoner=new Prisoner();
			prisoner.setId(id);
			fingerPrint.setPrisoner(prisoner);
			fingerPrint.setPrintRecord(printRecord);
			
			prisonerServer.addFingerPrint(fingerPrint);
			
			int num=prisonerServer.countPrint(id);
			
			out.println("{\"result\":\"100\",\"count\":\""+num+"\"}");//指纹添加成功
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 查找一个指纹模板
	 */
	public void selectPrint(){
		try{
			HttpServletResponse response=ServletActionContext.getResponse();
			PrintWriter out=response.getWriter();
			List<String> result=new ArrayList<String>();
			List<FingerPrint> list=prisonerServer.selectFingerPrint(id);
			if(list.size()>0){
				for(FingerPrint i:list){
					result.add(i.getPrintRecord());
				}
			}else{
				result.add("error");
			}
			String json=JSON.toJSONString(result);
			out.println(json);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 快速入所打印页
	 */
	public String inPrint(){
		is_has_image = prisonerServer.hasImage(id);
		oneprison = prisonerServer.detail(id);
		prisonerHealth = prisonerHealthService.detailByPrisoner(id);
		riskAssess=riskAssessService.ByPrisonerId(id);
		prisonerGoods = prisonerGoodsService.detailByPrisoner(id);
		return "allPrint";
	}
	
	/**
	 * 进入图片上传页
	 */
	public String uploadUI(){
		return "uploadUI";
	}
	 
	/**
	 * 上传图片*************************************
	 */
	/* public String upload(){
		try {
			File file = new File(filePath);
			InputStream inputStream = new FileInputStream(file);
			int fileSize = (int) file.length();
			byte[] buff= new byte[fileSize];
			inputStream.read(buff, 0, fileSize);
			PrisonerImage img =prisonerServer.getPrisonerImage(id);
			String fileName  = file.getName();
			if(directionImg.equals("left")){
				setDirectionImg("left");
				img.setFileNameLeft(fileName);
				img.setFileLeftDate(buff);
			}
			if(directionImg.equals("center")){
				setDirectionImg("center");
				img.setFileName(fileName);
				img.setFileDate(buff);
			}
			if(directionImg.equals("right")){
				setDirectionImg("right");
				img.setFileNameRight(fileName);
				img.setFileRightDate(buff);
			}
			img.setPrisoner(new Prisoner(id));
			img.setFileSize(fileSize);
			if(prisonerServer.hasImage(id)){
				prisonerServer.updateImage(img);
			}else{
				prisonerServer.addImage(img);
			}
			inputStream.close();
			file.delete();
		} catch (Exception e) {
			e.printStackTrace();
		}

		 return "main";
	 }*/
	
	public String upload(){
		try {
			File file = new File(filePath);
			InputStream inputStream = new FileInputStream(file);
			int fileSize = (int) file.length();
			byte[] buff= new byte[fileSize];
			inputStream.read(buff, 0, fileSize);
			PrisonerImage img =prisonerServer.getPrisonerImage(id);
			if(img==null)
			{
				img=new PrisonerImage();
			}
			String fileName  = file.getName();
			if(directionImg.equals("left")){
				setDirectionImg("left");
				img.setFileNameLeft(fileName);
				img.setFileLeftDate(buff);
			}
			if(directionImg.equals("center")){
				setDirectionImg("center");
				img.setFileName(fileName);
				img.setFileDate(buff);
			}
			if(directionImg.equals("right")){
				setDirectionImg("right");
				img.setFileNameRight(fileName);
				img.setFileRightDate(buff);
			}
			img.setPrisoner(new Prisoner(id));
			img.setFileSize(fileSize);
			if(prisonerServer.hasImage(id)){
				prisonerServer.updateImage(img);
			}else{
				prisonerServer.addImage(img);
			}
			inputStream.close();
			file.delete();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		 return "main";
 }
	
	 /**
	  * 输出图片
	  */
	 public void image(){
		 try {
			 byte[] image = prisonerServer.getprisonerImage(id,directionImg);
			 if(image != null){
				 HttpServletResponse response = ServletActionContext.getResponse();
				 response.setContentType("image/jpeg");
				 OutputStream toClient = response.getOutputStream();//获取输出流      
				 toClient.write(image);//输出到页面      
				// toClient.close();//关闭输出流      
			 }
		} catch (Exception e) {
//			e.printStackTrace();//当上传右边图片时会报错，但是不会影响功能，有时间在调节一下
		}
	 }

	/**
	 * 查询所有被拘留人的信息
	 * **/
	public String select() {
		dangerLev = dictionaryService.selectDictionary(Type.DANGERTYPE);
		HttpServletRequest request = ServletActionContext.getRequest();
		pageNum = ServletRequestUtils.getInt(request, "page", "1");
		limit = ServletRequestUtils.getInt(request, "limit", "20");
		String prisonCode=PrisonUtil.getPrisonCode(request);
		if(bussiness!=null){
			if(bussiness.equals("in")){
				inTime=new Date();
			}else if(bussiness.equals("out")){
				detainState="1";
				outTime=new Date();
			}else if(bussiness.equals("execused")){
				detainState="2";
			}else if(bussiness.equals("xingju")){
				detainState="3";
				realityTime=new Date();
				xingju="113";
			}else if(bussiness.equals("yanguan")){
				yanguan="117";
			}else if(bussiness.equals("alreadyOut")){
				detainState="3";
				realityTime=new Date();
			}else if(bussiness.equals("chaoqi")){
				chaoqi=new Date();
			}else if(bussiness.equals("yuqitanhua")){
				yuqi="1";
			}else if(bussiness.equals("butanhua")){
				butanhua="1";
			}
		}
		lists = prisonerServer.allPrisoners(orderlist,prisonerNum, prisonerName, roomNum, dangerlevel,detainState,inTime,outTime,xingju,yanguan,realityTime,chaoqi,yuqi,butanhua, pageNum, limit,prisonCode);
		totalNum = prisonerServer.countPrisoner(prisonerNum, prisonerName, roomNum, dangerlevel,detainState,inTime,outTime,xingju,yanguan,realityTime,chaoqi,yuqi,butanhua,prisonCode);
		totalPage = (totalNum - 1) / limit + 1;
		prisonerListWebname="被拘留人信息管理";
		return "List";
	}
		
	/**
	 * 查询明日出所人的信息                 刘泉2014.06.12
	 * **/
	public String selectOutPrisonerTomorrow() {
		dangerLev = dictionaryService.selectDictionary(Type.DANGERTYPE);
		HttpServletRequest request = ServletActionContext.getRequest();
		pageNum = ServletRequestUtils.getInt(request, "page", "1");
		limit = ServletRequestUtils.getInt(request, "limit", "20");
		String prisonCode=PrisonUtil.getPrisonCode(request);
		if(bussiness!=null){
			if(bussiness.equals("in")){
				inTime=new Date();
			}else if(bussiness.equals("out")){
				detainState="1";
				outTime=new Date();
			}else if(bussiness.equals("execused")){
				detainState="2";
			}else if(bussiness.equals("xingju")){
				detainState="3";
				realityTime=new Date();
				xingju="113";
			}else if(bussiness.equals("yanguan")){
				yanguan="117";
			}else if(bussiness.equals("alreadyOut")){
				detainState="3";
				realityTime=new Date();
			}else if(bussiness.equals("chaoqi")){
				chaoqi=new Date();
			}else if(bussiness.equals("yuqitanhua")){
				yuqi="1";
			}else if(bussiness.equals("butanhua")){
				butanhua="1";
			}
		}
		lists = prisonerServer.outPrisonerTomorrow(prisonerNum, prisonerName, roomNum, dangerlevel,detainState,inTime,outTime,xingju,yanguan,realityTime,chaoqi,yuqi,butanhua, pageNum, limit,prisonCode);
		totalNum = prisonerServer.countOutPrisoner(prisonerNum, prisonerName, roomNum, dangerlevel,detainState,inTime,outTime,xingju,yanguan,realityTime,chaoqi,yuqi,butanhua,prisonCode);
		totalPage = (totalNum - 1) / limit + 1;
		prisonerListWebname="明日出所人员信息管理";
		return "OutPrisonerList";
	}
	
	/*
	 * 进入被拘留人更换拘留室页面
	 * */
	public String intoDetentionAreaChange()
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		String prisonCode=PrisonUtil.getPrisonCode(request);
		return "prisonerDetentionAre";		
	}
	
	public void DetentionAjax(){		
		HttpServletRequest request = ServletActionContext.getRequest();
		String prisonCode = PrisonUtil.getPrisonCode(request);
		List list=prisonerServer.allDetentionInfo(prisonCode);
		// id,detentionCode,detentionName,capacity
		StringBuilder sb = new StringBuilder("{\"pridata\":[");
		for(Iterator<Object[]> it = list.iterator();it.hasNext();){
			Object[] objs = it.next();
			sb.append("{\"id\":\""+objs[0]+"\"," +
					"\"detentionCode\":\""+objs[1]+"\"," +
					"\"detentionName\":\""+objs[2]+"\"," +
					"\"capacity\":\""+objs[3]+"\"}");
			if(it.hasNext()){
				sb.append(",");
			}
		}
		sb.append("]}");

		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		try {
			PrintWriter out = response.getWriter();
			out.println(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 查询某拘室的被拘留人
	 * */
	public void getDetentionPrisonerAjax(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String prisonCode = PrisonUtil.getPrisonCode(request);
		List list=prisonerServer.getDetentionPrisoner(prisonCode,detentionNum);
		// id,detentionCode,detentionName,capacity
		StringBuilder sb = new StringBuilder("{\"pridata\":[");
		for(Iterator<Object[]> it = list.iterator();it.hasNext();){
			Object[] objs = it.next();
			sb.append("{\"id\":\""+objs[0]+"\"," + "\"name\":\""+objs[1]+"\"}");
			if(it.hasNext()){
				sb.append(",");
			}
		}
		sb.append("]}");

		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		try {
			PrintWriter out = response.getWriter();
			out.println(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 更改被拘留人拘室
	 * */
	public void ChangeDetention(){
		prisonerServer.toChangeDetention(pid, did);		
	}

	/**
	 * 添加一条被拘留人的信息
	 * **/
	public String add() {
		HttpServletRequest request = ServletActionContext.getRequest();
		// 设置拘留所编码
		prisoner.setPrisonCode(PrisonUtil.getPrisonCode(request));
		// 设置拘留所ID
		prisoner.setPrison(new PrisonInfo());
		prisoner.getPrison().setId(PrisonUtil.getPrisonId(request));

		prisoner.setNoYear(PrisonUtil.getYear());//添加流水号
		prisoner.setNoNumber(dictionaryService.getNo("Prisoner"));
		id = prisonerServer.add(prisoner); // 添加数据得到id
		
		// 添加日志
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "添加成功。";
		log.getInsertLogMessage(prisoner, config.getInsert(), operate, config.getPrisonerManage(), config.getSucceed(), request);
		
		type = "prisoner";
		if("kuaisu".equals(kuaisu)){
			return "kuaisu";
		}else if("wizard".equals(mode)){
			// 快速添加
			step = "2";
			complete = "1";
			return "next";
		}else{
			return "main";
		}
	}

	/**
	 * 查询一条被拘留人的信息
	 * **/
	public String detail() {
		prisoner = prisonerServer.detail(id);
		return "Detail";
	}

	/**
	 * 删除一条被拘留人的信息
	 * **/
	public String delete() {
		prisonerServer.delete(id);
		Prisoner object = prisonerServer.detail(id);
		
		// 添加日志
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "删除成功。";
		log.getModifyLogMessage(null, object, config.getDelete(), operate, config.getPrisonerManage(), config.getSucceed(), request);

		return "select";
	}

	/**
	 * 修改一条被拘留人的信息
	 * **/
	public String update() {

		id = prisoner.getId();
		Prisoner object = prisonerServer.detail(id);
		Prisoner old_object = prisonerServer.detail(id);
		ObjectUpdateUtil.compareProperty(prisoner, object);
		
		prisonerServer.update(object);
		id = prisoner.getId();
		
		// 添加日志
		HttpServletRequest request = ServletActionContext.getRequest();
		ConfigHelper config = ConfigHelper.getConfig();
		String operate = "修改成功。";
		log.getModifyLogMessage(object, old_object, config.getUpdate(), operate, config.getPrisonerManage(), config.getSucceed(), request);
		
		return "detail";
	}

	/**
	 * 进入添加页面
	 * **/
	public String interAdd() {
		initDict();
		return "Add";
	}

	/**
	 * 打印法律文书
	 * 
	 * @return
	 */
	public String doc() {
		prisoner = prisonerServer.detail(id);
		return "doc";
	}

	/**
	 * 进入修改页面
	 * **/
	public String interEdit() {
		prisoner = prisonerServer.detail(id);
		initDict();
		return "Edit";
	}

	/**
	 * 查询数据字典
	 * **/
	public void initDict() {
		specials = dictionaryService.selectDictionary(Type.SPECIALTYPE);
		address = dictionaryService.selectDictionary(Type.ADDRESSTYPE);
		careers = dictionaryService.selectCareer(1);
		documents = dictionaryService.selectDocument(1);
		nations = dictionaryService.selectNationality(1);
		peoples = dictionaryService.selectPeoples(1);
		gender = dictionaryService.selectDictionary(Type.GENDERTYPE);
		marryStatus = dictionaryService.selectDictionary(Type.MARRYTYPE);
		eduLevel = dictionaryService.selectDictionary(Type.EDUCATIONTYPE);
		status = dictionaryService.selectDictionary(Type.STATUSTYPE);
		inprison = dictionaryService.selectDictionary(Type.INPRISONTYPE);
		handType = dictionaryService.selectDictionary(Type.HANDTYPE);
		crime = dictionaryService.selectDictionary(Type.CRIMETYPE);
		voucher = dictionaryService.selectDictionary(Type.VOUCHERTYPE);
		dangerLev = dictionaryService.selectDictionary(Type.DANGERTYPE);
		outPrison = dictionaryService.selectDictionary(Type.OUTPRISONTYPE);
		managers = dictionaryService.selectDictionary(Type.MANAGERTYPE);
		dateCheck = dictionaryService.selectDictionary(Type.CHECKTYPE);
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String prisonId = PrisonUtil.getPrisonId(request);
		String prisonCode=PrisonUtil.getPrisonCode(request);
		detentionList = dictionaryService.getDetentionList(prisonId);
		workUnits= dictionaryService.selectWorkUnit(prisonCode);
	}
	
	public void searchAddress(){
		HttpServletResponse response=ServletActionContext.getResponse();
		try{
			PrintWriter out=response.getWriter();
			if(idNum!=null){
				IdentityAddress identity = prisonerServer.getAddress(idNum);
				Dictionary shenfenID=prisonerServer.getshengfen(idNum);
				if(identity!=null){
					String address=java.net.URLEncoder.encode(identity.getAddress(),"UTF-8");
					out.println("{\"result\":\""+address+"\",\"resultID\":\""+shenfenID.getId()+"\"}"); // 返回地址
				}else{
					out.println("{\"result\":\"\",\"resultID\":\"\"}"); //
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}


	public PrisonerService getPrisonerServer() {
		return prisonerServer;
	}


	public void setPrisonerServer(PrisonerService prisonerServer) {
		this.prisonerServer = prisonerServer;
	}


	public DictionaryService getDictionaryService() {
		return dictionaryService;
	}


	public void setDictionaryService(DictionaryService dictionaryService) {
		this.dictionaryService = dictionaryService;
	}


	public PrisonerHealthService getPrisonerHealthService() {
		return prisonerHealthService;
	}


	public void setPrisonerHealthService(PrisonerHealthService prisonerHealthService) {
		this.prisonerHealthService = prisonerHealthService;
	}


	public RiskAssessService getRiskAssessService() {
		return riskAssessService;
	}


	public void setRiskAssessService(RiskAssessService riskAssessService) {
		this.riskAssessService = riskAssessService;
	}


	public List<Prisoner> getLists() {
		return lists;
	}


	public void setLists(List<Prisoner> lists) {
		this.lists = lists;
	}


	public Prisoner getPrisoner() {
		return prisoner;
	}


	public void setPrisoner(Prisoner prisoner) {
		this.prisoner = prisoner;
	}


	public int getPageNum() {
		return pageNum;
	}


	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}


	public int getLimit() {
		return limit;
	}


	public void setLimit(int limit) {
		this.limit = limit;
	}


	public int getTotalPage() {
		return totalPage;
	}


	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}


	public int getTotalNum() {
		return totalNum;
	}


	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getIdNum() {
		return idNum;
	}


	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}


	public List<Dictionary> getGender() {
		return gender;
	}


	public void setGender(List<Dictionary> gender) {
		this.gender = gender;
	}


	public List<Dictionary> getMarryStatus() {
		return marryStatus;
	}


	public void setMarryStatus(List<Dictionary> marryStatus) {
		this.marryStatus = marryStatus;
	}


	public List<Dictionary> getEduLevel() {
		return eduLevel;
	}


	public void setEduLevel(List<Dictionary> eduLevel) {
		this.eduLevel = eduLevel;
	}


	public List<Dictionary> getStatus() {
		return status;
	}


	public void setStatus(List<Dictionary> status) {
		this.status = status;
	}


	public List<Dictionary> getInprison() {
		return inprison;
	}


	public void setInprison(List<Dictionary> inprison) {
		this.inprison = inprison;
	}


	public List<Dictionary> getHandType() {
		return handType;
	}


	public void setHandType(List<Dictionary> handType) {
		this.handType = handType;
	}


	public List<Dictionary> getCrime() {
		return crime;
	}


	public void setCrime(List<Dictionary> crime) {
		this.crime = crime;
	}


	public List<Dictionary> getVoucher() {
		return voucher;
	}


	public void setVoucher(List<Dictionary> voucher) {
		this.voucher = voucher;
	}


	public List<Dictionary> getDangerLev() {
		return dangerLev;
	}


	public void setDangerLev(List<Dictionary> dangerLev) {
		this.dangerLev = dangerLev;
	}


	public List<Dictionary> getOutPrison() {
		return outPrison;
	}


	public void setOutPrison(List<Dictionary> outPrison) {
		this.outPrison = outPrison;
	}


	public List<Dictionary> getManagers() {
		return managers;
	}


	public void setManagers(List<Dictionary> managers) {
		this.managers = managers;
	}


	public List<Dictionary> getDateCheck() {
		return dateCheck;
	}


	public void setDateCheck(List<Dictionary> dateCheck) {
		this.dateCheck = dateCheck;
	}


	public List<Peoples> getPeoples() {
		return peoples;
	}


	public void setPeoples(List<Peoples> peoples) {
		this.peoples = peoples;
	}


	public List<Dictionary> getSpecials() {
		return specials;
	}


	public void setSpecials(List<Dictionary> specials) {
		this.specials = specials;
	}


	public List<Dictionary> getAddress() {
		return address;
	}


	public void setAddress(List<Dictionary> address) {
		this.address = address;
	}


	public List<Career> getCareers() {
		return careers;
	}


	public void setCareers(List<Career> careers) {
		this.careers = careers;
	}


	public List<Document> getDocuments() {
		return documents;
	}


	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}


	public List<Nationality> getNations() {
		return nations;
	}


	public void setNations(List<Nationality> nations) {
		this.nations = nations;
	}


	public List<DetentionInfo> getDetentionList() {
		return detentionList;
	}


	public void setDetentionList(List<DetentionInfo> detentionList) {
		this.detentionList = detentionList;
	}


	public List<WorkUnit> getWorkUnits() {
		return workUnits;
	}


	public void setWorkUnits(List<WorkUnit> workUnits) {
		this.workUnits = workUnits;
	}


	public String getPrisonerNum() {
		return prisonerNum;
	}


	public void setPrisonerNum(String prisonerNum) {
		this.prisonerNum = prisonerNum;
	}


	public String getPrisonerName() {
		return prisonerName;
	}


	public void setPrisonerName(String prisonerName) {
		this.prisonerName = prisonerName;
	}


	public String getRoomNum() {
		return roomNum;
	}


	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}


	public String getDangerlevel() {
		return dangerlevel;
	}


	public void setDangerlevel(String dangerlevel) {
		this.dangerlevel = dangerlevel;
	}


	public String getDetainState() {
		return detainState;
	}


	public void setDetainState(String detainState) {
		this.detainState = detainState;
	}


	public Date getInTime() {
		return inTime;
	}


	public void setInTime(Date inTime) {
		this.inTime = inTime;
	}


	public Date getOutTime() {
		return outTime;
	}


	public void setOutTime(Date outTime) {
		this.outTime = outTime;
	}


	public String getXingju() {
		return xingju;
	}


	public void setXingju(String xingju) {
		this.xingju = xingju;
	}


	public String getYanguan() {
		return yanguan;
	}


	public void setYanguan(String yanguan) {
		this.yanguan = yanguan;
	}


	public Date getRealityTime() {
		return realityTime;
	}


	public void setRealityTime(Date realityTime) {
		this.realityTime = realityTime;
	}


	public Date getChaoqi() {
		return chaoqi;
	}


	public void setChaoqi(Date chaoqi) {
		this.chaoqi = chaoqi;
	}


	public String getYuqi() {
		return yuqi;
	}


	public void setYuqi(String yuqi) {
		this.yuqi = yuqi;
	}


	public String getButanhua() {
		return butanhua;
	}


	public void setButanhua(String butanhua) {
		this.butanhua = butanhua;
	}


	public String getBussiness() {
		return bussiness;
	}


	public void setBussiness(String bussiness) {
		this.bussiness = bussiness;
	}


	public String getFilePath() {
		return filePath;
	}


	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}


	public LogFactory getLog() {
		return log;
	}


	public void setLog(LogFactory log) {
		this.log = log;
	}


	public String getMode() {
		return mode;
	}


	public void setMode(String mode) {
		this.mode = mode;
	}


	public String getStep() {
		return step;
	}


	public void setStep(String step) {
		this.step = step;
	}


	public String getComplete() {
		return complete;
	}


	public void setComplete(String complete) {
		this.complete = complete;
	}


	public String getKuaisu() {
		return kuaisu;
	}


	public void setKuaisu(String kuaisu) {
		this.kuaisu = kuaisu;
	}


	public PrisonerGoodsService getPrisonerGoodsService() {
		return prisonerGoodsService;
	}


	public void setPrisonerGoodsService(PrisonerGoodsService prisonerGoodsService) {
		this.prisonerGoodsService = prisonerGoodsService;
	}


	public Prisoner getOneprison() {
		return oneprison;
	}


	public void setOneprison(Prisoner oneprison) {
		this.oneprison = oneprison;
	}


	public PrisonerHealth getPrisonerHealth() {
		return prisonerHealth;
	}


	public void setPrisonerHealth(PrisonerHealth prisonerHealth) {
		this.prisonerHealth = prisonerHealth;
	}


	public RiskAssess getRiskAssess() {
		return riskAssess;
	}


	public void setRiskAssess(RiskAssess riskAssess) {
		this.riskAssess = riskAssess;
	}


	public PrisonerGoods getPrisonerGoods() {
		return prisonerGoods;
	}


	public void setPrisonerGoods(PrisonerGoods prisonerGoods) {
		this.prisonerGoods = prisonerGoods;
	}


	public boolean isIs_has_image() {
		return is_has_image;
	}


	public void setIs_has_image(boolean is_has_image) {
		this.is_has_image = is_has_image;
	}


	public String getPrintRecord() {
		return printRecord;
	}


	public void setPrintRecord(String printRecord) {
		this.printRecord = printRecord;
	}


	public FingerPrint getFingerPrint() {
		return fingerPrint;
	}


	public void setFingerPrint(FingerPrint fingerPrint) {
		this.fingerPrint = fingerPrint;
	}
	public void setDocumeNum(String documeNum) {
		this.documeNum = documeNum;
	}
	public String getDocumeNum() {
		return documeNum;
	}
	
	public String getOrderlist() {
		return orderlist;
	}
	public void setOrderlist(String orderlist) {
		this.orderlist = orderlist;
	}
	
	public String getPrisonerListWebname() {
		return prisonerListWebname;
	}
	public void setPrisonerListWebname(String prisonerListWebname) {
		this.prisonerListWebname = prisonerListWebname;
	}
	
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getDid() {
		return did;
	}
	public void setDid(String did) {
		this.did = did;
	}
	public String getDetentionNum() {
		return detentionNum;
	}
	public void setDetentionNum(String detentionNum) {
		this.detentionNum = detentionNum;
	}
	
}
