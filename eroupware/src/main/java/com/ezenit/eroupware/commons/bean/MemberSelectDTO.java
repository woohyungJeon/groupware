package com.ezenit.eroupware.commons.bean;

public class MemberSelectDTO {
	
	private int deptno;
	private String id;
	private String name;
	private int rankno;
	private String rankname;
	
	@Override
	public String toString() {
		return "MemberSelectDTO [deptno=" + deptno + ", id=" + id + ", name=" + name + ", rankno=" + rankno
				+ ", rankname=" + rankname + "]";
	}
	
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
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
	public int getRankno() {
		return rankno;
	}
	public void setRankno(int rankno) {
		this.rankno = rankno;
	}
	public String getRankname() {
		return rankname;
	}
	public void setRankname(String rankname) {
		this.rankname = rankname;
	}
	
	
	
}
