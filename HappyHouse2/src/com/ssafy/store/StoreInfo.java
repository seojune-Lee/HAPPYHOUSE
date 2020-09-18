package com.ssafy.store;

public class StoreInfo {
	private String name;
	private String branch;
	private String kind;
	private String dong;
	
	public StoreInfo() {

	}

	public StoreInfo(String name, String branch, String kind, String dong) {
		super();
		this.name = name;
		this.branch = branch;
		this.kind = kind;
		this.dong = dong;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getDong() {
		return dong;
	}

	public void setDong(String dong) {
		this.dong = dong;
	}

	@Override
	public String toString() {
		return "StoreInfo [name=" + name + ", branch=" + branch + ", kind=" + kind + ", dong=" + dong + "]";
	}
}
