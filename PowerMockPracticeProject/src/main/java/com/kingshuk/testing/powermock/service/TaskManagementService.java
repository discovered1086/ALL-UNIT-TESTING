package com.kingshuk.testing.powermock.service;

import java.util.List;

import com.kingshuk.testing.powermock.dao.TaskManagementDAO;
import com.kingshuk.testing.powermock.exceptions.TaskManagementException;
import com.kingshuk.testing.powermock.model.TaskModel;

public interface TaskManagementService {
	void addTask(TaskModel taskModel) throws TaskManagementException;

    List<TaskModel> getAllTask() throws TaskManagementException;

    void setTaskManagementDAO(TaskManagementDAO taskManagementDAO);
}
