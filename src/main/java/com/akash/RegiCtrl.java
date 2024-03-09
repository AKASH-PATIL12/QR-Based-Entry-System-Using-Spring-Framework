package com.akash;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegiCtrl {
	
	@RequestMapping("addUser")
	public ModelAndView addUserInfo(@RequestParam("name") String name,
			@RequestParam("phno") String phno,
			@RequestParam("email") String email,
			@RequestParam("pass") String pass) throws SQLException 
	{
			UserPojo up = new UserPojo(name,Integer.parseInt(phno),email,pass);
			RegiDao rd = new RegiDao();
			String str = rd.addUser(up);
			String str1 = rd.addLogin(up);
			if(str.equals("success") && str1.equals("success")) {
				return new ModelAndView("Login","msg",str+"Now login Please");
			}
			else {
				return new ModelAndView("Register","msg","car not inserted");
			}
			
	}
	
}

	

