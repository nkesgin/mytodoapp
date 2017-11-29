package com.mytodolist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages={"com.mytodolist.Controller"})
public class MytodolistApplication {

	public static void main(String[] args) {
		SpringApplication.run(MytodolistApplication.class, args);
	}
}
