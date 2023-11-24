package com.ebit.kieServerTest.controller;

import org.kie.server.api.model.KieContainerResourceList;
import org.kie.server.client.KieServicesClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ebit.kieServerTest.service.KieServerService;

@RestController
public class HomeController {

	@Autowired
	private KieServerService kieServerService;

	@Autowired
	private KieServicesClient kieServicesClient;

	@GetMapping("/get")
	public KieContainerResourceList getdata() {
		return kieServerService.getDeployedProjects();
	}

	@GetMapping("/test")
	public KieContainerResourceList getDeployedProjects() {
		return kieServicesClient.listContainers().getResult();
	}
}
