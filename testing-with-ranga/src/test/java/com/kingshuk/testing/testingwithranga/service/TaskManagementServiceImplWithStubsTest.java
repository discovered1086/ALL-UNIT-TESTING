package com.kingshuk.testing.testingwithranga.service;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.kingshuk.testing.testingwithranga.exceptions.TaskManagementException;
import com.kingshuk.testing.testingwithranga.model.TaskModel;
import com.kingshuk.testing.testingwithranga.model.dao.TaskManagementDAO;
import com.kingshuk.testing.testingwithranga.model.utility.ConnectionManager;

class TaskManagementDAOImpl implements TaskManagementDAO {

    @Override
    public List<TaskModel> getAllTask() throws SQLException, ClassNotFoundException {
        TaskModel taskModel = new TaskModel();
        taskModel.setTaskId(1);
        taskModel.setTaskTitle("To wake up early");
        taskModel.setTaskDescription("To wake up early");

        TaskModel taskModel2 = new TaskModel();
        taskModel2.setTaskId(2);
        taskModel2.setTaskTitle("Completing Ranga's course");
        taskModel2.setTaskDescription("To complete the unit testing course of Ranga Karanam");

        return Arrays.asList(taskModel, taskModel2);
    }

    @Override
    public boolean deleteTask(Integer taskId) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public void setConnectionManager(ConnectionManager connectionManager) {

    }
}

public class TaskManagementServiceImplWithStubsTest {

    private TaskManagementDAO taskManagementDAO;

    @Test
    public void getAllTask() throws TaskManagementException {
        TaskManagementService service = new TaskManagementServiceImpl();
        service.setTaskManagementDAO(new TaskManagementDAOImpl());

        List<TaskModel> allTask = service.getAllTask();

        assertEquals(2, allTask.size());

    }
}