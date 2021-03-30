package ncs.test1;

public class ArrayTest {
	
	public static void main(String[] args) {
		
		int [][] array = {{12,41,36,56,21},
				            {82,10,12,61,45},
				            {14,16,18,78,65},
				            {45,26,72,23,34}};
		
		double sum = 0;
		double num =0;
		
		for(int i =0; i < array.length; i++) {
			for(int k = 0; k < array[i].length; k++) {
				sum += array[i][k];
				num++;
			}
		}
		
		System.out.println("합계 : " + sum);
		System.out.printf("평균 : %.2f" , (double)sum/num );
		
		
		

	}
}
