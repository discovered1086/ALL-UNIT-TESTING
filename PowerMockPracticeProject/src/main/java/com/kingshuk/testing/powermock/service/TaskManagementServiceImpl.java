package com.kingshuk.testing.powermock.service;

import java.util.List;

import com.kingshuk.testing.powermock.dao.TaskManagementDAO;
import com.kingshuk.testing.powermock.exceptions.TaskManagementException;
import com.kingshuk.testing.powermock.model.TaskModel;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class TaskManagementServiceImpl implements TaskManagementService {

	private TaskManagementDAO taskManagementDAO = null;

	@Override
	public void addTask(TaskModel taskModel) throws TaskManagementException {
		try {
			taskManagementDAO.addTask(taskModel);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new TaskManagementException(ex);
		}
	}

	@Override
	public List<TaskModel> getAllTask() throws TaskManagementException {
		try {
			return taskManagementDAO.getAllTask();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new TaskManagementException(ex);
		}
	}

	public void setTaskManagementDAO(TaskManagementDAO taskManagementDAO) {
		this.taskManagementDAO = taskManagementDAO;
	}

}
