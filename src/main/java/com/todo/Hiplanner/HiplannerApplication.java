package com.todo.Hiplanner;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = {"com.todo.Hiplanner.mapper"})
@SpringBootApplication
public class HiplannerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HiplannerApplication.class, args);
	}

}
