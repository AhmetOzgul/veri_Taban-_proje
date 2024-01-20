package com.example.vtys.repository;

import com.example.vtys.entity.Task;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long>{

    List<Task> findByProjectId(Long projectId);
    
}
