package kh.java.two.dimentional.array;

/**
 * 
 * 2차원 배열 => 배열 안의 배열 , 행 과 열 처럼 생각하면 쉬움
 * 
 * {{1,2,3} , {4,5,6} , {7,8,9}} 배열 안에 배열이 있다.
 *
 * arr[0][0] --> 1
 * arr[0][1] --> 2
 * arr[0][2] --> 3
 * 
 * arr[1][0] --> 4
 * arr[1][1] --> 5
 * arr[1][2] --> 6
 * 
 * arr[2][0] --> 7
 * arr[2][1] --> 8
 * arr[2][2] --> 9
 */

public class TwoDimentionalArrayTest {

	public static void main(String[] args) {
		TwoDimentionalArrayTest t = new TwoDimentionalArrayTest();
//		t.test1();
//		t.test2();
//		t.test3();
		t.test4();
	}

	/**
	 * 2차원 배열의 이해
	 * -배열 안의 배열
	 * 
	 * -참조의 참조
	 */
	public void test4() {
		int[][] arr = new int[2][3];
		
		int k = 100;
		
		// int[][] 의 길이는 첫번째 가리키는 배열의 길이다. = 2
		for(int i = 0; i < arr.length; i++) {
			
			// int[] 의 길이는 두번째 가리키는 배열의 길이 = 3
			for(int j = 0; j < arr[i].length; j++) {
				arr[i][j] = k++;
				System.out.print(arr[i][j] + " ");
				
			}
			System.out.println();
		}

	}

	/**
	 * 실습 문제 : 알파벳 배열 0 행 에는 대문자 26개 1행 에는 소문자 26개 char[][] 을 생성하세요
	 */
	public void test3() { 

		char[][] arr = new char[2][26]; // 2행 26열

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = (char) ((i == 0 ? 'A' : 'a') + j);
			}
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

	}

	/**
	 * 2차원 배열의 초기화
	 * 
	 * (선언, 배열 할당 , 값대입) 모든걸 한번에 처리.
	 */
	public void test2() {
		int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 } };

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

	}

	public void test1() {
		// 1. 배열 선언
		int[][] arr; // 이차원 배열을 가르키는 변수 공간

		// 2. 배열 할당
		arr = new int[2][3]; // 2행 3열

		// 3. 값 대입
		arr[0][0] = 1;
		arr[0][1] = 2;
		arr[0][2] = 3;
		arr[1][0] = 4;
		arr[1][1] = 5;
		arr[1][2] = 6;

		// 4. 값 출력
		System.out.println(arr[0][0]); // 1
		System.out.println(arr[0][1]); // 2
		System.out.println(arr[0][2]); // 3
		System.out.println(arr[1][0]); // 4
		System.out.println(arr[1][1]); // 5
		System.out.println(arr[1][2]); // 6

		// 행 : arr.length
		// 열 : arr[0].length , 0 대신 i 도 가능

		// i : 0,1
		for (int i = 0; i < arr.length; i++) {
			// j : 0,1,2
			for (int j = 0; j < arr[i].length; j++) {
				System.out.println(arr[i][j]);
			}
		}

	}

}
