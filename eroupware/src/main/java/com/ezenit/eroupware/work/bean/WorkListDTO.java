package com.ezenit.eroupware.work.bean;

public class WorkListDTO {

	private int workNo;
	private String workDate;
	private String dayOfWeek;
	private String startTime;
	private String startIp;
	private String endTime;
	private String endIp;
	private String id;

	public WorkListDTO() {
		super();
	}

	public WorkListDTO(String workDate, String dayOfWeek, String id) {
		super();
		this.workDate = workDate;
		this.dayOfWeek = dayOfWeek;
		this.id = id;
	}
	
	


	@Override
	public String toString() {
		return "WorkListDTO [workNo=" + workNo + ", workDate=" + workDate + ", dayOfWeek=" + dayOfWeek + ", startTime="
				+ startTime + ", startIp=" + startIp + ", endTime=" + endTime + ", endIp=" + endIp + ", id=" + id + "]";
	}

	public int getWorkNo() {
		return workNo;
	}

	public void setWorkNo(int workNo) {
		this.workNo = workNo;
	}

	public String getWorkDate() {
		return workDate;
	}

	public void setWorkDate(String workDate) {
		this.workDate = workDate;
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

	public String getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}
	

}
