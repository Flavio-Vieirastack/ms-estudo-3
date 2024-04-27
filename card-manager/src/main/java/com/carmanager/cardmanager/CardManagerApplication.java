package com.carmanager.cardmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class CardManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardManagerApplication.class, args);
	}

}
