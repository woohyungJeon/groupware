package com.ezenit.eroupware.main.bean;

public class ReportListDTO {

	private int seq_ew_draft;
	private String type;
	private String r_title;
	private String r_position;
	private String r_drafter;
	private String r_draftDate;

	
	@Override
	public String toString() {
		return "ReportListDTO [seq_ew_draft=" + seq_ew_draft + ", type=" + type + ", r_title=" + r_title
				+ ", r_position=" + r_position + ", r_drafter=" + r_drafter + ", r_draftDate=" + r_draftDate + "]";
	}
	public String getR_title() {
		return r_title;
	}
	public void setR_title(String r_title) {
		this.r_title = r_title;
	}
	public int getSeq_ew_draft() {
		return seq_ew_draft;
	}

	public void setSeq_ew_draft(int seq_ew_draft) {
		this.seq_ew_draft = seq_ew_draft;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getR_position() {
		return r_position;
	}

	public void setR_position(String r_position) {
		this.r_position = r_position;
	}

	public String getR_drafter() {
		return r_drafter;
	}

	public void setR_drafter(String r_drafter) {
		this.r_drafter = r_drafter;
	}

	public String getR_draftDate() {
		return r_draftDate;
	}

	public void setR_draftDate(String r_draftDate) {
		this.r_draftDate = r_draftDate;
	}

}
