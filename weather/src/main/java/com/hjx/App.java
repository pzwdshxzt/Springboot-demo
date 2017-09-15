package com.hjx;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hjx.dao")
public class App {

	public static void main(String[] args) {

		SpringApplication.run(App.class, args);

	}
}
