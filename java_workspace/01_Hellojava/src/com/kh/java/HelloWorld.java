package com.kh.java; //패키지는 최상단에 와야함

import com.kh.java.other.OtherJava; // 클래스 선언문 전에 import문을  작성해야함
//java.lang 패키지의 모든 클래스는 import문 없이 사용이 가능
import java.lang.*;  //ㅡ> java.lang 패키지에 있는 모든 클래스를 의미한다.
import java.util.Date;

                     //위에 * 의미는 '전부,모두' 라는 뜻 
/**
 * 
 * '/**' 이 표시는 javadoc 주석 (클래스, 메소드 레벨에 작성)
 * 지금은 주석 클래스 레벨에 작성한 것
 * 
 * 
 * 여기서 지금 패키지명은 com.kh.java
 * 클래스명은 HelloWorld
 * 
 * 실제 클래스명 : package + class
 * 
 * 클래스명 =대문자
 * 메소드,패키지명 = 소문자 사용
 * 
 * 
 * 그래서 여기서 실제 클래스명은  com.kh.java.HelloWorld
 * 
 * 같은 패키지안에 동일한 이름의 클래스는 존재할 수 없다.
 * 다른 패키지안의 동일한 이름의 클래스는 존재할 수 있다.
 * 
 * 
 * 패키지란?
 * 보통 성격이 같은 클래스의 모음
 * 패키지는 겹치지 않도록 보통 도메인을 거꾸로 사용한다.
 * ex: com.kh.HelloWorld
 * 패키지는 고유하게 관리하기 위해 3레벨 이상을 추천한다.  com.naver.www
 *
 * 
 *
 *
 */
public class HelloWorld {
	
	/**지금은 주석을 메소드 위에다 썼으니까 메소드 레벨에 주석을 쓴것
	 * 
	 * 중요!!!!!!실행 코드는 무조건 메소드 안에 있어야 한다!!!!!
	 * 
	 * 
	 * 아래는 프로그램의 첫 실행 메소드
	 * 
	 * 객체 지향 언어 
	 * 객체란 ? 메모리에 적재된 데이터 저장 공간
	 * 
	 * 객체 레시피 
	 * 클래스명  변수명 = new 클래스명(); ㅡ> 객체 만드는 법
	 * 
	 */
	//바로 아래 문단은  메인 메소드 만든것
	public static void main(String[] args) {
		
//		System.out.println("Hello world~");  저렇게 앞에 더블 슬래쉬 하면 실행이 안됨.
//		System.out.println("안녕!");           즉 결과물이 안나옴 안녕 이런것들.
//	    System.out.println("반가워!!!");
		
		
	    //클래스를 객체로 만든다
		
		HelloWorld hw = new HelloWorld();
		hw.test1(); // 메소드 호출부
		hw.test2();
		
		
		KHJava kh = new KHJava();  // KHJava 클래스를 객체로 만든것 , 클래스를 객체로 만들면 다른 클래스의 것도 가져다 쓸수 있음.
		kh.welcome();  
		
		//다른 패키지의 클래스 가져다 쓰는 경우 import문이 필요.
		OtherJava oj = new OtherJava(); // OtherJava 클래스를 객체로 만듬
	    oj.callMe();  // callMe 메소드 호출
	    
	    
	    //jdk 제공 클래스 사용하기
	     java.util.Date now = new Date();// import문 없이 사용하려면
	    // java.util.Date now = new java.util.Date(); 이렇게 하면 됨
         System.out.println(now);
         
         //java.sql.Date , java.util.Date 를 동시에 써야한다면 import문으로는 사용불가
         
        java.sql.Date today = new java.sql.Date(System.currentTimeMillis());
        System.out.println(today);
	    
	    
	    
		

		
		
		//System.out.println("메인 메소드 출력!");
		
		
	}
	
	// 괄호 () 바로 앞에 있는게 메소드명 , 여기선 test1 이 메소드명
	// 메소드 선언부는 어디에 쓰던 순서가 중요하지 않다, 선언만 하면 된다.
	// 동일한 이름의 메소드를 선언 할수 없다.
	// 이건 메소드 선언부 , 이렇게 선언을 했기 때문에 메소드를 호출 할수 있는것이다.
	public void test1() {
		//아래 시스템은 Java.lang.system 에 있는 시스템이다
		System.out.println("test1 호출!");
	}
	
	public void test2() {
		System.out.println("test2 호출!");
		
	}
		
	
	

}
