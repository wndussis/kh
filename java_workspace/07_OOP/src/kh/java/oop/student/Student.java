package kh.java.oop.student;

/**
 * 
 * class 작성 => 객체(object(개념) , instance(메모리조각))
 * 
 *  클래스 = 틀, 설계도
 *
 *클래스를 프로그램이 지향하는 바에 따라 설계하는 것을 추상화 라고 한다.
 *
 */

public class Student {
	// field  :  학생 객체의 속성(정적인(고정된) data) ,클래스 영역에 작성
   private String name;
   private int point;
   
   public void setName(String name) {
		this.name = name;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	
	public String getName() {
		return this.name;
	}
	public int getPoint() {
		return this.point;
	}
	
	
	
	//method : 학생객체의 기능
	public void printStudentInfo() {
		//method에서는 field를 참조할 수 있다.
//		System.out.println("이름 : " + name);
//		System.out.println("점수 : " + point);
		System.out.println(name + "님의 점수는" + point + "점입니다.");
	}
	
     

}
