package com.ssafy.environment;

public class EnvironmentInfo {
	private String name;
	private String date;
	private String content;
	private String dong;
	public EnvironmentInfo() {
	}
	public EnvironmentInfo(String name, String date, String content, String dong) {
		super();
		this.name = name;
		this.date = date;
		this.content = content;
		this.dong = dong;
	}
	public String getName() {
		return name;
	}
	public String getDate() {
		return date;
	}
	public String getContent() {
		return content;
	}
	public String getDong() {
		return dong;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}
	@Override
	public String toString() {
		return "EnvironmentInfo [name=" + name + ", date=" + date + ", content=" + content + ", dong=" + dong + "]";
	}
	
}
