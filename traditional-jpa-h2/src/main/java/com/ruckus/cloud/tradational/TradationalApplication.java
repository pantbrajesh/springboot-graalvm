package com.ruckus.cloud.tradational;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(proxyBeanMethods = false)
public class TradationalApplication {

	public static void main(String[] args) {
		SpringApplication.run(TradationalApplication.class, args);
	}

}
