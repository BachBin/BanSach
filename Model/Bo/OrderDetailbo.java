package Bo;

import java.util.ArrayList;

import Bean.OrderDetail;
import Dao.OrderDetaildao;


public class OrderDetailbo {
	OrderDetaildao odao = new OrderDetaildao();
	public ArrayList<OrderDetail> getOrderDt(Long mahd) throws Exception {
		return odao.getOrderDetail(mahd);
	}
	public boolean createOrderDetail(OrderDetail od) throws Exception {
		return odao.createOrderDetail(od);
	}
}
