package ncs.test7;

import java.util.Scanner;

public class test1 {
	
//	다음과 같은 프로그램을 작성하시오.
//	(1) 사용자로부터 배열 길이(size)를 입력받음
	
	Scanner sc = new Scanner(System.in);
	System.out.print("배열 길이 입력 :  ");
	int size = sc.nextInt();
	
//	(2) 길이가 size인 배열을 생성
	
	int [] arr = new int[size];
	
//	(3) 사용자로부터 size 개의 정수값을 입력받아 배열에 저장
	
	 System.out.print("5개의 정수를 입력하세요 :  ");
	 for (int i = 0; i < arr.length; i++) {
		 arr[i] = sc.nextInt();
	 }
	
	
//	(4) 배열의 원소를 순서대로 모두 출력
	
	for(int i = 0; i < arr.length; i++) {
		 System.out.print( arr[i] + " ");
		 
	}
	
//	(5) 배열의 원소를 순서대로 모두 출력
//	- 실행 예:
//	lab4_1: 홍길동
//	배열 길이 입력: 5
//	5개의 정수 입력: 12 13 14 15 -16
//	배열 = 12 13 14 15 -16
//	배열 = 12 13 14 15 -16

	

	
	
	
	
	
  
}
