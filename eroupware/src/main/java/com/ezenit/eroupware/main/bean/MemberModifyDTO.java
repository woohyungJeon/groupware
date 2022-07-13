package com.ezenit.eroupware.main.bean;

public class MemberModifyDTO {

	private String id;
	private String name;
	private String mobile1;
	private String mobile2;
	private String mobile3;
	private String addNumber;
	private String addName;
	private String addDetail;
	private int deptno;
	private int rankno;
	private String emailf;
	private String emailb;
	private String image;
	
	@Override
	public String toString() {
		return "MemberModifyDTO [id=" + id + ", name=" + name + ", mobile1=" + mobile1 + ", mobile2=" + mobile2
				+ ", mobile3=" + mobile3 + ", addNumber=" + addNumber + ", addName=" + addName + ", addDetail="
				+ addDetail + ", deptno=" + deptno + ", rankno=" + rankno + ", emailf=" + emailf + ", emailb=" + emailb
				+ ", image=" + image + "]";
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
	public String getMobile1() {
		return mobile1;
	}
	public void setMobile1(String mobile1) {
		this.mobile1 = mobile1;
	}
	public String getMobile2() {
		return mobile2;
	}
	public void setMobile2(String mobile2) {
		this.mobile2 = mobile2;
	}
	public String getMobile3() {
		return mobile3;
	}
	public void setMobile3(String mobile3) {
		this.mobile3 = mobile3;
	}
	public String getAddNumber() {
		return addNumber;
	}
	public void setAddNumber(String addNumber) {
		this.addNumber = addNumber;
	}
	public String getAddName() {
		return addName;
	}
	public void setAddName(String addName) {
		this.addName = addName;
	}
	public String getAddDetail() {
		return addDetail;
	}
	public void setAddDetail(String addDetail) {
		this.addDetail = addDetail;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public int getRankno() {
		return rankno;
	}
	public void setRankno(int rankno) {
		this.rankno = rankno;
	}
	public String getEmailf() {
		return emailf;
	}
	public void setEmailf(String emailf) {
		this.emailf = emailf;
	}
	public String getEmailb() {
		return emailb;
	}
	public void setEmailb(String emailb) {
		this.emailb = emailb;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
}
