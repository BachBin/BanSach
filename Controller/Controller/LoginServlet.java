package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.Customerbean;
import Bo.Customerbo;



@WebServlet("/user-login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		String tk = req.getParameter("makh");
		String mk = req.getParameter("matkhau");
		Customerbo kbo = new Customerbo();
		if(kbo.checkLogin(tk, mk)==null){
			req.setAttribute("error", "Sai tên tài khoản hoặc mật khẩu!");
			req.getRequestDispatcher("login").forward(req, resp);
		}		
		else {
			HttpSession session = req.getSession();
			session.setAttribute("auth", kbo.checkLogin(tk, mk));
			resp.sendRedirect("home");			
		}		
	} 	
}
