<%-- 
    Document   : building
    Created on : Oct 15, 2015, 11:45:25 AM
    Author     : ICTS Members
--%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="nust.directory.model.Building" %>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
     <head>
         <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="css/custom2.css">
        <link rel="stylesheet" type="text/css" href="css/dashboard.css">
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
        <title>Directory Land</title>
    </head>

    
    <body>

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

    <div class="container">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
            <li><a href="${pageContext.request.contextPath}/DisplayUserController" class="active">Home</a></li>
            <li><a href="${pageContext.request.contextPath}/DisplayUserController" class="active">User</a></li>
            <li><a href="${pageContext.request.contextPath}/DisplayEmployeeController" class="active">Employee</a></li>
            <li><a href="${pageContext.request.contextPath}/DisplayFacultyController" class="active">Faculty</a></li>
            <li><a href="${pageContext.request.contextPath}/DisplayDepartmentController" class="active">Department</a></li>
            <li><a href="${pageContext.request.contextPath}/DisplayBuildingController" class="active">Building</a></li>
            <li><a href="#">Settings</a></li>
          </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <div class="row">
            <div class="col-md-12">
                <div id="searchbox">
                    <form class="form-group">
                            <a href="buildingcreate.jsp" class="btn btn-info btn-lg1">
                                <span class="glyphicon glyphicon-add">Add
                            </a>
                            <label for="Search"></label>
                            <input type="text" class="form-control" id="search" onkeyup="showHint(this.value)">

                            <a href="#" class="btn btn-info btn-lg">
                                <span class="glyphicon glyphicon-search">Search
                            </a>
                    </form> 
                    <p>Suggestions: <span id="txtHint"></span></p>
                </div>
             </div>
          <h2 class="sub-header">Building Listings</h2>
          <div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
                  <th>Building ID</th>
                  <th>Name</th>
                  <th>Number of Floors</th>
                  <th>Number of Offices</th>
                </tr>
              </thead>
              <tbody>
                
                 <c:forEach var="building" items= '<%= request.getAttribute("listBuilding") %>' >
               
                <tr value="${building.building_id}" name="${building.building_id}"> 
                    <td><c:out value="${building.building_id}" /></td>
                    <td><c:out value="${building.name}" /></td>
                    <td><c:out value="${building.floor}" /></td>
                    <td><c:out value="${building.numOffices}" /></td
                 
                     <td ><a class="btn btn-info btn-lg2" href="${pageContext.request.contextPath}/ViewBuildingController?id=${building.building_id} "><span class="glyphicon glyphicon-edit">Edit</a></td>
                     <td><a class="btn btn-info btn-lg2" href="${pageContext.request.contextPath}/DeleteBuildingController?id=${building.building_id} "><span class="glyphicon glyphicon-erase">Delete</a></td>
                     <td><a href="${pageContext.request.contextPath}/ViewBuildingController" class="btn btn-info btn-lg2"><span class="glyphicon glyphicon-info-sign">View</a></td>
                </tr> 
                </c:forEach>
              </tbody>
            </table>
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

</html>
