package com.fastcampus.ch2;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST) //400������ �ٲ��ֱ�
class MyException extends RuntimeException {
	MyException(String msg){
		super(msg);
	}
	
	MyException() {
		this("");
	}
}



//�Ʒ��� ExceptionController�� ������ ���� �ڵ�.
//�̷��� ����� ���ܸ� ���� ��Ʈ�ѷ����� ó���ؾ��ϴ� ��� �ƿ� ����ó�� ��Ʈ�ѷ��� ���� ������ִ� ���� ����.
//ex3�� ȣ���ϸ� ������ ���������� GlobalCatcherŬ����(��Ʈ�ѷ�)���� ó���� ���ֱ� ������ ���ܸ� ó���� error.jsp�� �̵��ϰ� �ȴ�.
@Controller
public class ExceptionController2 {

	@RequestMapping("/ex3")
	public String main() throws Exception{
		throw new MyException("���ܰ� �߻��߽��ϴ�.");
	}
	
	@RequestMapping("/ex4")
	public String main2() throws Exception{
		throw new NullPointerException("���ܰ� �߻��߽��ϴ�.");
	}
}
