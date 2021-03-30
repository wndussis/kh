package kh.java.polymorphism.animal;

/**
 *인터페이스 실습
 *
 *컴파일된 결과는 Runnable.class로 클래스와 동일하다.
 *
 *
 */

public interface Runnable {
	
	//상수 public static final 이 자동추가됨
	int LEGS = 4;
	
	//추상메소드 public abstract 가 자동 추가됨
	void run();
	

}
