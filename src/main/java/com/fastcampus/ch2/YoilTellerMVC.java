//package com.fastcampus.ch2;
//
//import java.io.IOException;
//import java.util.Calendar;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RequestMapping;
//
////������� �Է��ϸ� ������ �˷��ִ� ���α׷��� ������.
////������ YoilTeller���α׷��� ������ ������ �̿��ؼ� ���ɻ縦 �и��غ���!
//@Controller
//public class YoilTellerMVC {
//	
//	@ExceptionHandler(Exception.class)
//	public String catcher(Exception e) {
//		e.printStackTrace(); //� �������� ��� �� �� �ִ� �޼���
//		return "yoilError";
//	}
//	
//	@RequestMapping("/getYoilMVC")
//	public String main(int year, int month, int day, Model model) throws IOException {
//
//		//1. ��ȿ�� �˻�
//		if(!isValid(year, month, day)) {
//			return "yoilError"; //��, ��, ���� ��ȿ���� ������ WEB-INF/views/yoilError.jsp�� �����ְڴ�!
//		}
//		
//		//2. ���� ���
//		char yoil = getYoil(year, month, day);
//		
//		//3. ����� ����� model�� ����
//		model.addAttribute("year", year);
//		model.addAttribute("month", month);
//		model.addAttribute("day", day);
//		model.addAttribute("yoil", yoil);
//		
//		return "yoil"; // /WEB-INF/views/yoil.jsp�� �̿��ؼ� ������� �����ְڴ� ��� ��!
//					   // �ٵ� ��ο� Ȯ���� �κ��� �Ź� �Ȱ����ϱ� ����� �κ��� ���� view�̸��� ������ �ϴ� ��!
//		
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
package com.fastcampus.ch2;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class YoilTellerMVC {
    @RequestMapping("/getYoilMVC") // http://localhost/ch2/getYoilMVC
    public String main(int year, int month, int day, Model model) {
 
        // 1. ��ȿ�� �˻�
    	if(!isValid(year, month, day)) 
    		return "yoilError";  // ��ȿ���� ������, /WEB-INF/views/yoilError.jsp�� �̵�
    	
        // 2. ó��
    	char yoil = getYoil(year, month, day);

        // 3. Model�� �۾� ��� ����
        model.addAttribute("year", year);
        model.addAttribute("month", month);
        model.addAttribute("day", day);
        model.addAttribute("yoil", yoil);
        
        // 4. �۾� ����� ������ View�� �̸��� ��ȯ
        return "yoil"; // /WEB-INF/views/yoil.jsp
    }
    
    private char getYoil(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, day);

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        return " �Ͽ�ȭ�������".charAt(dayOfWeek);
    }
    
    private boolean isValid(int year, int month, int day) {    
    	if(year==-1 || month==-1 || day==-1) 
    		return false;
    	
    	return (1<=month && month<=12) && (1<=day && day<=31); // ������ üũ 
    }
}