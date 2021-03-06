package member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberViewServlet
 */
@WebServlet({ "/MemberViewServlet", "/member/memberView" })
public class MemberViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	//Get방식 처리
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	    //2. JSP 위임처리(forward)
		request.getRequestDispatcher("/WEB-INF/views/member/memberView.jsp").forward(request, response);
	}

}