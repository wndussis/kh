<%@page import="member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	//  session에서 저장된 값(msg) 읽어옴
	String msg = (String)session.getAttribute("msg"); // return타입이 Object라서 (String)으로 형변환해줌(다운캐스팅)
	if(msg != null) session.removeAttribute("msg"); // 메세지를 1회용으로 쓰기위해, 위 코드에서 읽어내고, 이 코드로 메세지 날려버림
	
	String loc = (String)request.getAttribute("loc"); // loc 꺼냄
	Member loginMember = (Member)session.getAttribute("loginMember"); // session을 저장소처럼 사용함
	
	//사용자 쿠키처리
	String saveId = null;
	Cookie[] cookies = request.getCookies();
	if(cookies != null){
		for(Cookie c : cookies){
			String name = c.getName();
			String value = c.getValue();
			//System.out.println(name  + " : " + value);
			if("saveId".equals(name))  // saveId와 동일한게 있다면
				saveId = value;  // saveId에 value를 저장한다. 사용자 아이디가 담기게 된다.
		}
	}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello MVC</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style.css" />
<script src="<%= request.getContextPath() %>/js/jquery-3.6.0.js"></script>
<script>
<% if(msg != null) { %> // null이 아니면 alert로 경고창을 띄워라
//출력식, 문자열이니까 <> 를 감싸줘야함 큰따옴표로
alert("<%= msg %>");  

<% } %>

<% if(loc != null) { %>
	location.href = "<%= loc %>";
<% } %>

$(function(){   // onload 함수 사용해야함, DOM에 등록되기전에 실행되기때문에
	/**
	* 로그인 폼 유효성 검사
	*/
	$("#loginFrm").submit(function(){  //submit 이벤트 핸들러 만듬
		var $memberId = $(memberId);   // $(memberId) 이건 태그객체를 전달한것 선택자가 아니라
		var $password = $(password); 
		
		if(/^.{4,}$/.test($memberId.val()) == false){
			alert("유효한 아이디를 입력하세요.");
			$memberId.select();
			return false; // 제출되지 않도록 return false했음
		}

		if(/^.{4,}$/.test($password.val()) == false){
			alert("유효한 비밀번호를 입력하세요.");
			$password.select();
			return false; // 제출되지 않도록 return false했음
		}
	});
	
	
});

</script>
</head>
<body>
	<div id="container">
		<header>
			<h1>Hello MVC</h1>
			
			<div class="login-container">
			
			  <%-- 로그인 실패시 --%>
			<% if(loginMember == null) {  %>
			
			<!-- 로그인폼 시작 -->
				<form id="loginFrm" action="<%= request.getContextPath() %>/member/Login" method="POST">
					<table>
							<tr>
								<td><input type="text" name="memberId" id="memberId" 
								placeholder="아이디" tabindex="1" value="<%= saveId != null ? saveId : "" %>"></td>
								<td><input type="submit" value="로그인" tabindex="3"></td>
							</tr>
							<tr>
								<td><input type="password" name="password" id="password" placeholder="비밀번호" tabindex="2"></td>
								<td></td>
							</tr>
							<tr>
								<td colspan="2">
									<input type="checkbox" name="saveId" id="saveId" <%= saveId != null ? "checked" : "" %> />
									<label for="saveId">아이디저장</label>&nbsp;&nbsp;
									<input type="button" value="회원가입" onclick="location.href='<%= request.getContextPath() %>/member/memberEnroll';">
								</td>
							</tr>
						</table>
					</form>
				<!-- 로그인폼 끝-->
				<% } else { %> 
				   <%-- 로그인 성공시 --%>
				  <table id="login">
				  		<tr>
				  			<td><%= loginMember.getMemberName() %>님 , 안녕하세요.</td>
				  		</tr>
				  		<tr>
				  		     <td>
					  		    <input type="button" value="내정보보기" onclick="location.href='<%= request.getContextPath() %>/member/memberView';"/> <%-- /member/memberView 이건 onclick때문에 적어준것  --%>
							<input type="button" value="로그아웃" onclick="location.href='<%=request.getContextPath()%>/member/logout';"/>
				  		     </td>
				  		</tr>
				  </table>
				
				<% } %>
				
				</div>
				<!-- 메인메뉴 시작 -->
				<nav>
					<ul class="main-nav">
						<li class="home"><a href="<%= request.getContextPath() %>">Home</a></li>
						<li class="notice"><a href="#">공지사항</a></li>
						<li class="board"><a href="#">게시판</a></li>
					</ul>
				</nav>
				<!-- 메인메뉴 끝-->
					</header>
					
					<section id="content">