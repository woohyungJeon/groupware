package com.ezenit.eroupware.admin.bean;

public class AdminMemberDTO {
	
	private String id;
	private String deptname;
	private String rankname;
	private String name;
	private String mobile;
	private String hiredate;
	
	@Override
	public String toString() {
		return "AdminMemberDTO [id=" + id + ", deptname=" + deptname + ", rankname=" + rankname + ", name=" + name
				+ ", mobile=" + mobile + ", hiredate=" + hiredate + "]";
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	public String getRankname() {
		return rankname;
	}
	public void setRankname(String rankname) {
		this.rankname = rankname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getHiredate() {
		return hiredate;
	}
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
	

}
