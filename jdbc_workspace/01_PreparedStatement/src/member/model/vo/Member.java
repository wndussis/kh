package member.model.vo;

import java.sql.Date;
/**
 * 
 * VO객체는 Member테이블의 한 행과 대응한다.
 * 
 * 
 */

public class Member {
	
	private String memberId;
	private String password;
	private String memberName;
	private String gender;   // M F , char는 JDBC에 없어서 여기선 String으로 사용
	private int age;
	private String email;
	private String phone;
	private String address;
	private String hobby;
	private Date enrollDate;  // java.sql.Date(import할때 이걸로 사용) -> java.util.Date의 자식클래스
	
	
	public Member() {    // 기본생성자 만듬, Alt+shift+s 사용해서 맨아래꺼
		super();
		
	}
	public Member(String memberid, String password, String memberName, String gender, int age, String email, //파라미터 생성자 만듬
			String phone, String address, String hobby, Date enrollDate) {   
		super();
		this.memberId = memberid;
		this.password = password;
		this.memberName = memberName;
		this.gender = gender;
		this.age = age;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.hobby = hobby;
		this.enrollDate = enrollDate;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberid) {
		this.memberId = memberid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public Date getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}
	@Override
	public String toString() {
		return "Member [memberid=" + memberId + ", password=" + password + ", memberName=" + memberName + ", gender="
				+ gender + ", age=" + age + ", email=" + email + ", phone=" + phone + ", address=" + address
				+ ", hobby=" + hobby + ", enrollDate=" + enrollDate + "]";
	}
	
	
	
	
	 
}
