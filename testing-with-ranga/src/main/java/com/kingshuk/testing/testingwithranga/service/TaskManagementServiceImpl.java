package com.kingshuk.testing.testingwithranga.service;


import com.kingshuk.testing.testingwithranga.exceptions.TaskManagementException;
import com.kingshuk.testing.testingwithranga.model.TaskModel;
import com.kingshuk.testing.testingwithranga.model.dao.TaskManagementDAO;
import com.kingshuk.testing.testingwithranga.model.dao.TaskManagementDAOImpl;

import java.util.List;

public class TaskManagementServiceImpl implements TaskManagementService {

	private TaskManagementDAO taskManagementDAO;

    public TaskManagementServiceImpl() {
        this.taskManagementDAO = new TaskManagementDAOImpl();
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
