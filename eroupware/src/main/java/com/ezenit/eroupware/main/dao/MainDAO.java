package com.ezenit.eroupware.main.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ezenit.eroupware.board.notice.bean.NoticeDTO;
import com.ezenit.eroupware.main.bean.MainMemberDTO;
import com.ezenit.eroupware.main.bean.ReportCountDTO;
import com.ezenit.eroupware.main.bean.ReportListDTO;

@Repository
public class MainDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;

	public MainMemberDTO getMemberInfo(String id) {
		return sqlSession.selectOne("mybatis.mainMapper.getMemberInfo", id);
	}

	public int updateMemberMemo(Map<String, Object> map) {
		return sqlSession.update("mybatis.mainMapper.updateMemberMemo", map);
	}

	public List<NoticeDTO> getNoticeList() {
		return sqlSession.selectList("mybatis.mainMapper.getNoticeList");
	}

	public int memberPwdCheck(Map<String, Object> map) {
		return sqlSession.selectOne("mybatis.mainMapper.memberPwdCheck", map);
	}

	public int updateMember(MainMemberDTO dto) {
		return sqlSession.update("mybatis.mainMapper.updateMember", dto);
	}

	public ReportCountDTO getRequestReportCnt(String id) {
		return sqlSession.selectOne("mybatis.mainMapper.getRequestReportCnt", id);
	}
	
	public List<ReportListDTO> getReportList(String id) {
		return sqlSession.selectList("mybatis.mainMapper.getReportList", id);
	}

	/*
	 * public int getRequestReportCnt1(String id) { return
	 * sqlSession.selectOne("mybatis.mainMapper.getRequestReportCnt1", id); } public
	 * int getRequestReportCnt2(String id) { return
	 * sqlSession.selectOne("mybatis.mainMapper.getRequestReportCnt2", id); } public
	 * int getRequestReportCnt3(String id) { return
	 * sqlSession.selectOne("mybatis.mainMapper.getRequestReportCnt3", id); }
	 */
}
