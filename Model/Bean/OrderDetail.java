package Bean;

public class OrderDetail {
	private Long MaChiTietHD;
	private Long MaSach;
	private int SoLuongMua;
	private Long MaHoaDon;
	private boolean DaMua;
	public OrderDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderDetail(Long maChiTietHD, Long maSach, int soLuongMua, Long maHoaDon, boolean daMua) {
		super();
		this.MaChiTietHD = maChiTietHD;
		this.MaSach = maSach;
		this.SoLuongMua = soLuongMua;
		this.MaHoaDon = maHoaDon;
		this.DaMua = daMua;
	}
	public Long getMaChiTietHD() {
		return MaChiTietHD;
	}
	public void setMaChiTietHD(Long maChiTietHD) {
		this.MaChiTietHD = maChiTietHD;
	}
	public Long getMaSach() {
		return MaSach;
	}
	public void setMaSach(Long maSach) {
		this.MaSach = maSach;
	}
	public int getSoLuongMua() {
		return SoLuongMua;
	}
	public void setSoLuongMua(int soLuongMua) {
		this.SoLuongMua = soLuongMua;
	}
	public Long getMaHoaDon() {
		return MaHoaDon;
	}
	public void setMaHoaDon(Long maHoaDon) {
		this.MaHoaDon = maHoaDon;
	}
	public boolean isDaMua() {
		return DaMua;
	}
	public void setDaMua(boolean daMua) {
		this.DaMua = daMua;
	}	
}
