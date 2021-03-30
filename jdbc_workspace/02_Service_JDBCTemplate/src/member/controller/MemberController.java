package member.controller;

import java.util.List;

import member.model.service.MemberService;
import member.model.vo.Member;

public class MemberController{
	//필드로 has a  관계 맺음 -> MemberService의 메소드를 MemberController에서 호출할수 있도록 구조화한것.!!!!!!!!!!!!!!!
	private MemberService memberService = new MemberService();

	public List<Member> selectAll() {
		return memberService.selectAll(); //리턴 타입은 List<Member> 
	}

	public Member selectOne(String memberId) {
		return memberService.selectOne(memberId);
	}

	public int insertMember(Member m) {
		return memberService.insertMember(m);
	}
	
	public int deleteMember(String memberId) {
		return memberService.deleteMember(memberId);
	}
	
	public int updateMember(Member m) {
		return memberService.updateMember(m);
		
	}

	
	public List<Member> selectByName(String memberName) {
		return memberService.selectByName(memberName);
	}

	

}
