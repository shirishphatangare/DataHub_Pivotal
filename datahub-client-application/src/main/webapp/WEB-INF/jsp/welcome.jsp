<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
	  <div id="getEmployees" class="form-inline">
        <form:form action="https://auth-service-dev.cfapps.io/oauth/authorize" method="post">
            <p>
                 <input type="hidden" name="response_type" value="code" /> 
                 <input type="hidden" name="client_id" value="employeeapp" />
                 <!--  <input type="hidden" name="redirect_uri" value="https://datahub-client-application-dev.cfapps.io/index" /> -->
                 <input type="hidden" name="redirect_uri" value="http://localhost:8082/index" />
                 <input type="hidden" name="scope" value="read" /> 
                 <input type="SUBMIT" value="Login" />
        </form:form>
    </div>
  </nav>
</body>
</html>
