package com.fastcampus.ch2;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST) //400에러로 바꿔주기
class MyException extends RuntimeException {
	MyException(String msg){
		super(msg);
	}
	
	MyException() {
		this("");
	}
}



//아래는 ExceptionController와 완전히 같은 코드.
//이렇게 비슷한 예외를 여러 컨트롤러에서 처리해야하는 경우 아예 예외처리 컨트롤러를 새로 만들어주는 것이 좋다.
//ex3을 호출하면 에러가 나야하지만 GlobalCatcher클래스(컨트롤러)에서 처리를 해주기 때문에 예외를 처리한 error.jsp로 이동하게 된다.
@Controller
public class ExceptionController2 {

	@RequestMapping("/ex3")
	public String main() throws Exception{
		throw new MyException("예외가 발생했습니다.");
	}
	
	@RequestMapping("/ex4")
	public String main2() throws Exception{
		throw new NullPointerException("예외가 발생했습니다.");
	}
}
