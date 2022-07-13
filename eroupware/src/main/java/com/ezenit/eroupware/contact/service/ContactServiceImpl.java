package com.ezenit.eroupware.contact.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezenit.eroupware.contact.bean.ContactDTO;
import com.ezenit.eroupware.contact.bean.SearchCriteria;
import com.ezenit.eroupware.contact.dao.ContactDAO;

@Service
public class ContactServiceImpl implements ContactService{	
	//DI 의존성주입용 생성자 메소드
	@Autowired
	private ContactDAO contactDAO;

	@Override
	public List<ContactDTO> contactMemberList(SearchCriteria scri) {
		return contactDAO.contactMemberList(scri);
	}

	@Override
	public int contactListCount(SearchCriteria scri) {
		return contactDAO.contactListCount(scri);
	}

	@Override
	public ContactDTO contactDetail(String id) {
		return contactDAO.contactDetail(id);
	}	
	
	
}
