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
 * Servlet implementation class QLBooks
 */
@WebServlet("/qlsach")
public class QLBooks extends HttpServlet {
	private static final long serialVersionUID = 1L;       
    @Override
    	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	try {
    		Bookbo sbo = new Bookbo();
    		ArrayList<Bookbean>  dsbook = sbo.getsach();
    		req.setAttribute("dsbook", dsbook);
    		RequestDispatcher rd = req.getRequestDispatcher("Books.jsp");
    		rd.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}    	
    	}
}
