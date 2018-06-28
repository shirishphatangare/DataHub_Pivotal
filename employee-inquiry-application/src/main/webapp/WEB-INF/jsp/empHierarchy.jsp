<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
  <title>Employee Inquiry</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
   <style>
    /* Remove the navbar's default margin-bottom and rounded borders */ 
    .navbar {
      margin-bottom: 0;
      border-radius: 0;
    }
    
    .sidenav {
      padding-top: 20px;
      background-color: #f1f1f1;
      height: 100%;
    }
    
    /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
    .row.content {height: 650px;}
    
    /* Set black background color, white text and some padding */
    footer {
      background-color: #555;
      color: white;
      margin-bottom: 5px;
      padding:	5px;
    }
    
  </style>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#"><B>Employee Inquiry </B></a>
    </div>
          <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li><a href="/index">Home</a></li>
        <!--  <li><a target="_blank" href="https://employee-master-service-dev.cfapps.io/hystrix">Hystrix DashBoard</a></li> -->
        <li><a target="_blank" href="https://employee-master-service-dev.cfapps.io/hystrix/monitor?stream=https://employee-master-service-dev.cfapps.io/actuator/hystrix.stream">Hystrix DashBoard</a></li>
        <li><a target="_blank" href="https://employee-master-service-dev.cfapps.io/swagger-ui.html">Swagger Documentation</a></li>
        <li><a href="#">About</a></li>
        <li><a href="#">Contact Us</a></li>
        <li><a  href="${pageContext.request.contextPath}/logout">Logout</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li style="margin-top:5px;margin-right:5px;padding-top:5px;">		  <div class="form-inline">
	    <input class="form-control mr-sm-2" id="employeeid" type="text" placeholder="Enter Emp id" aria-label="Search">
	    <button class="btn btn-info my-2 my-sm-0" style="font-weight: bold;" onclick="getEmployeeDetails()">Go</button>
	  </div></li>
      </ul>
    </div> 
    </div> 
</nav>
  
<div class="container-fluid text-center">    
  <div class="row content">
  <div class="col-sm-2 sidenav">
</div> 
    <div class="col-sm-8 text-justify" style="padding-top: 20px;"> 
<table class="table table-striped">
    <thead>
    <tr>
    <th colspan="4" style="background-color: #F5A9F2;">Company PeopleDirectory</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td colspan="4">${manager.firstname} ${manager.lastname}</td>
    </tr>
    <tr>
        <td colspan="4">${manager.role}</td>
    </tr>
    <tr>
    	<td colspan="4"><B>Employee ID: </B> <a href="/empDetails/${manager.id}"> ${manager.id} </a></td>
    </tr>
    <tr>
    <th colspan="4" style="background-color: #F5A9F2;">Roster Information</th>
    </tr>
    <c:forEach var="employee" items="${employeeList}" >
    <tr>
    	<td>${employee.firstname} ${employee.lastname}</td>
    	<th scope="row"><a href="/empDetails/${employee.id}"> ${employee.id} </a></th>
        <td>${employee.role}</td>
        <td>${employee.phone}</td>
    </tr>
 	</c:forEach>
    </tbody>
  </table> 
  </div>
  <div class="col-sm-2 sidenav">
</div>      
  </div> 
</div>
<hr>
<footer class="container-fluid text-center">
  Syntel Inc. 2018
</footer>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/employeeDetails.js"></script>
</body>
</html>