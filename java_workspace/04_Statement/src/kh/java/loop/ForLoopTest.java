package kh.java.loop;

import java.util.Scanner;

/**
 * 
 * for( 초기식 ; 조건식 ; 증감식 ){   //3개의 공간이 있음 초기식 조건식 증감식
 * 반복 실행할 코드 적음
 * }
 * - 초기식 : for 문이 시작하면서 단 한번만 실행, 증감변수를 초기식에서 선언
 * - 조건식 : true 면 반복문 1회 실행 , false 면 반복문 중지 , 조건식이 true 일때 까지만 반복문을 돌려라
 * - 증감식 : 증감변수 처리식(증가/감소)
 *
 *
 * 처리순서  -> 초조반증  반복 하는 것 그러다가 조건식이 false 가 되면 반복문이 끝남
 * 1. 초기식
 * 2. 조건식 -> true 라면
 * 3. 반복 실행 코드
 * 4. 증감식
 * 
 * 5. 다시 조건식 -> true 라면
 * 6. 반복 실행 코드
 * 7. 증감식
 * 
 * .....
 *  조건식 -> false 면
 *  반복문 중지
 * 
 * 
 */

public class ForLoopTest {
	public static void main(String[] args) {
		ForLoopTest f = new ForLoopTest();
//		f.test1();
//		f.test2();
//		f.test3();
//		f.test4();
//		f.test5();
		f.test6();
		
	}
	
	/**
	 * 
	 * 1,2,3,4,5,6,7,8,9,10
	 */
	
	public void test6() {
		for(int i = 1; i <= 10; i++ ) {
			System.out.print(i );
			System.out.println(i != 10 ? "," : "");
		}
		
	}
	/**
	 * 합계 구하기
	 * 
	 * 1 ~ 10 까지 합계구하기
	 * 1 + 2 + 3 + ...........+ 9 + 10
	 */
	
	public void test5() {
		int sum = 0;
		
		for(int i = 1; i <= 10; i++) {
			System.out.println(i);
			sum += i; // sum = sum + i;
		}
		System.out.println("합계 : " + sum);
		
	}
	/**
	 * 
	 * 실습문제 : 사용자에게 이름을 입력받고, 숫자를 입력받아서
	 * 해당 이름을 해당 횟수만큼 반복 출력하세요. 
	 */
	
	public void test4() {
		Scanner sc = new Scanner(System.in);
		System.out.println("이름 : ");
		String name = sc.next();
		
		System.out.print("횟수 : ");
		int n = sc.nextInt();
		
		for(int i = 0; i < n; i++) {
			System.out.println(name);
		}
		
		
	}
	
	/**
	 * 3 * 1 = 3
	 * 3 * 2 = 6
	 * 3 * 3 = 9
	 * 3 * 4 = 12
	 * 3 * 5 = 15
	 * 3 * 6 = 18
	 * 3 * 7 = 21
	 * 3 * 8 = 24
	 * 3 * 9 = 27
	 * 
	 * 
	 */
	
	public void test3() {
		for(int i = 1; i < 9; i++) {
			System.out.println("3 * " + i + " = " +(3 * i));
		}
		
	}
	
	public void test2() {
		// 11 12 13 14 15 16 17 18 19 20 이렇게 출력값 만들고 싶으면 아래처럼
		
		for(int i =11; i < 21; i++) {
			
			System.out.print(i + " ");
		}
		System.out.println();
		
		//1부터 홀수 10개
		//1 3 5 7 9 11 13 15 17 19
		for(int i = 1; i < 20; i+= 2) {
			System.out.print(i + " ");

		}
		System.out.println();
		
		//2 4 6 8 10 12 16 18 20
		
		for(int i = 1; i < 11; i++ ) {
			System.out.print(i*2 + " ");
		}
		System.out.println();
		
		//10 9 8 7 6 5 4 3 2 1
		for(int i = 10; i > 0; i-- ) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		//20 18 16 14 12 10 8 6 4 2
		for(int i = 20; i > 0; i -=2 ) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		//10 9 8 7 6 5 4 3 2 1 
		for(int i = 1; i <=  10; i++) {
			System.out.print((11 - i) + " ");
		}
	}

	public void test1() {
		// Hello World 를 3번 출력하는 반복문
		for(int i = 0; i < 3; i++) {
			
			System.out.println("Hello World");
			
		}
		
		
		
	}
}
