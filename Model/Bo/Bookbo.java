package Bo;

import java.util.ArrayList;

import Bean.Bookbean;
import Dao.Bookdao;



public class Bookbo {
	Bookdao sdao = new Bookdao();
	public ArrayList<Bookbean> getsach() throws Exception {
		return sdao.getsach();
	}
	public Long getPrice(Long masach) throws Exception {
		for(Bookbean s:getsach()) {
			if(s.getMasach() == masach) 
				return s.getGia();
		}
		return null;
	}
	public ArrayList<Bookbean> getByPage(int page,int sobai) throws Exception {		
		return sdao.getsachPage(page,sobai);
	}
	public ArrayList<Bookbean> TimLoai(String maloai) throws Exception {
		ArrayList<Bookbean> ds = getsach();
		ArrayList<Bookbean> tam= new ArrayList<Bookbean>();
		for(Bookbean s: ds)
			if(s.getMaloai().equals(maloai))
				tam.add(s);
			return tam;
	}
	public ArrayList<Bookbean> Tim(String key) throws Exception {
		ArrayList<Bookbean> ds = getsach();
		ArrayList<Bookbean> tam = new ArrayList<Bookbean>();
		for(Bookbean s: ds)
			if(s.getTensach().trim().toLowerCase().contains(key.trim().toLowerCase())||s.getTacgia().trim().toLowerCase().contains(key.trim().toLowerCase()))
				tam.add(s);
		   return tam;
	}
	public Bookbean getBookbyMaSach(Long masach) throws Exception {
		for(Bookbean e:getsach()) {
			if(e.getMasach()==masach)
				return e;
		}
		return null;
	}	
	public Bookbean sachNew() throws Exception {
		return sdao.getNew();
	}	
	public int getTotal() throws Exception {
		return sdao.getTotalBook();
	}
}
