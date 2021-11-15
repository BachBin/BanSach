package Bo;

import java.util.ArrayList;

import Bean.OrderDetail;
import Dao.OrderDetaildao;


public class OrderDetailbo {
	OrderDetaildao odao = new OrderDetaildao();
	public ArrayList<OrderDetail> getOrderDt(Long mahd) throws Exception {
		return odao.getOrderDetail(mahd);
	}	
	public OrderDetail getOrderDtbymacthd(Long macthd) throws Exception {
		return odao.getOrderDetailbymcthd(macthd);
	}
	public boolean createOrderDetail(OrderDetail od) throws Exception {
		return odao.createOrderDetail(od);
	}
	public boolean deleteOrderDetailbyMCTHD(Long mcthd) throws Exception {
		return odao.deleteOrderDetailbyMCTHD(mcthd);
	}	
	public boolean deleteOrderDetail(Long mo) throws Exception {
		return odao.deleteOrderDetail(mo);
	}
	public boolean updateStatus(Long id,String status)  throws Exception {
		return odao.updateStatus(id, status);
	}
	public boolean updateQuantity(Long id,Long quantity)  throws Exception {
		return odao.updateQuantity(id, quantity);
	}
}
