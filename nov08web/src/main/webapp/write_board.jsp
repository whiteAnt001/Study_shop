<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<form action="writeBoard.do" method="post">
			<h3 align="center">�Խñ� ����</h3>
			<p>�����Ӱ� ���� �ۼ��Ͻ� �� �� �ø��� ��ư�� ������, �ۼ��� ���� �Խñۿ� �ö󰩴ϴ�.</p>
			<table border="1">
				<tr><th>������</th><td><input type="text" name="TITLE" size="30"/></td></tr>
				<tr><th>�۳���</th><td><textarea rows="4" cols="50" name="CONTENT"></textarea></td></tr>
				<tr><td colspan="2"><input type="submit"  value="�� �ø���"/>
									<input type="reset" value="�� ��"></td></tr>
				
			</table>
		</form>
	</div>
</body>
</html>