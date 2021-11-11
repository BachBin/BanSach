package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.Bookbean;
import Bo.Bookbo;


/**
 * Servlet implementation class SearchBook
 */
@WebServlet("/searchbook")
public class SearchBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			resp.setContentType("text/html;charset=UTF-8");
			req.setCharacterEncoding("utf-8");
			resp.setCharacterEncoding("utf-8");
			String search = req.getParameter("search");			
			Bookbo sbo = new Bookbo();
			ArrayList<Bookbean> dsbook = sbo.Tim(search);
			req.setAttribute("dsbook", dsbook);
			RequestDispatcher rd = req.getRequestDispatcher("Books.jsp");
			rd.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
}
