package com.ezenit.eroupware.member.service;

import java.util.Map;

import com.ezenit.eroupware.member.bean.MemberDTO;

public interface MemberService {
	public MemberDTO memberLoginCheck(MemberDTO dto);
	public int memberIdCheck(Map<String, Object> map);
	public int memberJoin(MemberDTO dto);	//int로 하는 이유: 서비스가 실행됐을때 1, 0
	

}
