package kh.java.array;
/**
 * 
 * 배열 복사
 * 
 * 1. 얕은 복사 shallow copy
 * - 배열 변수(주소값)의 복사
 * 
 * 2. 깊은 복사  deep copy
 * - 배열 객체의 값 복사
 * 
 */

public class ArrayCopyTest {
	
	public static void main(String[] args) {
		ArrayCopyTest a = new ArrayCopyTest();
		a.test1();
//		a.test2();
//		a.test3();
//		a.test4();
		
}
	/**
	 * 깊은 복사 3
	 * clone()
	 *
	 */
	public void test4() {
		double[] arr1 = new double[] {0.123 , 0.741 , 0.324 };
		double[] arr2 = arr1.clone();
		
		arr1[1] = 0.567; // 이렇게 arr1[1] 값을 바꾸면  저것만 바뀜
		
		for(int i = 0; i < arr1.length; i++) {
			System.out.printf("%.3f ---%.3f%n", arr1[i] , arr2[i]);
		}
	}
	/**
	 * 
	 * 깊은 복사2 : 
	 * System.arraycopy(원본배열, 시작인덱스,도착지배열, 시작인덱스,복사할 길이);
	 */
	public void test3() {
		char[] arr1 = {'a','b','c','d','e'};
		char[] arr2 = new char[arr1.length];
		
//      System.arraycopy(arr1, 0, arr2, 0, arr1.length);
		System.arraycopy(arr1, 0, arr2, 3, 2);
		
		arr1[3] = 'x'; // arr1 만 바뀜 arr2 는 안바뀜 
		
		for(int i =0; i < arr1.length; i++) {
			System.out.printf("%c --- %c%n", arr1[i] , arr2[i]);
		}
		
		
	}
	
	 /**
	 * 깊은 복사 1 : 반복문을 통해 직접 값 복사하기
	 */
	
	public void test2() {
		int[] arr1 = {1,2,3};
		int[] arr2 = new int[arr1.length];
		
		for(int i = 0; i < arr1.length; i++) {
			arr2[i] = arr1[i]; // arr2[i] 값에 arr1[i] 값을 대입 하세요 라는 뜻.
			
			
		}
		arr1[1] *= 100;
		
		
		//출력
		for(int i = 0; i < arr1.length; i++) {
			System.out.printf("%d --- %d%n", arr1[i] , arr2[i]); //printf 사용할때는 " " 안에는 출력할 형태를 써주고  , 뒤에는 출력할 내용을 넣는다 !!!
		}
		
		System.out.println(arr1.hashCode());
		System.out.println(arr2.hashCode());
		System.out.println(arr1 == arr2); //false
	}
	/**
	 * 얕은 복사 : 주소값만 복사 , 같은 배열을 공유
	 * 
	 */

	public void test1() {
		int[] arr1 = {1,2,3};
		int[] arr2 = arr1;// arr1 을 arr2로  얕은 복사 한 것 
		
		arr1[1] += 10;
		
		for(int i = 0; i < arr1.length; i++) {
			System.out.printf("%d --- %d%n", arr1[i] , arr2[i]);
		}
		
		System.out.println(arr1.hashCode()); // hashcode 사용으로 같은 객체인지 판별 가능 , hashcode 사용했을때 둘다 값이 같으면 같은 객체
		System.out.println(arr2.hashCode());
		
		//배열 주소값 비교
		System.out.println(arr1 == arr2); // true 혹은 flase로 결과값 나옴 , 여기선 같으니까 true 가 나옴
		
	  //얕은 복사의 활용
		
		printArr(arr1);
		
		for(int i = 0; i < arr1.length; i++) {
			System.out.printf("%d --- %d%n", arr1[i], arr2[i]);
		}

		
	}
	public void printArr(int[] arr) {
		System.out.println(arr.hashCode());
		
		for(int i  = 0; i < arr.length; i++ ) {
			System.out.printf(arr[i] + " ");
		}
		arr[1] = 20;
	}
	
}
