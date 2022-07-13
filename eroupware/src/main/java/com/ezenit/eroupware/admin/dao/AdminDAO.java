package com.ezenit.eroupware.admin.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ezenit.eroupware.admin.bean.AdminMemberDTO;

@Repository
public class AdminDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public List<AdminMemberDTO> getAdminMemberList() {
		return sqlSession.selectList("mybatis.adminMapper.getAdminMemberList");
	}
	
	public int memberApproval(String id) {
		return sqlSession.update("mybatis.adminMapper.memberApproval", id);
	}

}
