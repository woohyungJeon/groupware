package com.ezenit.eroupware.todo.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezenit.eroupware.todo.bean.TodoDTO;
import com.ezenit.eroupware.todo.dao.TodoDAO;

@Service
public class TodoServiceImpl implements TodoService {

	@Autowired
	private TodoDAO todoDAO;

	@Override
	public int insertTodo(TodoDTO dto) {
		return todoDAO.insertTodo(dto);
	}

	@Override
	public List<TodoDTO> getTodoList(Map<String, Object> map) {
		return todoDAO.getTodoList(map);
	}

	@Override
	public int updateTodoContent(Map<String, Object> map) {
		return todoDAO.updateTodoContent(map);
	}

	@Override
	public int deleteTodo(Map<String, Object> map) {
		return todoDAO.deleteTodo(map);
	}

	@Override
	public int updateTodoColor(Map<String, Object> map) {
		return todoDAO.updateTodoColor(map);
	}

	@Override
	public int updateTodoSort(List<Map<String, Object>> list) {
		return todoDAO.updateTodoSort(list);
	}

}
