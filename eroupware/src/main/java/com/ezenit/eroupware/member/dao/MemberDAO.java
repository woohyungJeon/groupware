package com.ezenit.eroupware.member.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ezenit.eroupware.member.bean.MemberDTO;

@Repository
public class MemberDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;

	// 멤버 로그인
	public MemberDTO memberLoginCheck(MemberDTO dto) {
		return sqlSession.selectOne("mybatis.memberMapper.memberLoginCheck", dto);
	}

	// 멤버 아이디 중복 체그 쿼리
	public int memberIdCheck(Map<String, Object> map) {
		return sqlSession.selectOne("mybatis.memberMapper.memberIdCheck", map);
	}

	// 멤버 인서트 쿼리(회원가입)
	public int memberJoin(MemberDTO dto) {
		return sqlSession.insert("mybatis.memberMapper.memberJoin", dto);
	}

}
