package com.kingshuk.testing.testingwithranga.model.dao;


import com.kingshuk.testing.testingwithranga.model.TaskModel;
import com.kingshuk.testing.testingwithranga.model.utility.ConnectionManager;

import java.sql.SQLException;
import java.util.List;

public interface TaskManagementDAO {
	List<TaskModel> getAllTask() throws SQLException, ClassNotFoundException;

    boolean deleteTask(Integer taskId) throws SQLException, ClassNotFoundException;

    void setConnectionManager(ConnectionManager connectionManager);
}
