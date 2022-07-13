package com.ezenit.eroupware.board.anony.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ezenit.eroupware.board.anony.bean.AnonyDTO;
import com.ezenit.eroupware.board.anony.bean.Criteria;
import com.ezenit.eroupware.board.anony.bean.SearchCriteria;

@Repository("anonyDAO")
public class AnonyDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	
	//게시글작성
	public int anonyWrite(AnonyDTO anonyDTO) {
		return sqlSession.insert("mybatis.anonyMapper.anonyWrite", anonyDTO);
	}
	
	//게시글 목록조회
	public List<AnonyDTO> list(SearchCriteria scri) {
		return sqlSession.selectList("mybatis.anonyMapper.anonyListPage",scri);
	}
	
	//게시물 총 갯수
	public int anonyListCount(SearchCriteria scri) {
		return sqlSession.selectOne("mybatis.anonyMapper.anonyListCount",scri);
	}
	
	//게시글 상세보기
	public AnonyDTO anonyView(Map<String, Object> map) {
		return sqlSession.selectOne("mybatis.anonyMapper.anonyView", map);
	}
	
	public int insertLike(Map<String, Object> map) {
		return sqlSession.insert("mybatis.anonyMapper.insertLike", map);
	}

	public int deleteLike(Map<String, Object> map) {
		return sqlSession.delete("mybatis.anonyMapper.deleteLike", map);
	}
	
	//게시글 수정
	public void anonyUpdate(AnonyDTO anonyDTO) {
		sqlSession.update("mybatis.anonyMapper.anonyUpdate",anonyDTO);
	}
	
	//게시글 삭제
	public void anonyDelete(int anonyNo) {
		sqlSession.delete("mybatis.anonyMapper.anonyDelete",anonyNo);
	}
	
	//조회수 증가
	public int updateHit(int anonyNo) {
		return sqlSession.update("mybatis.anonyMapper.updateHit",anonyNo);
	}
	
}
