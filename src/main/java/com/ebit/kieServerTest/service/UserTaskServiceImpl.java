package com.ebit.kieServerTest.service;

import java.util.List;
import java.util.Map;

import org.kie.server.api.model.instance.TaskSummary;
import org.kie.server.client.UserTaskServicesClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserTaskServiceImpl {

	@Autowired
	private UserTaskServicesClient userTaskServicesClient;

	public List<TaskSummary> getAllTasks() {

//		TaskInstance taskInstance = userTaskServicesClient.findTaskById(4l);

		List<TaskSummary> tasks = userTaskServicesClient.findTasks("wbadmin", 0, 100);

		System.out.println("done");
		return tasks;
	}

	public void startTask() {
		userTaskServicesClient.startTask("evaluation_1.0.0-SNAPSHOT", 36L, "wbadmin");

	}
}