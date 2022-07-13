package com.ezenit.eroupware.project.bean;

public class TaskStatusCntDTO {
	
	private int totalCnt;
	private int completeCnt;

	@Override
	public String toString() {
		return "TaskStatusCntDTO [totalCnt=" + totalCnt + ", completeCnt=" + completeCnt + "]";
	}
	public int getTotalCnt() {
		return totalCnt;
	}
	public void setTotalCnt(int totalCnt) {
		this.totalCnt = totalCnt;
	}
	public int getCompleteCnt() {
		return completeCnt;
	}
	public void setCompleteCnt(int completeCnt) {
		this.completeCnt = completeCnt;
	}

}
