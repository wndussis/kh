package kh.java.error;
/**
 * Error
 * 예외처리 등 프로그램적으로 해결할 수 없는 심각한 오류 
 * 
 *
 */
public class ErrorTest {

	public static void main(String[] args) {
		ErrorTest e = new ErrorTest();
//		e.test1();
		e.test2();
		System.out.println("-------프로그램 정상 종료-------");
		

	}
	
	public void test2() {
		System.out.println("test2 호출!");
		test2();  //종료조건 없는 재귀호출 -> 메소드를 끝없이 호출함, "test2 호출!" 이 무한대로 출력됨
		//java.lang.StackOverflowError
		
	}
	public void test1() {
		long[] arr = new long[Integer.MAX_VALUE]; //배열의 크기가 너무커서 오류남
		//java.lang.OutOfMemoryError: Requested array size exceeds VM limit
	}

}
