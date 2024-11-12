package item;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ItemDetailServlet
 */
@WebServlet("/itemDetail.do")
public class ItemDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ItemDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("CODE");
		ItemDetailDAO dao = new ItemDetailDAO();
		ItemDTO dto = dao.doIt(code);
		
		request.setAttribute("ITEM", dto);
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp?BODY=itemDetail.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

class ItemDetailDAO {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	ItemDTO item;
	
	String query = "select code, name, price, info, origin, to_char(reg_date, 'YYYY/MM/DD') "
			+ "from item_board where code = ?";
	
	ItemDTO doIt(String code) {
		try {
			Class.forName(OracleXE11g.LIB);
			con = DriverManager.getConnection(OracleXE11g.NAME, "hr", "hr");
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, code);
			rs = pstmt.executeQuery();
			if(rs.next()) { //조회결과가 존재하는 경우
				
				item = new ItemDTO(); //조회결과를 저장하기 위해 DTO를 생성한다.
				item.setCode(rs.getString(1));
				item.setName(rs.getString(2));
				item.setPrice(rs.getInt(3));
				item.setInfo(rs.getString(4));
				item.setOrigin(rs.getString(5));
				item.setReg_date(rs.getString(6));
			}
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println("상품 상세정보 작업 중 문제발생");
		}finally {
			try {
				con.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return item;
	}
	
	
}
