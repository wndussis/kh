package kh.java.jdk.api;
/**
 * 
 * == 동등비교 연산자 
 * =>1. 기본형 값 비교할때 사용
 *     2. 참조형의 주소값 비교
 *      - true 같은 객체를 가리키고 있다.
 *      -false 다른 객체를 가리키고 있다.           
 *      
 *      String 참조형
 *      String 의 값비교는 equals 를 사용해야 한다.
 *      "abc".equals("abc")  이렇게 사용 "abc" "abc" 두 문자 비교할때
 *      1. 기본형
 *      2. 참조형
 *
 */

public class StringTest {
	public static void main(String[] args) {
//		int a = 10 , b = 20;
//		System.out.println( a == b);
//		
//		StringTest s1 = new StringTest();
//		StringTest s2 = s1;  // s1 , s2 둘이 가리키는 객체는 같다 !  ,얕은복사한것
//		
//		System.out.println(s1 == s2);
//		
//		s2 = new StringTest(); //새로운 객체를 만든것 그래서 s1 , s2 는 다름 !
//		System.out.println(s1 == s2); // 
//		System.out.println(s1.hashCode());
//		System.out.println(s2.hashCode());
		
		//문자열 값비교
		String s1 = "java";
		String s2 = new String("java");
		
//		System.out.println(s1 == s2); // 이렇게 비교하면 안됨 , 주소값 비교한것
//		System.out.println(s1.equals(s2)); // 내용비교 , 이렇게 equals 사용해서 써야함!
		
		String s3 = "java";
		System.out.println(s1 == s3); //true
	}

}
