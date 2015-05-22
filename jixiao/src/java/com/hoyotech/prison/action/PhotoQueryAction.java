package com.hoyotech.prison.action;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.hoyotech.prison.bean.Dictionary;
import com.hoyotech.prison.bean.PrisonInfo;
import com.hoyotech.prison.bean.Prisoner;
import com.hoyotech.prison.service.impl.DictionaryService;
import com.hoyotech.prison.service.impl.PhotoQueryService;
import com.hoyotech.prison.service.impl.PrisonInfoService;
import com.hoyotech.prison.service.impl.PrisonerService;
import com.hoyotech.prison.util.Type;
import com.isa.pims.basic.ServletRequestUtils;

public class PhotoQueryAction {
	private String documeNum; // 证件号码
	private String name; // 姓名
	private String origionPlaceCode; // 籍贯
	private String birthday_startTime; // 出生日期
	private String birthday_stopTime; // 出生日期
	private String educationLevel_id; // 文化程度
	private String prison_id; // 拘留所编号
	private String detentionCode; // 拘室
	private String in_startTime; // 入所开始日期
	private String in_stopTime; // 入所截止日期

	private String out_startTime; // 出所开始日期
	private String out_stopTime; // 出所截止日期
	private String inprisonReson; // 入所原因
	private String outprisonReson; // 出所原因
	private List<String> pcodelist;// 人员列表信息
	private PhotoQueryService photoQueryService;
	private PrisonerService prisonerServer;

	private List<PrisonInfo> prlist;// 拘留所信息
	private List<Dictionary> oplist;// 籍贯信息列表
	private List<Dictionary> edlist;// 文化程度 所有信息
	private List<Dictionary> inlist;// 入所原因
	private List<Dictionary> outlist;// 出所原因

	private int pageNum;
	private int limit;
	private int totalPage;
	private int totalNum;
	private DictionaryService dictionaryService;
	private String prisoner_id;
	private PrisonInfoService prisonService;

	public String getPrison_id() {
		return prison_id;
	}

	public void setPrison_id(String prisonId) {
		prison_id = prisonId;
	}

	public String getPrisoner_id() {
		return prisoner_id;
	}

	public void setPrisoner_id(String prisonerId) {
		prisoner_id = prisonerId;
	}

	public void listinit() {
		oplist = dictionaryService.selectDictionary(Type.ADDRESSTYPE);
		edlist = dictionaryService.selectDictionary(Type.EDUCATIONTYPE);
		inlist = dictionaryService.selectDictionary(Type.INPRISONTYPE);
		outlist = dictionaryService.selectDictionary(Type.OUTPRISONTYPE);
		prlist = prisonService.allPrisonInfo();
	}

	public String init() {
		listinit();
		return "init";
	}

	public String selectPrisoner() {
		listinit();
		HttpServletRequest request = ServletActionContext.getRequest();
		pageNum = ServletRequestUtils.getInt(request, "page", "1");
		limit = ServletRequestUtils.getInt(request, "limit", "12");
//		System.out.println(documeNum + "---" + name + "---" + origionPlaceCode
//				+ "---" + birthday_startTime + "---" + birthday_stopTime
//				+ "---" + educationLevel_id + "---" + prison_id + "---"
//				+ detentionCode + "---" + in_startTime + "---" + in_stopTime
//				+ "---" + out_startTime + "---" + out_stopTime + "---"
//				+ inprisonReson + "---" + outprisonReson + "---" + pageNum
//				+ "---" + limit);
		pcodelist = photoQueryService.allPrisonersForPhoto(documeNum, name,
				origionPlaceCode, birthday_startTime, birthday_stopTime,
				educationLevel_id, prison_id, detentionCode, in_startTime,
				in_stopTime, out_startTime, out_stopTime, inprisonReson,
				outprisonReson, pageNum, limit);
		totalNum = photoQueryService.allCount(documeNum, name,
				origionPlaceCode, birthday_startTime, birthday_stopTime,
				educationLevel_id, prison_id, detentionCode, in_startTime,
				in_stopTime, out_startTime, out_stopTime, inprisonReson,
				outprisonReson);
		totalPage = (totalNum - 1) / limit + 1;
		return "select";
//		alert("pageNum : "+pageNum+"  limit : "+limit+"   totalPage : "+totalPage);
	}

	public void getPrisonerDetailById() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		Prisoner p = prisonerServer.detail(prisoner_id);
		String prisonName = p.getPrison().getPrisonName();
		String name = p.getName();
		String educationLevel = p.getEducationLevel().getDescription();
		String marryStatues = p.getMarryStatus().getDescription();
		String sex = p.getGender().getDescription();
		String nickName = p.getNickName();
		String birthday = new SimpleDateFormat("yyyy-MM-dd").format(p
				.getBirthday());
		String documeNum = p.getDocumeNum();
		String origionPlace = p.getOrigionPlace().getDescription();
		String accountLocation = p.getAccountLocation().getDescription();
		String carer = p.getCarer().getDescription();
		String status = p.getStatus().getDescription();
		String workplace = p.getWorkPlace();
		String remack = p.getRemark();
		String specialStatus = p.getSpecialStatus().getDescription();
		String managerClasses = p.getManagerClasses().getDescription();
		String intime = new SimpleDateFormat("yyyy-MM-dd").format(p
				.getDateInprison());
		String imprisonReason = p.getImprisonReason().getDescription();
		String crime = p.getCrime().getDescription();
		String getHandleCases = p.getHandleCases().getUnitName();
		String datagatherName = p.getDatagatherName();
		String sammary = p.getSammary();

		try {
			PrintWriter out = response.getWriter();
			out.println("{\"marryStatues\":\"" + marryStatues
					+ "\",\"educationLevel\":\"" + educationLevel
					+ "\",\"prisonName\":\"" + prisonName + "\",\"name\":\""
					+ name + "\",\"sex\":\"" + sex + "\",\"nickName\":\""
					+ nickName + "\",\"birthday\":\"" + birthday
					+ "\",\"documeNum\":\"" + documeNum
					+ "\",\"origionPlace\":\"" + origionPlace
					+ "\",\"accountLocation\":\"" + accountLocation
					+ "\",\"carer\":\"" + carer + "\",\"status\":\"" + status
					+ "\",\"workplace\":\"" + workplace + "\",\"remack\":\""
					+ remack + "\",\"specialStatus\":\"" + specialStatus
					+ "\",\"managerClasses\":\"" + managerClasses
					+ "\",\"intime\":\"" + intime + "\",\"imprisonReason\":\""
					+ imprisonReason + "\",\"crime\":\"" + crime
					+ "\",\"getHandleCases\":\"" + getHandleCases
					+ "\",\"datagatherName\":\"" + datagatherName
					+ "\",\"sammary\":\"" + sammary + "\"}");
		} catch (Exception e) {
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

	public List<Dictionary> getOplist() {
		return oplist;
	}

	public void setOplist(List<Dictionary> oplist) {
		this.oplist = oplist;
	}

	public List<Dictionary> getInlist() {
		return inlist;
	}

	public void setInlist(List<Dictionary> inlist) {
		this.inlist = inlist;
	}

	public List<Dictionary> getOutlist() {
		return outlist;
	}

	public void setOutlist(List<Dictionary> outlist) {
		this.outlist = outlist;
	}

	public List<Dictionary> getEdlist() {
		return edlist;
	}

	public void setEdlist(List<Dictionary> edlist) {
		this.edlist = edlist;
	}

	public PhotoQueryService getPhotoQueryService() {
		return photoQueryService;
	}

	public void setPhotoQueryService(PhotoQueryService photoQueryService) {
		this.photoQueryService = photoQueryService;
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

	public String getDocumeNum() {
		return documeNum;
	}

	public void setDocumeNum(String documeNum) {
		this.documeNum = documeNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthday_startTime() {
		return birthday_startTime;
	}

	public void setBirthday_startTime(String birthdayStartTime) {
		birthday_startTime = birthdayStartTime;
	}

	public String getBirthday_stopTime() {
		return birthday_stopTime;
	}

	public void setBirthday_stopTime(String birthdayStopTime) {
		birthday_stopTime = birthdayStopTime;
	}

	public String getEducationLevel_id() {
		return educationLevel_id;
	}

	public void setEducationLevel_id(String educationLevelId) {
		educationLevel_id = educationLevelId;
	}

	public String getPrisonCode() {
		return prison_id;
	}

	public void setPrisonCode(String prisonCode) {
		this.prison_id = prisonCode;
	}

	public String getDetentionCode() {
		return detentionCode;
	}

	public void setDetentionCode(String detentionCode) {
		this.detentionCode = detentionCode;
	}

	public String getIn_startTime() {
		return in_startTime;
	}

	public void setIn_startTime(String inStartTime) {
		in_startTime = inStartTime;
	}

	public String getIn_stopTime() {
		return in_stopTime;
	}

	public void setIn_stopTime(String inStopTime) {
		in_stopTime = inStopTime;
	}

	public String getOut_startTime() {
		return out_startTime;
	}

	public void setOut_startTime(String outStartTime) {
		out_startTime = outStartTime;
	}

	public String getOut_stopTime() {
		return out_stopTime;
	}

	public void setOut_stopTime(String outStopTime) {
		out_stopTime = outStopTime;
	}

	public String getOrigionPlaceCode() {
		return origionPlaceCode;
	}

	public void setOrigionPlaceCode(String origionPlaceCode) {
		this.origionPlaceCode = origionPlaceCode;
	}

	public String getInprisonReson() {
		return inprisonReson;
	}

	public void setInprisonReson(String inprisonReson) {
		this.inprisonReson = inprisonReson;
	}

	public String getOutprisonReson() {
		return outprisonReson;
	}

	public void setOutprisonReson(String outprisonReson) {
		this.outprisonReson = outprisonReson;
	}

	public List<String> getPcodelist() {
		return pcodelist;
	}

	public void setPcodelist(List<String> pcodelist) {
		this.pcodelist = pcodelist;
	}

	public List<PrisonInfo> getPrlist() {
		return prlist;
	}

	public void setPrlist(List<PrisonInfo> prlist) {
		this.prlist = prlist;
	}

	public PrisonInfoService getPrisonService() {
		return prisonService;
	}

	public void setPrisonService(PrisonInfoService prisonService) {
		this.prisonService = prisonService;
	}

}
