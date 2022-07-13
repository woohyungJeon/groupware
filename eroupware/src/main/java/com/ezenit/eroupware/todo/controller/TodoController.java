package com.ezenit.eroupware.todo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ezenit.eroupware.todo.bean.TodoDTO;
import com.ezenit.eroupware.todo.service.TodoService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


@Controller
public class TodoController {
	
	@Autowired
	TodoService todoService;

	@RequestMapping("/todo")
	public String getTodoMainPage(HttpSession session, ModelMap modelMap) {
		String id = (String)session.getAttribute("session_memberId");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		
		List<TodoDTO> todoList = todoService.getTodoList(map);
		
		modelMap.addAttribute("todoList", todoList);
		
		return "tiles/todo/todo";
	}
	
	@RequestMapping(value="/todo", method=RequestMethod.POST)
	public String insertTodo(TodoDTO todoDTO) {
		todoService.insertTodo(todoDTO); 
		return "redirect:/todo";
	}
	
	@RequestMapping(value="/todo/updateTodoContent", method=RequestMethod.POST, produces="application/text; charset=UTF-8")
	@ResponseBody
	public String updateTodoContent(HttpServletRequest request) throws Exception {
		
		int todoNo = Integer.parseInt(request.getParameter("todoNo"));
		String content = request.getParameter("content");
		
		Map<String, Object> map = new HashMap<>();
		map.put("todoNo", todoNo);
		map.put("content", content);
		
		int result = todoService.updateTodoContent(map);
		
		JSONObject json = new JSONObject();
		
		json.put("result", result);
		return json.toString();
		
	}
	
	
	@RequestMapping(value="/todo/deleteTodo", method=RequestMethod.POST, produces="application/text; charset=UTF-8")
	@ResponseBody
	public String deleteTodo(HttpServletRequest request) throws Exception {
		
		int todoNo = Integer.parseInt(request.getParameter("todoNo"));
		
		Map<String, Object> map = new HashMap<>();
		map.put("todoNo", todoNo);
		
		
		int result = todoService.deleteTodo(map);
		
		JSONObject json = new JSONObject();
		
		json.put("result", result);
		return json.toString();
		
	}
	
	@RequestMapping(value="/todo/updateTodoColor", method=RequestMethod.POST, produces="application/text; charset=UTF-8")
	@ResponseBody
	public String updateTodoColor(HttpServletRequest request) throws Exception {
		
		int todoNo = Integer.parseInt(request.getParameter("todoNo"));
		String color = request.getParameter("color");
		
		Map<String, Object> map = new HashMap<>();
		map.put("todoNo", todoNo);
		map.put("color", color);
		
		int result = todoService.updateTodoColor(map);
		
		JSONObject json = new JSONObject();
		
		json.put("result", result);
		return json.toString();
		
	}
	
	
	// 리스트 가져오는거는 성공 근데 안됨
	@RequestMapping(value="/todo/updateCardSort", method= {RequestMethod.POST, RequestMethod.GET}, produces="application/text; charset=UTF-8")
	@ResponseBody
	public String updateCardSort(HttpServletRequest request, @RequestParam Map<String, Object> params) throws Exception {
		//String[] positions = request.getParameterValues("positions[]");
		
		String jsonParam = params.get("list").toString();
	    ObjectMapper mapper = new ObjectMapper();
	    List<Map<String, Object>> list = mapper.readValue(jsonParam, new TypeReference<List<Map<String, Object>>>(){});
		
		int result = todoService.updateTodoSort(list);
		  
		JSONObject json = new JSONObject();
		json.put("result", result);
		
		return json.toString();
	}
	
}
