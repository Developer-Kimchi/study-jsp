package com.task.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Oper extends HttpServlet {
   
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	   response 문자 형식 utf-8로 지정
      response.setContentType("text/html; charset=utf-8");
//      플래그 변수(스위치문에서 사용)
      boolean isError = false;
//      요청객체(request)의 getParameter 메소드를 통해 화면에서 입력된 값 서블릿으로 가져오기
      String expression = request.getParameter("expression");
//      사칙연산 기호
      String opers = "+-*/";
//      사칙연산 중 사용자가 입력한 기호 담을 char 객체(스위치문에서 사용)
      char oper = ' ';
//      Calc 클래스 타입 객체(사용자가 입력한 연산에 맞게 메소드 호출)
      Calc calc = null;
//      연산할 수
      String[] numbers = null;
//      연산 결과
      int result = 0;
//      PrintWriter 객체를 통해 응답할 내용 화면에 보여주기
      PrintWriter out = response.getWriter();
      
//      이중 for문 expression과
      for(int i=0; i<expression.length(); i++) {
//    	  opers 중에
         for(int j=0; j<opers.length(); j++) {
//        	 서로 일치하는 문자값이 있다면
            if(expression.charAt(i) == opers.charAt(j)) {
//            	해당 문자값을 oper에 담아라
               oper = opers.charAt(j);
            }
         }
      }
      
//      위에서 결정된 oper를 바탕으로 expression을 배열로 스플릿
//      numbers에 저장
      numbers = expression.split("\\" + oper);
//      위에서 선언했던 calc에 생성자 담기
      calc = new Calc(numbers[0], numbers[1]);
//      스위치문으로 연산 기호 체크, 케이스별 알맞은 메소드 호출
      switch(oper) {
      case '+':
         result = calc.add();
         break;
      case '-':
         result = calc.sub();
         break;
      case '*':
         result = calc.mul();
         break;
      case '/':
//    	  나눗셈에서 예외 예외 발생
         try {
            result = calc.div();
         } catch (Exception e) {
//        	 플래그 변수 및 에러 발생 시 출력할 화면
            isError = true;
            out.print("<h1>0으로 나눌 수 없습니다.</h1>");
            out.print("<a href='calc'>다시 계산하기</a>");
//            출력 경로 닫기
            out.close();
         }
         break;
      }
//      플래그 변수가 false 일 때(즉 에러 없을 때) 출력할 화면
      if(!isError) {
         out.print("<h1>결과: " + result + "</h1>");
         out.print("<a href='calc'>다시 계산하기</a>");
//         출력 경로 닫기
         out.close();
      }
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }

}














