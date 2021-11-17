package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.Login;
import Bo.Loginbo;

/**
 * Servlet implementation class CUUsers
 */
@WebServlet("/cuusers")
public class CUUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			resp.setContentType("text/html;charset=UTF-8");
     	 	req.setCharacterEncoding("utf-8");
     	 	resp.setCharacterEncoding("utf-8");
     	 	
     	 	String id = (String)req.getParameter("id");
     	 	String tendn = (String)req.getParameter("tendn");
     	 	String matkhau = (String)req.getParameter("matkhau");
     	 	String quyen = (String)req.getParameter("quyen");
     	 	boolean isadmin = (quyen==null)?true:false;
     	 	Loginbo lgbo = new Loginbo();
     	 	if(id!=null && !id.equals("")) {     	 		
     	 		if(lgbo.updateLogin(new Login(id, matkhau, isadmin))) {
     	 			HttpSession session = req.getSession();
					session.setAttribute("alert1", "Cập nhật tài khoản thành công!");
					resp.sendRedirect("qltaikhoan");
     	 		}
     	 		else {
     	 			HttpSession session = req.getSession();
					session.setAttribute("error1", "Cập nhật tài khoản thất bại!");
					resp.sendRedirect("qltaikhoan");
     	 		}
     	 	}
     	 	else {     	 	     	 		
     	 		if(lgbo.createLogin(new Login(tendn, matkhau, isadmin))) {
     	 			HttpSession session = req.getSession();
					session.setAttribute("alert2", "Tạo tài khoản thành công!");
					resp.sendRedirect("qltaikhoan");
     	 		}
     	 		else {
     	 			HttpSession session = req.getSession();
					session.setAttribute("error2", "Tạo tài khoản thất bại, tên tài khoản đã tồn tại!");
					resp.sendRedirect("qltaikhoan");
     	 		}
     	 	}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
