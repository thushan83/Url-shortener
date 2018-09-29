package com.shortener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.shortner.service", "com.shortner.util"})
public class UrlShortenerAppliction {
	
	public static void main(String[] args) {
		SpringApplication.run(UrlShortenerAppliction.class, args);
	}
}
