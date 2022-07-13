package com.ezenit.eroupware.project.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ezenit.eroupware.commons.controller.FileController;
import com.ezenit.eroupware.project.bean.PmemberDTO;
import com.ezenit.eroupware.project.bean.ProjectDTO;
import com.ezenit.eroupware.project.bean.ProjectListDTO;
import com.ezenit.eroupware.project.bean.ProjectMemberListDTO;
import com.ezenit.eroupware.project.bean.ProjectTaskCntDTO;
import com.ezenit.eroupware.project.bean.TaskDTO;
import com.ezenit.eroupware.project.bean.TaskListDTO;
import com.ezenit.eroupware.project.bean.TaskStatusCntDTO;
import com.ezenit.eroupware.project.service.ProjectService;

@Controller
public class ProjectController {
	
	@Autowired
	ProjectService projectService;
	
	@Autowired
	FileController fc;

	// 프로젝트 메인 페이지, 참여중인 프로젝트 리스트 보여주기
	@RequestMapping("/project")
	public String getProjectMainPage(HttpSession session, ModelMap modelMap) {
		
		String id = (String)session.getAttribute("session_memberId");
		List<ProjectListDTO> list = projectService.getProjectList(id);
		
		modelMap.addAttribute("projectList", list);
		
		return "tiles/project/project";
	}
	
	// 프로젝트 생성하기
	@RequestMapping(value="/project", method=RequestMethod.POST)
	public String insertProject(ProjectDTO projectDTO, PmemberDTO pmemberDTO) {
		
		String[] colors = {"#A285A9", "#A3B7BC", "#7172A3", "#864E68", "#854481", "#715697", "#927898"};
		
		Random rand = new Random();
		
		projectDTO.setColor(colors[rand.nextInt(7)]);
		
		projectService.insertProject(projectDTO);
		
		pmemberDTO.setProjectNo(projectDTO.getProjectNo());
		projectService.insertProjectMembers(pmemberDTO); 
		
		return "redirect:/project";
	}
	
	// 프로젝트 상세 페이지
	@RequestMapping(value="/project/{projectNo}", method=RequestMethod.GET)
	public String getProjectDetail(@PathVariable("projectNo") int projectNo, ModelMap modelMap) {
		
		// 프로젝트 정보 
		ProjectListDTO projectInfoDTO = projectService.getProjectInfo(projectNo);
		
		// 프로젝트에 속한 태스크 상태별 카운트
		ProjectTaskCntDTO projectTaskCntDTO = projectService.getProjectTaskCnt(projectNo);
		
		// 프로젝트에 속한 멤버 목록
		List<ProjectMemberListDTO> projectMemberList = projectService.getProjectMemberList(projectNo);
		for(int i=0; i<projectMemberList.size(); i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			TaskStatusCntDTO tscdto = new TaskStatusCntDTO();
			map.put("projectNo", projectNo);
			map.put("id", projectMemberList.get(i).getId());
			tscdto = projectService.getTaskStatusCntByMember(map);
			projectMemberList.get(i).setTaskTotalCnt(tscdto.getTotalCnt());
			projectMemberList.get(i).setTaskCompleteCnt(tscdto.getCompleteCnt());
			
			if(tscdto.getTotalCnt() > 0) {
				
				int percent = Math.round((tscdto.getCompleteCnt()*100 / tscdto.getTotalCnt()));
				projectMemberList.get(i).setTaskPercent(percent);
			}
			//System.out.println(projectMemberList.get(i).toString());
		}
		
		// 프로젝트에 속한 태스크 목록
		List<TaskListDTO> taskList = projectService.getTaskList(projectNo);
		
		
		// 원본 파일명으로 만들기
		for(int i=0; i<taskList.size(); i++) {
			String filepath = taskList.get(i).getFilepath();
			taskList.get(i).setFilepath(fc.renameFile(filepath));
		}
		
		modelMap.addAttribute("projectInfoDTO", projectInfoDTO);
		modelMap.addAttribute("taskList", taskList);
		modelMap.addAttribute("projectTaskCntDTO", projectTaskCntDTO);
		modelMap.addAttribute("projectMemberList", projectMemberList);
		
		return "tiles/project/projectDetail";
	}
	
	// 태스크 생성하기 및 파일 업로드
	@RequestMapping(value="/project/{projectNo}/task", method=RequestMethod.POST)
	public String insertProject(@PathVariable("projectNo") int projectNo, HttpServletRequest request, TaskDTO taskDTO, MultipartFile file) {
		  
		String filename = fc.fileUpload(request, file);
		taskDTO.setFilepath(filename);
		projectService.insertTask(taskDTO);
		
		return "redirect:/project/"+projectNo;
	}
	
	@RequestMapping(value="/project/updateTaskStatus", method=RequestMethod.POST, produces="application/text; charset=UTF-8")
	@ResponseBody
	public String updateTaskStatus(@RequestParam("taskNo") int taskNo, @RequestParam("status") String status) throws Exception {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("taskNo", taskNo);
		map.put("status", status);

		int result = projectService.updateTaskStatus(map);
		
		JSONObject json = new JSONObject();
		
		json.put("result", result);
		return json.toString();
		
	}
	
	@RequestMapping(value="/project/deleteTask", method=RequestMethod.GET)
	public String deleteTask(@RequestParam("taskNo") int taskNo, @RequestParam("projectNo") int projectNo) throws Exception {
		
		projectService.deleteTask(taskNo);
		
		return "redirect:/project/"+projectNo;
	}
	
	@RequestMapping(value="/project/update", method=RequestMethod.POST)
	public String projectUpdate(HttpServletRequest request, ProjectDTO projectDTO, @RequestParam("projectNo") int projectNo) throws Exception {
		
		String[] idArrNew = request.getParameterValues("idArrNew");
		
		
		projectService.updateProject(projectDTO);
		
		if(idArrNew != null) {
			PmemberDTO pmemberDTO = new PmemberDTO();
			pmemberDTO.setIdArr(idArrNew);
			pmemberDTO.setProjectNo(projectNo);
			projectService.insertProjectMembers(pmemberDTO);
		}
		
		return "redirect:/project/"+projectNo;
	}
	
	
	
}
