package com.fastcampus.ch2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//년월일을 입력하면 요일을 알려주는 프로그램을 만들어보자.
//관심사를 분리해보자! (뷰따로, )
@Controller
public class YoilTellerMVC {
	
	@RequestMapping("/getYoilMVC")
	public String main(int year, int month, int day, Model model) throws IOException {
		/**
		 * HttpServletRequest로 데이터를 받는 대신, 직접 year, month, day를 받을 수 있다.
		 * 이 때 String이 아닌 int 타입으로 받을 수 있는데, 쿼리스트링의 String타입을 DispatcherServlet이 자동으로 int타입으로 변환해주기 때문이다.
		 * 
		 * 또한 Model에 데이터를 담아 view에 보내야하기 때문에 HttpServletResponse도 필요가 업고, Model객체를 받아준다.
		 * Model또한 DispatcherServlet이 만들어서 Controller에 보내준다!
		 */
		
		
		//현재는 isValid를 true로 놨을 때 파라미터를 안넘기면 500에러(서버에러) 남
		//why? getYoilMVC2 예제부터 배울거지만, 현재는 파라미터가 필수 입력이 아닌 상태다(required=false).
		//그렇기 때문에 클라이언트는 파라미터를 넘기지 않아도 된다.
		//그렁 파라미터 부분엔 null값이 들어오게 되는데, null을 int타입으로 바꿀 수 없기 때문에 서버에러가 난다.
		
		//1. 유효성 검사
		if(!isValid(year, month, day)) {
			return "yoilError";
		}
		
		//2. 요일 계산
		char yoil = getYoil(year, month, day);
		
		//3. 계산한 결과를 model에 저장
		//model은 컨트롤러와 뷰 사이에서 데이터를 전달해주는 역할을 한다.
		model.addAttribute("year", year);
		model.addAttribute("month", month);
		model.addAttribute("day", day);
		model.addAttribute("yoil", yoil);
		
		return "yoil"; //view의 경로 반환
					   //servlet-context.xml파일에 prefix(접두사 : /WEB-INF/views/)와 suffix를(접미사 : .jsp) 이용해 view의 경로를 지정한다.
		
	}

	private boolean isValid(int year, int month, int day) {
		return true; //false로 두면 무조건 yoilError 페이지로 넘어간다!!!! 일단 유효성 검사를 간단하게 true, false로 해봄
					 //true로 두면 yoil페이지로 넘어간다.
	}

	private char getYoil(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month - 1, day);
		
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); //숫자로 출력됨. 1=일, 2=월, 3=화 ...
		return " 일월화수목금토".charAt(dayOfWeek); //숫자를 다시 문자로 바꿔준다.
	}
}