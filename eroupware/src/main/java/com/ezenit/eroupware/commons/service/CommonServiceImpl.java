package com.ezenit.eroupware.commons.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezenit.eroupware.commons.bean.DeptSelectDTO;
import com.ezenit.eroupware.commons.bean.MemberSelectDTO;
import com.ezenit.eroupware.commons.dao.CommonDAO;

@Service
public class CommonServiceImpl implements CommonService {

	@Autowired
	private CommonDAO commonDAO;


	@Override
	public List<MemberSelectDTO> getMemberSelectDTOList() {
		return commonDAO.getMemberSelectDTOList();
	}

	@Override
	public List<DeptSelectDTO> getDeptSelectDTOList() {
		return commonDAO.getDeptSelectDTOList();
	}

	@Override
	public String getFilepath(Map<String, Object> map) {
		return commonDAO.getFilepath(map);
	}


}
