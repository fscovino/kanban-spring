package com.scovino.kanban.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.scovino.kanban.exception.ResourceNotFoundException;
import com.scovino.kanban.model.Task;
import com.scovino.kanban.repository.TaskRepository;
import com.scovino.kanban.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {
	
	private TaskRepository taskRepository;
	
	
	public TaskServiceImpl(TaskRepository taskRepository) {
		super();
		this.taskRepository = taskRepository;
	}


	@Override
	public Task saveTask(Task task) {
		return taskRepository.save(task);
	}
	
	
	@Override
	public List<Task> getAllTasks() {
		return taskRepository.findAll();
	}


	@Override
	public Task getTaskById(Long id) {
		return taskRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Task", "Id", id));
	}


	@Override
	public Task updateTask(Long id, Task task) {
		// Verify task exist on the database
		Task existingTask = taskRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Task", "Id", id));
		// Update fields
		existingTask.setAssignedTo(task.getAssignedTo());
		existingTask.setDate(task.getDate());
		existingTask.setDescription(task.getDescription());
		existingTask.setStatus(task.getStatus());
		existingTask.setTitle(task.getTitle());
		// Save Task updated
		taskRepository.save(existingTask);
		return existingTask;
	}


	@Override
	public Task deleteTask(Long id) {
		// Verify task exist on the database
		Task existingTask = taskRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Task", "Id", id));
		taskRepository.deleteById(id);
		return existingTask;
	}
}
