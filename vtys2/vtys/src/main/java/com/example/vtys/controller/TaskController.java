package com.example.vtys.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.vtys.entity.Project;
import com.example.vtys.entity.Task;
import com.example.vtys.entity.User;
import com.example.vtys.service.ProjectService;
import com.example.vtys.service.TaskService;
import com.example.vtys.service.UserService;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    private TaskService taskService;
    private ProjectService projectService;
    private UserService userService;

    public TaskController(TaskService taskService, ProjectService projectService, UserService userService) {
        this.taskService = taskService;
        this.projectService = projectService;
        this.userService = userService;
    }

    @GetMapping
    public String listTasks(Model model) {
        model.addAttribute("tasks", taskService.getAllTasks());
        List<Task> tasks = taskService.getAllTasks();

        // Calculate remaining days for each task
        for (Task task : tasks) {
            int remainingDays = (int) calculateRemainingDays(task.getEndDate());
            task.setRemainingDays(remainingDays);
        }
        return "tasks";
    }

    @GetMapping("/add")
    public String addTaskForm(Model model) {
        Task task = new Task();
        List<Project> projects = projectService.getAllProjects();
        List<User> users = userService.getAllUsers();

        model.addAttribute("project", projects);
        model.addAttribute("user", users);
        model.addAttribute("task", task);
        return "create_task";
    }

    @PostMapping("/add")
    public String saveTask(@ModelAttribute("task") Task task) {
        taskService.saveTask(task);
        return "redirect:/tasks";
    }

    @GetMapping("/edit/{id}")
    public String editTaskForm(@PathVariable Long id, Model model) {
        List<Project> projects = projectService.getAllProjects();
        List<User> users = userService.getAllUsers();

        model.addAttribute("project", projects);
        model.addAttribute("user", users);
        model.addAttribute("task", taskService.getTaskById(id));
        return "edit_task";
    }

    @PostMapping("/edit/{id}")
    public String editTask(@PathVariable Long id, @ModelAttribute Task task) {
        taskService.updateTask(id, task);
        return "redirect:/tasks";
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "redirect:/tasks";
    }
    
    @GetMapping("/remaining-days/{id}")
    public String getRemainingDays(@PathVariable Long id, Model model) {
        Task task = taskService.getTaskById(id);

        // Hesaplanan kalan gün sayısı
        int remainingDays = (int) calculateRemainingDays(task.getEndDate());

        // Task nesnesine remaining değerini set et
        task.setRemainingDays(remainingDays);

        model.addAttribute("task", task);
        model.addAttribute("remainingDays", remainingDays);
        return "remainingDays";
    }


    // kalan günleri hesapla
    private long calculateRemainingDays(Date endDate) {
    	
        LocalDate currentDate = LocalDate.now();
        LocalDate endLocalDate = endDate.toLocalDate();
        // Hesaplanan kalan gün sayısı
        long remainingDays = ChronoUnit.DAYS.between(currentDate, endLocalDate);

        if(remainingDays < 0){
            return 0;
        }

        return remainingDays;

    }

}
