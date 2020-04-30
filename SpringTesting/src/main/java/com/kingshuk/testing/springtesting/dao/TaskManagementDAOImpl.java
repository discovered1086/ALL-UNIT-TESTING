package com.kingshuk.testing.springtesting.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.kingshuk.testing.springtesting.model.TaskModel;

@Repository
public class TaskManagementDAOImpl implements TaskManagementDAO {
	
	private static final List<TaskModel> taskList = new ArrayList<>();

	@Override
	public void addTask(TaskModel taskModel) throws SQLException, ClassNotFoundException {
		taskList.add(taskModel);
	}

	@Override
	public List<TaskModel> getAllTask() throws SQLException, ClassNotFoundException {
		return new ArrayList<>(taskList);
	}

	@Override
	public boolean updateTask(TaskModel taskModel) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteTask(Integer taskId) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return false;
	}

}
