package com.fastcampus.ch2;

import java.io.IOException;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//YoilTellerMVC + @RequestParam을 설정하고, 예외 처리를 하는 예제!
@Controller
public class YoilTellerMVC2 {
	
	@ExceptionHandler(Exception.class)
	public String catcher(Exception e) {
		e.printStackTrace(); //어떤 예외인지 찍어 볼 수 있는 메서드
		return "yoilError";
	}
	
	@RequestMapping("/getYoilMVC2")
	public String main(@RequestParam(required=true) int year, 
						@RequestParam(required=true) int month, 
						@RequestParam(required=true) int day, Model model) throws IOException {
						//매개변수 입력을 true(필수)로 줬기 때문에 매개변수를 넘기지 않음면 400번대 에러(클라이언트 에러)가 난다.
						//이 에러 화면이 뜨지 않도록 예외처리 메서드를 만들었다.
		//1. 유효성 검사
		if(!isValid(year, month, day)) {
			return "yoilError"; //년, 월, 일이 유효하지 않으면 WEB-INF/views/yoilError.jsp를 보여주겠다!
		}
		
		//2. 요일 계산
		char yoil = getYoil(year, month, day);
		
		//3. 계산한 결과를 model에 저장
		model.addAttribute("year", year);
		model.addAttribute("month", month);
		model.addAttribute("day", day);
		model.addAttribute("yoil", yoil);
		
		return "yoil"; // /WEB-INF/views/yoil.jsp를 이용해서 결과물을 보여주겠다 라는 뜻!
					   // 근데 경로와 확장자 부분은 매번 똑같으니까 공통된 부분은 빼고 view이름만 적도록 하는 것!
		
	}

	private boolean isValid(int year, int month, int day) {
		if(year == -1 || month == -1 || day == -1) {
			return false;
		}
		return (1 <= month && month <= 12) && (1 <= day && day <= 31); //간단히 체크
	}

	private char getYoil(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month - 1, day);
		
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); //숫자로 출력됨. 1=일, 2=월, 3=화 ...
		return " 일월화수목금토".charAt(dayOfWeek); //숫자를 다시 문자로 바꿔준다.
	}
}
