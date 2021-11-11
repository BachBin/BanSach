package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.Categorybean;
import Bo.Categorybo;

/**
 * Servlet implementation class QLCategories
 */
@WebServlet("/qlloaisach")
public class QLCategories extends HttpServlet {
	private static final long serialVersionUID = 1L;       
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Categorybo lbo = new Categorybo();	
			ArrayList<Categorybean> dscate = lbo.getloai();
			req.setAttribute("dscate", dscate);
			RequestDispatcher rd = req.getRequestDispatcher("Categories.jsp");
			rd.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
