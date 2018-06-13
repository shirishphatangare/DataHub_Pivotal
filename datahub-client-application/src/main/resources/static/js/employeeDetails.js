function getEmployeeDetails(){
   var employeeId = document.getElementById("employeeid").value;
   var url = "/empDetails/" + employeeId;
   window.location.replace(url);
}