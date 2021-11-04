package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import Bean.GioHangbean;
import Bo.Bookbo;
import Bo.GioHangbo;


@WebServlet("/delcart")
public class EditCart extends HttpServlet {
	private static final long serialVersionUID = 1L;      
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ArrayList<String> res = new ArrayList<String>();		
		Long id = Long.valueOf(req.getParameter("id"));
		HttpSession session = req.getSession();
		GioHangbo gh = (GioHangbo)session.getAttribute("order");
		for(GioHangbean e:gh.ds) {
			if(e.getMasach()==id) {
				gh.ds.remove(e);			
				break;
			}
		}
		session.setAttribute("order", gh);
		
		res.add(NumberFormat.getNumberInstance(Locale.US).format(gh.Tongtien()));
		res.add(String.valueOf(gh.Size()));
		
		
		String json = new Gson().toJson(res);
		
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().write(json);
	}
}
