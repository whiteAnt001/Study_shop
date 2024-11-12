package item;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.tribes.group.interceptors.FragmentationInterceptor;
import org.apache.tomcat.dbcp.dbcp2.PStmtKey;

/**
 * Servlet implementation class ItemModifyServlet
 */
@WebServlet("/itemModify.do")
public class ItemModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ItemModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr"); //한글처리
		String btn = request.getParameter("BTN");
		String code = request.getParameter("CODE"); //상품번호가 들어있는 파라미터(CODE) 수신
		if(btn.equals("상품정보 수정")) {
			String name = request.getParameter("NAME");
			String price = request.getParameter("PRICE");
			String origin = request.getParameter("ORIGIN");
			String content = request.getParameter("CONTENT");
			ItemDTO dto = new ItemDTO();
			dto.setCode(code);
			dto.setName(name);
			dto.setPrice(Integer.parseInt(price));
			dto.setOrigin(origin);
			dto.setInfo(content);
			ItemUpdateDAO dao = new ItemUpdateDAO();
			boolean flag = dao.doIt(dto);
			if(flag) { //상품정보 수정 성공
				response.sendRedirect("itemList.do");
			}else { //상품 정보 수정 실패
				response.sendRedirect("index.jsp?BODY=itemUpdateFail.jsp");
			}
			
		}else if(btn.equals("상품정보 삭제")) {
			ItemDeleteDAO dao = new ItemDeleteDAO();
			boolean flag = dao.doIt(code);
			if(flag) { //상품정보 삭제 성공
				//다시 상품 목록 출력
				response.sendRedirect("index.jsp?BODY=itemList.do");
			}else { //상품정보 삭제 실패
				//삭제 실패 화면 출력
				response.sendRedirect("index.jsp?BODY=itemDeleteFail.jsp");
			}
		}
	}
}

class ItemDeleteDAO {
	Connection con;
	PreparedStatement pstmt;
	boolean yesOrNo;
	
	String query = "delete from item_board where code = ?";
	
	boolean doIt(String code) {
		try {
			Class.forName(OracleXE11g.LIB);
			con = DriverManager.getConnection(OracleXE11g.NAME, "hr", "hr");
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, code);
			pstmt.executeUpdate();
			yesOrNo = true;
		} catch (Exception e) {
			System.out.println("상품 삭제 중 문제발생");
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

class ItemUpdateDAO {
	Connection con;
	PreparedStatement pstmt;
	boolean yesOrNo;
	
	String query = "update item_board set name = ?, price = ?, origin = ?, info = ? where code = ?";
	
	boolean doIt(ItemDTO dto) {
		try {
			Class.forName(OracleXE11g.LIB);
			con = DriverManager.getConnection(OracleXE11g.NAME, "hr", "hr");
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, dto.getName());
			pstmt.setInt(2, dto.getPrice());
			pstmt.setString(3, dto.getOrigin());
			pstmt.setString(4, dto.getInfo());
			pstmt.setString(5, dto.getCode());
			pstmt.executeUpdate();
			yesOrNo = true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("상품정보 변경 중 문제발생");
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
