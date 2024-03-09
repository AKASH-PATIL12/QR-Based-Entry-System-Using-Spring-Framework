package com.akash;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test {

	
	public int userId(int phno) {
		int id = 0;
		 String sql = "select id,phno from user_images where phno=?";
         DBAdapter adapter = new DBAdapter();
 		Connection con = adapter.getConnection();
 		
 		try {
 			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, phno);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				id = rs.getInt("id");
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
 		
	}
	
	public static void main(String[] args) {
		Test t =new Test();
		LoginPojo lp = new LoginPojo();
		System.out.println(lp.getPhno());
		System.out.println( t.userId(lp.getPhno()));
//		System.out.println( t.userId(7498));
	}
}
