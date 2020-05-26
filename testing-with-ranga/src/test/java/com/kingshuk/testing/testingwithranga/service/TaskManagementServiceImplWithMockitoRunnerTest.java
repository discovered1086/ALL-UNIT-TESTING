package com.kingshuk.testing.testingwithranga.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atMostOnce;
import static org.mockito.Mockito.verify;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.kingshuk.testing.testingwithranga.exceptions.TaskManagementException;
import com.kingshuk.testing.testingwithranga.model.TaskModel;
import com.kingshuk.testing.testingwithranga.model.dao.TaskManagementDAO;

@RunWith(MockitoJUnitRunner.class)
public class TaskManagementServiceImplWithMockitoRunnerTest {

	@Mock
	private TaskManagementDAO taskManagementDAO;

	@InjectMocks
	private TaskManagementService service = new TaskManagementServiceImpl();

//    @Before
//    public void setUp(){
//        MockitoAnnotations.initMocks(this);
//    }

	@Test
	public void getAllTask() throws TaskManagementException, SQLException, ClassNotFoundException {
		TaskModel taskModel = new TaskModel();
		taskModel.setTaskId(1);
		taskModel.setTaskTitle("To wake up early");
		taskModel.setTaskDescription("To wake up early");

		TaskModel taskModel2 = new TaskModel();
		taskModel2.setTaskId(2);
		taskModel2.setTaskTitle("Completing Ranga's course");
		taskModel2.setTaskDescription("To complete the unit testing course of Ranga Karanam");

		when(taskManagementDAO.getAllTask()).thenReturn(Arrays.asList(taskModel, taskModel2));

		List<TaskModel> allTask = service.getAllTask();

		assertEquals(2, allTask.size());

	}

	@Test
	public void getAllTask_No_Data() throws TaskManagementException, SQLException, ClassNotFoundException {
		TaskModel taskModel2 = new TaskModel();
		taskModel2.setTaskId(2);
		taskModel2.setTaskTitle("Completing Ranga's course");
		taskModel2.setTaskDescription("To complete the unit testing course of Ranga Karanam");

		when(taskManagementDAO.getAllTask()).thenReturn(new ArrayList<>());

		List<TaskModel> allTask = service.getAllTask();

		assertEquals(0, allTask.size());

	}

	@Test
	public void deleteTask() throws TaskManagementException, SQLException, ClassNotFoundException {
		when(taskManagementDAO.deleteTask(anyInt())).thenReturn(true);

		assertTrue(service.deleteTask(6));
		
		verify(taskManagementDAO).deleteTask(6);
		verify(taskManagementDAO, atMostOnce()).deleteTask(anyInt());
	}
}