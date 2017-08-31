<%-- 
    Document   : adminlogin
    Created on : Oct 14, 2015, 11:19:02 AM
    Author     : mzingayendhlovu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="nust.directory.controller.LoginController"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="css/custom.css">

        <title>NUST Internal Directory</title>
        
              
    </head>
    <body>
        <div class="container">
	  	
             <form class="form-login"  action="LoginController" method="post">
		<h2 class="form-login-heading">NUST ADMINISTRATOR INTERNAL DIRECTORY </h2>
		 <div class="login-wrap">
		            <input class="form-control" placeholder="Username" name="user_name" autofocus="" type="text">
		            <br>
		            <input class="form-control" placeholder="Password" name="password" type="password">
                            <br>
		            <button  class="form-control-2" type="submit"> <font color="white">Login</font> </button>
		            <hr>
		            
		 </div>
             </form>	
		          
		          
        </div>
		          
     </body>
</html>
