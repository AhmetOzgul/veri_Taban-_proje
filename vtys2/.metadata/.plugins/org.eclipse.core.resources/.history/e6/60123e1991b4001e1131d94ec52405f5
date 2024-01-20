package com.example.vtys.controller;

import java.security.Timestamp;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

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



@Controller
@RequestMapping("/projects")
public class ProjectController {

    private ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        super();
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
            return "project-detail"; // Bu, Thymeleaf şablon sayfasının adını temsil eder (project-details.html)
        } else {
            // Projeyi bulamazsa hata sayfasına yönlendirilebilir.
            return "error";
        }
    }

}
