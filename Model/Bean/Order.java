package Bean;


import java.sql.Timestamp;



public class Order {
	private Long MaHoaDon;
	private Long makh;
	private Timestamp NgayMua;
	private boolean DaMua;
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(Long maHoaDon, Long makh, Timestamp ngayMua, boolean daMua) {
		super();
		this.MaHoaDon = maHoaDon;
		this.makh = makh;
		this.NgayMua = ngayMua;
		this.DaMua = daMua;
	}
	public Long getMaHoaDon() {
		return MaHoaDon;
	}
	public void setMaHoaDon(Long maHoaDon) {
		this.MaHoaDon = maHoaDon;
	}
	public Long getMakh() {
		return makh;
	}
	public void setMakh(Long makh) {
		this.makh = makh;
	}
	public Timestamp getNgayMua() {
		return NgayMua;
	}
	public void setNgayMua(Timestamp ngayMua) {
		this.NgayMua = ngayMua;
	}
	public boolean isDaMua() {
		return DaMua;
	}
	public void setDaMua(boolean daMua) {
		this.DaMua = daMua;
	}	
}
