package Bo;

import java.util.ArrayList;

import Bean.Order;
import Dao.Orderdao;

public class Orderbo {
	Orderdao odao = new Orderdao();
	public ArrayList<Order> getAllOrder() throws Exception {
		return odao.getAllOrder();
	}
	public ArrayList<Order> getOrder(Long makh) throws Exception {
		return odao.getOrder(makh);
	}
	public Long createOrder(Order od,String hoten,String diachi,String sdt) throws Exception {
		return odao.createOrder(od, hoten, diachi, sdt);
	}
	public boolean deleteOrder(Long mo) throws Exception {
		return odao.deleteOrder(mo);
	}
	public boolean updateStatus(Long id,String status)  throws Exception {
		return odao.updateStatus(id, status);
	}	
}
