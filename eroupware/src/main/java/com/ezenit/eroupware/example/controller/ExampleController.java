package com.ezenit.eroupware.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ezenit.eroupware.example.bean.ExampleDTO;
import com.ezenit.eroupware.example.service.ExampleService;

@Controller
public class ExampleController {
	
	@Autowired
	ExampleService exampleService;
	 
	// 메인호출 메서드는 메인패키지 안에 있음
//	@RequestMapping("/main")
//	public String main() {
//		return "tiles/example/main";
//	}

	// 입력폼 가져오기
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public String insertForm() {
		return "tiles/example/insertExample";
	}
	
	// insert 후 리다이렉트
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insertExample(ExampleDTO dto) {
		exampleService.insertExample(dto);
		return "redirect:/main";
	}

	// 타일즈 제외 페이지
	@RequestMapping("/test")
	public String test() {
		return "example/test";
	}
	
	// 제이쿼리 유틸 테스트 페이지
	@RequestMapping("/utiltest")
	public String utiltest() {
		return "tiles/example/utiltest";
	}
	
	// 레스트풀
	@RequestMapping(value="/main/{number}")
	public String restful(@PathVariable("number") int number, ModelMap modelMap) {
		modelMap.addAttribute("number", number);
		return "tiles/example/restful";
	}

}
