package com.ezenit.eroupware.commons.controller;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ezenit.eroupware.commons.bean.MemberSelectDTO;
import com.ezenit.eroupware.commons.service.CommonService;

@Controller
public class CommonController {
	
	@Autowired
	CommonService commonService;
	
//	@RequestMapping(value="/getMemberSelectList", method=RequestMethod.POST, produces="application/text; charset=UTF-8")
//	@ResponseBody
//	public String getSelecMemberList() {
//		List<MemberSelectListDTO> list = commonService.getMemberSelectList();
//		
//		for(int i=0; i<list.size(); i++) {
//			System.out.println(list.get(i).toString());
//		}
//		
//		JSONObject json = new JSONObject();
//		JSONArray items = new JSONArray();
//		
//		for(int i=0; i<list.size(); i++) {
//			MemberSelectListDTO dto = list.get(i);
//			JSONObject temp = new JSONObject();
//			temp.put("id", dto.getDeptno());
//			temp.put("title", dto.getName());
//			
//			items.put(i, temp);
//		}
//		
//		json.put("items", items);
//		json.put("list", list);
//		
//		return json.toString();
//	}

}
