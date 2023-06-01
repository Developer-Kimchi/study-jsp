package com.app.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.Action;
import com.app.Result;
import com.mybatis.dao.MemberDAO;
import com.mybatis.vo.MemberVO;

public class JoinOkController implements Action {
	@Override
	public Result execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		한글 깨지는 것 사전 방지
		req.setCharacterEncoding("UTF-8");
		
//		이름을 요청객체의 getParameter메소드로 받기
		String name = req.getParameter("memberName");
//		위와 같은 방식으로 나이를 받는데, 정수값으로 파싱해서 받기
		int age = Integer.parseInt(req.getParameter("memberAge"));
//		memberDAO 선언
		MemberDAO memberDAO = new MemberDAO();
//		결과값 리턴할 객체 선언
		Result result = new Result();
		
//		memberVO 선언
		MemberVO memberVO = new MemberVO();
//		화면에서 전달받은 값을 memberVO에 담는다
		memberVO.setMemberName(name);
		memberVO.setMemberAge(age);
		
//		memberDAO의 insert메소드 실행
		memberDAO.insert(memberVO);
//		redirect 설정
		result.setRedirect(true);
//		result.setPath를 로그인 페이지로 설정
		result.setPath("login.member");
//		결과 리턴
		return result;
	}
}












