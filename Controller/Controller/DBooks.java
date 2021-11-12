package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bo.Bookbo;
import Bo.Categorybo;

/**
 * Servlet implementation class DBooks
 */
@WebServlet("/delbook")
public class DBooks extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			resp.setContentType("text/html;charset=UTF-8");
     	 	req.setCharacterEncoding("utf-8");
     	 	resp.setCharacterEncoding("utf-8"); 
     	 	
			String ms = (String)req.getParameter("id");
			if(ms!=null&&ms!="") {
				Bookbo sbo = new Bookbo();
				if(sbo.deleteBook(Long.parseLong(ms))) {						
					HttpSession session = req.getSession();
					session.setAttribute("alertx", "Xoá sách thành công!");
					resp.sendRedirect("qlsach");
				}
				else {
					HttpSession session = req.getSession();
					session.setAttribute("errorx", "Xoá loại thất bại!");
					resp.sendRedirect("qlsach");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
