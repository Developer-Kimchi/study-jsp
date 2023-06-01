package com.app.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.Result;
import com.app.member.controller.JoinOkController;
import com.app.member.controller.LoginOkController;

public class MemberFrontController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		target에 요청 uri에서 상대경로와 확장자명을 뺸 값을 담는다
		String target = req.getRequestURI().replace(req.getContextPath() + "/", "").split("\\.")[0];
//		결과값 담을 객체 선언
		Result result = null;
		
//		joinOk라면
		if(target.equals("templates/joinOk")) {
//			JoinOkController 클래스의 메소드 실행값 담아준다!
			result = new JoinOkController().execute(req, resp);
//		join이면
		}else if(target.equals("templates/join")) {
//			결과에 join.jsp로의 경로를 담아준다!
			result = new Result();
			result.setPath("join.jsp");
//		login이면	
		}else if(target.equals("templates/login")) {
//			결과에 login.jsp로의 경로를 담아준다!
			result = new Result();
			result.setPath("login.jsp");
//			loginOk면
		}else if(target.equals("templates/loginOk")) {
			System.out.println(target);
//			결과에 loginOk 메소드 실행값 담아준다!
			result = new LoginOkController().execute(req, resp);
			
		}
//		result가 null이 아니라면
		if(result != null) {
//			result의 isRedirect가 true라면
			if(result.isRedirect()) {
//				응답 객체의 sendRedirect 메소드 실행(매개변수로 위에서 설정한 경로를 받아온다)
				resp.sendRedirect(result.getPath());
//				isRedirect가 false면(forward)
			}else {
//				경로를 forward방식으로 
				req.getRequestDispatcher(result.getPath()).forward(req, resp);
			}
		}
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
