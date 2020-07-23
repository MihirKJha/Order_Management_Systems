package com.corp.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class OrderMgmtConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderMgmtConfigServerApplication.class, args);
	}
}
