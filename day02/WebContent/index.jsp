<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP로 만든 페이지</title>
</head>
<body>
<!-- MyServlet 서블릿에 작성된 값을 가져와서(action="MyServlet") 화면에 보여줘라(doGet 메소드)(method="get") -->
	<form action="MyServlet" method="get">
		<label>
		<!-- name은 자바 파일의 객체명과 같아야 혼동이 없다. -->
			이름 <input type="text" name="name">
		</label>
		<input type="submit" value="완료">
	</form>
</body>
</html>
