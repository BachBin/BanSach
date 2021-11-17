package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.OrderDetail;
import Bo.OrderDetailbo;
import Bo.Orderbo;

/**
 * Servlet implementation class DOrderDetail
 */
@WebServlet("/deletedetail")
public class DOrderDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;   
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			resp.setContentType("text/html;charset=UTF-8");
     	 	req.setCharacterEncoding("utf-8");
     	 	resp.setCharacterEncoding("utf-8"); 
     	 	
     	 	String id = (String)req.getParameter("id");
     	 	String ido = (String)req.getParameter("ido");
     	 	
     	 	if(id!=null&&id!="") {     	 		
     	 		OrderDetailbo odbo = new OrderDetailbo();
     	 		if(odbo.deleteOrderDetailbyMCTHD(Long.parseLong(id))) {  
     	 			ArrayList<OrderDetail> dsod = odbo.getOrderDt(Long.parseLong(ido));
	 				boolean co = true;
	 				for(OrderDetail o:dsod) {     	 						
	 					if(o.isDaMua()==false)
	 					{
	 						co = false;
	 						break;
	 					}
	 				}
	 				if(co==true) {
	 					Orderbo obo = new Orderbo();
	 					obo.updateStatus(Long.parseLong(ido), "True");
	 				}
     	 			HttpSession session = req.getSession();
					session.setAttribute("alertx", "Xoá chi tiết đơn hàng thành công!");					
					resp.sendRedirect("orderdetail?id="+ido);
     	 		}
     	 		else {
					HttpSession session = req.getSession();
					session.setAttribute("errorx", "Xoá chi tiết đơn hàng thất bại!");					
					resp.sendRedirect("orderdetail?id="+ido);
				}
     	 	}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
