package Controller;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import Bean.GioHangbean;
import Bo.GioHangbo;

/**
 * Servlet implementation class IncDecCart
 */
@WebServlet("/incdec")
public class IncDecCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String id = req.getParameter("id");
			String action = req.getParameter("action");
			GioHangbo gh = null;
			HttpSession session = req.getSession();
			ArrayList<String> res = new ArrayList<String>();
			long sl = 0;
			if(action.equals("inc")) {
				gh = (GioHangbo)session.getAttribute("order");
				for(GioHangbean e:gh.ds) {
					if(e.getMasach().equals(id)) {
						e.setSlmua(e.getSlmua()+1);
						sl = e.getSlmua();
						break;
					}
				}
			}
			else {
				gh = (GioHangbo)session.getAttribute("order");
				for(GioHangbean e:gh.ds) {
					if(e.getMasach().equals(id) && e.getSlmua() > 1) {
						e.setSlmua(e.getSlmua()-1);
						sl = e.getSlmua();
						break;
					}
					else if(e.getMasach().equals(id) && e.getSlmua() == 1){
						gh.ds.remove(e);
						res.add("del");
						break;
					}
				}
			}		
		
		session.setAttribute("order", gh);
		
		res.add(NumberFormat.getNumberInstance(Locale.US).format(gh.Tongtien()));
		res.add(String.valueOf(gh.Size()));
		res.add(String.valueOf(sl));
		
		String json = new Gson().toJson(res);

		
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().write(json);
	}
}
