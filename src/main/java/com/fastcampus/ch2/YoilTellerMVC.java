//package com.fastcampus.ch2;
//
//import java.io.IOException;
//import java.util.Calendar;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RequestMapping;
//
////년월일을 입력하면 요일을 알려주는 프로그램을 만들어보자.
////기존의 YoilTeller프로그램을 스프링 패턴을 이용해서 관심사를 분리해보자!
//@Controller
//public class YoilTellerMVC {
//	
//	@ExceptionHandler(Exception.class)
//	public String catcher(Exception e) {
//		e.printStackTrace(); //어떤 예외인지 찍어 볼 수 있는 메서드
//		return "yoilError";
//	}
//	
//	@RequestMapping("/getYoilMVC")
//	public String main(int year, int month, int day, Model model) throws IOException {
//
//		//1. 유효성 검사
//		if(!isValid(year, month, day)) {
//			return "yoilError"; //년, 월, 일이 유효하지 않으면 WEB-INF/views/yoilError.jsp를 보여주겠다!
//		}
//		
//		//2. 요일 계산
//		char yoil = getYoil(year, month, day);
//		
//		//3. 계산한 결과를 model에 저장
//		model.addAttribute("year", year);
//		model.addAttribute("month", month);
//		model.addAttribute("day", day);
//		model.addAttribute("yoil", yoil);
//		
//		return "yoil"; // /WEB-INF/views/yoil.jsp를 이용해서 결과물을 보여주겠다 라는 뜻!
//					   // 근데 경로와 확장자 부분은 매번 똑같으니까 공통된 부분은 빼고 view이름만 적도록 하는 것!
//		
//	}
//
//	private boolean isValid(int year, int month, int day) {
//		return true;
//	}
//
//	private char getYoil(int year, int month, int day) {
//		Calendar cal = Calendar.getInstance();
//		cal.set(year, month - 1, day);
//		
//		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); //숫자로 출력됨. 1=일, 2=월, 3=화 ...
//		return "일월화수목금토".charAt(dayOfWeek); //숫자를 다시 문자로 바꿔준다.
//	}
//}
package com.fastcampus.ch2;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class YoilTellerMVC {
    @RequestMapping("/getYoilMVC") // http://localhost/ch2/getYoilMVC
    public String main(int year, int month, int day, Model model) {
 
        // 1. 유효성 검사
    	if(!isValid(year, month, day)) 
    		return "yoilError";  // 유효하지 않으면, /WEB-INF/views/yoilError.jsp로 이동
    	
        // 2. 처리
    	char yoil = getYoil(year, month, day);

        // 3. Model에 작업 결과 저장
        model.addAttribute("year", year);
        model.addAttribute("month", month);
        model.addAttribute("day", day);
        model.addAttribute("yoil", yoil);
        
        // 4. 작업 결과를 보여줄 View의 이름을 반환
        return "yoil"; // /WEB-INF/views/yoil.jsp
    }
    
    private char getYoil(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, day);

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        return " 일월화수목금토".charAt(dayOfWeek);
    }
    
    private boolean isValid(int year, int month, int day) {    
    	if(year==-1 || month==-1 || day==-1) 
    		return false;
    	
    	return (1<=month && month<=12) && (1<=day && day<=31); // 간단히 체크 
    }
}