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

		//1. 유효성 검사
		if(!isValid(date)) {
			return "yoilError"; //년, 월, 일이 유효하지 않으면 WEB-INF/views/yoilError.jsp를 보여주겠다!
		}
		
		//2. 처리 - 요일 계산
//		char yoil = getYoil(date);
		
		//3. 계산한 결과를 model에 저장
//		model.addAttribute("myDate", date);
//		model.addAttribute("yoil", yoil);
		
		return "yoil"; // /WEB-INF/views/yoil.jsp를 이용해서 결과물을 보여주겠다 라는 뜻!
					   // 근데 경로와 확장자 부분은 매번 똑같으니까 공통된 부분은 빼고 view이름만 적도록 하는 것!
		
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
		
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); //숫자로 출력됨. 1=일, 2=월, 3=화 ...
		return " 일월화수목금토".charAt(dayOfWeek); //숫자를 다시 문자로 바꿔준다.
	}
}
