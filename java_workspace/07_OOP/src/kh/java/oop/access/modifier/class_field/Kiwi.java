package kh.java.oop.access.modifier.class_field;
/**
 * 
 * 접근 제한자
 * 
 * field / method 
 * 1. public - 다른 패키지, 다른 클래스 모두 가능 !!!
 * 2. protected - 같은 패키지 가능 , 다른 패키지라도 상속관계는 접근가능
 * 3. default(작성금지) 그냥 비워두는것 - 같은 패키지 에서만 접근 가능
 * 4. private - 같은 클래스 내에서만 접근 가능
 *
 
 */

public class Kiwi {
	
	public int publicNum = 100;
	protected int protectedNum = 90;
	int defaultNum = 80;
	private int privateNum = 70;
	

}
