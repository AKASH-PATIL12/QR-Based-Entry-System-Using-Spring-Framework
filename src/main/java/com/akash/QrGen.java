package com.akash;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.web.servlet.ModelAndView;

import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

public class QrGen {
	public QrGen() {}
	
//	GENERATE QR CODE
	public QrGen(LoginPojo lp) {
		try {
			
			int phno = lp.getPhno();
			String pass = lp.getPass();
			File file = new File("E:\\Program Files\\Spring\\CowShed\\src\\main\\webapp\\WEB-INF\\QR-imgs\\"+phno+"-"+pass+".PNG");
			String content = phno+"-"+pass;
			
			ByteArrayOutputStream out = QRCode.from(content).to(ImageType.PNG).stream();
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(out.toByteArray());
			fos.close();
			
			String userCheck = chekUser(phno);		//cheak whether user is alredy exist in user_images database
			
			if(userCheck.equals("have")) {
				//Save to database 
//				System.out.println("Fetched from db");
			}else {
				saveToDatabase(phno,pass,file);	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//SAVE IMAGE TO DATABASE
	private void saveToDatabase(int phno, String pass, File file) {
        try {
      
            String sql = "INSERT INTO user_images (phno, pass, image_data) VALUES (?, ?, ?)";
            DBAdapter adapter = new DBAdapter();
    		Connection con = adapter.getConnection();

            try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
                preparedStatement.setInt(1, phno);
                preparedStatement.setString(2, pass);

                // Read image file into a byte array
                FileInputStream fis = new FileInputStream(file);
                byte[] imageData = new byte[(int) file.length()];
                fis.read(imageData);
                fis.close();

                // Set the image data parameter
                preparedStatement.setBytes(3, imageData);
                // Execute the insert statement
                preparedStatement.executeUpdate();
            }

            // Close the database connection
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	
	//CHEACK USER'S QR CODE IS ALREADY GENERATED 
	private String chekUser(int phno) {
		 String sql = "select * from user_images where phno=?";
         DBAdapter adapter = new DBAdapter();
 		Connection con = adapter.getConnection();
 		String res = null;
 		try {
 			PreparedStatement pst = con.prepareStatement(sql);
 			pst.setInt(1, phno);
 			ResultSet rs = pst.executeQuery();
 			if (rs.next()) {
 	           res = "have";
 	        } else {
 	            res =  "havenot";
 	        }

 			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	
	
	
}
