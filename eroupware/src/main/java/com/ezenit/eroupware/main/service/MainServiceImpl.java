package com.ezenit.eroupware.main.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezenit.eroupware.board.notice.bean.NoticeDTO;
import com.ezenit.eroupware.main.bean.MainMemberDTO;
import com.ezenit.eroupware.main.bean.ReportCountDTO;
import com.ezenit.eroupware.main.bean.ReportListDTO;
import com.ezenit.eroupware.main.dao.MainDAO;

@Service
public class MainServiceImpl implements MainService {

	@Autowired
	private MainDAO mainDAO;

	@Override
	public MainMemberDTO getMemberInfo(String id) {
		return mainDAO.getMemberInfo(id);
	}

	@Override
	public int updateMemberMemo(Map<String, Object> map) {
		return mainDAO.updateMemberMemo(map);
	}

	@Override
	public List<NoticeDTO> getNoticeList() {
		return mainDAO.getNoticeList();
	}

	@Override
	public int memberPwdCheck(Map<String, Object> map) {
		return mainDAO.memberPwdCheck(map);
	}

	@Override
	public int updateMember(MainMemberDTO dto) {
		return mainDAO.updateMember(dto);
	}

	@Override
	public ReportCountDTO getRequestReportCnt(String id) {
		return mainDAO.getRequestReportCnt(id);
	}

	@Override
	public List<ReportListDTO> getReportList(String id) {
		return mainDAO.getReportList(id);
	}

//	@Override
//	public int getRequestReportCnt1(String id) {
//		return mainDAO.getRequestReportCnt1(id);
//	}
//
//	@Override
//	public int getRequestReportCnt2(String id) {
//		return mainDAO.getRequestReportCnt2(id);
//	}
//
//	@Override
//	public int getRequestReportCnt3(String id) {
//		return mainDAO.getRequestReportCnt3(id);
//	}

}
