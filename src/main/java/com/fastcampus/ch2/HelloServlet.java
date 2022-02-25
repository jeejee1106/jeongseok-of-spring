package com.fastcampus.ch2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** ���� ���
 * ó�� ȣ���ϸ� �Ʒ� �� �޼��尡 ������� ȣ��ȴ�.
 * [HelloServlet] init() is called.
 * [HelloServlet] service() is called.
 * 
 * ���ΰ�ħ�� ���� ��� ȣ���� �ϸ� 
 * [HelloServlet] service() is called. �� ȣ���� �Ǵ� ���� Ȯ���� �� �ִ�.
 * 
 * ������ �����ϰ� �����ϸ� ��Ĺ�� �ڵ� ���ε� �Ǵµ�, �� ��
 * [HelloServlet] destroy() is called. �޼��尡 ȣ��ȴ�.
 * ��, ������ ���� ���ŵǼ� ���ε� �Ǿ��� ������ ���� ���� ������ �������� ���� ȣ���� �ȰŴ�.
 * 
 * �׸��� �ٽ� /hello�� ȣ���ϸ� ó���� ������ ���ư��� �Ʒ� �� �޼��尡 ȣ��Ǵ� ���� �� �� �ִ�.
 * [HelloServlet] init() is called.
 * [HelloServlet] service() is called.
 */

@WebServlet("/hello") //������ ������ Ŭ������ ������ �ؾ���
public class HelloServlet extends HttpServlet { //������ ������ HttpServlet ��� �޾ƾ���
	
	@Override
	public void init() throws ServletException {
		//1. ������ �ʱ�ȭ �� �� �ڵ� ȣ�� �Ǵ� �޼��� - ������ �ʱ�ȭ ���
		System.out.println("[HelloServlet] init() is called.");
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//2. ������ �۾��� ó���ϴ� �޼���(�Է�, ó��, ����� 3�ܰ�). ��û�� �� ������ ȣ��ȴ�. ���⼱ ���� ȣ��Ǵ����� Ȯ���Ұ���
		System.out.println("[HelloServlet] service() is called.");   
	}
	
	
	@Override
	public void destroy() {
		//3. ������ - ������ �޸𸮿��� ������ ��, ������ ���� ���ŵǼ� ���ε� �ǰų�, ���ø����̼��� ����� �� ȣ�� (��, ������ �޸𸮿��� ���ŵ� �� ���� �����̳ʿ� ���ؼ� �ڵ� ȣ��)
		System.out.println("[HelloServlet] destroy() is called.");
	}
}
