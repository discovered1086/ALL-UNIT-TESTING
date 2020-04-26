package com.kingshuk.testing.practice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.kingshuk.testing.practice.exceptions.TaskManagementException;
import com.kingshuk.testing.practice.model.TaskModel;
import com.kingshuk.testing.practice.model.dao.TaskManagementDAO;
import com.kingshuk.testing.practice.service.TaskManagementService;
import com.kingshuk.testing.practice.service.TaskManagementServiceImpl;

public class TaskManagerServiceImplTest {
	private TaskManagementService taskManagementService;

	@Mock
	private TaskManagementDAO taskManagementDAO;

	@BeforeEach
	public void setUp() throws Exception {
		// This is essentially the stubbing part., step 1 of mocking
		// This line should always come before other configuration

		// Below is the most important line here.
		// At runtime this will help create proxies for all dependent objects
		// The parameter to this method is the current class under test
		MockitoAnnotations.initMocks(this);

		taskManagementService = new TaskManagementServiceImpl();
		taskManagementService.setTaskManagementDAO(taskManagementDAO);
	}

	@Test
	public void addTaskShouldCreateATask() throws Exception {
		// Here the add task method calls the DAO method addTask(). So we want to mock
		// out that method call
		// As if we're trying to imitate the behavior of the actual service class. We
		// want this addTask method
		// to do what we ask it to do.

		TaskModel taskModel = new TaskModel();
		taskModel.setTaskId(1);
		taskModel.setTaskTitle("To wake up early");
		taskModel.setTaskDescription("To wake up early");

		// When is used for conditionally mocking out method calls. When is the trigger.
		// Then is the consequence.

		// This is essentially setting up expectations., step 2 of mocking

		// Basically what I'm telling mockito is that when we make a call to the addTask
		// method of the DAO class then
		// it returns true. Here am forcing the stubbed object to return true when I
		// make a call to the DAO method.
		when(taskManagementDAO.addTask(ArgumentMatchers.any(TaskModel.class))).thenReturn(true);

		// This is the assertion or verification of results....step 3 of mocking
		// After I have forced the the expectation to be true, am making a call to the
		// actual service method
		// Does it actually call the DAO here? not sure
		Boolean result = taskManagementService.addTask(taskModel);

		// And then am asserting if the result is indeed true.

		// This is what is happening here.
		// -->I have mocked out the DAO so what the DAO does is least of my concern
		// here.
		// -->Basically here am testing if the DAO returns true, then the service should
		// return true as well. This is the basic idea here.
		// Am testing the service class's behavior here based on what the DAO returns.
		assertTrue(result);

		// This is the verification part. This does NOT verify the results. It just
		// verifies that when we call the addTask method
		// on the service class, actually the DAO method is getting called.step 3 of
		// mocking

		// Verify method can be used to see if the stubbed method got called.
		verify(taskManagementDAO).addTask(taskModel);

	}

	@Test
	public void addTask_should_throw_exception() throws Exception {
		// Here the add task method calls the DAO method addTask(). So we want to mock
		// out that method call
		// As if we're trying to imitate the behavior of the actual service class. We
		// want this addTask method
		// to do what we ask it to do.

		// When is used for conditionally mocking out method calls. When is the trigger.
		// Then is the consequence.

		// This is essentially setting up expectations., step 2 of mocking

		// Basically what I'm telling mockito is that when we make a call to the addTask
		// method of the DAO class then
		// it throws a null pointer exception. Here am forcing the stubbed object to
		// throw a null pointer exception
		// when I make a call to the DAO method.
		when(taskManagementDAO.addTask(null)).thenThrow(new NullPointerException());

		// This is the assertion or verification of results....step 3 of mocking
		// After I have forced the the expectation to be true, am making a call to the
		// actual service method
		// Does it actually call the DAO here? not sure

		Assertions.assertThrows(TaskManagementException.class, () -> {
			taskManagementService.addTask(null);
		});

		// And then am asserting if the result is indeed true.

		// This is what is happening here.
		// -->I have mocked out the DAO so what the DAO does is least of my concern
		// here.
		// -->Basically here am testing if the DAO throws a null pointer exception, then
		// the service should
		// throw a task management exception
		// This is the basic idea here.

		// This is the verification part. This does NOT verify the results. It just
		// verifies that when we call the addTask method
		// on the service class, actually the DAO method is getting called.step 3 of
		// mocking

		// Verify method can be used to see if the stubbed method got called.
		verify(taskManagementDAO, atLeastOnce()).addTask(null);

	}

	@Test
	public void addTask_should_throw_sql_exception() throws Exception {
		// Here the add task method calls the DAO method addTask(). So we want to mock
		// out that method call
		// As if we're trying to imitate the behavior of the actual service class. We
		// want this addTask method
		// to do what we ask it to do.

		TaskModel taskModel = new TaskModel();
		taskModel.setTaskId(0);
		taskModel.setTaskTitle("To wake up early");
		taskModel.setTaskDescription("To wake up early");

		// When is used for conditionally mocking out method calls. When is the trigger.
		// Then is the consequence.

		// This is essentially setting up expectations., step 2 of mocking

		// Basically what I'm telling mockito is that when we make a call to the addTask
		// method of the DAO class then
		// it throws a null pointer exception. Here am forcing the stubbed object to
		// throw a null pointer exception
		// when I make a call to the DAO method.
		when(taskManagementDAO.addTask(taskModel)).thenThrow(new SQLException());

		// This is the assertion or verification of results....step 3 of mocking
		// After I have forced the the expectation to be true, am making a call to the
		// actual service method
		// Does it actually call the DAO here? not sure
		Assertions.assertThrows(TaskManagementException.class, () -> {
			taskManagementService.addTask(taskModel);
		});

		// And then am asserting if the result is indeed true.

		// This is what is happening here.
		// -->I have mocked out the DAO so what the DAO does is least of my concern
		// here.
		// -->Basically here am testing if the DAO throws a null pointer exception, then
		// the service should
		// throw a task management exception
		// This is the basic idea here.

		// This is the verification part. This does NOT verify the results. It just
		// verifies that when we call the addTask method
		// on the service class, actually the DAO method is getting called.step 3 of
		// mocking

		// Verify method can be used to see if the stubbed method got called.
		verify(taskManagementDAO, times(1)).addTask(taskModel);

	}

	@Test
	public void addTask_should_return_false() throws Exception {
		// Here the add task method calls the DAO method addTask(). So we want to mock
		// out that method call
		// As if we're trying to imitate the behavior of the actual service class. We
		// want this addTask method
		// to do what we ask it to do.
		TaskModel taskModel = new TaskModel();
		taskModel.setTaskId(1);
		taskModel.setTaskTitle("To wake up early");
		taskModel.setTaskDescription("To wake up early");

		// When is used for conditionally mocking out method calls. When is the trigger.
		// Then is the consequence.

		// This is essentially setting up expectations., step 2 of mocking

		// Basically what I'm telling mockito is that when we make a call to the addTask
		// method of the DAO class then
		// it throws a null pointer exception. Here am forcing the stubbed object to
		// throw a null pointer exception
		// when I make a call to the DAO method.
		when(taskManagementDAO.addTask(taskModel)).thenReturn(false);

		// This is the assertion or verification of results....step 3 of mocking
		// After I have forced the the expectation to be true, am making a call to the
		// actual service method
		// Does it actually call the DAO here? not sure
		Boolean result = taskManagementService.addTask(taskModel);

		// And then am asserting if the result is indeed false.
		assertFalse(result);

		// This is what is happening here.
		// -->I have mocked out the DAO so what the DAO does is least of my concern
		// here.
		// -->Basically here am testing if the DAO throws a null pointer exception, then
		// the service should
		// throw a task management exception
		// This is the basic idea here.

		// This is the verification part. This does NOT verify the results. It just
		// verifies that when we call the addTask method
		// on the service class, actually the DAO method is getting called.step 3 of
		// mocking

		// Verify method can be used to see if the stubbed method got called.
		verify(taskManagementDAO, atLeastOnce()).addTask(taskModel);

	}

	@Test
	public void getAllTask_return_list() throws Exception {
		List<TaskModel> taskModelList = new ArrayList<>();
		TaskModel taskModel = new TaskModel();
		taskModel.setTaskId(1);
		taskModel.setTaskTitle("To wake up early");
		taskModel.setTaskDescription("To wake up early");
		taskModelList.add(taskModel);

		when(taskManagementDAO.getAllTask()).thenReturn(taskModelList);

		List<TaskModel> taskModelList2 = taskManagementService.getAllTask();

		// assertTrue(taskModelList2.size()>0);
		assertEquals(taskModelList, taskModelList2);

		verify(taskManagementDAO, atLeastOnce()).getAllTask();
	}

	@Test
	public void getAllTask_throw_Exception() throws Exception {

		when(taskManagementDAO.getAllTask()).thenThrow(new NullPointerException());

		Assertions.assertThrows(TaskManagementException.class, () -> {
			taskManagementService.getAllTask();
		});

		verify(taskManagementDAO, atLeastOnce()).getAllTask();
	}

	@Test
	public void getAllTask_throw_SQLException() throws Exception {

		when(taskManagementDAO.getAllTask()).thenThrow(new SQLException());

		Assertions.assertThrows(TaskManagementException.class, () -> {
			taskManagementService.getAllTask();
		});

		verify(taskManagementDAO, atLeastOnce()).getAllTask();
	}

	@Test
	public void getAllTask_returns_empty_list() throws Exception {

		when(taskManagementDAO.getAllTask()).thenReturn(new ArrayList<>());

		assertTrue(taskManagementService.getAllTask().size() == 0);

		verify(taskManagementDAO, atLeastOnce()).getAllTask();
	}

	@Test
	public void updateTask_updates_the_task() throws Exception {
		TaskModel taskModel = new TaskModel();
		taskModel.setTaskId(1);
		taskModel.setTaskTitle("Got to go to bed early");
		taskModel.setTaskDescription("Going to be bed early is always a good practice in life");

		when(taskManagementDAO.updateTask(taskModel)).thenReturn(true);

		assertTrue(taskManagementService.updateTask(taskModel));

		verify(taskManagementDAO, atLeastOnce()).updateTask(taskModel);
	}

	@Test
	public void updateTask_task_not_found() throws Exception {
		TaskModel taskModel = new TaskModel();
		taskModel.setTaskId(10);
		taskModel.setTaskTitle("Got to go to bed early");
		taskModel.setTaskDescription("Going to be bed early is always a good practice in life");

		when(taskManagementDAO.updateTask(taskModel)).thenReturn(false);

		assertFalse(taskManagementService.updateTask(taskModel));

		verify(taskManagementDAO, atLeastOnce()).updateTask(taskModel);
	}

	@Test
	public void updateTask_throws_SQLException_on_title() throws Exception {
		TaskModel taskModel = new TaskModel();
		taskModel.setTaskId(10);
		taskModel.setTaskTitle(null);
		taskModel.setTaskDescription("Going to be bed early is always a good practice in life");

		when(taskManagementDAO.updateTask(taskModel)).thenThrow(new SQLException());

		Assertions.assertThrows(TaskManagementException.class, () -> {
			taskManagementService.updateTask(taskModel);
		});

		verify(taskManagementDAO, atLeastOnce()).updateTask(taskModel);
	}

	@Test
	public void deleteTask() throws Exception {
	}

	@AfterEach
	public void tearDown() throws Exception {
		taskManagementService = null;
	}

}
