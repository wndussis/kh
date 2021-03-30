package kh.java.oop.field;
/**
 * 변수별 생명주기
 * 
 * 프로그램
 * main 시작 ----------------------> main 끝
 * 
 * 지역변수 -        메소드 호출시 -----> 메소드 리턴
 * 멤버변수 -        객체생성시 -----------> 객체소멸(garbage collector 에 의해 제거됨)
 * 클래스변수 -     프로그램 시작시-----------------------> 프로그램 종료
 *                    (해당클래스 최초 호출시)
 */
public class GalaxyNote20 {
	
	//전역변수 - 메소드 안에서 얼마든지 접근 가능
	//멤버변수 : instance변수, non-static변수
	private String owner;
	private String phoneNumber;
	
	//클래스 변수 : static 변수
	// 공유 목적 : 모든 객체가 공유할 값
	public static int width = 10;
	public static int height = 20;
	
	//매개변수도 하나의 지역변수
		public void heyBixby(String str) {
			//지역변수 : 접근제한자, static 키워드 사용불가
			int a = 10;
		}
		
		public void setOwner(String owner) {
			this.owner = owner;
		}
		public String getOwner() {
			return owner;
		}
		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
		public String getPhoneNumber() {
			return phoneNumber;
		}
	}

	
	