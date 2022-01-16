package com.scovino.kanban.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.scovino.kanban.model.Task;
import com.scovino.kanban.service.TaskService;

@Controller
@RequestMapping("/api/tasks/")
public class TaskController {

	private TaskService taskService;

	public TaskController(TaskService taskService) {
		super();
		this.taskService = taskService;
	}
	
	
	// Create a Task
	@PostMapping()
	public ResponseEntity<Task> createTask(@RequestBody Task task) {
		return new ResponseEntity<Task>(taskService.saveTask(task), HttpStatus.CREATED);
	}
	
	
	// Retrieve All Tasks
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping()
	public ResponseEntity<List<Task>> getAllTasks() {
		return new ResponseEntity<List<Task>>(taskService.getAllTasks(), HttpStatus.OK);
	}
	
	
	// Get Task by Id
	@GetMapping("{id}")
	public ResponseEntity<Task> getTaskById(@PathVariable("id") long id) {
		return new ResponseEntity<Task>(taskService.getTaskById(id), HttpStatus.OK);
	}
	
	
	// Update Task by Id
	@PutMapping("{id}")
	public ResponseEntity<Task> updateTask(@PathVariable("id") Long id, @RequestBody Task task) {
		return new ResponseEntity<Task>(taskService.updateTask(id, task), HttpStatus.OK);
	}
	
	
	// Delete Task by Id
	@DeleteMapping("{id}")
	public ResponseEntity<Task> deleteTaskById(@PathVariable("id") Long id){
		return new ResponseEntity<Task>(taskService.deleteTask(id), HttpStatus.OK);
	}
}
