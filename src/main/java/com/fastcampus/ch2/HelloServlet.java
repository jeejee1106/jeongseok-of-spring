package com.fastcampus.ch2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** 실행 결과
 * 처음 호출하면 아래 두 메서드가 순서대로 호출된다.
 * [HelloServlet] init() is called.
 * [HelloServlet] service() is called.
 * 
 * 새로고침을 통해 계속 호출을 하면 
 * [HelloServlet] service() is called. 만 호출이 되는 것을 확인할 수 있다.
 * 
 * 파일을 수정하고 저장하면 톰캣이 자동 리로드 되는데, 이 때
 * [HelloServlet] destroy() is called. 메서드가 호출된다.
 * 즉, 서블릿이 새로 갱신되서 리로딩 되었기 때문에 원래 쓰던 서블릿의 뒷정리를 위해 호출이 된거다.
 * 
 * 그리고 다시 /hello를 호출하면 처음의 순서로 돌아가서 아래 두 메서드가 호출되는 것을 볼 수 있다.
 * [HelloServlet] init() is called.
 * [HelloServlet] service() is called.
 */

@WebServlet("/hello") //서블릿은 무조건 클래스에 매핑을 해야함
public class HelloServlet extends HttpServlet { //서블릿은 무조건 HttpServlet 상속 받아야함
	
	@Override
	public void init() throws ServletException {
		//1. 서블릿이 초기화 될 때 자동 호출 되는 메서드 - 서블릿의 초기화 담당
		System.out.println("[HelloServlet] init() is called.");
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//2. 실제로 작업을 처리하는 메서드(입력, 처리, 출력의 3단계). 요청이 올 때마다 호출된다. 여기선 언제 호출되는지만 확인할거임
		System.out.println("[HelloServlet] service() is called.");   
	}
	
	
	@Override
	public void destroy() {
		//3. 뒷정리 - 서블릿이 메모리에서 내려올 때, 서블릿이 새로 갱신되서 리로딩 되거나, 애플리케이션이 종료될 때 호출 (즉, 서블릿이 메모리에서 제거될 때 서블릿 컨테이너에 의해서 자동 호출)
		System.out.println("[HelloServlet] destroy() is called.");
	}
}
