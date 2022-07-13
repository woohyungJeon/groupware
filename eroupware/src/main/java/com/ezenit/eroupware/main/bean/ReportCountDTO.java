package com.ezenit.eroupware.main.bean;

public class ReportCountDTO {
	
	private int cnt_n; 	// 결재 요청 문서 개수
	private int cnt_y;		// 결재 완료 문서 개수
	private int cnt_f; 		// 결재 반려 문서 개수
	private int cnt_r; 		// 결재 수신 문서 개수
	
	@Override
	public String toString() {
		return "ReportCountDTO [cnt_n=" + cnt_n + ", cnt_y=" + cnt_y + ", cnt_f=" + cnt_f + ", cnt_r=" + cnt_r + "]";
	}
	
	public int getCnt_n() {
		return cnt_n;
	}
	public void setCnt_n(int cnt_n) {
		this.cnt_n = cnt_n;
	}
	public int getCnt_y() {
		return cnt_y;
	}
	public void setCnt_y(int cnt_y) {
		this.cnt_y = cnt_y;
	}
	public int getCnt_f() {
		return cnt_f;
	}
	public void setCnt_f(int cnt_f) {
		this.cnt_f = cnt_f;
	}
	public int getCnt_r() {
		return cnt_r;
	}
	public void setCnt_r(int cnt_r) {
		this.cnt_r = cnt_r;
	}

}
