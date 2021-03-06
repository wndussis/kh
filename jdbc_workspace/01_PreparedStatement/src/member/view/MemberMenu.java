package member.view;

import java.util.List;
import java.util.Scanner;

import member.contoller.MemberController;
import member.model.vo.Member;

public class MemberMenu {
	
	private MemberController memberController = new MemberController();
	private Scanner sc = new Scanner(System.in);        // 필드로 선언해서 다른 메소드와 공유 !!!
	
	public void mainMenu() {
		String menu = "========== 회원 관리 프로그램 ==========\n"
					+ "1.회원 전체조회\n"
					+ "2.회원 아이디조회\n" 
					+ "3.회원 이름조회\n" 
					+ "4.회원 가입\n" 
					+ "5.회원 정보변경\n" 
					+ "6.회원 탈퇴\n" 
					+ "0.프로그램 끝내기\n"
					+ "----------------------------------\n"
					+ "선택 : "; 
		while(true) {                     // 반복문에서 반복 제공, 반복문 안쓰면 메뉴하나 누르고 또 메뉴가 안뜨고 그냥 종료해버리니까!!!!!!!!
			System.out.print(menu);
			//switch문 안에서 쓸 변수를 미리 선언함
			int choice = sc.nextInt();   // sc.nextInt()를 사용해서 사용자값을 받은걸 choice변수에 대입.
			Member member = null;
			int result = 0;
			String msg = null;
			List<Member> list = null;
			String memberId = null;
			String memberName = null;
					
			switch(choice) {
				case 1:                 //사용자가 1번을 입력했을때
					list = memberController.selectAll(); //selectAll호출,컨트롤러에 요청하고, 그결과를 list로 받음 list객체가 넘어옴
					displayMemberList(list);  //list를 전달해서 출력
					break;
				case 2: 
					memberId = inputMemberId();
					member = memberController.selectOne(memberId);
					displayMember(member);
					break;
				case 3: 
					memberName = inputMemberName();
					list = memberController.selectByName(memberName);
					displayMemberList(list);
					break;
				case 4: 
					//1.신규회원정보 입력 -> Member객체
					member = inputMember();  // member객체를 리턴할 메소드 inputMember();
					System.out.println(">>> 신규회원 확인 : " + member);
					//2.controller에 회원가입 요청(메소드호출) ->insert into 사용해서 정보넣었으니까  DML요청 -> int리턴(처리된 행의 개수)
					result = memberController.insertMember(member); // insertMember메소드 이용해서 멤버객체전달
					//3.int에 따른 분기처리
					msg = result > 0 ? "회원 가입 성공!" : "회원 가입 실패!";
					displayMsg(msg); //사용자 피드백을 보내는 메소드
					break;
				case 5: 
				    member = updateMember();
				    result = memberController.updateMember(member);
				    msg = result > 0 ? "회원 수정 성공!" : "회원 수정 실패!";
				    displayMsg(msg);
					break;
				case 6: 
					memberId = inputMemberId();
					result = memberController.deleteMember(memberId);
					msg = result > 0 ? "회원 탈퇴 성공!" : "회원 탈퇴 실패!";
					displayMsg(msg);
					break;
				case 0: 
					System.out.print("정말로 끝내시겠습니까?(y/n) : ");
					if(sc.next().charAt(0) == 'y')   // 한글자(y/n)는 char를 이용해야해서, String의 charAt(0)메소드를 사용 !, 사용자가 입력한 값이 y라면 이라는 뜻
						return;//현재메소드(mainMenu)를 호출한 곳 으로 리턴함
					break;
				default: 
					System.out.println("잘못 입력하셨습니다.");
			}	
		}
	}

	private Member updateMember() {
		Member m = new Member();
		System.out.print("변경할 회원 아이디 : ");
		m.setMemberId(sc.next());
		System.out.print("암호 : ");
		m.setPassword(sc.next());
		System.out.print("이메일  : ");
		m.setEmail(sc.next());
		System.out.print("전화번호(_빼고입력): ");
		m.setPhone(sc.next());
		System.out.print("주소 : ");
		sc.nextLine(); // 개행문자 날리기용
		m.setAddress(sc.nextLine()); //주소라서 nextLine 사용 공백도 있을테니까
		System.out.print("취미 (,로 공백없이 나열): ");
		m.setHobby(sc.next());
		return m;
	}

	private String inputMemberName() {
		System.out.println("조회할 이름 입력 : ");
		return sc.next();
	}

	/**
	 * DB에서 조회한 1명의 회원 출력
	 * @param member
	 */
	private void displayMember(Member member) {
		if(member == null)
			System.out.println(">>>> 조회된 회원이 없습니다.");
		else {  // member 가 null이 아니라면
			System.out.println("****************************************************************");
			System.out.println(member);
			System.out.println("****************************************************************");
		}
	}

	/**
	 * 조회할 회원아이디 입력
	 * @return
	 */
	private String inputMemberId() {
		System.out.print("조회할 아이디 입력 : ");
		return sc.next();
	}

	/**
	 * DB에서 조회된 회원객체 n개를 출력
	 * @param list
	 */
	private void displayMemberList(List<Member> list) {   //전체 회원정보 출력
		if(list == null || list.isEmpty()) {
			System.out.println(">>>> 조회된 행이 없습니다.");	
		}
		else {
			System.out.println("*********************************************************");
			for(Member m : list) {   //for each문 사용함
				System.out.println(m);
			}
			System.out.println("*********************************************************");
		}
	}

	/**
	 * DML처리결과 통보용 
	 * @param msg
	 */
	private void displayMsg(String msg) {
		System.out.println(">>> 처리결과 : " + msg);  // 이걸 통해서 사용자는 처리결과가 성공했는지,실패했는지 알수있음 !
	}

	/**
	 * 신규회원 정보 입력
	 * @return
	 */
	private Member inputMember() {
		System.out.println("새로운 회원정보를 입력하세요.");
		Member member = new Member();
		System.out.print("아이디 : ");
		member.setMemberId(sc.next());  // 사용자 입력값(sc.next())을 setMemberid에 전달한다는 뜻.
		System.out.print("이름 : ");
		member.setMemberName(sc.next());
		System.out.print("비밀번호 : ");
		member.setPassword(sc.next());
		System.out.print("나이 : ");
		member.setAge(sc.nextInt());
		System.out.print("성별(M/F) : ");//m, f 소문자는 안됨 , check 제약조건에 어긋남 !
		member.setGender(String.valueOf(sc.next().toUpperCase().charAt(0))); // toUpperCase() 소문자를 대문자로 바꿀때 /String.valueOf  =>  String 아닌것을 String 으로 변환해줌 !
		System.out.print("이메일: ");
		member.setEmail(sc.next());
		System.out.print("전화번호(-빼고 입력) : ");
		member.setPhone(sc.next());
		sc.nextLine();//버퍼에 남은 개행문자 날리기용 (next계열 - nextLine 같이 사용할때), next()가 남겨놓은 개행문자를 날려야 하기 때문에 , 아래는 nextLine을 쓰니까 날려야함
		System.out.print("주소 : ");
		member.setAddress(sc.nextLine());// 주소는 보통 여러 공백을 포함하기 때문에 next() 는 안되고 , nextLine() 사용할것 !!!, nextLine은 개행문자 까지 가져옴
		System.out.print("취미(,로 나열할것) : ");
		member.setHobby(sc.nextLine()); //사용자가 취미를 공백을 두고 쓸수있으니까 nextLine()으로 한거임
		return member;
	}
}





