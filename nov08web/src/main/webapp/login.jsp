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
	<h3 align="center"><font color="red">�α��ε��� �ʾҽ��ϴ�. ������ ��ȣ�� Ȯ���ϼ���</font></h3>
<%
	}
%>
<div align="center">
	<p>������ ��ȣ�� �Է��ϰ� �α��� ��ư�� ��������.</p>
	<form action="login.do" method="post">
	���� : <input type="text" name="ID" size="10"/><br/>
	��ȣ : <input type="password" name="PWD" size="10"><br/>
	<input type="submit" value="�α���"/>
	<input type="reset" value="�� ��"/>
	</form>
</div>
</body>
</html>