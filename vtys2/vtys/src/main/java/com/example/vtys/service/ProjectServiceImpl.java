package com.example.vtys.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.vtys.entity.Project;
import com.example.vtys.repository.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService {

    private ProjectRepository ProjectRepository;

    public ProjectServiceImpl(ProjectRepository ProjectRepository){
        super();
        this.ProjectRepository = ProjectRepository;
    }

    @Override
    public List<Project> getAllProjects() {
        return ProjectRepository.findAll();
    }

    @Override
    public Project saveProject(Project Project) {
        return ProjectRepository.save(Project);
    }

    @Override
    public Project getProjectById(Long id) {
        return ProjectRepository.findById(id).get();
    }

    @Override
    public void updateProject(Long id,Project Project) {
        if(ProjectRepository.existsById(id)){
            Project.setId(id);
            ProjectRepository.save(Project);
        }

    }

    @Override
    public void deleteProject(Long id){
        ProjectRepository.deleteById(id);
    }
    
}
