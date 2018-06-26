package com.example.employeeinquiryclient.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmployeeInquiryErrorController implements ErrorController  {
 
	@RequestMapping("/error")
	public String handleError(HttpServletRequest request) {
	    Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
	    
	    if (status != null) {
	        Integer statusCode = Integer.valueOf(status.toString());
	        if(statusCode == HttpStatus.FORBIDDEN.value()) {
	            return "error-403";
	        } 
	        else {
	        	return "error-general";
	        }
	    }
	    return "error";
	}
 
    @Override
    public String getErrorPath() {
        return "/error";
    }
}