package com.ezenit.eroupware.commons.bean;

public class DeptSelectDTO {
	
	private int deptno;
	private String deptname;
	
	@Override
	public String toString() {
		return "DeptSelectDTO [deptno=" + deptno + ", deptname=" + deptname + "]";
	}
	
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	
	
	
}
