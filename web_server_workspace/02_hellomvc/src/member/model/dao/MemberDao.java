package member.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import member.model.vo.Member;

public class MemberDao {
	private Properties prop = new Properties();
	/**
	 * MemberDao객체 생성시(최초1회) member-query.properties의 내용을 읽어서
	 * prop에 저장한다
	 * dao메소드 호출시마다 prop으로 부터 sql문을 받는다
	 * @param conn
	 * @return
	 */
	public MemberDao() {
		String fileName = MemberDao.class.getResource("/sql/member/member-query.properties").getPath();
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public Member selectOne(Connection conn,String memberId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
//		String sql = "select * from member where member_id = ?";
		String sql = prop.getProperty("selectOne");
		Member member = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				memberId = rset.getString("member_id");
				String password = rset.getString("password");
				String memberName = rset.getString("member_name");
				String memberRole = rset.getString("member_role");
				String gender = rset.getString("gender");
				Date birthday = rset.getDate("birthday");
				String email = rset.getString("email");
				String phone = rset.getString("phone");
				String address = rset.getString("address");
				String hobby = rset.getString("hobby");
				Date enrollDate = rset.getDate("enroll_date");
				member = new Member(memberId, password, memberName, memberRole, gender, birthday, email, phone, address, hobby, enrollDate);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return member;
	}
	public int insertMember(Connection conn,Member m) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getMemberId());
			pstmt.setString(2, m.getPassword());
			pstmt.setString(3, m.getMemberName());
			pstmt.setString(4, m.getMemberRole());
			pstmt.setString(5, m.getGender());
			pstmt.setDate(6, m.getBirthday());
			pstmt.setString(7, m.getEmail());
			pstmt.setString(8, m.getPhone());
			pstmt.setString(9, m.getAddress());
			pstmt.setString(10, m.getHobby());
			pstmt.setDate(11, m.getEnrollDate());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	 
	
	  public int deleteMember(Connection conn, String membmerId) {
			int result = 0;
			PreparedStatement pstmt = null;
			String query = prop.getProperty("deleteMember"); 

			try {
				//미완성쿼리문을 가지고 객체생성.
				pstmt = conn.prepareStatement(query);
				//쿼리문미완성
				pstmt.setString(1, membmerId);
				
				//쿼리문실행 : 완성된 쿼리를 가지고 있는 pstmt실행(파라미터 없음)
				//DML은 executeUpdate()
				result = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return result;
		}


	public int updateMember(Connection conn, Member member) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("updateMember"); 

		try {
			//미완성쿼리문을 가지고 객체생성.
			pstmt = conn.prepareStatement(query);
			//쿼리문미완성
			pstmt.setString(1, member.getPassword());
			pstmt.setString(2, member.getMemberName());
			pstmt.setString(3, member.getGender());
			pstmt.setDate(4, member.getBirthday());
			pstmt.setString(5, member.getEmail());
			pstmt.setString(6, member.getPhone());
			pstmt.setString(7, member.getAddress());
			pstmt.setString(8, member.getHobby());
			pstmt.setString(9, member.getMemberId());
			
			//쿼리문실행 : 완성된 쿼리를 가지고 있는 pstmt실행(파라미터 없음)
			//DML은 executeUpdate()
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}


	

	
}