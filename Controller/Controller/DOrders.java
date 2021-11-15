package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bo.Bookbo;
import Bo.OrderDetailbo;
import Bo.Orderbo;

/**
 * Servlet implementation class DOrders
 */
@WebServlet("/deleteorder")
public class DOrders extends HttpServlet {
	private static final long serialVersionUID = 1L;       
    @Override
    	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	try {
			resp.setContentType("text/html;charset=UTF-8");
     	 	req.setCharacterEncoding("utf-8");
     	 	resp.setCharacterEncoding("utf-8"); 
     	 	
			String mo = (String)req.getParameter("id");
			if(mo!=null&&mo!="") {
				Orderbo obo = new Orderbo();
				OrderDetailbo odbo = new OrderDetailbo();
				if(odbo.deleteOrderDetail(Long.parseLong(mo))) {
					if(obo.deleteOrder(Long.parseLong(mo))) {						
						HttpSession session = req.getSession();
						session.setAttribute("alertx", "Xoá đơn hàng thành công!");
						resp.sendRedirect("qlhoadon");
					}
					else {
						HttpSession session = req.getSession();
						session.setAttribute("errorx", "Xoá đơn hàng thất bại!");
						resp.sendRedirect("qlhoadon");
					}
				}				
				else {
					if(obo.deleteOrder(Long.parseLong(mo))) {						
						HttpSession session = req.getSession();
						session.setAttribute("alertx", "Xoá đơn hàng thành công!");
						resp.sendRedirect("qlhoadon");
					}
					else {
						HttpSession session = req.getSession();
						session.setAttribute("errorx", "Xoá đơn hàng thất bại!");
						resp.sendRedirect("qlhoadon");
					}					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	}
}
