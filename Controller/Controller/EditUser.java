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
import Bean.Login;
import Bo.Customerbo;
import Bo.Loginbo;


@WebServlet("/editUser")
public class EditUser extends HttpServlet {
	private static final long serialVersionUID = 1L; 
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");		
		HttpSession session = req.getSession();
		Login user = (Login)session.getAttribute("auth");		
		String id = req.getParameter("makh");
		String mk = req.getParameter("matkhau");		
		
		if(user.getTendn().equals(id) && user.getMatkhau().equals(mk)) {
			resp.sendRedirect("home");	
		}
		else {
			Loginbo kbo = new Loginbo();
			Login usernew = new Login(id, mk, user.isIsadmin());
			if(kbo.updateLogin(usernew)) {
				session.setAttribute("auth", usernew);
				req.setAttribute("alert","Cập nhật tài khoản thành công!");
				req.getRequestDispatcher("home").forward(req, resp);
			}			
		} 			
	}
}
