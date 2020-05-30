package com.kingshuk.testing.mockito.dao;

import java.sql.SQLException;
import java.util.List;

import com.kingshuk.testing.mockito.model.TaskModel;

public interface TaskManagementDAO {
	void addTask(TaskModel taskModel) throws SQLException, ClassNotFoundException;

    List<TaskModel> getAllTask() throws SQLException, ClassNotFoundException;

    boolean updateTask(TaskModel taskModel) throws SQLException, ClassNotFoundException;

    boolean deleteTask(Integer taskId) throws SQLException, ClassNotFoundException;

}
