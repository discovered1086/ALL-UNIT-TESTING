package com.kingshuk.testing.testingwithranga.service;


import com.kingshuk.testing.testingwithranga.exceptions.TaskManagementException;
import com.kingshuk.testing.testingwithranga.model.TaskModel;
import com.kingshuk.testing.testingwithranga.model.dao.TaskManagementDAO;

import java.util.List;

public interface TaskManagementService {
	List<TaskModel> getAllTask() throws TaskManagementException;

    boolean deleteTask(Integer taskId) throws TaskManagementException;

    void setTaskManagementDAO(TaskManagementDAO taskManagementDAO);
}
