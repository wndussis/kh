package member.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static common.JDBCTemplate.close;

import member.model.exception.ProductException;
import member.model.vo.Product;



public class ProductDao {
	
	private Properties prop = new Properties();
	/**
	 * 1.ProductDao객체 생성시(최초1회)
	 * member-query.properties의 내용을 읽어다 prop에 저장한다.
	 * 
	 * 2.dao메소드 호출시마다 prop으로부터 query를 가져다 사용한다.
	 * 
	 */
	
	public ProductDao() { // 기본생성자 만듬
		//member-query.properties -> prop 으로 가져오는 코드!!!
		String fileName = "resources/member-query-.properties";
		try {
			prop.load(new FileReader(fileName)); // load 는 메소드다
//			System.out.println(prop);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	
	
	/**
	 * 
	 * DAO 에서 하는거
	 * 3.PreparedStatement객체 생성 (미완성쿼리- 물음표가있는거)
	 * 3-1. ? 값대입
	 * 4. 실행과 동시에 리턴값 받음  DML(executeUpdate) -> int 정수형으로 리턴,
	 *                       DQL(executeQuery) -> ResultSet 으로 리턴
	 * 4-1. ResultSet을 자바객체로 옮겨담기   
	 * 5. 자원반납(생성역순 rset - pstmt)
	 *
	 */

	public List<Product> selectAll(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectAll"); //가입일 역순으로 조회했음
		List<Product> list = null;
		
	
		try {
					//3.PreparedStatement객체 생성 (미완성쿼리- 물음표가있는거)
					pstmt = conn.prepareStatement(sql);
					//* 3-1. ? 값대입 - 여기선 필요없음 이미 값 대입 되어있어서
					
					// * 4. 실행과 동시에 리턴값 받음  DML(executeUpdate) -> int 정수형으로 리턴,
					//*                       DQL(executeQuery) -> ResultSet 으로 리턴
					rset = pstmt.executeQuery();
					//* 4-1. ResultSet을 자바객체로 옮겨담기  
					list = new ArrayList<>();
					while(rset.next()) {
				
						String productId = rset.getString("product_id");
					    String productName = rset.getString("product_name");
						String description = rset.getString("description");
						int price = rset.getInt("price"); 		
					    int stock = rset.getInt("stock");
						int iono = rset.getInt("io_no");
					    int amount = rset.getInt("amount");
					    Date ioDate = rset.getDate("io_date");
						Product product = new Product(productId, productName, description, price, stock, iono, amount, ioDate);
						list.add(product);
					    
					    }
			
			
			} catch (SQLException e) {
				//		e.printStackTrace();
			    // 예외를 전환 : RuntimeException, 의미분명한 커스텀 예외객체로 전환
				throw new ProductException("회원 전체 조회", e);
				
			} finally {
				//5. 자원반납(생성역순 rset - pstmt)
				close(rset);
				close(pstmt);
			}
			
			return list;
		}
	
	public int insertProduct(Connection conn, Product p) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertProduct");
		
		try {
			//PreparedStatment객체 생성, 미완성 쿼리 값대입
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,p.getProductId());
			pstmt.setString(2,p.getProductName());
			pstmt.setString(3,p.getDescription());
			pstmt.setInt(4,p.getPrice());
			pstmt.setInt(5,p.getStock());
			pstmt.setInt(6,p.getIono());
			pstmt.setInt(7,p.getAmount());
			pstmt.setDate(8,p.getIoDate());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
//		System.out.println("result@dao="+result);
		
		return result;
	}

	public Product selectOneProduct(Connection conn, String productId) {
		Product p = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "select * from product_stock where product_id = ?";
		
		try {
			//1. PreparedStatement객체 생성, 미완성 쿼리 값대입
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, productId);
			
			//2. 쿼리 실행, ResultSet => Member
			rset = pstmt.executeQuery();
			while(rset.next()) {
				p = new Product();
				p.setProductId(rset.getString("product_id"));
				p.setProductName(rset.getString("product_name"));
				p.setDescription(rset.getString("description"));
				p.setPrice(rset.getInt("price"));
				p.setStock(rset.getInt("stock"));
				p.setIono(rset.getInt("iono"));
				p.setAmount(rset.getInt("amount"));
				p.setIoDate(rset.getDate("iodate"));
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//3. ResultSet, PreparedStatement객체 반납
			close(rset);
			close(pstmt);
		}
		
//		System.out.println("member@dao="+m);
		
		return p;
	}
	
	

	/**
	 * 아이디를 가지고 회원정보조회
	 * 
	 * @param memberId
	 * @return
	 */
	public Product selectOne(Connection conn, String memberId){
		Product m = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		//미리준비된 statement(query)
		String query = "select * from member where member_id=?";
		
		try {
			//미완성쿼리문을 가지고 객체생성함
			pstmt = conn.prepareStatement(query);
			//쿼리문 완성작업
			pstmt.setString(1, memberId);
			//쿼리문실행
			//pstmt에 이제 완성된 쿼리를 가지고 있기때문에 파라미터없이 실행한다.
			rset = pstmt.executeQuery();
			
			if(rset.next()){
				m = new Product();
				m.setMemberId(rset.getString("member_id"));
				m.setPassword(rset.getString("password"));
				m.setMemberName(rset.getString("member_name"));
				m.setGender(rset.getString("gender"));
				m.setAge(rset.getInt("age"));
				m.setEmail(rset.getString("email"));
				m.setPhone(rset.getString("phone"));
				m.setAddress(rset.getString("address"));
				m.setHobby(rset.getString("hobby"));
				m.setEnrollDate(rset.getDate("enroll_date"));
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
			
		}
		
		return m;
	}

	public List<Product> selectByName(Connection conn, String memberName) {
		ArrayList<Product> list = null;
		
		//사용후 반납해야할(close)자원들은 try~catch문 바깥에서 선언해야 한다.
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from member where member_name like ?";
		try {
			
			//3. 쿼리문을 실행할 statement객체 생성
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+memberName+"%");
			//4. 쿼리문 전송, 실행결과 받기
			rset = pstmt.executeQuery();
			
			//5. 받은 결과값들을 객체에 옮겨 저장하기
			list = new ArrayList<Product>();
			
			while(rset.next()){
				Product m = new Product();
				m.setMemberId(rset.getString("member_id"));
				m.setPassword(rset.getString("password"));
				m.setMemberName(rset.getString("member_name"));
				m.setGender(rset.getString("gender"));
				m.setAge(rset.getInt("age"));
				m.setEmail(rset.getString("email"));
				m.setPhone(rset.getString("phone"));
				m.setAddress(rset.getString("address"));
				m.setHobby(rset.getString("hobby"));
				m.setEnrollDate(rset.getDate("enroll_date"));

				list.add(m);
			}
			
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public int updateMember(Connection conn, Product m) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update member set "
					 + " password=?"
					 + ",email=?"
					 + ",phone=?"
					 + ",address=?"
					 + " where member_id=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, m.getPassword());
			pstmt.setString(2, m.getEmail());
			pstmt.setString(3, m.getPhone());
			pstmt.setString(4, m.getAddress());
			pstmt.setString(5, m.getMemberId());
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int deleteMember(Connection conn, String memberId) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "delete from member where member_id=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}


	

}	


