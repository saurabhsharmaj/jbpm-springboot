package com.ebit.kieServerTest.controller;

import java.util.List;

import org.kie.server.api.model.definition.ProcessDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ebit.kieServerTest.service.KieServerService;

@RestController
@RequestMapping("/process-definitions")
public class ProcessDefinitionController {

	@Autowired
	private KieServerService kieServerService;

	@GetMapping("/")
	public List<ProcessDefinition> getProcessDefinitions() {
		return kieServerService.getAllProcessDefinitions();
	}

	@GetMapping("/{id}")
	public List<ProcessDefinition> getProcessDefinitionsById(@PathVariable String id) {
		return kieServerService.getProcessDefinitionsById(id);
	}

}
