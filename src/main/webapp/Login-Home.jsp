<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	import="com.akash.*"
	import="java.util.Base64"
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login-Home  </title>
<style type="text/css">
body{
background: linear-gradient(180deg, #fde1ff,#e1ffea22 60%);
 background-repeat: no-repeat;
}
.loginhome{
	 margin: auto;
    width: 50%;
    
}
</style>
</head>
<body>
<div class="loginhome">
		<h2>Login Home ${msg}</h2>
	
	
<% 

		int userId;
		userId = Integer.parseInt((String) request.getAttribute("msg"));
		LoginCtrl lc = new  LoginCtrl();
        byte[] imageData = lc.getImageData(userId);

        if (imageData != null && imageData.length > 0) {
            String base64Image = Base64.getEncoder().encodeToString(imageData);
    %>
            <img src="data:image/png;base64, <%= base64Image %>" alt="User Image">
    <%
        } else {
    %>
            <p>No image found for the user.</p>
    <%
        }
    %>
	
</div>
  
	
	
	
</body>
</html>
