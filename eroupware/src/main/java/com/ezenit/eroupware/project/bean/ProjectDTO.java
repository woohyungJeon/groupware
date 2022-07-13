package com.ezenit.eroupware.project.bean;

public class ProjectDTO {
	
	private int projectNo;
	private String title;
	private String content;
	private String status;
	private String color;
	private String regdate;
	
	@Override
	public String toString() {
		return "ProjectDTO [projectNo=" + projectNo + ", title=" + title + ", content=" + content + ", status=" + status
				+ ", color=" + color + ", regdate=" + regdate + "]";
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
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}

}
