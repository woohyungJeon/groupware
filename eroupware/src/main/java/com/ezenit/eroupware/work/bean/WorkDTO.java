package com.ezenit.eroupware.work.bean;

public class WorkDTO {
	
	private int workNo;
	private String workDate;
	private String startTime;
	private String startIp;
	private String endTime;
	private String endIp;
	private String id;
	private String timeFlag;
	
	
	@Override
	public String toString() {
		return "WorkDTO [workNo=" + workNo + ", workDate=" + workDate + ", startTime=" + startTime + ", startIp="
				+ startIp + ", endTime=" + endTime + ", endIp=" + endIp + ", id=" + id + ", timeFlag=" + timeFlag
				+ ", getWorkNo()=" + getWorkNo() + ", getStartTime()=" + getStartTime() + ", getStartIp()="
				+ getStartIp() + ", getEndTime()=" + getEndTime() + ", getEndIp()=" + getEndIp() + ", getId()="
				+ getId() + ", getTimeFlag()=" + getTimeFlag() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	public int getWorkNo() {
		return workNo;
	}
	public void setWorkNo(int workNo) {
		this.workNo = workNo;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getStartIp() {
		return startIp;
	}
	public void setStartIp(String startIp) {
		this.startIp = startIp;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getEndIp() {
		return endIp;
	}
	public void setEndIp(String endIp) {
		this.endIp = endIp;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTimeFlag() {
		return timeFlag;
	}
	public void setTimeFlag(String timeFlag) {
		this.timeFlag = timeFlag;
	}
	public String getWorkDate() {
		return workDate;
	}
	public void setWorkDate(String workDate) {
		this.workDate = workDate;
	}

}
