package com.hoyotech.prison.bean;

public class Permission {

	private int id;
	private String keyName;
	private String permission;
	private String moduleId;
	private String moduleName;
	private String explain;
	private String url;
	private String path;
	private String organizeType;
	
	private int isSync = 0;// 是否同步；0：未同步；1：已同步

	public Permission() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIsSync() {
		return isSync;
	}

	public void setIsSync(int isSync) {
		this.isSync = isSync;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getModuleId() {
		return moduleId;
	}
	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public String getOrganizeType() {
		return organizeType;
	}
	public void setOrganizeType(String organizeType) {
		this.organizeType = organizeType;
	}

	public String getKeyName() {
		return keyName;
	}
	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	public String getExplain() {
		return explain;
	}
	public void setExplain(String explain) {
		this.explain = explain;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	
}
