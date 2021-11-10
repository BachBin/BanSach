package Bo;

import java.util.ArrayList;

import Bean.Order;
import Dao.Orderdao;

public class Orderbo {
	Orderdao odao = new Orderdao();
	public ArrayList<Order> getOrder(Long makh) throws Exception {
		return odao.getOrder(makh);
	}
	public Long createOrder(Order od,String hoten,String diachi,String sdt) throws Exception {
		return odao.createOrder(od, hoten, diachi, sdt);
	}
}
