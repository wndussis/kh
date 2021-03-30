package kh.java.array;

public class ArrayTest {
	public static void main(String[] args) {
		ArrayTest a = new ArrayTest();
//		a.test0();
//		a.test1();
//		a.test2();
//		a.test3();
//		a.test4();
//		a.test5();
//		a.test6();
		a.test7();
		
	}
	/**
	 * 배열의 특징
	 * - 배열의 길이는 변경할 수 없다.!!!!!!!
	 * 
	 */
	public void test7() {
		int[] arr = new int[10]; // 여기서 10 은 10개의 연속된 공간
		System.out.println(arr.length);
		//hashcode 비교 : 객체 주소값에 접근할 수 있는 key값 , hashcode값이 같으면 동일한 객체이다
		System.out.println(arr.hashCode());
		//toString : 객체를 문자열 정보로 표현
		System.out.println(arr);  // 출력결과 : [I@24273305
		System.out.println(arr.toString());  // 출력결과 : [I@24273305

		
		
		arr = new int[7]; // 새로운 배열 객체를 만든것 . 배열을 10에서 7 로 줄인게 아니라
		System.out.println(arr.length);
		System.out.println(arr.hashCode());
		System.out.println(arr);
		System.out.println(arr.toString());
		
		// 참조형 변수의 기본값 = null
		arr = null;  // 참조형 변수에 null 을 대입하는게 '삭제' 다
		
//		System.out.println(arr.length); //NullPointerException 이라고 오류가 뜨면 null 을 의심
//		System.out.println(arr[0]); //NullPointerException 이라고 오류가 뜨면 null 을 의심
	}
	/**
	 * String[] => 스트링 배열
	 */
	
	public void test6() {
//		String[] nameArr = new String[3];
//		nameArr[0] = "홍길동";
//		nameArr[1] = "신사임당";
//		nameArr[2] = "장영실";
    	String[] nameArr = {"홍길동" , "신사임당"  , "장영실"}; // 이렇게 한번에 가능함
		
		for(int i = 0; i < nameArr.length; i++) {
			System.out.println(nameArr[i]);
		}
	}
	/**
	 * 실습문제 : 알파벳 소문자가 담긴 char배열을 생성하고 출력하세요.
	 * a,b,c,d,e,f,g, . . . . .x,y,z
	 */
	public void test5() {
		int len = 26;
		char[] abc = new char[len];
		
		for(int i = 0; i < abc.length; i++) {
			abc[i] = (char)('a' + i);
			System.out.print(abc[i]);
			System.out.print(i != abc.length - 1 ? ", " : "");
		}
		
	}
	/**
	 * 배열의 요소에 담긴 값에 규칙이 있다면 ,값 대입시에  반복문을 사용할 수 있다.
	 * 
	 * {1,2,3,4,5}
	 * {'a' ,'b','c'}
	 * {2,4,6,8,10}
	 * 
	 * 이렇게 규칙이 있을때
	 */
	public void test4() { // 1 부터 100까지 값 대입 하려고 할때
		int[] arr = new int[100];
		
		//값대입
		for(int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
				
		}
		//값 출력
		for(int i = 0; i < arr.length; i++) {
			System.out.printf("arr[%d] = %d%n" , i, arr[i]);
		}
		
	}
	/**
	 * 초기화
	 * 배열 변수 선언 + 배열 할당(heap) + 인덱스별 값대입
	 *
	 */
	public void test3() {
		//char[] chArr = {'a' , 'b' , 'c'}; // 아래꺼를 이렇게 간단히 쓸수 있음
		char[] chArr = new char[] {'a' ,'b' ,'c'}; //초기화 진행하면 이렇게 간단히 쓸수 있음 아래거를
		
//		char[] chArr;
//		chArr = new char[3];
//		chArr[0] = 'a';
//		chArr[1] = 'b';
//		chArr[2] = 'c';
		
	}
	public void test2() {
		// 배열 선언
//		double[] arr;
		// 배열 할당 : heap 영역에 배열 객체를 생성하고 , 주소값을 arr 에 대입
//		arr = new double[3];
		
		//위에 두줄 합쳐도됨 아래처럼
		double[] arr = new double[3];
		
		// 배열 요소( 각각의 인덱스) 에 값 대입
		arr[0] = 1.1;
		arr[1] = 2.2;
		arr[2] = 3.3; //배열의 마지막 인덱스 : arr.length -1  , 여기선 3 - 1 = 2 
		
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	/**
	 * 	배열 : 동일한 자료형의 값이 여러개인 경우
	 */
	public void test1() {
		//1. 배열 변수 선언
		int[] arr; 
    	//int arr[]; //이것도 가능, 하지만 자바에선 위에꺼 사용하기
		
		
		//2. 배열 할당 : 배열 길이를 반드시 저장할 것.
		// 메모리 heap 영역에 int값을 담을 수 있는 공간 할당.
		// 배열은 각 타입별 초기값을 미리 처리됨.
		// 기본형 - int 0  , double = 0.0 , char ' ' , boolean false => 각 타입별 기본값
		// 참조형 - null (값없음)
		arr = new int[5];
		
		// 배열 각 번지수 참조
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		System.out.println(arr[3]);
		System.out.println(arr[4]);

	
	
		//3. 배열 각번지에 값 대입
		arr[0] = 80;
		arr[1] = 70;
		arr[2] = 90;
		arr[3] = 75;
		arr[4] = 43;
		
//		System.out.println("=================="); // 그냥 구분한것
//		System.out.println(arr[0]);
//		System.out.println(arr[1]);
//		System.out.println(arr[2]);
//		System.out.println(arr[3]);
//		System.out.println(arr[4]);
		System.out.println("==================");
		
		//위에 꺼를 반복문 통해서 대체 가능
		for(int i = 0; i < 5; i++) {
			System.out.println(arr[i]);
	    System.out.println("==================");
		}
		
		//4. 총점, 평균
//		int total = arr[0] + arr[1] + arr[2] + arr[3] +arr[4]; //총점
		
		//반복문 이용해서 점수 배열의 총점 구하기
		int total = 0;
		//의미를 찾기 힘든 magic number 대신 변수, 상수를 사용하자
		for(int i = 0; i < arr.length; i++) {
			total += arr[i];
		}
		
		double avg = (double)total / arr.length;
		System.out.println(arr.length);
		System.out.printf("총점 : %d점, 평균 : %.2f%n", total, avg);
		
		
		
	}
	
	
	public void test0() {
		//동일한 자료형을 가진 여러 값 
		int kor = 80;
		int math = 70;
		int eng = 90;
		int society = 75;
		int science = 43;
		
		// 초기화
		//int[] arr = {80 , 70 , 90 . 75 , 43};
		
		// 총점 , 평균  구하기
		int total = kor + math + eng + society + science;
	    double avg = (double)total / 5;
	    
	    System.out.printf("총점 : %d점 , 평균 : %.2f%n" , total , avg);
	    
	}

}
