package com.kingshuk.testing.mockito.service;

import java.util.List;

import com.kingshuk.testing.mockito.dao.TaskManagementDAO;
import com.kingshuk.testing.mockito.dao.TaskManagementDAOImpl;
import com.kingshuk.testing.mockito.exceptions.TaskManagementException;
import com.kingshuk.testing.mockito.model.TaskModel;

public class TaskManagementServiceImpl implements TaskManagementService {

	private TaskManagementDAO taskManagementDAO=null;

    public TaskManagementServiceImpl() {
        this.taskManagementDAO = new TaskManagementDAOImpl();
    }

    @Override
    public void addTask(TaskModel taskModel) throws TaskManagementException {
        try{
           taskManagementDAO.addTask(taskModel);
        }catch (Exception ex){
            ex.printStackTrace();
            throw new TaskManagementException(ex);
        }
    }

    @Override
    public List<TaskModel> getAllTask() throws TaskManagementException{
        try{
            return taskManagementDAO.getAllTask();
        }catch (Exception ex){
            ex.printStackTrace();
            throw new TaskManagementException(ex);
        }
    }

    @Override
    public boolean updateTask(TaskModel taskModel) throws TaskManagementException{
        try{
           return taskManagementDAO.updateTask(taskModel);
        }catch (Exception ex){
            ex.printStackTrace();
            throw new TaskManagementException(ex);
        }
    }

    @Override
    public boolean deleteTask(Integer taskId) throws TaskManagementException{
        try{
            return taskManagementDAO.deleteTask(taskId);
        }catch (Exception ex){
            ex.printStackTrace();
            throw new TaskManagementException(ex);
        }
    }

    public void setTaskManagementDAO(TaskManagementDAO taskManagementDAO) {
        this.taskManagementDAO = taskManagementDAO;
    }

}
