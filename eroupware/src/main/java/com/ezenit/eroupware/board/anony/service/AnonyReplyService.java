package com.ezenit.eroupware.board.anony.service;

import java.util.List;

import com.ezenit.eroupware.board.anony.bean.AnonyReplyDTO;

public interface AnonyReplyService {
	public List<AnonyReplyDTO> readReply(int anonyNo);
	public void writeReply(AnonyReplyDTO anonyReplyDTO);
}
