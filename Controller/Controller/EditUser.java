package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.google.gson.Gson;

import Bean.Customerbean;
import Bo.Customerbo;


@WebServlet("/editUser")
public class EditUser extends HttpServlet {
	private static final long serialVersionUID = 1L; 
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");		
		HttpSession session = req.getSession();
		Customerbean user = (Customerbean)session.getAttribute("auth");		
		String id = req.getParameter("makh");
		String mk = req.getParameter("matkhau");		
		String ht = req.getParameter("hoten");
		String dc = req.getParameter("diachi");
		String sdt = req.getParameter("sdt");
		String email = req.getParameter("email");				
		if(user.getTendn().equals(id) && user.getMatkhau().equals(mk) && user.getHoten().equals(ht) && user.getDiachi().equals(dc) && user.getSdt().equals(sdt) && user.getEmail().equals(email)) {
			resp.sendRedirect("home");	
		}
		else {
			Customerbo kbo = new Customerbo();
			if(kbo.updateCustomer(new Customerbean(user.getId(), ht, dc, sdt, email, id, mk))) {
				session.setAttribute("auth", new Customerbean(user.getId(), ht, dc, sdt, email, id, mk));
				req.setAttribute("alert","Cập nhật tài khoản thành công!");
				req.getRequestDispatcher("home").forward(req, resp);			
			}
		} 			
	}
}
