package kh.java.api.datetime;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 
 * java.util.Calendar
 * java.util.Date - 기본생성자, long타입 생성자를 제외하고 사용금지!!! deprecated
 * 
 * java.time.LocalDateTime
 *
 */
public class DateTimeTest {

	public static void main(String[] args) {
		DateTimeTest dt = new DateTimeTest();
//		dt.test1();
//		dt.test2();
		dt.test3();

	}
	/**
	 * Date()
	 * Date(long millis)
	 * 위에 생성자만 사용가능하다.
	 * 
	 */
	public void test3() {
		
		Date now = new Date(); // 현재 시각 정보 확인
		System.out.println(now);
		
		// 캘린더를 객체로 변환하기
		Calendar cal = Calendar.getInstance();
		cal.setTime(now);
		
		System.out.println(cal);
		
		
		// 캘린더를 Date 로 변환
	    long millis = cal.getTimeInMillis();
		Date date = new Date(millis);
		
		System.out.println(date);
		
		
	   
		
	}
	/**
	 * 특정일 , 특정시각을 Calendar 객체로 생성하기
	 */
	public void test2() {
		Calendar cal1 = Calendar.getInstance();
		cal1.set(2021,0,1,0,0,0); // 순서대로 년 , 월, 일 , 시 ,분, 초  적은것
		printCalendar(cal1);
		
		Calendar cal2 = new GregorianCalendar(2021 , 1 , 1 , 0 , 0 , 0); // 생성자 이용하는 방법
		printCalendar(cal2);
		
		//날짜 차이 계산하기
		Calendar now = Calendar.getInstance();
		// 밀리초 단위로 변환(getTimeInMillis 사용)해서 차이를 구한후 , 다시 초,분,시,일 단위로 환산하기
		// 밀리초 = unix second : 1970년 1월 1일 자정기준으로 흐른 밀리초
		long num1 = now.getTimeInMillis();
		long num2 = cal1.getTimeInMillis();
		// millis / 1000 은(초)  / 60 은 (분) / 60 은 (시) /24 는 (일)
		long diff = (num2 - num1) / 1000 / 60 / 60 /24;
		
		System.out.println(diff);
		System.out.println("새해까지 D-" + (diff +1) + "일 남았습니다.");
		
//		System.out.println(num1);
//		System.out.println(num2);
		
	}
	/**
	 * Calendar
	 */
	public void test1() {
		//현재 날짜, 시각 정보 조회
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = new GregorianCalendar();
		
//		System.out.println(cal1);
		
		//조회
	    System.out.println(cal1.get(Calendar.YEAR));
	    System.out.println(cal1.get(Calendar.MONTH) + 1); //momth 는 0부터 11까지라서 +1 을 해줘야 원래대로 나옴
	    System.out.println(cal1.get(Calendar.DATE));
	    
	    System.out.println(cal1.get(Calendar.HOUR));
	    System.out.println(cal1.get(Calendar.HOUR_OF_DAY));
	    System.out.println(cal1.get(Calendar.MINUTE));
	    System.out.println(cal1.get(Calendar.SECOND));
	    
	    //요일  , 요일은 1부터 시작  달 은 0 부터
	  //  ( 일요일 = 1 , 월요일 = 2 , 화 = 3, 수 = 4 , 목 = 5 , 금 = 6 , 토 =7 로 리턴함)
	    System.out.println(cal1.get(Calendar.DAY_OF_WEEK)); // 3  나옴
	    char[] dayOfWeek = {'일' , '월' , '화' , '수' ,  '목' , '금' , '토' };
	    System.out.println(dayOfWeek[cal1.get(Calendar.DAY_OF_WEEK) -1 ]);
	    
		
	}
	/**
	 * yyyy/MM/dd   hh24 : mm : ss
	 * 
	 */
	public void printCalendar(Calendar c) {
		System.out.printf("%d/%02d/%02d %02d:%02d:%02d%n" ,
				               c.get(Calendar.YEAR),
				               c.get(Calendar.MONTH) + 1,
				               c.get(Calendar.DATE) ,
				               c.get(Calendar.HOUR_OF_DAY) ,
				               c.get(Calendar.MINUTE) ,
				               c.get(Calendar.SECOND)
				               
		);
	}

}
