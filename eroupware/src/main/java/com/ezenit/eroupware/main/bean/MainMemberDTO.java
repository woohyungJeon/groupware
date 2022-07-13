package com.ezenit.eroupware.main.bean;

public class MainMemberDTO {
	
	private String id;
	private String name;
	private String pwd;
	private String mobile;
	private String addnumber;
	private String addname;
	private String adddetail;
	private int deptno;
	private String deptname;
	private int rankno;
	private String rankname;
	private String email;
	private String image;
	private String birth;
	private String gender;
	private String hiredate;
	private String qmemo;
	
	@Override
	public String toString() {
		return "MainMemberDTO [id=" + id + ", name=" + name + ", pwd=" + pwd + ", mobile=" + mobile + ", addnumber="
				+ addnumber + ", addname=" + addname + ", adddetail=" + adddetail + ", deptno=" + deptno + ", deptname="
				+ deptname + ", rankno=" + rankno + ", rankname=" + rankname + ", email=" + email + ", image=" + image
				+ ", birth=" + birth + ", gender=" + gender + ", hiredate=" + hiredate + ", qmemo=" + qmemo + "]";
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
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAddnumber() {
		return addnumber;
	}
	public void setAddnumber(String addnumber) {
		this.addnumber = addnumber;
	}
	public String getAddname() {
		return addname;
	}
	public void setAddname(String addname) {
		this.addname = addname;
	}
	public String getAdddetail() {
		return adddetail;
	}
	public void setAdddetail(String adddetail) {
		this.adddetail = adddetail;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getHiredate() {
		return hiredate;
	}
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
	public String getQmemo() {
		return qmemo;
	}
	public void setQmemo(String qmemo) {
		this.qmemo = qmemo;
	}
	
	

}
