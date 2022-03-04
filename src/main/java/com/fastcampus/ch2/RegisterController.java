package com.fastcampus.ch2;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/register")
public class RegisterController {
	
	@InitBinder //�ش� ��Ʈ�ѷ� �������� ������ �ȴ�.
	public void toDate(WebDataBinder binder) {
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd"); //UserŬ������ �ʵ忡 @DateTimeFormat�� ����� ���� �ִ�.
//		binder.registerCustomEditor(Date.class, new CustomDateEditor(df, false));
		
		binder.registerCustomEditor(String[].class, new StringArrayPropertyEditor("#")); //�������� �����ϴ� ���. ���ڿ� �߶� �迭�� �ֱ�
//		binder.registerCustomEditor(String[].class, "hobby", new StringArrayPropertyEditor("#")); //�̷��� Ư�� �ʵ忡�� ������ ���� �ִ�.
		
		binder.setValidator(new UserValidator()); //UserValidator�� WebDataBinder�� ���� validator�� ��� - �ڵ� ������ ����??
		
//		binder.addValidators(new UserValidator());
		List<Validator> validatorList =  binder.getValidators();
		System.out.println("validatorList = " + validatorList);
	}

//	@RequestMapping("/register/add") //(value="/register/add", method={RequestMethod.GET, RequestMethod.POST}) �� �����Ǿ� �ִ� ��! GET�� POST �� �� ����ϰڴ�. �Ʒ��� ������ �ڵ�
	@RequestMapping(value="/add", method={RequestMethod.GET, RequestMethod.POST}) 
//	@GetMapping("/register/add")
	public String register() {
		return "registerForm";
	}
	/*
	 * ��� �� �޼���� ���� ���Ḹ ���� �� ���ٸ� ����� ���� �޼����̴�.
	 * �̷� �޼������ servlet-context.xml���Ͽ� 
	 * <view-controller path="/register/add" view-name="registerForm"/>
	 * �̷��� �� ���� �߰����ָ� �� ������ �Ⱦ��� ���� ����� �ϰ� ���� �� �ִ�.
	 * view-controller�� get��û�� ����Ѵ�!
	 * �� �� �ϳ��� �����. �� �� �ϳ��� �� �ּ��ϱ�!
	 * */
	

//	@RequestMapping(value="/register/save", method=RequestMethod.POST) //�Ʒ��� ������ �ڵ�!
	@PostMapping("/save") //PostMapping, GetMapping ������̼��� ������ 4.3����!!
	public String save(@Valid User user, BindingResult result, Model m) throws Exception{
		System.out.println("result = " + result);
		System.out.println("user = " + user);
		
		//user��ü�� �ùٸ� Ÿ���� ���� �����ϴ°ǰ�...?...?
		//���� ���� - Validator�� ���� �����ϰ�, validate()�� ���� ȣ��
//		UserValidator userValidator = new UserValidator();
//		userValidator.validate(user, result); //BindingResult�� Errors�� �ڼ�
		
		//User��ü�� ������ ��� ������ ������ registerForm�� �̿��ؼ� ������ ���������
		if(result.hasErrors()) {
			return "registerForm";
		}
		
//		//1. ��ȿ�� �˻�
//		if(!isValid(user)) {
//			String msg = URLEncoder.encode("id�� �߸� �Է��ϼ̽��ϴ�.", "utf-8"); //��Ʈ�ѷ����� ���� URL�� �ѱ��� ������ �������� ���ڵ��� ���� �� ��� ���⼭ ���ڵ��� ���־���Ѵ�.
//			
////			return "redirect:/register/add?msg=" + msg; //URL���ۼ�(rewriting)
//			
//			//�� msg�� �𵨷� ������ ����� �ִ�. �� ���ٰ� ���� �ڵ�
//			m.addAttribute("msg", msg);
//			return "forward:/register/add";
//		}
		
		return "registerInfo";
	}

	private boolean isValid(User user) {
		return true;
	}
}
