package com.ezenit.eroupware.member.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezenit.eroupware.main.bean.MainMemberDTO;
import com.ezenit.eroupware.member.bean.MemberDTO;
import com.ezenit.eroupware.member.dao.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO memberDAO;


	@Override
	public MemberDTO memberLoginCheck(MemberDTO dto) {
		return memberDAO.memberLoginCheck(dto);
	}

	@Override
	public int memberIdCheck(Map<String, Object> map) {
		return memberDAO.memberIdCheck(map);
	}

	@Override
	public int memberJoin(MemberDTO dto) {		
		return memberDAO.memberJoin(dto);		
	}
	
	

}
