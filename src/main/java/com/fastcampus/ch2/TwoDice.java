package com.fastcampus.ch2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//새로고침을 할 때 마다 숫자가 바뀌는 주사위 이미지를 브라우저에 출력해보자!
@Controller
public class TwoDice {
	@RequestMapping("/rollDice")
	public void main(HttpServletResponse response) throws IOException {
		int idx1 = (int)(Math.random()*6) + 1;
		int idx2 = (int)(Math.random()*6) + 1;
		
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<img src='resources/img/dice" + idx1 + ".jpg'>");
		out.println("<img src='resources/img/dice" + idx2 + ".jpg'>");
		out.println("</body>");
		out.println("</html>");
		
	}
}
