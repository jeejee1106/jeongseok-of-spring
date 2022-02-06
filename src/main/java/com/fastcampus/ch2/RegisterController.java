package com.fastcampus.ch2;

import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegisterController {

//	@RequestMapping("/register/add") //(value="/register/add", method={RequestMethod.GET, RequestMethod.POST}) 이 생략되어 있는 것! GET과 POST 둘 다 허용하겠다.
//	@GetMapping("/register/add")
//	public String register() {
//		return "registerForm";
//	}
	/*
	 * 사실 위 메서드는 매핑 연결만 해줄 뿐 별다른 기능이 없는 메서드이다.
	 * 이런 메서드들은 servlet-context.xml파일에 
	 * <view-controller path="/register/add" view-name="registerForm"/>
	 * 이렇게 한 줄을 추가해주면 위 네줄을 안쓰고도 같은 기능을 하게 만들 수 있다.
	 * view-controller는 get요청만 허락한다!
	 * */
	

//	@RequestMapping(value="/register/save", method=RequestMethod.POST) //아래와 동일한 코드!
	@PostMapping("/register/save") //PostMapping, GetMapping 어노태이션은 스프링 4.3부터!!
	public String save(User user, Model m) throws Exception{
		//1. 유효성 검사
		if(!isValid(user)) {
			String msg = URLEncoder.encode("id를 잘못 입력하셨습니다.", "utf-8");
			
//			return "redirect:/register/add?msg=" + msg; //URL재작성(rewriting)
			
			//위 msg를 모델로 보내는 방법도 있다.
			m.addAttribute("msg", msg);
			return "redirect:/register/add";
		}
		
		return "registerInfo";
	}

	private boolean isValid(User user) {
		return true;
	}
}
