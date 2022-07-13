package com.ezenit.eroupware.project.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ezenit.eroupware.project.bean.PmemberDTO;
import com.ezenit.eroupware.project.bean.ProjectDTO;
import com.ezenit.eroupware.project.bean.ProjectListDTO;
import com.ezenit.eroupware.project.bean.ProjectMemberListDTO;
import com.ezenit.eroupware.project.bean.ProjectTaskCntDTO;
import com.ezenit.eroupware.project.bean.TaskDTO;
import com.ezenit.eroupware.project.bean.TaskListDTO;
import com.ezenit.eroupware.project.bean.TaskStatusCntDTO;

@Repository
public class ProjectDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public int insertProject(ProjectDTO dto) {
		return sqlSession.insert("mybatis.projectMapper.insertProject", dto);
	}
	
	public int insertProjectMembers(PmemberDTO dto) {
		return sqlSession.insert("mybatis.projectMapper.insertProjectMembers", dto);
	}
	
	public List<ProjectListDTO> getProjectList(String id) {
		return sqlSession.selectList("mybatis.projectMapper.getProjectList", id);
	}
	
	public ProjectListDTO getProjectInfo(int projectNo) {
		return sqlSession.selectOne("mybatis.projectMapper.getProjectInfo", projectNo);
	}
	
	public int insertTask(TaskDTO dto) {
		return sqlSession.insert("mybatis.projectMapper.insertTask", dto);
	}
	
	public List<TaskListDTO> getTaskList(int projectNo) {
		return sqlSession.selectList("mybatis.projectMapper.getTaskList", projectNo);
	}
	
	public ProjectTaskCntDTO getProjectTaskCnt(int projectNo) {
		return sqlSession.selectOne("mybatis.projectMapper.getProjectTaskCnt", projectNo);
	}
	
	public List<ProjectMemberListDTO> getProjectMemberList(int projectNo) {
		return sqlSession.selectList("mybatis.projectMapper.getProjectMemberList", projectNo);
	}
	
	public TaskStatusCntDTO getTaskStatusCntByMember(Map<String, Object> map) {
		return sqlSession.selectOne("mybatis.projectMapper.getTaskStatusCntByMember", map);
	}
	
	public int updateTaskStatus(Map<String, Object> map) {
		return sqlSession.update("mybatis.projectMapper.updateTaskStatus", map);
	}
	
	public int deleteTask(int taskNo) {
		return sqlSession.delete("mybatis.projectMapper.deleteTask", taskNo);
	}
	
	public int updateProject(ProjectDTO dto) {
		return sqlSession.update("mybatis.projectMapper.updateProject", dto);
	}
	
}
