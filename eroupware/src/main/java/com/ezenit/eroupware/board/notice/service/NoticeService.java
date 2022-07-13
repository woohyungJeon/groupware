package com.ezenit.eroupware.board.notice.service;

import java.util.List;

import com.ezenit.eroupware.board.anony.bean.SearchCriteria;
import com.ezenit.eroupware.board.notice.bean.NoticeDTO;

public interface NoticeService {
	//public List<NoticeDTO> getNoticeList(int startNum, int endNum);
	//public int getTotalNotice();
	public List<NoticeDTO> list(SearchCriteria scri);
	public int noticeListCount(SearchCriteria scri);
	public int updateHit(int seq);
	public NoticeDTO noticeView(int seq);
	public int noticeWrite(NoticeDTO noticeDTO);
	public int noticeUpdate(NoticeDTO noticeDTO);
	public int noticeDelete(int seq);
}
