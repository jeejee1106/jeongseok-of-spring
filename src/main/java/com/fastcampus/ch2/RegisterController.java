package com.fastcampus.ch2;

import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegisterController {

//	@RequestMapping("/register/add") //(value="/register/add", method={RequestMethod.GET, RequestMethod.POST}) �� �����Ǿ� �ִ� ��! GET�� POST �� �� ����ϰڴ�.
//	@GetMapping("/register/add")
//	public String register() {
//		return "registerForm";
//	}
	/*
	 * ��� �� �޼���� ���� ���Ḹ ���� �� ���ٸ� ����� ���� �޼����̴�.
	 * �̷� �޼������ servlet-context.xml���Ͽ� 
	 * <view-controller path="/register/add" view-name="registerForm"/>
	 * �̷��� �� ���� �߰����ָ� �� ������ �Ⱦ��� ���� ����� �ϰ� ���� �� �ִ�.
	 * view-controller�� get��û�� ����Ѵ�!
	 * */
	

//	@RequestMapping(value="/register/save", method=RequestMethod.POST) //�Ʒ��� ������ �ڵ�!
	@PostMapping("/register/save") //PostMapping, GetMapping ������̼��� ������ 4.3����!!
	public String save(User user, Model m) throws Exception{
		//1. ��ȿ�� �˻�
		if(!isValid(user)) {
			String msg = URLEncoder.encode("id�� �߸� �Է��ϼ̽��ϴ�.", "utf-8");
			
//			return "redirect:/register/add?msg=" + msg; //URL���ۼ�(rewriting)
			
			//�� msg�� �𵨷� ������ ����� �ִ�.
			m.addAttribute("msg", msg);
			return "redirect:/register/add";
		}
		
		return "registerInfo";
	}

	private boolean isValid(User user) {
		return true;
	}
}
