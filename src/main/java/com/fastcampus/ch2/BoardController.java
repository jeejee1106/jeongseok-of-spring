package com.fastcampus.ch2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {

	@GetMapping("/list")
	public String list(HttpServletRequest request) {
		if(!loginCheck(request)) {
			return "redirect:/login/login?toURL=" + request.getRequestURL(); //로그인 안했으면 로그인 화면으로 이동
			//request.getRequestURL() -> 어느 경로에서 넘어왔는지 값이 찍히게 함.
			///login/login 컨트롤러에 toURL도 같이 넘겨서 로그인 후 어디로 redirect해줄지 알려준다.
		} 
		return "boardList"; //로그인 했으면 게시판으로 이동
	}

	private boolean loginCheck(HttpServletRequest request) {
		//1. 세션을 얻어서
		HttpSession session = request.getSession();
		
		//2. 세션에 id가 있는지 확인
		return session.getAttribute("id") != null; //아이디가 있으면 로그인 중이므로 true반환. 없으면 반대.
	}
}
