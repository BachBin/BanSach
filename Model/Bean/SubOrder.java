package Bean;

import java.sql.Timestamp;

public class SubOrder {
	private Long MaHoaDon;
	private String anh;
	private String tensach;
	private String tenloai;
	private String tacgia;
	private String hoten;
	private int SoLuongMua;
	private Long gia;
	private Timestamp NgayMua;
	private String diachi;
	private String sodt;
	private Long thanhtien;
	public SubOrder() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SubOrder(Long maHoaDon, String anh, String tensach, String tenloai, String tacgia, String hoten,
			int soLuongMua, Long gia, Timestamp ngayMua, String diachi, String sodt) {
		super();
		MaHoaDon = maHoaDon;
		this.anh = anh;
		this.tensach = tensach;
		this.tenloai = tenloai;
		this.tacgia = tacgia;
		this.hoten = hoten;
		SoLuongMua = soLuongMua;
		this.gia = gia;
		NgayMua = ngayMua;
		this.diachi = diachi;
		this.sodt = sodt;
		this.thanhtien = gia*soLuongMua;
	}
	public Long getMaHoaDon() {
		return MaHoaDon;
	}
	public void setMaHoaDon(Long maHoaDon) {
		MaHoaDon = maHoaDon;
	}
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
	public String getTensach() {
		return tensach;
	}
	public void setTensach(String tensach) {
		this.tensach = tensach;
	}
	public String getTenloai() {
		return tenloai;
	}
	public void setTenloai(String tenloai) {
		this.tenloai = tenloai;
	}
	public String getTacgia() {
		return tacgia;
	}
	public void setTacgia(String tacgia) {
		this.tacgia = tacgia;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public int getSoLuongMua() {
		return SoLuongMua;
	}
	public void setSoLuongMua(int soLuongMua) {
		SoLuongMua = soLuongMua;
	}
	public Long getGia() {
		return gia;
	}
	public void setGia(Long gia) {
		this.gia = gia;
	}
	public Timestamp getNgayMua() {
		return NgayMua;
	}
	public void setNgayMua(Timestamp ngayMua) {
		NgayMua = ngayMua;
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
	public Long getThanhtien() {
		return gia*SoLuongMua;
	}		
}
