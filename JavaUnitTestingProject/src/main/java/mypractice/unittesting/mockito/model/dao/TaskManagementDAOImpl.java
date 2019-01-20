package mypractice.unittesting.mockito.model.dao;

import mypractice.unittesting.mockito.DataProcessingException;
import mypractice.unittesting.mockito.model.TaskModel;
import mypractice.unittesting.mockito.utility.ConnectionManager;

import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kingshuk on 8/27/17.
 */
public class TaskManagementDAOImpl implements TaskManagementDAO {

    private ConnectionManager connectionManager;

    public TaskManagementDAOImpl() {
        connectionManager = new ConnectionManager();
    }

    public void setConnectionManager(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    @Override
    public boolean addTask(TaskModel taskModel) throws SQLException, ClassNotFoundException {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = connectionManager.getMyConnection();
            ps = connection.prepareStatement("INSERT INTO mockito_test_task " +
                    "VALUES(mockito_sequence.nextval, ?,?,?,?)");
            ps.setString(1, taskModel.getTaskTitle());
            ps.setString(2, taskModel.getTaskDescription());
            ps.setString(3, taskModel.getTaskDueDate());
            ps.setString(4, taskModel.getTaskOwner());

            int insert=ps.executeUpdate();

            if(insert==0){
                return false;
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            try {

                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (Exception sql) {
                sql.printStackTrace();
            }
        }
        return true;
    }

    @Override
    public List<TaskModel> getAllTask() throws SQLException, ClassNotFoundException {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        List<TaskModel> taskModelList = new ArrayList<>();
        try {
            connection = connectionManager.getMyConnection();
            ps = connection.prepareStatement("SELECT * FROM mockito_test_task");
            resultSet = ps.executeQuery();

            while (resultSet.next()) {
                TaskModel taskModel = new TaskModel();
                taskModel.setTaskId(resultSet.getInt(1));
                taskModel.setTaskTitle(resultSet.getString(2));
                taskModel.setTaskDescription(resultSet.getString(3));
                taskModel.setTaskDueDate(resultSet.getString(4));
                taskModel.setTaskOwner(resultSet.getString(5));
                taskModelList.add(taskModel);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            try {

                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (Exception sql) {
                sql.printStackTrace();
            }
        }

        return taskModelList;
    }

    @Override
    public boolean updateTask(TaskModel taskModel) throws SQLException, ClassNotFoundException {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = connectionManager.getMyConnection();
            ps = connection.prepareStatement("UPDATE mockito_test_task SET task_title=?, " +
                    "task_desc=?, task_due_date=?, task_owner=? WHERE task_id=?");
            ps.setString(1, taskModel.getTaskTitle());
            ps.setString(2, taskModel.getTaskDescription());
            ps.setString(3, taskModel.getTaskDueDate());
            ps.setString(4, taskModel.getTaskOwner());
            ps.setInt(5, taskModel.getTaskId());
            int update = ps.executeUpdate();

            if(update==0){
               return false;
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            try {

                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (Exception sql) {
                sql.printStackTrace();
            }
        }

        return true;
    }

    @Override
    public boolean deleteTask(Integer taskId) throws SQLException, ClassNotFoundException {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = connectionManager.getMyConnection();
            ps = connection.prepareStatement("DELETE FROM mockito_test_task WHERE task_id=?");
            ps.setInt(1, taskId);

            int delete = ps.executeUpdate();
            if(delete==0){
                return false;
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            try {

                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (Exception sql) {
                sql.printStackTrace();
            }
        }
        return true;
    }
}
