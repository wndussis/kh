package com.kh.print;

public class PrintTest {
	
	public static void main(String[] args) {
		//한줄 주석
		/* 이건 여러줄 주석
		 * 
		 *
		 */
		
		PrintTest p = new PrintTest(); // 클래스를 객체로 만든것
        p.test1(); // 프린트 테스트의 프린트 테스트1을 호출 하겠다는 뜻, 메소드 호출
        p.test2(); 
        p.test3();
        
        /**
         * 문자열 더하기연산
         * 1. 문자열 + 문자열 => 문자열
         * 2. 문자열 + 숫자 => 문자열
         * 3. 숫자 + 숫자 => 숫자
         */
        
	
		
	}
	
	
	public void test3() {
		System.out.println("가나다" + "라마바사"); // "가나다라마바사" 문자열
		System.out.println("abc" + 123); // "abc123" 문자열 + 숫자 니까 = 문자열
		System.out.println("123" + 4); // "1234" 문자열 + 숫자 니까 = 문자열
		System.out.println(12 + 34); // 46 = 숫자
		
		System.out.println(12 + "34"+ 56); //"123456" 문자열
		System.out.println(12 + 34 + "56");// "4656" 문자열
		System.out.println("12" + 3 * 7); //"1221" 문자열
		
		
		
	}

	public void test2() {
        
        
             System.out.println("abc" + "def");
        
             System.out.println(
            		 "\t\"Shake It 알람\"\n" +
                     "------------------------------------\n" +
            		 "   흔들기\t쏴리질러\t터치하기\t원터치\n" +
            		 "------------------------------------\n" 
            		 );
             
             System.out.println(
            		 "홍길동\n"+    // "  " 시작된 문자열은 그 줄에서 끝나야함 다음줄 까지 넘어가지말고
                     "\t\"신사임당\"\n" + // 그래서 + 를 이용해서 하면됨 옆에처럼
                     "\t\t세종대왕\\\"\\'\\/"
                      
            		 
            		 
            		 );
     
            		
           
	}
	
	/**
	 * escape 문자
	 * ( \ + 특정문자)
	 * 
	 * \n 개행문자 (윈도우 \r\n)
	 * \t 탭
	 * 
	 * \\ \(역슬래시)출력
	 * \" "(쌍따옴표)출력
	 * 
	 * 
	 */
	public void test1() { //메소드 선언
		
		System.out.println("안녕"); //출력후 개행
		System.out.print("하\n"); //출력
		System.out.print("하"); //출력
		System.out.print("하\n"); //출력
		
		
		// 그는 말했다. "춥다....."
		
		System.out.println("그는 말했다. \"춥다.....\"");
		
		//윈도우 디렉토리 구분자는 역슬래시를 사용한다.
		System.out.println("C:\\dev\\eclipse\\eclipse.exe");
		System.out.println("C:/dev/eclipse/eclipse.exe");//그냥 슬래시로 해도 무방함
		
		
		
	}

}
