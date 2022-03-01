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

	@ExceptionHandler(Exception.class) //어떤 예외가 발생했을 때 이 메서드를 호출할건지 적어준다.
	//이 메서드가 실행되어 예외처리가 잘 되면 error.jsp를 보여준다. 그렇기 때문에 잘 처리 되었다는 200상태코드가 나타나는데, 그래도 예외는 예외이니 예외가 발생되었다는 상태코드로 바꿔주어야 한다.
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) //상태코드 200에서 500으로 바꿔주는 어노테이션
	public String catcher(Exception ex, Model model) {
//		model.addAttribute("ex", ex); //jsp에서 isErrorPage="true"를 써주면 어떤 에러인지 view에 전달해주지 않아도 된다. 그런데 상태코드가 무조건 500으로 보내줌.
		return "error";
	}
	
	@ExceptionHandler({NullPointerException.class, FileNotFoundException.class}) //하나의 핸들러 메서드로 두 개 이상의 예외를 처리하고 싶을 땐 이렇게 배열로 써주면 된다.
	public String catcher2(Exception ex, Model model) {
		model.addAttribute("ex", ex);
		return "error";
	}
	
	@RequestMapping("/ex")
	public String main() throws Exception{
		throw new Exception("예외가 발생했습니다."); //이 예외를 try-catch블럭으로 처리해 줄 수도 있지만, 예외 처리 메서드를 하나 만들어서 예외가 발생했을 때 그 메서드에서 처리하게 한다.
	}
	
	@RequestMapping("/ex2")
	public String main2() throws Exception{
		throw new NullPointerException("예외가 발생했습니다."); //이 예외를 try-catch블럭으로 처리해 줄 수도 있지만, 예외 처리 메서드를 하나 만들어서 예외가 발생했을 때 그 메서드에서 처리하게 한다.
	}
}
