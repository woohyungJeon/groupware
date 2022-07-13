package com.ezenit.eroupware.commons.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ezenit.eroupware.commons.bean.DeptSelectDTO;
import com.ezenit.eroupware.commons.bean.MemberSelectDTO;

@Repository
public class CommonDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	 
	public List<DeptSelectDTO> getDeptSelectDTOList() {
		return sqlSession.selectList("mybatis.commonMapper.getDeptSelectDTOList");
	}
	
	public List<MemberSelectDTO> getMemberSelectDTOList() {
		return sqlSession.selectList("mybatis.commonMapper.getMemberSelectDTOList");
	}
	
	public String getFilepath(Map<String, Object> map) {
		return sqlSession.selectOne("mybatis.commonMapper.getFilepath", map);
	}
	
}
