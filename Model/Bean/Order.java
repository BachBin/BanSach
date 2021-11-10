package Bean;


import java.sql.Timestamp;



public class Order {
	private Long MaHoaDon;
	private Long makh;
	private Timestamp NgayMua;	
	private String hoten;
	private String diachi;
	private String sdt;
	private boolean DaMua;
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(Long maHoaDon, Long makh, Timestamp ngayMua, String hoten, String diachi, String sdt, boolean daMua) {
		super();
		MaHoaDon = maHoaDon;
		this.makh = makh;
		NgayMua = ngayMua;
		this.hoten = hoten;
		this.diachi = diachi;
		this.sdt = sdt;
		DaMua = daMua;
	}
	public Long getMaHoaDon() {
		return MaHoaDon;
	}
	public void setMaHoaDon(Long maHoaDon) {
		MaHoaDon = maHoaDon;
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
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public boolean isDaMua() {
		return DaMua;
	}
	public void setDaMua(boolean daMua) {
		DaMua = daMua;
	}
	
}
