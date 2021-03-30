package kh.java.oop.access.modifier.class_field;

public class KiwiRun {
	
	public static void main(String[] args) {
		
		Kiwi kw = new Kiwi();
		System.out.println(kw.publicNum);
		System.out.println(kw.protectedNum);
		System.out.println(kw.defaultNum);
//		System.out.println(kw.privateNum);
	}

}
