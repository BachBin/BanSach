package Controller;

import java.io.IOException;
import java.sql.Timestamp;
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
import Bean.Order;
import Bean.OrderDetail;
import Bean.SubOrder;
import Bo.Bookbo;
import Bo.Categorybo;
import Bo.OrderDetailbo;
import Bo.Orderbo;


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
    			
    			Orderbo od = new Orderbo();
    			ArrayList<Order> dsOrder =  od.getOrder(makh);
    			OrderDetailbo dtail = new OrderDetailbo();
    			ArrayList<SubOrder> dsSubOrder = new ArrayList<SubOrder>();
    			Bookbo sbo = new Bookbo();		
    			for(Order o:dsOrder) {
    				ArrayList<OrderDetail> dsDetail =  dtail.getOrderDt(o.getMaHoaDon());
    				Long tt = (long)0;
    				for(OrderDetail e:dsDetail) {
    					tt += e.getSoLuongMua() * sbo.getPrice(e.getMaSach());
    				}
    				Long MaHoaDon = o.getMaHoaDon();
    				Long tongTien = tt;
    				Timestamp ngayMua = o.getNgayMua();
    				String hoten = auth.getHoten();
    				String diachi = auth.getDiachi();
    				String sodt = auth.getSdt();
    				SubOrder sbor = new SubOrder(MaHoaDon,tongTien, ngayMua, hoten, diachi, sodt);
    				dsSubOrder.add(sbor);
    			}
    			
    			
        		Categorybo lbo = new Categorybo();		
        		
        		ArrayList<Bookbean> dsbook = sbo.getsach();
        		ArrayList<Categorybean> dscate = lbo.getloai();
        				
        		req.setAttribute("dsOrder", dsSubOrder);
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
