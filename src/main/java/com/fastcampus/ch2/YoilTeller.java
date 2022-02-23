package com.fastcampus.ch2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//������� �Է��ϸ� ������ �˷��ִ� ���α׷��� ������.
@Controller
public class YoilTeller {
	
//	public static void main(String[] args) {
	@RequestMapping("/getYoil")
	public void main(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//�������� �Ķ���͸� ���ָ� 500������ ���.
		//HttpServletRequest : ������ �ִ� ������ �� �Ķ���ͷ� �ްڴ�.
		//HttpServletResponse : �������� ��� �� �� response�� �̿��ؼ� ����Ѵ�. �Ű������� ���⸸ �ϸ� ��Ĺ�� �� �ʰ� �ʿ��ϱ���?�ϰ� �˾Ƽ� �ش�.
		
		//1. �Է�
		String year = request.getParameter("year"); //�Ķ���ʹ� ��(����)���� �Ѱ��ش�
		String month = request.getParameter("month"); //ex) http://localhost:9000/ch2/getYoil?year=1995&month=11&day=6
		String day = request.getParameter("day");     //����ǥ �ڿ� ���� �͵��� �Ķ���� ��� �����ϸ� �� �� ����.
		
		//�� ���ڿ��� ���ڷ� �ٲ��ش�.
		int yyyy = Integer.parseInt(year);
		int mm = Integer.parseInt(month);
		int dd = Integer.parseInt(day);
		
		//2. ó���۾� - ��¥ ����
		Calendar cal = Calendar.getInstance();
		cal.set(yyyy, mm - 1, dd);
		
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); //������ ���ڷ� ��µ�. 1=��, 2=��, 3=ȭ ...
		char yoil = " �Ͽ�ȭ�������".charAt(dayOfWeek); //���ڸ� �ٽ� ���ڷ� �ٲ��ش�.
		
		//3-1. �ֿܼ� ���
//		System.out.println(year + "�� " + month + "�� " + day + "���� ");
//		System.out.println(yoil + "���� �Դϴ�.");
		
		//3-2. �������� ���
		response.setContentType("text/html"); //����� ������ Ÿ���� ���־�� �Ѵ�. why?�������� ���� ������ ������ �ؽ�Ʈ���� ���̳ʸ����� �𸣱� ������ �˷�����Ѵ�.
		response.setCharacterEncoding("utf-8"); //���ڵ��� �˷���� ��
		PrintWriter out = response.getWriter(); //response��ü���� ���������� ��� ��Ʈ���� ��´�.
												//response.getWriter()�� ���� ó���� ���־�� �ϴµ�
												//������ �ϴ� �����ڴ�.
		
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println(year + "�� " + month + "�� " + day + "���� ");
		out.println(yoil + "���� �Դϴ�.");
		out.println("</body>");
		out.println("</html>");
	}
	/*
	 * ���� �� �ڵ�� �ϳ��� �޼��� �ȿ� 3���� ���ɻ�(�Է�, ó��, ���)�� ���ÿ� �����ǰ� �ִ�.
	 * �츮�� �� ���ɻ���� �и����� �ʿ䰡 �ִ�.
	 * */
}