package com.ezenit.eroupware.todo.service;

import java.util.List;
import java.util.Map;

import com.ezenit.eroupware.todo.bean.TodoDTO;

public interface TodoService {
	public int insertTodo(TodoDTO dto);
	public List<TodoDTO> getTodoList(Map<String, Object> map);
	public int  updateTodoContent(Map<String, Object> map);
	public int  deleteTodo(Map<String, Object> map);
	public int  updateTodoColor(Map<String, Object> map);
	public int updateTodoSort(List<Map<String, Object>> list);

}
