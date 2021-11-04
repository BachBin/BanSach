package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import Bean.Order;
import Bean.OrderDetail;
import Connection.ConnecDataBase;

public class OrderDetaildao {
	String sql;	
	public ArrayList<OrderDetail> getOrderDetail(Long mahd) throws Exception { 
		ArrayList<OrderDetail> ds = new ArrayList<OrderDetail>();
		sql = "select * from OrderDetail where MaHoaDon = ?";		
			Connection con = new ConnecDataBase().getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, mahd);			
			ResultSet rs = ps.executeQuery(sql);
			while(rs.next()) {				
				Long maChiTietHD = rs.getLong(1);				
				Long maSach = rs.getLong(2);
				int soLuongMua = rs.getInt(3);
				Long maHoaDon = rs.getLong(4);
				boolean daMua = rs.getBoolean(5);				
				ds.add(new OrderDetail(maChiTietHD, maSach, soLuongMua, maHoaDon, daMua));
			}
			rs.close();
			ps.close();
			con.close();			
			return ds;
	}	
	public boolean createOrderDetail(OrderDetail od) throws Exception { 		
		sql = "insert into OrderDetail(MaSach,SoLuongMua,MaHoaDon,DaMua) values (?,?,?,?)";			
		Connection con = new ConnecDataBase().getConnection();
		PreparedStatement ps = con.prepareStatement(sql);	
		ps.setLong(1, od.getMaSach());	
		ps.setInt(2, od.getSoLuongMua());	
		ps.setLong(3, od.getMaHoaDon());	
		ps.setBoolean(4, od.isDaMua());				
		return ps.executeUpdate() > 0;				
			
	}
	
}
