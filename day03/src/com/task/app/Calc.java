package com.task.app;

public class Calc {
   private int number1;
   private int number2;
   
   public Calc() {;}
//   생성자로 매개변수 전달받기
//   expression이 문자열 값이므로 매개변수인 number1, 2를 문자열로 받고
//   객체 변수에 전달할 때 정수로 파싱
   public Calc(String number1, String number2) {
      this.number1 = Integer.parseInt(number1);
      this.number2 = Integer.parseInt(number2);
   }

   public int add() {return number1 + number2;}
   public int sub() {return number1 - number2;}
   public int mul() {return number1 * number2;}
   public int div() {return number1 / number2;}
   
}