package com.ezenit.eroupware.contact.bean;

public class ContactDTO {	
	private String id;
	private String name;	
	private String mobile;
	private String addnumber;
	private String addname;
	private int deptno;
	private String deptname;
	private int rankno;
	private String rankname;
	private String email;
	private String image;
	private String birth;
	private String hiredate;
	
	@Override
	public String toString() {
		return "NoticeDTO [name=" + name + ", mobile=" + mobile + ", addnumber=" + addnumber + ", addname=" + addname
				+ ", department=" +  ", position="  + ", email=" + email + ", image=" + image
				+ ", birth=" + birth + ", hiredate=" + hiredate + "]";
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
	public String getHiredate() {
		return hiredate;
	}
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}	
	
	

}
