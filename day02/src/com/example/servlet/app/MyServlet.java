package com.example.servlet.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet
 */
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//    매개변수 HSR request, HSR response 객체
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		문자 형식 UTF-8로 설정(글자 깨짐 방지)
		response.setContentType("text/html; charset=UTF-8");
//		getParameter: 화면에서 문자열 전달받아 문자열값 리턴
//		문자열 객체 생성하여 화면에서 입력된 값 저장
		String name = request.getParameter("name");
//		response.getWriter : 화면에 서블릿에서 작성한 텍스트가 보일 수 있도록 PrintWriter 타입의 객체를 리턴
		PrintWriter out = response.getWriter();
//		out.print(); <- 소괄호 안에 HTML 텍스트를 입력하면 화면에 출력해준다
		out.print("<h3>" + name + "님 환영합니다.</h3>");
//		a태그를 통해 다시 index 페이지로 이동
		out.print("<a href='index'>이름 다시 입력하기.</a>");
//		화면 출력을 위해 열었던 경로를 다시 닫아준다.
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
