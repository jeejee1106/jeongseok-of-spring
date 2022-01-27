package com.fastcampus.ch2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//년월일을 입력하면 요일을 알려주는 프로그램을 만들어보자.
@Controller
public class YoilTeller {
	
//	public static void main(String[] args) {
	@RequestMapping("/getYoil")
	public void main(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//HttpServletRequest : 서버에서 파라미터를 받겠다.
		//HttpServletResponse : 브라우저에 출력 할 때!
		
		//1. 입력
		String year = request.getParameter("year"); //파라미터는 웹(서버)에서 넘겨준다
		String month = request.getParameter("month"); //ex) http://localhost:9000/ch2/getYoil?year=1995&month=11&day=6
		String day = request.getParameter("day");     //물음표 뒤에 오는 것들이 파라미터 라고 생각하면 될 것 같다.
		
		//위 문자열을 숫자로 바꿔준다.
		int yyyy = Integer.parseInt(year);
		int mm = Integer.parseInt(month);
		int dd = Integer.parseInt(day);
		
		//2. 작업 - 날짜 셋팅
		Calendar cal = Calendar.getInstance();
		cal.set(yyyy, mm - 1, dd);
		
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); //숫자로 출력됨. 1=일, 2=월, 3=화 ...
		char yoil = "일월화수목금토".charAt(dayOfWeek); //숫자를 다시 문자로 바꿔준다.
		
		//3-1. 콘솔에 출력
//		System.out.println(year + "년 " + month + "월 " + day + "일은 ");
//		System.out.println(yoil + "요일 입니다.");
		
		//3-2. 브라우저에 출력
		response.setContentType("text/html"); //출력할 내용의 타입을 써주어야 한다. why?브라우저는 내가 보내는 내용이 텍스트인지 바이너리인지 모르기 때문에 알려줘야한다.
		response.setCharacterEncoding("utf-8"); //인코딩도 알려줘야 함
		PrintWriter out = response.getWriter(); //response객체에서 브라우저로의 출력 스트림을 얻는다.
												//response.getWriter()는 예외 처리를 해주어야 하는데
												//지금은 일단 던지겠다.
		
		out.println(year + "년 " + month + "월 " + day + "일은 ");
		out.println(yoil + "요일 입니다.");
	}

}
