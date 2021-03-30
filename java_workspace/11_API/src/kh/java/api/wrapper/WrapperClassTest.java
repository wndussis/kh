package kh.java.api.wrapper;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * WrapperClass
 * 
 * 기본형에 대응하는 참조형 클래스
 * java.lang 패키지에 존재
 * 기본형(값)을 감싼 형태이기 때문에 wrapper 라고 부른다.
 * 
 * 1. 기본형을 참조형으로 사용해야할 때 사용한다.
 * 2. 기본형 관련된 메소드 혹은 상수를 사용하고자 할때.
 * 
 * 
 *
 */
public class WrapperClassTest {

	public static void main(String[] args) {
		WrapperClassTest wc = new WrapperClassTest();
//		wc.test1();
		wc.test2();
		
	}
	/**
	 * WrapperClass 는 형변환 static 메소드 지원.
	 * 문자열 데이터를 각각의 타입으로 변환.
	 */
	public void test2() {
		int i = Integer.parseInt("100");
		System.out.println( i * 100);
		
		double d = Double.parseDouble("123.456");
		System.out.println(d * 100);
		
		boolean bool = Boolean.parseBoolean("true");
		System.out.println(!bool); // false 출력됨
		
		char ch = "abc".charAt(0);
		System.out.println((int)ch); //숫자로 변환
		
		
	}
	/**
	 * boolean - Boolean
	 * 
	 * char - Character
	 * 
	 * byte - Byte
	 * short - Short
	 * int - Integer
	 * long - Long
	 * 
	 * float - Float
	 * double -Double
	 * 
	 */
	public void test1() {
		
		int num = 100;
		Integer i = new Integer(100);  // 이렇게 선언함
		
		//auto-boxing :  기본형을 Wrapper에 담음
		//auto-unboxing : Wrapper에 있는걸 기본형으로 가져오는것
		
		
		System.out.println(num + i);
		System.out.println(num + i.intValue()); // 오토 언박싱 , 위에꺼 처럼 쓰면됨
		
		Integer j = 3;
//		Integer j = new Integer(3); // 오토 박싱 ,위에꺼처럼 쓰면됨
		
		System.out.println(j == 3); // 
		System.out.println(j.intValue() == 3);
		System.out.println(j.hashCode());
		System.out.println(Integer.MAX_VALUE);
		
		// Generics 기본형이 아닌 참조형만 써야하는 경우
//		List<int> list = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		
	}

}
