package com.ezenit.eroupware.work.controller;

import java.util.ArrayList;
import java.util.Calendar;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.ezenit.eroupware.work.bean.WorkDTO;
import com.ezenit.eroupware.work.bean.WorkListDTO;
import com.ezenit.eroupware.work.service.WorkService;

@Controller
public class WorkController {

	@Autowired
	WorkService workService;

	// 출근 퇴근 시간 기록하기
	@RequestMapping(value = "/work", method = RequestMethod.POST, produces = "application/text; charset=UTF-8")
	@ResponseBody
	public String insertStartWork(HttpServletRequest request, WorkDTO workDTO) {

		JSONObject json = new JSONObject();
		int checkResult = workService.workCheck(workDTO);

		// 이미 출퇴근한 기록이 있을 경우
		if (checkResult > 0) {
			json.put("result", 2);
		} else {
			request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
			String ip = request.getHeader("X-FORWARDED-FOR");
			if (ip == null) {
				ip = request.getRemoteAddr();
			}

			if (ip == null) {
				ip = request.getHeader("Proxy-Client-IP");
			}
			if (ip == null) {
				ip = request.getHeader("WL-Proxy-Client-IP");
			}
			if (ip == null) {
				ip = request.getHeader("HTTP_CLIENT_IP");
			}
			if (ip == null) {
				ip = request.getHeader("HTTP_X_FORWARDED_FOR");
			}
			if (ip == null) {
				ip = request.getRemoteAddr();
			}

			int result = 0;

			if (workDTO.getTimeFlag().equals("startTime") || workDTO.getTimeFlag() == "startTime") {
				workDTO.setStartIp(ip);
				result = workService.insertStartWork(workDTO);
			} else if (workDTO.getTimeFlag().equals("endTime") || workDTO.getTimeFlag() == "endTime") {
				workDTO.setEndIp(ip);
				result = workService.updateEndWork(workDTO);
			}
			json.put("result", result);
		}
		return json.toString();
	}

	@RequestMapping(value = "/work", method = RequestMethod.GET)
	public String getWorkMainPage(HttpSession session, HttpServletRequest request, ModelMap modelMap) {
		
		Calendar cal = Calendar.getInstance();
		String id = (String) session.getAttribute("session_memberId");
		int year = request.getParameter("year") == null ? cal.get(Calendar.YEAR) : Integer.parseInt(request.getParameter("year"));
		int month = request.getParameter("month") == null ? cal.get(Calendar.MONTH)+1 : Integer.parseInt(request.getParameter("month"));
		
		Map<String, Object> map = new HashMap<String, Object>();
		String inputWorkDate;
		if(month < 10) {
			inputWorkDate = year + "-0"+month;
		} else {
			inputWorkDate = year + "-"+month;
		}
		map.put("id", id);
		map.put("workDate", inputWorkDate);
		
		List<WorkListDTO> workListByMonth = workService.getWorkList(map);

		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month-1);
		int maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		String week[] = new String[] { "일", "월", "화", "수", "목", "금", "토" };
		List<WorkListDTO> workList = new ArrayList<WorkListDTO>(maxDay);

		for (int i = 0; i < maxDay; i++) {
			cal.set(Calendar.DATE, i + 1);

			String cal_year = cal.get(Calendar.YEAR) + "";
			String cal_month = (cal.get(Calendar.MONTH) + 1) < 10 ? "0" + (cal.get(Calendar.MONTH) + 1)
					: (cal.get(Calendar.MONTH) + 1) + "";
			String cal_date = (cal.get(Calendar.DAY_OF_MONTH)) < 10 ? "0" + (cal.get(Calendar.DAY_OF_MONTH))
					: cal.get(Calendar.DAY_OF_MONTH) + "";
			String dayOfWeek = week[cal.get(Calendar.DAY_OF_WEEK) - 1];

			String workDate = cal_year + "-" + cal_month + "-" + cal_date;

			WorkListDTO workListDTO = new WorkListDTO(workDate, dayOfWeek, id);
			workList.add(i, workListDTO);

			for(int j=0; j<workListByMonth.size(); j++) {
				if(workListByMonth.get(j).getWorkDate().equals(workDate)) {
					workListByMonth.get(j).setDayOfWeek(dayOfWeek);
					workList.set(i, workListByMonth.get(j));
				}
			}
		}
		modelMap.addAttribute("workList", workList);
		modelMap.addAttribute("year", year);
		modelMap.addAttribute("month", month);
		
		return "tiles/work/work";
	}

}
