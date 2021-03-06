package kh.java.two.dimentional.array;

import java.util.Scanner;

public class JaggedArrayTest {
	/**
	 * 가변 배열 JaggedArray
	 * 
	 * int[][] arr = new int[3][];
	 * 
	 * 참조의 참조인 배열의 길이가 제각각인 배열
	 * 
	 */
	
	public static void main(String[] args) {
		JaggedArrayTest j = new JaggedArrayTest();
//		j.test1();
//      j.test2();
		j.test3();
	}
	/**
	 * 실습문제 :
	 * 사용자에게 정수를 입력받고, 입력한 정수에 따라 다음과 같이 처리
	 * 정수 : 5
	 * 0 행 길이 = 5  // 둘이 합쳐서 5 니까 
	 * 1행  길이 = 4
	 * 2행  길이 = 3
	 * 3행  길이 = 2
	 * 4행  길이 = 1
	 * 
	 * 출력값 아래처럼 나오게 만들어보기
	 * 
	 * 1 2 3 4 5 
	 * 6 7 8 9
	 * 10 11 12
	 * 13 14
	 * 15
	 * 
	 */
	public void test3() { 
      
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 : ");
		int num = sc.nextInt();
		int[][] arr = new int[num][];
		//2차원배열 할당
		for(int i = 0; i < arr.length; i++)
			arr[i] = new int[num - i];
		//값대입
		int k = 1;
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				arr[i][j] = k++; 
			}
		}
		//값출력
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

		
	}
	/**
	 * 실습문제:
	 * 구매 목록을 입력 받는데, 의류 5종류,식료품 2종류, 기타물품 3종류 
	 * 담을수 있는 가변배열을 선언하고, 사용자로부터 각각 입력 받으세요.
	 * 
	 */
	public void test2() { 
		
		String[][] buyArr = new String[3][];
		// 배열 할당
		buyArr[0] = new String[5];
		buyArr[1] = new String[2];
		buyArr[2] = new String[3];
		Scanner sc = new Scanner(System.in);
		
		// 값 입력
		for(int i = 0; i < buyArr.length; i++) {
			
			switch(i) {
			case 0: System.out.print("의류 "); break;
			case 1: System.out.print("식료품 "); break;
			case 2: System.out.print("기타물품 "); break;
			}
			System.out.println(buyArr[i].length + "가지를 입력하세요.");
			
			for(int j = 0; j < buyArr[i].length; j++) {
				
				System.out.print(j + 1 + " : ");
				buyArr[i][j] = sc.next();
			}
		}
		//출력
		for(int i = 0; i < buyArr.length; i++) {
			
			switch(i) {
			case 0: System.out.print("의류 : "); break;
			case 1: System.out.print("식료품 : "); break;
			case 2: System.out.print("기타물품 : "); break;
			}
			for(int j = 0; j < buyArr[i].length; j++) {
				
				System.out.print(buyArr[i][j]);
				System.out.print((j != buyArr[i].length - 1) ? ", " : "");
			}
			System.out.println();
		}

		
		
		
		
				
	}
	/**
	 * 가변 배열
	 */
	public void test1() {
		int[][] arr = new int[3][]; //1차원 배열만 정해놓고 , 2차원 배열은 정해놓지 않음 그래서 비어놨음
		
		// 2차원 배열 할당
		arr[0] = new int[10];
		arr[1] = new int[3];
		arr[2] = new int[7];
		
		// 값 입력
		int k = 0;
		for(int i = 0; i < arr.length; i++)
			for(int j = 0; j < arr[i].length; j++)
				arr[i][j] = k++;
		
		for(int i = 0; i < arr.length; i++) {
//			System.out.println(arr[i].toString()); //객체의 정보를 문자열로 출력(hashcode 값 포함)
			for(int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		
		
	}
			 

}
