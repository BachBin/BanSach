package Bean;

import java.sql.Timestamp;

public class SubOrder {
	private Long MaHoaDon;
	private Long TongTien;
	private Timestamp NgayMua;
	private String hoten;
	private String diachi;
	private String sodt;
	private boolean DaMua;
	public SubOrder() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SubOrder(Long maHoaDon, Long tongTien, Timestamp ngayMua, String hoten, String diachi, String sodt,
			boolean daMua) {
		super();
		MaHoaDon = maHoaDon;
		TongTien = tongTien;
		NgayMua = ngayMua;
		this.hoten = hoten;
		this.diachi = diachi;
		this.sodt = sodt;
		DaMua = daMua;
	}
	public Long getMaHoaDon() {
		return MaHoaDon;
	}
	public void setMaHoaDon(Long maHoaDon) {
		MaHoaDon = maHoaDon;
	}
	public Long getTongTien() {
		return TongTien;
	}
	public void setTongTien(Long tongTien) {
		TongTien = tongTien;
	}
	public Timestamp getNgayMua() {
		return NgayMua;
	}
	public void setNgayMua(Timestamp ngayMua) {
		NgayMua = ngayMua;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public String getSodt() {
		return sodt;
	}
	public void setSodt(String sodt) {
		this.sodt = sodt;
	}
	public boolean isDaMua() {
		return DaMua;
	}
	public void setDaMua(boolean daMua) {
		DaMua = daMua;
	}	
}
