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
	String id = (String)session.getAttribute("ID"); //���ǿ� ����� ������(����)�� �����´�.
%>
<h3 align="center">�α��� �Ǿ����ϴ�. ȯ���մϴ� <%= id %>��</h3>
</body>
</html>