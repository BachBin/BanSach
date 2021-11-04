package Bo;

import java.util.ArrayList;

import Bean.SubOrder;
import Dao.SubOrderdao;

public class SubOrderbo {
	SubOrderdao od = new SubOrderdao();
	public ArrayList<SubOrder> getOrders(Long makh) throws Exception {
		return od.getSubOrder(makh);
	}
}
