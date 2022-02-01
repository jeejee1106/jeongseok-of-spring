package com.fastcampus.ch2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
	
	@Override
	public void init() throws ServletException {
		//������ �ʱ�ȭ �� �� �ڵ� ȣ��Ǵ� �޼���
		//1. ������ �ʱ�ȭ �۾� ��� - ó�� �� ���� ȣ�� �ȴ�.
		System.out.println("[HelloServlet] init() is called.");
	}

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		super.service(arg0, arg1);
		// ��û�� �� �� ���� ȣ��ȴ�.
		// 1. �Է�
		// 2. ó��
		// 3. ���
		System.out.println("[HelloServlet] service() is called.");
	}

	@Override
	public void destroy() {
		// ������ �޸𸮿��� ���ŵ� �� ���� �����̳ʿ� ���ؼ� �ڵ� ȣ��, ������ ���ŵǼ� ���ε� �ǰų�, �� ���ø����̼��� ����� �� ������ ���õ� �޸����� �۾��� �ϱ� ���� ȣ��ȴ�.
		System.out.println("[HelloServlet] destroy() is called.");
	}


}
