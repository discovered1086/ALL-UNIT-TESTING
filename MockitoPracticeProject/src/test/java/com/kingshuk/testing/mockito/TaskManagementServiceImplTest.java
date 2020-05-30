package com.kingshuk.testing.mockito;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.kingshuk.testing.mockito.dao.TaskManagementDAOImpl;
import com.kingshuk.testing.mockito.exceptions.TaskManagementException;
import com.kingshuk.testing.mockito.model.TaskModel;
import com.kingshuk.testing.mockito.service.TaskManagementServiceImpl;

public class TaskManagementServiceImplTest {

	@Mock
	private TaskManagementDAOImpl theDaoImpl;

	@InjectMocks
	private TaskManagementServiceImpl service;

	@BeforeEach
	public void classCreation() {
		MockitoAnnotations.initMocks(this);

	}

	@Test
	public void test_addTask_Method_Should_Be_Successful()
			throws TaskManagementException, ClassNotFoundException, SQLException {
		TaskModel taskModel = new TaskModel();

		doNothing().doThrow(ClassNotFoundException.class).when(theDaoImpl).addTask(taskModel);

		service.addTask(taskModel);

		assertThrows(TaskManagementException.class, () -> {
			service.addTask(taskModel);
		});

		verify(theDaoImpl, times(2)).addTask(taskModel);
	}

}
