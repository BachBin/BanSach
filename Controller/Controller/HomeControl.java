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
 * Servlet implementation class HomeControl
 */
@WebServlet("/home")
public class HomeControl extends HttpServlet {
	private static final long serialVersionUID = 1L;      
   

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		Bookbo sbo = new Bookbo();		
		Categorybo lbo = new Categorybo();		
		
		ArrayList<Bookbean> dsbook = sbo.getsach();
		ArrayList<Categorybean> dscate = lbo.getloai();				
		
		request.setAttribute("dsbook", dsbook);
		request.setAttribute("dscate", dscate);
		request.setAttribute("booknew", sbo.sachNew());
		request.getRequestDispatcher("index.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
}
