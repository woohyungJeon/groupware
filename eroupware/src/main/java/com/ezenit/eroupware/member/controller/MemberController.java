package com.ezenit.eroupware.member.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ezenit.eroupware.member.bean.MemberDTO;
import com.ezenit.eroupware.member.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	// 로그인 페이지
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String getLoginPage() {
		return "tilesLogin/member/loginForm";
	}
	
	// 로그인
	@RequestMapping(value="/login", method=RequestMethod.POST, produces="application/text; charset=UTF-8")
	@ResponseBody
	public String doLogin(MemberDTO dto, HttpServletRequest request) throws Exception {
		MemberDTO dto_result = memberService.memberLoginCheck(dto);
		JSONObject json = new JSONObject();
		
		if(dto_result != null) {
			if(dto_result.getEnabled().equals("Y") || dto_result.getEnabled() == "Y") {
				// 기존 멤버아이디 세션값 있는 경우 삭제 후 무효화
				if(request.getSession().getAttribute("session_memberId") != null) {
					request.getSession().removeAttribute("session_memberId");
					request.getSession().invalidate(); // 기존 세션 무효화
				}
				request.getSession().setMaxInactiveInterval(3600); // 세션 유지시간 60분
				request.getSession().setAttribute("session_memberId", dto.getId()); // 멤버 아이디값 세션저장
			}
			json.put("enabled", dto_result.getEnabled());
			json.put("authority", dto_result.getAuthority());
			
		} else {
			json.put("enabled", "F");
		}
		
		return json.toString();
	}
	
	// 로그아웃
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String memberLogout(HttpServletRequest request, HttpSession session) throws Exception {
		request.getSession().removeAttribute("session_memberId");
		return "redirect:/login";
	}
	
	// 회원가입 페이지
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String getJoinPage() {
		return "tilesLogin/member/joinForm";
	}
	
	//ID_Check
	@RequestMapping(value="/idCheck", method=RequestMethod.POST, produces="application/text; charset=UTF-8")
	@ResponseBody
	public String idCheck(HttpServletRequest request) throws Exception {
		String id = request.getParameter("id");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		
		int result = memberService.memberIdCheck(map);
		
		JSONObject json = new JSONObject();
		json.put("result", result);		
		return  json.toString();
	}
	
	
	//회원가입
	@RequestMapping(value="/join", method = RequestMethod.POST, produces="application/text; charset=UTF-8")
	public String memberJoin(MemberDTO dto,  HttpServletRequest request) {
		memberService.memberJoin(dto);
		return "redirect:/login";
	};
	
	
}
