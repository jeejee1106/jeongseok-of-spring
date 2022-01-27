package com.fastcampus.ch2;

import java.lang.reflect.Method;

public class PrivateMethodCall {

	public static void main (String[] args) throws Exception {
//		Hello hello = new Hello();
//		hello.main(); //private라서 외부에선 호출이 불가능
		
		// 그럼 어떻게 원격 프로그램에서는 private라도 호출이 가능했던 걸까??
		// Reflection API를 사용했기 때문이다 - 클래스 정보를 얻고 다룰 수 있는 강력한 기능 제공
		// java.lang.reflect 라는 패키지를 제공해준다.
		
		// Reflection API를 사용해 객체를 생성하고 메서드를 호출해보자
		
		// 1. 먼저 클래스에 대한 정보를 얻어와야 한다. - Class객체 : 클래스의 정보를 담고 있는 객체
		Class helloClass = Class.forName("com.fastcampus.ch2.Hello");
		Hello hello = (Hello)helloClass.newInstance(); //Class객체가 가진 정보로 객체 생성
		Method main = helloClass.getDeclaredMethod("main"); //main이라는 메서드에 대한 정보를 가져온다.
		main.setAccessible(true); //private인 main()을 호출 가능하게 한다.
		
		main.invoke(hello); //hello.main()을 호출한 것과 같다.
	}
}
