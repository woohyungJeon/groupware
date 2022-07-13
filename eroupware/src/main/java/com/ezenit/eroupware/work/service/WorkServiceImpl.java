package com.ezenit.eroupware.work.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezenit.eroupware.work.bean.WorkDTO;
import com.ezenit.eroupware.work.bean.WorkListDTO;
import com.ezenit.eroupware.work.dao.WorkDAO;

@Service
public class WorkServiceImpl implements WorkService {
	
	@Autowired
	private WorkDAO workDAO;
	
	@Override
	public int insertStartWork(WorkDTO dto) {
		return workDAO.insertStartWork(dto);
	}

	@Override
	public int workCheck(WorkDTO dto) {
		return workDAO.workCheck(dto);
	}

	@Override
	public int updateEndWork(WorkDTO dto) {
		return workDAO.updateEndWork(dto);
	}

//	@Override
//	public WorkListDTO getWorkList(WorkListDTO dto) {
//		return workDAO.getWorkList(dto);
//	}
	
	@Override
	public List<WorkListDTO> getWorkList(Map<String, Object> map) {
		return workDAO.getWorkList(map);
	}
  

}
