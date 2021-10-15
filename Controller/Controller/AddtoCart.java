package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.Bookbean;
import Bean.GioHangbean;
import Bo.Bookbo;
import Bo.GioHangbo;


@WebServlet("/addtoCart")
public class AddtoCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	long quantity = 1;
    	GioHangbo gh = null;
    	String ms = req.getParameter("bookId");    	
    	String sl = req.getParameter("quantity");
    	if(sl != null) quantity = Integer.parseInt(sl);
    	HttpSession session = req.getSession();
    	if(session.getAttribute("order")==null) {
    		gh = new GioHangbo();
    		Bookbo sbo = new Bookbo();
    		Bookbean book = sbo.getBookbyID(ms);
    		gh.Them(ms, book.getTensach(), book.getTacgia(), book.getAnh(), book.getGia(), quantity);
    		session.setAttribute("order", gh);
    		resp.sendRedirect("home");
    	}
    	else {
    		gh = (GioHangbo) session.getAttribute("order");
    		Bookbo sbo = new Bookbo();
    		Bookbean book = sbo.getBookbyID(ms);
    		gh.Them(ms, book.getTensach(), book.getTacgia(), book.getAnh(), book.getGia(), quantity);
    		session.setAttribute("order", gh);
    		resp.sendRedirect("home");
    	}
    }

}
