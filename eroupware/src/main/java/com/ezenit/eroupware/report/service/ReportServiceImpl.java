package com.ezenit.eroupware.report.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezenit.eroupware.report.bean.CReportDTO;
import com.ezenit.eroupware.report.bean.EReportDTO;
import com.ezenit.eroupware.report.bean.VReportDTO;
import com.ezenit.eroupware.report.dao.ReportDAO;

@Service("reportService")
public class ReportServiceImpl implements ReportService {
	@Autowired
	private ReportDAO reportDAO;

	// 지출품의서 insert
	@Override
	public int expenseInsert(EReportDTO eReportDTO) {
		return reportDAO.expenseInsert(eReportDTO);}
	// 지출품의서 delete
	@Override
	public int expenseDelete(int seq_ew_draft) {
		return reportDAO.expenseDelete(seq_ew_draft);}
	// 지출품의서 상신함 목록보기
	@Override
	public List<EReportDTO> expenseList(int startNum, int endNum, String r_id) {
		return reportDAO.expenseList(startNum, endNum, r_id);}
	// 지출품의서 상신함 총 데이터 갯수
	@Override
	public int expenseTotal(String r_id) {
		return reportDAO.expenseTotal(r_id);}
	// 지출품의서 상신함 상세보기
	@Override
	public EReportDTO expenseView(int seq_ew_draft) {
		return reportDAO.expenseView(seq_ew_draft);}
	// 지출품의서 수신함 목록보기
	@Override
	public List<EReportDTO> expenseReceptionList(int startNum, int endNum, String r_id) {
		return reportDAO.expenseReceptionList(startNum, endNum, r_id);}
	// 지출품의서 수신함 총 데이터 갯수
	@Override
	public int expenseReceptionTotal(String r_id) {
		return reportDAO.expenseReceptionTotal(r_id);}
	// 지출품의서 수신함 상세보기
	@Override 
	public EReportDTO expenseReceptionView(int seq_ew_draft) {
		return reportDAO.expenseReceptionView(seq_ew_draft);}
	// 지출품의서 결재하기 ajax
	@Override
	public int expenseApprove(int seq_ew_draft, String flag) {
		return reportDAO.expenseApprove(seq_ew_draft, flag);}
	 
	
	
	
	
	// 업무협조요청서 insert
	@Override
	public int cooperateInsert(CReportDTO cReportDTO) {
		return reportDAO.cooperateInsert(cReportDTO);}
	// 업무협조요청서 delete
	@Override
	public int cooperateDelete(int seq_ew_draft) {
		return reportDAO.cooperateDelete(seq_ew_draft);}
	// 업무협조요청서 상신함 목록보기
	@Override
	public List<CReportDTO> cooperateList(int startNum, int endNum, String r_id) {
		return reportDAO.cooperateList(startNum, endNum, r_id);}
	// 업무협조요청서 상신함 총 데이터 갯수
	@Override
	public int cooperateTotal(String r_id) {
		return reportDAO.cooperateTotal(r_id);}
	// 업무협조요청서 상신함 상세보기
	@Override
	public CReportDTO cooperateView(int seq_ew_draft) {
		return reportDAO.cooperateView(seq_ew_draft);}
	// 업무협조요청서 수신함 목록보기
	@Override
	public List<CReportDTO> cooperateReceptionList(int startNum, int endNum, String r_id) {
		return reportDAO.cooperateReceptionList(startNum, endNum, r_id);}
	// 업무협조요청서 수신함 총 데이터 갯수
	@Override
	public int cooperateReceptionTotal(String r_id) {
		return reportDAO.cooperateReceptionTotal(r_id);}
	// 업무협조요청서 수신함 상세보기
	@Override
	public CReportDTO cooperateReceptionView(int seq_ew_draft) {
		return reportDAO.cooperateReceptionView(seq_ew_draft);}
	// 업무협조요청서 결재하기 ajax
	@Override
	public int cooperateApprove(int seq_ew_draft, String flag) {
		return reportDAO.cooperateApprove(seq_ew_draft, flag);}


	
	
	
	
	// 휴가신청서 insert
	@Override
	public int vacationInsert(VReportDTO vReportDTO) {
		return reportDAO.vacationInsert(vReportDTO);}
	// 휴가신청서 delete
	@Override
	public int vacationDelete(int seq_ew_draft) {
		return reportDAO.vacationDelete(seq_ew_draft);}
	// 휴가신청서 상신함 목록보기
	@Override
	public List<VReportDTO> vacationList(int startNum, int endNum, String r_id) {
		return reportDAO.vacationList(startNum, endNum, r_id);}
	// 휴가신청서 상신함 총 데이터 갯수
	@Override
	public int vacationTotal(String r_id) {
		return reportDAO.vacationTotal(r_id);}
	// 휴가신청서 상신함 상세보기
	@Override
	public VReportDTO vacationView(int seq_ew_draft) {
		return reportDAO.vacationView(seq_ew_draft);}
	// 휴가신청서 수신함 목록보기
	@Override
	public List<VReportDTO> vacationReceptionList(int startNum, int endNum, String r_id) {
		return reportDAO.vacationReceptionList(startNum, endNum, r_id);}
	// 휴가신청서 수신함 총 데이터 갯수
	@Override
	public int vacationReceptionTotal(String r_id) {
		return reportDAO.vacationReceptionTotal(r_id);}
	// 휴가신청서 수신함 상세보기
	@Override
	public VReportDTO vacationReceptionView(int seq_ew_draft) {
		return reportDAO.vacationReceptionView(seq_ew_draft);}
	// 휴가신청서 결재하기 ajax
	@Override
	public int vacationApprove(int seq_ew_draft, String flag) {
		return reportDAO.vacationApprove(seq_ew_draft, flag);}
}