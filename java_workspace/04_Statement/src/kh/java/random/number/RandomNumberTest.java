package kh.java.random.number;

import java.util.Random;
import java.util.Scanner;

public class RandomNumberTest {
	
	public static void main(String[] args) {
		RandomNumberTest r = new RandomNumberTest();
//		r.test1();
//		r.test2();
//		r.test3();
		
		r.test4();
	}
	/**
	 * 올림   ceiling : double 을 리턴함
	 * 버림  floor : double 리턴
	 * 반올림 round : long 리턴
	 */
	
	public void test4() {
		//1. 올림
		double num = 1.1;
		double result = Math.ceil(num);
		System.out.println("result = " + result);
		
		//2.버림
		result = Math.floor(num);
		System.out.println("result = " + result);
		
		//부동 소수점 방식
		//올림해서 소수점 첫번쨰 자리까지 표현  : 1.3 
		//1.23 * 10 => 12.3 => 13.0 / 10 => 1.3 이된다
		num = 1.23; // 1.23 을 1.3 으로 만들려면
		result = Math.ceil(num * 10) / 10;
		System.out.println("result = " + result);
		
		//3. 반올림
		double n = 3.75;
		long res = Math.round(n);
		System.out.println("res = " + res);
		
		//반올림 결과 3.8 을 얻고 싶을떄
		// 3.75 * 10 -> 37.5 -> (double)38 / 10 -> 3.8 	}
		System.out.println("res = " + res);
	
	/**
	 * 동전게임
	 */
	
	public void test3() {
		Scanner sc = new Scanner(System.in);
//		System.out.print("동전 앞/뒤를 입력(1.앞 2.뒤) > ");
		int user = sc.nextInt();
		
//		int coin = (int)(Math.random() * 2) + 1; // 여기서 2 는 경우의 수, 동전 앞,뒤 니까 2 곱한것
		Random rnd = new Random();
//		int coin = rnd.nextInt(2) + 1; 
	    int coin = rnd.nextBoolean() ? 1 : 2;
		
		
		String result = user == coin ? "정답" : "오답" ;
		System.out.println(result);
		System.out.println("user = " + user + ", coin =" + coin);
		
		
	}
	
	/**
	 * java.util.Random 이용
	 */
	public void test1() {
		Random rnd = new Random();
		
	
     //int num = rnd.nextInt(); // int 범위
		
	  //경우의 수 , 시작값(최소값)
//		int num = rnd.nextInt(10) + 1; // ( 0 ~ 9 ) + 1
		
	//	System.out.println(num);
		
	 // 101 ~ 200 : 경우의 수 = 100 , 시작값은 101
//		int num = rnd.nextInt(100) + 101;
		
		System.out.println(num);
		
		// 0.0(포함) ~ 1.0(미포함) 의 난수
		double dnum = rnd.nextDouble();
		System.out.println(dnum);
		
		
		boolean bool = rnd.nextBoolean();
		System.out.println(bool);
		
	}
	
	/**
	 * Math.random() 이용 , import 문 없이 이용가능
	 * 
	 * 0.0(포함) ~ 1.0(미포함) , 실수를 리턴
	 */
	
	public void test2() {
		double num = Math.random();
		System.out.println(num);
		
		//Math.random() * 경우의 수 + 최소값  => 정수형 난수 얻을수 있음
		int i =(int)(Math.random() * 10) + 1; // 1부터 10 사이의 난수를 얻을 수 있음
		System.out.println(i);
		
		
	}

}
