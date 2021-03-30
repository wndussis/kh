package prt1;

public class HelloWorld {
	public static void main(String[] args) {
		 
		HelloWorld hw = new HelloWorld(); // 클래스 객체화
    	hw.test1(); // 메소드 호출부 
	    hw.test2();
	}	    
	    public void test2() {
	    	java.util.Date now = new java.util.Date();
			System.out.println(now);
	    }
	    	

	
	
	//메소드 선언부 , 메소드는 항상 선언 한 후에 호출 해야 오류가 없음
	// 선언 하지 않고 호출만 하면 실행안됨 !!!
	public void test1() {
		System.out.println("주연아 화이팅 !!! 김주연이 최고다!!!");
	
		
	}


}
