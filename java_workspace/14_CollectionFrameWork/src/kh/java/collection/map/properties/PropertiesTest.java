package kh.java.collection.map.properties;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

/**
 * 
 * Properties
 * Key , Value 타입을 String으로 제한한 map 컬렉션
 * 
 * - 파일 입출력 메소드를 지원
 * - 설정정보 표현에 최적화 되있음
 *
 */
public class PropertiesTest {

	public static void main(String[] args) {
		PropertiesTest p = new PropertiesTest();
//		p.test1();
		p.test2();
	}	
	
	/**
	 * 입력
	 */
	private void test2() {
		Properties prop = new Properties();
		
		try {
//			prop.load(new FileReader("userInfo.properties"));
			prop.loadFromXML(new FileInputStream("userInfo.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
//		System.out.println(prop);
		//1.요소 가져오기
		String url = prop.getProperty("url");
		String userName = prop.getProperty("userName");
		String password = prop.getProperty("password");
		System.out.println(url);
		System.out.println(userName);
		System.out.println(password);
		
		//2.전체열람메소드 
		//Enumeration타입
		Enumeration<?> en = prop.propertyNames();  // name(key) 모음
		//<?> 물음표는 모든타입 다 가능하다는 뜻 Object같은것
		while(en.hasMoreElements()) {
			String name = (String)en.nextElement();
			String value = prop.getProperty(name);
			System.out.println(name + " = " + value);
		}
		
	}




	/**
	 * 출력
	 */
	private void test1() {
		Properties prop = new Properties();
		prop.setProperty("url", "http://localhost:9090/kh-java");
		prop.setProperty("userName", "honggd");
		prop.setProperty("password", "1233!@#$");
		
		System.out.println(prop);
		
		//파일에 저장 , 아래에 두 확장자를 가장 많이 쓴다.
		// .properties
		// .xml 사용자 정의 태그
		try {
//			prop.store(new FileWriter("userInfo.properties"), "userInfo.properties");
			prop.storeToXML(new FileOutputStream("userInfo.xml"), "userInfo.xml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}

		
