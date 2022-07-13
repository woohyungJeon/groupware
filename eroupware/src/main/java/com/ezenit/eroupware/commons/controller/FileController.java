package com.ezenit.eroupware.commons.controller;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileController {
	
	public String fileUpload(HttpServletRequest request, MultipartFile file) {
		
		// 파일 업로드
		// 첨부한 파일이 있을경우
		if(file.getSize() > 0) {
			
			// 파일 업로드 경로
			String filePath = request.getSession().getServletContext().getRealPath("/resources/storage/");
			// 첨부한 원본 파일명
			String fileName = file.getOriginalFilename();
			
			// 파일명 앞에 현재시간밀리세컨드+랜덤숫자 부여 => 동일파일명 겹치지 않게 처리함
			long now = System.currentTimeMillis();
			Random r = new Random();
			int i = r.nextInt(50);
			fileName = now + i + "_" + fileName;
			
			// 경로에 폴더 없으면 만들어주기
			File dir = new File(filePath);
			if(!dir.exists()) {
				dir.mkdirs();
			}
			
			// 파일 저장하기
			try {
				File new_file = new File(filePath + fileName);
				file.transferTo(new_file);
			} catch(IllegalStateException e) {
				e.printStackTrace();
			} catch(IOException e) {
				e.printStackTrace();
			}
			return fileName;
		} else {
			// 첨부한 파일 없을경우 dto.filepath에 널값주기
			return null;
		}
		
	}
	
	public String renameFile(String filepath) {
		if(filepath != null) {
			int index = filepath.indexOf("_");
			return filepath.substring(index + 1);
		} else {
			return null;
		}
		
	}

}
