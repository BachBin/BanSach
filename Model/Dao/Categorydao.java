package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Bean.Categorybean;
import Connection.ConnecDataBase;




public class Categorydao {
	String sql;	
	public ArrayList<Categorybean> getloai() throws Exception {
		ArrayList<Categorybean> ds = new ArrayList<Categorybean>();
		sql = "select * from Category";		
			Connection con = new ConnecDataBase().getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {				
				ds.add(new Categorybean(rs.getString(1),rs.getString(2)));
			}
			rs.close();
			st.close();		
		return ds;
	}
	public boolean createCate(Categorybean cate)  throws Exception {
		sql = "insert into Category(maloai,tenloai) values(?,?)";		
			Connection con = new ConnecDataBase().getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, cate.getMaloai());
			ps.setString(2, cate.getTenloai());				
			return ps.executeUpdate() > 0;				
	}
	public boolean updateCate(Categorybean cate)  throws Exception {
		sql = "update Category set tenloai = ? where maloai = ? ";		
		Connection con = new ConnecDataBase().getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, cate.getTenloai());
		ps.setString(2, cate.getMaloai());		
		return ps.executeUpdate() > 0;		
	}
	public boolean deleteCate(String ml)  throws Exception {
		sql = "delete from Category WHERE maloai = ?";		
		Connection con = new ConnecDataBase().getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, ml);		
		return ps.executeUpdate() > 0;		
	}
}
