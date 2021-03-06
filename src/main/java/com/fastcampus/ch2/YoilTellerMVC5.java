package com.fastcampus.ch2;

import java.io.IOException;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

//YoilTellerMVC4 + @ModelAttribute
@Controller
public class YoilTellerMVC5 {
	
	@ExceptionHandler(Exception.class)
	public String catcher(Exception e) {
		e.printStackTrace();
		return "yoilError";
	}
	
	//@ModelAttribute는 MyDate를 자동으로 model에 담아주는 역할을 한다. 따라서 Model객체를 쓸 필요가 없다.
	
	@RequestMapping("/getYoilMVC5")
	//public String main(@ModelAttribute("myDate") MyDate date, Model model) throws IOException { //밑 줄과 같은 의미! 생략 하면 자동으로 타입의 첫글자를 소문자로 바꿔서 key로 사용한다.
	public String main(@ModelAttribute MyDate date, Model model) throws IOException {

		//1. 유효성 검사
		if(!isValid(date)) {
			return "yoilError"; //년, 월, 일이 유효하지 않으면 WEB-INF/views/yoilError.jsp를 보여주겠다!
		}
		
		//2. 처리 - 요일 계산
//		char yoil = getYoil(date); //@ModelAttribute를 사용했기 때문에 자동으로 호출된다.
		
		//3. 계산한 결과를 model에 저장
//		model.addAttribute("myDate", date);
//		model.addAttribute("yoil", yoil); //@ModelAttribute를 사용했기 때문에 따로 model에 담아줄 필요가 없다.
		
		//@ModelAttribute를 이용하면 2,3번이 다 필요가 없다.
		
		return "yoil"; // /WEB-INF/views/yoil.jsp를 이용해서 결과물을 보여주겠다 라는 뜻!
					   // 근데 경로와 확장자 부분은 매번 똑같으니까 공통된 부분은 빼고 view이름만 적도록 하는 것!
		
	}

	private boolean isValid(MyDate date) {
		return isValid(date.getYear(), date.getMonth(), date.getDay());
	}

	private @ModelAttribute("yoil") char getYoil(MyDate date) { //반환타입 앞에 붙여주면 key를 꼭 적어줘야한다. ("yoil")
		return getYoil(date.getYear(), date.getMonth(), date.getDay());
	}


	private char getYoil(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month - 1, day);
		
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); //숫자로 출력됨. 1=일, 2=월, 3=화 ...
		return " 일월화수목금토".charAt(dayOfWeek); //숫자를 다시 문자로 바꿔준다.
	}
	
	private boolean isValid(int year, int month, int day) {
		if(year == -1 || month == -1 || day == -1) {
			return false;
		}
		return (1 <= month && month <= 12) && (1 <= day && day <= 31); //간단히 체크
	}
}
