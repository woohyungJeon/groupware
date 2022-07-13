package com.ezenit.eroupware.board.anony.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezenit.eroupware.board.anony.bean.AnonyDTO;
import com.ezenit.eroupware.board.anony.bean.Criteria;
import com.ezenit.eroupware.board.anony.bean.SearchCriteria;
import com.ezenit.eroupware.board.anony.dao.AnonyDAO;

@Service("anonyService")
public class AnonyServiceImpl implements AnonyService{

	@Autowired
	private AnonyDAO anonyDAO;
	
	@Override
	public int anonyWrite(AnonyDTO anonyDTO) {
		return anonyDAO.anonyWrite(anonyDTO);
	}
	
	@Override
	public AnonyDTO anonyView(Map<String, Object> map) {
		return anonyDAO.anonyView(map);
	}

	@Override
	public void anonyUpdate(AnonyDTO anonyDTO) {
		anonyDAO.anonyUpdate(anonyDTO);
		
	}

	@Override
	public void anonyDelete(int anonyNo) {
		anonyDAO.anonyDelete(anonyNo);
		
	}

	@Override
	public List<AnonyDTO> list(SearchCriteria scri) {
		return anonyDAO.list(scri);
	}

	@Override
	public int anonyListCount(SearchCriteria scri) {
		// TODO Auto-generated method stub
		return anonyDAO.anonyListCount(scri);
	}

	@Override
	public int updateHit(int anonyNo) {
		return anonyDAO.updateHit(anonyNo);
	}

	@Override
	public int insertLike(Map<String, Object> map) {
		return anonyDAO.insertLike(map);
	}

	@Override
	public int deleteLike(Map<String, Object> map) {
		return anonyDAO.deleteLike(map);
	}	
	

}
