<%@page import="item.ItemDTO"%>
<%@page import="java.util.ArrayList"%>
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
	ArrayList<ItemDTO> al = (ArrayList<ItemDTO>)request.getAttribute("ITEMS");
%>
<h3 align="center">��ǰ ���</h3>
<div align="center">
	<table border="1">
	<tr><th>��ǰ�ڵ�</th><th>��ǰ�̸�</th><th>��ǰ����</th><th>������</th><th>�����</th></tr>
	<% 
		for(ItemDTO dto : al){
	%>
		<tr><td><%= dto.getCode() %></td><td><a href="itemDetail.do?CODE=<%= dto.getCode() %>"><%= dto.getName() %></a></td><td><%= dto.getPrice() %></td>
			<td><%= dto.getOrigin() %></td><td><%= dto.getReg_date() %></td></tr>
	<%
		}
	%>
	</table>
</div>
</body>
</html>