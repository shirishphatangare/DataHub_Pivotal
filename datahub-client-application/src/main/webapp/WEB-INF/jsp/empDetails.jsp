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
  <a class="navbar-brand">Employee Inquiry</a>
  <div class="form-inline">
    <input class="form-control mr-sm-2" id="employeeid" type="text" placeholder="Enter Emp id" aria-label="Search">
    <button class="btn btn-outline-success my-2 my-sm-0" onclick="getEmployeeDetails()">Go</button>
  </div>
</nav>


<table class="table table-striped">
    <thead>
    <tr>
    <th scope="col" style="background-color: #cc66ff;">Employee Details</th>
    </tr>
    </thead>
    <tbody>
    
    <tr>
        <td>${employee.firstname} ${employee.lastname}</td>
    </tr>
    <tr>
        <td>${employee.role}</td>
    </tr>
    <tr>
    	<td><B>FedEx ID: </B> <a href="/empDetails/${employee.id}"> ${employee.id} </a></td>
    </tr>
    
    <tr>
        <td> Manager: <a href="/empHierarchy/${employee.manager}">  ${manager.firstname} ${manager.lastname}</a></td>
    </tr>
<tr>
    <th style="background-color: #cc66ff;" scope="col">Contact Information</th>
    </tr>
    
    <tr>
        <td><B>Phone:</B> ${employee.phone}</td>
    </tr>
    <tr>
        <td><B>Email:</B> ${employee.email}</td>
    </tr>
    
    <tr>
    <th scope="col" style="background-color: #cc66ff;">Work Address</th>
    </tr>
    <tr>
        <td>${employee.address1}</td>
    </tr>
    <tr>
        <td>${employee.address2}</td>
    </tr>
    <tr>
        <td>${employee.city}</td>
    </tr>
        <tr>
        <td>${employee.state}</td>
    </tr>
    
        <tr>
        <td>${employee.zip}</td>
    </tr>
        <tr>
        <td>${employee.country}</td>
    </tr>
    
    
    </tbody>
  </table>
	<a style="float:right" href="https://employee-master-service-dev.cfapps.io/swagger-ui.html">Swagger Documentation</a>
	<a style="float:right" href="https://employee-master-service-dev.cfapps.io/hystrix">Hystrix DashBoard</a>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/employeeDetails.js"></script>
</body>
</html>