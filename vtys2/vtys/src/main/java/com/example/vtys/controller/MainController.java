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
import com.example.vtys.service.ProjectService;
import com.example.vtys.service.TaskService;


@Controller
@RequestMapping("/projects")
public class MainController {
  public String index() {
    return "projects";
  }
  
  private TaskService taskService;
	private ProjectService projectService;


  public MainController(TaskService taskService, ProjectService projectService) {
		super();
		this.taskService = taskService;
		this.projectService = projectService;
	}




  @GetMapping
  public String listprojects(Model model) {
      model.addAttribute("projects", projectService.getAllProjects());
      return "projects";
  }

  @GetMapping("/add")
  public String addprojectForm(Model model){
      Project project = new Project();
      model.addAttribute("project", project);
      return "create_project";
  }


  @PostMapping("/add")
  public String saveproject(@ModelAttribute("project") Project project){
      projectService.saveProject(project);
      return "redirect:/projects";
  }
  
  @GetMapping("/edit/{id}")
  public String editprojectForm(@PathVariable Long id, Model model){
      model.addAttribute("project", projectService.getProjectById(id));
      return "edit_project";
  }

  @PostMapping("/edit/{id}")
  public String editproject(@PathVariable Long id, @ModelAttribute Project project) {
      projectService.updateProject(id, project);
      return "redirect:/projects";
  }

  @GetMapping("/delete/{id}")
  public String deleteProject(@PathVariable Long id) {
      projectService.deleteProject(id);
      return "redirect:/projects";
  }

  @GetMapping("/{id}")
public String showProjectDetails(@PathVariable Long id, Model model) {
    Project project = projectService.getProjectById(id);

    if (project != null) {
        model.addAttribute("project", project);
        // Get tasks related to the project
        List<Task> tasks = taskService.getTasksByProjectId(id);

        // Calculate remaining days for each task
        for (Task task : tasks) {
            int remainingDays = (int) calculateRemainingDays(task.getEndDate());
            task.setRemainingDays(remainingDays);
        }

        model.addAttribute("tasks", tasks);

        return "project-detail"; // Thymeleaf template name
    } else {
        // Project not found, redirect to error page
        return "error";
    }
}
  private long calculateRemainingDays(Date endDate) {
    	
        LocalDate currentDate = LocalDate.now();
        LocalDate endLocalDate = endDate.toLocalDate();
        // Hesaplanan kalan gün sayısı
        long remainingDays = ChronoUnit.DAYS.between(currentDate, endLocalDate);

        if (remainingDays < 0 ){
            return 0;
        }

        return remainingDays;

    }
}
