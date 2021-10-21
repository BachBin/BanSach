package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Bean.Login;
import Connection.ConnecDataBase;

public class Logindao {
	String sql;	
	public ArrayList<Login> getLogin(){
		ArrayList<Login> ds = new ArrayList<Login>();
		sql = "select * from DangNhap";
		try {
			Connection con = new ConnecDataBase().getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {				
				ds.add(new Login(rs.getString(1), rs.getString(2), rs.getBoolean(3)));
			}
			rs.close();
			st.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}
	public boolean createLogin(Login user) {
		sql = "insert into DangNhap(TenDangNhap,MatKhau,Quyen) values(?,?,?)";
		try {
			Connection con = new ConnecDataBase().getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user.getTendn());
			ps.setString(2, user.getMatkhau());
			ps.setBoolean(3, user.isIsadmin());
			
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean updateLogin(Login user) {
		sql = "update DangNhap set MatKhau = ?, Quyen = ? where TenDangNhap = ?";
		try {
			Connection con = new ConnecDataBase().getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user.getTendn());
			ps.setString(2, user.getMatkhau());
			ps.setBoolean(3, user.isIsadmin());
			
			return ps.executeUpdate() > 0;			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
