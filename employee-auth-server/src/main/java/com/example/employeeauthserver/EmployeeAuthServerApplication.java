package com.example.employeeauthserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableResourceServer
//@RestController
public class EmployeeAuthServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeAuthServerApplication.class, args);
	}
	
	
	/*@RequestMapping("/user")
	Principal getUser(Principal user) {
		return user;
	}
	
	@Bean
	public static BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}*/
	
//   @Bean
//    FilterRegistrationBean corsFilter(@Value("${tagit.origin:http://localhost:8082}") String origin) {
//    	
//    	FilterRegistrationBean f = 	new FilterRegistrationBean();
//    	
//    	f.setFilter(new Filter() {
//            public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
//                    throws IOException, ServletException {
//                HttpServletRequest request = (HttpServletRequest) req;
//                HttpServletResponse response = (HttpServletResponse) res;
//                String method = request.getMethod();
//                // this origin value could just as easily have come from a database
//                response.setHeader("Access-Control-Allow-Origin", origin);
//                response.setHeader("Access-Control-Allow-Methods", "POST,GET,OPTIONS,DELETE");
//                response.setHeader("Access-Control-Max-Age", Long.toString(60 * 60));
//                response.setHeader("Access-Control-Allow-Credentials", "true");
//                response.setHeader("Access-Control-Allow-Headers", "Origin,Accept,X-Requested-With,Content-Type,Access-Control-Request-Method,Access-Control-Request-Headers,Authorization");
//                if ("OPTIONS".equals(method)) {
//                    response.setStatus(HttpStatus.OK.value());
//                } else {
//                    chain.doFilter(req, res);
//                }
//            }
//
//            public void init(FilterConfig filterConfig) {
//            }
//
//            public void destroy() {
//            }
//        });
//    	
//    	return f;
//    	
//    }
	
	
}
