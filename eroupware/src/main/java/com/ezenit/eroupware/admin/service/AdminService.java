package com.ezenit.eroupware.admin.service;

import java.util.List;

import com.ezenit.eroupware.admin.bean.AdminMemberDTO;

public interface AdminService {
	public List<AdminMemberDTO> getAdminMemberList();
	public int memberApproval(String id);

}
