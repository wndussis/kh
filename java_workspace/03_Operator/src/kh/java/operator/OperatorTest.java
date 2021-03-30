package kh.java.operator;

import java.util.Scanner;

public class OperatorTest {
	
	public static void main(String[] args) {
		OperatorTest ot = new OperatorTest();
		ot.test1();
		ot.test1_1();
		
		ot.test2();
		ot.test2_1();
		
		ot.test3();
		
		ot.test4();
		
	
	}
	
	/**
	 * 복합 대입 연산자
	 * +=
	 * -=
	 * *=
	 *  /=
	 * %/
	 * 
	 * 
	 * 
	 * 
	 */
	public void test4() {
		int n = 10; 
		n = n + 5; // n 공간에  n + 5 결과를 대입하라는 뜻 = n +=5; 와 같은뜻
		n += 5; 
		System.out.println("n = " + n);
		
		n = n - 5; // n-=5 와 같은말
		n -=5;
	    System.out.println("n = " + n);
	    
	    n= n * 3;
	    n *= 3;
	    System.out.println("n = " + n);
	    
	    
	    n = n / 9;
	    n /=9; // 몫
	    System.out.println("n = " + n);
	    
	    
	    n = n % 3;
	    n %= 3; //나머지
	    System.out.println("n = " + n);
	    
	   	
		
	}
	
		/**
		 * 삼항 연산자
		 * (논리식) ? (true 일때 값 ) : (false 일때 값);
		 * 
		 * 
		 * 
		 */
		public void test3() {
		 System.out.println(10 > 3 ? "ㅎㅎㅎㅎ" : "ㅋㅋㅋ"); // true 니까 ㅎㅎㅎㅎ 가 출력됨
		 
		
			
		int a = 10;
		int b = 5;
		int c = a > b ? a : b;
	    System.out.println(" c =" + c);
	    
	    // a가 b의 배수인가?
	    String s = (a % b == 0) ?  "a는 b의 배수입니다." : "a는 b의 배수가 아닙니다.";
	    System.out.println(s);
	    
	    
	    // 짝수/홀수 여부
	    Scanner sc = new Scanner(System.in);
	    System.out.print("정수 : ");
	    int num = sc.nextInt();
	    
	    System.out.println(num % 2 == 0 ? "짝수 입니다" : "홀수 입니다");
	    System.out.println(num % 2 != 0 ? "홀수 입니다" : "짝수 입니다");
		}

	
	/**
	 * 이항 연산자
	 * 논리 비교 연산자 && ||
	 * - && AND
	 *  a && b  : a 가 참이면서 b 가 참인가? , 좌항,우항 모두 참이면 참 , 하나라도 아니면 거짓
	 *  
	 *  -  || OR
	 *     a || b : a 혹은 b 가 참인가? , 좌/우항중 하나라도 참이면 참 , 둘다 거짓인 경우는 거짓
	 * 
	 */
	
	public void test2_1() {
		int i = 3;
		System.out.println(i > 0 && i < 10); // true true 둘다 true 니까 최종결과는 true
		System.out.println(i == 0 && i <10); // false true 니까 결과는 false
		System.out.println(i == 0 || i < 10); // false true 니까 결과는 true
		
		int a = 1;
		int b = 1;
		System.out.println(a >0  && ++b >0); 
		System.out.println(a == 0 && ++b > 0); // false
		System.out.println("a = " + a + " , b = " + b);
		
	}
	//	System.out.println(a == 0 && ++b > 0); // false
	//	System.out.println("a = " + a + " , b = " + b);
		
		// & (AND)  | (OR) 논리비교 연산자  , 이건 굳이 사용하지 말것 추천안함
		// 좌항의 결과와 상관 없이 우항을 무조건 검사
		
		
	
	/**
	 * 이항 연산자
	 */
	
	public void test2() {
		int a = 10;
		int b = 4;
		System.out.println(a + b);
		System.out.println(a - b);
		System.out.println(a * b);
		System.out.println(a / b);
		System.out.println(a % b);
		
		System.out.println(a + (b * a / b) -( a % b)); 
		
		// ((a + ((b * a ) / b) - (a % b))
		
		System.out.println(a > b); // 크다 gt greater than
		System.out.println(a < b);// 작다 lt less than
		System.out.println(a >= b);// 크거나 같다 ge (greater than) or (equal to)
		System.out.println(a <= b);// 작거나 같다 le (less than) or (equal to)
		
		
	}
	
	public void test1_1() {
		
		int x = 10;
	    int y = 10;
	    int z = ++x;
	    System.out.printf("x = %d, y = %d, z = %d%n", x,y,z);
	    
	    z = y++;
	    System.out.printf("x = %d, y = %d, z = %d%n", x,y,z);
	    
	    x = 20;
	    z = x++ + --y;
	    System.out.printf("x = %d, y = %d, z = %d%n", x,y,z);
	    
	    int m = 20;
	    int n = m++ + m;
	    System.out.printf("m = %d, n= %d%n" , m, n);
	    
	    
		
	}
	    
	    
	   
	
	/**
	 * 
	 * 단항 연산자
	 * 
	 */

	public void test1() {
		int a = 10;
		System.out.println(+a + " , " + -a);
	    
		boolean bool = (a != 10); // 같지 않으면 true , 같으면 false
		System.out.println(!bool);
		
		System.out.println((long)Integer.MAX_VALUE + 1);
		
		//증감 연산자 : ++ --
		// ++a  --a 전위 증감 연산자: 먼저 1 증감후 , 인접연산에 사용된다.
		// a++ a-- 후위 증감 연산자: 인접 연산에 먼저 사용된후 , 1 증감한다.
		
		a++; // a 에 1 을 증가시켜라 a= a + 1 , 우항의 값을 처리한다음에 좌항에 대입
		a--; // a = a - 1
		
		System.out.println("a =" + a);
		
//		System.out.println(++a + 1);
		System.out.println(a++ + 1);
		
		int k = 1;
//		int m = ++k; // 여기도 인접연산은 = 이거
		int m = k++; // 여기서 인접연산은 = 이거임
		System.out.println("k =" + k + ", m = " +m);
		
		int i = 3;
		int j = ++i + 10; // 여기서 인접연산은 + 이거임
		System.out.println("i =" + i + ", j =" + j);
		
		
		
	}
}
