package kh.java.test.array;
/**
 * 
 * 길이가 5인 String 배열을 선언하고, 
    “딸기”, ”복숭아”, ”키위”, ”사과” , ”바나나” 로 초기화를 한 후, 
    배열 인덱스를 활용해서 바나나를 출력해 보세요
 * 
 *
 */

public class Test2 {
	
	public static void main(String[] args) {
		Test2 a = new Test2();
		a.test2();
		
	}
	
	public void test2() {
		
		String[] arr = new String [5];
		
		arr[0] = "딸기";
		arr[1] = "복숭아";
		arr[2] = "키위";
		arr[3] = "사과";
		arr[4] = "바나나";
		
		System.out.println(arr[4]);
		
	}
	

}
