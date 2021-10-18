package Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Bean.Bookbean;
import Bean.Cart;
import Connection.ConnecDataBase;



//Bookbean(String masach, String tensach, Long soluong, Long gia, String maloai, Long sotap, String anh, Date ngaynhap, String tacgia)
//					1				2			3				4			5			6			 7			  8				  9
public class Bookdao {
	String sql;	
	public ArrayList<Bookbean> getsach(){
		ArrayList<Bookbean> ds = new ArrayList<Bookbean>();
		sql = "select * from Book";
		try {
			Connection con = new ConnecDataBase().getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {				
				ds.add(new Bookbean(rs.getString(1),rs.getString(2),rs.getLong(3),rs.getLong(4),rs.getString(5),rs.getLong(6),rs.getString(7),rs.getDate(8),rs.getString(9)));
			}
			rs.close();
			st.close();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return ds;
	}	
	public Bookbean getNew() {
		sql = "select top 1 * from Book order by ngaynhap desc";
		try {
			Connection con = new ConnecDataBase().getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {				
				return new Bookbean(rs.getString(1),rs.getString(2),rs.getLong(3),rs.getLong(4),rs.getString(5),rs.getLong(6),rs.getString(7),rs.getDate(8),rs.getString(9));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public ArrayList<Bookbean> getsachPage(int index,int size){ 
		ArrayList<Bookbean> ds = new ArrayList<Bookbean>();
		sql = "select * from Book order by masach offset ? ROWS FETCH NEXT ? ROWS ONLY";
		try {
			Connection con = new ConnecDataBase().getConnection();			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, (index-1)*size);
			ps.setInt(2, size);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ds.add(new Bookbean(rs.getString(1),rs.getString(2),rs.getLong(3),rs.getLong(4),rs.getString(5),rs.getLong(6),rs.getString(7),rs.getDate(8),rs.getString(9)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}
	public int getTotalBook() {
		sql = "select COUNT(*) from Book";
		try {
			Connection con = new ConnecDataBase().getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {				
				return rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}	
	
}
