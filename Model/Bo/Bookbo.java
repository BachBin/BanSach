package Bo;

import java.util.ArrayList;
import java.util.List;

import Bean.Bookbean;
import Bean.Cart;
import Dao.Bookdao;



public class Bookbo {
	Bookdao sdao = new Bookdao();
	public ArrayList<Bookbean> getsach(){
		return sdao.getsach();
	}
	public ArrayList<Bookbean> getByPage(int page,int sobai){		
		return sdao.getsachPage(page,sobai);
	}
	public ArrayList<Bookbean> TimLoai(String maloai) {
		ArrayList<Bookbean> ds = getsach();
		ArrayList<Bookbean> tam= new ArrayList<Bookbean>();
		for(Bookbean s: ds)
			if(s.getMaloai().equals(maloai))
				tam.add(s);
			return tam;
	}
	public ArrayList<Bookbean> Tim(String key) {
		ArrayList<Bookbean> ds = getsach();
		ArrayList<Bookbean> tam = new ArrayList<Bookbean>();
		for(Bookbean s: ds)
			if(s.getTensach().trim().toLowerCase().contains(key.trim().toLowerCase())||s.getTacgia().trim().toLowerCase().contains(key.trim().toLowerCase()))
				tam.add(s);
		   return tam;
	}
	public Bookbean getBookbyMaSach(String masach) {
		for(Bookbean e:getsach()) {
			if(e.getMasach().equals(masach))
				return e;
		}
		return null;
	}	
	public Bookbean sachNew() {
		return sdao.getNew();
	}	
	public int getTotal() {
		return sdao.getTotalBook();
	}
}
