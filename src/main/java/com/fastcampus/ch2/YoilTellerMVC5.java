//package com.fastcampus.ch2;
//
//import java.io.IOException;
//import java.util.Calendar;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//
////YoilTellerMVC2 + ����!
//@Controller
//public class YoilTellerMVC5 {
//	
//	@ExceptionHandler(Exception.class)
//	public String catcher(Exception e) {
//		e.printStackTrace();
//		return "yoilError";
//	}
//	
//	// 2�� ����ó�� �Ķ���͸� �ϳ��ϳ� ���� ���� �������� ���� ���� �������� �ڵ尡 ������ٴ� ���̴�.
//	// �̷� �� Ŭ������ �ϳ� ���� 
//	@RequestMapping("/getYoilMVC5")
//	//public String main(@ModelAttribute("myDate") MyDate date, Model model) throws IOException { //�� �ٰ� ���� �ǹ�! ���� �ϸ� �ڵ����� Ÿ���� ù���ڸ� �ҹ��ڷ� �ٲ㼭 key�� ����Ѵ�.
//	public String main(@ModelAttribute MyDate date, Model model) throws IOException {
//
//		//1. ��ȿ�� �˻�
//		if(!isValid(date)) {
//			return "yoilError"; //��, ��, ���� ��ȿ���� ������ WEB-INF/views/yoilError.jsp�� �����ְڴ�!
//		}
//		
//		//2. ó�� - ���� ���
////		char yoil = getYoil(date);
//		
//		//3. ����� ����� model�� ����
////		model.addAttribute("myDate", date);
////		model.addAttribute("yoil", yoil);
//		
//		return "yoil"; // /WEB-INF/views/yoil.jsp�� �̿��ؼ� ������� �����ְڴ� ��� ��!
//					   // �ٵ� ��ο� Ȯ���� �κ��� �Ź� �Ȱ����ϱ� ����� �κ��� ���� view�̸��� ������ �ϴ� ��!
//		
//	}
//
//	private boolean isValid(MyDate date) {
//		return isValid(date.getYear(), date.getMonth(), date.getDay());
//	}
//
//	private @ModelAttribute("yoil") char getYoil(MyDate date) {
//		return getYoil(date.getYear(), date.getMonth(), date.getDay());
//	}
//
//	private boolean isValid(int year, int month, int day) {
//		return true;
//	}
//
//	private char getYoil(int year, int month, int day) {
//		Calendar cal = Calendar.getInstance();
//		cal.set(year, month - 1, day);
//		
//		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); //���ڷ� ��µ�. 1=��, 2=��, 3=ȭ ...
//		return "�Ͽ�ȭ�������".charAt(dayOfWeek); //���ڸ� �ٽ� ���ڷ� �ٲ��ش�.
//	}
//}
