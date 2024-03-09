package com.akash;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {
	
	
	
	public String validateUser(LoginPojo lp) throws SQLException {
		String sql = "select * from login where phno=? and pass=?";
		DBAdapter adapter = new DBAdapter();
		Connection con = adapter.getConnection();
		
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1,lp.getPhno());
		pst.setString(2,lp.getPass());
		
		ResultSet rs = pst.executeQuery();
		if (rs.next()) {
			
           return "success";
        } else {
            return "error";
        }
		
	} 
	
	
}
