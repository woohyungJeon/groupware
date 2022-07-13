package com.ezenit.eroupware.board.notice.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.ezenit.eroupware.board.anony.bean.PageMaker;
import com.ezenit.eroupware.board.anony.bean.SearchCriteria;
import com.ezenit.eroupware.board.notice.bean.NoticeDTO;
import com.ezenit.eroupware.board.notice.service.NoticeService;
import com.ezenit.eroupware.commons.controller.FileController;

@Controller
public class NoticeController {

	private static final Logger logger = LoggerFactory.getLogger(NoticeController.class);
	
	@Autowired
	NoticeService noticeService;
	
	@Autowired
	FileController fc;

	//게시글 목록보기 & 페이징처리
	@RequestMapping(value="/notice", method =RequestMethod.GET)
	public String list(Model model, @ModelAttribute("scri") SearchCriteria scri) throws Exception {
		logger.info("noticeList");
		
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
		
		return "tiles/board/notice/noticeList";
	}
	
	//게시글 상세보기 (아직 댓글추가안함)
	@RequestMapping(value="notice/{seq}", method = RequestMethod.GET)
	public String noticeView(NoticeDTO noticeDTO, Model model, @PathVariable("seq") int seq) throws Exception{
		logger.info("noitceView");
		
		//조회수
		noticeService.updateHit(seq);
		
		noticeDTO = noticeService.noticeView(seq);
		noticeDTO.setFilepath(fc.renameFile(noticeDTO.getFilepath()));

		model.addAttribute("noticeView",noticeDTO);
		
		return"tiles/board/notice/noticeView";
	}
	
	//게시글 작성화면보여주기
	@RequestMapping(value="/notice/writeForm", method=RequestMethod.GET)
	public String noticeWriteForm(NoticeDTO noticeDTO,Model model) throws Exception{
		noticeDTO.setFilepath(fc.renameFile(noticeDTO.getFilepath()));
		model.addAttribute("noticeDTO",noticeDTO);
		
		return "tiles/board/notice/noticeWriteForm";
	}
	
	//게시글 작성하기
	@RequestMapping(value = "notice/write",method = RequestMethod.POST)
	public String noticeWrite(NoticeDTO noticeDTO, HttpServletRequest request, Model model, MultipartFile file) throws Exception{
		logger.info("noticeWrite");
		
		noticeDTO.setFilepath(fc.fileUpload(request, file));
		int result = noticeService.noticeWrite(noticeDTO);
		
		model.addAttribute("result",result);
		
		return "tiles/board/notice/noticeWrite";
	}
	
	// 게시글 수정폼화면보여주기
	@RequestMapping(value="/notice/noticeUpdateForm/{seq}", method= RequestMethod.GET)
	public String noticeUpdateForm(NoticeDTO noticeDTO, Model model) throws Exception{
		logger.info("noticeUpdateForm");
			
		NoticeDTO noticeDTO_update = new NoticeDTO();
		noticeDTO_update = noticeService.noticeView(noticeDTO.getSeq());
		noticeDTO_update.setFilepath(fc.renameFile(noticeDTO_update.getFilepath()));
		
		model.addAttribute("noticeUpdate", noticeDTO_update);
			
		return "tiles/board/notice/noticeUpdateForm";
	}
		
	//게시글 수정하기
	@RequestMapping(value="/notice/update", method = RequestMethod.POST )
	public String noticeUpdate(NoticeDTO noticeDTO, HttpServletRequest request, Model model, MultipartFile file)throws Exception {
		logger.info("noticeUpdate");
		
		noticeDTO.setFilepath(fc.fileUpload(request, file));
		int result = noticeService.noticeUpdate(noticeDTO);
			
		model.addAttribute("result",result);	
			
		return "tiles/board/notice/noticeUpdate";
	}
	
	//글삭제
	@RequestMapping(value="/notice/delete/{seq}")
	public String noticeDelete (NoticeDTO noticeDTO) throws Exception {
		logger.info("noticeDelete");
		
		noticeService.noticeDelete(noticeDTO.getSeq());
		
		return "redirect:/notice";
	}	
	
}