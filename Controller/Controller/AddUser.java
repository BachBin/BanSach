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
    	 try {
    		 resp.setContentType("text/html;charset=UTF-8");
     	 	req.setCharacterEncoding("utf-8");
     	 	resp.setCharacterEncoding("utf-8");  
     	 	
     	 	String hoten = req.getParameter("hoten");
     	 	String diachi = req.getParameter("diachi");
     	 	String sdt = req.getParameter("sdt");
     	 	String email = req.getParameter("email");    	 	
     	 	
 			String tendn = req.getParameter("tendncr");
 			String matkhau= req.getParameter("matkhaucr");
 			String rematkhau = req.getParameter("rematkhaucr");			
 			if(!matkhau.equals(rematkhau)) {
 				req.setAttribute("mess", "Kiểm tra lại mật khẩu!");				
 				req.setAttribute("hoten", hoten);
					req.setAttribute("diachi", diachi);
					req.setAttribute("sdt", sdt);
					req.setAttribute("email", email);
					req.setAttribute("tknew", tendn);
					req.setAttribute("mknew", matkhau);
					req.setAttribute("remk", rematkhau);
 				req.getRequestDispatcher("register").forward(req, resp);
 			}
 			else {
 				Customerbo lgbo = new Customerbo();
 				if(lgbo.checkExists(tendn)) {
 					req.setAttribute("mess", "Tài khoản đã tồn tại!");					
 					req.setAttribute("hoten", hoten);
						req.setAttribute("diachi", diachi);
						req.setAttribute("sdt", sdt);
						req.setAttribute("email", email);
						req.setAttribute("tknew", tendn);
						req.setAttribute("mknew", matkhau);
						req.setAttribute("remk", rematkhau);
 					req.getRequestDispatcher("register").forward(req, resp);
 				}
 				else {
 					Customerbean ac = new Customerbean(-1, hoten, diachi, sdt, email, tendn, matkhau);
 					if(lgbo.createCustomer(ac)) {
 						
 						req.setAttribute("hoten", hoten);
 						req.setAttribute("diachi", diachi);
 						req.setAttribute("sdt", sdt);
 						req.setAttribute("email", email);
 						req.setAttribute("tknew", tendn);
 						req.setAttribute("mknew", matkhau);
 						req.setAttribute("remk", rematkhau);
 						req.getRequestDispatcher("login").forward(req, resp);
 					}		
 					else resp.sendRedirect("register");
 				}
 			}
		} catch (Exception e) {
			e.printStackTrace();
		}			
    }	
}
