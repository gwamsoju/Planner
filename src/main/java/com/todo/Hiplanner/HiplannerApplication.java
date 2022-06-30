package com.todo.Hiplanner;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@MapperScan(value = {"com.todo.Hiplanner.mapper"})
@SpringBootApplication
public class HiplannerApplication {

	@Bean
	public BCryptPasswordEncoder encodePassword(){
		return new BCryptPasswordEncoder();
	}

	public static void main(String[] args) {
		SpringApplication.run(HiplannerApplication.class, args);
	}

}
