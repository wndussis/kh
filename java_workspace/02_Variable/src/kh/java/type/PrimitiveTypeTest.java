package kh.java.type;

/**
 * 
 * 자료형 Data Type
 * 1.  기본형 Primitive Type
 *  - 값(literal)을 저장
 *  -8가지
 *  문자형 char,
 *  논리형 boolean,
 *  정수형 byte short int long,
 *  실수형 float double)
 *  
 *  
 * 2.  참조형 Reference Type
 * - 주소값을 저장 (4byte)
 * -기본형을 제외한 모든 타입 
 *    String, System, Date, Calendar
 *    모든 클래스는 자료형이다.
 *    
 *    bit
 *    byte - 8bit
 *    kilo byte - 1024byte
 *    mega byte - 1024 kb
 *    giga byte - 1024 mb
 *    tera byte - 1024 gb
 *    peta byte - 1024 tb
 *    exa  byte
 *    zetta byte
 *    yotta byte
 *    
 *    
 *
 */

public class PrimitiveTypeTest {
	
	public static void main (String[] args) {
		PrimitiveTypeTest p =new PrimitiveTypeTest();
	//    p.test1();
	  //  p.test2();
	//	  p.test3();
		  p.test4();
		  
		  
		  
		  
        
	    
	    
	    /**
	     * 초기화
	     * 변수 선언과 값대입을 한줄에서 처리
	     */
	
	   publc void test2() {
	//	   int num;
	//	   num = 123;
		   
		   int num = 123; //초기화
           System.out.println(num);
		   
	   
		   /**
		    * 상수
		    * 한번 값 대입 후에 값을 변경할 수 없는 변수
		    * final  키워드 사용
		    */
		   
		     public void test3() {
			   
			   final int age = 20;
			   
			// age = 30;
			   
			   System.out.println(age);
			   
			   int myAge = age + 1;
			   System.out.println(myAge);
			   
			   //jdk 가 지정해둔 상수
			   System.out.println(10 * 10 * Math.PI);  // Math.PI 는 3.14
			   
			   System.out.println(Byte.MIN_VALUE + " ~ " + Byte.MAX_VALUE);
			   System.out.println(Short.MIN_VALUE + " ~ " + Short.MAX_VALUE);
			   System.out.println(Integer.MIN_VALUE + " ~ " + Integer.MAX_VALUE);
			   System.out.println(Long.MIN_VALUE + " ~ " + Long.MAX_VALUE);
			   
		     }
			   
			   /**
			    * Data Overflow
			    */
			   
           public void test4() {
        	     
              int i =  Integer.MAX_VALUE;
              System.out.println(i);
              
              i = i + 1;
              System.out.println(i);
              
              
              
              
           }
			   
			   
			   
			   
		   
		
		   
	   
}

	
		
   /**
    * 기본형
    *  1.논리형
    *     boolean(1byte) : true or false
    *  2.문자형
    *     char(2byte) 0 ~ 65535 까지 표현가능 : 'a','가','1'
    *  3.정수형 
    *     byte(1byte) -128 ~ 127(256) 까지 표현가능
    *     short(2byte) -32768 ~ 32767 (65536)
    *     int(4byte) (정수 기본형) -21억 ~ 21억(42억)
    *     long(8byte)-922경 ~ 922경
    *     
    *     
    *  4.실수형
    *     float(4byte) 소수점 이하 7자리
    *     double(8byte) (실수 기본형) 소수점 이하 16자리
    *  
    * 
    */
	
		public void test1() {
			//1. 변수 선언
			boolean bool;
			
			char ch;
			
			float f;
			double d;
			
			//변수는 값대입 없이 사용할 수 없다.
		
			
			//2. 변수에 값 대입 ,값대입 여러번 할수 있음
			bool = true; // true 를 bool 에 담으라는 뜻
			bool = false;
			bool = (5 > 2 ); // 5는 2보다 크니 , 왼쪽 기준으로 읽기 , >= 크거나 같다, <= 작거나 같다.
			bool = (3 == 4); // 3은 4와 같니
			bool = (3 != 4); // 3은 4와 같지 않니,같지 않으면 true , 같으면 false
			bool = !bool; // 좌측에 우측의 결과를 넣어줘 , !bool 은 bool의 원래값의 반대를 의미 '!' 니까
			
			ch = 'a';
		    
			// 실수 기본형 double
			f = 0.123456789F; //Type mismatch: cannot con
		    d = 0.123456789012345667;
			 
			//3. 변수 사용(출력)
			System.out.println("bool =" + bool);
			System.out.println("ch =" + ch);
			
			//정수연산
			int i = 10;
			int j = 3;
			
			System.out.println(i + j);
			System.out.println(i - j);
			System.out.println(i * j); //곱하기
			System.out.println(i / j); //나누기 ,출력값은 몫 만 처리됨 소수점(나머지)은 안나옴
			System.out.println(i % j); //나머지 출력
			
		}
		
		
			
				
	}
	



 