package com.ezenit.eroupware.commons.controller;

import java.util.List;

import org.apache.tiles.Attribute;
import org.apache.tiles.AttributeContext;
import org.apache.tiles.preparer.ViewPreparer;
import org.apache.tiles.request.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ezenit.eroupware.commons.bean.DeptSelectDTO;
import com.ezenit.eroupware.commons.bean.MemberSelectDTO;
import com.ezenit.eroupware.commons.service.CommonService;

@Component
public class DepartmentPreparer implements ViewPreparer {
	
	@Autowired
	CommonService commonService;
	
	@Override
	public void execute(Request tilesContext, AttributeContext attributeContext) {
		List<DeptSelectDTO> deptSelectDTOList = commonService.getDeptSelectDTOList();
		List<MemberSelectDTO> memberSelectDTOList =  commonService.getMemberSelectDTOList();
		
		attributeContext.putAttribute("deptSelectDTOList", new Attribute(deptSelectDTOList), true);
		attributeContext.putAttribute("memberSelectDTOList", new Attribute(memberSelectDTOList), true);
	}
}
