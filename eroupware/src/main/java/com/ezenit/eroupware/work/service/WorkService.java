package com.ezenit.eroupware.work.service;

import java.util.List;
import java.util.Map;

import com.ezenit.eroupware.work.bean.WorkDTO;
import com.ezenit.eroupware.work.bean.WorkListDTO;

public interface WorkService {
	public int insertStartWork(WorkDTO dto);
	public int workCheck(WorkDTO dto);
	public int updateEndWork(WorkDTO dto);
//	public WorkListDTO getWorkList(WorkListDTO dto);
	public List<WorkListDTO> getWorkList(Map<String, Object> map);
	
	

}
