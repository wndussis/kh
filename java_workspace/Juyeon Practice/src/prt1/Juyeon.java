package prt1;

public class Juyeon {
	public static void main(String[] args) {
		Juyeon b = new Juyeon();
//		b.test1();
//		b.test2();
		b.test3();
	
	}
	public void test3() {
		
			int i = 1;
			while(true) {
				System.out.println(i);
				if(i++ == 100) {
					break;
					
				}
			}
			System.out.println("종료!");
	}
	public void test2() {
		
		// 1 2 3 4 5 6 7 8 9 10
		
		int i = 1;
		while(i <= 10) {
			System.out.print(i + " ");
			i++;
		}
		
	}
	public void test1() {
//		for(int i = 0; i < 10; i++) {
	//		System.out.println("HelloWorld"~);
//		}
		
		int i = 0;
		while(i < 10) {
			System.out.println("Hello World" +  i);
			i++;
		}
		
	}

}
