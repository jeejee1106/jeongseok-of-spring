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

// ���� ���, ���͸� ������ ��û�� ���� ���� - ��� ��û�� ���͸� ����.
@WebFilter(urlPatterns="/*")
public class PerformanceFilter implements Filter {
	//������ ����ð��� �˾ƺ����� ���� Ŭ����
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// �ʱ�ȭ �۾�
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 1. ��ó�� �۾�
		long startTime = System.currentTimeMillis(); //������ ȣ���� �ð�

		// 2. ���� �Ǵ� ���� ���͸� ȣ��
		chain.doFilter(request, response); 
		
		// 3. ��ó�� �۾�
		HttpServletRequest req = (HttpServletRequest) request;
		String referer = req.getHeader("referer"); //��� ��ο��� ��û�ߴ°�?
		String method = req.getMethod(); //� ������� ��û�ߴ°�?(GET, POST ��)
		System.out.print("[" + referer + "] -> " + method + " ["+req.getRequestURI()+"]");
		System.out.println(" �ҿ�ð�="+(System.currentTimeMillis()-startTime)+"ms");
		
		/**
		 * 2���� �������� ���ΰ�, 1,3���� �츮�� ��� ���� ���Ͽ� ������ �ڵ�� �����ϸ� �ȴ�.
		 * �׷��� ��� ���� ������ ȣ��Ǳ� ���� �Ŀ� �츮�� �ۼ��� �ڵ尡 ����ȴ�.
		 */
	}

	@Override
	public void destroy() {
		// ���� �۾�
	}

}