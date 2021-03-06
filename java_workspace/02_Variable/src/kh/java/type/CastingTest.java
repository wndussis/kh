package kh.java.type;

/**
 * 
 * 컴퓨터 작동원리
 * 
 * 1. 같은 자료형끼리 연산할 수 있다. ex) int 와 double 은 같이 계산할수 없다
 * 2. 연산 결과 역시 동일한 자료형이다. int 끼리 연산하면 결과도 int
 * 3. 같은 자료형의 변수에만 대입할 수 있다.
 * 
 * 위의 조건을 만족하기 위해서 암묵적/명시적 형변환이 필요하다.
 * 1. 암묵적 : 자동으로 처리
 * 2. 명시적 : 형변환 코드 필요
 * 
 * 
 */
public class CastingTest {
	
	public static void main(String[] args) {
		CastingTest c = new CastingTest();
		//c.test1();
		//c.test2();
		//c.test3();
		c.test4();
	}
	
	/**
	 * java.lang.String 문자열
	 * "abc"
	 * -참조형(객체 만들어서 사용)
	 * - 기본형처럼 사용가능(리터럴을 대입하는 형태)
	 * 
	 */
		
		
	
		
		
		/** 
		 * 명시적 형변환
		 * 1. 크기가 작은 
		     타입으로 형변환 - 데이터 손실
		 * 2. 크기가 큰 타입으로 형변환
		 */
		

	
	/**
	 * 형 변환 유의사항
	 * -byte , short,char 타입은 연산시
	 * 자동으로 int(정수 기본형)으로 변환되서 처리
	 * 
	 */
	
   public void test4() {
	   String name = "홍길동";
	   String name2 = new String("홍길동");
	   
	   // 더하기 연산
	  System.out.println(name + " 만세!");
	  
	  
	  //char
	  System.out.println(name + 'a');
	  System.out.println(123 + 'a');
	  System.out.println("abc" + 'z' + 123);
	  System.out.println(123 + 'z' + "abc");
	   
   }
   
	   
	   
	   
	   
   public void test3() {
	   byte b1 = 10;
	   byte b2 = 20;
	   byte result =(byte)( b1 + b2);
	   System.out.println("result =" + result);
	   
	   
	   boolean bool = 'a' >(b1 + b2); 
	   //             char > (byte + byte)
	   //             char > (int + int)
	   //             char > int
	   //             int(97) > int(30)
	   System.out.println("bool =" + bool);
	   
	   // char 변수에 int 대입
	   char ch = 65;
	   System.out.println(ch);
	   
	   
	   
   }

	public void test2() {
		//1. 데이터 손실이 있는 경우
		int num =(int) 3.7; // int 에 double(3.7) 을 대입한것 ,불가능 
		                    // 하지만 앞에 (int) 를 넣어줌으로써 소수점 이하를 버림으로 가능
		System.out.println(num);
		
		//2. 데이터 손실 없이 큰 타입으로 변환
		int a = 10;
		int b = 4;
		System.out.println((double)a / b); // int 를 double로 바꿈 
		                                   // (double)int / int
		                                   // double / int
		                                   // double / double
		
		System.out.println(a * 1.0 / b);
		               // int * double
		               // double * double
		               // double / int
		               // double / double
		
		
		
        		
	}
	/**
	 * 자동형 변환
	 * -크기가 작은 타입에서 큰 타입으로 변환은 자동으로 처리
	 * -정수에서 실수로의 변환은 자동처리
	 * 아래 방향(->) 대로만 변경 가능
	 * -byte(1) - > short(2) -> int(4)-> long(8)-> float(4) -> double(8)
	 *              char(2)  ->
	 */
	
	public void test1() {
		
		//대입연산
		int num = 300;
		long lNum = num; // num에 담긴 300은 int 인데 이걸 long 에 담으라고하니 
		                 //안되는거지만 여기선 자동으로 되는거라 됨
        System.out.println("1Num = " + 1Num);	
        
        int a = 3;
        double b = 1.5;
        System.out.println(a + b); //int +double
                                   //double + double -> int 가 double로 바뀐것
        
        int c = 'a'; //int = char
                     //int = int  , chat 는 int로 변경 가능하니까
        System.out.println(c);
        
        System.out.println('c' + 1); // char('c') + int
                                     // int + int
        
        // 2147483647 + 1 = > 2147483648
        int i = Integer.MAX_VALUE;
        System.out.println((long)i + 1);
        System.out.println(i + 1L);
        
        	
        
        
        
        
		
	}

}
