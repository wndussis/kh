package kh.java.oop.field;

public class Main {
	
	public static void main(String[] args) {
		
		GalaxyNote20 ph1 = new GalaxyNote20();
		ph1.setOwner("김한성");
		ph1.setPhoneNumber("01012341234");
		System.out.println(ph1.getOwner() + " : " + ph1.getPhoneNumber());
		//static 변수는 class명으로 접근해야 한다.
		System.out.println(GalaxyNote20.WIDTH);
		
		
		GalaxyNote20 ph2 = new GalaxyNote20();
		ph2.setOwner("홍길동");
		ph2.setPhoneNumber("01088887777");
		System.out.println(ph2.getOwner() + " : " + ph2.getPhoneNumber());
		System.out.println(GalaxyNote20.WIDTH);
		
	}
}
