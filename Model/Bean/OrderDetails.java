package Bean;

public class OrderDetails {
	private Long masach;
	private String tensach;
	private String tacgia;
	private String anh;
	private Long gia;
	private int slmua;
	private Long thanhtien;
	private boolean DaMua;
	

	public OrderDetails() {
		super();
		// TODO Auto-generated constructor stub
	}	

	public OrderDetails(Long masach, String tensach, String tacgia, String anh, Long gia, int slmua,boolean damua) {
		super();
		this.masach = masach;
		this.tensach = tensach;
		this.tacgia = tacgia;
		this.anh = anh;
		this.gia = gia;
		this.slmua = slmua;
		this.DaMua = damua;
		this.thanhtien = gia * slmua;		
	}

	public Long getMasach() {
		return masach;
	}

	public void setMasach(Long masach) {
		this.masach = masach;
	}

	public String getTensach() {
		return tensach;
	}

	public void setTensach(String tensach) {
		this.tensach = tensach;
	}

	public String getTacgia() {
		return tacgia;
	}

	public void setTacgia(String tacgia) {
		this.tacgia = tacgia;
	}

	public String getAnh() {
		return anh;
	}

	public void setAnh(String anh) {
		this.anh = anh;
	}

	public Long getGia() {
		return gia;
	}

	public void setGia(Long gia) {
		this.gia = gia;
	}

	public int getSlmua() {
		return slmua;
	}

	public void setSlmua(int slmua) {
		this.slmua = slmua;
	}

	public Long getThanhtien() {
		return gia * slmua;
	}
	
	public boolean isDaMua() {
		return DaMua;
	}

	public void setDaMua(boolean daMua) {
		DaMua = daMua;
	}
	
}
