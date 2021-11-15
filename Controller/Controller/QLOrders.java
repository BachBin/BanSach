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

import Bean.Order;
import Bean.OrderDetail;
import Bean.SubOrder;
import Bo.Bookbo;
import Bo.OrderDetailbo;
import Bo.Orderbo;

/**
 * Servlet implementation class QLOrders
 */
@WebServlet("/qlhoadon")
public class QLOrders extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Override
    	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	try {
    		Orderbo od = new Orderbo();
    		ArrayList<Order> dsOrder =  od.getAllOrder();
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
				String hoten = o.getHoten();
				String diachi = o.getDiachi();
				String sodt = o.getSdt();
				SubOrder sbor = new SubOrder(MaHoaDon,tongTien, ngayMua, hoten, diachi, sodt,o.isDaMua());
				dsSubOrder.add(sbor);
			}
			req.setAttribute("dsOrder", dsSubOrder);
    		RequestDispatcher rd = req.getRequestDispatcher("Orders.jsp");
    		rd.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	}
}
