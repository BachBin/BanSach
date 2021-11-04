package Bo;

import java.util.ArrayList;

import Bean.Customerbean;
import Dao.Customerdao;

public class Customerbo {
	Customerdao khachdao = new Customerdao();
	public ArrayList<Customerbean> getkh() throws Exception {
		return khachdao.getkhach();
	}
	public Customerbean checkLogin(String makh, String matkhau) throws Exception {
		for(Customerbean e:getkh()) {
			if(e.getTendn().equals(makh) && e.getMatkhau().equals(matkhau))
				return e;
		}		
		return null;
	}
	public boolean createCustomer(Customerbean user) throws Exception {
		if(khachdao.createCustomer(user))
			return true;
		return false;
	}
	public boolean updateCustomer(Customerbean user) throws Exception {
		if(khachdao.updateCustomer(user))
			return true;
		return false;
	}
	public boolean checkExists(String tk) throws Exception {
		for(Customerbean e:getkh()) {
			if(e.getTendn().equals(tk))
				return true;
		}
		return false;
	}
}
