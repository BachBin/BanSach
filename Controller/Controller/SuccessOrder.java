package Controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.Customerbean;
import Bean.GioHangbean;
import Bean.Order;
import Bean.OrderDetail;
import Bo.Customerbo;
import Bo.GioHangbo;
import Bo.OrderDetailbo;
import Bo.Orderbo;

/**
 * Servlet implementation class SuccessOrder
 */
@WebServlet("/xacnhandon")
public class SuccessOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			resp.setContentType("text/html;charset=UTF-8");
			req.setCharacterEncoding("utf-8");
			resp.setCharacterEncoding("utf-8");
			
			String hoten = req.getParameter("hoten");
			String diachi = req.getParameter("diachi");
			String sdt = req.getParameter("sdt");
			String email = req.getParameter("email");
			
			HttpSession session = req.getSession();
			Customerbean auth = (Customerbean)session.getAttribute("auth");
			Customerbo ctbo = new Customerbo();		
			Customerbean authorder = new Customerbean(auth.getId(), hoten, diachi, sdt, email, auth.getTendn(), auth.getMatkhau());
			ctbo.updateCustomer(authorder);
			
			session.setAttribute("auth", authorder);
			
			GioHangbo order = (GioHangbo)session.getAttribute("order");		
			if(order!=null && order.Size()>0) {
				Date date = new Date();		
				Timestamp datecreate = new Timestamp(date.getTime());
				Orderbo odbo = new Orderbo();
				Order od = new Order((long)-1,auth.getId(),datecreate,hoten,diachi,sdt,true);
				Long idOrder = odbo.createOrder(od,hoten,diachi,sdt);
				if(idOrder > 0) {								
					if(order!=null && order.Size()>0) {
						if(order!=null) { 
							OrderDetailbo dtbo = new OrderDetailbo();
		            		for(GioHangbean i: order.ds){            						
		            			OrderDetail dt = new OrderDetail((long)-1, i.getMasach(), i.getSlmua(), idOrder, true);
		            			dtbo.createOrderDetail(dt);
		            		}
						}
						session.setAttribute("successod", "Tạo đơn thành công!");
						resp.sendRedirect("home");		
					}					
				}
				else {
					req.setAttribute("mess", "Không thể tạo đơn hàng!");
					RequestDispatcher rd = req.getRequestDispatcher("thanhtoan");
	    			rd.forward(req, resp);    	
				}
			}
			else {
				req.setAttribute("mess", "Không có hàng!");
				RequestDispatcher rd = req.getRequestDispatcher("thanhtoan");
    			rd.forward(req, resp);    	
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
