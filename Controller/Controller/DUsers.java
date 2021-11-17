package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bo.Categorybo;
import Bo.Loginbo;

/**
 * Servlet implementation class DUsers
 */
@WebServlet("/deleteuser")
public class DUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	try {
    		resp.setContentType("text/html;charset=UTF-8");
     	 	req.setCharacterEncoding("utf-8");
     	 	resp.setCharacterEncoding("utf-8"); 
     	 	
			String id = (String)req.getParameter("id");
			if(id!=null&&id!="") {
				Loginbo lgbo = new Loginbo();
				if(lgbo.deleteLogin(id)) {						
					HttpSession session = req.getSession();
					session.setAttribute("alertx", "Xoá tài khoản thành công!");
					resp.sendRedirect("qltaikhoan");
				}
				else {
					HttpSession session = req.getSession();
					session.setAttribute("errorx", "Xoá tài khoản thất bại!");
					resp.sendRedirect("qltaikhoan");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }  

}
