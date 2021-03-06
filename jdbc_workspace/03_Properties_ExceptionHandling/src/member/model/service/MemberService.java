package member.model.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import common.JDBCTemplate;
import member.model.dao.MemberDao;
import member.model.vo.Member;

import static common.JDBCTemplate.*;

/**
 * Service 에서 하는거
 * 1. DriverClass 등록(최초1회)
 * 2. Connection객체 생성 (url,user,password)
 * 2-1. 자동커밋 (false)설정
 * 6.트랜잭션처리(DML만) commit/rollback
 * 7. 자원반납(conn)
 *  
 * 
 * DAO 에서 하는거
 * 3.PreparedStatement객체 생성 (미완성쿼리- 물음표가있는거)
 * 3-1. ? 값대입
 * 4. 실행과 동시에 리턴값 받음  DML(executeUpdate) -> int 정수형으로 리턴,
 *                       DQL(executeQuery) -> ResultSet 으로 리턴
 * 4-1. ResultSet을 자바객체로 옮겨담기   
 * 5. 자원반납(생성역순 rset - pstmt - conn)
 */

public class MemberService {
	
	private MemberDao memberDao = new MemberDao();
	
	public List<Member> selectAll() {
		Connection conn = getConnection(); //static 메소드라서 글씨체가 다름 getConnection
		List<Member> list = memberDao.selectAll(conn);
		close(conn); //static 메소드라서 글씨체가 다름 close
		return list;
	}
	
	/*
	   1. DriverClass 등록(최초1회)
	 * 2. Connection객체 생성 (url,user,password)
	 * 2-1. 자동커밋 (false)설정
	 * ------Dao 요청----------
	 * 6.트랜잭션처리(DML만) commit/rollback
	 * 7. 자원반납(conn)
	*/

	public List<Member> selectAll_() {
		String driverClass = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "student";
		String password = "student";
		Connection conn = null;
		List<Member> list = null;
		
		try {
			//1. DriverClass 등록(최초1회)
			Class.forName(driverClass);
			// * 2. Connection객체 생성 (url,user,password)
			conn = DriverManager.getConnection(url, user, password);

			// * 2-1. 자동커밋 (false)설정
			conn.setAutoCommit(false);// false 라고해도 자동커밋됨
			
			//-----------DAO 요청------------------
			//Connection객체 전달 .   중요 !!!!!!
			list = memberDao.selectAll(conn);
			// * 6.트랜잭션처리(DML만) commit/rollback
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// * 7. 자원반납(conn)
			try {
				if(conn != null)
				   conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public int insertMember(Member member) {
		Connection conn = getConnection();
		int result = memberDao.insertMember(conn,member);
		if(result > 0) 
				commit(conn);
		else 
				rollback(conn);
		close(conn);	
		return result;
	}

	public Member selectOneMember(String memberId) {
		
		//1. Connection객체 생성
				Connection conn = getConnection();
				//2. dao에 Connection객체, memberId를 전달해서 Member객체를 리턴받음.
				Member m = memberDao.selectOneMember(conn, memberId);
				//3. Connection 자원반납
				close(conn);
				
//				System.out.println("member@service="+m);
				return m;
			}
			
	
	

			public List<Member> selectByName(String memberName) {
				Connection conn = getConnection();
				List<Member> list = memberDao.selectByName(conn, memberName);
				close(conn);
				return list;
			}
			
			public Member selectOne(String memberId){
				Connection conn = getConnection();
				Member m = memberDao.selectOne(conn, memberId);
				close(conn);
				return m;
			}
			
			public int updateMember(Member m) {
				Connection conn = getConnection();
				int result = memberDao.updateMember(conn, m);
				if(result > 0) commit(conn);
				else rollback(conn);
				close(conn);
				return result;
			}
			
			public int deleteMember(String memberId) {
				Connection conn = getConnection();
				int result = memberDao.deleteMember(conn, memberId);
				if(result > 0) commit(conn);
				else rollback(conn);
				close(conn);
				return result;
			}


	

}
