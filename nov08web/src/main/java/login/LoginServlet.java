package login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("ID");
		String password = request.getParameter("PWD");
		LoginCheckDAO dao = new LoginCheckDAO();
		boolean yesOrNo = dao.doIt(id, password);
		if(yesOrNo) { //로그인에 성공한 경우
			//로그인에 성공했으므로 HttpSession에 데이터(계정)를 저장한다
			HttpSession session = request.getSession();
			session.setAttribute("ID", id);
			response.sendRedirect("index.jsp?BODY=loginSuccsess.jsp");
		}else { //로그인에 실패한 경우
			response.sendRedirect("index.jsp?BODY=login.jsp?MSG=Y");
		}
	}
}