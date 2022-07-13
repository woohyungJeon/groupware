package com.ezenit.eroupware.board.anony.bean;

public class AnonyDTO {
	private int anonyNo;
	private String id;
	private String title;
	private String content;
	private int hit;
	private int likeCount;
	private int likeFlag;
	private String regdate;
	

	
	@Override
	public String toString() {
		return "AnonyDTO [anonyNo=" + anonyNo + ", id=" + id + ", title=" + title + ", content=" + content + ", hit="
				+ hit + ", likeCount=" + likeCount + ", likeFlag=" + likeFlag + ", regdate=" + regdate + "]";
	}


	public int getLikeCount() {
		return likeCount;
	}


	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}



	public int getAnonyNo() {
		return anonyNo;
	}

	public void setAnonyNo(int anonyNo) {
		this.anonyNo = anonyNo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}


	public int getLikeFlag() {
		return likeFlag;
	}


	public void setLikeFlag(int likeFlag) {
		this.likeFlag = likeFlag;
	}
	
	
	
}
