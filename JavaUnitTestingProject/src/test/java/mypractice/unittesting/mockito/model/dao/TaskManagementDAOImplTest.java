package mypractice.unittesting.mockito.model.dao;

import mypractice.unittesting.mockito.model.TaskModel;
import mypractice.unittesting.mockito.utility.ConnectionManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.matchers.Null;

import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

/**
 * Created by kingshuk on 9/2/17.
 */

public class TaskManagementDAOImplTest {

    private TaskManagementDAO taskManagementDAO;

    @Mock
    private ConnectionManager connectionManager;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        taskManagementDAO=new TaskManagementDAOImpl();

        Field privateField=ConnectionManager.class.getDeclaredField("connectionDriver");
        Field privateField2=ConnectionManager.class.getDeclaredField("url");
        Field privateField3=ConnectionManager.class.getDeclaredField("dbname");
        Field privateField4=ConnectionManager.class.getDeclaredField("username");
        Field privateField5=ConnectionManager.class.getDeclaredField("password");

        privateField.setAccessible(true);
        privateField2.setAccessible(true);
        privateField3.setAccessible(true);
        privateField4.setAccessible(true);
        privateField5.setAccessible(true);

        privateField.set(connectionManager, "oracle.jdbc.driver.OracleDriver");
        privateField2.set(connectionManager, "jdbc:oracle:thin:@192.168.0.9:1521:");
        privateField3.set(connectionManager, "mydatabase");
        privateField4.set(connectionManager, "servlet_training");
        privateField5.set(connectionManager, "Iofdtiger#16");

        taskManagementDAO.setConnectionManager(connectionManager);
    }

    @Test
    public void addTask_insert_record_successfully() throws Exception {
        
        TaskModel taskModel = new TaskModel();
        //taskModel.setTaskId(1);
        taskModel.setTaskTitle("To wake up early");
        taskModel.setTaskDescription("To wake up early");
        taskModel.setTaskOwner("Kingshuk");
        taskModel.setTaskDueDate("08/21/2018");


        when(connectionManager.getMyConnection()).thenCallRealMethod();

        Boolean result=taskManagementDAO.addTask(taskModel);

        assertTrue(result);

        verify(connectionManager, atLeast(1)).getMyConnection();
    }

    @Test(expected = NullPointerException.class)
    public void addTask_throw_NullPinterException() throws Exception {

        when(connectionManager.getMyConnection()).thenCallRealMethod();

        taskManagementDAO.addTask(null);

        //assertTrue(result);

        //verify(connectionManager, atLeast(1)).getMyConnection();
    }


    @Test(expected = NullPointerException.class)
    public void addTask_throw_NullPinterException_On_Connection() throws Exception {
        TaskModel taskModel = new TaskModel();
        //taskModel.setTaskId(1);
        taskModel.setTaskTitle("To wake up early");
        taskModel.setTaskDescription("To wake up early");
        taskModel.setTaskOwner("Kingshuk");
        taskModel.setTaskDueDate("08/21/2018");


        when(connectionManager.getMyConnection()).thenReturn(null);

        taskManagementDAO.addTask(taskModel);

        //assertTrue(result);

        //verify(connectionManager, atLeast(1)).getMyConnection();
    }

    @Test(expected = SQLException.class)
    public void addTask_throws_SQLException_On_title() throws Exception {
        TaskModel taskModel = new TaskModel();
        //taskModel.setTaskId(1);
        taskModel.setTaskTitle(null);
        taskModel.setTaskDescription("To wake up early");
        taskModel.setTaskOwner("Kingshuk");
        taskModel.setTaskDueDate("08/21/2018");


        when(connectionManager.getMyConnection()).thenCallRealMethod();

        taskManagementDAO.addTask(taskModel);

        //assertTrue(result);

        //verify(connectionManager, atLeast(1)).getMyConnection();
    }

    @Test(expected = SQLException.class)
    public void addTask_throws_SQLException_On_task_owner() throws Exception {
        TaskModel taskModel = new TaskModel();
        //taskModel.setTaskId(1);
        taskModel.setTaskTitle("To wake up early");
        taskModel.setTaskDescription("To wake up early");
        taskModel.setTaskOwner("dfsdggggsgddfsdggggsgddfsdggggsgddfsdggggsgddfsdggggsgd");
        taskModel.setTaskDueDate("08/21/2018");


        when(connectionManager.getMyConnection()).thenCallRealMethod();

        taskManagementDAO.addTask(taskModel);

        //assertTrue(result);

        //verify(connectionManager, atLeast(1)).getMyConnection();
    }

    @Test
    public void getAllTask() throws Exception {

        when(connectionManager.getMyConnection()).thenCallRealMethod();

        List<TaskModel> taskModelList=taskManagementDAO.getAllTask();

        assertTrue(taskModelList.size()>0);

        verify(connectionManager, atLeast(1)).getMyConnection();
    }


    @Test(expected = NullPointerException.class)
    public void getAllTAsk_Throws_NullPointerException() throws Exception {

        when(connectionManager.getMyConnection()).thenReturn(null);

        taskManagementDAO.addTask(null);

        //assertTrue(result);

        //verify(connectionManager, atLeast(1)).getMyConnection();
    }

    @Test
    public void updateTask_Successfully_Updated() throws Exception {

        TaskModel taskModel = new TaskModel();
        taskModel.setTaskId(1);
        taskModel.setTaskTitle("To complete Junit training");
        taskModel.setTaskDescription("To wake up early and complete the Junit training by Bharath");
        taskModel.setTaskOwner("Kingshuk");
        taskModel.setTaskDueDate("09/03/2017");

        when(connectionManager.getMyConnection()).thenCallRealMethod();

        assertTrue(taskManagementDAO.updateTask(taskModel));

        verify(connectionManager, atLeast(1)).getMyConnection();
    }

    @Test
    public void updateTask_Task_Not_Found() throws Exception {

        TaskModel taskModel = new TaskModel();
        taskModel.setTaskId(25);
        taskModel.setTaskTitle("To complete Junit training");
        taskModel.setTaskDescription("To wake up early and complete the Junit training by Bharath");
        taskModel.setTaskOwner("Kingshuk");
        taskModel.setTaskDueDate("09/03/2017");

        when(connectionManager.getMyConnection()).thenCallRealMethod();

        assertFalse(taskManagementDAO.updateTask(taskModel));

        verify(connectionManager, atLeast(1)).getMyConnection();
    }

    @Test(expected = NullPointerException.class)
    public void updateTask_Throws_NullPointerException_Because_Of_Null_Input() throws Exception {

        when(connectionManager.getMyConnection()).thenCallRealMethod();

        taskManagementDAO.updateTask(null);

        //verify(connectionManager, atLeast(1)).getMyConnection();
    }


    @Test(expected = NullPointerException.class)
    public void updateTask_Throws_NullPointerException_On_Connection() throws Exception {

        TaskModel taskModel = new TaskModel();
        taskModel.setTaskId(6);
        taskModel.setTaskTitle("To complete Junit training");
        taskModel.setTaskDescription("To wake up early and complete the Junit training by Bharath");
        taskModel.setTaskOwner("Kingshuk");
        taskModel.setTaskDueDate("09/03/2017");

        when(connectionManager.getMyConnection()).thenReturn(null);

        taskManagementDAO.updateTask(taskModel);

        //assertFalse(taskManagementDAO.updateTask(taskModel));

        //verify(connectionManager, atLeast(1)).getMyConnection();
    }


    @Test(expected = SQLException.class)
    public void updateTask_Throws_SQLException_On_Task_Owner() throws Exception {

        TaskModel taskModel = new TaskModel();
        taskModel.setTaskId(5);
        taskModel.setTaskTitle("To complete Junit training");
        taskModel.setTaskDescription("To wake up early and complete the Junit training by Bharath");
        taskModel.setTaskOwner("dfsdggggsgddfsdggggsgddfsdggggsgddfsdggggsgddfsdggggsgd");
        taskModel.setTaskDueDate("09/03/2017");

        when(connectionManager.getMyConnection()).thenCallRealMethod();

        taskManagementDAO.updateTask(taskModel);

        //assertFalse(taskManagementDAO.updateTask(taskModel));

        //verify(connectionManager, atLeast(1)).getMyConnection();
    }


    @Test(expected = SQLException.class)
    public void updateTask_Throws_SQLException_On_Task_Title_Being_Null() throws Exception {

        TaskModel taskModel = new TaskModel();
        taskModel.setTaskId(5);
        taskModel.setTaskTitle(null);
        taskModel.setTaskDescription("To wake up early and complete the Junit training by Bharath");
        taskModel.setTaskOwner("Kingshuk");
        taskModel.setTaskDueDate("09/03/2017");

        when(connectionManager.getMyConnection()).thenCallRealMethod();

        taskManagementDAO.updateTask(taskModel);

        //assertFalse(taskManagementDAO.updateTask(taskModel));

        //verify(connectionManager, atLeast(1)).getMyConnection();
    }


    @Test
    public void deleteTask_performs_delete() throws Exception {

        when(connectionManager.getMyConnection()).thenCallRealMethod();

        assertTrue(taskManagementDAO.deleteTask(4));

        verify(connectionManager, atLeast(1)).getMyConnection();
    }


    @Test
    public void deleteTask_task_not_found() throws Exception {

        when(connectionManager.getMyConnection()).thenCallRealMethod();

        assertFalse(taskManagementDAO.deleteTask(11));

        verify(connectionManager, atLeast(1)).getMyConnection();
    }


    @Test(expected = NullPointerException.class)
    public void deleteTask_Throws_NullPointerException_On_Connection() throws Exception {

        when(connectionManager.getMyConnection()).thenReturn(null);

        taskManagementDAO.deleteTask(2);

        //verify(connectionManager, atLeast(1)).getMyConnection();
    }

    @Test(expected = NullPointerException.class)
    public void deleteTask_Throws_NullPointerException_On_Input() throws Exception {

        when(connectionManager.getMyConnection()).thenCallRealMethod();

        taskManagementDAO.deleteTask(null);

        //verify(connectionManager, atLeast(1)).getMyConnection();
    }


    @After
    public void tearDown() throws Exception {
        connectionManager=null;
        taskManagementDAO=null;
    }
}