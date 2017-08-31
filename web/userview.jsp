<%-- 
    Document   : userview
    Created on : Oct 20, 2015, 12:05:27 PM
    Author     : avlab6
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
     <head>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="css/crudentities.css">
        <link rel="stylesheet" type="text/css" href="css/custom2.css">
        <link rel="stylesheet" type="text/css" href="css/dashboard.css">
        <title>Directory Land</title>
    </head>

    
    <body>
<%---------------------NAV BAR AT THE TOP----------------------%>
    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">NUST INTERNAL DIRECTORY</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="#"><span class="glyphicon glyphicon-user"></span> Admin</a></li>
            <li><a href="adminlogin.jsp">Logout</a></li>
          </ul>
        </div>
      </div>
    </nav>
<%----------------------------SIDE BAR-------------------------------------%>
    <div class="container">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
            <li><a href="${pageContext.request.contextPath}/DisplayEmployeeController" class="active">Home</a></li>
            <li><a href="${pageContext.request.contextPath}/DisplayUserController" class="active">User</a></li>
            <li><a href="${pageContext.request.contextPath}/DisplayEmployeeController" class="active">Employee</a></li>
            <li><a href="${pageContext.request.contextPath}/DisplayFacultyController" class="active">Faculty</a></li>
            <li><a href="${pageContext.request.contextPath}/DisplayDepartmentController" class="active">Department</a></li>
            <li><a href="${pageContext.request.contextPath}/DisplayBuildingController" class="active">Building</a></li>
            <li><a href="#" class="active">Settings</a></li>
          </ul>
        </div>
        <%------------------------------BODY WHERE TABLE IS------------------------------%>          
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <div class="row">
            <div class="col-md-12">
                <div id="searchbox">
                    <form class="form-group1">
                        <table class="table table-striped">
                            <tbody>
                                <tr>   
                                    <th>Name</th>
                                    <th><label for="name"></label></th>
                                    <td><input type="text" class="form-control" id="nameb"></td>
                                </tr>
                                <tr>
                                    <th>Surname</th>
                                    <th><label for="surname"></label></th>
                                    <td><input type="text" class="form-control" id="building_Idb"></td>
                                </tr>
                                <tr>
                                    <th>Job Title</th>
                                    <th><label for="job title"></label></th>
                                    <td><input type="text" class="form-control" id="number_officesb"></td>
                                </tr>
                                <tr>
                                    <th>User ID</th>
                                    <th><label for="user ID"></label></th>
                                    <td><input type="text" class="form-control" id="number_floorsb"></td>
                                </tr>
                                <tr>
                                    <th>Password</th>
                                    <th><label for="password"></label></th>
                                    <td><input type="text" class="form-control" id="number_floorsb"></td>
                                </tr>
                            <th><a href="#" class="btn btn-info btn-lg2"><span class="glyphicon glyphicon-upload">Update</a></th>
                            </tbody>
                        </table>
                    </form>    
                </div>
            </div>
          </div>
        </div>
      </div>
    </div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="../../dist/js/bootstrap.min.js"></script>
    <!-- Just to make our placeholder images work. Don't actually copy the next line! -->
    <script src="../../assets/js/vendor/holder.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
    
    
  </body>

</html>
