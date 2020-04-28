package com.kingshuk.testing.powermock.dao;

import java.sql.SQLException;
import java.util.List;

import com.kingshuk.testing.powermock.model.TaskModel;

public interface TaskManagementDAO {
	void addTask(TaskModel taskModel) throws SQLException, ClassNotFoundException;

    List<TaskModel> getAllTask() throws SQLException, ClassNotFoundException;

}
