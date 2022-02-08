package com.fastcampus.ch2;

import java.io.FileNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

//ControllerAdvice를 만들었지만 같은 클래스에 예외처리를 해주는 메서드가 있기 때문에 여기서 예외처리가 된다.

@Controller
public class ExceptionController {

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) //상태코드 200에서 500으로 바꿔주는 어노테이션
	public String catcher(Exception ex, Model model) {
//		model.addAttribute("ex", ex); //jsp에서 isErrorPage="true"를 써주면 어떤 에러인지 view에 전달해주지 않아도 된다. 그런데 상태코드가 무조건 500으로 보내줌.
		return "error";
	}
	
	@ExceptionHandler({NullPointerException.class, FileNotFoundException.class})
	public String catcher2(Exception ex, Model model) {
		model.addAttribute("ex", ex);
		return "error";
	}
	
	@RequestMapping("/ex")
	public String main() throws Exception{
		throw new Exception("예외가 발생했습니다.");
	}
	
	@RequestMapping("/ex2")
	public String main2() throws Exception{
		throw new NullPointerException("예외가 발생했습니다.");
	}
}
