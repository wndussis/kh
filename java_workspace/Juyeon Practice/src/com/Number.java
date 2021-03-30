package com;

import java.util.Scanner;

public class Number {
	public static void main(String[] args) {
		Number n = new Number();
		n.test1();
	}
	public void test1() {
		Scanner sc = new Scanner(System.in);
		System.out.println("정수 1 :  ");
		int num1 = sc.nextInt();
		
		System.out.println("정수 2 :  ");
		int num2 = sc.nextInt();
		
		System.out.println("정수 1 + 정수 2  "+ "=" + " " +( num1 + num2));
		
	}
}

