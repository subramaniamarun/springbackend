package com.paraminfo.todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.paraminfo.todo")
public class Test {

	public static void main(String[] args) {
		SpringApplication.run(Test.class, args);
	}
}
