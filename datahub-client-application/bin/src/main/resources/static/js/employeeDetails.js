function getEmployeeDetails(){
   var employeeId = document.getElementById("employeeid").value;
   if(employeeId == "" || employeeId == undefined){
	   return;
   }
   var url = "/empDetails/" + employeeId;
   window.location.replace(url);
}