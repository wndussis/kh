package member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MemberLogoutServlet
 */
@WebServlet("/member/logout")
public class MemberLogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//세션무효화 : 세션에 저장된 속성값을 모두 폐기
		//만약 세션이 존재하지 않으면(이미 세션이 폐기되었을때- 시간이 만료되어서), 새로 만들지 않고, null을 리턴.
		HttpSession session = request.getSession(false); //getSession(false) 생성여부가 false니까 새로 만들지 말라는 뜻
		
		if(session != null) //  세션객체를 재사용하기위한 과정, 현재세션을 무효화해서 속성을 다 제거하고 다음 사용자가 오면 재사용할수있게 (세션아이디는 새로 발급됨)
			session.invalidate(); //invalidate() 무효화
		
		response.sendRedirect(request.getContextPath()); // index 페이지로 보냄
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response); // doGet을 호출함
	}

}
