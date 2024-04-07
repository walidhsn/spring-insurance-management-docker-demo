package com.tn.esprit.assuranceexam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class AssuranceExamApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssuranceExamApplication.class, args);
	}

}
