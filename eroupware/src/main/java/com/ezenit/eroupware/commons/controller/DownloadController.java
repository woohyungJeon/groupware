package com.ezenit.eroupware.commons.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import com.ezenit.eroupware.commons.service.CommonService;

@Controller
public class DownloadController implements ApplicationContextAware {
	
	@Autowired
	CommonService commonService;
	
	private WebApplicationContext context = null;
	
	@RequestMapping(value="/file/{tableName}/{no}")
	public void download(@PathVariable String tableName, @PathVariable String no, HttpServletResponse response, HttpServletRequest request) throws Exception {
		File file = getFile(tableName, no);

		response.setContentType("application/download; charset=utf-8");
		response.setContentLength((int) file.length());

		String userAgent = request.getHeader("User-Agent");

		// 다운로드받는 파일이름 깨지지 않도록 처리
		boolean ie = userAgent.indexOf("MSIE") > -1; // ie 인 경우만 true
		String fileName = null;
		if (ie) {
			fileName = URLEncoder.encode(file.getName(), "utf-8");
		} else {
			fileName = new String(file.getName().getBytes("utf-8"), "iso-8859-1");
		}
		
		// 원본 파일명으로 만들기
		int index = fileName.indexOf("_"); 
		String downloadFileName = fileName.substring(index+1);
		
		response.setHeader("Content-Disposition", "attachment; filename=\"" + downloadFileName + "\";"); // 무조건 특정 파일이	름으로 다운받게  만들기
		response.setHeader("Content-Transfer-Encoding", "binary");
		OutputStream out = response.getOutputStream();

		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
			FileCopyUtils.copy(fis, out);
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException ex) {
				}
			}
		}
		out.flush(); // 남은 데이터를 전송하고 close 하기
	}
	
	// 자동으로 호출되면서 현재 클래스의 컨텍스트를 어플리케이션 컨텍스트로 맞춘다.
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.context = (WebApplicationContext) applicationContext;
	}
	
	private File getFile(String tableName, String no) {
		Map<String, Object> map = new HashMap<String, Object>();
		String columnName = null;
		
		if(tableName.equals("ew_task")) {
			columnName = "taskNo";
		} else if(tableName.equals("ew_notice")) {
			columnName = "seq";
		} else if(tableName.equals("ew_eReport")) {
			columnName = "seq_ew_draft";
		}
		
		map.put("columnName", columnName);
		map.put("tableName", tableName);
		map.put("no", no);
		
		String dbPath = commonService.getFilepath(map);
		String uploadPath = context.getServletContext().getRealPath("/resources/storage");
		
		//String realPath = context.getServletContext().getRealPath("/"); // 서버에 실제로 올라간 프로젝트명 까지의 절대경로
		String fullPath = uploadPath + "/" + dbPath;
		return new File(fullPath);
	}
	
}
