package kh.java.collection.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ArrayListTest {

	public static void main(String[] args) {
		ArrayListTest a = new ArrayListTest();
//		a.test0()
//		a.test1();
//		a.test2();
//		a.test3();
//		a.test4();
//		a.test5();
//		a.test6();
//		a.test7();
		a.test8();

	}
	/**
	 * Collections.shuffle 사용 ->값  섞어주는것
	 */
	private void test8() {
		
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		System.out.println(list);
		Collections.shuffle(list);
		System.out.println(list);
		Collections.shuffle(list);
		System.out.println(list);
	}
	/**
	 *  ConcurrentModificationException
	 */
	private void test7() {
		List<Student> list = new ArrayList<>();
		list.add(new Student(1,"홍길동"));
		list.add(new Student(2,"신사임당"));
		list.add(new Student(3,"세종대왕"));
		list.add(new Student(4, "장영실"));
		list.add(new Student(5, "이황"));
		
//		for(Student s : list) {  // 반복문 시작부터 끝까지 중에는 리스트 자체를 변경하면 안된다!
//      		System.out.println(s);
//			if(s.getNo() == 5)
//				list.remove(s);  //  반복문 돌아가는동안 삭제 해버렸기 때문에 오류가남
		
		//5번 학생 제거
		//1. 반복문 외부 변수에 idx 저장
//		int idx = -1; // 인덱스가 존재하지 않는경우로 -1 을 둔것.
//		for(int i = 0; i < list.size(); i++) {
//			if(list.get(i).getNo() == 5)
//				idx = i;
//					
//		}
//		System.out.println(idx);
//		if(idx != -1)
//		list.remove(idx);
		
		//2. iterator 사용해서 5번학생 제거
		Iterator<Student> iter = list.iterator();
		while(iter.hasNext() ) {
			Student s = iter.next();
			if(s.getNo() == 5)
				iter.remove(); // 현재 가리키고 있는 Collection 요소를 제거
		}
		
		System.out.println(list);
	}
	/**
	 * 커스텀 클래스 정렬하기
	 */
	private void test6() {
		List<Student> list = new ArrayList<>();
		list.add(new Student(1,"홍길동"));
		list.add(new Student(2,"신사임당"));
		list.add(new Student(3,"세종대왕"));
		list.add(new Student(4, "장영실"));
		list.add(new Student(5, "이황"));
		
		// 기본정렬 : 학번오름차순
//		Collections.sort(list);
//		list.sort(null);  // 기본정렬인 경우 Comparator객체 필요치 않다.
		
		//학번 내림차순
		Collections.sort(list,Collections.reverseOrder());
		
		
		// 추가적인 정렬기준 생성하기
		//1. 이름 오름차순
//		Comparator<Student> comp = new StudentNameAscending();
//		Collections.sort(list, comp);
		
		
		// 2. 이름 내림차순
		Comparator<Student> comp = new StudentNameAscending().reversed();
//		Collections.sort(list, comp);
		list.sort(comp);
		

		System.out.println(list);
		
	}
	/**
	 *  정렬
	 * 1. comparable 인터페이스 
	 *    기본정렬(한가지) 클래스에서 구현.  compareTo 메소드 오버라이딩
	 *    
	 * 2. comparator 인터페이스
	 *     기본정렬외에 추가적으로 정렬기준을 제시해야 할 때.
	 *     별도의 comparator 구현클래스를 작성(개수 제한 없음)
	 *     compare메소드 오버라이딩
	 * 
	 *  
	 */
	private void test5() {
		List<String> list = new ArrayList<>();
		list.add("가버려");
		list.add("나나나~");
		list.add("다나가");
		list.add("허허허");
		
		// 정렬메소드 호출
//		Collections.sort(list); // 기본정렬기준(사전등재순)에 따라 정렬
		
		//사전등재 역순
		Comparator<String> comp = Collections.reverseOrder();
		Collections.sort(list, comp);
		
		
		System.out.println(list);
		
		
		
	}
	/**
	 * 
	 */
	private void test4() {
		//객체 할당부의 제네릭 타입은 생략이 가능 (jdk 1.7이상만)
		List<Integer> list = new ArrayList<>();
		list.add(5);
		list.add(2); 
		list.add(3);
		list.add(1);
		list.add(4);
		list.add(1, 100);  // 1번지에 100 요소 추가
		
		// 삭제메소드
		//1. index로 삭제
//		list.remove(3); // 3번지 지우는것
		
		//2. 동등객체로 삭제 (특정 숫자를 지우고 싶을때) : 객체가 가진 값이 동일한 객체(equals 가 동일한 객체)
		list.remove(new Integer(100)); // 해당 숫자가 지워짐, 숫자 100 지움
		
		// 수정 : 해당인덱스의 객체를 제공된 매개인자로 대체
		list.set(1, 888);
		
		// 다른 collection 객체 추가
		List<Integer> another = new ArrayList<>();
		another.add(7);
		another.add(8);
		another.add(9);
		list.addAll(another);
		
		//매개인자 요소를 포함하고 있는가(동등객체) : boolean
		System.out.println(list.contains(9)); // 매개인자 9를 포함하는지 물음 , true가 출력됨
		
		// 매개인자 요소가 몇번지에 있는가 : int
		System.out.println(list.indexOf(9));
		
		//열람 : 기존 for문 , forEach문, iterator방식
		Iterator<Integer> iter = list.iterator();
		while(iter.hasNext() ) {
			Integer i = iter.next();
			System.out.println(i);
		}
		
		// 모든 요소 삭제
		list.clear();
		
		// 리스트가 비어있는가 ?
		System.out.println(list.isEmpty());
		
		System.out.println(list);
		
		
		
	}
	/**
	 *  test0 을 ArrayList  사용버전으로 변경하기
	 *  
	 *  
		
	 */
	private void test3() {
		ArrayList<Student> list = new ArrayList<Student>();
		
		list.add(new Student(1,"홍길동"));
		list.add(new Student(2,"신사임당"));
		list.add(new Student(3,"세종대왕"));
		
		//1. 마지막에 학생 2명 추가
		
		list.add(new Student(4, "장영실"));
		list.add(new Student(5, "이황"));
		
		//2. 중간의 학생1명 삭제
//		list.remove(2); // 2번지 세종대왕 삭제됨
		
//		list.remove(new Student(3,세종대왕));
		//객체를 전달해 삭제하려면, 전달한 객체와 저장된 객체의 동등성을 인정받아야 한다.
		// 두객체의 equals 비교 결과가 true가 나오도록 equals 를 오버라이딩 해야한다.
		
        System.out.println(new Student(3, "세종대왕").equals(new Student(3, "세종대왕")));
		
		System.out.println(list.remove(new Student(3, "세종대왕")));
		System.out.println(new Student(3, "세종대왕").hashCode());
		System.out.println(new Student(3, "세종대왕").hashCode());
		
		
		
	
		
		//3. 중간에 학생1명 추가 : new Student(6, "뻉덕어멈")
		list.add(0, new Student(6,"뺑덕어멈")); // 인덱스 0번지에 뺑덕어멈 추가
		
		for(Student s : list) {  // forEach문 사용해 출력
			System.out.println(s);
		}
		





		
	}
	/**
	 * Generics 역할 =  타입제한
	 * 
	 * 기본형을 사용할 수 없다.
	 * int - > Integer
	 * double - > Double
	 * 
	 */
	private void test2() {
		List list1 = new ArrayList();
		list1.add("안녕");
		list1.add(123);
		Object e1 = list1.get(0);
		Object e2 = list1.get(1);
		System.out.println(((String)e1).length());  // String 으로 형변환
		
		
		// 다형성 적용
		// <String> 타입변수 지정  : 요소의 타입 제한 한것
		
		List<String> list2 = new ArrayList<String>();  // 제네릭 적용한 예시
		list2.add("안녕");
//		list2.add(123); // String이 아닌 요소는 추가될 수 없다.  컴파일 오류남
		String s1 = list2.get(0);
		System.out.println(s1.length()); // 형변환 없이 호출 가능 , 250번쨰 줄에서 <String>으로 타입제한을 해놨기때문에 String타입밖에 못옴
		
		//Wrapper Class
		List<Integer> list3 = new ArrayList<Integer>();
		list3.add(31); // int 31이 new Integer(31) 로 변환 : auto-boxing ,기본형은 요소로서 추가될수 없다.
		int num = list3.get(0); // new Integer(31) -> 31로 변환됨 : auto-unboxing
		System.out.println(list3);
		
		
	}
	/**
	 *     List
	 * 
	 * java.util.List 인터페이스
	 * java.util.ArrayList 구현클래스
	 * 
	 */
	private void test1() {
		ArrayList list1 = new ArrayList();
		List list2 = new ArrayList();
		Collection list3 = new ArrayList();
		
		//맨 마지막에 요소 추가 add
		list1.add("안녕");
		list1.add(123);
		list1.add(123.456);
		list1.add(true);
		list1.add(new Date());
		list1.add(new Student(1, "고주몽"));
		list1.add(123);
		
		// toString 이 override 되어 있음.
		//저장된 순서유지, 중복허용
		System.out.println(list1);
		
		// 저장된 요소의 개수
		System.out.println(list1.size());
		
		// 삭제 remove
		list1.remove(3); // true 날라가고 뒤에꺼가 앞으로 떙겨와짐
		
		// 중간에 요소추가
		list1.add(3, false); // 3번지에 false 추가
		
		//반복문을 통해 요소에 접근가능: 인덱스 사용이 가능
		for(int i = 0; i < list1.size(); i++) {
			System.out.println(i + " : " + list1.get(i));
		}
		
	}
	/*
	 * 배열의 문제점
	 * 
	 */
	private void test0() {
		
		Student[] arr = new Student[3];
		arr[0] = new Student(1,"홍길동");
		arr[1] = new Student(2,"신사임당");
		arr[2] = new Student(3,"세종대왕");
		
		//1. 학생 2명 추가
		Student[] arr2 = new Student[10]; // 메모리 공간 낭비
		System.arraycopy(arr, 0, arr2, 0, arr.length);
		arr2[3] = new Student(4, "장영실");
		arr2[4] = new Student(5, "이황");
		
		//2.  중간의 학생1명 삭제 
		// 데이터는 중간의 빈자리 없이 관리해야한다. 이렇게 중간에 삭제하면 안됨
//		arr2[2] = null;  // 세종대왕 삭제
		
		arr2[2] = arr2[3];   // 이렇게 앞에부터 자리를 땡겨주어야함
		arr2[3] = arr2[4];
		arr2[4] = null;
		
		//3. 중간에 학생1명 추가 : new Student(6 , "뻉덕어멈");
		
		arr2[4] = arr2[3];
		arr2[3] = arr2[2];
		arr2[2] = arr2[1];
		arr2[1] = arr2[0];
		arr2[0] = new Student(6 ,"뺑덕어멈");
		
		System.out.println(Arrays.toString(arr2));
		
	}

}
