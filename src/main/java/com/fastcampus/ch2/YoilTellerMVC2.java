package com.fastcampus.ch2;

import java.io.IOException;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//YoilTellerMVC + @RequestParam�� �����ϰ�, ���� ó���� �ϴ� ����!
@Controller
public class YoilTellerMVC2 {
	
	@ExceptionHandler
	public String catcher(Exception e) {
		e.printStackTrace();
		return "yoilError";
	}
	
	@RequestMapping("/getYoilMVC2")
	public String main(@RequestParam(required=true) int year, 
						@RequestParam(required=true) int month, 
						@RequestParam(required=true) int day, Model model) throws IOException {

		//1. ��ȿ�� �˻�
		if(!isValid(year, month, day)) {
			return "yoilError"; //��, ��, ���� ��ȿ���� ������ WEB-INF/views/yoilError.jsp�� �����ְڴ�!
		}
		
		//2. ���� ���
		char yoil = getYoil(year, month, day);
		
		//3. ����� ����� model�� ����
		model.addAttribute("year", year);
		model.addAttribute("month", month);
		model.addAttribute("day", day);
		model.addAttribute("yoil", yoil);
		
		return "yoil"; // /WEB-INF/views/yoil.jsp�� �̿��ؼ� ������� �����ְڴ� ��� ��!
					   // �ٵ� ��ο� Ȯ���� �κ��� �Ź� �Ȱ����ϱ� ����� �κ��� ���� view�̸��� ������ �ϴ� ��!
		
	}

	private boolean isValid(int year, int month, int day) {
		return true;
	}

	private char getYoil(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month - 1, day);
		
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); //���ڷ� ��µ�. 1=��, 2=��, 3=ȭ ...
		return "�Ͽ�ȭ�������".charAt(dayOfWeek); //���ڸ� �ٽ� ���ڷ� �ٲ��ش�.
	}
}
