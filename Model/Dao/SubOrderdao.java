package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import Bean.Order;
import Bean.SubOrder;
import Connection.ConnecDataBase;

public class SubOrderdao {
	String sql;
	public ArrayList<SubOrder> getSubOrder(Long makh) throws Exception {
		ArrayList<SubOrder> ds = new ArrayList<SubOrder>();
		sql = "select od.MaHoaDon,anh,tensach,tenloai,tacgia,hoten,dt.SoLuongMua,b.gia,od.NgayMua,cr.diachi,sodt from Category as ct JOIN Book as b on ct.maloai = b.maloai JOIN OrderDetail as dt on b.masach = dt.MaSach JOIN Orders as od on dt.MaHoaDon = od.MaHoaDon JOIN Customer as cr on od.makh = cr.makh where cr.makh = ?";
		Connection con = new ConnecDataBase().getConnection();
		PreparedStatement ps = con.prepareStatement(sql);	
		ps.setLong(1, makh);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {	
			Long mahd = rs.getLong(1);
			String anh = rs.getString(2);
			String tensach = rs.getString(3);
			String tenloai = rs.getString(4);
			String tacgia = rs.getString(5);
			String hoten = rs.getString(6);
			int soLuongMua = rs.getInt(7);
			Long gia = rs.getLong(8);
			Timestamp ngayMua = rs.getTimestamp(9);
			String diachi = rs.getString(10);
			String sodt = rs.getString(11);
			ds.add(new SubOrder(mahd,anh, tensach, tenloai, tacgia, hoten, soLuongMua, gia, ngayMua, diachi, sodt));
		}
		rs.close();			
		con.close();			
		return ds;		
	}
}
