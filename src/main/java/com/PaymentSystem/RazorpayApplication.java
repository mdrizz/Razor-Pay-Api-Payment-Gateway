package com.PaymentSystem;

import Config.RazorpayConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RazorpayApplication {

	@Bean
	public RazorpayConfig razorpayConfig(){
		return new RazorpayConfig();
	}

	public static void main(String[] args) {
		SpringApplication.run(RazorpayApplication.class, args);
	}

}
