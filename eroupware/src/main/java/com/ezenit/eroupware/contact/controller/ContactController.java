package com.ezenit.eroupware.contact.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ezenit.eroupware.contact.bean.ContactDTO;
import com.ezenit.eroupware.contact.bean.PageMaker;
import com.ezenit.eroupware.contact.bean.SearchCriteria;
import com.ezenit.eroupware.contact.service.ContactService;

@Controller
public class ContactController {
	
	@Autowired
	ContactService contactService;
	
	//사원 리스트 가져오기
	@RequestMapping(value="/contact", method = RequestMethod.GET)
	public String contactMemberList(Model model, @ModelAttribute("scri") SearchCriteria scri) throws Exception{
				
		model.addAttribute("contactlist", contactService.contactMemberList(scri));
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(scri);
		pageMaker.setTotalCount(contactService.contactListCount(scri));
		
		model.addAttribute("pageMaker",pageMaker);
				
		return "tiles/contact/contactList";		
	}	
	
	//연락처 상세보기
	@RequestMapping(value = "/contact/{id}", method = RequestMethod.GET)
	public String contactDetail(ContactDTO contactDTO, Model model, @PathVariable("id") String id) throws Exception {
		
		contactDTO = contactService.contactDetail(id);		
		model.addAttribute("contactDetail", contactDTO);		
		
		return "contact/contactDetail";
	}	
}
