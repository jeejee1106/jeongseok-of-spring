package com.fastcampus.ch2;

import java.lang.reflect.Method;

public class PrivateMethodCall {

	public static void main (String[] args) throws Exception {
//		Hello hello = new Hello();
//		hello.main(); //private�� �ܺο��� ȣ���� �Ұ���
		
		// �׷� ��� ���� ���α׷������� private�� ȣ���� �����ߴ� �ɱ�??
		// Reflection API�� ����߱� �����̴� - Ŭ���� ������ ��� �ٷ� �� �ִ� ������ ��� ����
		// java.lang.reflect ��� ��Ű���� �������ش�.
		
		// Reflection API�� ����� ��ü�� �����ϰ� �޼��带 ȣ���غ���
		
		// 1. ���� Ŭ������ ���� ������ ���;� �Ѵ�. - Class��ü : Ŭ������ ������ ��� �ִ� ��ü
		Class helloClass = Class.forName("com.fastcampus.ch2.Hello");
		Hello hello = (Hello)helloClass.newInstance(); //Class��ü�� ���� ������ ��ü ����
		Method main = helloClass.getDeclaredMethod("main"); //main�̶�� �޼��忡 ���� ������ �����´�.
		main.setAccessible(true); //private�� main()�� ȣ�� �����ϰ� �Ѵ�.
		
		main.invoke(hello); //hello.main()�� ȣ���� �Ͱ� ����.
	}
}
