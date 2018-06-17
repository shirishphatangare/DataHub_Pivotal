package com.example.employeehierarchyservice.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.example.employeehierarchyservice.model.Employee;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = EmployeeHierarchyController.class)
@ContextConfiguration(classes = EmployeeHierarchyControllerTest.WebsocketSourceConfiguration.class)
@AutoConfigureMockMvc(secure = false)
@DataJpaTest
@TestPropertySource(locations="classpath:test.properties")
public class EmployeeHierarchyControllerTest {
	    
    @Autowired
    private MockMvc mvc;
    
    Employee expectedResult = new Employee(5154048, "Angelsungv", "Soutsavang", "Business Application Analyst",97867,"+1(808) 838-6132","Angelsungv.Soutsavang@abc.com","129 Pohakulana Pl", "SECOND FLOOR - DEV","Honolulu","HI","96819","USA");
    
    @Test
    public void getEmployeeDetails() throws Exception {
    	
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
        		"/manager/find/97867").header("Authorization", "TEST").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

        mvc.perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(14)))
        .andExpect(jsonPath("$[0].manager").value(expectedResult.getManager()));
    }
	    
	    
	@ComponentScan({"com.example.employeehierarchyservice.service"})
	@EnableJpaRepositories("com.example.employeehierarchyservice.repo")
	@EntityScan("com.example.employeehierarchyservice.model")
	@EnableWebMvc
	public static class WebsocketSourceConfiguration {
		@Bean 
		ServletWebServerFactory servletWebServerFactory(){
			return new TomcatServletWebServerFactory();
		}
	}

}
