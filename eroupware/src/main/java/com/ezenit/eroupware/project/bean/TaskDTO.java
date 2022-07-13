package com.ezenit.eroupware.project.bean;

public class TaskDTO {
	
	private int taskNo;
	private String id;
	private String title;
	private String content;
	private String status;
	private String filepath;
	private int projectNo;
	
	@Override
	public String toString() {
		return "TaskDTO [taskNo=" + taskNo + ", id=" + id + ", title=" + title + ", content=" + content + ", status="
				+ status + ", filepath=" + filepath + ", projectNo=" + projectNo + "]";
	}
	
	public int getTaskNo() {
		return taskNo;
	}
	public void setTaskNo(int taskNo) {
		this.taskNo = taskNo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	public int getProjectNo() {
		return projectNo;
	}
	public void setProjectNo(int projectNo) {
		this.projectNo = projectNo;
	}

}
