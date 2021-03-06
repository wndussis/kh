package ncs.test2;
/**
 * 주어진 String 데이터를 “,”로 나누어
 *  5개의 실수 데이터들을 꺼내어 합과 평균을 구한다.
단, String 문자열의 모든 실수 데이터를 배열로 만들어 계산한다.
 * 
 *String str = "1.22,4.12,5.93,8.71,9.34";
 */
public class StringTest {

	public static void main(String[] args) {
		String str = "1.22,4.12,5.93,8.71,9.34";
		double data[] = new double[5];
		double sum = 0;
		
		//str 에서 데이터를 분리한다.
		String[] st = str.split("[,]");
		
		//반복문 사용
		int i = 0;
		for(String s : st) {
			//배열에 실수 데이터를 넣는다
			data[i] = Double.parseDouble(s);
			//배열 데이터의 합을 구한다.
			sum += data[i++];
			
		}
		//결과값을 출력한다
		System.out.printf("합계 : %.3f" , sum); // %.3f  는 소수점 3번째 까지 표현한다는 뜻
		System.out.printf("\n평균 : %.3f" ,(sum/i));
		

	}

}
