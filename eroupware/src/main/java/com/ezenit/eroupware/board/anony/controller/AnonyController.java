package com.ezenit.eroupware.board.anony.controller;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ezenit.eroupware.board.anony.bean.AnonyDTO;
import com.ezenit.eroupware.board.anony.bean.AnonyReplyDTO;
import com.ezenit.eroupware.board.anony.bean.PageMaker;
import com.ezenit.eroupware.board.anony.bean.SearchCriteria;
import com.ezenit.eroupware.board.anony.service.AnonyReplyService;
import com.ezenit.eroupware.board.anony.service.AnonyService;

@Controller
public class AnonyController {
	
	private static final Logger logger = LoggerFactory.getLogger(AnonyController.class);
	
	@Autowired
	AnonyService anonyService;
	
	@Autowired
	AnonyReplyService anonyReplyService;
	
	//게시글 목록보기 & 페이징처리
	@RequestMapping(value="/anony",method = RequestMethod.GET )
	public String list(Model model, @ModelAttribute("scri") SearchCriteria scri)throws Exception{
		logger.info("anonyList");
		
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
			
		return "tiles/board/anony/anonyList";	
	}
	
	//게시글 상세보기 (+댓글기능 시간되면 다시넣기..)
	@RequestMapping(value="/anony/{anonyNo}", method= RequestMethod.GET)
	public String anonyView(AnonyDTO anonyDTO, Model model,@PathVariable("anonyNo") int anonyNo, HttpSession session) throws Exception{
		logger.info("anonyView");
		
		//조회수
		anonyService.updateHit(anonyNo);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("anonyNo", anonyNo);
		map.put("id", session.getAttribute("session_memberId"));
				
		anonyDTO =anonyService.anonyView(map);
		
		model.addAttribute("anonyView",anonyDTO);	
		
//		//댓글
//		List<AnonyReplyDTO> anonyReplyList = anonyReplyService.readReply(anonyDTO.getAnonyNo());
//		model.addAttribute("anonyReplyList",anonyReplyList);
			
		return "tiles/board/anony/anonyView";
	}
	
	//게시글 작성화면 보여주기
	@RequestMapping(value = "/anony/writeForm",method = RequestMethod.GET)
	public String anonyWriteView() throws Exception {
		
		return "tiles/board/anony/anonyWriteForm";
	}
	
	
	// 게시판 글 작성
	@RequestMapping(value = "/anony/write", method = RequestMethod.POST)
	public String anonyWrite(AnonyDTO anonyDTO, Model model) throws Exception{
		logger.info("anonywrite");
			
		int result = anonyService.anonyWrite(anonyDTO);
			
		model.addAttribute("result",result);
			
			
		return "tiles/board/anony/anonyWrite";
	}
	
	@RequestMapping(value="/anony/updateLike", method=RequestMethod.POST, produces="application/text; charset=UTF-8")
	@ResponseBody
	public String updateCardSort(HttpServletRequest request, @RequestParam Map<String, Object> params, HttpSession session) throws Exception {
		//String[] positions = request.getParameterValues("positions[]");
		String id = (String)session.getAttribute("session_memberId");
		int anonyNo = Integer.parseInt((String) params.get("anonyNo"));
		int likeFlag = Integer.parseInt((String) params.get("likeFlag"));
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("anonyNo", anonyNo);
		
		int result = 0;
		// 좋아요 취소
		if(likeFlag > 0) {
			result = anonyService.deleteLike(map);
		} 
		// 좋아요 하기
		else {
			result = anonyService.insertLike(map);
		}
		
		JSONObject json = new JSONObject();
		json.put("result", result);
		
		return json.toString();
	}
	
	
	
	
	//게시글 수정
	@RequestMapping(value="/anony/anonyUpdate", method= RequestMethod.POST)
	public String anonyUpdate(AnonyDTO anonyDTO, Model model) throws Exception{
		logger.info("anonyUpdate");
		
		anonyService.anonyUpdate(anonyDTO);
		
		return "redirect:/anony/anonyList";
	}
	
	//게시글 삭제
	@RequestMapping(value="/anony/anonyDelete/{anonyNo}", method= RequestMethod.GET)
	public String anonyDelete(AnonyDTO anonyDTO) throws Exception{
		logger.info("anonyDelete");
		
		anonyService.anonyDelete(anonyDTO.getAnonyNo());
		
		return "redirect:/anony";
		
	}
	
	//댓글 작성
	@RequestMapping(value="/anony/reply/{anonyNo}", method=RequestMethod.POST)
	public String anonyReplyWrite(AnonyReplyDTO anonyReplyDTO, SearchCriteria scri, RedirectAttributes rttr)throws Exception{
		System.out.println("왜안나와");
		logger.info("anonyReplyWrite");
		
		anonyReplyService.writeReply(anonyReplyDTO);
		
		rttr.addAttribute("anonyNo",anonyReplyDTO.getAnonyNo());
		//rttr.addAttribute("page",scri.getPage());
		//rttr.addAttribute("perPageNum",scri.getPerPageNum());
		//rttr.addAttribute("searchType",scri.getSearchType());
		//rttr.addAttribute("keyword",scri.getKeyword());
		
		return "redirect:/anony/anonyView";
	}
}