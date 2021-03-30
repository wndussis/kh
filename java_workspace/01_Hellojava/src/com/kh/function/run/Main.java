package com.kh.function.run;

/**
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

public class Main {
	
	public static void main(String[] args) {
		
		Example subj = new Example();
		subj.opSample1();
		subj.opSample2();
		
		
		
	}

	

}
