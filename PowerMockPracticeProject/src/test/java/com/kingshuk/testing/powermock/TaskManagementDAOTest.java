package com.kingshuk.testing.powermock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.verifyStatic;
import static org.powermock.api.mockito.PowerMockito.when;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.kingshuk.testing.powermock.dao.TaskManagementDAO;
import com.kingshuk.testing.powermock.dao.TaskManagementDAOImpl;
import com.kingshuk.testing.powermock.database.PowerMockDatabase;
import com.kingshuk.testing.powermock.model.TaskModel;

@RunWith(PowerMockRunner.class)
@PrepareForTest(PowerMockDatabase.class)
public class TaskManagementDAOTest {

	@Test
	public void testGetAllTasks() throws ClassNotFoundException, SQLException {
		TaskModel taskModel = new TaskModel();
		taskModel.setTaskId(1);
		taskModel.setTaskTitle("To wake up early");
		taskModel.setTaskDescription("To wake up early");
		taskModel.setTaskOwner("Kingshuk");
		taskModel.setTaskDueDate("08/21/2018");

		TaskModel taskModel2 = new TaskModel();
		taskModel2.setTaskId(1);
		taskModel2.setTaskTitle("To complete Junit training");
		taskModel2.setTaskDescription("To wake up early and complete the Junit training by Bharath");
		taskModel2.setTaskOwner("Kingshuk");
		taskModel2.setTaskDueDate("09/03/2017");

		List<TaskModel> taskList = Arrays.asList(taskModel, taskModel2);

		TaskManagementDAO taskManagementDAO = new TaskManagementDAOImpl();

		mockStatic(PowerMockDatabase.class);
		when(PowerMockDatabase.getAllTasks()).thenReturn(taskList);

		List<TaskModel> allTask = taskManagementDAO.getAllTask();

		assertEquals(2, allTask.size());
		
		verifyStatic(PowerMockDatabase.class);
		PowerMockDatabase.getAllTasks();
	}

}
