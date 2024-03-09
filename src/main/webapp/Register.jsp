<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Register First</title>
<style type="text/css">
	
.register{
    margin: auto;
    width: 50%;
    border:2px solid black;
    border-radius: 25px;
    padding: 10px;
    background: linear-gradient(180deg, #fde1ff,#e1ffea22 60%);
}
.register input{
    border: none;
    background:rgba(233, 217, 217, 0.819) ;
    border-radius: 15px;
    padding: 3px;
}
.btn{
    border: solid  black;

}
</style>
  
</head>
<body>
    <div class="register">
        <form action="addUser">
            <h3>Register -></h3>
            <table>
                <tr>
                    <td>Name :</td>
                    <td><input type="text" name="name" required></td>
                </tr>
                <tr>
                    <td>Phone no. :</td>
                    <td><input type="text" name="phno" required></td>
                </tr>
                <tr>
                    <td>email :</td>
                    <td><input type="text" name="email" required></td>
                </tr>
                <tr>
                    <td>Password :</td>
                    <td><input type="text" name="pass" placeholder="example-  pass123" required></td>
                </tr>
                <tr>
                    
                    <td ><input style="border:2px solid black;background: rgb(180, 201, 244);" type="Submit" value="Submit"></td>
                    <td><span>Alredy Register?</span><a href="Login.jsp">Click here.</a></td>
                    
                </tr>
            </table>
        </form>
        

    </div>
</body>
</html>