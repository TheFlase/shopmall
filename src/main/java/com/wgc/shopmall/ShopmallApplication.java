package com.wgc.shopmall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ShopmallApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopmallApplication.class, args);
	}

}
