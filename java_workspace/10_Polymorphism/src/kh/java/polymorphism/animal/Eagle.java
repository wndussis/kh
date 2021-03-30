package kh.java.polymorphism.animal;

public class Eagle extends Animal implements Flyable {
	
	@Override
	public void attack() {
		System.out.println("날개를 펼친다!");
	}
	
	@Override
	public void fly(String sound) {
		System.out.println("날개를 활짝 펴고 앉는다~" + sound);
	}
	
	

}
