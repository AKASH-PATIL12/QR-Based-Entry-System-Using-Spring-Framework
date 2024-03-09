package com.akash;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginCtrl {
	
	public LoginCtrl() {}
	
	@RequestMapping("login")
	public ModelAndView validateUser(@RequestParam("phno") String phno, @RequestParam("pass") String pass) throws SQLException {
			
			LoginPojo lp = new LoginPojo(Integer.parseInt(phno),pass);
			LoginDao ld = new LoginDao();
			
			String str = ld.validateUser(lp);
			if(str.equals("success")) {
				QrGen qr = new QrGen(lp);
				String res = String.valueOf(userId(phno));
				
	
				return new ModelAndView("Login-Home","msg",res); 
			}
			else
			{
				return new ModelAndView("Login","msg","Invalid Credential"); 
			}
			
	}
	
	//THIS METHOD HELP TO LOAD IMAGE FROM DATABASE
	public byte[] getImageData(int id) {
	        try {
	            String sql = "SELECT image_data FROM user_images WHERE id = ?";
	            DBAdapter adapter = new DBAdapter();
	    		Connection con = adapter.getConnection();

	            try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
	            	    			
	            	
	                preparedStatement.setInt(1, id);
	                ResultSet resultSet = preparedStatement.executeQuery();
	                if (resultSet.next()) {
	                    return resultSet.getBytes("image_data");
	                }
	            }
	            con.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return null;
	    }
	    
		//RETURN ID OF LOGINED USER FROM USER_IMAGES DB 
	    public int userId(String phno) {
			int id = 0;
			 String sql = "select id from user_images where phno=?";
	         DBAdapter adapter = new DBAdapter();
	 		Connection con = adapter.getConnection();
	 		
	 		try {
	 			PreparedStatement pst = con.prepareStatement(sql);
	 			int pno = Integer.parseInt(phno);
				pst.setInt(1, pno);
				ResultSet rs = pst.executeQuery();
				while(rs.next()) {
					id = rs.getInt("id");
				}	
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return id;
	 		
		}
	
					
	
}
