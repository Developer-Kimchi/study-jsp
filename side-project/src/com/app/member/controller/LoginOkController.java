package com.app.member.controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.Action;
import com.app.Result;
import com.mybatis.dao.MemberDAO;

public class LoginOkController implements Action {

	@Override
	public Result execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
//		멤버다오 선언
		MemberDAO memberDAO = new MemberDAO();
//		result 선언
		Result result = new Result();
//		화면에서 이름이랑 나이 받기
		String name = req.getParameter("memberName");
		int age = Integer.parseInt(req.getParameter("memberAge"));
//		memberId에 member.login() 값 넣기
//		Long을 클래스로 사용하는 이유는 null값을 허용하기 위해서
		Long memberId = memberDAO.login(name, age);
//		memberId가 null이 아니면
		if(memberId != null) {
//			로그인 성공
			result.setRedirect(true);
//			서블릿에서 쿼리스트링에 문자열값을 보낼 때에는 URLEncoder를 사용하여 보낸다.
			result.setPath(req.getContextPath() + "/main?name=" + URLEncoder.encode(name, "UTF-8"));
			
		}else {
//			로그인 실패
			result.setPath("join.member");
			
		}
		
		return result;
	}
}
