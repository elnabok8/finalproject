package com.bikeshop;

	
	import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
	
//	@SpringBootApplication
//	@ComponentScan("com.bikeshop")
//	@EntityScan("com.bikeshop.entities")
@SpringBootApplication(scanBasePackageClasses = { ComponentScanMarker.class})
	public class BikeShop extends SpringBootServletInitializer {
		public static void main (String[] args) {
			SpringApplication.run(BikeShop.class, args);
		}
	}
	