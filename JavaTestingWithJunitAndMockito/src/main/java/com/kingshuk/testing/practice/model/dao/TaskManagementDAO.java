package com.kingshuk.testing.practice.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.kingshuk.testing.practice.model.TaskModel;
import com.kingshuk.testing.practice.model.utility.ConnectionManager;

public interface TaskManagementDAO {
	boolean addTask(TaskModel taskModel) throws SQLException, ClassNotFoundException;

    List<TaskModel> getAllTask() throws SQLException, ClassNotFoundException;

    boolean updateTask(TaskModel taskModel) throws SQLException, ClassNotFoundException;

    boolean deleteTask(Integer taskId) throws SQLException, ClassNotFoundException;

    void setConnectionManager(ConnectionManager connectionManager);
}
