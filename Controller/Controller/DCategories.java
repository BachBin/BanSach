package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bo.Categorybo;

/**
 * Servlet implementation class DCategories
 */
@WebServlet("/delcategories")
public class DCategories extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			try {
				resp.setContentType("text/html;charset=UTF-8");
	     	 	req.setCharacterEncoding("utf-8");
	     	 	resp.setCharacterEncoding("utf-8"); 
	     	 	
				String ml = (String)req.getParameter("id");
				if(ml!=null&&ml!="") {
					Categorybo cate = new Categorybo();
					if(cate.deleteCate(ml)) {						
						HttpSession session = req.getSession();
						session.setAttribute("alertx", "Xoá loại thành công!");
						resp.sendRedirect("qlloaisach");
					}
					else {
						HttpSession session = req.getSession();
						session.setAttribute("errorx", "Xoá loại thất bại, đã có sách hãy xoá sách trước!");
						resp.sendRedirect("qlloaisach");
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
}
