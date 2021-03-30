package kh.java.method;

import java.util.Scanner;

public class MethodTest {
	
	public static void main(String[] args) {
		
		MethodTest m = new MethodTest();
		m.test1();
		m.test2();
				
		
	}
	
	public void test2() {
		
		int num1 = inputNumber();
		
	
		int num2 = inputNumber();
		
		System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
		
		
		
	}
	
	/**
	 * 
	 * int 형 값을 리턴하는 메소드
	 */
	
	public int inputNumber() {
        Scanner sc = new Scanner(System.in);
		
		System.out.println("정수 입력 : ");
		int num1 = sc.nextInt();
		
		return num1;  // 메소드 호출부 리턴시 num 값을 가지고 간다 는 의미
		
	}
	
	public void test1() {
		
		//1. 데이터 할당부
		String name = "홍길동";
	    int age = 30;
	    
			
		// 2. 데이터 출력부
	    
	    //현재 객체를 가리키는 참조변수, 예를들어 this.printInfo 앞에 this가 생략 되어있는것.
	    printInfo(name , age); // 이걸로 하고 출력할때한번만 고치면 중복된 코드가 모두 고쳐진다.
	                           // 선언한 순서대로 호출해야한다.
		System.out.println("안녕하세요~" + age + "살, " + name + "입니다");
		
		name = "김주연";
		age = 28; 
		printInfo( name , age); // 매개 인수 ( 여기선 name 과 age 가 인수)
		System.out.println("안녕하세요~" + age + "살 , "+ name + "입니다");
		System.out.println("name = " + name);
		System.out.println("age = " + age);
		
	}
	
	/**
	 * 매개 인수(인자) : 메소드 호출에 전달된 값
	 * 매개 변수 : 메소드 호출시 전달된 값이 보관될 변수(공간)
	 */
	
	public void printInfo(String name , int age) { // 매개변수 ( printInfo) 가 매개변수 여기선
		System.out.println("안녕하세요~" + age + "살 , "+ name + "입니다");
		
	}

}
