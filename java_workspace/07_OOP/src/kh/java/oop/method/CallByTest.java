package kh.java.oop.method;
/**
 * 두개 차이 꼭 기억하기 !!!
 * 
 * call by value : 값을 전달 ( 기본형 )
 * 
 * call by reference : 주소값을 전달( 참조형 )
 *
 */
public class CallByTest {

	public static void main(String[] args) {      
		
		int a = 10; // 기본형
		int[] arr = {1,2,3,4,5}; // 참조형
		
		CallByTest c = new CallByTest();
		c.test1(a); // call by value
	    System.out.println(a);
	    
	    c.test2(arr); // call by reference  주소값이 전달되는것
	    System.out.println(arr[0]);
	    
	    String s = "안녕";
	    c.test3(s); // call by reference
	    System.out.println(s);
	    
	    Sample sp = new Sample();
		sp.num = 99;
		c.test4(sp); // call by reference
		System.out.println(sp.num);
		
	}
	
	public void test4(Sample s) {
		s.num *= 100;
	}
	
	public void test3(String str) {
		str = "잘가";
	}
	
	
	public void test2(int[] arr) {
		arr[0] *= 100;
	}

	public void test1(int x) {
//		System.out.println(x);
		x = 20;
	}
	
}

class Sample {
	int num;
}







	    
	  