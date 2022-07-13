package com.ezenit.eroupware.commons.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class LoginCheckInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
		try	{
			// session_세션값이 널일경우 
			if(request.getSession().getAttribute("session_memberId") == null){
				//로그인페이지로 redirect
				response.setContentType("text/html; charset=UTF-8");
	            PrintWriter out = response.getWriter();
	            out.println("<script>alert('로그인 후 이용가능합니다.'); location.href='login'</script>");
	            out.flush(); 

				return false; 
			} 
		}catch(Exception e){
			e.printStackTrace();
		} // 널이 아니면 정상적으로 컨트롤러 호출 
		return true;
	}
	
}
