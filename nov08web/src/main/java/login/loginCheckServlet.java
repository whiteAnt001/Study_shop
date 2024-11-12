package login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class loginCheckServlet
 */
@WebServlet("/logincheck.do")
public class loginCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public loginCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession에 계정이 있는지 확인한다
//		계정이 있으면, 관리자 계정인지 확인한다.
//		관리자 계정인 경우 화면을 input_item.jsp로 변환한다.
		HttpSession session = request.getSession(); //HttpSession 인스턴스 생성
		String id = (String)session.getAttribute("ID"); //HttpSession에서 ID로 계정을 찾는다.
		if(id != null) { //로그인을 한 경우
			if(id.equals("admin")) { //관리자 계정으로 로그인 한 경우
				response.sendRedirect("index.jsp?BODY=input_item.jsp");
			}else { //일반 회원으로 로그인 한 경우
				response.sendRedirect("index.jsp?BODY=noAdmin.jsp");
			}
		}else { //로그인을 안 한 경우
			response.sendRedirect("index.jsp?BODY=login.jsp?MSG=Y");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
class OracleXE11g{
    static final String LIB = "oracle.jdbc.driver.OracleDriver"; //상수처리
    static final String NAME = "Jdbc:oracle:thin:@localhost:1521:XE"; //상수처리
 }
class LoginCheckDAO {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	boolean yesOrNo;
	
	String query = "select user_id from user_info where user_id = ? and user_pwd = ?";
	
	boolean doIt(String id, String pwd) {
		try {
			Class.forName(OracleXE11g.LIB);
			con = DriverManager.getConnection(OracleXE11g.NAME, "hr", "hr");
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				yesOrNo = true;
			}
		} catch (Exception e) {
			System.out.println("로그인 중 문제발생");
		}finally {
			try {
				con.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return yesOrNo;
	}
	
	
}
