package com.todo.todo_operation.repository;

import com.todo.todo_operation.models.task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<task,Long>{

}
