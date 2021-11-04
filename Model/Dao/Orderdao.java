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
			ResultSet rs = ps.executeQuery(sql);
			while(rs.next()) {				
				Long maHoaDon = rs.getLong(1);
				Long makh = rs.getLong(2);
				Timestamp ngayMua = rs.getTimestamp(3);
				boolean daMua = rs.getBoolean(3);
				ds.add(new Order(maHoaDon, makh, ngayMua, daMua));
			}
			rs.close();			
			con.close();			
			return ds;
	}	
	public Long createOrder(Order od) throws Exception { 		
		sql = "insert into Orders(makh, NgayMua, DaMua) values(?,?,?)";	
		
			Connection con = new ConnecDataBase().getConnection();
			PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			ps.setLong(1, od.getMakh());	
			ps.setTimestamp(2, od.getNgayMua());	
			ps.setBoolean(3, od.isDaMua());	
			int affectedRows = ps.executeUpdate();
			if (affectedRows == 0) {
				con.close();
            	ps.close();
	           return (long)-1;
	        }
			try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
	            if (generatedKeys.next()) {	            	
	            	return generatedKeys.getLong(1);	                
	            }
	            else {
	            	con.close();
	            	ps.close();
	                return (long)-2;
	            }
	        }
	}
	
}
