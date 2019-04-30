package org.springcloud.service01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroService01Application {

	public static void main(String[] args) {
		SpringApplication.run(MicroService01Application.class, args);
	}

}
