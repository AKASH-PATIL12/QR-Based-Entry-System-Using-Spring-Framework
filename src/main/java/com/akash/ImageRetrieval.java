//package com.akash;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//
//public class ImageRetrieval {
//
//    public  byte[] getImageData() {
//        try {
//            	
//        	LoginPojo lp = new LoginPojo();
//            String sql = "SELECT image_data FROM user_images WHERE id = ?";
//            DBAdapter adapter = new DBAdapter();
//    		Connection con = adapter.getConnection();
//
//            try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
//            	
//            	int Id = userId(7498);
//            	System.out.println(Id);
//                preparedStatement.setInt(1, Id);
//                ResultSet resultSet = preparedStatement.executeQuery();
//                if (resultSet.next()) {
//                    return resultSet.getBytes("image_data");
//                }
//            }
//            con.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//    
//    public static int userId(int phno) {
//		int id = 0;
//		 String sql = "select id from user_images where phno=?";
//         DBAdapter adapter = new DBAdapter();
// 		Connection con = adapter.getConnection();
// 		
// 		try {
// 			PreparedStatement pst = con.prepareStatement(sql);
//			pst.setInt(1, phno);
//			ResultSet rs = pst.executeQuery();
//			while(rs.next()) {
//				id = rs.getInt("id");
//			}
//			
//			
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return id;
// 		
//	}
//
//    
//}
