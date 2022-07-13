package com.ezenit.eroupware.project.bean;

public class ProjectMemberListDTO {
	
	private int projectNo;
	private String id;
	private String name;
	private String image;
	private String rankname;
	private String deptname;
	private int taskTotalCnt;
	private int taskCompleteCnt;
	private int taskPercent;
	
	@Override
	public String toString() {
		return "ProjectMemberListDTO [projectNo=" + projectNo + ", id=" + id + ", name=" + name + ", image=" + image
				+ ", rankname=" + rankname + ", deptname=" + deptname + ", taskTotalCnt=" + taskTotalCnt
				+ ", taskCompleteCnt=" + taskCompleteCnt + ", taskPercent=" + taskPercent + "]";
	}
	public int getProjectNo() {
		return projectNo;
	}
	public void setProjectNo(int projectNo) {
		this.projectNo = projectNo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getRankname() {
		return rankname;
	}
	public void setRankname(String rankname) {
		this.rankname = rankname;
	}
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	public int getTaskTotalCnt() {
		return taskTotalCnt;
	}
	public void setTaskTotalCnt(int taskTotalCnt) {
		this.taskTotalCnt = taskTotalCnt;
	}
	public int getTaskCompleteCnt() {
		return taskCompleteCnt;
	}
	public void setTaskCompleteCnt(int taskCompleteCnt) {
		this.taskCompleteCnt = taskCompleteCnt;
	}
	public int getTaskPercent() {
		return taskPercent;
	}
	public void setTaskPercent(int taskPercent) {
		this.taskPercent = taskPercent;
	}
	
}
