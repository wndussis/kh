package kh.java.inherit.basic;

public class Child1 extends Parent { //상속한것 extends 사용해서
	/**
	 * super(); 는 부모 생성자를 호출
	 * 생략해도 jvm이 자동으로 생성해서 호출
	 * 무조건 맨 첫줄에 작성해야함!!!!!!!
	 * this 와 동시 사용 불가 !!!
	 */
	
	public Child1() {
//		super(); // 부모 생성자를 호출하는 키워드 ! ,안적어도 원래 생략되어있음 
		System.out.println("Chile1생성자호출!");
	}
	/**
	 * 메소드 재작성 Override (덮어쓴다),수정할때 이렇게 씀
	 */
	public void say() {
		System.out.println("제가 첫째 입니다.");
	}
	// Parent 에는 없는 기능을 추가
	public void game() {
		System.out.println("첫째가 게임을 합니다.");
	}

}
