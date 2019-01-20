package mypractice.unittesting.mockito;

import mypractice.unittesting.mockito.model.TaskModel;
import mypractice.unittesting.mockito.service.TaskManagementService;
import mypractice.unittesting.mockito.service.TaskManagementServiceImpl;

/**
 * Created by kingshuk on 8/27/17.
 */
public class TestingClient {

    private TaskManagementService taskManagementService = null;

    public static void main(String[] args) {
        new TestingClient().doHandleAllRequest(1);
    }

    public void setUp() {
        taskManagementService = new TaskManagementServiceImpl();
    }

    public void doHandleAllRequest(Integer requestType) {
        setUp();
        switch (requestType) {
            case 1:
                TaskModel taskModel = new TaskModel();
                taskModel.setTaskId(1);
                taskModel.setTaskTitle("To wake up early");
                taskModel.setTaskDescription("To wake up early");
                taskModel.setTaskDueDate("08/25/2017");
                taskModel.setTaskOwner("Kingshuk");

                try {
                    taskManagementService.addTask(taskModel);
                } catch (TaskManagementException e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                TaskModel model2 = new TaskModel();
                break;
            case 3:
                TaskModel model3 = new TaskModel();
                break;
            case 4:
                TaskModel model4 = new TaskModel();
                break;
            case 5:
                TaskModel model5 = new TaskModel();
                break;
        }
    }
}
