<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3 align="center">��ǰ ���</h3>
<div align="center">
<form action="inputItem.do" method="post">
	<table border="1">
	<tr><th>��ǰ�ڵ�</th><td><input type="text" name="CODE" size="10" /></td></tr>
	<tr><th>��ǰ�̸�</th><td><input type="text" name="NAME" size="15" /></td></tr>
	<tr><th>��ǰ����</th><td><input type="text" name="PRICE" size="10" /></td></tr>
	<tr><th>�� �� ��</th><td><select name="ORIGIN">
		<option value="KOR">���ѹα�</option><option value="JPN">�� ��</option> 
		<option value="CHN">�� ��</option><option value="USA">�� ��</option>
		<option value="AUS">ȣ ��</option><option value="GBR">�� ��</option>
		<option value="RUS">���þ�</option><option value="ETC">�� Ÿ</option>
		</select></td></tr>
		<tr><th>��ǰ����</th><td><textarea rows="5" cols="40" name="INFO"></textarea></td></tr>
		<tr><td colspan="2" align="center"><input type="submit" value="��ǰ ���" />
			<input type="reset" value="�� ��" />
	</table>
</form>
</div>
</body>
</html>