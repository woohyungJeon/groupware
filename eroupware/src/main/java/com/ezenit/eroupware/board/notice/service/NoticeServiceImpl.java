package com.ezenit.eroupware.board.notice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezenit.eroupware.board.anony.bean.SearchCriteria;
import com.ezenit.eroupware.board.notice.bean.NoticeDTO;
import com.ezenit.eroupware.board.notice.dao.NoticeDAO;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService{
	@Autowired
	private NoticeDAO noticeDAO;
	
//	@Override
//	public List<NoticeDTO> getNoticeList(int startNum, int endNum) {
//		return noticeDAO.getNoticeList(startNum, endNum);
//	}
//
//	@Override
//	public int getTotalNotice() {
//		return noticeDAO.getTotalNotice();
//	}
	
	@Override
	public List<NoticeDTO> list(SearchCriteria scri) {
		return noticeDAO.list(scri);
	}

	@Override
	public int noticeListCount(SearchCriteria scri) {
		return noticeDAO.noticeListCount(scri);
	}
	
	@Override
	public int updateHit(int seq) {
		return noticeDAO.updateHit(seq);
	}
	
	@Override
	public NoticeDTO noticeView(int seq) {
		return noticeDAO.noticeView(seq);
	}

	@Override
	public int noticeWrite(NoticeDTO noticeDTO) {
		return noticeDAO.noticeWrite(noticeDTO);
	}

	@Override
	public int noticeUpdate(NoticeDTO noticeDTO) {
		return noticeDAO.noticeUpdate(noticeDTO);
	}

	@Override
	public int noticeDelete(int seq) {
		return noticeDAO.noticeDelete(seq);
	}
	
}
