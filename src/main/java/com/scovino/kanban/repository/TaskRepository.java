package com.scovino.kanban.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scovino.kanban.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
