package kh.java.inherit.shape;
/**
 * Circle  은 has a point 이다  : has a  포함관계 /연관관계
 * 
 * Circle ────> Point
 * 
 * Circle 은 하나의 shape 이다. :  is a 상속관계(일반화관계)
 * Circle ────▷ Shape
 *
 */
public class Circle extends Shape {  // Circle 은 Shape 을 상속한다
	
	private Point center; // center 타입이 Point 인것
	private int r; // 반지름
	
	public Circle() {
		//아무런 필드 대입이 없다면 , 기본값으로 세팅한다.
		this.center = new Point(100,100); //좌표세팅
		this.r = 100;  //반지름
		
		
	}
	public Circle(Point center, int r) {
		super();
		this.center = center;
		this.r = r;
	}
	public Point getCenter() {
		return center;
	}
	public void setCenter(Point center) {
		this.center = center;
	}
	public int getR() {
		return r;
	}
	public void setR(int r) {
		this.r = r;
	}
	/**
	 * override 상속받은 메소드를 고쳐쓸수 있다.
	 * 1. 메소드명, 파라미터 선언부 , 리턴타입 모두 동일해야함!!!
	 *    -@override annotation   // @ 이게 annotation
	 * 2. 접근제한자는 더 넓은 범위로 수정이 가능(private 와 default 는 안됨)
	 *    -private - default - protected - public  // 맨 오른쪽 public이 가장 넓은것
	 *    -private 메소드는 오버라이드 불가
	 *    -default 메소드는 거의없음
	 * 3. 메소드가 던지는 예외클래스는 줄이거나, 자식클래스로 변경가능
	 *  
	 */
	@Override  // 틀린걸 알려준다 오류난걸 알려줌, 안전장치라고 생각해
	public void draw() {
		System.out.println("중심점이 " + center.toString()+ "이고,"
				                 +"반지름이" + r + "인 원을 그리고 있다.");
		
		
	}
	

}
