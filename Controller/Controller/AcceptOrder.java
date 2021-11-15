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
     	 	
     	 	if(id!=null&&id!="") {  
     	 		OrderDetailbo odbo = new OrderDetailbo();
     	 		if(odbo.updateStatus(Long.parseLong(id), "True")) {
     	 			OrderDetail oddt = odbo.getOrderDtbymacthd(Long.parseLong(id));
     	 			Bookbo sbo = new Bookbo();     	 	
     	 			Long slkho =  sbo.getBookbyMaSach(oddt.getMaSach()).getSoluong();
     	 			if(oddt.getSoLuongMua() <= slkho && oddt.isDaMua()==false) {
     	 				long slu = (slkho - (long)oddt.getSoLuongMua() > 0)?slkho - (long)oddt.getSoLuongMua():0;
     	 				if(sbo.updateSLBook(oddt.getMaSach(), slu)) {
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
     	 			}
     	 			else {     	 				
     	 				if(slkho > 0) {     	 					
     	 					OrderDetail od1 = new OrderDetail((long)-1, oddt.getMaSach(), slkho.intValue(), oddt.getMaHoaDon(), true);
     	 					odbo.createOrderDetail(od1);
     	 					odbo.updateQuantity(Long.parseLong(id), oddt.getSoLuongMua() - slkho);
     	 					odbo.updateStatus(Long.parseLong(id), "False");
     	 					if(sbo.updateSLBook(oddt.getMaSach(), (long)0)) {
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
     	 					
     	 				}
     	 				else {     
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
    						resp.sendRedirect("orderdetail?id="+ido);
     	 				}
     	 			}     	 			
     	 		}
     	 		else {
     	 			HttpSession session = req.getSession();
					session.setAttribute("errorx1", "Xác nhận chi tiết đơn hàng thất bại!");					
					resp.sendRedirect("orderdetail?id="+ido);
     	 		}
     	 	}    		
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
