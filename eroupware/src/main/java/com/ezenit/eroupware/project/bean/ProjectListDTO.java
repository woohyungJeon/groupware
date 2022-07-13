package com.ezenit.eroupware.project.bean;

public class ProjectListDTO {
	
	private int projectNo;
	private String title;
	private String content;
	private String status;
	private String color;
	private String regdate;
	private int pmembers;
	private int percent;
	
	
	@Override
	public String toString() {
		return "ProjectListDTO [projectNo=" + projectNo + ", title=" + title + ", content=" + content + ", status="
				+ status + ", color=" + color + ", regdate=" + regdate + ", pmembers=" + pmembers + ", percent="
				+ percent + "]";
	}
	public int getProjectNo() {
		return projectNo;
	}
	public void setProjectNo(int projectNo) {
		this.projectNo = projectNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public int getPmembers() {
		return pmembers;
	}
	public void setPmembers(int pmembers) {
		this.pmembers = pmembers;
	}
	public int getPercent() {
		return percent;
	}
	public void setPercent(int percent) {
		this.percent = percent;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}

}
