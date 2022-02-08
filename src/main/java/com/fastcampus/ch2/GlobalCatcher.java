package com.fastcampus.ch2;

import java.io.FileNotFoundException;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@ControllerAdvice //모든 컨트롤러에서 발생하는 예외를 다 처리하게 된다. -> 모든패키지에 적용
//@ControllerAdvice("com.fastcampus.ch2") //해당 패키지에 있는 컨트롤러에만 적용
@ControllerAdvice("com.fastcampus.ch3") //해당 패키지에 있는 컨트롤러에만 적용
public class GlobalCatcher {

	@ExceptionHandler(Exception.class)
	public String catcher(Exception ex, Model model) {
		model.addAttribute("ex", ex);
		return "error";
	}
	
	@ExceptionHandler({NullPointerException.class, FileNotFoundException.class})
	public String catcher2(Exception ex, Model model) {
		model.addAttribute("ex", ex);
		return "error";
	}
}
