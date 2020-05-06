package com.kingshuk.testing.testingwithranga.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class TaskModel {
	private Integer taskId;

	private String taskTitle;

	private String taskDescription;

	private String taskDueDate;

	private String taskOwner;
}
