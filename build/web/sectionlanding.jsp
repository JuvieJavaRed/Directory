<%-- 
    Document   : sectionlanding
    Created on : Nov 19, 2015, 10:06:25 AM
    Author     : mary.dzinomwa
--%>

-%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="nust.directory.model.Section"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
     <head>
         <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="css/custom2.css">
        <link rel="stylesheet" type="text/css" href="css/dashboard.css">
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
            <li><a href="${pageContext.request.contextPath}/DisplayEmployeeController" class="active">Home</a></li>
            <li><a href="${pageContext.request.contextPath}/DisplayUserController" class="active">User</a></li>
            <li><a href="${pageContext.request.contextPath}/DisplayEmployeeController" class="active">Employee</a></li>
            <li><a href="${pageContext.request.contextPath}/DisplayFacultyController" class="active">Faculty</a></li>
            <li><a href="${pageContext.request.contextPath}/DisplayDepartmentController" class="active">Department</a></li>
            <li><a href="${pageContext.request.contextPath}/DisplayBuildingController" class="active">Building</a></li>
            <li><a href="#" class="active">Settings</a></li>
          </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <div class="row">
            <div class="col-md-12">
                <div id="searchbox">
                    <form class="form-group">
                            <a href="sectioncreate.jsp" class="btn btn-info btn-lg1">
                                <span class="glyphicon glyphicon-add">Add
                            </a>
                            <label for="Search"></label>
                            <input type="text" class="form-control" id="search">
                            <a href="#" class="btn btn-info btn-lg">
                                <span class="glyphicon glyphicon-search">Search
                            </a>
                    </form>    
                </div>
          </div>
          <h2 class="sub-header">Section Listings</h2>
          <div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
                  <th>Section ID</th>
                  <th>Section Name</th>
                  <th>Building ID</th>
                </tr>
              </thead>
              <tbody>
                <c:forEach  var="section" items= '<%= request.getAttribute("listSection") %>' >
                <tr> 
                    <td><c:out value="${section.section_id}" /></td>
                    <td><c:out value="${section.section_name}" /></td>
                    <td><c:out value="${section.building_id}" /></td>
                </tr>
                 <td><a href="${pageContext.request.contextPath}/EditSectionController" class="btn btn-info btn-lg2"><span class="glyphicon glyphicon-edit">Edit</a></td>
                 <td><a href="${pageContext.request.contextPath}/DeleteSectionController" class="btn btn-info btn-lg2"><span class="glyphicon glyphicon-erase">Delete</a></td>
                 <td><a href="${pageContext.request.contextPath}/ViewSectionController" class="btn btn-info btn-lg2"><span class="glyphicon glyphicon-info-sign">View</a></td>
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
    
    
  </body>

</html>


