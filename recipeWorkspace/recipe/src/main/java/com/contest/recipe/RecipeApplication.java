package com.contest.recipe;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.contest.recipe")
public class RecipeApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecipeApplication.class, args);
	}

}
