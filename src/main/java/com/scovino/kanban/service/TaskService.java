package com.scovino.kanban.service;

import java.util.List;

import com.scovino.kanban.model.Task;

public interface TaskService {
	Task saveTask(Task task);
	List<Task> getAllTasks();
	Task getTaskById(Long id);
	Task updateTask(Long id, Task task);
	Task deleteTask(Long id);
}
