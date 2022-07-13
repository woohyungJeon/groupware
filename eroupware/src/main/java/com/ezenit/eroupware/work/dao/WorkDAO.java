package com.ezenit.eroupware.work.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ezenit.eroupware.work.bean.WorkDTO;
import com.ezenit.eroupware.work.bean.WorkListDTO;

@Repository
public class WorkDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public int insertStartWork(WorkDTO dto) {
		return sqlSession.insert("mybatis.workMapper.insertStartWork", dto);
	}
	
	public int workCheck(WorkDTO dto) {
		return sqlSession.selectOne("mybatis.workMapper.workCheck", dto);
	}
	public int updateEndWork(WorkDTO dto) {
		return sqlSession.update("mybatis.workMapper.updateEndWork", dto);
	}
	
//	public WorkListDTO getWorkList(WorkListDTO dto) {
//		return sqlSession.selectOne("mybatis.workMapper.getWorkList", dto);
//	}
	
	public List<WorkListDTO> getWorkList(Map<String, Object> map) {
		return sqlSession.selectList("mybatis.workMapper.getWorkList", map);
	}
	
}


