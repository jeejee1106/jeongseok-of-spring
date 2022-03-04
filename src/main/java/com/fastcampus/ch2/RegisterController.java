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
	
	@InitBinder //해당 컨트롤러 내에서만 적용이 된다.
	public void toDate(WebDataBinder binder) {
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd"); //User클래스의 필드에 @DateTimeFormat를 사용할 수도 있다.
//		binder.registerCustomEditor(Date.class, new CustomDateEditor(df, false));
		
		binder.registerCustomEditor(String[].class, new StringArrayPropertyEditor("#")); //스프링이 제공하는 기능. 문자열 잘라서 배열에 넣기
//		binder.registerCustomEditor(String[].class, "hobby", new StringArrayPropertyEditor("#")); //이렇게 특정 필드에만 적용할 수도 있다.
		
		binder.setValidator(new UserValidator()); //UserValidator를 WebDataBinder의 로컬 validator로 등록 - 자동 검증을 위해??
		
//		binder.addValidators(new UserValidator());
		List<Validator> validatorList =  binder.getValidators();
		System.out.println("validatorList = " + validatorList);
	}

//	@RequestMapping("/register/add") //(value="/register/add", method={RequestMethod.GET, RequestMethod.POST}) 이 생략되어 있는 것! GET과 POST 둘 다 허용하겠다. 아래와 동일한 코드
	@RequestMapping(value="/add", method={RequestMethod.GET, RequestMethod.POST}) 
//	@GetMapping("/register/add")
	public String register() {
		return "registerForm";
	}
	/*
	 * 사실 위 메서드는 매핑 연결만 해줄 뿐 별다른 기능이 없는 메서드이다.
	 * 이런 메서드들은 servlet-context.xml파일에 
	 * <view-controller path="/register/add" view-name="registerForm"/>
	 * 이렇게 한 줄을 추가해주면 위 네줄을 안쓰고도 같은 기능을 하게 만들 수 있다.
	 * view-controller는 get요청만 허락한다!
	 * 둘 중 하나만 써야함. 둘 중 하나는 꼭 주석하기!
	 * */
	

//	@RequestMapping(value="/register/save", method=RequestMethod.POST) //아래와 동일한 코드!
	@PostMapping("/save") //PostMapping, GetMapping 어노태이션은 스프링 4.3부터!!
	public String save(@Valid User user, BindingResult result, Model m) throws Exception{
		System.out.println("result = " + result);
		System.out.println("user = " + user);
		
		//user객체에 올바른 타입이 들어갔나 검증하는건가...?...?
		//수동 검증 - Validator를 직접 생성하고, validate()를 직접 호출
//		UserValidator userValidator = new UserValidator();
//		userValidator.validate(user, result); //BindingResult는 Errors의 자손
		
		//User객체를 검증한 결과 에러가 있으면 registerForm을 이용해서 에러를 보여줘야함
		if(result.hasErrors()) {
			return "registerForm";
		}
		
//		//1. 유효성 검사
//		if(!isValid(user)) {
//			String msg = URLEncoder.encode("id를 잘못 입력하셨습니다.", "utf-8"); //컨트롤러에서 직접 URL에 한글을 보내면 브라우저가 인코딩을 해줄 수 없어서 여기서 인코딩을 해주어야한다.
//			
////			return "redirect:/register/add?msg=" + msg; //URL재작성(rewriting)
//			
//			//위 msg를 모델로 보내는 방법도 있다. 위 한줄과 같은 코드
//			m.addAttribute("msg", msg);
//			return "forward:/register/add";
//		}
		
		return "registerInfo";
	}

	private boolean isValid(User user) {
		return true;
	}
}
