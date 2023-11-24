package com.ebit.kieServerTest.controller;

import java.util.List;

import org.kie.server.api.model.instance.TaskInstance;
import org.kie.server.api.model.instance.TaskSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ebit.kieServerTest.service.UserTaskServiceImpl;

@RestController
public class ProcessTaskController {

	@Autowired
	private UserTaskServiceImpl userTaskServiceImpl;

	@GetMapping("/tasks")
	public List<TaskSummary> getTasks() {

		return userTaskServiceImpl.getAllTasks();

	}

	@GetMapping("/tasks/start")
	public String StartTask() {

		userTaskServiceImpl.startTask();
		return "Task Done";

	}
}
