package member.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import member.model.vo.Member;

/**
 * DAO
 * Data Access Object
 * DB에 접근하는 클래스, DB에 접근하는건 DAO 혼자 다함.
 * 
 *    DAO 절차순서
 *    
 * 1. 드라이버클래스 등록(최초1회)
 * 2. Connection객체 생성(url, user, password) 
 * 3. 자동커밋여부 설정 : true(기본값) 자동커밋됨 / false로 하면 -> app에서 직접 트랜잭션 제어
 * 4. PreparedStatement객체생성(미완성쿼리 -> 값대입이 안되어있는 상태) 및 값대입
 * 5. Statement객체 실행. DB에 쿼리 요청
 * 6. 응답처리 DML:int리턴, DQL:ResultSet리턴->자바객체로 전환하는 과정 필요(DQL만)
 * 7. 트랜잭션처리(DML만)
 * 8. 자원반납(생성의 역순)
 * 
 * 자원반납(생성역순 rset - pstmt - conn)- DQL 인 경우
 * 				(pstmt - conn)- DML 인 경우
 *
 */

public class MemberDao {
	//다른 메소드에서도 사용할 수 있게 필드에 위치시킴
	String driverClass = "oracle.jdbc.OracleDriver";  //드라이버클래스 등록
	String url = "jdbc:oracle:thin:@localhost:1521:xe"; //Connection객체 생성 / 형식 => DB 드라이버 타입 @ ip주소 or 도메인 : port번호 :실제 DB 이름
	String user = "student";
	String password = "student";  // 패스워드는 대소문자 구별함 !

	public int insertMember(Member member) {
		//밑에서 사용할 것들을 미리 지역변수로 선언함 
		Connection conn = null;  
		PreparedStatement pstmt = null; //  PreparedStatement 는 쿼리를 실행하는 객체다 !
		String sql = "insert into member values(?, ?, ?, ?, ?, ?, ?, ?, ?, default)"; //실제 값 들어갈 부분은 ? 물음표로 처리 , enroll date 니까 default 해줌
		int result = 0;
		
		try {
			//1. 드라이버클래스 등록(최초1회)   , 드라이버클래스 = 시작점 같은 클래스
			Class.forName(driverClass);  // 클래스 등록 (예외처리 해야함 try catch 절로)
			//2. Connection객체 생성(url, user, password)
			conn = DriverManager.getConnection(url, user, password);
			//3. 자동커밋여부 설정(DML) : true(기본값)/false -> app에서 직접 트랜잭션 제어
			conn.setAutoCommit(false); //직접 트랜잭션 제어 하기위해 false로 함
			//4. PreparedStatement객체생성(미완성쿼리) 및 값대입
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberId()); //첫번째 물음표에 값 넣기
			pstmt.setString(2, member.getPassword());  
			pstmt.setString(3, member.getMemberName());
			pstmt.setString(4, member.getGender());
			pstmt.setInt(5, member.getAge());
			pstmt.setString(6, member.getEmail());
			pstmt.setString(7, member.getPhone());
			pstmt.setString(8, member.getAddress());
			pstmt.setString(9, member.getHobby()); // 9번째 물음표에 값 넣기
			
			//5. Statement객체 실행. DB에 쿼리 요청
			//6. 응답처리 DML:int리턴, DQL:ResultSet리턴->자바객체로 전환
			result = pstmt.executeUpdate();  // 5,6번 같이 처리한것, DML 인 경우엔 executeUpdate 사용, DQL 인 경우엔 executeQuery 사용
											 //정상적으로 처리되었으면 1이 리턴됨 
			//7. 트랜잭션처리(DML)
			if(result > 0)
				conn.commit(); //커밋호출
			else 
				conn.rollback();

		} catch (ClassNotFoundException e) {
			//ojdbc6.jar 프로젝트 연동실패!
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//8. 자원반납(생성의 역순)
			try {
				if(pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	public List<Member> selectAll() {
		// finally절 에서도 접근가능하도록 여기에 선언함 지역변수로
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "select * from member order by enroll_date desc";  // DQL
		List<Member> list = null;
		
		try {
			//1. 드라이버클래스 등록(최초1회)
			Class.forName(driverClass);
			//2. Connection객체 생성(url, user, password) 
			//3. 자동커밋여부 설정 : true(기본값) 자동커밋됨 / false로 하면 -> app에서 직접 트랜잭션 제어
			conn = DriverManager.getConnection(url, user, password);  // 여긴 DQL 이라서 conn.setAutoCommit(false); 이게 필요없다
			
			//4. PreparedStatement객체생성(미완성쿼리 -> 값대입이 안되어있는 상태) 및 값대입
			pstmt = conn.prepareStatement(sql);  //값대입 할게 없어서 넘어감, 회원전체조회 니까 
			//5. Statement객체 실행. DB에 쿼리 요청
			rset = pstmt.executeQuery(); //DQL 이라서 executeQuery 사용
			//6. 응답처리 DML:int리턴, DQL:ResultSet리턴->자바객체로 전환하는 과정 필요(DQL만)
			//다음행 존재여부리턴, 커서가 다음행에 접근.
			list = new ArrayList<>(); //객체할당
			while(rset.next()) {
				//컬럼명은 대소문자를 구분하지 않는다.
				String memberId = rset.getString("member_id"); //컬럼의 값을 가져와서 자바 변수에 각각 담은것 !
				String password = rset.getString("password");
				String memberName = rset.getString("member_name");
				String gender = rset.getString("gender");
				int age = rset.getInt("age");
				String email = rset.getString("email");
				String phone = rset.getString("phone");
				String address = rset.getString("address");
				String hobby = rset.getString("hobby");
				Date enrollDate = rset.getDate("enroll_date");
				
				// 반복문(while)을 거치면 리턴된 모든행의 정보를 Member 객체를 생성해서 list 에 차곡차곡 더해줌
				Member member = new Member(memberId, password, memberName, gender, age, email, phone, address, hobby, enrollDate);
				list.add(member); // list 에 추가


			}
			
			
			//7. 트랜잭션처리(DML만) , DQL 일땐 트랜잭션 처리 안해도됨
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			//8. 자원반납(생성의 역순)
			try {
				if(rset != null)
				rset.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(pstmt != null)
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(conn != null)
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
		}
		
		
		return list;   // null 로 되어있는거 바꾸는거 중요 !!!!!!!!!!!!!!!!!!!!!!!!
	}

	public Member selectOne(String memberId) {  //String memberId = 매개변수
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "select * from member where member_id = ?";
		Member member = null;
		
		try {
			//1. 드라이버클래스 등록(최초1회)
			Class.forName(driverClass);
			//2. Connection객체 생성(url, user, password) 
			//3. 자동커밋여부 설정 : true(기본값)/false -> app에서 직접 트랜잭션 제어
			conn = DriverManager.getConnection(url, user, password);
			//4. PreparedStatement객체생성(미완성쿼리) 및 값대입  , ? 물음표가 있으면 값대입 해줘야함
			pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, memberId);//select * from member where member_id = 'honggd' , 첫번째 물음표에 memberId를 입력해주세요 라는 뜻
			//5. Statement객체 실행. DB에 쿼리 요청
			rset = pstmt.executeQuery();
			//6. 응답처리 DML:int리턴, DQL:ResultSet리턴->자바객체로 전환
			//다음행 존재여부리턴. 커서가 다음행에 접근.
			while(rset.next()) {
				//컬럼명은 대소문자를 구분하지 않는다.
				memberId = rset.getString("member_id"); // 매개변수로 위에서  String memberId 를 선언해놔서 여기에서 또 쓸수 없어서 memberId 라고만 씀
				String password = rset.getString("password");
				String memberName = rset.getString("member_name");
				String gender = rset.getString("gender");
				int age = rset.getInt("age");
				String email = rset.getString("email");
				String phone = rset.getString("phone");
				String address = rset.getString("address");
				String hobby = rset.getString("hobby");
				Date enrollDate = rset.getDate("enroll_date");
				
				member = new Member(memberId, password, memberName, gender, age, email, phone, address, hobby, enrollDate);
			}
			//7. 트랜잭션처리(DML)
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//8. 자원반납(생성의 역순)
			try {
				if(rset != null)
					rset.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return member;
	}

	public List<Member> selectByName(String memberName) {
		List<Member> list = new ArrayList<Member>();
		
		//사용후 반납해야할(close)자원들은 try~catch문 바깥에서 선언해야 한다.
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from member where member_name like ?";
		try {
				//2. 등록된 클래스를 이용해서 db연결함
				//통행권 Connection 객체생성
					conn = DriverManager.getConnection(url,user,password);
					
				//3.쿼리문을 실행할 statement객체 생성
					pstmt = conn.prepareStatement(query);
					pstmt.setString(1, "%" + memberName + "%");
				
				//4.쿼리문 전송, 실행결과 받기
				rset = pstmt.executeQuery();
				
				//5.받은 결과값들을 객체에 옮겨 저장하기
				//rset 가 null인경우는 모두 Exception처리된다.
				
				while(rset.next()) {
							//커서가 가리키는 다음행에서 컬럼 정보를 읽어온다.
							String memberId = rset.getString("member_id");
							String password = rset.getString("password");
							memberName = rset.getString("member_name");
							String gender = rset.getString("gender");
							int age = rset.getInt("age");
							String email = rset.getString("email");
							String phone = rset.getString("phone");
							String address = rset.getString("address");
							String hobby = rset.getString("hobby");
							Date enrollDate = rset.getDate("enroll_date");
							
							Member m = new Member(memberId, password,memberName,
													gender,age,email,phone,
													address,hobby,enrollDate);
							list.add(m);
							
				       }
		      } catch (Exception e) {
		    	  e.printStackTrace();
		      } finally {	  
				
					//자원반납 순서는 생성의 역순이다.
				try {	rset.close();
						pstmt.close();
						conn.close();
				} catch (SQLException e) {
					       e.printStackTrace();
				}
		   }
		
		return list;
	}
	
	public int updateMember(Member m) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		//키워드, 값 사이의 공란주의 !!!
		String query = "update member set "
					 + " password=?"
					 + ",email=?"
					 + ",phone=?"
					 + ",address=?"
					 + " where member_id=?";
		
		try {
			//2. 드라이버매니져로부터 connection객체 얻기
			conn = DriverManager.getConnection(url, user, password);
			conn.setAutoCommit(false); //DML요청이라서
			//3. 미완성쿼리 생성 및 갑대입, 실행
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, m.getPassword());
			pstmt.setString(2, m.getEmail());
			pstmt.setString(3, m.getPhone());
			pstmt.setString(4, m.getAddress());
			pstmt.setString(5, m.getMemberId());
			result = pstmt.executeUpdate();
			
			//커밋처리
			if(result>0) conn.commit();
			else conn.rollback();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

	public int deleteMember(String memberId) {
				int result = 0;
				Connection conn = null;
				PreparedStatement pstmt = null;
				
				String query = "delete from member where member_id = ?";
				
						try {
							conn = DriverManager.getConnection(url, user, password);
							conn.setAutoCommit(false);
							pstmt = conn.prepareStatement(query);
							pstmt.setNString(1, memberId);
							result = pstmt.executeUpdate();
							
							//커밋처리
								if(result > 0) conn.commit();
								else conn.rollback();
						} catch (Exception e) {
								e.printStackTrace();
						} finally {
								try {
									pstmt.close();
									conn.close();
									
								
						} catch (SQLException e) {
							e.printStackTrace();
					}
			}		
		return result;
	}

}		
		
		


