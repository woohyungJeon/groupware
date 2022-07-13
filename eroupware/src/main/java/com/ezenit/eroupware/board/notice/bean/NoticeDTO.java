package com.ezenit.eroupware.board.notice.bean;

public class NoticeDTO {
	private int seq;				// 공지사항번호
	private String title;			//제목
	private String content;			//내용
	private String filepath;		//첨부파일
	private int hit;				//조회수
	private String logtime;			//작성일
	
	@Override
	public String toString() {
		return "NoticeDTO [seq=" + seq + ", title=" + title + ", content=" + content + ", filepath=" + filepath
				+ ", hit=" + hit + ", logtime=" + logtime + "]";
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
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
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getLogtime() {
		return logtime;
	}
	public void setLogtime(String logtime) {
		this.logtime = logtime;
	}	
}
