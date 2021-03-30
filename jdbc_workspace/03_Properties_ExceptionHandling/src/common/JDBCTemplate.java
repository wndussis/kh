package common;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 
 * Service, Dao클래스의 공통부문을 static메소드로 제공
 * 예외처리를 공통부분에서 작성하므로 ,사용(호출)하는 쪽의 코드를 간결히 할수있다.
 *
 */

public class JDBCTemplate {
	
	static	String driverClass;
	static	String url;
	static	String user;
	static	String password;
	
	static {
		//data-source.properties의 내용을 읽어서 변수에 대입하도록 한다
		Properties prop = new Properties();  //properties 객체필요해서 만듬
		String fileName = "resources/data-source.properties";// 파일경로를 String 타입변수 fileName로 선언함
		try {
			prop.load(new FileReader(fileName));
	//		System.out.println(prop);  -  잘 읽어왓나 테스트해봄
			// 변수에 대입한것 
			driverClass = prop.getProperty("driverClass");
			url = prop.getProperty("url");
			user = prop.getProperty("user");
			password = prop.getProperty("password");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
		try {
			//1. DriverClass 등록(최초1회)
			Class.forName(driverClass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public static Connection getConnection() {
		Connection conn = null;
		
		try {
			// * 2. Connection객체 생성 (url,user,password)
			conn = DriverManager.getConnection(url, user, password);
			
			// * 2-1. 자동커밋 (false)설정
			conn.setAutoCommit(false);// false 라고해도 자동커밋됨
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public static void close(Connection conn) { //Connection conn을 인자로 받는 close 메소드
		
		// * 7. 자원반납(conn)
					try {
						if(conn != null)
						   conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
	}
	
	public static void close(ResultSet rset) {
		try {
			if(rset != null)
				rset.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(PreparedStatement pstmt) {
		try {
			if(pstmt != null)
				pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void commit(Connection conn) {
		try {
			    if(conn != null)
			             conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void rollback(Connection conn) {
			try {
				  if(conn != null)
				           conn.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
}
