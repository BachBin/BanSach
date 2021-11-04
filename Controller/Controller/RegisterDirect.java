package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.Bookbean;
import Bean.Categorybean;
import Bo.Bookbo;
import Bo.Categorybo;

/**
 * Servlet implementation class RegisterDirect
 */
@WebServlet("/register")
public class RegisterDirect extends HttpServlet {
	private static final long serialVersionUID = 1L;   
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	try {
			Bookbo sbo = new Bookbo();		
		Categorybo lbo = new Categorybo();		
		
		ArrayList<Bookbean> dsbook = sbo.getsach();
		ArrayList<Categorybean> dscate = lbo.getloai();
				
		
		req.setAttribute("dsbook", dsbook);
		req.setAttribute("dscate", dscate);
		req.setAttribute("booknew", sbo.sachNew());
		req.getRequestDispatcher("register.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}    	   	
    }
}
