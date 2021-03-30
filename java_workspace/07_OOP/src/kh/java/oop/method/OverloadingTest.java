package kh.java.oop.method;
/**
 * 
 * Method Overloading
 * 메소드 명은 변수명 처럼 직관적으로 작성해야함.
 * 동사(+명사)  이런형태
 * - setUserName
 * - getUserName
 * - printInfo
 * - add(int, int)
 * - add(double , double)
 * 
 * 오버로딩 규칙
 * - 메소드명은 동일해야 한다.
 * - 매개변수 선언부는 달라야한다.( 타입, 개수, 순서 등 이 달라야함)
 * 
 * - 매개변수명, 접근제한자 , 리턴타입은 상관하지 않는다.
 * 
 *
 */
public class OverloadingTest {
	
	public static void main(String[] args) {
		
		System.out.println(123); // public void println( int x)
		System.out.println(true); //public void println(boolean b)
		System.out.println('a'); //          
		System.out.println(123.456);
		
	}
	
	public void test() {}
	public void test(int i) {}
	public void test(char ch) {}
	public void test(int i, int j) {}
//	public void test(int j, int i) {} //매개변수명이 다른 것은 오버로딩이 아니다.
	public void test(String s) {}
//	private void test(String s) {}//접근제한자가 다른 것은 오버로딩이 아니다.
//	public String test(String s) {}//리턴타입이 다른 것은 오버로딩이 아니다.
	public void test(String s, int i, int j) {}
	public void test(boolean b) {}
	public void test(int[] arr) {}
	public void test(int[][] arr) {}
	public void test(double d) {}
	
		
	
	

}
