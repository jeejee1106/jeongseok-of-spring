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
		//1. ������ ����
		session.invalidate();
		
		//2. Ȩ���� �̵�
		return "redirect:/";
	}
	
	@PostMapping("/login") //���� ���� URL�� ������ �Ǿ� ������ ����� GET�̱� ������ ��ġ�� �ʴ´�!
	public String login(String id, String pwd, String toURL, boolean rememberId, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//1. id�� pwd�� Ȯ��
		if(!loginCheck(id, pwd)) {
			//2-1. ��ġ���� ������ loginForm���� �̵�
			String msg = URLEncoder.encode("id �Ǵ� pwd�� ��ġ���� �ʽ��ϴ�.", "utf-8");
			
			return "redirect:/login/login?msg=" + msg;
		}
		//2-2. id�� pwd�� ��ġ�ϸ�
		//3. ���� ��ü�� ������
		HttpSession session = request.getSession();
		
		//4. ���� ��ü�� id�� ����
		session.setAttribute("id", id);
		
		//5-1. ���̵� ��￡ üũ�� ������
		if(rememberId) {
			//	6-1. ��Ű�� ����
			Cookie cookie = new Cookie("id", id);
			//	6-2. ���信 ����
			response.addCookie(cookie);
		} else {
			//5-2. ���̵� ��￡ üũ�� ��������
			//6-1. ��Ű ����
			Cookie cookie = new Cookie("id", id);
			cookie.setMaxAge(0); //Ȥ�� ���������� �� ��Ű ����
			//6-2. ���信 ����
			response.addCookie(cookie);
		}
		
		//	7. ��𿡼� �α��� ������ �Ѿ�ԳĿ� ���� redirect�� �ٸ��� ���ش�.
		// Ȩ���� �α������� �Ѿ� ������ toURL�� �ƹ��͵� �����Ƿ� "/"�� �ְ�, �ٸ� ��ο��� �α����� �Ϸ��� �Դٸ� �α��� �� �ٽ� �� ��η� redirect���ش�. �ű���.. ��մ�....
		toURL = toURL == null || toURL.equals("") ? "/" : toURL;
		return "redirect:"  + toURL;
	}

	private boolean loginCheck(String id, String pwd) { //������ �� �Ű������� null�� ���� �� �־ �� �˻縦 ���־���Ѵ�. ���⼱ �����ϰԸ� ����
		return "asdf".equals(id) && "1234".equals(pwd);
	}
	

}
