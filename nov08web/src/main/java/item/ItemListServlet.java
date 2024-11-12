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
 * Servlet implementation class ItemListServlet
 */
@WebServlet("/itemList.do")
public class ItemListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ItemListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ItemListDAO dao = new ItemListDAO();
		ArrayList<ItemDTO> list = dao.doIt();
		request.setAttribute("ITEMS", list);
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp?BODY=itemList.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
class ItemListDAO {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	ArrayList<ItemDTO> al;
	String query = "select code,name,price,origin,to_char(reg_date, 'YYYY/MM/DD') from item_board"; //상품 설명은 상품 상세정보에서 처리함
	
	ArrayList<ItemDTO> doIt() {
		try {
			Class.forName(OracleXE11g.LIB);
			con = DriverManager.getConnection(OracleXE11g.NAME, "hr", "hr");
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			al = new ArrayList<ItemDTO>();
			while(rs.next()) {
				ItemDTO dto = new ItemDTO(); //dto 생성
				dto.setCode(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setPrice(rs.getInt(3));
				dto.setOrigin(rs.getString(4));
				dto.setReg_date(rs.getString(5));
				al.add(dto); //ArrayList에 dto 저장
			}
		} catch (Exception e) {
			System.out.println("상품 목록 조회 중 문제발생");
		}finally {
			try {
				con.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return al;
	}
}