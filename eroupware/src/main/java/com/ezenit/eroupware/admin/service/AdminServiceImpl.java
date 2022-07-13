package com.ezenit.eroupware.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezenit.eroupware.admin.bean.AdminMemberDTO;
import com.ezenit.eroupware.admin.dao.AdminDAO;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminDAO adminDAO;
	
	@Override
	public List<AdminMemberDTO> getAdminMemberList() {
		return adminDAO.getAdminMemberList();
	}

	@Override
	public int memberApproval(String id) {
		return adminDAO.memberApproval(id);
	}

}
