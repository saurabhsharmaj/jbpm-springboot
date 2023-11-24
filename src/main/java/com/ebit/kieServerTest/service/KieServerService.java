package com.ebit.kieServerTest.service;

import java.util.List;

import org.kie.server.api.model.KieContainerResourceList;
import org.kie.server.api.model.definition.ProcessDefinition;
import org.kie.server.api.model.instance.ProcessInstance;
import org.kie.server.client.KieServicesClient;
import org.kie.server.client.KieServicesConfiguration;
import org.kie.server.client.KieServicesFactory;
import org.kie.server.client.QueryServicesClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KieServerService {

	@Autowired
	private KieServicesClient kieServicesClient;

	@Autowired
	private KieServicesConfiguration kieServicesConfiguration;

	public List<ProcessDefinition> getAllProcessDefinitions() {
		KieServicesClient kieServicesClient = KieServicesFactory.newKieServicesClient(kieServicesConfiguration);
		QueryServicesClient queryServicesClient = kieServicesClient.getServicesClient(QueryServicesClient.class);

		return queryServicesClient.findProcesses(0, 100); // Adjust pagination or filtering if needed
	}

	public KieContainerResourceList getDeployedProjects() {
		return kieServicesClient.listContainers().getResult();
	}

	public List<ProcessDefinition> getProcessDefinitionsById(String id) {
		KieServicesClient kieServicesClient = KieServicesFactory.newKieServicesClient(kieServicesConfiguration);
		QueryServicesClient queryServicesClient = kieServicesClient.getServicesClient(QueryServicesClient.class);

		return queryServicesClient.findProcessesById(id); // Adjust pagination or filtering if needed
	}

	public List<ProcessInstance> getAllProcessInstances() {
		KieServicesClient kieServicesClient = KieServicesFactory.newKieServicesClient(kieServicesConfiguration);
		QueryServicesClient queryServicesClient = kieServicesClient.getServicesClient(QueryServicesClient.class);

		return queryServicesClient.findProcessInstances(0, 100); // Adjust pagination or filtering if needed
	}

	public List<ProcessInstance> getAllProcessInstances(String containerId) {
		KieServicesClient kieServicesClient = KieServicesFactory.newKieServicesClient(kieServicesConfiguration);
		QueryServicesClient queryServicesClient = kieServicesClient.getServicesClient(QueryServicesClient.class);

		return queryServicesClient.findProcessInstances(0, 100); // Adjust pagination or filtering if
																	// needed
	}

}
