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
      <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
      <hr>
      <img src="${pageContext.request.contextPath}/images/employee-data.jpg" width="100%" height="460"  alt="Responsive image">
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