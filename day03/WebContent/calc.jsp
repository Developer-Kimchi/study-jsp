<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정수 입력</title>
</head>
<body>
   <form action="Oper" name="expression-form">
      <input type="text" placeholder="수식 입력" id="expression" name="expression">
      <input type="button" id="send" value="결과 확인">
   </form>
</body>
<!-- 제이쿼리 가져오기 -->
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<script>
/* 제이쿼리로 #send 가져와서 클릭이벤트 주기 */
   $("#send").on("click", () => {
	   /* 입력창에 값이 없으면 alert창 띄우고 리턴 */
      if(!$("#expression").val()){
         alert("수식을 입력해주세요.")
         return;
      }
      /* 이상 없으면 form태그 submit */
      $("form[name='expression-form']").submit();
   });
</script>
</html>