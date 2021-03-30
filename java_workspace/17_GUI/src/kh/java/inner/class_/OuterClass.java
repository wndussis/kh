package kh.java.inner.class_;

import kh.java.inner.class_.OuterClass.A;

/**
 * 
 * 내부 클래스
 * 
 * 3가지 종류가 있음
 * 
 * 1. static 내부클래스
 * 2. non-static 내부클래스
 * 3. 지역 내부클래스
 * 
 * 내부 클래스 목적
 * - 외부클래스 안에서만 사용할때.
 * - 외부클래스의 자원(private자원)에 쉽게 접근하기 위해.
 * 
 *
 */
public class OuterClass {
	
	private int num = 100;
	private static int snum = 99;
	
	public OuterClass() {
		new A().aaa();
		
		// non- static 에서는 static 자원에 접근이 가능하다.
		new B().bbb();
		
		test();
	}
	
	public class A {  // non-static 클래스
		public void aaa() {
			System.out.println(num);  // private 접근가능
			System.out.println(snum); // private 접근가능
			
		}
	}
	public static class B {
		public void bbb() {
//			System.out.println(num);  // non-static  자원 접근 불가
			System.out.println(snum);
			
		}
	}
	/**
	 * 지역내부클래스는 지역변수와 마찬가지로 접근제한자를 가질수 없다.
	 * 그래서 아래에서 class C 라고만 씀
	 */
	public void test() {
		class C {
			public void ccc() {
				System.out.println(num);  // private 접근가능
				System.out.println(snum);  // private 접근가능
				
			}
		}
		C c  = new C();
		c.ccc();
	}
	
	public static void main(String[] args) {
		
		new OuterClass(); //생성자 호출
	

	}

}
