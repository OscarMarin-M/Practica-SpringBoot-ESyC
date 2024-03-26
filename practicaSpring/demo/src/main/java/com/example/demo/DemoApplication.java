package com.example.demo;

import com.example.demo.controller.AutorController;
import com.example.demo.controller.LibroController;
import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication


public class DemoApplication {
	@Autowired AutorController autorController;
	@Autowired LibroController libroController;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
