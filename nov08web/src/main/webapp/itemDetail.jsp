<%@page import="item.ItemDTO"%>
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
	ItemDTO dto = (ItemDTO)request.getAttribute("ITEM");
%>
<h3 align="center">��ǰ �� ����</h3>
<div align="center">
<form action="itemModify.do" method="post">
<table border="1">
	<tr><th>��ǰ��ȣ</th><td><input type="hidden" name="CODE" value="<%= dto.getCode() %>"/><%= dto.getCode() %></td></tr>
	<tr><th>��ǰ�̸�</th><td><input type="text" name="NAME" value="<%= dto.getName() %>" /></td></tr>
	<tr><th>��ǰ����</th><td><input type="text" name="PRICE" value="<%= dto.getPrice() %>" /></td></tr>
	<tr><th>�����</th><td><%= dto.getReg_date() %></td></tr>
	<tr><th>������</th>
		<td><select name="ORIGIN">
		<% if(dto.getOrigin().equals("KOR")){ %>
		<option value="KOR" selected="selected">���ѹα�</option>
		<% }else { %>
		<option value="KOR">���ѹα�</option>
		<% } %>
		<% if(dto.getOrigin().equals("JPN")){ %>
		<option value="JPN" selected="selected">�� ��</option> 
		<% }else { %>
		<option value="JPN">�� ��</option>
		<% } %>
		<% if(dto.getOrigin().equals("CHN")){ %>
		<option value="CHN" selected="selected">�� ��</option>
		<% }else { %>
		<option value="CHN">�� ��</option>
		<% } %>
		<% if(dto.getOrigin().equals("USA")){ %>
		<option value="USA" selected="selected">�� ��</option>
		<% }else { %>
		<option value="USA">�� ��</option>		
		<% } %>
		<% if(dto.getOrigin().equals("AUS")){ %>
		<option value="AUS" selected="selected">ȣ ��</option>
		<% }else { %>
		<option value="AUS">ȣ ��</option>
		<% } %>
		<% if(dto.getOrigin().equals("GBR")){ %>
		<option value="GBR" selected="selected">�� ��</option>
		<% }else { %>
		<option value="GBR">�� ��</option>
		<% } %>
		<% if(dto.getOrigin().equals("RUS")){ %>
		<option value="RUS" selected="selected">���þ�</option>
		<% }else { %>
		<option value="RUS">���þ�</option>
		<% } %>
		<% if(dto.getOrigin().equals("ETC")){ %>
		<option value="ETC" selected="selected">�� Ÿ</option>
		<% }else { %>
		<option value="ETC">�� Ÿ</option>
		<% } %>
		</select></td></tr>
		<tr><th>��ǰ����</th><td><textarea rows="5" cols="50" name="CONTENT"><%= dto.getInfo() %></textarea></td><tr>
	<%
		String id = (String)session.getAttribute("ID");
		if(id != null && id.equals("admin")){
			
	%>
	<tr><td colspan="2" align="center">
		<input type="submit" value="��ǰ���� ����" name="BTN" />
		<input type="submit" value="��ǰ���� ����" name="BTN"/>
	</td></tr>
	<%	
		}else if(id != null) {
	%>
		<tr><td colspan="2" align="center">
			<input type="button" value="��ٱ��Ͽ� ���" onclick="buy()"/>
		</td></tr>
	<%
		}
	%>
</table>
</form>
</div>
<script type="text/javascript">
function buy(){
	confirm("��ٱ��Ͽ� �߰��Ǿ����ϴ�.");
}
</script>
</body>
</html>