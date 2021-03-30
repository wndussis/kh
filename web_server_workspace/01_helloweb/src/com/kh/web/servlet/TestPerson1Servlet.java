package com.kh.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * Servlet
 * webservice를 위한 java class
 * HttpServlet을 상속해야함
 * 
 * Servlet의 생명주기
 * - was구동내내 딱 하나의 객체만 만들어져서 처리된다.(singletone방식)
 * 
 * 1. Servlet객체생성(기본 생성자 호출)    - 최초 client호출시 1회
 * 2. init메소드 호출                                  - 최초 client호출시 1회
 * 3. HttpServlet의 service메소드 호출     - client 매 요청마다 
 * 4. 전송방식에 따라 doGet | doPost 호출  - client 매 요청마다 
 * 5. destroy호출(tomcat종료시 객체 반환) - 마지막 1회
 *
 * 멱등 
 * - 서비스 전후로 database의 상태가 바뀌지 않는 경우
 * - select  -> GET 방식 사용
 * - insert update delete 는 멱등 이 아님  -> POST 방식 사용
 * - login -> POST (id/password를 url에 노출시키지않도록 막기위해 POST방식 사용)
 * 
 *
 */
public class TestPerson1Servlet extends HttpServlet {

	/**
	 * 기본생성자
	 * 
	 */
	public TestPerson1Servlet() {
		super();
		System.out.println("기본생성자 TestPerson1Servlet() 호출!");
	}
	
	@Override
	public void init(ServletConfig config) {
		System.out.println("init(ServletConfig) 호출!");
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy() 호출!");
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws IOException, ServletException {
		//매 요청시 사용되는 servlet객체는 동일하다.
		// (Single tone 패턴이기때문에.)
		
		System.out.println(this.hashCode());
		
		//1. 사용자입력값 가져오기
		//1-1.단일값
		String name = request.getParameter("name");
		String color = request.getParameter("color");
		String animal = request.getParameter("animal");
		//1-2.복수개의 값을 가져올때
		String[] foodArr = request.getParameterValues("food");
		
		//1-3.값 확인
		System.out.println("name = " + name);
		System.out.println("color = " + color);
		System.out.println("animal = " + animal);
		System.out.println("foodArr = " + Arrays.toString(foodArr));
		
		//2. 응답메세지 작성 : html
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>개취 검사 결과</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>개인 취향 검사 결과 GET</h1>");
		out.println("<p>" + name + "님의 개인취향 검사 결과는 </p>");
		out.println("<p>" + color + "색을 좋아합니다. </p>");
		out.println("<p>좋아하는 동물은 " + animal + "입니다.</p>");
		out.println("<p>좋아하는 음식은 " + Arrays.toString(foodArr)+ "입니다. </p>");
		out.println("</body>");
		out.println("</html>");
	}
	
	
	@Override 
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws IOException, ServletException {
		
		//0. 인코딩 선언
		//http message body부분 인코딩이 유효하도록 한다.
		//post방식은 body부분에 작성되기에 한글을 인코딩 명시적으로 해줘야함
		//head는 자동으로 인코딩이됨...따라서 get방식은 상관없음
		request.setCharacterEncoding("utf-8");

		//1. 사용자입력값 가져오기
		//1-1. 단일값
		String name = request.getParameter("name");
		String color = request.getParameter("color");
		String animal = request.getParameter("animal");
		//1-2. 복수개의 값을 가져올때
		String[] foodArr = request.getParameterValues("food");
		
		//1-3 값 확인
		System.out.println("name = " + name);
		System.out.println("color = " + color);
		System.out.println("animal = " + animal);
		System.out.println("foodArr = " + Arrays.toString(foodArr));
		
		//2. 응답메세지 작성 : html
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>개취 검사 결과</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>개인 취향 검사 결과 POST</h1>");
		out.println("<p>" + name + "님의 개인취향 검사 결과는 </p>");
		out.println("<p>" + color + "색을 좋아합니다. </p>");
		out.println("<p>좋아하는 동물은 " + animal + "입니다.</p>");
		out.println("<p>좋아하는 음식은 " + Arrays.toString(foodArr)+ "입니다. </p>");
		out.println("</body>");
		out.println("</html>");
	}
	
	
}




	