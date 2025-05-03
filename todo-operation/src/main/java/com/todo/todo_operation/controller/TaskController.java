package com.todo.todo_operation.controller;

import com.todo.todo_operation.models.task;
import com.todo.todo_operation.services.TaskServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@RequestMapping("/tasks")
public class TaskController {
    private final TaskServices taskservices;

    public TaskController(TaskServices taskservices) {
        this.taskservices = taskservices;
    }

    @GetMapping
    public String getTasks(Model model){
        List<task> tasks = taskservices.getAllTask();
        model.addAttribute("tasks",tasks);
        return "tasks";
    }

    @PostMapping
    public String createTasks(@RequestParam String title){
        taskservices.createTask(title);
        return "redirect:/";
    }

    @GetMapping("/{id}/delete")
    public String deleteTasks(@PathVariable Long id){
        taskservices.deleteTask(id);
        return "redirect:/";
    }

    @GetMapping("/{id}/toggle")
    public String toggleTasks(@PathVariable Long id){
        taskservices.toggleTask(id);
        return "redirect:/";
    }
}
