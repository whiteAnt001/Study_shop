package item;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InputItemServlet
 */
@WebServlet("/inputItem.do")
public class InputItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InputItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr"); // method가 Post인 경우 한글처리 필요
		String code = request.getParameter("CODE"); //상품코드
		String name = request.getParameter("NAME"); //상품명
		String price = request.getParameter("PRICE"); //상품가격
		String origin = request.getParameter("ORIGIN"); //원산지
		String info = request.getParameter("INFO"); //상품정보
		ItemDTO dto = new ItemDTO(); // DTO 생성
		//DTO에 파라미터 저장
		dto.setCode(code);
		dto.setName(name);
		dto.setPrice(Integer.parseInt(price));
		dto.setOrigin(origin);
		dto.setInfo(info);
		InputItemDAO dao = new InputItemDAO();
		boolean flag = dao.doIt(dto);
		if(flag) {
			response.sendRedirect("itemList.do");
		}else {
			
		}
	}
}

class OracleXE11g{
    static final String LIB = "oracle.jdbc.driver.OracleDriver"; //상수처리
    static final String NAME = "Jdbc:oracle:thin:@localhost:1521:XE"; //상수처리
 }
class InputItemDAO {
	Connection con;
	PreparedStatement pstmt;
	boolean yesOrNo;
	
	String query = "insert into item_board values(?,?,?,?,?,sysdate)";
	boolean doIt(ItemDTO dto) {
		try {
			Class.forName(OracleXE11g.LIB);
			con = DriverManager.getConnection(OracleXE11g.NAME, "hr", "hr");
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, dto.getCode());
			pstmt.setString(2, dto.getName());
			pstmt.setInt(3, dto.getPrice());
			pstmt.setString(4, dto.getInfo());
			pstmt.setString(5, dto.getOrigin());
			pstmt.executeUpdate();
			yesOrNo = true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("상품 등록 중 문제발생");
		}finally {
			try {
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return yesOrNo;
	}
}
