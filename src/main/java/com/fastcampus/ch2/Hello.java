package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//1. 원격 가능한 프로그램으로 등록하기 @Controller
@Controller
public class Hello {
	
	int iv = 10;
	static int cv = 20;
	
	//2. URL과 메서드 연결(맵핑, Mapping)
	@RequestMapping("/hello")
	private void main() {
		//접근제어자에 상관없이 원격에서 호출이 가능하다. but 당연히 자바프로젝트에서는 호출 불가! Main 클래스에서 한 번 호출해보자.(Main클래스 확인)
		
		System.out.println("Hello");
		System.out.println(iv);
		System.out.println(cv);
		
		// 공부해보자
		// 이 메서드는 인스턴스 메서드이다. 인스턴스 매서드는 객체를 생성해야 호출이 가능하다.
		// 그런데 따로 객체생성을 해준 적이 없는데 어떻게 호출이 잘 될까??
		// 답은 중간에서 누군가 객체 생성을 해주기 때문이다.
		// 누가??? 톰캣 내부에서!!!!
		
		// 근데 왜 굳이 인스턴스 메서드로 생성을 하는걸까??
		// static메서드는 cv만 사용가능한 반면 인스턴스 메서드는 cv, iv 둘 다 사용 가능하다.
		// 어떤 메서드를 써도 상관은 없지만 인스턴스 메서드를 쓰는 것이 더 효율적일 수 있다!
	}
}
