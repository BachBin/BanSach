package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.Customerbean;
import Bean.Login;
import Bo.Customerbo;
import Bo.Loginbo;


@WebServlet("/create")
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
     @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	 	resp.setContentType("text/html;charset=UTF-8");
    	 	req.setCharacterEncoding("utf-8");
    	 	resp.setCharacterEncoding("utf-8");    	 	
    	 	 	 	
			String tendn = req.getParameter("tendncr");
			String matkhau= req.getParameter("matkhaucr");
			String rematkhau = req.getParameter("rematkhaucr");			
			if(!matkhau.equals(rematkhau)) {
				req.setAttribute("mess", "Kiểm tra lại mật khẩu!");				
				req.setAttribute("tendn", tendn);	
				req.getRequestDispatcher("register").forward(req, resp);
			}
			else {
				Loginbo lgbo = new Loginbo();
				if(lgbo.checkExists(tendn)) {
					req.setAttribute("mess", "Tài khoản đã tồn tại!");					
					req.setAttribute("mk", matkhau);	
					req.setAttribute("remk", rematkhau);
					req.getRequestDispatcher("register").forward(req, resp);
				}
				else {
					if(lgbo.createLogin(new Login(tendn,matkhau,false))) {
						req.setAttribute("tknew", tendn);
						req.setAttribute("mknew", matkhau);
						req.getRequestDispatcher("login").forward(req, resp);
					}		
					else resp.sendRedirect("register");
				}
			}
			
    }	
}
