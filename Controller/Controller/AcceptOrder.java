package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.Bookbean;
import Bean.OrderDetail;
import Bean.OrderDetails;
import Bo.Bookbo;
import Bo.OrderDetailbo;
import Bo.Orderbo;

/**
 * Servlet implementation class AcceptOrder
 */
@WebServlet("/accept")
public class AcceptOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;      
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	try {
    		resp.setContentType("text/html;charset=UTF-8");
     	 	req.setCharacterEncoding("utf-8");
     	 	resp.setCharacterEncoding("utf-8"); 
     	 	
     	 	String id = (String)req.getParameter("id");
     	 	String ido = (String)req.getParameter("ido");
     	 	if(id!=null&&!id.equals("")&&ido!=null&&!ido.equals("")) {  
     	 		OrderDetailbo odbo = new OrderDetailbo();
     	 		OrderDetail hdct = odbo.getOrderDtbymacthd(Long.parseLong(id));
     	 		if(hdct.isDaMua()==true) {     	 			
     	 			resp.sendRedirect("orderdetail?id="+ido);
     	 			return;
     	 		}
     	 		Bookbo sbo = new Bookbo();
     	 		Bookbean sachmua = sbo.getBookbyMaSach(hdct.getMaSach());
     	 		if(hdct.getSoLuongMua() <= sachmua.getSoluong()) {
     	 			long slupdate = (sachmua.getSoluong() - (long)hdct.getSoLuongMua() > 0)?sachmua.getSoluong() - (long)hdct.getSoLuongMua():0;
     	 			odbo.updateStatus(Long.parseLong(id), "True");
     	 			sbo.updateSLBook(hdct.getMaSach(), slupdate);
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
					session.setAttribute("alertx1", "Xác nhận chi tiết đơn hàng thành công!");					
					resp.sendRedirect("orderdetail?id="+ido);
     	 		}
     	 		else {
     	 			if(sachmua.getSoluong() > 0 ) {
     	 				OrderDetail odtupdate = new  OrderDetail((long)-1, hdct.getMaSach(), sachmua.getSoluong().intValue(), hdct.getMaHoaDon(), true);
     	 				odbo.createOrderDetail(odtupdate);
     	 				if(hdct.getSoLuongMua() - sachmua.getSoluong() > 0)
     	 					odbo.updateQuantity(hdct.getMaChiTietHD(), hdct.getSoLuongMua() - sachmua.getSoluong());
     	 				odbo.updateStatus(hdct.getMaChiTietHD(), "False");
     	 				sbo.updateSLBook(hdct.getMaSach(), (long)0);	
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
    	 				session.setAttribute("errorx1", "Cập nhật đơn hàng, số lượng trong kho không đủ!");					
    					resp.sendRedirect("orderdetail?id="+ido);
     	 			}
     	 			else {
     	 				HttpSession session = req.getSession();
    	 				session.setAttribute("errorx2", "Số lượng trong kho không đủ!");
     	 				resp.sendRedirect("orderdetail?id="+ido);
     	 			}
     	 		}
     	 	}
     	 	else {
     	 		resp.sendRedirect("orderdetail?id="+ido);
     	 	}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
