package com.ezenit.eroupware.project.bean;

public class ProjectTaskCntDTO {
	
	private int projectNo;
	private int totalCnt;
	private int waitCnt;
	private int processCnt;
	private int completeCnt;
	
	@Override
	public String toString() {
		return "ProjectTaskCntDTO [projectNo=" + projectNo + ", totalCnt=" + totalCnt + ", waitCnt=" + waitCnt
				+ ", processCnt=" + processCnt + ", completeCnt=" + completeCnt + "]";
	}
	
	public int getProjectNo() {
		return projectNo;
	}
	public void setProjectNo(int projectNo) {
		this.projectNo = projectNo;
	}
	public int getTotalCnt() {
		return totalCnt;
	}
	public void setTotalCnt(int totalCnt) {
		this.totalCnt = totalCnt;
	}
	public int getWaitCnt() {
		return waitCnt;
	}
	public void setWaitCnt(int waitCnt) {
		this.waitCnt = waitCnt;
	}
	public int getProcessCnt() {
		return processCnt;
	}
	public void setProcessCnt(int processCnt) {
		this.processCnt = processCnt;
	}
	public int getCompleteCnt() {
		return completeCnt;
	}
	public void setCompleteCnt(int completeCnt) {
		this.completeCnt = completeCnt;
	}

}
