package com.ezenit.eroupware.board.notice.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ezenit.eroupware.board.anony.bean.SearchCriteria;
import com.ezenit.eroupware.board.notice.bean.NoticeDTO;


@Repository("noticeDAO")
public class NoticeDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	//게시글 목록 & 페이징처리
//	public List<NoticeDTO> getNoticeList(int startNum, int endNum){
//		Map<String,Integer> map = new HashMap<String,Integer>();
//		map.put("startNum", startNum);
//		map.put("endNum", endNum);
//		return sqlSession.selectList("mybatis.noticeMapper.getNoticeList", map);
//	}
	
	//게시글 목록 & 페이징처리
	public List<NoticeDTO> list(SearchCriteria scri){
		return sqlSession.selectList("mybatis.noticeMapper.noticeListPage",scri);
	}
	
	// 총 데이터 갯수
	public int noticeListCount(SearchCriteria scri) {
		return sqlSession.selectOne("mybatis.noticeMapper.noticeListCount",scri);
	}
	
	// 조회수 증가
	public int updateHit(int seq) {
		return sqlSession.update("mybatis.noticeMapper.updateHit", seq);
	}
	
	// 상세보기 
	public NoticeDTO noticeView(int seq) { 
		return sqlSession.selectOne("mybatis.noticeMapper.noticeView", seq); }

	// 글저장 
	public int noticeWrite(NoticeDTO noticeDTO) { 
		return sqlSession.insert("mybatis.noticeMapper.noticeWrite", noticeDTO);
	}
	 
	//글수정
	public int noticeUpdate(NoticeDTO noticeDTO) {
		return sqlSession.update("mybatis.noticeMapper.noticeUpdate", noticeDTO);
	}

	// 글삭제 
	public int noticeDelete(int seq) { 
		return sqlSession.delete("mybatis.noticeMapper.noticeDelete", seq); 
			
	}	
}
