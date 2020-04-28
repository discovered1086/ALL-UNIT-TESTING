package com.kingshuk.testing.powermock.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class TaskModel {
	private Integer taskId;

	private String taskTitle;

	private String taskDescription;

	private String taskDueDate;

	private String taskOwner;
}
