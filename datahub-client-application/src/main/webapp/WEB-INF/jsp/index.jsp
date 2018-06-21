<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
	<a style="float:right;font-size: 15px; margin-left: 30px;margin-top: 650px;margin-right: 10px" href="https://auth-service-dev.cfapps.io/logout">Logout</a>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/employeeDetails.js"></script>
</body>
</html>
