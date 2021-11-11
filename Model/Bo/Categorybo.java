package Bo;

import java.util.ArrayList;

import Bean.Categorybean;
import Dao.Categorydao;


public class Categorybo {
	
	Categorydao ldao = new Categorydao();
	public ArrayList<Categorybean> getloai() throws Exception {
		return ldao.getloai();
	}
	public String getTenLoai(String ml) throws Exception {
		for(Categorybean c:getloai()) {
			if(c.getMaloai().equals(ml))
				return c.getTenloai();
		}
		return null;
	}
	public ArrayList<Categorybean> Tim(String key) throws Exception {
		ArrayList<Categorybean> ds = getloai();
		ArrayList<Categorybean> tam = new ArrayList<Categorybean>();
		for(Categorybean s: ds)
			if(s.getTenloai().trim().toLowerCase().contains(key.trim().toLowerCase()))
				tam.add(s);
		   return tam;
	}
	public boolean createCate(Categorybean cate)  throws Exception {
		return ldao.createCate(cate);
	}
	public boolean updateCate(Categorybean cate)  throws Exception {
		return ldao.updateCate(cate);
	}
	public boolean deleteCate(String ml)  throws Exception {
		return ldao.deleteCate(ml);
	}
}
