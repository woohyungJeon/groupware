package com.ezenit.eroupware.example.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ezenit.eroupware.example.bean.ExampleDTO;

@Repository
public class ExampleDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public int insertExample(ExampleDTO dto) {
		return sqlSession.insert("mybatis.exampleMapper.insertExample", dto);
	}
}
