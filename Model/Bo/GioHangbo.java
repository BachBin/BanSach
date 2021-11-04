package Bo;

import java.util.ArrayList;

import Bean.GioHangbean;

public class GioHangbo {
	public ArrayList<GioHangbean> ds = new ArrayList<GioHangbean>();
	public 	void Them(Long masach, String tensach, String tacgia, String anh, Long gia, int sl) {
		for(GioHangbean g:ds)
			if(g.getMasach()==masach) {
				g.setSlmua(g.getSlmua()+sl);				
				return;
			}
		ds.add(new GioHangbean(masach, tensach, tacgia, anh, gia, sl));
	}	
	public void Xoa(String masach) {
		for(GioHangbean g: ds)
			if(g.getMasach().equals(masach)) {
				ds.remove(g);
				break;
			}
		
	}
	public long Size() {		
		return ds.size();
	}
	public long Tongtien(){
		long tongtien=0;
		for(GioHangbean o:ds) {
			tongtien+=o.getThanhtien();
		}
		return tongtien;
	}
}
