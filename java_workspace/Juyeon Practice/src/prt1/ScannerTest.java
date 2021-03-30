package prt1;

import java.util.Scanner;

public class ScannerTest {
	public static void main(String[] args) {
		ScannerTest s = new ScannerTest();
		s.test1();
		
	}
	public void test1() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름 : ");
		String name = sc.next();
		
		System.out.print("나이 : ");
		int age = sc.nextInt();
		
		sc.nextLine();
		System.out.print("주소 : ");
		String address = sc.nextLine();		
		
	}

}
