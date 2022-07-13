package com.ezenit.eroupware.admin.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ezenit.eroupware.admin.bean.AdminMemberDTO;
import com.ezenit.eroupware.admin.service.AdminService;
import com.ezenit.eroupware.board.anony.bean.AnonyDTO;
import com.ezenit.eroupware.board.anony.bean.PageMaker;
import com.ezenit.eroupware.board.anony.bean.SearchCriteria;
import com.ezenit.eroupware.board.anony.service.AnonyService;
import com.ezenit.eroupware.board.notice.bean.NoticeDTO;
import com.ezenit.eroupware.board.notice.service.NoticeService;
import com.ezenit.eroupware.commons.controller.FileController;

@Controller
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@Autowired
	NoticeService noticeService;
	
	@Autowired
	AnonyService anonyService;
	
	@Autowired
	FileController fc;
	
	@RequestMapping("/admin/member")
	public String getAdminMemberPage(Model model) {
		
		List<AdminMemberDTO> list = adminService.getAdminMemberList();
		model.addAttribute("list", list);
		
		return "tilesAdmin/admin/member";
	}
	
	@RequestMapping(value="/admin/member/{id}", method=RequestMethod.POST)
	@ResponseBody
	public String memberApproval(@PathVariable("id") String id) {
		int result = adminService.memberApproval(id);
		JSONObject json = new JSONObject();
		json.put("result", result);
		
		return json.toString();
	}
	
	@RequestMapping("/admin/notice")
	public String getNoticePage(HttpSession session, Model model) {
		
		return "tilesAdmin/admin/notice";
	}
	

	//게시글 목록보기 & 페이징처리
	@RequestMapping(value="/admin/notice", method=RequestMethod.GET)
	public String noticeList(Model model, @ModelAttribute("scri") SearchCriteria scri) throws Exception {
		
		model.addAttribute("list",noticeService.list(scri));
		
		//게시글 페이지부분
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(scri);
		pageMaker.setTotalCount(noticeService.noticeListCount(scri));
		
		model.addAttribute("pageMaker",pageMaker);
		
		//게시글 New표시
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar =Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH,-1); //1일 보여주기
		String nowday = format.format(calendar.getTime());
		
		model.addAttribute("nowday",nowday);
		
		return "tilesAdmin/admin/noticeList";
	}
	
	//게시글 작성화면보여주기
	@RequestMapping(value="/admin/notice/write", method=RequestMethod.GET)
	public String noticeWriteForm(NoticeDTO noticeDTO,Model model) throws Exception{
		noticeDTO.setFilepath(fc.renameFile(noticeDTO.getFilepath()));
		model.addAttribute("noticeDTO",noticeDTO);
		
		return "tilesAdmin/admin/noticeWriteForm";
	}
	
	//게시글 작성하기
	@RequestMapping(value = "/admin/notice/write",method = RequestMethod.POST)
	public String noticeWrite(NoticeDTO noticeDTO, HttpServletRequest request, Model model, MultipartFile file) throws Exception{
		
		noticeDTO.setFilepath(fc.fileUpload(request, file));
		int result = noticeService.noticeWrite(noticeDTO);
		
		model.addAttribute("result",result);
		
		return "tilesAdmin/admin/noticeWrite";
	}
	
	//게시글 상세보기 (아직 댓글추가안함)
	@RequestMapping(value="/admin/notice/{seq}", method = RequestMethod.GET)
	public String noticeView(NoticeDTO noticeDTO, Model model, @PathVariable("seq") int seq) throws Exception{
		
		noticeDTO = noticeService.noticeView(seq);
		noticeDTO.setFilepath(fc.renameFile(noticeDTO.getFilepath()));

		model.addAttribute("noticeView",noticeDTO);
		
		return"tilesAdmin/admin/noticeView";
	}
	
	// 게시글 수정폼화면보여주기
	@RequestMapping(value="/admin/notice/noticeUpdateForm/{seq}", method= RequestMethod.GET)
	public String noticeUpdateForm(NoticeDTO noticeDTO, Model model) throws Exception{
			
		NoticeDTO noticeDTO_update = new NoticeDTO();
		noticeDTO_update = noticeService.noticeView(noticeDTO.getSeq());
		noticeDTO_update.setFilepath(fc.renameFile(noticeDTO_update.getFilepath()));
		
		model.addAttribute("noticeUpdate", noticeDTO_update);
			
		return "tilesAdmin/admin/noticeUpdateForm";
	}
	
	//게시글 수정하기
	@RequestMapping(value="/admin/notice/update", method = RequestMethod.POST )
	public String noticeUpdate(NoticeDTO noticeDTO, HttpServletRequest request, Model model, MultipartFile file)throws Exception {
		
		noticeDTO.setFilepath(fc.fileUpload(request, file));
		int result = noticeService.noticeUpdate(noticeDTO);
			
		model.addAttribute("result",result);	
			
		return "tilesAdmin/admin/noticeUpdate";
	}
	
	//글삭제
	@RequestMapping(value="/admin/notice/delete/{seq}")
	public String noticeDelete (@PathVariable("seq") int seq) throws Exception {
		
		noticeService.noticeDelete(seq);
		
		return "redirect:/admin/notice";
	}
	
	
	
	@RequestMapping("/admin/anony")
	public String getAnonyPage(HttpSession session, Model model) {
		
		return "tilesAdmin/admin/anony";
	}
	
	//게시글 목록보기 & 페이징처리
	@RequestMapping(value="/admin/anony",method = RequestMethod.GET )
	public String anonyList(Model model, @ModelAttribute("scri") SearchCriteria scri)throws Exception{
		
		model.addAttribute("list",anonyService.list(scri));
			
		//게시글 페이지부분
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(scri);
		pageMaker.setTotalCount(anonyService.anonyListCount(scri));
			
		model.addAttribute("pageMaker",pageMaker);
			
		//게시글 New표시
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar =Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH,-1); //1일 보여주기
		String nowday = format.format(calendar.getTime());
					
		model.addAttribute("nowday",nowday);
			
		return "tilesAdmin/admin/anonyList";	
	}
	
	//게시글 상세보기 (+댓글기능 시간되면 다시넣기..)
	@RequestMapping(value="/admin/anony/{anonyNo}", method= RequestMethod.GET)
	public String anonyView(AnonyDTO anonyDTO, Model model,@PathVariable("anonyNo") int anonyNo, HttpSession session) throws Exception{
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("anonyNo", anonyNo);
		map.put("id", session.getAttribute("session_memberId"));
				
		anonyDTO = anonyService.anonyView(map);
		
		model.addAttribute("anonyView",anonyDTO);	
			
		return "tilesAdmin/admin/anonyView";
	}
	
	//게시글 삭제
	@RequestMapping(value="/admin/anony/delete/{seq}", method= RequestMethod.GET)
	public String anonyDelete(@PathVariable("seq") int seq) throws Exception{
		
		anonyService.anonyDelete(seq);
		
		return "redirect:/admin/anony";
		
	}

}
