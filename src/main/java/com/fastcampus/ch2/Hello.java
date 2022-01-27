package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//1. ���� ������ ���α׷����� ����ϱ� @Controller
@Controller
public class Hello {
	
	int iv = 10;
	static int cv = 20;
	
	//2. URL�� �޼��� ����(����, Mapping)
	@RequestMapping("/hello")
	private void main() {
		//���������ڿ� ������� ���ݿ��� ȣ���� �����ϴ�. but �翬�� �ڹ�������Ʈ������ ȣ�� �Ұ�! Main Ŭ�������� �� �� ȣ���غ���.(MainŬ���� Ȯ��)
		
		System.out.println("Hello");
		System.out.println(iv);
		System.out.println(cv);
		
		// �����غ���
		// �� �޼���� �ν��Ͻ� �޼����̴�. �ν��Ͻ� �ż���� ��ü�� �����ؾ� ȣ���� �����ϴ�.
		// �׷��� ���� ��ü������ ���� ���� ���µ� ��� ȣ���� �� �ɱ�??
		// ���� �߰����� ������ ��ü ������ ���ֱ� �����̴�.
		// ����??? ��Ĺ ���ο���!!!!
		
		// �ٵ� �� ���� �ν��Ͻ� �޼���� ������ �ϴ°ɱ�??
		// static�޼���� cv�� ��밡���� �ݸ� �ν��Ͻ� �޼���� cv, iv �� �� ��� �����ϴ�.
		// � �޼��带 �ᵵ ����� ������ �ν��Ͻ� �޼��带 ���� ���� �� ȿ������ �� �ִ�!
	}
}
