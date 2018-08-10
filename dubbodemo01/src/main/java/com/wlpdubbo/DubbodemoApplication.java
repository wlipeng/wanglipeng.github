package com.wlpdubbo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
/*@ComponentScan(basePackages = {"com.wlpdubbo.scanConfig"})*/
public class DubbodemoApplication {

	public static void main(String[] args) {
		ApplicationContext ctx =SpringApplication.run(DubbodemoApplication.class, args);
	}
}
