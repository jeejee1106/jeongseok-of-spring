package com.fastcampus.ch2;

import java.io.IOException;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

//YoilTellerMVC5 + BindingResult
@Controller
public class YoilTellerMVC6 {
	
	@ExceptionHandler(Exception.class)
	public String catcher(Exception e, BindingResult result) {
		System.out.println("result = " + result);
		
		FieldError error = result.getFieldError();
		System.out.println("Code = " + error.getCode());
		System.out.println("Field = " + error.getField());
		System.out.println("DefaultMessage = " + error.getDefaultMessage());
		
		e.printStackTrace();
		return "yoilError";
	}
	
	@RequestMapping("/getYoilMVC6")
	public String main(MyDate date, BindingResult result) throws IOException {
		System.out.println("result = " + result);

		//1. ��ȿ�� �˻�
		if(!isValid(date)) {
			return "yoilError"; //��, ��, ���� ��ȿ���� ������ WEB-INF/views/yoilError.jsp�� �����ְڴ�!
		}
		
		//2. ó�� - ���� ���
//		char yoil = getYoil(date);
		
		//3. ����� ����� model�� ����
//		model.addAttribute("myDate", date);
//		model.addAttribute("yoil", yoil);
		
		return "yoil"; // /WEB-INF/views/yoil.jsp�� �̿��ؼ� ������� �����ְڴ� ��� ��!
					   // �ٵ� ��ο� Ȯ���� �κ��� �Ź� �Ȱ����ϱ� ����� �κ��� ���� view�̸��� ������ �ϴ� ��!
		
	}

	private boolean isValid(MyDate date) {
		return isValid(date.getYear(), date.getMonth(), date.getDay());
	}

	private @ModelAttribute("yoil") char getYoil(MyDate date) {
		return getYoil(date.getYear(), date.getMonth(), date.getDay());
	}

	private boolean isValid(int year, int month, int day) {
		return true;
	}

	private char getYoil(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month - 1, day);
		
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); //���ڷ� ��µ�. 1=��, 2=��, 3=ȭ ...
		return " �Ͽ�ȭ�������".charAt(dayOfWeek); //���ڸ� �ٽ� ���ڷ� �ٲ��ش�.
	}
}
