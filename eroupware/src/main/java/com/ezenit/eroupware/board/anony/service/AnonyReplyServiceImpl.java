package com.ezenit.eroupware.board.anony.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezenit.eroupware.board.anony.bean.AnonyReplyDTO;
import com.ezenit.eroupware.board.anony.dao.AnonyReplyDAO;

@Service
public class AnonyReplyServiceImpl implements AnonyReplyService{

	@Autowired
	AnonyReplyDAO anonyReplyDAO;
	
	@Override
	public List<AnonyReplyDTO> readReply(int anonyNo) {
		return anonyReplyDAO.readReply(anonyNo);
	}

	@Override
	public void writeReply(AnonyReplyDTO anonyReplyDTO) {
		anonyReplyDAO.writeReply(anonyReplyDTO);
		
	}

}
