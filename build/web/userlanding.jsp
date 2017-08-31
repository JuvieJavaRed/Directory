7\<%-- 
    Document   : testland
    Created on : Oct 26, 2015, 2:22:21 PM
    Author     : avlab6
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
     <head>
         <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="css/custom2.css">
        <link rel="stylesheet" type="text/css" href="css/dashboard.css">
         <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script language="javascript" type="text/javascript"></script>
        <script>
        function showHint(str){
          var xhttp;
          if (str.length === 0){ 
            document.getElementById("txtHint").innerHTML = "";
            return;
          }
          xhttp = new XMLHttpRequest();
          xhttp.onreadystatechange = function() {
            if (xhttp.readyState === 4 && xhttp.status === 200) {
              document.getElementById("txtHint").innerHTML = xhttp.responseText;
            }
          };
          xhttp.open("GET", "names.asp?q="+str, true);
          xhttp.send();
        }
        </script>
        <title>NUST INTERNAL DIRECTORY</title>
    </head>

    
    <body>

    <nav class="navbar navbar-inverse navbar-fixed-top"  >
      <div class="container-fluid1" >
        <div class="navbar-header" >
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">NUST INTERNAL DIRECTORY</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse" height="100px">
           
          <ul class="nav navbar-nav navbar-right">
            <li><a href="#">Map</a></li>
            <li><a href="adminlogin.jsp">Logout</a></li>
          </ul>
        </div>
      </div>
        
    </nav>

        <br><div class="container">
      <div class="row">
           
               
        
            <div class="col-md-8">
                <div id="searchbox">
                    
            <ul class="nav navbar-nav"> 
                    <li><a href="#">Name</a></li>
                    <li><a href="#">Surname</a></li>
                    <li><a href="#">Department</a></li>
                    <li><a href="#">Faculty</a></li>  
            </ul>
            
                    <form class="form-group2">
                            <label for="Search"></label>
                            <input type="text" class="form-control" id="search" onkeyup="showHint(this.value)">

                            <a href="#" class="btn btn-info btn-lg">
                                <span class="glyphicon glyphicon-search">Search
                            </a>
                             <p>  <span id="txtHint"></span></p>
                    </form> 
                   
                </div>
             </div>
          
       
      </div>
    </div>
        <div class="navbar-fixed-bottom"
        <footer>
            <p>Copyright:2015 All Rights Reserved|Designed by NUST ICTS</p>
        </footer>
        </div>
    </body>
</html>
        
