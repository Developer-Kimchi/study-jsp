package com.example.servlet.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Info extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req객체의 getParameter메소드를 통해 화면에서 입력된 값을 서버로 전달
		String memberName = req.getParameter("memberName");
//		int값으로 받으려면 req객체를 integer로 파싱해야 한다.
		int memberAge = Integer.parseInt(req.getParameter("memberAge"));
//		문자 형식 지정
		resp.setContentType("text/html; charset=UTF-8");
//		out 객체 선언
		PrintWriter out = resp.getWriter();
//		화면에 보여줄 HTML 텍스트 입력
		out.print("<h1>" + memberName + "</h1>");
		out.print("<h1>" + memberAge + "</h1>");
//		a태그 경로 info.jsp
		out.print("<a href='info-jsp'>정보 다시 입력</a>");
//		파일 출력 시 열었던 경로 닫기
		out.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
