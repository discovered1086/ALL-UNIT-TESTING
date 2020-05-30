package com.kingshuk.testing.mockito.service;

import java.util.List;

import com.kingshuk.testing.mockito.dao.TaskManagementDAO;
import com.kingshuk.testing.mockito.exceptions.TaskManagementException;
import com.kingshuk.testing.mockito.model.TaskModel;

public interface TaskManagementService {
	void addTask(TaskModel taskModel) throws TaskManagementException;

    List<TaskModel> getAllTask() throws TaskManagementException;

    boolean updateTask(TaskModel taskModel) throws TaskManagementException;

    boolean deleteTask(Integer taskId) throws TaskManagementException;

    void setTaskManagementDAO(TaskManagementDAO taskManagementDAO);
}
