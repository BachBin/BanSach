package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.Bookbean;
import Bean.Categorybean;
import Bean.Customerbean;
import Bean.SubOrder;
import Bo.Bookbo;
import Bo.Categorybo;
import Bo.SubOrderbo;

/**
 * Servlet implementation class History
 */
@WebServlet("/lichsumuahang")
public class History extends HttpServlet {
	private static final long serialVersionUID = 1L;       
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	try {
			HttpSession session = req.getSession();
    		Customerbean auth = (Customerbean)session.getAttribute("auth");
    		if(auth==null) {
    			resp.sendRedirect("login");
    		}
    		else {
    			Long makh = auth.getId();
    			SubOrderbo sborder = new SubOrderbo();
    			ArrayList<SubOrder> dsOrder = sborder.getOrders(makh);
    			
    			Bookbo sbo = new Bookbo();		
        		Categorybo lbo = new Categorybo();		
        		
        		ArrayList<Bookbean> dsbook = sbo.getsach();
        		ArrayList<Categorybean> dscate = lbo.getloai();
        				
        		req.setAttribute("dsOrder", dsOrder);
        		req.setAttribute("dsbook", dsbook);
        		req.setAttribute("dscate", dscate);
        		req.setAttribute("booknew", sbo.sachNew());
        		RequestDispatcher rd = req.getRequestDispatcher("History.jsp");
    			rd.forward(req, resp);
    		}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

}
