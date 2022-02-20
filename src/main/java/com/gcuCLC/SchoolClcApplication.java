package com.gcuCLC;

/** * * * * * * * * * * * * * * *
 * CST-339 CLC Milestone Project
 * Order Management Application *
 * Created by Warren Peterson,* *
 * Jonathan Levan, Ivan Gudino  *
 * * * * * * * * * * * * * * * **/ 

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

// Inializes the Web Application
@ComponentScan({"com.gcuCLC"})
@SpringBootApplication
public class SchoolClcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolClcApplication.class, args);
	}

}
