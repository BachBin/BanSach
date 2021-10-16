package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Bean.Customerbean;
import Connection.ConnecDataBase;


public class Customerdao {
	String sql;	
	public ArrayList<Customerbean> getkhach(){
		ArrayList<Customerbean> ds = new ArrayList<Customerbean>();
		sql = "select * from Customer";
		try {
			Connection con = new ConnecDataBase().getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {				
				ds.add(new Customerbean(rs.getLong(1),rs.getString(2),rs.getString(3),rs.getString(4), rs.getString(5),rs.getString(6), rs.getString(7)));
			}
			rs.close();
			st.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}
	public boolean createCustomer(Customerbean user) {
		sql = "insert into Customer(hoten,diachi,sodt,email,tendn,pass) values(?,?,?,?,?,?)";
		try {
			Connection con = new ConnecDataBase().getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user.getHoten());
			ps.setString(2, user.getDiachi());
			ps.setString(3, user.getSdt());
			ps.setString(4, user.getEmail());	
			ps.setString(5, user.getTendn());	
			ps.setString(6, user.getMatkhau());	
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean updateCustomer(Customerbean user) {
		sql = "update Customer SET hoten = ?, diachi = ?, sodt = ?, email = ?, tendn = ?, pass = ? where makh = ?";
		try {
			Connection con = new ConnecDataBase().getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user.getHoten());
			ps.setString(2, user.getDiachi());
			ps.setString(3, user.getSdt());
			ps.setString(4, user.getEmail());	
			ps.setString(5, user.getTendn());	
			ps.setString(6, user.getMatkhau());
			ps.setLong(7, user.getId());
			return ps.executeUpdate() > 0;			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
