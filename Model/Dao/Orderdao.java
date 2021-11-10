package Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;


import Bean.Order;
import Connection.ConnecDataBase;

public class Orderdao {
	String sql;	
	public ArrayList<Order> getOrder(Long MaKH) throws Exception { 
		ArrayList<Order> ds = new ArrayList<Order>();
		sql = "select * from Orders where makh = ?";		
			Connection con = new ConnecDataBase().getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, MaKH);			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {				
				Long maHoaDon = rs.getLong(1);
				Long makh = rs.getLong(2);
				Timestamp ngayMua = rs.getTimestamp(3);
				String hoten = rs.getString(4);
				String diachi = rs.getString(5);
				String sdt = rs.getString(6);
				boolean daMua = rs.getBoolean(7);
				ds.add(new Order(maHoaDon, makh, ngayMua, hoten, diachi, sdt, daMua));
			}					
			con.close();			
			return ds;
	}	
	public Long createOrder(Order od,String hoten,String diachi,String sdt) throws Exception { 		
		sql = "insert into Orders(makh, NgayMua, HoTen, DiaChi, SDT,DaMua) values(?,?,?,?,?,?)";	
		
			Connection con = new ConnecDataBase().getConnection();
			PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			ps.setLong(1, od.getMakh());	
			ps.setTimestamp(2, od.getNgayMua());	
			ps.setString(3, hoten);
			ps.setString(4, diachi);
			ps.setString(5, sdt);
			ps.setBoolean(6, od.isDaMua());	
			int affectedRows = ps.executeUpdate();
			if (affectedRows == 0) {				 	
	           return (long)-1;
	        }
			try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
	            if (generatedKeys.next()) {	            	
	            	return generatedKeys.getLong(1);	                
	            }
	            else {	            	
	                return (long)-2;
	            }
	        }
	}
	
}
