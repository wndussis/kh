package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * Service, Dao클래스의 공통부분을 static메소드로 제공
 * 예외처리를 공통부분에서(JDBCTemplate) 작성하므로 ,사용(호출)하는 쪽의 코드를 간결히 할수있다.
 *
 */

public class JDBCTemplate {
	//필드로 지정
	static	String driverClass = "oracle.jdbc.OracleDriver";
	static	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	static	String user = "student";
	static	String password = "student";
	
	static {  //  static 초기화 블럭 (최초1회만 실행됨), 클래스가 처음 사용될때 딱 1번 실행됨
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
