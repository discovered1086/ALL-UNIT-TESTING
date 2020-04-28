package com.kingshuk.testing.powermock.dao;

import java.sql.SQLException;
import java.util.List;

import com.kingshuk.testing.powermock.database.PowerMockDatabase;
import com.kingshuk.testing.powermock.model.TaskModel;

public class TaskManagementDAOImpl implements TaskManagementDAO {
	

	@Override
	public void addTask(TaskModel taskModel) throws SQLException, ClassNotFoundException {
		PowerMockDatabase.addTask(taskModel);
	}

	@Override
	public List<TaskModel> getAllTask() throws SQLException, ClassNotFoundException {
		return PowerMockDatabase.getAllTasks();
	}

}
