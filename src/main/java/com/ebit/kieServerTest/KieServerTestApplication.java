package com.ebit.kieServerTest;

import org.kie.server.client.KieServicesClient;
import org.kie.server.client.UserTaskServicesClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.ebit.kieServerTest")
@EnableAutoConfiguration(exclude = HibernateJpaAutoConfiguration.class)
public class KieServerTestApplication {

	private KieServicesClient kieServicesClient;

	@Autowired
	public void KieServerConfig(KieServicesClient kieServicesClient) {
		this.kieServicesClient = kieServicesClient;
	}

	public static void main(String[] args) {
		SpringApplication.run(KieServerTestApplication.class, args);
	}

	@Bean
	public UserTaskServicesClient userTaskServicesClient() {
		return kieServicesClient.getServicesClient(UserTaskServicesClient.class);
	}
}
