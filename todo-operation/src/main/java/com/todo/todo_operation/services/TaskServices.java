package com.todo.todo_operation.services;

import com.todo.todo_operation.models.task;
import com.todo.todo_operation.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServices {

    private final TaskRepository taskrepository;

    public TaskServices(TaskRepository taskrepository) {
        this.taskrepository = taskrepository;
    }
//cretate method for each like toggle , delete
    public List<task> getAllTask() {
        return taskrepository.findAll();
    }

    public void createTask(String title) {
        task t =new task();
        t.setTitle(title);
        t.setCompleted(false);
        taskrepository.save(t);
    }

    public void deleteTask(Long id) {
        taskrepository.deleteById(id);
    }

    public void toggleTask(Long id) {
        task t = taskrepository.findById(id).
                orElseThrow(() -> new IllegalArgumentException("Task not found"));
                t.setCompleted(!t.isCompleted());
        taskrepository.save(t);
    }
}
