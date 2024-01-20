package com.example.vtys.service;
import java.util.List;

import com.example.vtys.entity.Project;

public interface ProjectService {
    List<Project> getAllProjects();
	
	Project saveProject(Project Project);
	
	Project getProjectById(Long id);
	
	void updateProject(Long id,Project Project);
	
	void deleteProject(Long id);
}
