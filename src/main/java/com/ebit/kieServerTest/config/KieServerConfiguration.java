package com.ebit.kieServerTest.config;

import org.kie.server.api.marshalling.MarshallingFormat;
import org.kie.server.client.KieServicesClient;
import org.kie.server.client.KieServicesConfiguration;
import org.kie.server.client.KieServicesFactory;
import org.kie.server.client.UserTaskServicesClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KieServerConfiguration {

	@Bean
	public KieServicesClient kieServicesClient() {
		KieServicesConfiguration config = KieServicesFactory
				.newRestConfiguration("http://192.168.1.24:8080/kie-server/services/rest/server", "wbadmin", "wbadmin");

		config.setMarshallingFormat(MarshallingFormat.JSON);

		return KieServicesFactory.newKieServicesClient(config);
	}

	@Bean
	public KieServicesConfiguration kieServicesConfiguration() {
		return KieServicesFactory.newRestConfiguration("http://192.168.1.24:8080/kie-server/services/rest/server",
				"wbadmin", "wbadmin");
	}

}
