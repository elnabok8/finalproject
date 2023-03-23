package com.bikeshop;

	
	import org.springframework.boot.SpringApplication;
	import org.springframework.boot.autoconfigure.SpringBootApplication;
	import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
	
	@SpringBootApplication (scanBasePackageClasses = {ComponentScanMarker.class})
	public class BikeShop {
		public static void main (String[] args) {
			SpringApplication.run(BikeShop.class, args);
		}
	}
	
