package com.ezenit.eroupware.board.anony.service;

import java.util.List;
import java.util.Map;

import com.ezenit.eroupware.board.anony.bean.AnonyDTO;
import com.ezenit.eroupware.board.anony.bean.Criteria;
import com.ezenit.eroupware.board.anony.bean.SearchCriteria;

public interface AnonyService {
	public int anonyWrite(AnonyDTO anonyDTO);
	public AnonyDTO anonyView(Map<String, Object> map);	
	public void anonyUpdate(AnonyDTO anonyDTO);
	public void anonyDelete(int anonyNo);
	public List<AnonyDTO> list(SearchCriteria scri);
	public int anonyListCount(SearchCriteria scri);
	public int updateHit(int anonyNo);
	public int insertLike(Map<String, Object> map);
	public int deleteLike(Map<String, Object> map);
}
