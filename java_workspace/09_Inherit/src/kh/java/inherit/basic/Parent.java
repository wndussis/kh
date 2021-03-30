package kh.java.inherit.basic;
/**
 * 상속 Inheritance
 * 부모 클래스가 가지고 있는 member변수/메소드를 
 * 자식클래스에서 선언하지 않고, 사용할 수 있게 하는것.
 * 
 * 문법 ▼
 * - public class 자식 클래스  extends 부모클래스 {}
 *
 *- 상속의 이점
 *- 중복을 제거해서 효율적으로 코드관리 가능
 *- 공통적인 코드를 부모 클래스에서 관리할 수 있다.
 *
 *-특징-
 *1. 부모클래스의 필드/메소드는 자식클래스에서 선언없이 사용/접근 가능
 *2. 모든 클래스의 최상위 부모클래스는 Object다. !!!!!!!!!!!!!
 * - 아무 클래스도 상속하지 않았다면 , extends Object 가 생략된 것
 * - Object 의 메소드를 모든 클래스에서 사용가능 ( toString, hashCode, equals ...)
 *3. 부모 클래스의 생성자 , 초기화블럭은 상속안됨.
 *  - 부모클래스의 생성자 호출하는 super()
 * 4. 부모클래스의 메소드는 자식클래스에서 재작성해서 사용가능
 * 5. 부모클래스의 private 필드/메소드는 상속은 가능하지만 직접접근은 불가.
 *   - getter/setter 를 이용해서 접근하기
 *   - 값대입시에 부모생성자 super를 호출해서 부모클래스 안에서 값대입하기
 */

public class Parent extends Object {  //extends Object 가 생략되어있음 
	
	String name;
	int age;
	
	public Parent() {
		System.out.println("Parent 부모 클래스 생성자 호출!");
	}
	
	public void say() {
		System.out.println("제가 애빕니다.");
	}
	
	public void printInfo() {
		System.out.println(name + " ," + age);
	}

}

