package com.kingshuk.testing.powermock.database;

import java.util.ArrayList;
import java.util.List;

import com.kingshuk.testing.powermock.model.TaskModel;

public final class PowerMockDatabase {
	private static final PowerMockDatabase OBJECT_INSTANCE = new PowerMockDatabase();

	private static final List<TaskModel> tasksList = new ArrayList<>();

	private PowerMockDatabase() {
	}

	public static final PowerMockDatabase createNewInstance() {
		return OBJECT_INSTANCE;
	}

	public static final List<TaskModel> getAllTasks() {
		List<TaskModel> allTasks = new ArrayList<>();

		tasksList.forEach(task -> {
			TaskModel newTask = new TaskModel(task.getTaskId(), task.getTaskTitle(), task.getTaskDescription(),
					task.getTaskDueDate(), task.getTaskOwner());
			allTasks.add(newTask);
		});
		return allTasks;
	}

	public static final void addTask(TaskModel task) {
		tasksList.add(task);
	}

}
