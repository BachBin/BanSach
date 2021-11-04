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
				ds.add(new Bookbean(rs.getLong(1),rs.getString(2),rs.getLong(3),rs.getLong(4),rs.getString(5),rs.getLong(6),rs.getString(7),rs.getDate(8),rs.getString(9)));
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
				return new Bookbean(rs.getLong(1),rs.getString(2),rs.getLong(3),rs.getLong(4),rs.getString(5),rs.getLong(6),rs.getString(7),rs.getDate(8),rs.getString(9));
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
				ds.add(new Bookbean(rs.getLong(1),rs.getString(2),rs.getLong(3),rs.getLong(4),rs.getString(5),rs.getLong(6),rs.getString(7),rs.getDate(8),rs.getString(9)));
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
	
}
