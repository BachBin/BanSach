package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.Bookbean;
import Bo.Bookbo;

/**
 * Servlet implementation class Search
 */
@WebServlet("/searchenter")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;       
   
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		String search = req.getParameter("search");
		Bookbo sbo = new Bookbo();
		ArrayList<Bookbean> dsbook = sbo.Tim(search);
		req.setAttribute("dsbooktk", dsbook);
		req.setAttribute("search", search);
		req.getRequestDispatcher("home").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
