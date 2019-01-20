package mypractice.unittesting.mockito.service;

import mypractice.unittesting.mockito.TaskManagementException;
import mypractice.unittesting.mockito.model.TaskModel;
import mypractice.unittesting.mockito.model.dao.TaskManagementDAO;

import java.util.List;

/**
 * Created by kingshuk on 8/27/17.
 */
public interface TaskManagementService {

    boolean addTask(TaskModel taskModel) throws TaskManagementException;

    List<TaskModel> getAllTask() throws TaskManagementException;

    boolean updateTask(TaskModel taskModel) throws TaskManagementException;

    boolean deleteTask(Integer taskId) throws TaskManagementException;

    void setTaskManagementDAO(TaskManagementDAO taskManagementDAO);
}
