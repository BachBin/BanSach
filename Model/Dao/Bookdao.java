package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


import Bean.Bookbean;
import Connection.ConnecDataBase;



public class Bookdao {
	String sql;	
	public ArrayList<Bookbean> getsach() throws Exception { 
		ArrayList<Bookbean> ds = new ArrayList<Bookbean>();
		sql = "select * from Book";		
			Connection con = new ConnecDataBase().getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {				
				ds.add(new Bookbean(rs.getLong(1),rs.getString(2),rs.getLong(3),rs.getLong(4),rs.getString(5),rs.getLong(6),rs.getString(7),rs.getTimestamp(8),rs.getString(9)));
			}
			rs.close();
			st.close();
			con.close();			
			return ds;
	}	
	public Bookbean getNew() throws Exception{
		sql = "select top 1 * from Book order by ngaynhap desc";		
			Connection con = new ConnecDataBase().getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {				
				return new Bookbean(rs.getLong(1),rs.getString(2),rs.getLong(3),rs.getLong(4),rs.getString(5),rs.getLong(6),rs.getString(7),rs.getTimestamp(8),rs.getString(9));
			}
			rs.close();
			st.close();
			con.close();		
		return null;
	}
	public ArrayList<Bookbean> getsachPage(int index,int size) throws Exception { 
		ArrayList<Bookbean> ds = new ArrayList<Bookbean>();
		sql = "select * from Book order by masach offset ? ROWS FETCH NEXT ? ROWS ONLY";		
			Connection con = new ConnecDataBase().getConnection();			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, (index-1)*size);
			ps.setInt(2, size);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ds.add(new Bookbean(rs.getLong(1),rs.getString(2),rs.getLong(3),rs.getLong(4),rs.getString(5),rs.getLong(6),rs.getString(7),rs.getTimestamp(8),rs.getString(9)));
			}
			rs.close();			
			con.close();		
		return ds;
	}
	public int getTotalBook() throws Exception {
		sql = "select COUNT(*) from Book";		
			Connection con = new ConnecDataBase().getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {				
				return rs.getInt(1);
			}
			rs.close();
			st.close();
			con.close();		
		return 0;
	}
	public boolean createBook(Bookbean book)  throws Exception {
		sql = "insert into Book(tensach,soluong,gia,maloai,sotap,anh,ngaynhap,tacgia) values(?,?,?,?,?,?,?,?)";		
			Connection con = new ConnecDataBase().getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, book.getTensach());
			ps.setLong(2, book.getSoluong());		
			ps.setLong(3, book.getGia());		
			ps.setString(4, book.getMaloai());		
			ps.setLong(5, book.getSotap());		
			ps.setString(6, book.getAnh());		
			ps.setTimestamp(7, book.getNgaynhap());		
			ps.setString(8, book.getTacgia());		
			
			return ps.executeUpdate() > 0;				
	}
	public boolean updateBook(Bookbean book)  throws Exception {
		sql = "update Book set tensach = ? , soluong = ?, gia = ?, maloai = ?, sotap = ?, anh = ?, ngaynhap = ?, tacgia = ? where masach = ?";		
		Connection con = new ConnecDataBase().getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, book.getTensach());
		ps.setLong(2, book.getSoluong());
		ps.setLong(3, book.getGia());
		ps.setString(4, book.getMaloai());
		ps.setLong(5, book.getSotap());
		ps.setString(6, book.getAnh());
		ps.setTimestamp(7, book.getNgaynhap());
		ps.setString(8, book.getTacgia());
		ps.setLong(9, book.getMasach());
		
		return ps.executeUpdate() > 0;		
	}
	public boolean deleteBook(Long ms)  throws Exception {
		sql = "delete from Book WHERE masach = ?";		
		Connection con = new ConnecDataBase().getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setLong(1, ms);		
		return ps.executeUpdate() > 0;		
	}
	
}
