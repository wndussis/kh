package kh.java.oop.method;
/**
 * 
 * -static method(클래스 메소드) : 클래스명, 메소드명 호출!
 *  static 자원에서는 field  method 만 접근 가능하다
 * 
 * -not-static method(member 메소드 , instance 메소드) : 
 * 객체, 메소드명 호출!
 * non-static , static 자원 모두 접근 가능하다.
 *
 *static 자원에서는 non-static 자원들을 참조할 수 없다
 *하지만 반대는 가능 non static 에서 static 자원을 참조가능
 */

public class MethodTest {   //////////////////////코드 다시
	
	private int num = 100;
	private static int snum = 99;

	public static void main(String[] args) {
		MethodTest.a();
		
		MethodTest m = new MethodTest();
		m.b();
		
		
		System.out.println(MyUtil.add(100, 7));
		System.out.println(MyUtil.add(80, 3));
		
		
//		System.out.println(num);
	}
	
	//공유
	public static void a() {
		System.out.println("a!");
//		System.out.println(num); // Cannot make a static reference to the non-static field num
		System.out.println(snum);
		
//		b();
	}
	
	public void b() {
		System.out.println("b!");
		System.out.println(num);
		System.out.println(snum);
		
		MethodTest.a();
	}
	
	
	
}
