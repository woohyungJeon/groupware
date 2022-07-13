package com.ezenit.eroupware.todo.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ezenit.eroupware.todo.bean.TodoDTO;

@Repository
public class TodoDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public int insertTodo(TodoDTO dto) {
		return sqlSession.insert("mybatis.todoMapper.insertTodo", dto);
	}
	
	public List<TodoDTO> getTodoList(Map<String, Object> map) {
		return sqlSession.selectList("mybatis.todoMapper.getTodoList", map);
	}
	
	public int updateTodoContent(Map<String, Object> map) {
		return sqlSession.update("mybatis.todoMapper.updateTodoContent", map);
	}
	 
	public int deleteTodo(Map<String, Object> map) {
		return sqlSession.delete("mybatis.todoMapper.deleteTodo", map);
	}
	
	public int updateTodoColor(Map<String, Object> map) {
		return sqlSession.update("mybatis.todoMapper.updateTodoColor", map);
	}
	
	public int updateTodoSort(List<Map<String, Object>> list) {
		return sqlSession.update("mybatis.todoMapper.updateTodoSort", list);
	}
	
}
