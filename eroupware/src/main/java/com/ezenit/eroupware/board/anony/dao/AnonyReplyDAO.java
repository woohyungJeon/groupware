package com.ezenit.eroupware.board.anony.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ezenit.eroupware.board.anony.bean.AnonyReplyDTO;

@Repository ("anonyReplyDAO")
public class AnonyReplyDAO {
	
	@Autowired
	SqlSessionTemplate sqlSession;
	
	//댓글조회
	public List<AnonyReplyDTO> readReply(int anonyNo){
		return sqlSession.selectList("mybatis.anonyReplyMapper.readReply",anonyNo);
	}
	
	//댓글 작성
	public void writeReply(AnonyReplyDTO anonyReplyDTO) {
		sqlSession.insert("mybatis.anonyReplyMapper.writeReply",anonyReplyDTO);
	}

}
