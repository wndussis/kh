package kh.java.collection.set;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * 
 * Collection - Set - HashSet
 *  중복을 허용하지 않는다 , 저장된 순서를 보장하지 않는다.
 *  
 *  LinkedHashSet : 저장된 순서 유지 , 중복을 허용하지 않는다
 *  TreeSet : 오름차순 정렬 지원, 중복을 허용하지 않는다
 *  
 *  
 *
 */
public class HashSetTest {

	public static void main(String[] args) {
		HashSetTest h = new HashSetTest();
//		h.test1();
//		h.test2();
//		h.test3();
//		h.test4();
		h.test5();
		  
	}
	/**
	 * 실습문제
	 * 로또 숫자 출력하기
	 * 
	 * 1 ~45 사이의 중복없는 난수 6개를 오름차순 정렬해서 출력하세요.
	 * 
	 */
	public void test5() {
		Set<Integer> lotto = new TreeSet<>();
		while(lotto.size() < 6)
			lotto.add((int)(Math.random() * 45) + 1);
		System.out.println(lotto);
		
		}
		
		
	

	/**
	 * LinkedHashSet
	 * TreeSet
	 */
	public void test4() {
		
		//  LinkedHashSet 저장된 순서유지
		Set<Integer> set1 = new LinkedHashSet<>();
		set1.add(34);
		set1.add(25);
		set1.add(100);
		set1.add(1);
		System.out.println(set1);
		
		// TreeSet 오름차순 정렬
		Set<Integer> set2 = new TreeSet<>(set1);
		System.out.println(set2);
	
		
	}
	/**
	 * 커스텀 클래스 중복처리
	 */
	public void test3() {
		Set<Person> set = new HashSet<>();
		set.add(new Person("홍길동"));
		set.add(new Person("신사임당"));
		
		set.add(new Person("홍길동"));
		
		System.out.println(set);
	}
	
	/**
	 *  List -> set : 중복 제거하기위해
	 *  
	 *  Set -> List : 순서필요(정렬)
	 *  
	 *  
	 */
	public void test2() {
		
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(1);
		list.add(3);
		list.add(2);
		System.out.println(list);
		
		// set 으로  변환
		Set<Integer> set = new HashSet<>(list);
		System.out.println(set);
		
		// list 로 변환 : 내림차순 정렬
		List<Integer> list2 = new ArrayList<>(set);
		Collections.sort(list, Collections.reverseOrder());
		System.out.println(list);
		
		
		
	}
	public void test1() {
		HashSet<Integer> set1 = new HashSet<>();
		Set<String> set2 = new HashSet<>();
		Collection<Double> set3 = new HashSet<>();
		
		//요소 추가
		set2.add("안녕");
//		set2.add(123); // 제네릭 덕분에 다른 타입의 요소는 추가가 불가능하다. 오류남
		set2.add("hello world");
		set2.add("ㅋㅋㅋ");
		set2.add("ㅋㅋㅋ");
		
		//저장된 요소 개수 확인
		System.out.println(set2.size());
		
		// 인덱스를 통한 요소가져오기는 지원하지 않는다!!!!!
//		set2.get(2)  // 이런거 안됨
		
		//반복문을 통한 전체 열람만 가능
		// 일반 for문은 사용할 수 없다.
		//1. forEach문은 사용가능
		for(String s : set2)
			System.out.println(s);
		
		//2. iterator객체 
		Iterator<String> iter = set2.iterator();
		while(iter.hasNext()) {
			String s = iter.next();
			System.out.println(s);
			
		}
		
		//삭제 : 동등한 객체를 찾아 삭제(equals & hashCode overriding 필수)
		set2.remove("ㅋㅋㅋ");
		// 전체삭제
		set2.clear();
		//비어있는지 검사
		System.out.println(set2.isEmpty());
		
		
		System.out.println(set2);
	}

}
