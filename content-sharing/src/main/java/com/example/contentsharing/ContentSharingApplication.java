package com.example.contentsharing;

import com.example.contentsharing.selenium.SeleniumTest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.io.IOException;

@SpringBootApplication
public class ContentSharingApplication {

	public static void main(String[] args){
		SpringApplication.run(ContentSharingApplication.class, args);
	}

}
