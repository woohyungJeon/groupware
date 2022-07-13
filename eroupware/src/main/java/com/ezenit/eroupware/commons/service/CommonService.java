package com.ezenit.eroupware.commons.service;

import java.util.List;
import java.util.Map;

import com.ezenit.eroupware.commons.bean.DeptSelectDTO;
import com.ezenit.eroupware.commons.bean.MemberSelectDTO;

public interface CommonService {
	public List<MemberSelectDTO> getMemberSelectDTOList();
	
	public List<DeptSelectDTO> getDeptSelectDTOList();
	
	public String getFilepath(Map<String, Object> map);

} 
