package kh.java.array.sort;

/**
 * 
 * 배열 정렬
 * [3,4,1,2,5] => [1,2,3,4,5] 오름차순으로 변경  , [5,4,3,2,1] 내림차순으로
 * 
 * 알고리즘 공부 단골 주제 - 검색, 정렬 , 자료구조
 * 
 * - 순차정렬 (오늘 배운거)
 * - 선택정렬 (오늘 배운거)
 * - 버블정렬
 * - 삽입정렬
 * 
 * - 퀵정렬
 * - 합병정렬
 * - 팀정렬
 *
 */

public class SortingTest {
	
	public static void main(String[] args) {
		SortingTest s = new SortingTest();
//		s.test1();
//		s.test2();
//		s.test3();
		s.test4();
		
		
	}
	/**
	 * 선택 정렬
	 * 회차마다 최소값을 찾아서 마지막에 한번만 swap 한다.
	 * 
	 * 
	 */
	public void test4() {
		int[] arr = {4,3,0,2,1};
		// i = 0 1 2 3 
		for(int i = 0; i < arr.length - 1; i++) {
			
		
			// 최소값을 가리킬 인덱스
		    int min = i;
			
			// j = 0 일때 1234 , 1일때 234, 2일떄 34, 3일때 4
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[min] > arr[j])
					min = j;
				
				print(arr,i);
			}
			swap(arr, min, i);
	   }
		print(arr, 5);
	}		
	/**
	 * 순차정렬
	 * 회차(바깥 반복문의 한턴)에 해당하는 인덱스에 알맞은 수를 찾는 방법
	 * 한 회차가 끝나면 해당 인덱스는 정렬 완료.
	 * 
	 */
	public void test3() {
		int[] arr = {4,3,0,2,1};
		
		// i : 0 1 2 3 // 4는 맨마지막이니까 여기서 확인할 필요 없음
		for(int i = 0; i < arr.length - 1; i++) {
			
			//j : 0 일때 1234, 1일때 234 , 2일때 34, 3일때 4
			for(int j = i + 1; j < arr.length; j++) {
				// 큰수가 좌측에 위치한 경우
				if(arr[i] > arr[j])
					swap(arr, i, j);
				
				print(arr, i);
								
			}
		}
		
	}
	
	public void print(int[] arr, int nth) {
		System.out.printf("%d : %d %d %d %d %d%n",
				          nth, arr[0], arr[1], arr[2], arr[3], arr[4]);
	}
	public void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = arr[j];
		arr[j] = temp;
			
		
		
	}
	/**
	 * 배열에서의 값교환
	 */
	public void test2() {
		int[] arr = {2, 1, 3};
		
//		int temp = arr[0];
//		arr[0] = arr[1];
//		arr[1] = temp;
		
		swap(arr, 0 , 1);
		
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		
	}
	/**
	 * 자리바꿈
	 * 제 3의 공간이 필요함 !
	 * 
	 */
	
	public void test1() {
		int a = 10;
		int b = 7;
		
		int temp = b;
		b = a;
		a = temp;
		
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		
		
	}

}
