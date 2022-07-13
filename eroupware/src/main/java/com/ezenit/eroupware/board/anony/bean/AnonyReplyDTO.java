package com.ezenit.eroupware.board.anony.bean;

import java.util.Date;


public class AnonyReplyDTO {
	private int anonyNo;	//게시글번호
	private int anonyRNO;	//댓글번호
	private String content;
	private String id;
	private Date regdate;
	public int getAnonyNo() {
		return anonyNo;
	}
	public void setAnonyNo(int anonyNo) {
		this.anonyNo = anonyNo;
	}
	public int getAnonyRNO() {
		return anonyRNO;
	}
	public void setAnonyRNO(int anonyRNO) {
		this.anonyRNO = anonyRNO;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	@Override
	public String toString() {
		return "AnonyReplyDTO [anonyNo=" + anonyNo + ", anonyRNO=" + anonyRNO + ", content=" + content + ", id=" + id
				+ "]";
	}
	
	
}
