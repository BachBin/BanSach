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
	public ArrayList<Categorybean> getloai(){
		ArrayList<Categorybean> ds = new ArrayList<Categorybean>();
		sql = "select * from Category";
		try {
			Connection con = new ConnecDataBase().getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {				
				ds.add(new Categorybean(rs.getString(1),rs.getString(2)));
			}
			rs.close();
			st.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}
	public boolean createCate(Categorybean cate) {
		sql = "insert into Category(maloai,tenloai) values(?,?)";
		try {
			Connection con = new ConnecDataBase().getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, cate.getMaloai());
			ps.setString(2, cate.getTenloai());
					
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
