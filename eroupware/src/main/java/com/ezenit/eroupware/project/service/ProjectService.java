package com.ezenit.eroupware.project.service;

import java.util.List;
import java.util.Map;

import com.ezenit.eroupware.project.bean.PmemberDTO;
import com.ezenit.eroupware.project.bean.ProjectDTO;
import com.ezenit.eroupware.project.bean.ProjectListDTO;
import com.ezenit.eroupware.project.bean.ProjectMemberListDTO;
import com.ezenit.eroupware.project.bean.ProjectTaskCntDTO;
import com.ezenit.eroupware.project.bean.TaskDTO;
import com.ezenit.eroupware.project.bean.TaskListDTO;
import com.ezenit.eroupware.project.bean.TaskStatusCntDTO;

public interface ProjectService {
	public int insertProject(ProjectDTO dto);
	public int insertProjectMembers(PmemberDTO dto);
	public List<ProjectListDTO> getProjectList(String id);
	public ProjectListDTO getProjectInfo(int projectNo);
	public int insertTask(TaskDTO dto);
	public List<TaskListDTO> getTaskList(int projectNo);
	public ProjectTaskCntDTO getProjectTaskCnt(int projectNo);
	public List<ProjectMemberListDTO> getProjectMemberList(int projectNo);
	public TaskStatusCntDTO getTaskStatusCntByMember(Map<String, Object> map);
	public int updateTaskStatus(Map<String, Object> map);
	public int deleteTask(int taskNo);
	public int updateProject(ProjectDTO dto);

}
