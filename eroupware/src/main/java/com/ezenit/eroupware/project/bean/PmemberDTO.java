package com.ezenit.eroupware.project.bean;

import java.util.Arrays;

public class PmemberDTO {
	
	private int pmemberNo;
	private String[] idArr;
	private int projectNo;
	
	@Override
	public String toString() {
		return "PmemberDTO [pmemberNo=" + pmemberNo + ", idArr=" + Arrays.toString(idArr) + ", projectNo=" + projectNo
				+ "]";
	}
	
	public int getPmemberNo() {
		return pmemberNo;
	}
	public void setPmemberNo(int pmemberNo) {
		this.pmemberNo = pmemberNo;
	}
	public String[] getIdArr() {
		return idArr;
	}
	public void setIdArr(String[] idArr) {
		this.idArr = idArr;
	}
	public int getProjectNo() {
		return projectNo;
	}
	public void setProjectNo(int projectNo) {
		this.projectNo = projectNo;
	}
	
	

}
