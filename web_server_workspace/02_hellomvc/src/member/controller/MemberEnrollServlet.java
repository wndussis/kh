package member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberEnrollServlet
 */
@WebServlet("/member/memberEnroll") // /mvc 앞에 쓰면 안됨
public class MemberEnrollServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	/**
	 * 회원가입페이지  - 멱등요청
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/member/memberEnroll.jsp")
			   .forward(request,response);
	}

	/**
	 * 회원가입 처리 - db에 저장, 멱등 아님 , DML은 다 doPost로 처리하면된다!
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
