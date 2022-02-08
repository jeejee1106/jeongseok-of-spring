package com.fastcampus.ch2;

import java.io.FileNotFoundException;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@ControllerAdvice //��� ��Ʈ�ѷ����� �߻��ϴ� ���ܸ� �� ó���ϰ� �ȴ�. -> �����Ű���� ����
//@ControllerAdvice("com.fastcampus.ch2") //�ش� ��Ű���� �ִ� ��Ʈ�ѷ����� ����
@ControllerAdvice("com.fastcampus.ch3") //�ش� ��Ű���� �ִ� ��Ʈ�ѷ����� ����
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
