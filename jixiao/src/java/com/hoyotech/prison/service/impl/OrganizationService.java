package com.hoyotech.prison.service.impl;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hoyotech.prison.bean.Area;
import com.hoyotech.prison.bean.Organization;
import com.hoyotech.prison.bean.Police;
import com.hoyotech.prison.dao.impl.BasicDao;
import com.hoyotech.prison.util.ObjectUpdateUtil;

public class OrganizationService {
	private BasicDao dao;
	
	/**
	 * 查询组织信息
	 * @param orgCode
	 * @param orgName
	 * @param orgState
	 * @param orgLevel
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	public List<Organization> getList(String orgCode, String orgName, String orgState, String orgLevel, int pageNumber,int pageSize){
		List<String> param = getParaCondition(orgCode, orgName, orgState, orgLevel);
		String condition = getCondition(orgCode, orgName, orgState, orgLevel);
		
		String hql = "from Organization where state=1"+condition+" order by updateTime desc";
		
		return (List<Organization>)dao.queryByHql(hql, param.toArray(), pageNumber, pageSize);
	}
	
	/**
	 * 查询一级和二级组织列表
	 * @return
	 */
	public List<Organization> getParentOrgList(){
		String hql = "from Organization where state=1 and orgLevel<3 order by path asc";
		List<Organization> list = (List<Organization>)dao.queryByHql(hql, null);
		for(Organization org : list){
			if(org.getOrgLevel() == 1){
				org.setOrgName("|-"+org.getOrgName());
			}else if(org.getOrgLevel() == 2){
				org.setOrgName("　|-"+org.getOrgName());
			}
		}
		return list;
	}
	
	/**
	 * 查询二级组织列表
	 * @return
	 */
	public List<Organization> getOrgTwoList(){
		String hql = "from Organization where state=1 and orgLevel=2";
		List<Organization> list = (List<Organization>)dao.queryByHql(hql, null);
		return list;
	}
	
	/**
	 * 查询三级组织列表
	 * @return
	 */
	public List<Organization> getOrgList(){
		String hql = "from Organization where state=1 and orgLevel=3";
		List<Organization> list = (List<Organization>)dao.queryByHql(hql, null);
		return list;
	}
	
	/**
	 * 查询组织总数
	 **/
	public int getCount(String orgCode, String orgName, String orgState, String orgLevel){
		List<String> param = getParaCondition(orgCode, orgName, orgState, orgLevel);
		String condition = getCondition(orgCode, orgName, orgState, orgLevel);
		
		String hql = "select count(*) from Organization where state=1"+condition;
		
		return dao.getCount(hql, param.toArray());
	}
	
	/**
	 * 读取警员列表
	 * @return
	 */
	public List<Police> getPoliceList(){
		String hql="from Police";
		List<Police> list = (List<Police>)dao.queryByHql(hql, null);
		return list;
	}
	
	public String getCondition(String orgCode, String orgName, String orgState, String orgLevel){
		StringBuilder sb = new StringBuilder();
		if(orgCode != null && orgCode.length() > 0){
			sb.append(" and orgCode=?");
		}
		if(orgName != null && orgName.length() > 0){
			sb.append(" and orgName like '%"+orgName+"%'");
		}
		if(orgState != null && orgState.length() > 0){
			sb.append(" and state=?");
		}
		if(orgLevel != null && orgLevel.length() > 0){
			sb.append(" and orgLevel=?");
		}
		return sb.toString();
	}
	
	public List<String> getParaCondition(String orgCode, String orgName, String orgState, String orgLevel){
		List<String> list = new ArrayList<String>();
		if(orgCode != null && orgCode.length() > 0){
			list.add(orgCode);
		}
//		if(orgName != null && orgName.length() > 0){
//			list.add(orgName);
//		}
		if(orgState != null && orgState.length() > 0){
			list.add(orgState);
		}
		if(orgLevel != null && orgLevel.length() > 0){
			list.add(orgLevel);
		}
		return list;
	}
	
	public String add(Organization org){
		//解决外键为空的异常
		ObjectUpdateUtil.checkProperty(org);
		org.setAddTime(new Date());
		org.setUpdateTime(new Date());
		String id = dao.save(org);
		org.setId(id);
		
		updateLevelAndPath(org);
		//生成组织机构编码
		String orgCode = this.createOrgCode(org);
		org.setOrgCode(orgCode);
		dao.update(org);
		return id;
	}
	
	public Organization detail(String id){
		return (Organization)dao.detail(Organization.class, id);
	}
	
	public void update(Organization org){
		//解决外键为空的异常
		ObjectUpdateUtil.checkProperty(org);
		org.setUpdateTime(new Date());
		updateLevelAndPath(org);
		
		dao.update(org);
	}
	
	public void delete(String id){
		String hql = "update Organization set state=0 where id=?";
		dao.executeHql(hql, new Object[]{id});
	}
	
	/**
	 * 生成新对象
	 * @param org
	 * @return
	 */
	public void updateLevelAndPath(Organization org){
		int newLevel = 1;
		String newPath = "";
		if(org.getParentOrg() != null){
			Organization parentOrg = (Organization) dao.detail(Organization.class, org.getParentOrg().getId());
			newLevel = parentOrg.getOrgLevel() + 1;
			newPath = parentOrg.getPath()+org.getId()+"-";
		}else{
			newPath = "-"+org.getId()+"-";
		}
		
		org.setOrgLevel(newLevel);
		org.setPath(newPath);
	}
	
	/**
	 * 生成组织机构编码
	 * @param org
	 * @return
	 */
	public String createOrgCode(Organization org){
		String code = "";
		if(org.getParentOrg() != null){
			//查询该区域下已有组织数量
			int count = dao.getCount("select count(*) from Organization where parentOrg.id=?", new Object[]{org.getParentOrg().getId()});
			
			if(org.getOrgLevel() == 2){
				Area area = (Area)dao.detail(Area.class, org.getArea().getId());
				
				DecimalFormat format = new DecimalFormat("0000");
				code = area.getRegionCode()+format.format(count)+"00";
				
			}else{
				Organization parentOrg = detail(org.getParentOrg().getId());
				
				DecimalFormat format = new DecimalFormat("00");
				code = parentOrg.getOrgCode().substring(0, 10)+format.format(count);
			}
			
		} else if(org.getOrgLevel() == 1){
			code = "420000"+"000000";
		}
		return code;
	}
	
	public BasicDao getDao() {
		return dao;
	}
	
	public void setDao(BasicDao dao) {
		this.dao = dao;
	}
}
