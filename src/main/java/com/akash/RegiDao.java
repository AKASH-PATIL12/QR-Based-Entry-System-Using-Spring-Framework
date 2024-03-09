package com.akash;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegiDao {
	
	public String addLogin(UserPojo up) throws SQLException {
		String sql = "insert into login values(?,?)";
		DBAdapter adapter = new DBAdapter();
		Connection con = adapter.getConnection();
		
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, up.getPhno());
		pst.setString(2, up.getPass());
		
		int i1 = pst.executeUpdate();
		if(i1>0) {
			return "success";
		}
		else {
			return "error";
		}
	
		
	}
	
	public String addUser(UserPojo cp) throws SQLException {
		String sql = "insert into register(name,phno,email,pass) values(?,?,?,?)";
		DBAdapter adapter = new DBAdapter();
		Connection con = adapter.getConnection();
		

		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, cp.getName());
		pst.setInt(2, cp.getPhno());
		pst.setString(3, cp.getEmail());
		pst.setString(4, cp.getPass());
		
		int i = pst.executeUpdate();
		if(i>0) {
			return "success";
		}
		else
		{
			return "error";
		}
	}
}
