<!DOCTYPE html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
      <ul class="nav navbar-nav navbar-right">
        <li> 
	          <div id="getEmployees" class="form-inline" > 
		        <form:form action="https://employee-auth-service-dev.cfapps.io/oauth/authorize" method="post">
	                <input type="hidden" name="response_type" value="code" /> 
	                <input type="hidden" name="client_id" value="employeeapp" />
	                <input type="hidden" name="redirect_uri" value="https://employee-inquiry-application-dev.cfapps.io/index" />
	               <!--   <input type="hidden" name="redirect_uri" value="http://localhost:8082/index" /> -->
	                <input type="hidden" name="scope" value="read" /> 
	                <input type="SUBMIT" class="btn btn-info" value="Login using Employee Auth Service" style="font-weight: bold;margin-top:10px;margin-right:10px;padding-top:5px;"/>
		        </form:form>
	    	</div>
    	</li>
    </ul>
    </div> 
</nav>
  
<div class="container-fluid text-center">    
  <div class="row content">
  <div class="col-sm-2 sidenav">
</div> 
    <div class="col-sm-8 text-justify"> 
      <h1>Welcome</h1>
      <p>The Employee Inquiry application uses ZUUL API gateway as an edge service that provides dynamic routing and logging. 'Employee Master' microservice is a dashboard service which internally communicates with 'Employee Details' and 'Employee Hierarchy' microservies. 'Employee Master' microservice uses Feign client to call REST endpoints of 'Employee Details' and 'Employee Hierarchy' microservices. Authentication and authorization is controlled using OAuth2.0 protocol. Employee Inquiry application features Hystrix dashboard and Swagger documentation. The Hystrix Dashboard facilitates monitoring Hystrix metrics in real time. Swagger takes the manual work out of API documentation, with a range of solutions for generating, visualizing, and maintaining API docs. Configuration microservice allows database configurations for dev-prod profiles. Eureka Service registry is primarily used in the cloud for service discovery, for the purpose of load balancing and failover of middle-tier servers.</p>
      <hr>
      <img src="${pageContext.request.contextPath}/images/employee-data.jpg" width="100%" height="400"  alt="Responsive image">
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
</body>
</html>