package com.fastcampus.ch2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//������� �Է��ϸ� ������ �˷��ִ� ���α׷��� ������.
//���ɻ縦 �и��غ���! (�����, )
@Controller
public class YoilTellerMVC {
	
	@RequestMapping("/getYoilMVC")
	public String main(int year, int month, int day, Model model) throws IOException {
		/**
		 * HttpServletRequest�� �����͸� �޴� ���, ���� year, month, day�� ���� �� �ִ�.
		 * �� �� String�� �ƴ� int Ÿ������ ���� �� �ִµ�, ������Ʈ���� StringŸ���� DispatcherServlet�� �ڵ����� intŸ������ ��ȯ���ֱ� �����̴�.
		 * 
		 * ���� Model�� �����͸� ��� view�� �������ϱ� ������ HttpServletResponse�� �ʿ䰡 ����, Model��ü�� �޾��ش�.
		 * Model���� DispatcherServlet�� ���� Controller�� �����ش�!
		 */
		
		
		//����� isValid�� true�� ���� �� �Ķ���͸� �ȳѱ�� 500����(��������) ��
		//why? getYoilMVC2 �������� ��������, ����� �Ķ���Ͱ� �ʼ� �Է��� �ƴ� ���´�(required=false).
		//�׷��� ������ Ŭ���̾�Ʈ�� �Ķ���͸� �ѱ��� �ʾƵ� �ȴ�.
		//�׷� �Ķ���� �κп� null���� ������ �Ǵµ�, null�� intŸ������ �ٲ� �� ���� ������ ���������� ����.
		
		//1. ��ȿ�� �˻�
		if(!isValid(year, month, day)) {
			return "yoilError";
		}
		
		//2. ���� ���
		char yoil = getYoil(year, month, day);
		
		//3. ����� ����� model�� ����
		//model�� ��Ʈ�ѷ��� �� ���̿��� �����͸� �������ִ� ������ �Ѵ�.
		model.addAttribute("year", year);
		model.addAttribute("month", month);
		model.addAttribute("day", day);
		model.addAttribute("yoil", yoil);
		
		return "yoil"; //view�� ��� ��ȯ
					   //servlet-context.xml���Ͽ� prefix(���λ� : /WEB-INF/views/)�� suffix��(���̻� : .jsp) �̿��� view�� ��θ� �����Ѵ�.
		
	}

	private boolean isValid(int year, int month, int day) {
		return true; //false�� �θ� ������ yoilError �������� �Ѿ��!!!! �ϴ� ��ȿ�� �˻縦 �����ϰ� true, false�� �غ�
					 //true�� �θ� yoil�������� �Ѿ��.
	}

	private char getYoil(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month - 1, day);
		
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); //���ڷ� ��µ�. 1=��, 2=��, 3=ȭ ...
		return " �Ͽ�ȭ�������".charAt(dayOfWeek); //���ڸ� �ٽ� ���ڷ� �ٲ��ش�.
	}
}