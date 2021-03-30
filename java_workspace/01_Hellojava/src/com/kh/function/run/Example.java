package com.kh.function.run;

import java.util.Scanner;


/** 기능 제공용 클래스
 * [문제 1]
 - 메소드명 : public void opSample1(){}
 - 구현 내용 : 
    국어(정수), 영어(정수), 수학(정수), 총점(정수), 평균(실수) 변수 선언하고,
    각 점수를 키보드로 입력받고,
    합계(국어+영어+수학)와 평균(합계/3.0)을 계산하고,
    세 과목의 점수와 평균을 가지고 "합격" 출력
    합격의 조건 : 세 과목의 점수가 각각 40점이상이면서,
                평균이 60점 이상이면 합격, 
                아니면 "불합격" 출력
     
@com.kh.function.Example

 */

public class Example {
	
	public void opSample1() {
		
		int kor, eng, mat, sum;
		double avg;
		
		Scanner num = new Scanner(System.in);
		
		System.out.print("국어 : ");
		kor = num.nextInt();
		
		System.out.print("영어 : ");
		eng = num.nextInt();
		
		System.out.print("수학 : ");
		mat = num.nextInt();
		
		sum = kor + eng + mat;
		
		avg = sum/3.0;
		
		System.out.println("총점 :" + sum);
		System.out.println("평균 :" + avg);
		System.out.println(kor>=40 && eng>=40 && mat>=40 && avg>=60 ? "합격" : "불합격" );
		
		
		
		
	}
	
	/**
	 *[문제 2]
 - 메소드명 : public void opSample2(){}
 - 구현 내용 : 
    변수 선언하고, 키보드로 입력받은 값들을 변수에 기록하고
    변수값을 화면에 출력 확인함
    성별이 'M'이면 남학생, 'M'이 아니면 여학생으로 출력처리함
    => 변수 선언후 입력받음 
    학생이름 (문자열)
    학년 (정수)
    반 (정수)
    번호 (정수)
    성별(M/F) (문자)    //문자열로 입력받은 후, 문자하나 분리해야 함
    성적 (실수)         //소숫점 아래 둘째자리까지 입력받음
 - 출력 예
    3학년 2반 24번 남학생 홍길동은 성적이 95.55이다.
 
	 */
	public void opSample2() {
		Scanner num = new Scanner(System.in);
		
		System.out.print("학생이름 : ");
		String name = num.next();
		
		System.out.print("학년 : ");
		int grade = num.nextInt();
		
		System.out.print("반 : ");
		int cls = num.nextInt();
		
		System.out.print("번호 : ");
		int numb = num.nextInt();
		
		System.out.print("성별 : ");
		char gender = num.next().charAt(0);
		     gender = (gender == 'M' ? gender = '남' : '여');
		
		System.out.print("성적 : ");
		double score = num.nextDouble();
		
		System.out.printf(" %d학년 %d반 %d번 %s 은 성적이 %.2f이다.",grade ,cls, numb, gender, score);
		
		
				
				
		
		
	}

}
