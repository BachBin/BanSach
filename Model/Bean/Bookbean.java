package Bean;

import java.sql.Date;

import javax.print.attribute.standard.DateTimeAtCompleted;

public class Bookbean {	
	private String masach;
	private String tensach;
	private Long soluong;
	private Long gia;
	private String maloai;
	private Long sotap;
	private String anh;
	private Date ngaynhap;
	private String tacgia;
	public Bookbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Bookbean(String masach, String tensach, Long soluong, Long gia, String maloai, Long sotap, String anh,
			Date ngaynhap, String tacgia) {
		super();
		this.masach = masach;
		this.tensach = tensach;
		this.soluong = soluong;
		this.gia = gia;
		this.maloai = maloai;
		this.sotap = sotap;
		this.anh = anh;
		this.ngaynhap = ngaynhap;
		this.tacgia = tacgia;
	}
	public String getMasach() {
		return masach;
	}
	public void setMasach(String masach) {
		this.masach = masach;
	}
	public String getTensach() {
		return tensach;
	}
	public void setTensach(String tensach) {
		this.tensach = tensach;
	}
	public Long getSoluong() {
		return soluong;
	}
	public void setSoluong(Long soluong) {
		this.soluong = soluong;
	}
	public Long getGia() {
		return gia;
	}
	public void setGia(Long gia) {
		this.gia = gia;
	}
	public String getMaloai() {
		return maloai;
	}
	public void setMaloai(String maloai) {
		this.maloai = maloai;
	}
	public Long getSotap() {
		return sotap;
	}
	public void setSotap(Long sotap) {
		this.sotap = sotap;
	}
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
	public Date getNgaynhap() {
		return ngaynhap;
	}
	public void setNgaynhap(Date ngaynhap) {
		this.ngaynhap = ngaynhap;
	}
	public String getTacgia() {
		return tacgia;
	}
	public void setTacgia(String tacgia) {
		this.tacgia = tacgia;
	}	
	
}
