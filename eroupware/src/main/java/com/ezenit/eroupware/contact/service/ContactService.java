package com.ezenit.eroupware.contact.service;

import java.util.List;

import com.ezenit.eroupware.contact.bean.ContactDTO;
import com.ezenit.eroupware.contact.bean.SearchCriteria;

public interface ContactService {
	//사원 목록 조회 & 페이징 처리
	public List<ContactDTO> contactMemberList(SearchCriteria scri);
	public int contactListCount(SearchCriteria scri);
	public ContactDTO contactDetail(String id);
	

}
