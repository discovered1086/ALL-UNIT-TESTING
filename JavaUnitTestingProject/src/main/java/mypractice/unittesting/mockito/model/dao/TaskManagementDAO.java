package mypractice.unittesting.mockito.model.dao;

import java.sql.SQLException;
import java.util.List;

import mypractice.unittesting.mockito.model.TaskModel;
import mypractice.unittesting.mockito.utility.ConnectionManager;

/**
 * Created by kingshuk on 8/27/17.
 */
public interface TaskManagementDAO {

    boolean addTask(TaskModel taskModel) throws SQLException, ClassNotFoundException;

    List<TaskModel> getAllTask() throws SQLException, ClassNotFoundException;

    boolean updateTask(TaskModel taskModel) throws SQLException, ClassNotFoundException;

    boolean deleteTask(Integer taskId) throws SQLException, ClassNotFoundException;

    void setConnectionManager(ConnectionManager connectionManager);
}
