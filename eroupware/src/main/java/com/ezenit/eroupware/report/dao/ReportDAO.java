package com.ezenit.eroupware.report.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ezenit.eroupware.report.bean.CReportDTO;
import com.ezenit.eroupware.report.bean.EReportDTO;
import com.ezenit.eroupware.report.bean.VReportDTO;

@Repository("reportDAO")
public class ReportDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	// 지출품의서 insert
	public int expenseInsert(EReportDTO eReportDTO) {
		return sqlSession.insert("mybatis.reportMapper.expenseInsert", eReportDTO);}
	// 지출품의서 delete
	public int expenseDelete(int seq_ew_draft) {
		return sqlSession.delete("mybatis.reportMapper.expenseDelete", seq_ew_draft);}
	// 지출품의서 상신함 목록보기
	public List<EReportDTO> expenseList(int startNum, int endNum, String r_id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		map.put("r_id", r_id);
		return sqlSession.selectList("mybatis.reportMapper.expenseList", map);}
	// 지출품의서 상신함 총 데이터 갯수
	public int expenseTotal(String r_id) {
		return sqlSession.selectOne("mybatis.reportMapper.expenseTotal", r_id);}
	// 지출품의서 상신함 상세보기
	public EReportDTO expenseView(int seq_ew_draft) { 
		return sqlSession.selectOne("mybatis.reportMapper.expenseView", seq_ew_draft);}
	// 지출품의서 수신함 목록보기
	public List<EReportDTO> expenseReceptionList(int startNum, int endNum, String r_id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		map.put("r_id", r_id);
		return sqlSession.selectList("mybatis.reportMapper.expenseReceptionList", map);}
	// 지출품의서 수신함 총 데이터 갯수
	public int expenseReceptionTotal(String r_id) {
		return sqlSession.selectOne("mybatis.reportMapper.expenseReceptionTotal", r_id);}
	// 지출품의서 수신함 상세보기
	public EReportDTO expenseReceptionView(int seq_ew_draft) { 
		return sqlSession.selectOne("mybatis.reportMapper.expenseReceptionView", seq_ew_draft);}
	// 지출품의서 결재하기 ajax
	public int expenseApprove(int seq_ew_draft, String flag) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("seq_ew_draft", seq_ew_draft);
		map.put("flag", flag);
		return sqlSession.update("mybatis.reportMapper.expenseApprove", map);}
	
		
	
	
	
		
	// 업무협조요청서 insert
	public int cooperateInsert(CReportDTO cReportDTO) {
		return sqlSession.insert("mybatis.reportMapper.cooperateInsert", cReportDTO);}
	// 업무협조요청서 delete
	public int cooperateDelete(int seq_ew_draft) {
		return sqlSession.delete("mybatis.reportMapper.cooperateDelete", seq_ew_draft);}
	// 업무협조요청서 상신함 목록보기
	public List<CReportDTO> cooperateList(int startNum, int endNum, String r_id) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		map.put("r_id", r_id);
		return sqlSession.selectList("mybatis.reportMapper.cooperateList", map);}
	// 업무협조요청서 상신함 총 데이터 갯수
	public int cooperateTotal(String r_id) {
		return sqlSession.selectOne("mybatis.reportMapper.cooperateTotal", r_id);}
	// 업무협조요청서 상세보기
	public CReportDTO cooperateView(int seq_ew_draft) { 
		return sqlSession.selectOne("mybatis.reportMapper.cooperateView", seq_ew_draft);}
	// 업무협조요청서 수신함 목록보기
	public List<CReportDTO> cooperateReceptionList(int startNum, int endNum, String r_id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		map.put("r_id", r_id);
		return sqlSession.selectList("mybatis.reportMapper.cooperateReceptionList", map);}
	// 업무협조요청서 수신함 총 데이터 갯수
	public int cooperateReceptionTotal(String r_id) {
		return sqlSession.selectOne("mybatis.reportMapper.cooperateReceptionTotal", r_id);}
	// 업무협조요청서 수신함 상세보기
	public CReportDTO cooperateReceptionView(int seq_ew_draft) { 
		return sqlSession.selectOne("mybatis.reportMapper.cooperateReceptionView", seq_ew_draft);}
	// 업무협조요청서 결재하기 ajax
	public int cooperateApprove(int seq_ew_draft, String flag) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("seq_ew_draft", seq_ew_draft);
		map.put("flag", flag);
		return sqlSession.update("mybatis.reportMapper.cooperateApprove", map);}
	
	
	
	
	
	
	
	
	
	
	
	// 휴가신청서 insert
	public int vacationInsert(VReportDTO vReportDTO) {
		return sqlSession.insert("mybatis.reportMapper.vacationInsert", vReportDTO);}
	// 휴가신청서 delete
	public int vacationDelete(int seq_ew_draft) {
		return sqlSession.delete("mybatis.reportMapper.vacationDelete", seq_ew_draft);}
	// 휴가신청서 상신함 목록보기
	public List<VReportDTO> vacationList(int startNum, int endNum, String r_id) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		map.put("r_id", r_id);
		return sqlSession.selectList("mybatis.reportMapper.vacationList", map);}
	// 휴가신청서 상신함 총 데이터 갯수
	public int vacationTotal(String r_id) {
		return sqlSession.selectOne("mybatis.reportMapper.vacationTotal", r_id);}
	// 휴가신청서 상세보기
	public VReportDTO vacationView(int seq_ew_draft) { 
		return sqlSession.selectOne("mybatis.reportMapper.vacationView", seq_ew_draft);}
	// 휴가신청서 수신함 목록보기
	public List<VReportDTO> vacationReceptionList(int startNum, int endNum, String r_id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		map.put("r_id", r_id);
		return sqlSession.selectList("mybatis.reportMapper.vacationReceptionList", map);}
	// 휴가신청서 수신함 총 데이터 갯수
	public int vacationReceptionTotal(String r_id) {
		return sqlSession.selectOne("mybatis.reportMapper.vacationReceptionTotal", r_id);}
	// 휴가신청서 수신함 상세보기
	public VReportDTO vacationReceptionView(int seq_ew_draft) { 
		return sqlSession.selectOne("mybatis.reportMapper.vacationReceptionView", seq_ew_draft);}
	// 휴가신청서 결재하기 ajax
	public int vacationApprove(int seq_ew_draft,String flag) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("seq_ew_draft", seq_ew_draft);
		map.put("flag", flag);
		return sqlSession.update("mybatis.reportMapper.vacationApprove", map);}
}
