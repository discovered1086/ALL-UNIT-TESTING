package com.kingshuk.testing.springtesting.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kingshuk.testing.springtesting.dao.TaskManagementDAO;
import com.kingshuk.testing.springtesting.exceptions.TaskManagementException;
import com.kingshuk.testing.springtesting.model.TaskModel;

@Service
public class TaskManagementServiceImpl implements TaskManagementService {

	private TaskManagementDAO taskManagementDAO;
	
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

	@Override
	public boolean updateTask(TaskModel taskModel) throws TaskManagementException {
		try {
			return taskManagementDAO.updateTask(taskModel);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new TaskManagementException(ex);
		}
	}

	@Override
	public boolean deleteTask(Integer taskId) throws TaskManagementException {
		try {
			return taskManagementDAO.deleteTask(taskId);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new TaskManagementException(ex);
		}
	}

	@Autowired
	public void setTaskManagementDAO(TaskManagementDAO taskManagementDAO) {
		this.taskManagementDAO = taskManagementDAO;
	}

}
