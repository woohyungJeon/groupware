package com.ezenit.eroupware.report.bean;

public class CReportDTO {
	
	private int seq_ew_draft;	  // 문서고유번호
	private String r_id;		  // 기안자 아이디
	private String r_drafter;     // 기안자 이름
    private String r_draftDate;   // 기안날짜
    private String r_department;  // 부서
    private String r_position;    // 직급
    private String r_title;       // 제목
    private String r_content;     // 내용
    private String r_approver;    // 결재권자
    private String r_status; 	  // 결재상태
    private String r_aso; 		  // 비고
	
    @Override
	public String toString() {
		return "CReportDTO [seq_ew_draft=" + seq_ew_draft + ", r_id=" + r_id + ", r_drafter=" + r_drafter
				+ ", r_draftDate=" + r_draftDate + ", r_department=" + r_department + ", r_position=" + r_position
				+ ", r_title=" + r_title + ", r_content=" + r_content + ", r_approver=" + r_approver + ", r_status="
				+ r_status + ", r_aso=" + r_aso + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	public int getSeq_ew_draft() {
		return seq_ew_draft;
	}

	public void setSeq_ew_draft(int seq_ew_draft) {
		this.seq_ew_draft = seq_ew_draft;
	}

	public String getR_id() {
		return r_id;
	}

	public void setR_id(String r_id) {
		this.r_id = r_id;
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

	public String getR_department() {
		return r_department;
	}

	public void setR_department(String r_department) {
		this.r_department = r_department;
	}

	public String getR_position() {
		return r_position;
	}

	public void setR_position(String r_position) {
		this.r_position = r_position;
	}

	public String getR_title() {
		return r_title;
	}

	public void setR_title(String r_title) {
		this.r_title = r_title;
	}

	public String getR_content() {
		return r_content;
	}

	public void setR_content(String r_content) {
		this.r_content = r_content;
	}

	public String getR_approver() {
		return r_approver;
	}

	public void setR_approver(String r_approver) {
		this.r_approver = r_approver;
	}

	public String getR_status() {
		return r_status;
	}

	public void setR_status(String r_status) {
		this.r_status = r_status;
	}

	public String getR_aso() {
		return r_aso;
	}

	public void setR_aso(String r_aso) {
		this.r_aso = r_aso;
	}
}
