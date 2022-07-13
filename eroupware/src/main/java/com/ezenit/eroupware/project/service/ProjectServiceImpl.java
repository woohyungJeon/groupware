package com.ezenit.eroupware.project.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezenit.eroupware.project.bean.PmemberDTO;
import com.ezenit.eroupware.project.bean.ProjectDTO;
import com.ezenit.eroupware.project.bean.ProjectListDTO;
import com.ezenit.eroupware.project.bean.ProjectMemberListDTO;
import com.ezenit.eroupware.project.bean.ProjectTaskCntDTO;
import com.ezenit.eroupware.project.bean.TaskDTO;
import com.ezenit.eroupware.project.bean.TaskListDTO;
import com.ezenit.eroupware.project.bean.TaskStatusCntDTO;
import com.ezenit.eroupware.project.dao.ProjectDAO;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectDAO projectDAO;

	@Override
	public int insertProject(ProjectDTO dto) {
		return projectDAO.insertProject(dto);
	}

	@Override
	public int insertProjectMembers(PmemberDTO dto) {
		return projectDAO.insertProjectMembers(dto);
	}

	@Override
	public List<ProjectListDTO> getProjectList(String id) {
		return projectDAO.getProjectList(id);
	}

	@Override
	public ProjectListDTO getProjectInfo(int projectNo) {
		return projectDAO.getProjectInfo(projectNo);
	}

	@Override
	public int insertTask(TaskDTO dto) {
		return projectDAO.insertTask(dto);
	}

	@Override
	public List<TaskListDTO> getTaskList(int projectNo) {
		return projectDAO.getTaskList(projectNo);
	}

	@Override
	public ProjectTaskCntDTO getProjectTaskCnt(int projectNo) {
		return projectDAO.getProjectTaskCnt(projectNo);
	}

	@Override
	public List<ProjectMemberListDTO> getProjectMemberList(int projectNo) {
		return projectDAO.getProjectMemberList(projectNo);
	}

	@Override
	public TaskStatusCntDTO getTaskStatusCntByMember(Map<String, Object> map) {
		return projectDAO.getTaskStatusCntByMember(map);
	}

	@Override
	public int updateTaskStatus(Map<String, Object> map) {
		return projectDAO.updateTaskStatus(map);
	}

	@Override
	public int deleteTask(int taskNo) {
		return projectDAO.deleteTask(taskNo);
	}

	@Override
	public int updateProject(ProjectDTO dto) {
		return projectDAO.updateProject(dto);
	}


}
