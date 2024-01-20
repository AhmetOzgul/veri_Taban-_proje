package com.example.vtys.repository;

import com.example.vtys.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long>{
    
}
