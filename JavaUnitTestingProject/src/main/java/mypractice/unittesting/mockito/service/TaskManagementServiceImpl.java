package mypractice.unittesting.mockito.service;


import mypractice.unittesting.mockito.TaskManagementException;
import mypractice.unittesting.mockito.model.TaskModel;
import mypractice.unittesting.mockito.model.dao.TaskManagementDAO;
import mypractice.unittesting.mockito.model.dao.TaskManagementDAOImpl;

import java.util.List;

/**
 * Created by kingshuk on 8/27/17.
 */
public class TaskManagementServiceImpl implements TaskManagementService{
    private TaskManagementDAO taskManagementDAO=null;

    public TaskManagementServiceImpl() {
        this.taskManagementDAO = new TaskManagementDAOImpl();
    }

    @Override
    public boolean addTask(TaskModel taskModel) throws TaskManagementException {
        try{
           return taskManagementDAO.addTask(taskModel);
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
