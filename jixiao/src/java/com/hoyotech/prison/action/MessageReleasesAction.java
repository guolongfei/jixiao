package com.hoyotech.prison.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.hoyotech.prison.bean.AttachedFile;
import com.hoyotech.prison.bean.BasicSetUp;
import com.hoyotech.prison.bean.JX_Appraise;
import com.hoyotech.prison.bean.MessageReleases;
import com.hoyotech.prison.bean.MessageType;
import com.hoyotech.prison.bean.RuleType;
import com.hoyotech.prison.service.impl.MessageReleasesService;

public class MessageReleasesAction {
	
	private MessageReleasesService messageReleasesService;
	private List<MessageReleases> list;   //接收数据库的返回值
	private List<MessageReleases> list1;   //查询通知公告的消息
	private List<MessageType> listmt;
	private List<RuleType> listrt;         //接收政策法则的所有子分类
	private MessageReleases messageRelease;	
	private String messageType;   //消息类型
	private int pageNum;       //分页当前页
	private int totalNum;      //数据总数
	private int totalPage;     //分页总数
	private String titleName;  //标题名称
	private String id;
    private File file;
    private String title;      //根据标题查询政策相关信息
    private int ruleType;      //政策分类的类型
    private String userId;
    private String name;//姓名
    private String phoneNumber;//电话
    private String content;//内容
    private List<JX_Appraise> appraiseList;
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	private List<AttachedFile> listaf; //附件列表
    private List<Object[]> list2;
    //基础信息配置部分
    private List<BasicSetUp> basicList;//基础信息列表
    private BasicSetUp basicSetUp;
    private String errorMsg;
    private String bsId;
    private JX_Appraise jx_appraise;
  //提交过来的file的名字
    private String fileFileName;
      
    private File file1;
    private String file1FileName;
        
    public File getFile1() {
		return file1;
	}

	public void setFile1(File file1) {
		this.file1 = file1;
	}

	public String getFile1FileName() {
		return file1FileName;
	}

	public void setFile1FileName(String file1FileName) {
		this.file1FileName = file1FileName;
	}

	public List<Object[]> getList2() {
		return list2;
	}

	public void setList2(List<Object[]> list2) {
		this.list2 = list2;
	}

	public List<AttachedFile> getListaf() {
		return listaf;
	}

	public void setListaf(List<AttachedFile> listaf) {
		this.listaf = listaf;
	}


    public String getBsId() {
		return bsId;
    }

	public void setBsId(String bsId) {
		this.bsId = bsId;
	}

	public String getErrorMsg() {
        return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public BasicSetUp getBasicSetUp() {
		return basicSetUp;
	}

	public void setBasicSetUp(BasicSetUp basicSetUp) {
		this.basicSetUp = basicSetUp;
	}

	public List<BasicSetUp> getBasicList() {
		return basicList;
	}

	public void setBasicList(List<BasicSetUp> basicList) {
		this.basicList = basicList;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<RuleType> getListrt() {
		return listrt;
	}

	public void setListrt(List<RuleType> listrt) {
		this.listrt = listrt;
	}

	public int getRuleType() {
		return ruleType;
	}

	public void setRuleType(int ruleType) {
		this.ruleType = ruleType;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public List<MessageReleases> getList1() {
		return list1;
	}

	public void setList1(List<MessageReleases> list1) {
		this.list1 = list1;
	}

	public String getTitleName() {
		return titleName;
	}

	public void setTitleName(String titleName) {
		this.titleName = titleName;
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

	public MessageReleases getMessageRelease() {
		return messageRelease;
	}

	public void setMessageRelease(MessageReleases messageRelease) {
		this.messageRelease = messageRelease;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<MessageReleases> getList() {
		return list;
	}

	public void setList(List<MessageReleases> list) {
		this.list = list;
	}
	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}


	public MessageReleasesService getMessageReleasesService() {
		return messageReleasesService;
	}

	public void setMessageReleasesService(
			MessageReleasesService messageReleasesService) {
		this.messageReleasesService = messageReleasesService;
	}	
	public String getMessageType() {
		return messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}
	
	public List<MessageType> getListmt() {
		return listmt;
	}

	public void setListmt(List<MessageType> listmt) {
		this.listmt = listmt;
	}
    
	//根据消息类型获取消息列表
	public String getMessageList()
	{
		if(pageNum==0)
		{
			pageNum=1;
		}
		list=messageReleasesService.getMessageList(messageType,pageNum+"");
		list1=messageReleasesService.getMessageList(1+"",1+"");	 //动态获取二级界面通知公告的数据	
		titleName=messageReleasesService.getTypeName(messageType);
		totalNum = messageReleasesService.getTotalList(messageType);
		totalPage = (totalNum - 1) / 10 + 1;
		return "getMessageList";
	}
	//发表评价
	public String AddAppraise(){
		jx_appraise = new JX_Appraise();
		Date date = new Date();
		jx_appraise.setAppraise_time(date);
		jx_appraise.setContent(content);
		jx_appraise.setMessageReleasesId(id);
		jx_appraise.setName(name);
		jx_appraise.setPhoneNumber(phoneNumber);
		messageReleasesService.addAppraise(jx_appraise);
		messageRelease=messageReleasesService.detail(id);
		listaf=messageReleasesService.getTypeById(id);
		messageType="4";
		return "detail";
	}
	public String AppraiseList(){
		if(pageNum==0)
		{
			pageNum=1;
		}
		appraiseList = messageReleasesService.getAppraise(pageNum+"");
		list1=messageReleasesService.getMessageList(1+"",1+"");	 //动态获取二级界面通知公告的数据	
		totalNum = messageReleasesService.getAppraiseNum();
		totalPage = (totalNum - 1) / 10 + 1;
		return "appraise";
	}
	
	public JX_Appraise getJx_appraise() {
		return jx_appraise;
	}

	public void setJx_appraise(JX_Appraise jxAppraise) {
		jx_appraise = jxAppraise;
	}

	//根据消息类型获取最新政策列表
	public String getZhengceList() throws UnsupportedEncodingException
	{
		if(title==null)
		{
			title="";
		}
    	else
    	{
    	    title=URLDecoder.decode(title,"UTF-8");
    	}
		if(pageNum==0)
		{
			pageNum=1;
		}
		list=messageReleasesService.getZhengceList(12+"",pageNum+"",title,ruleType);	
		listrt=messageReleasesService.getAllRule();
		totalNum = messageReleasesService.getTotalZhengceList(12+"",title,ruleType);
		totalPage = (totalNum - 1) / 10 + 1;
		return "getZhengceList";
	}
	
	//跳转到政策详情界面
	public String  zhengceDetail() {
		messageRelease=messageReleasesService.detail(id);
		listaf=messageReleasesService.getTypeById(id);
		return "zhengceDetail";
	}
		
	public String detail() {
		messageRelease=messageReleasesService.detail(id);
		listaf=messageReleasesService.getTypeById(id);
		appraiseList = messageReleasesService.appraiseList(id);
		return "detail";
	}
	
	/*
	 * 刘泉 2015.01.25
	 * 进入信息列表
	 * */
	public String bs_getMessageList(){
		if(pageNum==0)
		{
			pageNum=1;
		}
		list2=messageReleasesService.bs_getMessageList(pageNum);
		totalNum=messageReleasesService.bs_getTotalMessageSize();
		totalPage = (totalNum - 1) / 10 + 1;
		return "bs_messageList";
	}
	
	/*
	 * 刘泉 2015.01.25
	 * 获取时间列表
	 * */
	public void bs_getMessageList1(){
		if(pageNum==0)
		{
			pageNum=1;
		}
		list2=messageReleasesService.bs_getMessageList(pageNum);
		totalNum=messageReleasesService.bs_getTotalMessageSize();
		totalPage = (totalNum - 1) / 10 + 1;
	}
	
	public String bs_gotoMessageAddPage(){
		bs_getMessageType();
		listrt=messageReleasesService.getAllRule();
		return "bs_messageAdd";
	}
	
	//文件上传
	public String fileUpload() throws IOException
	{
        
		String root = ServletActionContext.getServletContext().getRealPath("/upload");       
        InputStream is = new FileInputStream(file);
        OutputStream os = new FileOutputStream(new File(root, fileFileName));       
        byte[] buffer = new byte[500];
        int length = 0;
        
        while(-1 != (length = is.read(buffer, 0, buffer.length)))
        {
            os.write(buffer);
        }       
        os.close();
        is.close();
		return "getMessageList";
	}
	
	/*
	 * 刘泉 2015.01.25
	 * 获取信息类型
	 * */
	public void bs_getMessageType(){
		listmt=messageReleasesService.bs_getMessageType();
	}
	
	/*
	 * 刘泉 2015.01.25
	 * 信息保存
	 * */
	public String bs_SaveAdd() throws IOException{
		userId=(String) ServletActionContext.getRequest().getSession().getAttribute("userId");
		String deptId=(String) ServletActionContext.getRequest().getSession().getAttribute("deptId");
		messageRelease.setAdd_dept_id(deptId);
		//messageRelease.setAdd_time(new Date());
		messageRelease.setUser_id(userId);				
		if(file1FileName!=null)
		{
		String root = ServletActionContext.getServletContext().getRealPath("/message_upload");       
        InputStream is = new FileInputStream(file1);
        OutputStream os = new FileOutputStream(new File(root, file1FileName));       
        byte[] buffer = new byte[500];
        int length = 0;
        
        while(-1 != (length = is.read(buffer, 0, buffer.length)))
        {
            os.write(buffer);
        }       
        os.close();
        is.close();       
        messageRelease.setTitle_img_url(file1FileName);
		}
		String id=messageReleasesService.bs_SaveAdd(messageRelease);
		if(fileFileName!=null)
		{
		String root = ServletActionContext.getServletContext().getRealPath("/upload");       
        InputStream is = new FileInputStream(file);
        OutputStream os = new FileOutputStream(new File(root, fileFileName));       
        byte[] buffer = new byte[500];
        int length = 0;
        
        while(-1 != (length = is.read(buffer, 0, buffer.length)))
        {
            os.write(buffer);
        }       
        os.close();
        is.close();
        AttachedFile af=new AttachedFile();
        af.setFile_id(id);
        af.setFile_name(fileFileName);
        messageReleasesService.saveFile(af);
		}
		bs_getMessageList1();
		return "bs_messageList";
	}

	
	//展示门户网上标题及类型
	public String showType()
	{
		listmt=messageReleasesService.bs_getMessageType();
		return "bs_messageUpdate";
	}
	
	//修改门户网上标题
	public String updateType()
	{
		messageReleasesService.updateType(titleName,messageType);
		return showType();
	}

	
	//获取基础信息配置列表
	public String getBasicSetup(){
		basicList = messageReleasesService.getBasicList();
		return "basicList";
	}
	
	//跳转到基础信息设置
	public String toBasicSetup(){
		return "toBasicSetup";
	}
	
	//基础信息设置
	public String basicSetUp(){
		errorMsg = "";
		basicSetUp.setAddtime(new Date());
		messageReleasesService.basicSetUp(basicSetUp);
		errorMsg = "success";
		return "toBasicSetup";
	}
	
	//基础信息删除
	public String deleteBS(){
		errorMsg = "";
		messageReleasesService.deleteBasicSetUp(bsId);
		errorMsg = "success";
		return getBasicSetup();
	}
	
	//删除新闻
	public String deleteMes()
	{
		messageReleasesService.deleteMes(id);
		bs_getMessageList1();
		return "bs_messageList";
	}

	public void setAppraiseList(List<JX_Appraise> appraiseList) {
		this.appraiseList = appraiseList;
	}

	public List<JX_Appraise> getAppraiseList() {
		return appraiseList;
	}
}
