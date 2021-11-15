package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.OrderDetail;
import Bean.OrderDetails;
import Bo.Bookbo;
import Bo.OrderDetailbo;

/**
 * Servlet implementation class DetailAD
 */
@WebServlet("/orderdetail")
public class DetailAD extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			try {
				Long mahd = Long.valueOf(req.getParameter("id"));		
				Bookbo sbo = new Bookbo();	
				OrderDetailbo dtbo = new OrderDetailbo();
				ArrayList<OrderDetail> dsdetail = dtbo.getOrderDt(mahd);
				ArrayList<OrderDetails> dsOrderDetail = new ArrayList<OrderDetails>();
				for(OrderDetail o:dsdetail) {
					Long masach = o.getMaSach(); 
					String tensach = sbo.getBookbyMaSach(o.getMaSach()).getTensach(); 
					String tacgia = sbo.getBookbyMaSach(o.getMaSach()).getTacgia(); 
					String anh = sbo.getBookbyMaSach(o.getMaSach()).getAnh();
					Long gia = sbo.getBookbyMaSach(o.getMaSach()).getGia();
					int slmua = o.getSoLuongMua();
					boolean damua =o.isDaMua();
					OrderDetails od = new OrderDetails(o.getMaChiTietHD(),masach, tensach, tacgia, anh, gia, slmua,damua);
					dsOrderDetail.add(od);
				}
				req.setAttribute("dsOrder", dsOrderDetail);
	    		RequestDispatcher rd = req.getRequestDispatcher("DetailAD.jsp");
	    		rd.forward(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
}
