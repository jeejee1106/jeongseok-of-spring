package com.fastcampus.ch2;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

// 필터 등록, 필터를 적용할 요청의 패턴 지정 - 모든 요청에 필터를 적용.
@WebFilter(urlPatterns="/*")
public class PerformanceFilter implements Filter {
	//필터의 수행시간을 알아보고자 만든 클래스
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// 초기화 작업
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 1. 전처리 작업
		long startTime = System.currentTimeMillis(); //서블릿을 호출한 시간

		// 2. 서블릿 또는 다음 필터를 호출
		chain.doFilter(request, response); 
		
		// 3. 후처리 작업
		HttpServletRequest req = (HttpServletRequest) request;
		String referer = req.getHeader("referer"); //어느 경로에서 요청했는가?
		String method = req.getMethod(); //어떤 방법으로 요청했는가?(GET, POST 등)
		System.out.print("[" + referer + "] -> " + method + " ["+req.getRequestURI()+"]");
		System.out.println(" 소요시간="+(System.currentTimeMillis()-startTime)+"ms");
		
		/**
		 * 2번은 고정으로 놔두고, 1,3번만 우리가 모든 서블릿 파일에 적용할 코드로 수정하면 된다.
		 * 그러면 모든 서블릿 파일이 호출되기 전과 후에 우리가 작성한 코드가 실행된다.
		 */
	}

	@Override
	public void destroy() {
		// 정리 작업
	}

}