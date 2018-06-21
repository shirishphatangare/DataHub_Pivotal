<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
	<!-- Access the bootstrap Css like this, 
		Spring boot will handle the resource mapping automcatically -->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.css" />
	
	<c:url value="/css/home.css" var="jstlCss" />
	<link href="${jstlCss}" rel="stylesheet" />
	
</head>
<body>
	
<nav class="navbar navbar-light justify-content-between" style="background-color: #e3f2fd;">
  <a class="navbar-brand">Employee Hierarchy</a>
  <div class="form-inline">
    <input class="form-control mr-sm-2" id="employeeid" type="text" placeholder="Enter Emp id" aria-label="Search">
    <button class="btn btn-outline-success my-2 my-sm-0" onclick="getEmployeeDetails()">Go</button>
  </div>
</nav>


<table class="table table-striped">
    <thead>
    <tr>
    <th scope="col" style="background-color: #cc66ff;">Company PeopleDirectory</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>${manager.firstname} ${manager.lastname}</td>
    </tr>
    <tr>
        <td>${manager.role}</td>
    </tr>
    <tr>
    	<td><B>Employee ID: </B> <a href="/empDetails/${manager.id}"> ${manager.id} </a></td>
    </tr>
    <tr>
    <th scope="col" style="background-color: #cc66ff;">Roster Information</th>
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
	<a style="float:right;font-size: 15px; margin-left: 30px;margin-right: 10px" href="https://auth-service-dev.cfapps.io/logout">Logout</a>
	<a style="float:right;font-size: 15px; margin-left: 30px;" href="https://employee-master-service-dev.cfapps.io/swagger-ui.html">Swagger Documentation</a>
	<a style="float:right;font-size: 15px;" href="https://employee-master-service-dev.cfapps.io/hystrix">Hystrix DashBoard</a>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/employeeDetails.js"></script>
</body>
</html>
