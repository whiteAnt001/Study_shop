<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	String msg = request.getParameter("MSG");
	if(msg != null){
%>
	<h3 align="center"><font color="red">로그인되지 않았습니다. 계정과 암호를 확인하세요</font></h3>
<%
	}
%>
<div align="center">
	<p>계정과 암호를 입력하고 로그인 버튼을 누르세요.</p>
	<form action="login.do" method="post">
	계정 : <input type="text" name="ID" size="10"/><br/>
	암호 : <input type="password" name="PWD" size="10"><br/>
	<input type="submit" value="로그인"/>
	<input type="reset" value="취 소"/>
	</form>
</div>
</body>
</html>