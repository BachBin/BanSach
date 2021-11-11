package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class QLBooks
 */
@WebServlet("/qlsach")
public class QLBooks extends HttpServlet {
	private static final long serialVersionUID = 1L;       
    @Override
    	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	RequestDispatcher rd = req.getRequestDispatcher("Books.jsp");
		rd.forward(req, resp);
    	}
}
