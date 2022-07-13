package com.ezenit.eroupware.report.service;

import java.util.List;

import com.ezenit.eroupware.report.bean.CReportDTO;
import com.ezenit.eroupware.report.bean.EReportDTO;
import com.ezenit.eroupware.report.bean.VReportDTO;

public interface ReportService {
	// 지출품의서 insert
	public int expenseInsert(EReportDTO eReportDTO);
	// 지출품의서 delete
	public int expenseDelete(int seq_ew_draft);
	// 지출품의서 상신함 목록보기
	public List<EReportDTO> expenseList(int startNum, int endNum, String r_id);
	// 지출품의서 상신함 총 데이터 갯수
	public int expenseTotal(String r_id);
	// 지출품의서 상신함 상세보기
	public EReportDTO expenseView(int seq_ew_draft);
	// 지출품의서 수신함 목록보기
	public List<EReportDTO> expenseReceptionList(int startNum, int endNum, String r_id);
	// 지출품의서 수신함 총 데이터 갯수
	public int expenseReceptionTotal(String r_id);
	// 지출품의서 수신함 상세보기
	public EReportDTO expenseReceptionView(int seq_ew_draft);
	// 지출품의서 결재완료하기 ajax
	public int expenseApprove(int seq_ew_draft, String flag);
	
	   
	
	// 업무협조요청서 insert
	public int cooperateInsert(CReportDTO cReportDTO);
	// 업무협조요청서 delete
	public int cooperateDelete(int seq_ew_draft);
	// 업무협조요청서 상신함 목록보기
	public List<CReportDTO> cooperateList(int startNum, int endNum, String r_id);
	// 업무협조요청서 상신함 총 데이터 갯수
	public int cooperateTotal(String r_id);
	// 업무협조요청서 상세보기
	public CReportDTO cooperateView(int seq_ew_draft);
	// 업무협조요청서 수신함 목록보기
	public List<CReportDTO> cooperateReceptionList(int startNum, int endNum, String r_id);
	// 업무협조요청서 수신함 총 데이터 갯수
	public int cooperateReceptionTotal(String r_id);
	// 업무협조요청서 수신함 상세보기
	public CReportDTO cooperateReceptionView(int seq_ew_draft);
	// 업무협조요청서 결재완료하기 ajax
	public int cooperateApprove(int seq_ew_draft, String flag);
	
	
	// 휴가신청서 insert
	public int vacationInsert(VReportDTO vReportDTO);
	// 휴가신청서 delete
	public int vacationDelete(int seq_ew_draft);
	// 휴가신청서 상신함 목록보기
	public List<VReportDTO> vacationList(int startNum, int endNum, String r_id);
	// 휴가신청서 상신함 총 데이터 갯수
	public int vacationTotal(String r_id);
	// 휴가신청서 상신함 상세보기
	public VReportDTO vacationView(int seq_ew_draft);
	// 휴가신청서 수신함 목록보기
	public List<VReportDTO> vacationReceptionList(int startNum, int endNum, String r_id);
	// 휴가신청서 수신함 총 데이터 갯수
	public int vacationReceptionTotal(String r_id);
	// 휴가신청서 수신함 상세보기
	public VReportDTO vacationReceptionView(int seq_ew_draft);
	// 휴가신청서 결재완료하기 ajax
	public int vacationApprove(int seq_ew_draft, String flag);
}
