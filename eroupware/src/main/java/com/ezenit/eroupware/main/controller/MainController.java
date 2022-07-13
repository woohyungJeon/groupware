package com.ezenit.eroupware.main.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ezenit.eroupware.commons.controller.FileController;
import com.ezenit.eroupware.main.bean.MainMemberDTO;
import com.ezenit.eroupware.main.bean.MemberModifyDTO;
import com.ezenit.eroupware.main.bean.ReportCountDTO;
import com.ezenit.eroupware.main.bean.ReportListDTO;
import com.ezenit.eroupware.main.service.MainService;
import com.ezenit.eroupware.project.bean.ProjectListDTO;
import com.ezenit.eroupware.project.service.ProjectService;

@Controller
public class MainController {
	
	@Autowired
	MainService mainService;
	
	@Autowired
	ProjectService projectService;
	
	@Autowired
	FileController fc;
	
	@RequestMapping("/main")
	public String getMainPage(HttpSession session, Model model) {
		String id = (String)session.getAttribute("session_memberId");
		List<ProjectListDTO> projectList = projectService.getProjectList(id);
		ReportCountDTO reportCountDTO = mainService.getRequestReportCnt(id);
		List<ReportListDTO> reportList = mainService.getReportList(id);
		
		if(projectList.size() > 8) {
			for(int i=8; i<projectList.size(); i++) {
				projectList.remove(i);
			}
		}
		
		model.addAttribute("noticeList", mainService.getNoticeList());
		model.addAttribute("projectList", projectList);
		model.addAttribute("reportList", reportList);
		model.addAttribute("reportCountDTO", reportCountDTO);
		
		return "tiles/main/main";
	}
	
	@RequestMapping(value="/main/memberInfo", method=RequestMethod.POST, produces="application/text; charset=UTF-8")
	@ResponseBody
	public String getMemberInfo(HttpServletRequest request, HttpSession session) throws Exception {
		
		String id = (String) session.getAttribute("session_memberId");
		
		MainMemberDTO mainMemberDTO = mainService.getMemberInfo(id);
		
		JSONObject json = new JSONObject();
		
		json.put("id", mainMemberDTO.getId());
		json.put("name", mainMemberDTO.getName());
		json.put("deptname", mainMemberDTO.getDeptname());
		json.put("rankname", mainMemberDTO.getRankname());
		json.put("email", mainMemberDTO.getEmail());
		json.put("image", mainMemberDTO.getImage());
		json.put("qmemo", mainMemberDTO.getQmemo());
		
		return json.toString();
	}
	
	@RequestMapping(value="/main/updateMemberMemo", method=RequestMethod.POST, produces="application/text; charset=UTF-8")
	@ResponseBody
	public String updateMemberMemo(HttpServletRequest request, HttpSession session) throws Exception {
		
		String id = (String) session.getAttribute("session_memberId");
		
		String qmemo = request.getParameter("qmemo");
		Map<String, Object> map = new HashMap<>();
		map.put("qmemo", qmemo);
		map.put("id", id);
		
		int result = mainService.updateMemberMemo(map);
		
		JSONObject json = new JSONObject();
		
		json.put("result", result);
		
		return json.toString();
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public String getCheckPasswordPage() {

		return "tiles/main/passwordCheck";
	}
	
	@RequestMapping(value="/member/{id}", method=RequestMethod.GET)
	public String getMemberModifyPage(@PathVariable("id") String id, HttpSession session, ModelMap modelMap) {
		
		MainMemberDTO memberDTO = mainService.getMemberInfo(id);
		modelMap.addAttribute("memberDTO", memberDTO);
		
		MemberModifyDTO memberModifyDTO = new MemberModifyDTO();
		
		memberModifyDTO.setId(memberDTO.getId());
		memberModifyDTO.setName(memberDTO.getName());
		memberModifyDTO.setAddNumber(memberDTO.getAddnumber());
		memberModifyDTO.setAddName(memberDTO.getAddname());
		memberModifyDTO.setAddDetail(memberDTO.getAdddetail());
		memberModifyDTO.setDeptno(memberDTO.getDeptno());
		memberModifyDTO.setRankno(memberDTO.getRankno());
		memberModifyDTO.setImage(memberDTO.getImage());
		
		
		memberModifyDTO.setMobile1(memberDTO.getMobile().substring(0, 3));
		memberModifyDTO.setMobile2(memberDTO.getMobile().substring(3, 7));
		memberModifyDTO.setMobile3(memberDTO.getMobile().substring(7, 11));
		
		String email[] = memberDTO.getEmail().split("@");
		memberModifyDTO.setEmailf(email[0]);
		memberModifyDTO.setEmailb(email[1]);
		
		modelMap.addAttribute("memberModifyDTO", memberModifyDTO);
		return "tiles/main/modify";
	}
	
	@RequestMapping(value="/member/{id}", method=RequestMethod.POST)
	public String memberModify(@PathVariable("id") String id, HttpServletRequest request, MainMemberDTO memberDTO, MultipartFile file) {
		
		memberDTO.setImage(fc.fileUpload(request, file));
		
		mainService.updateMember(memberDTO);
		
		return "redirect:/main";
	}
	
	@RequestMapping(value="/memberPwdCheck", method=RequestMethod.POST, produces="application/text; charset=UTF-8")
	@ResponseBody
	public String memberPwdCheck(@RequestParam("id") String id, @RequestParam("pwd") String pwd) throws Exception {
		
		Map<String, Object> map = new HashMap<>();
		map.put("id", id);
		map.put("pwd", pwd);
		
		int result = mainService.memberPwdCheck(map);
		
		JSONObject json = new JSONObject();
		
		json.put("result", result);
		
		return json.toString();
	}
	
	
}
