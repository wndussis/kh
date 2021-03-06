package member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * @WebServlet
 * 서블릿 등록을 자동으로 처리함.
 * 
 * - urlPatterns :String[] 스트링배열로 받음
 * - name:String
 */
//@WebServlet("/member/login") 이렇게 그냥 써도됨 아래처럼안쓰고
@WebServlet(urlPatterns = {"/member/login"})
public class MemberLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;  // serialVersionUID 직렬화를 구분하기위한 클래스
	
	MemberService memberService = new MemberService();
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. encoding처리
		request.setCharacterEncoding("utf-8");
		
		//2. 사용자입력값 처리(자바변수에 옮겨담는것)
		String memberId = request.getParameter("memberId");
		String password = request.getParameter("password"); //request에있는 getParameter = 사용자 입력값을 꺼내는 메소드 
		String saveId = request.getParameter("saveId");
		System.out.println("memberId@servlet = " + memberId);  // @찍은 이유는 나중에 어디서 찍은건지 알아보기위해	
		System.out.println("password@servlet = " + password);
		System.out.println("saveId@servlet = " + saveId);
		
		//3. 업무로직(이 서블릿이 처리해야할 업무로직) , DB에 있는 사용자정보를 가져와야함
		// memberId로 회원객체를 조회
		Member member = memberService.selectOne(memberId);
		System.out.println("member@servlet = " + member);
		
		//로그인 성공/실패여부 판단
		//1. 로그인 성공 : member 객체가 null이 아니어야함 ,  member != null && password.equals(member.getpassword())
		//2. 로그인 실패 : member 객체가 null 
		// 아이디가 존재하지 않을때 member == null
		// 비번이 틀릴때 member != null && !password.equals(member.getPassword())
		
		HttpSession session = request.getSession(true); // getSession();으로 써도 똑같음 기본값이 true니까
		
		if(member != null && password.equals(member.getPassword())) {
			// 로그인 성공
//			request.setAttribute("msg", "로그인에 성공했습니다.");
			
			// 로그인한 사용자 정보 담기
			// request.getSession(create : boolean) : 새로 생성여부(존재하지않으면 새로 생성해서 가져와라) 기본값:true
//			System.out.println(session.getId()); // client와 공유한 JSESSIONID값 = key값과 동일함
			session.setAttribute("loginMember", member); // session에 담음 -> 생명주기가 한 브라우져내에서 지속가능(request,response)몇번을 오가도
			
			//Session timeout : web.wml보다 우선순위 높음
			// 초단위로 작성해야함
//			session.setMaxInactiveInterval(30); // 30초가 셋팅되어서  이후엔 로그아웃되야함
			
			
			//saveId : cookie처리
			Cookie c = new Cookie("saveId",memberId); // "saveId",memberId  -> key, value 형식
			c.setPath(request.getContextPath()); //path 쿠키를 전송할 url을 가리킴
			if(saveId != null) {
				//saveId 체크시
				c.setMaxAge(60 * 60 * 24 * 7); // 원하는 시간만큼 저장(초 기준) , 7일짜리 영속쿠키로 지정함
			}
			else {  // cookie 지우기 위해 else절 필요함
				//saveId 체크해제시
				c.setMaxAge(0); // 0으로 지정해서 쿠키 즉시 삭제, 음수로 지정하면 session종료시 제거됨
			}
			response.addCookie(c);
			
		}
		else {
			// 로그인 실패
			session.setAttribute("msg", "로그인에 실패했습니다.");
//			request.setAttribute("loc", request.getContextPath()); // url 바꿧음
				
//			//4. 응답메세지 html 처리(위임, 리다이렉트 등 방법이있다)
//			RequestDispatcher reqDispatcher = 
//					  request.getRequestDispatcher("/index.jsp");
//			reqDispatcher.forward(request,response);
		}	
		
		//리다이렉트 : url변경 목적
		response.sendRedirect(request.getContextPath());  // request.getContextPath() 이 주소로 이동 할거라는 뜻
		
			
	}

}
