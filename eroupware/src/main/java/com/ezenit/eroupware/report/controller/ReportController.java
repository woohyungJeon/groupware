package com.ezenit.eroupware.report.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ezenit.eroupware.commons.controller.FileController;
import com.ezenit.eroupware.main.bean.MainMemberDTO;
import com.ezenit.eroupware.main.service.MainService;
import com.ezenit.eroupware.report.bean.CReportDTO;
import com.ezenit.eroupware.report.bean.EReportDTO;
import com.ezenit.eroupware.report.bean.VReportDTO;
import com.ezenit.eroupware.report.service.ReportService;

@Controller
public class ReportController {

	@Autowired
	ReportService reportService;
	
	@Autowired
	MainService mainService;
	
	@Autowired
	FileController fc;
	
	// report Main 화면
	@RequestMapping(value="/report")
	public String reportMain() {
		return "tiles/report/reportMain";
	}
	
	// 1-1.지출품의서 insert 폼
	@RequestMapping(value="/reportExpenseWriteForm", method=RequestMethod.GET)
	public String reportExpenseWriteForm(HttpServletRequest request, HttpSession session, ModelMap modelMap) throws Exception { 
		request.setCharacterEncoding("UTF-8");
		// 기안자 부서 직급 자동입력으로 가져오기 위해
		String id = (String) session.getAttribute("session_memberId");
		MainMemberDTO mainMemberDTO = mainService.getMemberInfo(id);
		modelMap.addAttribute("memberDTO", mainMemberDTO);
		
		return "tiles/report/reportExpenseWriteForm";
	}
	// 1-2.지출품의서 insert
	@RequestMapping(value="/reportExpenseWrite", method=RequestMethod.POST)
	public String reportExpenseWrite(EReportDTO eReportDTO, HttpServletRequest request, HttpSession session, ModelMap modelMap, MultipartFile file) {
		// 데이터처리
		String id = (String) session.getAttribute("session_memberId");
		
		String filename = fc.fileUpload(request, file);
		eReportDTO.setFilepath(filename);
		
		int result = reportService.expenseInsert(eReportDTO);
		
		modelMap.addAttribute("result", result);
		
		// view처리
		return "tiles/report/reportExpenseWrite";
	}
	// 1-3. 지출품의서 delete
	@RequestMapping(value="/reportExpenseDelete/{seq_ew_draft}", method=RequestMethod.GET)
	public String reportExpenseDelete(@PathVariable("seq_ew_draft") int seq_ew_draft,HttpServletRequest request, ModelMap modelMap) throws Exception {
		// 데이터처리
		int seq_ew_report = seq_ew_draft;
		int pg = request.getParameter("pg") == null ? 1 : Integer.parseInt(request.getParameter("pg"));
		
		int result = reportService.expenseDelete(seq_ew_draft);
		
		modelMap.addAttribute("result", result);
		modelMap.addAttribute("seq_ew_draft", seq_ew_draft);
		modelMap.addAttribute("pg", pg);
		
		// view처리
		return "tiles/report/reportExpenseDelete";
	}
	// 1-4. 지출품의서 상신함 목록보기
	@RequestMapping(value="/reportExpenseList")
	public String reportExpenseList	(HttpServletRequest request, ModelMap modelMap, HttpSession session) throws Exception {
		// 데이터처리
		String r_id = (String)session.getAttribute("session_memberId");
				
		int pg = 1;
		if (request.getParameter("pg") != null)
			pg = Integer.parseInt(request.getParameter("pg"));

		// 목록 : 1페이지당 5개씩
		int endNum = pg * 5;
		int startNum = endNum - 4;
				
		List<EReportDTO> list = reportService.expenseList(startNum, endNum, r_id);
		

		// 페이징 : 3블럭
		int totalA = reportService.expenseTotal(r_id); // 총 데이터 갯수
		int totalP = (totalA + 4) / 5; // 총 페이지 갯수

		int startPage = (pg - 1) / 3 * 3 + 1;
		int endPage = startPage + 2;

		if (endPage > totalP) endPage = totalP;
		
		// View처리
		modelMap.addAttribute("pg", pg);
		modelMap.addAttribute("list", list);
		modelMap.addAttribute("totalP", totalP);
		modelMap.addAttribute("startPage", startPage);
		modelMap.addAttribute("endPage", endPage);
		
		return "tiles/report/reportExpenseList";
	}
	// 1-5. 지출품의서 상신함 상세보기
	@RequestMapping(value="/reportExpenseView/{seq_ew_draft}", method=RequestMethod.GET)
	public String reportExpenseView(@PathVariable("seq_ew_draft") int seq_ew_draft, HttpServletRequest request, HttpSession session, ModelMap modelMap) throws Exception {
		// 데이터처리
		int seq_ew_report = seq_ew_draft;
		int pg = request.getParameter("pg") == null ? 1 : Integer.parseInt(request.getParameter("pg"));
	
		EReportDTO eReportDTO = reportService.expenseView(seq_ew_report);
		MainMemberDTO r_approver = mainService.getMemberInfo(eReportDTO.getR_approver());
		
		// 파일명 원래대로 만들기
		String filepath = eReportDTO.getFilepath();
		eReportDTO.setFilepath(fc.renameFile(filepath));
		
		modelMap.addAttribute("pg", pg);
		modelMap.addAttribute("eReportDTO", eReportDTO);
		modelMap.addAttribute("r_approver", r_approver);
		
		// view처리
		return "tiles/report/reportExpenseView";
	}
	// 1-6. 지출품의서 수신함 목록보기
	@RequestMapping(value="/reportExpenseReceptionList")
	public String reportExpenseReceptionList(HttpServletRequest request, ModelMap modelMap, HttpSession session) throws Exception {
		String r_id = (String)session.getAttribute("session_memberId");
		  
		int pg = 1;
		if (request.getParameter("pg") != null)
			pg = Integer.parseInt(request.getParameter("pg"));

		// 목록 : 1페이지당 5개씩
		int endNum = pg * 5;
		int startNum = endNum - 4;

		List<EReportDTO> list = reportService.expenseReceptionList(startNum, endNum, r_id);

		// 페이징 : 3블럭
		int totalA = reportService.expenseReceptionTotal(r_id); // 총 데이터 갯수
		int totalP = (totalA + 4) / 5; // 총 페이지 갯수

		int startPage = (pg - 1) / 3 * 3 + 1;
		int endPage = startPage + 2;

		if (endPage > totalP) endPage = totalP;
		
		// View처리
		modelMap.addAttribute("pg", pg);
		modelMap.addAttribute("list", list);
		modelMap.addAttribute("totalP", totalP);
		modelMap.addAttribute("startPage", startPage);
		modelMap.addAttribute("endPage", endPage);
		
		return "tiles/report/reportExpenseReceptionList";
	}
	// 1-7. 지출품의서 수신함 상세보기
	@RequestMapping(value="/reportExpenseReceptionView/{seq_ew_draft}", method=RequestMethod.GET)
	public String reportExpenseReceptionView(@PathVariable("seq_ew_draft") int seq_ew_draft, HttpServletRequest request, HttpSession session, ModelMap modelMap) throws Exception {
		// 데이터처리
		int seq_ew_report = seq_ew_draft;
		int pg = request.getParameter("pg") == null ? 1 : Integer.parseInt(request.getParameter("pg"));
	
		EReportDTO eReportDTO = reportService.expenseView(seq_ew_report);
		MainMemberDTO r_approver = mainService.getMemberInfo(eReportDTO.getR_approver());
		
		// 파일명 원래대로 만들기
		String filepath = eReportDTO.getFilepath();
		eReportDTO.setFilepath(fc.renameFile(filepath));
		
		modelMap.addAttribute("pg", pg);
		modelMap.addAttribute("eReportDTO", eReportDTO);
		modelMap.addAttribute("r_approver", r_approver);
		
		// view처리
		return "tiles/report/reportExpenseReceptionView";
	}
	// 1-8.지출품의서 결재완료
	@RequestMapping(value="/report/expenseApprove/{seq_ew_draft}", method=RequestMethod.POST, produces="application/text; charset=UTF-8")
	@ResponseBody
	public String expenseApprove(@PathVariable("seq_ew_draft") int seq_ew_draft, HttpServletRequest request) throws Exception {
		String flag = request.getParameter("flag");
		
 
		int result = reportService.expenseApprove(seq_ew_draft, flag);
		
		JSONObject json = new JSONObject();
		
		json.put("result", result);
		return json.toString();
	}

	
	
	
	
	
	// 2-1.업무협조요청서 insert 폼
	@RequestMapping(value="/reportCooperateWriteForm", method=RequestMethod.GET)
	public String reportCooperateWriteForm(HttpServletRequest request, HttpSession session, ModelMap modelMap) throws Exception {
		// 기안자 부서 직급 자동입력으로 가져오기 위해
		String id = (String) session.getAttribute("session_memberId");
		MainMemberDTO mainMemberDTO = mainService.getMemberInfo(id);
		modelMap.addAttribute("memberDTO", mainMemberDTO);
	
		return "tiles/report/reportCooperateWriteForm";
	}
	// 2-2.업무협조요청서 insert
	@RequestMapping(value="/reportCooperateWrite", method=RequestMethod.POST)
	public String reportCooperateWrite(CReportDTO cReportDTO, HttpServletRequest request, HttpSession session, ModelMap modelMap) {
		// 데이터처리
		String id = (String) session.getAttribute("session_memberId");
		
		int result = reportService.cooperateInsert(cReportDTO);
		
		modelMap.addAttribute("result", result);
		
		// view처리
		return "tiles/report/reportCooperateWrite";
	}
	// 2-3. 업무협조요청서 delete
	@RequestMapping(value="/reportCooperateDelete/{seq_ew_draft}", method=RequestMethod.GET)
	public String reportCooperateDelete(@PathVariable("seq_ew_draft") int seq_ew_draft,HttpServletRequest request, ModelMap modelMap) throws Exception {
		// 데이터처리
		int seq_ew_report = seq_ew_draft;
		int pg = request.getParameter("pg") == null ? 1 : Integer.parseInt(request.getParameter("pg"));
		
		int result = reportService.cooperateDelete(seq_ew_draft);
		
		modelMap.addAttribute("result", result);
		modelMap.addAttribute("seq_ew_draft", seq_ew_draft);
		modelMap.addAttribute("pg", pg);
		
		// view처리
		return "tiles/report/reportCooperateDelete";
	}
	// 2-4. 업무협조요청서 상신함 목록보기
	@RequestMapping(value="/reportCooperateList")
	public String reportCooperateList(HttpServletRequest request, ModelMap modelMap, HttpSession session) throws Exception {
		// 데이터처리
		String r_id = (String)session.getAttribute("session_memberId");
		
		int pg = 1;
		if (request.getParameter("pg") != null)
			pg = Integer.parseInt(request.getParameter("pg"));

		// 목록 : 1페이지당 5개씩
		int endNum = pg * 5;
		int startNum = endNum - 4;
		
		List<CReportDTO> list = reportService.cooperateList(startNum, endNum, r_id);

		// 페이징 : 3블럭
		int totalA = reportService.cooperateTotal(r_id); // 총 데이터 갯수
		int totalP = (totalA + 4) / 5; // 총 페이지 갯수

		int startPage = (pg - 1) / 3 * 3 + 1;
		int endPage = startPage + 2;

		if (endPage > totalP) endPage = totalP;
			
		// View처리
		modelMap.addAttribute("pg", pg);
		modelMap.addAttribute("list", list);
		modelMap.addAttribute("totalP", totalP);
		modelMap.addAttribute("startPage", startPage);
		modelMap.addAttribute("endPage", endPage);
			
		return "tiles/report/reportCooperateList";
	}
	// 2-5. 업무협조요청서 상신함 상세보기
	@RequestMapping(value="/reportCooperateView/{seq_ew_draft}", method=RequestMethod.GET)
	public String reportCooperateView(@PathVariable("seq_ew_draft") int seq_ew_draft, HttpServletRequest request, HttpSession session, ModelMap modelMap) throws Exception {
		// 데이터처리
		int seq_ew_report = seq_ew_draft;
		int pg = request.getParameter("pg") == null ? 1 : Integer.parseInt(request.getParameter("pg"));
		
		CReportDTO cReportDTO = reportService.cooperateView(seq_ew_report);
		MainMemberDTO r_approver = mainService.getMemberInfo(cReportDTO.getR_approver());

		modelMap.addAttribute("pg", pg);
		modelMap.addAttribute("cReportDTO", cReportDTO);
		modelMap.addAttribute("r_approver", r_approver);
		
		// view처리
		return "tiles/report/reportCooperateView";
	}
	// 2-6. 업무협조요청서 수신함 목록보기
	@RequestMapping(value="/reportCooperateReceptionList")
	public String reportCooperateReceptionList(HttpServletRequest request, ModelMap modelMap, HttpSession session) throws Exception {
		String r_id = (String)session.getAttribute("session_memberId");
		  
		int pg = 1;
		if (request.getParameter("pg") != null)
			pg = Integer.parseInt(request.getParameter("pg"));

		// 목록 : 1페이지당 5개씩
		int endNum = pg * 5;
		int startNum = endNum - 4;

		List<CReportDTO> list = reportService.cooperateReceptionList(startNum, endNum, r_id);

		// 페이징 : 3블럭
		int totalA = reportService.cooperateReceptionTotal(r_id); // 총 데이터 갯수
		int totalP = (totalA + 4) / 5; // 총 페이지 갯수

		int startPage = (pg - 1) / 3 * 3 + 1;
		int endPage = startPage + 2;

		if (endPage > totalP) endPage = totalP;
		
		// View처리
		modelMap.addAttribute("pg", pg);
		modelMap.addAttribute("list", list);
		modelMap.addAttribute("totalP", totalP);
		modelMap.addAttribute("startPage", startPage);
		modelMap.addAttribute("endPage", endPage);
		
		return "tiles/report/reportCooperateReceptionList";
	}
	// 2-7. 업무협조요청서 수신함 상세보기
	@RequestMapping(value="/reportCooperateReceptionView/{seq_ew_draft}", method=RequestMethod.GET)
	public String reportCooperateReceptionView(@PathVariable("seq_ew_draft") int seq_ew_draft, HttpServletRequest request, HttpSession session, ModelMap modelMap) throws Exception {
		// 데이터처리
		int seq_ew_report = seq_ew_draft;
		int pg = request.getParameter("pg") == null ? 1 : Integer.parseInt(request.getParameter("pg"));
	
		CReportDTO cReportDTO = reportService.cooperateView(seq_ew_report);
		MainMemberDTO r_approver = mainService.getMemberInfo(cReportDTO.getR_approver());
		
		modelMap.addAttribute("pg", pg);
		modelMap.addAttribute("cReportDTO", cReportDTO);
		modelMap.addAttribute("r_approver", r_approver);
		
		// view처리
		return "tiles/report/reportCooperateReceptionView";
	}
	// 2-8. 업무협조요청서 결재완료
	@RequestMapping(value="/report/cooperateApprove/{seq_ew_draft}", method=RequestMethod.POST, produces="application/text; charset=UTF-8")
	@ResponseBody
	public String cooperateApprove(@PathVariable("seq_ew_draft") int seq_ew_draft, HttpServletRequest request) throws Exception {
		String flag = request.getParameter("flag");
		
		int result = reportService.cooperateApprove(seq_ew_draft, flag);
		
		JSONObject json = new JSONObject();
		
		json.put("result", result);
		return json.toString();
	}

	
	
	
	
	
	// 3-1.휴가신청서 insert 폼
	@RequestMapping(value="/reportVacationWriteForm", method=RequestMethod.GET)
	public String reportVacationWriteForm(HttpServletRequest request, HttpSession session, ModelMap modelMap) throws Exception {
		// 기안자 부서 직급 자동입력으로 가져오기 위해
		String id = (String) session.getAttribute("session_memberId");
		MainMemberDTO mainMemberDTO = mainService.getMemberInfo(id);
		modelMap.addAttribute("memberDTO", mainMemberDTO);
		
		return "tiles/report/reportVacationWriteForm";
	}
	// 3-2.휴가신청서 insert
	@RequestMapping(value="/reportVacationWrite", method=RequestMethod.POST)
	public String reportVacationWrite(VReportDTO vReportDTO, HttpServletRequest request, HttpSession session, ModelMap modelMap) {
		// 데이터처리
		String id = (String) session.getAttribute("session_memberId");
		
		int result = reportService.vacationInsert(vReportDTO);
		
		modelMap.addAttribute("result", result);
		
		// view처리
		return "tiles/report/reportVacationWrite";
	}
	
	// 3-3. 휴가신청서 delete
	@RequestMapping(value="/reportVacationDelete/{seq_ew_draft}", method=RequestMethod.GET)
	public String reportVacationDelete(@PathVariable("seq_ew_draft") int seq_ew_draft,HttpServletRequest request, ModelMap modelMap) throws Exception {
		// 데이터처리
		int seq_ew_report = seq_ew_draft;
		int pg = request.getParameter("pg") == null ? 1 : Integer.parseInt(request.getParameter("pg"));
		
		int result = reportService.vacationDelete(seq_ew_draft);
		
		modelMap.addAttribute("result", result);
		modelMap.addAttribute("seq_ew_draft", seq_ew_draft);
		modelMap.addAttribute("pg", pg);
		
		// view처리
		return "tiles/report/reportVacationDelete";
	}
	// 3-4. 휴가신청서 상신함 목록보기
	@RequestMapping(value="/reportVacationList")
	public String reportVacationList(HttpServletRequest request, ModelMap modelMap, HttpSession session) throws Exception {
		// 데이터 처리
		String r_id = (String)session.getAttribute("session_memberId");
		
		int pg = 1;
		if (request.getParameter("pg") != null)
			pg = Integer.parseInt(request.getParameter("pg"));

		// 목록 : 1페이지당 5개씩
		int endNum = pg * 5;
		int startNum = endNum - 4;

		List<VReportDTO> list = reportService.vacationList(startNum, endNum, r_id);

		// 페이징 : 3블럭
		int totalA = reportService.vacationTotal(r_id); // 총 데이터 갯수
		int totalP = (totalA + 4) / 5; // 총 페이지 갯수
		
		int startPage = (pg - 1) / 3 * 3 + 1;
		int endPage = startPage + 2;

		if (endPage > totalP) endPage = totalP;

		// View 처리
		modelMap.addAttribute("pg", pg);
		modelMap.addAttribute("list", list);
		modelMap.addAttribute("totalP", totalP);
		modelMap.addAttribute("startPage", startPage);
		modelMap.addAttribute("endPage", endPage);

		return "tiles/report/reportVacationList";
	}
	// 3-5. 휴가신청서 상신함 상세보기
	@RequestMapping(value="/reportVacationView/{seq_ew_draft}", method=RequestMethod.GET)
	public String reportVacationView(@PathVariable("seq_ew_draft") int seq_ew_draft, HttpServletRequest request, HttpSession session, ModelMap modelMap) throws Exception {
		// 데이터처리
		int seq_ew_report = seq_ew_draft;
		int pg = request.getParameter("pg") == null ? 1 : Integer.parseInt(request.getParameter("pg"));
			
		VReportDTO vReportDTO = reportService.vacationView(seq_ew_report);
		MainMemberDTO r_approver = mainService.getMemberInfo(vReportDTO.getR_approver());
		
		modelMap.addAttribute("pg", pg);
		modelMap.addAttribute("vReportDTO", vReportDTO);
		modelMap.addAttribute("r_approver", r_approver);
		
		// view처리
		return "tiles/report/reportVacationView";
	}
	// 3-6. 휴가신청서 수신함 목록보기
	@RequestMapping(value="/reportVacationReceptionList")
	public String reportVacationReceptionList(HttpServletRequest request, ModelMap modelMap, HttpSession session) throws Exception {
		String r_id = (String)session.getAttribute("session_memberId");
		  
		int pg = 1;
		if (request.getParameter("pg") != null)
			pg = Integer.parseInt(request.getParameter("pg"));

		// 목록 : 1페이지당 5개씩
		int endNum = pg * 5;
		int startNum = endNum - 4;

		List<VReportDTO> list = reportService.vacationReceptionList(startNum, endNum, r_id);

		// 페이징 : 3블럭
		int totalA = reportService.vacationReceptionTotal(r_id); // 총 데이터 갯수
		int totalP = (totalA + 4) / 5; // 총 페이지 갯수

		int startPage = (pg - 1) / 3 * 3 + 1;
		int endPage = startPage + 2;

		if (endPage > totalP) endPage = totalP;
		
		// View처리
		modelMap.addAttribute("pg", pg);
		modelMap.addAttribute("list", list);
		modelMap.addAttribute("totalP", totalP);
		modelMap.addAttribute("startPage", startPage);
		modelMap.addAttribute("endPage", endPage);
		
		return "tiles/report/reportVacationReceptionList";
	}
	// 3-7. 휴가신청서 수신함 상세보기
	@RequestMapping(value="/reportVacationReceptionView/{seq_ew_draft}", method=RequestMethod.GET)
	public String reportVacationReceptionView(@PathVariable("seq_ew_draft") int seq_ew_draft, HttpServletRequest request, HttpSession session, ModelMap modelMap) throws Exception {
		// 데이터처리
		int seq_ew_report = seq_ew_draft;
		int pg = request.getParameter("pg") == null ? 1 : Integer.parseInt(request.getParameter("pg"));
	
		VReportDTO vReportDTO = reportService.vacationView(seq_ew_report);
		MainMemberDTO r_approver = mainService.getMemberInfo(vReportDTO.getR_approver());
		
		modelMap.addAttribute("pg", pg);
		modelMap.addAttribute("vReportDTO", vReportDTO);
		modelMap.addAttribute("r_approver", r_approver);
		
		// view처리
		return "tiles/report/reportVacationReceptionView";
	}
	// 3-8. 업무협조요청서 결재완료
	@RequestMapping(value="/report/vacationApprove/{seq_ew_draft}", method=RequestMethod.POST, produces="application/text; charset=UTF-8")
	@ResponseBody
	public String vacationApprove(@PathVariable("seq_ew_draft") int seq_ew_draft, HttpServletRequest request) throws Exception {
		String flag = request.getParameter("flag");
		
		int result = reportService.vacationApprove(seq_ew_draft, flag);
		
		JSONObject json = new JSONObject();
		
		json.put("result", result);
		return json.toString();
	}
}
