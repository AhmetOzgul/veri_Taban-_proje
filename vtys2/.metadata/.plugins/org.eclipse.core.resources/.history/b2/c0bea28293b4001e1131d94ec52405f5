package com.example.vtys.controller;

import java.security.Timestamp;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.vtys.entity.Project;
import com.example.vtys.entity.Task;
import com.example.vtys.entity.User;
import com.example.vtys.service.ProjectService;
import com.example.vtys.service.TaskService;
import com.example.vtys.service.UserService;



@Controller
@RequestMapping("/tasks")
public class TaskController {

    private TaskService TaskService;
    private ProjectService projectService;
    private UserService userService;

    public TaskController(TaskService TaskService, ProjectService projectService, UserService userService) {
        super();
        this.TaskService = TaskService;
        this.projectService = projectService;
        this.userService = userService;
    }

    @GetMapping
    public String listTasks(Model model) {
        model.addAttribute("tasks", TaskService.getAllTasks());
        return "tasks";
    }

    @GetMapping("/add")
    public String addTaskForm(Model model){
        Task Task = new Task();
        List<Project> projects = projectService.getAllProjects();
        List<User> users = userService.getAllUsers();
        
        model.addAttribute("project", projects);
        model.addAttribute("user", users);
        model.addAttribute("task", Task);
        return "create_task";
    }

    @PostMapping("/add")
    public String saveTask(@ModelAttribute("task") Task Task){
        TaskService.saveTask(Task);
        return "redirect:/tasks";
    }
    
    @GetMapping("/edit/{id}")
    public String editTaskForm(@PathVariable Long id, Model model){
        List<Project> projects = projectService.getAllProjects();
        List<User> users = userService.getAllUsers();
        
        model.addAttribute("project", projects);
        model.addAttribute("user", users);
        model.addAttribute("task", TaskService.getTaskById(id));
        return "edit_task";
    }

    @PostMapping("/edit/{id}")
    public String editTask(@PathVariable Long id, @ModelAttribute Task Task) {
        TaskService.updateTask(id, Task);
        return "redirect:/tasks";
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        TaskService.deleteTask(id);
        return "redirect:/tasks";
    }
}
