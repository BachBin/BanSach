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
 * Servlet implementation class ProductDetail
 */
@WebServlet("/detail")
public class ProductDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Override
    	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    		String ms = req.getParameter("bookid");
    		Bookbo sbo = new Bookbo();
    		Bookbean book = sbo.getBookbyMaSach(ms);
    		Categorybo lbo = new Categorybo();
    		
    		ArrayList<Bookbean> dsbook = sbo.getsach();
    		ArrayList<Categorybean> dscate = lbo.getloai();
    		req.setAttribute("dsbook", dsbook);
    		req.setAttribute("dscate", dscate);
    		req.setAttribute("booknew", sbo.sachNew());
    		req.setAttribute("book", book);
    		
    		req.getRequestDispatcher("Details.jsp").forward(req, resp);
    	}   
    

}
