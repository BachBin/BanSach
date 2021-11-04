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

import com.google.gson.Gson;

import Bean.Bookbean;
import Bean.GioHangbean;
import Bo.Bookbo;
import Bo.GioHangbo;


@WebServlet("/addAjax")
public class AddtoCartAjax extends HttpServlet {	
	private static final long serialVersionUID = 1L;
    @Override   
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	try {
    		int quantity = 1;
        	GioHangbo gh = null;
        	Long ms = Long.valueOf(req.getParameter("masach"));    	
        	String sl = req.getParameter("quantity");
        	if(sl != null) quantity = Integer.parseInt(sl);
        	HttpSession session = req.getSession();
        	String data = null;
        	if(session.getAttribute("order")==null) {
        		gh = new GioHangbo();
        		Bookbo sbo = new Bookbo();
        		Bookbean book = sbo.getBookbyMaSach(ms);
        		gh.Them(ms, book.getTensach(), book.getTacgia(), book.getAnh(), book.getGia(), quantity);
        		session.setAttribute("order", gh);
        		data = new Gson().toJson(gh.Size());
        		
        	}
        	else {
        		gh = (GioHangbo) session.getAttribute("order");
        		Bookbo sbo = new Bookbo();
        		Bookbean book = sbo.getBookbyMaSach(ms);
        		gh.Them(ms, book.getTensach(), book.getTacgia(), book.getAnh(), book.getGia(), quantity);
        		session.setAttribute("order", gh);
        		data = new Gson().toJson(gh.Size());
        		
        	}
        	resp.setContentType("application/json");
    		resp.setCharacterEncoding("UTF-8");
    		resp.getWriter().write(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

}
