package com.mi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableSwagger2
@MapperScan("com.mi.mapper")
public class swaggerApplication {
	public static void main(String[] args) {
		SpringApplication.run(swaggerApplication.class, args);
	}
}

