<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Login</title>
<style type="text/css">

.login{
    margin: auto;
    width: 50%;
    border:2px solid black;
    border-radius: 25px;
    padding: 10px;
    background: linear-gradient(180deg, #fde1ff,#e1ffea22 60%);
    
}
.login input{
    border: none;
    background:rgba(233, 217, 217, 0.819) ;
    border-radius: 15px;
    padding: 3px;
}
.btn{
    border: solid 2px black;
}
    </style>
</head>
<body>

 	<div class="login">
 		<form action="login" method="post">
           <h3>Login -></h3> 
            <table>
                <tr>
                    <td>Phone no. :</td>
                    <td><input type="text" name="phno"></td>
                </tr>
                <tr>
                    <td>Password :</td>
                    <td><input type="text" name="pass"></td>
                </tr>
                <tr>
                    
                    <td ><input style="border:2px solid black;background: rgb(180, 201, 244);" type="Submit" value="Submit"></td>
                    <td><span>New User?</span><a href="Register.jsp">Click here</a> </td>
                </tr>
            </table>
        </form>
        <h3> ${msg} </h3>
 	</div>
          
</body>
</html>