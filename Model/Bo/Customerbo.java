package Bo;

import java.util.ArrayList;

import Bean.Customerbean;
import Dao.Customerdao;

public class Customerbo {
	Customerdao khachdao = new Customerdao();
	public ArrayList<Customerbean> getkh(){
		return khachdao.getkhach();
	}
	public Customerbean checkLogin(String makh, String matkhau) {
		for(Customerbean e:getkh()) {
			if(e.getTendn().equals(makh) && e.getMatkhau().equals(matkhau))
				return e;
		}		
		return null;
	}
	public boolean createCustomer(Customerbean user) {
		if(khachdao.createCustomer(user))
			return true;
		return false;
	}
	public boolean updateCustomer(Customerbean user) {
		if(khachdao.updateCustomer(user))
			return true;
		return false;
	}
	public boolean checkExists(String tk) {
		for(Customerbean e:getkh()) {
			if(e.getTendn().equals(tk))
				return true;
		}
		return false;
	}
}
