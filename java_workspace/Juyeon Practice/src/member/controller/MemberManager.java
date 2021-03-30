package member.controller;

import member.model.vo.Gold;
import member.model.vo.Silver;
import member.model.vo.VVip;
import member.model.vo.Vip;

public class MemberManager {
	
	public static final int MAX_MEMBER_COUNT = 10;
	Silver[] s = new Silver[MAX_MEMBER_COUNT];
	Gold[] g = new Gold[MAX_MEMBER_COUNT];
	Vip[] v = new Vip[MAX_MEMBER_COUNT];
	VVip[] vv = new VVip[MAX_MEMBER_COUNT];
	
	int silverIndex = 0;
	int goldIndex = 0;
	int vipIndex = 0;
	int vvipIndex = 0;
	
	
	
	

}
