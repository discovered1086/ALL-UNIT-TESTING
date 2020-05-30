package com.kingshuk.testing.springtesting;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kingshuk.testing.springtesting.config.SpringAppConfiguration;
import com.kingshuk.testing.springtesting.dao.TaskManagementDAO;
import com.kingshuk.testing.springtesting.exceptions.TaskManagementException;
import com.kingshuk.testing.springtesting.model.TaskModel;
import com.kingshuk.testing.springtesting.service.TaskManagementService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringAppConfiguration.class)
public class TaskManagementServiceImpltest {

	@Mock
	private TaskManagementDAO taskManagementDAO;

	@Autowired
	@InjectMocks
	private TaskManagementService service;

	private List<TaskModel> taskList;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		
		TaskModel taskModel = new TaskModel();
		taskModel.setTaskId(1);
		taskModel.setTaskTitle("To wake up early");
		taskModel.setTaskDescription("To wake up early");
		taskModel.setTaskOwner("Kingshuk");
		taskModel.setTaskDueDate("08/21/2018");

		TaskModel taskModel2 = new TaskModel();
		taskModel2.setTaskId(1);
		taskModel2.setTaskTitle("To complete Junit training");
		taskModel2.setTaskDescription("To wake up early and complete the Junit training");
		taskModel2.setTaskOwner("Kingshuk");
		taskModel2.setTaskDueDate("09/03/2017");

		taskList = Arrays.asList(taskModel, taskModel2);
	}

	@Test
	public void testGetAllTasks() throws TaskManagementException, Exception {
		when(taskManagementDAO.getAllTask()).thenReturn(taskList);
		
		List<TaskModel> allTask = service.getAllTask();

		assertEquals(2, allTask.size());
	}

}
