package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.Bookbean;
import Bo.Bookbo;

/**
 * Servlet implementation class loadcategories
 */
@WebServlet("/loadcategories")
public class loadcategories extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	try {
    		resp.setContentType("text/html;charset=UTF-8");
    		String ml = req.getParameter("maloai");
    		Bookbo sbo = new Bookbo();
    		ArrayList<Bookbean> listbook = sbo.TimLoai(ml);    		
    		req.setAttribute("dsbooktk", listbook);
    		req.getRequestDispatcher("home").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}    	
    		
    }
}
