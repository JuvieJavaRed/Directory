<%-- 
    Document   : theland
    Created on : Oct 2, 2015, 8:27:23 PM
    Author     : mzingayendhlovu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<html>
    <head>
        
         
        
        
        
  
        
        
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="css/custom2.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
        
        

        <title>Directory Land</title>
        
    
   
    
    
    <script type="text/javascript">
	function buttonSwap(image){
		var sb = document.getElementById('submit');
		sb.src = "images/"+image;
	}
</script>
       <link rel="icon" href="images/favicon.png" sizes="16x16" type="image/png">       
       
</head>
<body>
    
    
    
    <nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">NUST INTERNAL DIRECTORY</a>
    </div>
    <div>
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">Name</a></li>
        <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Lecturers <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">first page</a></li>
            <li><a href="#">second page</a></li>
            <li><a href="#">third page</a></li>
          </ul>
        </li>
        <li><a href="#">Non Accademic</a></li>
        <li><a href="#">Map</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#"><span class="glyphicon glyphicon-user"></span> Mzingaye</a></li>
        <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
      </ul>
    </div>
  </div>
</nav>
  
<div class="container">
  

  <div class="row">
    
    
</div>


    
    
	<form id="searchbox" action="">
           <input id="submit2" type="image" src="images/logo2.png"> 
        <input id="search" type="text" placeholder="Search">
        <input id="submit" type="image" src="images/search4.png" onmouseover="buttonSwap('search3.png')" onmouseout="buttonSwap('search4.png')">
        
	</form>
</body>
</html>
    
    
</html>
