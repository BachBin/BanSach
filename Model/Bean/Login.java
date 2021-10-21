package Bean;

public class Login {
	String tendn;
	String matkhau;
	boolean isadmin;
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Login(String tendn, String matkhau, boolean isadmin) {
		super();
		this.tendn = tendn;
		this.matkhau = matkhau;
		this.isadmin = isadmin;
	}
	public String getTendn() {
		return tendn;
	}
	public void setTendn(String tendn) {
		this.tendn = tendn;
	}
	public String getMatkhau() {
		return matkhau;
	}
	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}
	public boolean isIsadmin() {
		return isadmin;
	}
	public void setIsadmin(boolean isadmin) {
		this.isadmin = isadmin;
	}	
}
