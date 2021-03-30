package kh.java.io.byte_.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileIOTest {

	public static void main(String[] args) {
		FileIOTest f = new FileIOTest();
		f.test1();
		
		f.test2();
		System.out.println("----정상 종료----");

	}
	/**
	 * 내 컴퓨터의 이미지파일을 복사해서 byte폴더 하위에 위치시킬것.
	 * 경로상의 한글을 피할것.
	 */
	public void test2() {  /////////////강의 다시보고 내가 해보기 !!!!! 오후 7시4분부터 들으면됨
		
	}
	public void test1() {
		String filePath = "test.txt";
		String copyPath = "byte/test_copy.txt";
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		
		try {
			 fis = new FileInputStream(filePath);
			 fos = new FileOutputStream(copyPath);
			 
			 int data = 0; // 읽어온 데이터를 담을 변수
			 
			 while((data = fis.read()) != -1) {  // 여기서 -1 은 더이상 읽을값 없음 이란 의미 !
				 System.out.print((char)data ); //char 로 형변환한것
				 fos.write(data);
			 }
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
				fos.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
