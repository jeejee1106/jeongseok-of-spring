package com.fastcampus.ch2;

import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@GetMapping("/login")
	public String loginForm() {
		return "loginForm";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		//1. 세션을 종료
		session.invalidate();
		
		//2. 홈으로 이동
		return "redirect:/";
	}
	
	@PostMapping("/login")
	public String login(String id, String pwd, String toURL, boolean rememberId, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//1. id와 pwd를 확인
		if(!loginCheck(id, pwd)) {
			//2-1. 일치하지 않으면 loginForm으로 이동
			String msg = URLEncoder.encode("id 또는 pwd가 일치하지 않습니다.", "utf-8");
			
			return "redirect:/login/login?msg=" + msg;
		}
		//2-2. id와 pwd가 일치하면
		//3. 세션 객체를 얻어오기
		HttpSession session = request.getSession();
		
		//4. 세션 객체에 id를 저장
		session.setAttribute("id", id);
		
		//5-1. 아이디 기억에 체크를 했으면
		if(rememberId) {
			//	6-1. 쿠키를 생성
			Cookie cookie = new Cookie("id", id);
			//	6-2. 응답에 저장
			response.addCookie(cookie);
		} else {
			//5-2. 아이디 기억에 체크를 안했으면
			//6-1. 쿠키 삭제
			Cookie cookie = new Cookie("id", id);
			cookie.setMaxAge(0); //혹시 남았을지도 모를 쿠키 삭제
			//6-2. 응답에 저장
			response.addCookie(cookie);
		}
		
		toURL = toURL == null || toURL.equals("") ? "/" : toURL;
		//	7. 홈으로 이동
		return "redirect:"  + toURL;
	}

	private boolean loginCheck(String id, String pwd) {
		return "asdf".equals(id) && "1234".equals(pwd);
	}
	

}
