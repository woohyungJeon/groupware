package com.ezenit.eroupware.main.service;

import java.util.List;
import java.util.Map;

import com.ezenit.eroupware.board.notice.bean.NoticeDTO;
import com.ezenit.eroupware.main.bean.MainMemberDTO;
import com.ezenit.eroupware.main.bean.ReportCountDTO;
import com.ezenit.eroupware.main.bean.ReportListDTO;

public interface MainService {
	public MainMemberDTO getMemberInfo(String id);
	public int updateMemberMemo(Map<String, Object> map);
	public List<NoticeDTO> getNoticeList();
	public int memberPwdCheck(Map<String, Object> map);
	public int updateMember(MainMemberDTO dto);
	public ReportCountDTO getRequestReportCnt(String id);
	public List<ReportListDTO> getReportList(String id);
	
//	public int getRequestReportCnt1(String id);
//	public int getRequestReportCnt2(String id);
//	public int getRequestReportCnt3(String id);

}
