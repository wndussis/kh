package kh.java.loop;


/**
 * 
 * break : 반복문 블럭을 즉시 탈출 한다는 의미 , 반복문 중지 !!!
 *
 *continue : 이하 코드 실행하지 않고, 반복문 시작으로 이동
 *
 *  for 문은 증감식으로 가고
 *  while 문은 조건식으로 간다
 *
 *
 */

public class BreakContinueTest {
	
	public static void main(String[] args) {
		BreakContinueTest b = new BreakContinueTest();
//		b.test1();
//		b.test2();
//		b.test3();
		b.test4();
	}
	
	/**
	 * 실습문제 : ascii code (아스키 코드) 범위에서 숫자와 영문자만 출력하기
	 *               단, continue를 무조건 사용해서 코드를 전개하세요.
	 */
	public void test4() {
		
		
	}
	/**
	 *  
	 * continue 문 아래에 증감식( i++ 이런것) 위치 시키지 않기 !!!!!
	 */
	
	public void test3() {
//		int i = 1;
//		while(i <= 100) {
//			i++;
			//홀수는 true , 짝수는 false
//			if(i % 2 != 0)
//				continue;  //true면 continue 실행 false면 내려가서 print구문 실행
			
			
//			System.out.println(i);
				
				
	
//		}
	
	   for(int i = 1; i <= 100; i++) {
		   if(i % 2 != 0)
			   continue;
		
		   System.out.println(i);
	} 
	
}	
	/**
	 * 
	 * 11의 배수가 1000이 넘기 전까지만 출력하세요.
	 */
	public void test2() {
		final int NUM = 11;
		
		int i = 1;
		while(true) {
			int n = NUM * i++;
			if(n < 1000)
				System.out.println(n);
			else
				break;
			}
			
		}
		
		
	

	public void test1() {
		int i = 1;
		while(true) {
			System.out.println(i);
			if(i++ == 100) {
				break;
				
			}
		}
		System.out.println("종료!");
	}
}
