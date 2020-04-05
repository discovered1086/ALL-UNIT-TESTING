package com.kingshuk.testing.practice.service;

import java.util.List;

import com.kingshuk.testing.practice.exceptions.TaskManagementException;
import com.kingshuk.testing.practice.model.TaskModel;
import com.kingshuk.testing.practice.model.dao.TaskManagementDAO;

public interface TaskManagementService {
	boolean addTask(TaskModel taskModel) throws TaskManagementException;

    List<TaskModel> getAllTask() throws TaskManagementException;

    boolean updateTask(TaskModel taskModel) throws TaskManagementException;

    boolean deleteTask(Integer taskId) throws TaskManagementException;

    void setTaskManagementDAO(TaskManagementDAO taskManagementDAO);
}
