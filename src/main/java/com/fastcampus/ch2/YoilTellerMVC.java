package com.fastcampus.ch2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//������� �Է��ϸ� ������ �˷��ִ� ���α׷��� ������.
//������ YoilTeller���α׷��� ������ ������ �̿��ؼ� ���ɻ縦 �и��غ���!
@Controller
public class YoilTellerMVC {
	
	@RequestMapping("/getYoilMVC")
	public void main(int year, int month, int day, HttpServletRequest request, HttpServletResponse response) throws IOException {

		Calendar cal = Calendar.getInstance();
		cal.set(year, month - 1, day);
		
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); //���ڷ� ��µ�. 1=��, 2=��, 3=ȭ ...
		char yoil = "�Ͽ�ȭ�������".charAt(dayOfWeek); //���ڸ� �ٽ� ���ڷ� �ٲ��ش�.
		
		//3-1. �ֿܼ� ���
//		System.out.println(year + "�� " + month + "�� " + day + "���� ");
//		System.out.println(yoil + "���� �Դϴ�.");
		
		//3-2. �������� ���
//		response.setContentType("text/html"); //����� ������ Ÿ���� ���־�� �Ѵ�. why?�������� ���� ������ ������ �ؽ�Ʈ���� ���̳ʸ����� �𸣱� ������ �˷�����Ѵ�.
//		response.setCharacterEncoding("utf-8"); //���ڵ��� �˷���� ��
//		PrintWriter out = response.getWriter(); //response��ü���� ���������� ��� ��Ʈ���� ��´�.
//												//response.getWriter()�� ���� ó���� ���־�� �ϴµ�
//												//������ �ϴ� �����ڴ�.
//		
//		out.println(year + "�� " + month + "�� " + day + "���� ");
//		out.println(yoil + "���� �Դϴ�.");
	}

}
