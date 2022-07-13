package com.ezenit.eroupware.contact.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ezenit.eroupware.contact.bean.ContactDTO;
import com.ezenit.eroupware.contact.bean.SearchCriteria;

@Repository
public class ContactDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	//사원 목록 조회
	public List<ContactDTO> contactMemberList(SearchCriteria scri) {
		return sqlSession.selectList("mybatis.contactMapper.contactMemberList", scri);
	}
	
	//데이터 갯수 계산하기
	public int contactListCount(SearchCriteria scri) {
		return sqlSession.selectOne("mybatis.contactMapper.contactListCount", scri);
	}
	
	//연락처 상세보기
	public ContactDTO contactDetail(String id) {
		return sqlSession.selectOne("mybatis.contactMapper.contactDetail", id);
	}

}
