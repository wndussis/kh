package member.contoller;

import java.util.List;


import member.model.dao.MemberDao;
import member.model.vo.Member;


/**
 * Controller 역할
 * 
 *MVC패턴의 시작점이자 전체흐름을 제어. MODEL VIEW CONTROLLER
 * 
 * view단으로 부터 요청을 받아서 dao에 다시요청하고,
 * 그 결과를 view단에 다시 전달해줌
 *
*/
public class MemberController {
	// Dao객체생성
	private MemberDao memberDao = new MemberDao();

	// insert 메서드
	public int insertMember(Member member) {   
		return memberDao.insertMember(member); //회원객체를 DB에 저장해라(DAO에 요청보냄)
	}
    
	// 전체회원 목록 불러오는 메서드
	public List<Member> selectAll() {
		return memberDao.selectAll();
	}

	// 아이디 하나 조회하는 메서드
	public Member selectOne(String memberId) {
		return memberDao.selectOne(memberId);
	}

	public List<Member> selectByName(String memberName) {
		return memberDao.selectByName(memberName);
	}

	public int updateMember(Member member) {
		return memberDao.insertMember(member);
	}

	
	public int deleteMember(String memberId) {
		return memberDao.deleteMember(memberId);
	}

	
}



