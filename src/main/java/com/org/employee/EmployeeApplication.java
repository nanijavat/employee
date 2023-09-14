package com.org.employee;
//employee microservice now we will write one more
// microservices and call that micro to this
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeApplication {
  //c ,r u,d patch
	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}

}
